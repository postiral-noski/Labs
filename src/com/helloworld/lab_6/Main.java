package OOP.Lab6;
public class Main {
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
}
