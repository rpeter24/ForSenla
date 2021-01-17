package com.company;

import java.util.ArrayList;

public class Main6 {

    /*
    Имеется набор вещей, которые необходимо поместить в рюкзак.
    Рюкзак обладает заданной грузоподъемностью.
    Вещи в свою очередь обладают двумя параметрами — весом и стоимостью.
    Цель задачи заполнить рюкзак не превысив его грузоподъемность и максимизировать суммарную ценность груза.
     */

    public static void main(String[] args) {
        // write your code here
        int maxWeight = 100; //максимальный вес
        int cost = 0; //счетчик стоимости

        ArrayList<Integer> quant1 = new ArrayList<>(); //массивы с количеством каждого предмета для каждого варианта
        ArrayList<Integer> quant2 = new ArrayList<>();
        ArrayList<Integer> quant3 = new ArrayList<>();
        ArrayList<Integer> quant4 = new ArrayList<>();
        ArrayList<Integer> quant5 = new ArrayList<>();

        int[] costItems = new int[5]; //массив стоимости каждого предмета
        int[] weight = new int[5]; //массив веса каждого предмета

        costItems[0] = 100; //стоимость каждого предмета
        costItems[1] = 200;
        costItems[2] = 300;
        costItems[3] = 1000;
        costItems[4] = 500;

        weight[0] = 2; //масса каждого предмета
        weight[1] = 5;
        weight[2] = 3;
        weight[3] = 7;
        weight[4] = 12;

        for (int i = 0; i < 5; i++) { //сортируем предметы по весу по убыванию
            for (int j = i; j < 5; j++) {
                if (weight[i] < weight[j]) {
                    int tempC = costItems[i];
                    int tempW = weight[i];
                    costItems[i] = costItems[j];
                    weight[i] = weight[j];
                    costItems[j] = tempC;
                    weight[j] = tempW;
                }
            }
        }

//для перебора перебираем сначала количество самого тяжелого предмета, далее перебираем следующие по массе предметы
        for (int i1 = maxWeight/weight[0]; i1>=0; i1--) {
            for (int i2 = (maxWeight-i1)/weight[1]; i2>=0; i2--) {
                for (int i3 = (maxWeight-i1-i2)/weight[2]; i3>=0; i3--) {
                    for (int i4 = (maxWeight-i1-i2-i3)/weight[3]; i4>=0; i4--) {
                        for (int i5 = (maxWeight - i1-i2-i3-i4)/weight[4]; i5>=0; i5--) {
                            int totalCost = i1 * costItems[0] + i2 * costItems[1] + i3 * costItems[2] + i4 * costItems[3] + i5 * costItems[4];
                            if (cost < totalCost) { //если полученная общая стоимость больше максимальной суммы
                                cost = totalCost; //заменяем максимальную сумму на полученную
                                quant1.clear(); //очищаем массивы от ранее найденных значений
                                quant2.clear();
                                quant3.clear();
                                quant4.clear();
                                quant5.clear();
                                quant1.add(i1); //заполняем каждый массив количеством каждого предмета для получения полученной общей стоимости
                                quant2.add(i2);
                                quant3.add(i3);
                                quant4.add(i4);
                                quant5.add(i5);
                            }
                            if (cost == totalCost) { //если рассчитанная общая стоимость равна максимальной
                                boolean flag = true; //объявляем логический флаг для проверки дубликатов
                                for (int i = 0; i < quant1.size(); i++) {
                                    if ((quant1.get(i) == i1) && (quant2.get(i) == i2) && (quant3.get(i) == i3) && (quant4.get(i) == i4) && (quant5.get(i) == i5))
                                        flag = false; // если найденные количества предметов повторяют ранее найденные, флаг меняет значение
                                }
                                if (flag) { //если найденные количества уникальны, добавляем в массивы
                                    quant1.add(i1);
                                    quant2.add(i2);
                                    quant3.add(i3);
                                    quant4.add(i4);
                                    quant5.add(i5);
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println("Для переноса вещей на сумму" + cost + " необходимо:");

        for (int i = 0; i < quant1.size(); i++) {
            System.out.println("Вещей массой " + weight[0] + ", ценой " + costItems[0] + " необходимо " + quant1.get(i));
            System.out.println("Вещей массой " + weight[1] + ", ценой " + costItems[1] + " необходимо " + quant2.get(i));
            System.out.println("Вещей массой " + weight[2] + ", ценой " + costItems[2] + " необходимо " + quant3.get(i));
            System.out.println("Вещей массой " + weight[3] + ", ценой " + costItems[3] + " необходимо " + quant4.get(i));
            System.out.println("Вещей массой " + weight[4] + ", ценой " + costItems[4] + " необходимо " + quant5.get(i));
            if (quant1.size()>1)
                if (i != quant1.size()-1) {
                    System.out.println("или");
                }
        }

    }
}
