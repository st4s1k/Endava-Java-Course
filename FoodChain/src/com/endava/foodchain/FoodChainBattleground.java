package com.endava.foodchain;

class FoodChainBattleground {

    static final String vowels = "AEIOUWYaeiouwy";
//  static final String consonants = "BCDFGHJKLMNPQRSTVXZbcdfghjklmnpqrstvxz";

    static boolean isAlpha(String str) {
        if (str != null && str.length() > 0) {
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isLetter(str.charAt(i)))
                    return false;
            }
            return true;
        }
        return false;
    }

    static String getCorrectArticle(String word) throws InvalidWordException {
        if (!isAlpha(word))
            throw new InvalidWordException(word);
        if (vowels.indexOf(word.charAt(0)) != -1)
            return "an";
        else
            return "a";
    }

    static void tryToEat(ApexPredator predator, ApexPredator pray) {
        try {
            System.out.print("[" + predator.getSpecies() + " -> " + pray.getSpecies() + "]    ");
            predator.eat(pray);
        } catch (NotEatableException e1) {
            StringBuilder msg = new StringBuilder();
            try {
                msg.append(e.getPredatorClass());
                msg.append(" cannot eat ");
                msg.append(getCorrectArticle(e.getPrayClass()));
                msg.append(" ");
                msg.append(e.getPrayClass());
            } catch (InvalidWordException e2) {
                msg.append("An exception occured while trying to parse the word \"");
                msg.append(e2.getWord());
                msg.append("\"");
            }
            System.out.println(msg.toString());
        }
    }

    public static void main (String[] args) {

        ApexPredator        owl           = new ApexPredator("Owl");
        TertiaryConsumer    snake         = new TertiaryConsumer("Snake");
        TertiaryConsumer    snake2        = new TertiaryConsumer("Snake2");
        SecondaryConsumer   bluebird      = new SecondaryConsumer("Bluebird");
        PrimaryConsumer     grasshopper   = new PrimaryConsumer("Grasshopper");
        Producer            grass         = new Producer("Grass");

        System.out.println("\n//////////////////////");
        System.out.println("//    HOMEWORK#1    //");
        System.out.println("//////////////////////\n");

        System.out.println("Owl can "              + (ApexPredator.canEat(owl, snake)            ? "" : "not ") + "eat a snake.");
        System.out.println("Owl and Snake are "    + (ApexPredator.siblings(owl, snake)          ? "" : "not ") + "siblings");
        System.out.println("Snake can "            + (ApexPredator.canEat(snake, owl)            ? "" : "not ") + "eat an owl.");
        System.out.println("Snake can "            + (ApexPredator.canEat(snake, bluebird)       ? "" : "not ") + "eat a bluebird.");
        System.out.println("Snake can "            + (ApexPredator.canEat(snake, snake2)         ? "" : "not ") + "eat an Snake2.");
        System.out.println("Snake2 can "           + (ApexPredator.canEat(snake2, snake)         ? "" : "not ") + "eat a snake.");
        System.out.println("Snake and Snake2 are " + (ApexPredator.siblings(snake2, snake)       ? "" : "not ") + "siblings");
        System.out.println("Bluebird can "         + (ApexPredator.canEat(bluebird, snake)       ? "" : "not ") + "eat a snake.");
        System.out.println("Bluebird can "         + (ApexPredator.canEat(bluebird, grasshopper) ? "" : "not ") + "eat a grasshopper.");
        System.out.println("Grasshopper can "      + (ApexPredator.canEat(grasshopper, bluebird) ? "" : "not ") + "eat a bluebird.");
        System.out.println("Grasshopper can "      + (ApexPredator.canEat(grasshopper, grass)    ? "" : "not ") + "eat a grass.");
        System.out.println("Grass can "            + (ApexPredator.canEat(grass, grasshopper)    ? "" : "not ") + "eat a grasshopper.");

        // OUTPUT:

        // Owl can eat a snake.
        // Owl and Snake are not siblings
        // Snake can not eat an owl.
        // Snake can eat a bluebird.
        // Snake can not eat an Snake2.
        // Snake2 can not eat a snake.
        // Snake and Snake2 are siblings
        // Bluebird can not eat a snake.
        // Bluebird can eat a grasshopper.
        // Grasshopper can not eat a bluebird.
        // Grasshopper can eat a grass.
        // Grass can not eat a grasshopper.

        System.out.println("\n//////////////////////");
        System.out.println("//    HOMEWORK#2    //");
        System.out.println("//////////////////////\n");

        tryToEat(owl, snake);
        tryToEat(snake, owl);
        tryToEat(snake, bluebird);
        tryToEat(snake, snake2);
        tryToEat(bluebird, snake);
        tryToEat(bluebird, grasshopper);
        tryToEat(grasshopper, bluebird);
        tryToEat(grasshopper, grass);
        tryToEat(grass, grasshopper);

        // OUTPUT:

        // [Owl -> Snake]    OM NOM NOM...
        // [Snake -> Owl]    TertiaryConsumer cannot eat an ApexPredator
        // [Snake -> Bluebird]    OM NOM NOM...
        // [Snake -> Snake2]    TertiaryConsumer cannot eat a TertiaryConsumer
        // [Bluebird -> Snake]    SecondaryConsumer cannot eat a TertiaryConsumermer
        // [Bluebird -> Grasshopper]    OM NOM NOM...
        // [Grasshopper -> Bluebird]    PrimaryConsumer cannot eat a SecondaryConsumeronsumer
        // [Grasshopper -> Grass]    OM NOM NOM...
        // [Grass -> Grasshopper]    Producer cannot eat a PrimaryConsumer

    }
}
