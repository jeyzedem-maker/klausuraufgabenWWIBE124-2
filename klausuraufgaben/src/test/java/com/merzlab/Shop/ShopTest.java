package com.merzlab.Shop;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void testAddAndRateProduct() {
        Shop<FastFood> shop = new Shop<>("TestShop", new HashMap<>());
        FastFood burger = new FastFood("Burger", FastFoodCategory.BURGER, 500, false);

        shop.addProduct(burger);
        shop.rateProduct(burger, 4);
        shop.rateProduct(burger, 5);

        assertTrue(shop.assortment().containsKey(burger));
        assertEquals(Arrays.asList(4, 5), shop.assortment().get(burger));
    }

    @Test
    void testGetBestRatedProduct() {
        Shop<FastFood> shop = new Shop<>("TestShop", new HashMap<>());
        FastFood burger = new FastFood("Burger", FastFoodCategory.BURGER, 500, false);
        FastFood pizza = new FastFood("Pizza", FastFoodCategory.PIZZA, 300, true);

        shop.addProduct(burger);
        shop.addProduct(pizza);

        shop.rateProduct(burger, 3);
        shop.rateProduct(burger, 5);
        shop.rateProduct(pizza, 5);
        shop.rateProduct(pizza, 5);

        Optional<FastFood> best = shop.getBestRatedProduct();
        assertTrue(best.isPresent());
        assertEquals(pizza, best.get());
    }

    @Test
    void testGetAllProductsSortedByNaturalOrdering() {
        Shop<FastFood> shop = new Shop<>("TestShop", new HashMap<>());
        FastFood burger = new FastFood("Burger", FastFoodCategory.BURGER, 500, false);
        FastFood pizza = new FastFood("Pizza", FastFoodCategory.PIZZA, 300, true);
        FastFood salad = new FastFood("Salad", FastFoodCategory.SALAD, 150, true);

        shop.addProduct(pizza);
        shop.addProduct(burger);
        shop.addProduct(salad);

        List<FastFood> sorted = shop.getAllProductsSortedByNaturalOrdering();
        List<FastFood> expected = Arrays.asList(burger, pizza, salad);
        expected.sort(Comparator.naturalOrder());

        assertEquals(expected, sorted);
    }
}