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
        System.out.println("����� ���������� �����. ");

        //�������� �����, ������� �� ���� ��������� �������� ���, ���������� ������ ���������� ����� � ���� ���������.
        // ����������: ��� ���������� ���� �� ������� �� 4 , ��� ���� ���� ������� �� 100 �� ������ �������� � �� 400
        System.out.println("���������� �������� ���");
        System.out.println("������� ��� ������ ���������: ");
        int startYear = scanner.nextInt();
        System.out.println("������� ��������� ��� ���������: ");
        int endYear = scanner.nextInt();

        List<Integer> myLeapYears = returnLeapYear(startYear, endYear);
        System.out.println(myLeapYears);

        System.out.println();
        System.out.println("������� ���������� ��������� �������: ");
        int salaryNumbers = scanner.nextInt();
        List<Double> mySalaries = salaries(salaryNumbers);

        System.out.println("������ ������������ �����,\n" +
                "        ��������� �� ��������� �������, �������������� �� ������ ����������� �������������:");
        System.out.println("(�������� ������ ���� ����� 0 ... ��� �� ��������... ����� ������������� ��������.  )");
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
        2.	�������� �����, ������� �� ���� ��������� ����� �����(���������� �������) � ���������� ������ ������������ �����,
        ��������� �� ��������� �������, �������������� �� ������ ����������� �������������.
        ����������: � ����������� ������������� ���� ��� ���������: mean(������� ��������)  � std(������� ����������).
        � ������ Random ���� ����� nextGaussian(), ������� ���������� ��������� �������������� ����� � ����������� mean=0, std=1.
        ��� ��������� ������� ���������� ���������: std = 11190, mean = 29267(������ ����������� ����).
        ����������� ����� ������� ���������: ��������� �������� = nextGaussian() * std + mean.
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