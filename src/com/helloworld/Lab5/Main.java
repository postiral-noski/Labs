package lab_5;

public class Main {
    public static void main(String[] args) {
        String str = ("Первое предложение с такими словами: абрикос, ананас, арбуз. Второе предложение (тоже со словами): " +
                "первое ананас, вишня! " +
                "Это предложение без пунктуационных знаков.");
        TextL5 text = new TextL5(str.toLowerCase());
        text.findWords();
    }
}
