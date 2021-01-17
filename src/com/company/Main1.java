package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    /*Создать программу, которая будет сообщать, является ли целое число, введенное пользователем,
    чётным или нечётным, простым или составным.  Если пользователь введёт не целое число,
    то сообщать ему об ошибке.*/

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sNum = reader.readLine();
        int num = 0; //объявляем целочисленную переменную
        try {
            num = Integer.parseInt(sNum);//пробуем перевести текст в целое число
        }
        catch (NumberFormatException e) {
            System.out.println("Введено не целое число");
            System.exit(0);           //закрываем программу
        }

        if (num < 2) {
            if (num % 2 == 1)
                System.out.println("Нечетное число. Не является ни простым, ни составным числом");
            else
                System.out.println("Четное число. Не является ни простым, ни составным числом");
        }
        else {
            if (num % 2 == 1)
                checkNum(num); //проверка нечетных чисел больше 1 на простое или составное
            else {
                if (num == 2)
                    System.out.println("Простое четное число"); //введено число 2
                else
                    System.out.println("Составное четное число");//введено четное число больше 2
            }
        }
    }

    private static void checkNum (int num) { //поиск количества делителей перебором
        int n = (int) Math.sqrt(num);//находим целую часть квадратного корня для нахождения верхней границы перебора делителей
        int numDiv = 0;//счетчик делителей
        for (int i=1; i<=n; i++){ //делитель 1 всегда прибавит к счетчику 1. Т.к. в качестве делителя не рассматривается само число, если число простое, счетчик будет 1, если составное - больше 1
            if (num % i == 0)
                numDiv++;
        }
        if (numDiv > 1)
            System.out.println("Составное нечетное число");
        else
            System.out.println("Простое нечетное число");
    }

}
