public class ApexPredator {



    public boolean canEat(ApexPredator creature) {
        return this.getClass().isInstance(creature) &&
                !creature.getClass().isInstance(this);
    }

    public boolean siblings(ApexPredator creature) {
        return this.getClass().equals(creature.getClass());
    }
}