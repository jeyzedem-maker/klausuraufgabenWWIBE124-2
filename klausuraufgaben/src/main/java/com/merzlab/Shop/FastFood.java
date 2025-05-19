package com.merzlab.Shop;

public record FastFood(
        String name,
        FastFoodCategory category,
        double calories,
        boolean vegetarian
) implements Comparable<FastFood> {

    @Override
    public int compareTo(FastFood otherFastFood) {
        return Double.compare(otherFastFood.calories, this.calories);
    }
}
