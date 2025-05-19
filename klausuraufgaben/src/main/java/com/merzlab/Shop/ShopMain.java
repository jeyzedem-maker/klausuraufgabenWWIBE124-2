package com.merzlab.Shop;


public class ShopMain {

    public static void main(String[] args) {
        FastFood fastFood1 = new FastFood("Burger", FastFoodCategory.BURGER, 500, false);
        FastFood fastFood2 = new FastFood("Pizza", FastFoodCategory.PIZZA, 300, true);
        FastFood fastFood3 = new FastFood("Salad", FastFoodCategory.SALAD, 150, true);
        FastFood fastFood4 = new FastFood("Fries", FastFoodCategory.FRIES, 400, false);

        fastFood.add(fastFood1);
        fastFood.add(fastFood2);
        fastFood.add(fastFood3);

        Collection.sort(fastFood);
        fastFood.forEach(System.out::println);
    }

}
