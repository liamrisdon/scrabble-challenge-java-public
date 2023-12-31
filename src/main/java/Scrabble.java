import java.util.HashMap;
import java.util.Map;

public class Scrabble {

    private static final Map<Character, Integer> letterValue = new HashMap<>();

    static {
        letterValue.put('a', 1);
        letterValue.put('e', 1);
        letterValue.put('i', 1);
        letterValue.put('o', 1);
        letterValue.put('u', 1);
        letterValue.put('l', 1);
        letterValue.put('n', 1);
        letterValue.put('r', 1);
        letterValue.put('s', 1);
        letterValue.put('t', 1);
        letterValue.put('d', 2);
        letterValue.put('g', 2);
        letterValue.put('b', 3);
        letterValue.put('c', 3);
        letterValue.put('m', 3);
        letterValue.put('p', 3);
        letterValue.put('f', 4);
        letterValue.put('h', 4);
        letterValue.put('v', 4);
        letterValue.put('w', 4);
        letterValue.put('y', 4);
        letterValue.put('k', 5);
        letterValue.put('j', 8);
        letterValue.put('x', 8);
        letterValue.put('q', 10);
        letterValue.put('z', 10);

    }

    private String word;
    private int wordScore = 0;
    private boolean doubleWord;
    private boolean tripleWord;
    private Character[] doubleLetter;
    private Character[] tripleLetter;


    public Scrabble(String newWord) {
        word = newWord;
    }

    public Scrabble(String newWord, Character[] doubleLetter, Character[] tripleLetter, boolean doubleWord, boolean tripleWord) {
        word = newWord;
        this.doubleWord = doubleWord;
        this.tripleWord = tripleWord;
        this.doubleLetter = doubleLetter;
        this.tripleLetter = tripleLetter;
    }

    public int score() {
        return (word == null || word.isEmpty()) ? 0 : scoreCalculator();
    }

    private int scoreCalculator() {
        wordScore += wordScoreCalculator(word);
        doubleAndTripleWordCalculator();
        doubleTripleLetterValidator();
        return wordScore;
    }

    private int wordScoreCalculator(String word) {
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            wordScore += letterValue.get(word.charAt(i));
        }
        return wordScore;
    }

    private void doubleAndTripleWordCalculator() {
        if(this.doubleWord) wordScore *= 2;
        if(this.tripleWord) wordScore *= 3;
    }


    private void doubleTripleLetterValidator() {
        if (doubleLetter != null) applyDoubleLetterScore();
        if (tripleLetter != null) applyTripleLetterScore();
    }

    private void applyDoubleLetterScore() {
            for (char letter : doubleLetter) {
                    wordScore += letterValue.get(Character.toLowerCase(letter));
                }
        }

    private void applyTripleLetterScore() {
            for (char letter : tripleLetter) {
                wordScore += letterValue.get(Character.toLowerCase(letter)) * 2;
            }
    }

}






