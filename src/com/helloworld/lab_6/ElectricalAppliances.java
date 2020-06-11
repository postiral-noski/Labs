package OOP.Lab6;

import java.util.Arrays;
import java.util.Comparator;

// Создаем компаратор, который будет использоваться в методе Array.sort() для сортировки массива
class Power implements Comparator<ElectricalAppliances> {
    @Override
    public int compare(ElectricalAppliances o1, ElectricalAppliances o2) {
        return o1.getPower() - o2.getPower();
    }
}

public class ElectricalAppliances {
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
