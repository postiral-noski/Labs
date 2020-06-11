package lab_5;

public class Word {
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
