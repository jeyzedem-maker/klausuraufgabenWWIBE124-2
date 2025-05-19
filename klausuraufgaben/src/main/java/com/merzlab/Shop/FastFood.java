package com.merzlab.Shop;

public record FastFood(
    String name,
    FastFoodCategory fastFoodCategory,
    double calorificValueInKcal,
    boolean isVegetarian
) implements Comparable<FastFood> {

    @Override
    public int compareTo(FastFood otherFastFood) {
        return Double.compare(otherFastFood.calorificValueInKcal, this.calorificValueInKcal);
    }


}
