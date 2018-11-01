package Life.Domain;

public abstract class Eukarya {
    protected double weight;
    protected final long DNA;
    protected static long count;

    public Eukarya(double weight) {
        DNA = ++count;
        this.weight = weight;
    }

    public abstract void eat(Eukarya food);

    public abstract void excrete();

    public abstract Eukarya reproduce(Eukarya partner);
}
