public class FoodChainBattleground {
    public static void main (String[] args) {
        ApexPredator        Owl         = new ApexPredator();
        TertiaryConsumer    Snake       = new TertiaryConsumer();
        TertiaryConsumer    Snake2      = new TertiaryConsumer();
        SecondaryConsumer   Bluebird    = new SecondaryConsumer();
        PrimaryConsumer     Grasshopper = new PrimaryConsumer();
        Producer            Grass       = new Producer();

        System.out.println("Owl can "              + (ApexPredator.canEat(Owl, Snake)            ? "" : "not ") + "eat a snake.");
        System.out.println("Owl and Snake are "    + (ApexPredator.siblings(Owl, Snake)          ? "" : "not ") + "siblings");
        System.out.println("Snake can "            + (ApexPredator.canEat(Snake, Owl)            ? "" : "not ") + "eat an owl.");
        System.out.println("Snake can "            + (ApexPredator.canEat(Snake, Bluebird)       ? "" : "not ") + "eat a bluebird.");
        System.out.println("Snake can "            + (ApexPredator.canEat(Snake, Snake2)         ? "" : "not ") + "eat an Snake2.");
        System.out.println("Snake2 can "           + (ApexPredator.canEat(Snake2, Snake)         ? "" : "not ") + "eat a snake.");
        System.out.println("Snake and Snake2 are " + (ApexPredator.siblings(Snake2, Snake)       ? "" : "not ") + "siblings");
        System.out.println("Bluebird can "         + (ApexPredator.canEat(Bluebird, Snake)       ? "" : "not ") + "eat a snake.");
        System.out.println("Bluebird can "         + (ApexPredator.canEat(Bluebird, Grasshopper) ? "" : "not ") + "eat a grasshopper.");
        System.out.println("Grasshopper can "      + (ApexPredator.canEat(Grasshopper, Bluebird) ? "" : "not ") + "eat a bluebird.");
        System.out.println("Grasshopper can "      + (ApexPredator.canEat(Grasshopper, Grass)    ? "" : "not ") + "eat a grass.");
        System.out.println("Grass can "            + (ApexPredator.canEat(Grass, Grasshopper)    ? "" : "not ") + "eat a grasshopper.");
    }
}
