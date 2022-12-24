import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ѕоиск високосных годов. ");

        //Ќапишите метод, который на вход принимает диапазон лет, возвращает список високосных годов в этом диапазоне.
        // ѕримечание: год високосный если он делитс€ на 4 , при этом если делитс€ на 100 то должен делитьс€ и на 400
        System.out.println("ќпределите диапазон лет");
        System.out.println("¬ведите год начала диапазона: ");
        int startYear = scanner.nextInt();
        System.out.println("¬ведите последний год диапазона: ");
        int endYear = scanner.nextInt();

        List<Integer> myLeapYears = returnLeapYear(startYear, endYear);
        System.out.println(myLeapYears);

        System.out.println();
        System.out.println("¬ведите количество требуемых зарплат: ");
        int salaryNumbers = scanner.nextInt();
        List<Double> mySalaries = salaries(salaryNumbers);

        System.out.println("—писок вещественных чисел,\n" +
                "        состо€щих из случайных зарплат, распределенных по закону нормального распределени€:");
        System.out.println("(«арплата больше либо равна 0 ... Ёто же зарплата... убрал отрицательные зарплаты.  )");
        System.out.println(mySalaries);





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

    /*
        2.	Ќапишите метод, который на вход принимает целое число(количество зарплат) и возвращает список вещественных чисел,
        состо€щих из случайных зарплат, распределенных по закону нормального распределени€.
        ѕримечание: ” нормального распределени€ есть два параметра: mean(среднее значение)  и std(среднее отклонение).
        ” класса Random есть метод nextGaussian(), который генерирует нормально распределенное число с параметрами mean=0, std=1.
        ƒл€ генерации зарплат попробуйте параметры: std = 11190, mean = 29267(можете поподбирать свои).
        »спользуйте такую формулу генерации: случайна€ зарплата = nextGaussian() * std + mean.
         */
    public static List<Double> salaries (int salaryNumbers){
        Random randomNumber = new Random();
        List<Double> mySalaries = DoubleStream.generate(() -> randomNumber.nextGaussian(11190, 29267))
                .filter(n -> n>=0)
                .limit(salaryNumbers)
                .boxed()
                .toList();

        return mySalaries;
    }

}