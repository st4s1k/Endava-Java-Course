public class ApexPredator {



    public static boolean canEat(ApexPredator predator, ApexPredator creature) {
        return predator.getClass().isInstance(creature) &&
                !creature.getClass().isInstance(predator);
    }

    public static boolean siblings(ApexPredator creature1, ApexPredator creature2) {
        return creature1.getClass().equals(creature2.getClass());
    }
}