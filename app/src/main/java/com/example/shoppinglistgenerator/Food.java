package com.example.shoppinglistgenerator;

public class Food {
    private String foodName;
    private String foodDesc;
    private Double foodCal;
    private Double foodFats;
    private Double foodCarbs;
    private Double foodProtein;
    private Double servingSize;
    private String servingType;


    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodDesc() {
        return foodDesc;
    }

    public void setFoodDesc(String foodDesc) {
        this.foodDesc = foodDesc;
    }

    public Double getFoodCal() {
        return foodCal;
    }

    public void setFoodCal(Double foodCal) {
        this.foodCal = foodCal;
    }

    public Double getFoodFats() {
        return foodFats;
    }

    public void setFoodFats(Double foodFats) {
        this.foodFats = foodFats;
    }

    public Double getFoodCarbs() {
        return foodCarbs;
    }

    public void setFoodCarbs(Double foodCarbs) {
        this.foodCarbs = foodCarbs;
    }

    public Double getFoodProtein() {
        return foodProtein;
    }

    public void setFoodProtein(Double foodProtein) {
        this.foodProtein = foodProtein;
    }

    public Double getServingSize() {
        return servingSize;
    }

    public void setServingSize(Double servingSize) {
        this.servingSize = servingSize;
    }

    public String getServingType() {
        return servingType;
    }

    public void setServingType(String servingType) {
        this.servingType = servingType;
    }

    public Food(String foodName, String foodDesc, Double foodCal, Double foodFats, Double foodCarbs, Double foodProtein, Double servingSize, String servingType) {
        this.foodName = foodName;
        this.foodDesc = foodDesc;
        this.foodCal = foodCal;
        this.foodFats = foodFats;
        this.foodCarbs = foodCarbs;
        this.foodProtein = foodProtein;
        this.servingSize = servingSize;
        this.servingType = servingType;
    }
}