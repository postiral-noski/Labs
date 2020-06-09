package com.helloworld;

public class Lab_5 {
    public static void main(String[] args) {
        String str = ("Первое предложение с такими словами: абрикос, ананас, арбуз. Второе предложение (тоже со словами): " +
                "первое ананас, вишня! " +
                "Это предложение без пунктуационных знаков.");
        TextL5 text = new TextL5(str.toLowerCase());
        text.findWords();
    }
    public static class Letter {
        private char letter;

        public Letter(char letter) {
            this.letter = letter;
        }

        public char getLetter() {
            return letter;
        }

        public void setLetter(char letter) {
            this.letter = letter;
        }
    }

    public static class Sentence {
        private Word[] words;

        public Sentence(Word[] words) {
            this.words = words;
        }

        public Word[] getWords() {
            return words;
        }

        @Override
        public String toString() {
            String sentences = "";
            for(Word word : words){
                sentences += word.toString() + " ";
            }
            return sentences;
        }
    }

    public static class TextL5 {
        private Sentence[] sentences;
        private String string;

        public TextL5(String string) {
            this.string = string;
            convertToSentences();
        }

        public Sentence[] getSentences() {
            return sentences;
        }

        public void setSentences(Sentence[] sentences) {
            this.sentences = sentences;

        }
        /*
        Создаем метод, который разбивает наш текст (строку) на предложения, предложения на слова, а слова на буквы.
         */
        private void convertToSentences(){
            String[] allSentences = string.split("[.!?]");
            sentences = new Sentence[allSentences.length];
            int sentencesIndex = 0;
            for(String string : allSentences){
                String[] allWords = string.split("[ ,:)(]");
                Word[] words = new Word[allWords.length];
                int wordsIndex = 0;
                for(String word : allWords){
                    Letter[] letters = new Letter[word.length()];
                    int lettersIndex = 0;
                    for(char letter : word.toCharArray()){
                        letters[lettersIndex] = new Letter(letter);
                        lettersIndex++;
                    }
                    words[wordsIndex] = new Word(letters);
                    wordsIndex++;
                }
                sentences[sentencesIndex] = new Sentence(words);
                sentencesIndex++;
            }
        }
        /*
        Метод для вывода предложений нашего текста.
         */
        public void printSentences(){
            for(Sentence sentence : sentences){
                System.out.println(sentence.toString());
            }
        }
        /*
        Метод для поиска слов с первого предложения, которых нет в остальных.
         */
        public void findWords() {
            if (sentences.length != 0) {
                System.out.println("Слова с первого предложения, которых нет в остальных:");
                for (Word word : sentences[0].getWords()) {
                    boolean flag = false;
                    for (int i = 1; i < sentences.length; i++) {
                        for (Word word1 : sentences[i].getWords()) {
                            if (word.toString().equals(word1.toString())) {
                                flag = true;
                                break;
                            }
                        }
                    }
                    if (!flag) {
                        System.out.println(word.toString());
                    }
                }
            }else{
                System.out.println("Ваша строка пуста!");
            }
        }
    }

    public static class Word {
        private Letter[] letters;

        public Word(Letter[] letters){
            this.letters = letters;
        }

        public Letter[] getLetters() {
            return letters;
        }

        public void setLetters(Letter[] letters) {
            this.letters = letters;
        }

        @Override
        public String toString() {
            String res = "";
            for(Letter letter : letters){
                res += letter.getLetter();
            }
            return res;
        }
    }

}
