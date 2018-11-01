package Life.Domain.Kingdom.Phylum.Class.Order.Family.Genus.Species;

import Life.Domain.Eukarya;
import Life.Domain.Kingdom.Phylum.Class.Order.Family.Genus.Trypanosoma;

public class KissingBug extends Trypanosoma {
    public KissingBug(double weight) {
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
