package net.reshetnikov.Logic;

import java.util.Date;

/**
 * Created by Александр on 13.11.2014.
 */
public class Food {

    private int foodNumber;
    private int foodId;
    private String foodTitle;
    private int foodCount;
    private Date dateOfDelivery;
    private String animalTypeFood;
    private int animalTypeId;

    public int getFoodNumber() {
        return foodNumber;
    }

    public void setFoodNumber(int foodNumber) {
        this.foodNumber = foodNumber;
    }

    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodTitle() {
        return foodTitle;
    }

    public void setFoodTitle(String foodTitle) {
        this.foodTitle = foodTitle;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }

    public Date getDateOfDelivery() {
        return dateOfDelivery;
    }

    public void setDateOfDelivery(Date dateOfDelivery) {
        this.dateOfDelivery = dateOfDelivery;
    }

    public String getAnimalTypeFood() {
        return animalTypeFood;
    }

    public void setAnimalTypeFood(String animalTypeFood) {
        this.animalTypeFood = animalTypeFood;
    }

    public int getAnimalTypeId() {
        return animalTypeId;
    }

    public void setAnimalTypeId(int animalTypeId) {
        this.animalTypeId = animalTypeId;
    }

    @Override
    public String toString() {
        return "Logic.Food{" +
                "foodNumber=" + foodNumber +
                ", foodCount=" + foodCount +
                ", dateOfDelivery=" + dateOfDelivery +
                ", animalTypeFood=" + animalTypeFood +
                ", foodTitle='" + foodTitle + '\'' +
                '}';
    }
}
