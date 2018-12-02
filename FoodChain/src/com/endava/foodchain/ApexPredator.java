package com.endava.foodchain;


public class ApexPredator extends FoodChain {

    private String species;

    public ApexPredator(String species) {
        this.species = species;
    }

    public void eat(ApexPredator pray) throws NotEatableException {
        if (canEat(this, pray))
            System.out.println("OM NOM NOM...");
        else
            throw new NotEatableException(
                    this.getClass().getSimpleName(),
                    pray.getClass().getSimpleName()
            );
    }

    public String getSpecies() {
        return species;
    }
}