package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {

    /*Создать программу, которая будет вычислять и выводить на экран НОК (наименьшее общее кратное)
    и НОД (наибольший общий делитель) двух целых чисел, введенных пользователем.
    Если пользователь некорректно введёт хотя бы одно из чисел, то сообщать об ошибке.*/
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите первое целое число");
        String sA = reader.readLine();
        System.out.println("Введите второе целое число");
        String sB = reader.readLine();
        int a = 0; //объявляем первое число
        int b = 0; //объявляем второе число
        try {
            a = Integer.parseInt(sA);
            b = Integer.parseInt(sB);
        }
        catch (NumberFormatException e) {
            System.out.println("Введены не целые числа");
            System.exit(0); //закрываем программу, если введено не целое цисло
        }

        if (a != 0 && b != 0) {
            int GCD; // объявление переменной наибольшего общего кратного
            int LCM; //объявление переменной наименьшего общего кратного
            GCD = checkGCD(Math.abs(a), Math.abs(b));
            LCM = Math.abs(a*b) / GCD;
            System.out.println("Наибольший общий делитель: " + GCD + ", наименьшее общее кратное: " + LCM);
        }
        else {
            if (a == 0 && b == 0) {
                System.out.println("Наибольшего общего делителя и наименьшего общего кратного нет");
            }
            else {
                if (a == 0)
                    System.out.println("Наибольший общий делитель: " + Math.abs(b) + ", наименьшего общего кратного нет");
                else
                    System.out.println("Наибольший общий делитель: " + Math.abs(a) + ", наименьшего общего кратного нет");
            }
        }

    }

    private static int checkGCD (int a, int b) { //если a < b, после первой итерации остатком от деления a на b будет число a. Т.е. a и b поменяются местами
        if (b==0) return a;
        return checkGCD(b,a%b);
    }
}
