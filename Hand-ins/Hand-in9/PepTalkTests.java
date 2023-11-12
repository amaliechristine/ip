import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PepTalkTests {
    @Test
    public void testIfParanthesesAreAdded() {
        PepTalk peptalk = new PepTalk();
        String result = peptalk.findVowelAndAddParentheses("Konstantinopolitanerinde");
        String expected = "K:o:nst:a:nt:i:n:o:p:o:l:i:t:a:n:e:r:i:nd:e:";
        assertEquals(expected,result);

        result = peptalk.findVowelAndAddParentheses("coffee");
        expected = "c:o:ff:e::e:";
        assertEquals(expected,result);
    }

    @Test
    public void testConsonantSyllableSplit() {
        PepTalk peptalk = new PepTalk();

        String result = peptalk.findAndSplitConsonants(":a:ss:i:gnm:e:nt");
        String expected = "as-sig-nment";
        assertEquals(expected,result);

        result = peptalk.findAndSplitConsonants("c:o:ff:e::e:");
        expected = "cof-fee";
        assertEquals(expected,result);

        result = peptalk.findAndSplitConsonants("K:o:nst:a:nt:i:n:o:p:o:l:i:t:a:n:e:r:i:nd:e:");
        expected = "Kon-stan-ti-no-po-li-ta-ne-rin-de";
        assertEquals(expected,result);
    }

    @Test
    public void testVowelSplit() {
        PepTalk peptalk = new PepTalk();
        String result = peptalk.splitVowels(":a:s-s:i:g-nm:e:nt");
        String expected = ":a:s-s:i:g-nm:e:nt";
        assertEquals(expected,result);

        result = peptalk.splitVowels("c:o:f-f:e::a:");
        expected = "c:o:f-f:e:-:a:";
        assertEquals(expected,result);
    }

    @Test
    public void testReplaceFirstConsonantWithP() {
        PepTalk peptalk = new PepTalk();
        String result = peptalk.replaceFirstConsonantWithP("sig");
        String expected = "pig";
        assertEquals(expected,result);
    }

    @Test
    public void testGetPeppedSyllable() {
        PepTalk peptalk = new PepTalk();
        String result = peptalk.getPeppedSyllable("sig");
        String expected = "pig";
        assertEquals(expected,result);

        result = peptalk.getPeppedSyllable("as");
        expected = "pas";
        assertEquals(expected,result);
    }

    @Test
    public void testMakePepTalk() {
        PepTalk peptalk = new PepTalk();
        String result = peptalk.makePepTalk("Assignment");
        String expected = "Aspassigpignmentpent";
        assertEquals(expected,result);
        result = peptalk.makePepTalk("coffee");
        expected = "cofpoffepeepe";
        assertEquals(expected,result);
        result = peptalk.makePepTalk("Konstantinopolitanerinde");
        expected = "Konponstanpantipinopopopolipitapaneperinpindepe";
        assertEquals(expected,result);
    }
}