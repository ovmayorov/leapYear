import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Поиск високосных годов. ");

        //Напишите метод, который на вход принимает диапазон лет, возвращает список високосных годов в этом диапазоне.
        // Примечание: год високосный если он делится на 4 , при этом если делится на 100 то должен делиться и на 400
        System.out.println("Определите диапазон лет");
        System.out.println("Введите год начала диапазона: ");
        int startYear = scanner.nextInt();
        System.out.println("Введите последний год диапазона: ");
        int endYear = scanner.nextInt();

        List<Integer> myLeapYears = returnLeapYear(startYear, endYear);
        System.out.println(myLeapYears);



    }

    public static List<Integer> returnLeapYear (int startYear, int endYear){
        List<Integer> yearRange = new ArrayList<>();
        for(int i=startYear; i<=endYear; i++ ){
            yearRange.add(i);
        }

        List<Integer> leapYearRange = yearRange.stream()
                .filter(n -> (  n%400 == 0 || (n%4==0 && n%100!=0)  ) )
                .toList();

        return leapYearRange;
    }

}