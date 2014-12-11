package net.reshetnikov.Logic;

public class Overseer {
    private int overseerNumber;
    private int overseerId;
    private String name;
    private String lastName;
    private int phoneNumber;
    private int ageOverseer;
    private boolean isSick;
    private String overseerZone;
    private int zoneId;

    public int getOverseerNumber() {
        return overseerNumber;
    }
    public void setOverseerNumber(int overseerNumber) {
        this.overseerNumber = overseerNumber;
    }
    public int getOverseerId() {
        return overseerId;
    }
    public void setOverseerId(int overseerId) {
        this.overseerId = overseerId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getAgeOverseer() {
        return ageOverseer;
    }
    public void setAgeOverseer(int ageOverseer) {
        this.ageOverseer = ageOverseer;
    }
    public boolean getIsSick() {
        return isSick;
    }
    public void setIsSick(boolean isSick) {
        this.isSick = isSick;
    }
    public String getOverseerZone() {
        return overseerZone;
    }
    public void setOverseerZone(String overseerZone) {
        this.overseerZone = overseerZone;
    }
    public int getZoneId() {
        return zoneId;
    }
    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }
    @Override
    public String toString() {
        return "Overseers{" +
                "overseersNumber=" + overseerNumber +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", ageOverseers=" + ageOverseer +
                ", isSick=" + isSick +
                ", overseersZone=" + overseerZone +
                '}';
    }
}
