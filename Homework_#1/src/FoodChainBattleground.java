public class FoodChainBattleground {
    public static void main (String[] args) {
        ApexPredator        Owl         = new ApexPredator(        "Maga",  99, "Great Horned Owl");
        TertiaryConsumer    Snake       = new TertiaryConsumer(    "Zina",  40, "Cobra");
        SecondaryConsumer   Bluebird    = new SecondaryConsumer( "Karton",  15, "SlojnoPridumat");
        PrimaryConsumer     Grasshopper = new PrimaryConsumer( "Cucumber",   5, "Kuznecik");
        Producer            Grass       = new Producer(           "Trava", 100, "Zelenaya");

        System.out.println("Owl can " + (Owl.canBeEatenBy(Snake) ? "" : "not ") + "be eaten by snake.");
    }
}
