package HomeworkProject;

public class Commands {
    /**
     * The number of entered symbol in the entered String
     *
     * @param text: String where you need to find the number of entered symbol
     * @param c:    Symbol which amount you need to find
     * @return counter: The number of symbol in the entered string
     */
    public static int countChar(String text, char c) {
        int counter = 0;
        int length = text.length();
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == c) {
                counter = counter + 1;
            }
        }
        return counter;
    }


    /**
     * The number of sentenses in entered String
     *
     * @param text: String where you need to find the number of sentences
     * @return counter: The number of sentences in the entered string
     */

    public static int countSentences(String text) {
        int counter = 0;
        int length = text.length();
        for (int i = 0; i < length; i++) {
            if ((text.charAt(i) == '.') || (text.charAt(i) == '!') || (text.charAt(i) == '?')) {
                if ((text.charAt(i - 1) == '.') || (text.charAt(i - 1) == '!') || (text.charAt(i - 1) == '?')) {
                    continue;
                } else {
                    counter = counter + 1;
                }
            }
        }
        return counter;
    }

    /**
     * The number of words in the entered string
     *
     * @param text: string where you need to count the number of words
     * @return counter: The number of words in the entered string
     */

    public static int countWords(String text) {
        int counter = 0;
        int length = text.length();
        if (text.charAt(0) == ' ') {
            return 0;
        }
        for (int i = 0; i < length; i++) {
            if ((text.charAt(i) == ' ') || (text.charAt(i) == '.')) {
                if ((text.charAt(i - 1) == ' ') || (text.charAt(i - 1) == '.')) {
                    continue;
                } else {
                    counter = counter + 1;
                }
            }
        }
        if (counter == 0) {
            return 1;
        } else {
            counter = counter + 1;
        }
        return counter;
    }

    /**
     * This method replaces all words in the StringBuilder by another word
     *
     * @param text:     your StringBuilder
     * @param textWord: the word in your StringBuilder that you want to replace
     * @param newWord:  the word that you want to put in your StringBuilder instead of another word
     */
    public static void replaceWord(String text, String textWord, String newWord) {
        int i = 0;
        StringBuilder s_buffer = new StringBuilder(text.subSequence(0, text.length()));
        while ((i = s_buffer.indexOf(textWord, i)) >= 0) {
            s_buffer.delete(i, i + textWord.length());
            s_buffer.insert(i, newWord);
            i += newWord.length();
        }
    }


    /**
     * The number of entered word's repeat
     *
     * @param word: the word which repeat need to find
     * @param text: string where you find word's repeat
     * @return counter: number of entered word's repeat in the string
     */

    public static int countWordRepeat(String word, String text) {
        int counter = 0;
        int lengthw = word.length();
        int lengths = text.length();
        int j = 0;
        for (int i = 0; i < lengths; i++) {
            if (text.charAt(i) == word.charAt(j)) {
                j++;
                if (j == lengthw - 1) {
                    counter++;
                    j = 0;
                }
            } else {
                j = 0;
            }
        }
        return counter;
    }
}