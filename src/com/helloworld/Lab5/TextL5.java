package lab_5;


class TextL5 {
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
