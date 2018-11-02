package Life.Domain;

public class Eukarya {
    protected double weight;
    protected final long DNA;
    protected boolean alive;

    protected static long count;

    public Eukarya(double weight) {
        this.DNA = ++count;
        this.alive = true;
        this.weight = weight;
    }

    public void eat(Eukarya food){
        this.weight += food.weight;

    }

    public void excrete() {
        this.weight -= Math.random();
    }

    public Eukarya reproduce() {
        this.weight /= 2;
        return new Eukarya(this.weight);
    }

    public void die() {
        this.alive = false;
    }
}
