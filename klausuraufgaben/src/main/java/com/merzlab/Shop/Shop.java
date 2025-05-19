package com.merzlab.Shop;

import java.util.Map.Entry;
import java.util.*;

public record Shop<T extends Comparable<T>>(
    String name,
    Map<T, List<Integer>> assortment
) {

    public void addProduct(T product) {
        assortment.putIfAbsent(product, new ArrayList<>());
    }

    public void rateProduct(T product, int rating) {
        assortment.computeIfAbsent(product, k -> new ArrayList<>()).add(rating);
    }

    public Optional<T> getBestRatedProduct() {
       T bestRatedProduct = null;
       double bestAvarageRating = 0;
       
       for (Entry<T, List<Integer>> entry : assortment.entrySet()) {
            T product = entry.getKey();
            List<Integer> ratings = entry.getValue();

            double total = 0;
            for (int rating : ratings){
                total += rating;
            }
            double averageRating = total / ratings.size();

            if (averageRating >= bestAvarageRating) {
                bestAvarageRating = averageRating;
                bestRatedProduct = product;
                
            }
       }

       return Optional.ofNullable(bestRatedProduct);
       
       /*
        Optional<T> bestRatedProduct = Optional.empty();
        return bestRatedProduct
        */
    }

    public List<T> getAllProductsSortedByNaturalOrdering() {
        // Sort the products in natural order
        
        List<T> products = new ArrayList<>(assortment.keySet());
        Collections.sort(products);
        return products;
        
        // Variant:
        /*
        List<T> products = new ArrayList<>();

        for (T product : assortment.keySet()) {
            products.add(product);
        }
        Collections.sort(products);
        return products;
        */
    }
}
