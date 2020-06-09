package com.helloworld;
import java.util.Arrays;
import java.util.Comparator;
public class Lab_6 {
    public static void main(String[] args) {
        //Создаем объекты приборов (они все наследуют от класса ElectricalAppliances)
        Kettle kettle = new Kettle(1000, 10, "Чайник");
        Multivariate multivariate = new Multivariate(2500, 30, "Мультиварка");
        ElectricStove electricStove = new ElectricStove(6000, 50, "Электроплита");
        MicrowaveOven microwaveOven = new MicrowaveOven(4000, 70, "Микроволновка");

        // Создаем два массива. В одном массиве все приборы, а во втором только те, которые включены в розетку
        ElectricalAppliances[] allAppliances = {kettle, multivariate, electricStove, microwaveOven};
        ElectricalAppliances[] someAppliances = {kettle, electricStove, microwaveOven};

        // Выводим сумму мощности тех приборов, которые включены в розетку
        System.out.println("Итоговая мощность включеных приборов в розетку: " + ElectricalAppliances.sumByPower(someAppliances));

        // Сортируем массив всех приборов по мощности
        ElectricalAppliances.sortByPower(allAppliances);
        System.out.println("Отсортированый массив по мощности:");
        for (ElectricalAppliances x : allAppliances) {
            System.out.printf("%13s : %4d\n", x.getName(), x.getPower());
        }
        // Находим приборы, которые удовлетворяют указаному диапазону ЭМИ
        System.out.println("Приборы, которые удовлетворяют указаному диапазану ЭМИ: ");
        ElectricalAppliances.rangeRadiation(20, 50, allAppliances);
    }


    // Создаем компаратор, который будет использоваться в методе Array.sort() для сортировки массива
    public static class Power implements Comparator<ElectricalAppliances> {
        @Override
        public int compare(ElectricalAppliances o1, ElectricalAppliances o2) {
            return o1.getPower() - o2.getPower();
        }
    }

    public static class ElectricalAppliances {
        private int power;
        private int radiation;
        private String name;

        // Создаем конструктор класса
        ElectricalAppliances(int p, int r, String n) {
            power = p;
            radiation = r;
            name = n;
        }

        // Создаем методы при помощи которых мы имеем доступ к полям power и name
        public int getPower() {
            return power;
        }

        public String getName() {
            return name;
        }

        // Создаем метод, который суммирует мощность приборов подключенных к питанию
        public static int sumByPower(ElectricalAppliances[] m) {
            int sumPower = 0;
            for (ElectricalAppliances x : m) {
                sumPower += x.power;
            }
            return sumPower;
        }

        // Метод для сортировки объектов
        public static void sortByPower(ElectricalAppliances[] m) {
            Arrays.sort(m, new Power());
        }

        // Метод, который выводит имена объектов, которые удовлетворяют заданому диапазону
        public static void rangeRadiation(int a, int b, ElectricalAppliances[] args) {
            for (ElectricalAppliances x : args) {
                if (x.radiation >= a && x.radiation <= b) {
                    System.out.printf("%13s : %3d\n", x.name, x.radiation);
                }
            }

        }

    }
    public static class ElectricStove extends  ElectricalAppliances{
        ElectricStove(int p, int r, String n) {
            super(p, r, n);
        }
    }
    public static class Kettle extends ElectricalAppliances {
        Kettle(int p, int r, String n) {
            super(p, r, n);
        }
    }
    public static class MicrowaveOven extends ElectricalAppliances {
        MicrowaveOven(int p, int r, String n) {
            super(p, r, n);
        }
    }
    public static class Multivariate extends ElectricalAppliances {
        Multivariate(int p, int r, String n) {
            super(p, r, n);
        }
    }

}
