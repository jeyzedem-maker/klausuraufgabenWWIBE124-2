package com.merzlab.Shop;

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
        return assortment.entrySet().stream()
            .max(Comparator.comparingDouble(e -> e.getValue().stream().mapToInt(i -> i).average().orElse(0)))
            .map(Map.Entry::getKey);
    }

    public List<T> getAllProductsSortedByNaturalOrdering() {
        List<T> products = new ArrayList<>(assortment.keySet());
        Collections.sort(products);
        return products;
    }
}
