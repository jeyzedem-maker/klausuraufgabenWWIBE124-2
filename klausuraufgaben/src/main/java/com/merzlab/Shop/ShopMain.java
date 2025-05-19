package com.merzlab.Shop;


import java.util.*;


public class ShopMain {

    public static void main(String[] args) {
        List<FastFood> fastFood = new ArrayList<>();

        FastFood fastFood1 = new FastFood("Burger", FastFoodCategory.BURGER, 500, false);
        FastFood fastFood2 = new FastFood("Pizza", FastFoodCategory.PIZZA, 300, true);
        FastFood fastFood3 = new FastFood("Salad", FastFoodCategory.SALAD, 150, true);
        FastFood fastFood4 = new FastFood("Fries", FastFoodCategory.FRIES, 400, false);

        fastFood.add(fastFood1);
        fastFood.add(fastFood2);
        fastFood.add(fastFood3);
        fastFood.add(fastFood4);

        Collections.sort(fastFood);
        fastFood.forEach(System.out::println);
        System.out.println("--------------------------------------------------");

        Shop<FastFood> shop = new Shop<>("Fast Food Shop", new HashMap<>());
        shop.addProduct(fastFood1);
        shop.addProduct(fastFood2);
        shop.addProduct(fastFood3);
        shop.addProduct(fastFood4);
        
        shop.rateProduct(fastFood1, 4);
        shop.rateProduct(fastFood1, 3);
        shop.rateProduct(fastFood2, 3);
        shop.rateProduct(new FastFood("Veggie Burger", FastFoodCategory.BURGER, 450, true), 3);
        

        shop.assortment().forEach((p, rs) -> System.out.println(p + " " + rs));
        System.out.println("--------------------------------------------------");

        Optional<FastFood> bestRatedProduct =shop.getBestRatedProduct();
        

        bestRatedProduct.ifPresent(System.out::println);
        System.out.println("--------------------------------------------------");
        shop.getAllProductsSortedByNaturalOrdering().forEach(System.out::println);


    }

}
