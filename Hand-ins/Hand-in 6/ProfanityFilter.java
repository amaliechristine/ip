import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ProfanityFilter {


    List<String> swearWords;

    public ProfanityFilter() {
    }

    public static void main(String[] args) {
        ProfanityFilter profanityfilter = new ProfanityFilter();
        profanityfilter.filterSwearwords();
    }

    public void filterSwearwords() {
        Scanner scanner = new Scanner(System.in);
        swearWords = Arrays.asList(scanner.nextLine().toLowerCase().split(" "));
        
        while (scanner.hasNextLine()) {
            String[] tweetWords = scanner.nextLine().split(" ");
            boolean firstWord = true;
            for (String word: tweetWords) {
                String censoredWord = censorTweet(word);
                if (!firstWord) {
                    System.out.print(" ");
                }
                firstWord = false;
                System.out.print(censoredWord);
                
            }
            System.out.println();
        }
        scanner.close();
    }

    private String censorTweet(String word) { 
        String replacement;
        String character;

        if (word.contains(",") || word.contains(".") || word.contains("!") || word.contains("?")) {
            character = word.substring(word.length()-1);
            word = word.substring(0, word.length()-1);
        } else {
            character = "";
        }
        if (swearWords.contains(word.toLowerCase())) {
            replacement = toCharacters(word);
        } else {
            replacement = word;
        }
        replacement = replacement + character;
        return replacement;
    }

    private String toCharacters(String word) {
        int length = word.length();
        int charLength = length/5+1;
        return "*&#$%".repeat(charLength).substring(0, length);
    }
}