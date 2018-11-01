package Life.Domain.Kingdom.Phylum.Class.Order.Family.Genus.Species;

import Life.Domain.Eukarya;
import Life.Domain.Kingdom.Phylum.Class.Order.Family.Genus.Morchella;

public class Morel extends Morchella {
    public Morel(double weight) {
        super(weight);
    }

    @Override
    public void eat(Eukarya food) {

    }

    @Override
    public void excrete() {

    }

    @Override
    public Eukarya reproduce(Eukarya partner) {
        return null;
    }
}
