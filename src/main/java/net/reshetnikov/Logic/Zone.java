package net.reshetnikov.Logic;

public class Zone {

    private int zoneNumber;
    private int zoneId;
    private String zoneTitle;
    private int population;

    public int getZoneNumber() {
        return zoneNumber;
    }

    public void setZoneNumber(int zoneNumber) {
        this.zoneNumber = zoneNumber;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    public String getZoneTitle() {
        return zoneTitle;
    }

    public void setZoneTitle(String zoneTitle) {
        this.zoneTitle = zoneTitle;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "zoneNumber=" + zoneNumber +
                ", zoneId=" + zoneId +
                ", zoneTitle='" + zoneTitle + '\'' +
                ", population=" + population +
                '}';
    }
}
