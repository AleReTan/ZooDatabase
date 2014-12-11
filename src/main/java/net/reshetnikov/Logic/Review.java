package net.reshetnikov.Logic;

import java.util.Date;

public class Review {
    private int reviewNumber;
    private String reviewFoodTitle;
    private int reviewFoodCount;
    private Date reviewDateOfDelivery;
    private String reviewAimalTypeFood;

    public int getReviewNumber() {
        return reviewNumber;
    }

    public void setReviewNumber(int reviewNumber) {
        this.reviewNumber = reviewNumber;
    }

    public String getReviewFoodTitle() {
        return reviewFoodTitle;
    }

    public void setReviewFoodTitle(String reviewFoodTitle) {
        this.reviewFoodTitle = reviewFoodTitle;
    }

    public int getReviewFoodCount() {
        return reviewFoodCount;
    }

    public void setReviewFoodCount(int reviewFoodCount) {
        this.reviewFoodCount = reviewFoodCount;
    }

    public Date getReviewDateOfDelivery() {
        return reviewDateOfDelivery;
    }

    public void setReviewDateOfDelivery(Date reviewDateOfDelivery) {
        this.reviewDateOfDelivery = reviewDateOfDelivery;
    }

    public String getReviewAimalTypeFood() {
        return reviewAimalTypeFood;
    }

    public void setReviewAimalTypeFood(String reviewAimalTypeFood) {
        this.reviewAimalTypeFood = reviewAimalTypeFood;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewNumber=" + reviewNumber +
                ", reviewFoodTitle='" + reviewFoodTitle + '\'' +
                ", reviewFoodCount=" + reviewFoodCount +
                ", reviewDateOfDelivery=" + reviewDateOfDelivery +
                ", reviewAimalTypeFood='" + reviewAimalTypeFood + '\'' +
                '}';
    }
}
