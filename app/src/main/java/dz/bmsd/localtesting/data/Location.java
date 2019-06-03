package dz.bmsd.localtesting.data;

public class Location {

    private String cityName;
    private double latitude, langitude;

    public Location() {
    }

    public Location(String cityName, double latitude, double langitude) {
        this.cityName = cityName;
        this.latitude = latitude;
        this.langitude = langitude;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return langitude;
    }

    public void setLangitude(double langitude) {
        this.langitude = langitude;
    }
}
