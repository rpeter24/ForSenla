package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3 {

    /*
    Создать программу, которая будет:
    подсчитывать количество слов в предложении
    выводить их в отсортированном виде
    делать первую букву каждого слова заглавной.
    Предложение вводится вручную. (Разделитель пробел (“ ”)).
     */
    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();

        char[] chars = string.toCharArray(); //переводим введенную строку в символьный массив
        int numWord = 0; //счетчик числа слов в введенной строке
        if (chars[0] != ' ') //проверяем первый символ: если не пробел - считаем первым словом
            numWord++;
        for (int i = 1; i < chars.length; i++) { //считаем количество слов
            if (chars[i] != ' ' && chars[i-1] == ' ')
                numWord++;
        }
        String[] array = new String[numWord]; //заполняем созданный массив слов пустыми строками, чтобы не было "null"
        for (int i = 0; i < numWord; i++) {
        array[i] = "";
        }

        int j = 0;
        if (chars[0] != ' ') { //проверяем первый символ введенной строки. Если не пробел, заполняем символом первое слово массива
            String lit = "" + chars[0];
            array[0] = array[0] + lit.toUpperCase();
        }
        for (int i = 1; i < chars.length; i++) { //распределяем слова из строки в массив слов
            if (chars[i] != ' ') {
                if (chars[i-1] == ' ') { //если предыдущий символ пробел, делаем букву заглавной
                    String lit = "" + chars[i];
                    array[j] = array[j] + lit.toUpperCase();
                }
                else
                array[j] = array[j] + chars[i];
            }
            else
                if (chars[i-1] != ' ')
                    j++;
        }

        sort(array); //вызываем сортировку слов

        System.out.println("Количество слов: " + numWord); // выводим количество слов
        for (int i = 0; i < numWord; i++) //Выводим отсортированные слова из введенной строки
            System.out.println(array[i]);
    }

    public static void sort(String[] array) { //сортировка слов по алфавиту
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i].compareTo(array[j]) > 0) {
                    String temp = array[i];
                    array [i] = array [j];
                    array [j] = temp;
                }
            }
        }
    }
}
