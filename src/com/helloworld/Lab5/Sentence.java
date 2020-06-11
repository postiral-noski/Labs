package lab_5;

public class Sentence {
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
