public class ApexPredator {
    private String name;
    private int age;
    private String breed;

    public ApexPredator(String name, int age, String breed) {
        this.name = name;
        this.age = age;
        this.breed = breed;
    }

    public boolean canEat(ApexPredator creature) {
        return this.getClass().isInstance(creature) &&
                !creature.getClass().isInstance(this);
    }

    public boolean siblings(ApexPredator creature) {
        return this.getClass().equals(creature.getClass());
    }
}