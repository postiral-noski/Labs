package OOP.Lab7_8;


import java.util.Iterator;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) {
        MyAppliancesList appliances = new MyAppliancesList();
        System.out.println("Начальная длина списка: " + appliances.size());
        ElectricalAppliances appliance1 = null;
        ElectricalAppliances appliance2 = null;
        ElectricalAppliances appliance3 = null;
        ElectricalAppliances appliance4 = null;
        ElectricalAppliances appliance5 = null;
        try{
            System.out.println("Проверка на наличие объекта \"Сковородка\" в пустом списке: " + appliances.contains(new ElectricalAppliances(10, "Сковородка")));
            appliance1 = new ElectricalAppliances(10, "Печка");
            appliance2 = new ElectricalAppliances(10, "Плита");
            appliance3 = new ElectricalAppliances(12, "Чайник");
            appliance4 = new ElectricalAppliances(20, "Утюг");
            appliance5 = new ElectricalAppliances(30, "Микроволновка");
        } catch (MyException e){
            System.out.println("Параметр мощность меньше 0");
        }
        System.out.println("Добавление объекта \"Печка\": " + appliances.add(appliance1));
        System.out.println("Добавление объекта \"Плита\": " + appliances.add(appliance2));
        System.out.println("Добавление объекта \"Чайник\": " + appliances.add(appliance3));
        System.out.println("Повторное добавление объекта \"Плита\": " + appliances.add(appliance2));
        System.out.println("Добавление объекта \"Утюг\": " + appliances.add(appliance4));

        System.out.println("Проверка на наличие объекта \"Печка\": " + appliances.contains(appliance1));
        System.out.println("Длина списка после добавления: " + appliances.size() + " элементов: " + appliances.size());
        System.out.println("Список: " + appliances);

        for (ElectricalAppliances x: appliances) {
            System.out.println(x);
        }
//        Iterator iter = appliances.iterator();
//        System.out.println(iter.next());
//        System.out.println(iter.next());
        System.out.println("Проверка листитератора");
        ListIterator listIter = appliances.listIterator();
        System.out.println(listIter.next());
        System.out.println(listIter.next());
        System.out.println(listIter.next());
        System.out.println(listIter.previous());
        System.out.println(listIter.previous());

        listIter.set(appliance5);

        System.out.println(appliances);


        System.out.println("Удаление объекта " + appliance3.getName() + " прошло успешно? :" + appliances.remove(appliance3));
        System.out.println("Список: " + appliances);
        System.out.println("Удаление объекта " + appliance3.getName() + " прошло успешно? :" + appliances.remove(appliance3));

        System.out.println("Индекс объекта \"Плита\" : " + appliances.indexOf(appliance2));
        System.out.println("Имя объекта за индексом 1: " + appliances.get(1));
        appliances.clear();
        System.out.println("Длина списка после полного очищения: " + appliances.size());
        System.out.println("Сам список: " + appliances);

    }
}
