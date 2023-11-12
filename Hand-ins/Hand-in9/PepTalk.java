import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PepTalk {

    public static void main(String[] args) {
        PepTalk peptalk = new PepTalk();
        Scanner sc = new Scanner(System.in);

        boolean firstWord = true;

        while (sc.hasNextLine()) {
            String[] words = sc.nextLine().split(" ");
            
            for (String word : words) {
                if (!firstWord) {
                    System.out.print(" ");
                }
                System.out.print(peptalk.makePepTalk(word));

                firstWord = false;
            }
        }
        sc.close();
    }

    public String makePepTalk(String word) {
        //put vowels into "::" 
        word = findVowelAndAddParentheses(word);

        //split consonants between ::
        word = findAndSplitConsonants(word);

        //split two vowels
        word = findVowelAndAddParentheses(word);
        word = splitVowels(word);

        //remove all :
        word = word.replaceAll("[:]", "") ;

        //repeat syllable and add p.
        String[] sylllables = word.split("-");

        String pepTalk = "";

        for (String syllable : sylllables) {

            String peppedSyllable = getPeppedSyllable(syllable);

            pepTalk = pepTalk + syllable + peppedSyllable.toLowerCase();
        }

        return pepTalk;
    }

    public String getPeppedSyllable(String peppedSyllable) {

        if (peppedSyllable.matches("^[AEIOUaeiou].*")) {
            peppedSyllable = "p" + peppedSyllable;

        } else {
            peppedSyllable = replaceFirstConsonantWithP(peppedSyllable);
        }
        return peppedSyllable;
    }

    public String replaceFirstConsonantWithP(String peppedSyllable) {
        Pattern getFirstCons = Pattern.compile("^[^-AEIOUaeiou]+");
        Matcher m3 = getFirstCons.matcher(peppedSyllable);

        while (m3.find()) {
            peppedSyllable = m3.replaceFirst("p");
        }
        return peppedSyllable;
    }

    public String splitVowels(String word) {
        Pattern getTwoVowels = Pattern.compile("([AEIOUaeiou()])(::)([AEIOUaeiou()])");
        Matcher m4 = getTwoVowels.matcher(word);

        while (m4.find()) {
            word = word.replaceAll(m4.group(2), ":" + "-" + ":");
        }
        return word;
    }

    public String findAndSplitConsonants(String word) {
        String[] letterGroups = word.split(":");

        String newWord = "";

        int count = 0;
        for (String letterGroup : letterGroups) {
            Pattern getConsonants = Pattern.compile("([^AEIOUaeiou]+)");
            Matcher m = getConsonants.matcher(letterGroup);

            if (m.find() && !newWord.isEmpty() && count<letterGroups.length-1) {
                // If consonants
                if (letterGroup.length()>1) {
                    String firstConsonants = letterGroup.substring(0, letterGroup.length()/2);
                    String lastConsonants = letterGroup.substring(letterGroup.length()/2);
                    newWord = newWord + firstConsonants + "-" + lastConsonants;
                } else {
                    newWord = newWord + "-" + letterGroup;
                }
            } else {
                newWord = newWord + letterGroup;
            }
            count++;
        }
        return newWord;
    }

    public String findVowelAndAddParentheses(String word) {
        word = word.replaceAll("[AEIOUaeiou]", ":$0:") ;
        return word;
    }

}