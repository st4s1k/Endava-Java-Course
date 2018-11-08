package com.endava.foodchain;

public class ApexPredator {

    public void eat(ApexPredator pray) throws NotEatableException {
        if (canEat(this, pray)) {
            System.out.println("OM NOM NOM...");
        } else {
            throw new NotEatableException(pray);
        }
    }

    public static boolean canEat(ApexPredator predator, ApexPredator pray) {
        return predator.getClass().isInstance(pray) &&
                !pray.getClass().isInstance(predator);
    }

    public static boolean siblings(ApexPredator creature1, ApexPredator creature2) {
        return creature1.getClass().equals(creature2.getClass());
    }
}