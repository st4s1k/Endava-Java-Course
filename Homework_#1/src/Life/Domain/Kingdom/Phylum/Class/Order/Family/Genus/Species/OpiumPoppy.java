package Life.Domain.Kingdom.Phylum.Class.Order.Family.Genus.Species;

import Life.Domain.Eukarya;
import Life.Domain.Kingdom.Phylum.Class.Order.Family.Genus.Papaver;

public class OpiumPoppy extends Papaver {
    public OpiumPoppy(double weight) {
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
