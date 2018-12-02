package com.endava.foodchain;

// Service class

public class FoodChain {
    public static boolean canEat(ApexPredator predator, ApexPredator pray) {
        return predator.getClass().isInstance(pray) &&
                !pray.getClass().isInstance(predator);
    }

    public static boolean siblings(ApexPredator creature1, ApexPredator creature2) {
        return creature1.getClass().equals(creature2.getClass());
    }
}
