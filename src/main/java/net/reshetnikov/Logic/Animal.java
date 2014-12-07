package net.reshetnikov.Logic;

/**
 * Created by Александр on 13.11.2014.
 */
public class Animal {

    private int animalNumber;
    private String animalName;
    private int age;
    private String sex;
    private String animalType;
    private String animalZone;
    private int animalId;
    private int animalTypeId;
    private int zoneId;

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public int getAnimalNumber() {
        return animalNumber;
    }

    public void setAnimalNumber(int animalNumber) {
        this.animalNumber = animalNumber;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalZone() {
        return animalZone;
    }

    public void setAnimalZone(String animalZone) {
        this.animalZone = animalZone;
    }

    public int getAnimalTypeId() {
        return animalTypeId;
    }

    public void setAnimalTypeId(int animalTypeId) {
        this.animalTypeId = animalTypeId;
    }

    public int getZoneId() {
        return zoneId;
    }

    public void setZoneId(int zoneId) {
        this.zoneId = zoneId;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "animalNumber=" + animalNumber +
                ", animalName='" + animalName + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", animalType='" + animalType + '\'' +
                ", animalZone='" + animalZone + '\'' +
                ", animalId=" + animalId +
                ", animalTypeId=" + animalTypeId +
                ", zoneId=" + zoneId +
                '}';
    }
}
