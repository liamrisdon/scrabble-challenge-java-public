public class Scrabble {

    String word;

    public Scrabble(String newWord) {

        this.word = newWord;
    }
    public int score() {

        if(this.word == null || this.word.equals("")) {
            return 0;
        }

        return 1;

    }
}
