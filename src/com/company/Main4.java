package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main4 {

    /*Создать программу, которая подсчитывает сколько раз употребляется слово в тексте (без учета регистра).
    Текст и слово вводится вручную.
    */

    public static void main(String[] args) throws IOException {
	// write your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите предложение");
        String text = reader.readLine();
        System.out.println("Введите слово");
        String word = reader.readLine();
        text = text.toLowerCase(); //убираем верхний регистр
        word = word.toLowerCase();

        char[] cText = text.toCharArray();
        char[] cWord = word.toCharArray();

        int n = 0; //счетчик

        for (int i = 0; i < cText.length; i++) {
            if (cText[i] == cWord[0]) {
                int num = 0;
                for (int j = 0; j <cWord.length; j++) {
                    if (i+j >= cText.length) //если проверка текста выходит за его длину, проверка прерывается
                        break;
                    if (cText[i+j] == cWord[j]) //часть текста и слово посимвольно сравниваются друг с другом. Если они совпадут, счетчик достигнет значения длины слова
                        num++;
                }
                if (num == cWord.length)
                    n++;
            }

        }

        System.out.println("Количество повторений слова " + word + " в тексте: " + n);

    }
}
