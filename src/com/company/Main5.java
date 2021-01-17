package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main5 {

    /*
    Создать программу, которая в последовательности от 0 до N, находит все числа-палиндромы
    (зеркальное значение равно оригинальному).
    Длина последовательности N вводится вручную и не должна превышать 100.
     */

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sN = reader.readLine();
        int n = 0;
        try {
            n = Integer.parseInt(sN);
        }
        catch (NumberFormatException e) {
            System.out.println("Введите целое число!");
            System.exit(0);
        }

        if (n<0) { //проверяем, что число больше или равно 0
            System.out.println("Введите число больше 0");
            System.exit(0);
        }
        if (n>100) { //проверяем, что число меньше или равно 100
            System.out.println("Введите число до 100");
            System.exit(0);
        }

        for (int i = 0; i<=n; i++) {
            switch (i) {
                case 0: System.out.println(i);
                    break;
                case 1: System.out.println(i);
                    break;
                case 2: System.out.println(i);
                    break;
                case 3: System.out.println(i);
                    break;
                case 4: System.out.println(i);
                    break;
                case 5: System.out.println(i);
                    break;
                case 6: System.out.println(i);
                    break;
                case 7: System.out.println(i);
                    break;
                case 8: System.out.println(i);
                    break;
                case 9: System.out.println(i);
                    break;
                case 11: System.out.println(i);
                    break;
                case 22: System.out.println(i);
                    break;
                case 33: System.out.println(i);
                    break;
                case 44: System.out.println(i);
                    break;
                case 55: System.out.println(i);
                    break;
                case 66: System.out.println(i);
                    break;
                case 77: System.out.println(i);
                    break;
                case 88: System.out.println(i);
                    break;
                case 99: System.out.println(i);
                    break;
                default:
                    break;
            }
        }
    }
}
