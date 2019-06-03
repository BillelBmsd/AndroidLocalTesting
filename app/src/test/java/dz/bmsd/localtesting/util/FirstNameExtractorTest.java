package dz.bmsd.localtesting.util;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static dz.bmsd.localtesting.util.FirstNameExtractor.*;

public class FirstNameExtractorTest {

    private static String BMSD="Bmsd";

    @Test
    public void extractFirstName_NullInput_ReturnEmptyString() {
        assertThat(extractFirstName(null),is(""));
    }

    @Test
    public void extractFirstName_EmptyInput_ReturnEmptyString(){
        assertThat(extractFirstName(""),is(""));
    }

    @Test
    public void extractFirstName_FullName_ReturnsCorrect() {
        assertThat(extractFirstName("Bmsd Billel"), is(BMSD));
    }

    @Test
    public void extractFirstName_FullNameAroundWhiteSpaces_ReturnsCorrect() {
        assertThat(extractFirstName("Bmsd Billel "), is(BMSD));
        assertThat(extractFirstName(" Bmsd Billel"), is(BMSD));
        assertThat(extractFirstName("Bmsd    Billel"), is(BMSD));
        assertThat(extractFirstName("   Bmsd Billel   "), is(BMSD));
        assertThat(extractFirstName(" Bmsd Billel  "), is(BMSD));
    }

    @Test
    public void extractFirstName_FirstName_ReturnsCorrect() {
        assertThat(extractFirstName("Bmsd"), is(BMSD));
    }

    @Test
    public void extractFirstName_FirstNameAroundWhiteSpaces_ReturnsCorrect() {
        assertThat(extractFirstName("Bmsd "), is(BMSD));
        assertThat(extractFirstName(" Bmsd"), is(BMSD));
        assertThat(extractFirstName(" Bmsd "), is(BMSD));
        assertThat(extractFirstName("  Bmsd   "), is(BMSD));
    }

    @Test
    public void extractFirstName_ThreeWords_ReturnsCorrect() {
        assertThat(extractFirstName("Bmsd Bmsd Billel"), is(BMSD));
    }

    @Test
    public void extractFirstName_ThreeWordsAroundWhiteSpaces_ReturnsCorrect() {
        assertThat(extractFirstName("Bmsd Bmsd Billel "), is(BMSD));
        assertThat(extractFirstName(" Bmsd Bmsd Billel"), is(BMSD));
        assertThat(extractFirstName("   Bmsd Bmsd Billel   "), is(BMSD));
        assertThat(extractFirstName("Bmsd   Bmsd   Billel"), is(BMSD));
        assertThat(extractFirstName("  Bmsd   Bmsd   Billel"), is(BMSD));
        assertThat(extractFirstName("  Bmsd   Bmsd   Billel   "), is(BMSD));
    }
}