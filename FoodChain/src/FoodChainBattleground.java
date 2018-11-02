public class FoodChainBattleground {
    public static void main (String[] args) {
        ApexPredator        Owl         = new ApexPredator();
        TertiaryConsumer    Snake       = new TertiaryConsumer();
        TertiaryConsumer    Snake2      = new TertiaryConsumer();
        SecondaryConsumer   Bluebird    = new SecondaryConsumer();
        PrimaryConsumer     Grasshopper = new PrimaryConsumer();
        Producer            Grass       = new Producer();

        System.out.println("Owl can "               + (Owl.canEat(Snake)            ? "" : "not ") + "eat a snake.");
        System.out.println("Owl and Snake are "      + (Owl.siblings(Snake)          ? "" : "not ") + "siblings");
        System.out.println("Snake can "             + (Snake.canEat(Owl)            ? "" : "not ") + "eat an owl.");
        System.out.println("Snake can "             + (Snake.canEat(Bluebird)       ? "" : "not ") + "eat a bluebird.");
        System.out.println("Snake can "             + (Snake.canEat(Snake2)         ? "" : "not ") + "eat an Snake2.");
        System.out.println("Snake2 can "            + (Snake2.canEat(Snake)         ? "" : "not ") + "eat a snake.");
        System.out.println("Snake and Snake2 are "  + (Snake2.siblings(Snake)       ? "" : "not ") + "siblings");
        System.out.println("Bluebird can "          + (Bluebird.canEat(Snake)       ? "" : "not ") + "eat a snake.");
        System.out.println("Bluebird can "          + (Bluebird.canEat(Grasshopper) ? "" : "not ") + "eat a grasshopper.");
        System.out.println("Grasshopper can "       + (Grasshopper.canEat(Bluebird) ? "" : "not ") + "eat a bluebird.");
        System.out.println("Grasshopper can "       + (Grasshopper.canEat(Grass)    ? "" : "not ") + "eat a grass.");
        System.out.println("Grass can "             + (Grass.canEat(Grasshopper)    ? "" : "not ") + "eat a grasshopper.");
    }
}
