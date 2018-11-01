package Life.Domain.Kingdom.Phylum.Class.Order.Family.Genus.Species;

import Life.Domain.Eukarya;
import Life.Domain.Kingdom.Phylum.Class.Order.Family.Genus.Plasmodium;

public class Malaria extends Plasmodium {
    public Malaria(double weight) {
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
