package dz.bmsd.localtesting.util;

import org.junit.Before;
import org.junit.Test;

import dz.bmsd.localtesting.data.Location;

import static dz.bmsd.localtesting.util.FileReaderUtil.readFile;
import static dz.bmsd.localtesting.util.JsonParser.parseLocationFromJson;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.*;

public class ParseLocationFromJsonTest {

    private static final String CORRECT_CITY ="Dallas, TX, USA";
    private static final double CORRECT_LATITUDE =32.7766642;
    private static final double CORRECT_LONGITUDE =-96.79698789999999;
    private static final double NULL_COORDINATE =0.0;

    // json inputs
    private String correctInput, emptyResults, noCity, noCityAndLocation, noGeometry, noLatitude, noLongitude, noLocation, noResults;

    @Before
    public void readJsonFileToString(){
        ClassLoader classLoader = this.getClass().getClassLoader();
        correctInput = readFile(classLoader, "correctInput.json");
        emptyResults = readFile(classLoader, "emptyResults.json");
        noCity = readFile(classLoader, "noCity.json");
        noCityAndLocation = readFile(classLoader, "noCityAndLocation.json");
        noGeometry = readFile(classLoader, "noGeometry.json");
        noLatitude = readFile(classLoader, "noLatitude.json");
        noLocation = readFile(classLoader, "noLocation.json");
        noLongitude = readFile(classLoader, "noLongitude.json");
        noResults = readFile(classLoader, "noResults.json");
    }

    @Test
    public void parseLocationFromJson_NullInput_EmptyLocation(){
        Location location = parseLocationFromJson(null);
        assertThatLocationIsEmpty(location);
    }

    @Test
    public void parseLocationFromJson_EmptyInput_EmptyLocation(){
        Location location = parseLocationFromJson("");
        assertThatLocationIsEmpty(location);
    }

    @Test
    public void parseLocationFromJson_EmptyJson_EmptyLocation(){
        Location location = parseLocationFromJson("{}");
        assertThatLocationIsEmpty(location);
    }

    @Test
    public void parseLocationFromJson_NoteAJsonInput_EmptyLocation(){
        Location location = parseLocationFromJson(" some words here!");
        assertThatLocationIsEmpty(location);
    }

    @Test
    public void parseLocationFromJson_fullInput_CorrectResult() {
        Location location = parseLocationFromJson(correctInput);
        assertThat(location.getCityName(), is(CORRECT_CITY));
        assertThat(location.getLatitude(), is(CORRECT_LATITUDE));
        assertThat(location.getLongitude(), is(CORRECT_LONGITUDE));
    }

    @Test
    public void parseLocationFromJson_NoResults_EmptyLocation() {
        Location location = parseLocationFromJson(noResults);
        assertThatLocationIsEmpty(location);
    }

    @Test
    public void parseLocationFromJson_EmptyResults_EmptyLocation() {
        Location location = parseLocationFromJson(emptyResults);
        assertThatLocationIsEmpty(location);
    }

    @Test
    public void parseLocationFromJson_NoCityAndLocation_EmptyLocation() {
        Location location = parseLocationFromJson(noCityAndLocation);
        assertThatLocationIsEmpty(location);
    }

    @Test
    public void parseLocationFromJson_NoCity_NullCity() {
        Location location = parseLocationFromJson(noCity);
        assertThat(location.getCityName(), is(nullValue()));
        assertThat(location.getLatitude(), is(CORRECT_LATITUDE));
        assertThat(location.getLongitude(), is(CORRECT_LONGITUDE));
    }

    @Test
    public void parseLocationFromJson_NoLocation_ZeroLatLng() {
        Location location = parseLocationFromJson(noLocation);
        assertThat(location.getCityName(), is(CORRECT_CITY));
        assertThat(location.getLatitude(), is(NULL_COORDINATE));
        assertThat(location.getLongitude(), is(NULL_COORDINATE));
    }

    @Test
    public void parseLocationFromJson_NoGeometry_ZeroLatLng() {
        Location location = parseLocationFromJson(noGeometry);
        assertThat(location.getCityName(), is(CORRECT_CITY));
        assertThat(location.getLatitude(), is(NULL_COORDINATE));
        assertThat(location.getLongitude(), is(NULL_COORDINATE));
    }

    @Test
    public void parseLocationFromJson_NoLatitude_ZeroLat() {
        Location location = parseLocationFromJson(noLatitude);
        assertThat(location.getCityName(), is(CORRECT_CITY));
        assertThat(location.getLatitude(), is(NULL_COORDINATE));
        assertThat(location.getLongitude(), is(CORRECT_LONGITUDE));
    }

    @Test
    public void parseLocationFromJson_NoLongitude_ZeroLon() {
        Location location = parseLocationFromJson(noLongitude);
        assertThat(location.getCityName(), is(CORRECT_CITY));
        assertThat(location.getLatitude(), is(CORRECT_LATITUDE));
        assertThat(location.getLongitude(), is(NULL_COORDINATE));
    }

    private void assertThatLocationIsEmpty(Location location) {
        assertThat(location.getCityName(), is(nullValue()));
        assertThat(location.getLatitude(), is(NULL_COORDINATE));
        assertThat(location.getLongitude(), is(NULL_COORDINATE));
    }

}