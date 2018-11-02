public class FoodChainBattleground {
    public static void main (String[] args) {
        ApexPredator        Owl         = new ApexPredator(        "Maga",  99, "Great Horned Owl");
        TertiaryConsumer    Snake       = new TertiaryConsumer(    "Zina",  40, "Cobra");
        TertiaryConsumer    Snake2      = new TertiaryConsumer(    "Zina",  40, "Cobra");
        SecondaryConsumer   Bluebird    = new SecondaryConsumer( "Karton",  15, "SlojnoPridumat");
        PrimaryConsumer     Grasshopper = new PrimaryConsumer( "Cucumber",   5, "Kuznecik");
        Producer            Grass       = new Producer(           "Trava", 100, "Zelenaya");

        System.out.println("Owl can "         + (Owl.canEat(Snake)            ? "" : "not ") + "eat a snake.");
        System.out.println("Snake can "       + (Snake.canEat(Owl)            ? "" : "not ") + "eat an owl.");
        System.out.println("Snake can "       + (Snake.canEat(Bluebird)       ? "" : "not ") + "eat a bluebird.");
        System.out.println("Bluebird can "    + (Bluebird.canEat(Snake)       ? "" : "not ") + "eat a snake.");
        System.out.println("Bluebird can "    + (Bluebird.canEat(Grasshopper) ? "" : "not ") + "eat a grasshopper.");
        System.out.println("Grasshopper can " + (Grasshopper.canEat(Bluebird) ? "" : "not ") + "eat a bluebird.");
        System.out.println("Grasshopper can " + (Grasshopper.canEat(Grass)    ? "" : "not ") + "eat a grass.");
        System.out.println("Grass can "       + (Grass.canEat(Grasshopper)    ? "" : "not ") + "eat a grasshopper.");
    }
}
