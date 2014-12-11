package net.reshetnikov.Logic;

public class AnimalType {
    private int animalTypeNumber;
    private int animalTypeId;
    private String animalTypeTitle;
    private int animalCount;
    private int foodPerDay;

    public int getAnimalTypeNumber() {
        return animalTypeNumber;
    }

    public void setAnimalTypeNumber(int animalTypeNumber) {
        this.animalTypeNumber = animalTypeNumber;
    }

    public int getAnimalTypeId() {
        return animalTypeId;
    }

    public void setAnimalTypeId(int animalTypeId) {
        this.animalTypeId = animalTypeId;
    }

    public String getAnimalTypeTitle() {
        return animalTypeTitle;
    }

    public void setAnimalTypeTitle(String animalTypeTitle) {
        this.animalTypeTitle = animalTypeTitle;
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public void setAnimalCount(int animalCount) {
        this.animalCount = animalCount;
    }

    public int getFoodPerDay() {
        return foodPerDay;
    }

    public void setFoodPerDay(int foodPerDay) {
        this.foodPerDay = foodPerDay;
    }

    @Override
    public String toString() {
        return "Logic.AnimalType{" +
                "animalTypeNumber=" + animalTypeNumber +
                ", animalTypeTitle='" + animalTypeTitle + '\'' +
                ", animalCount=" + animalCount +
                ", foodPerDay=" + foodPerDay +
                '}';
    }
}
