package Life.Domain.Kingdom.Phylum.Class.Order.Family.Genus.Species;


import Life.Domain.Eukarya;
import Life.Domain.Kingdom.Phylum.Class.Order.Family.Genus.Loxodonta;

public class AfricanElephant extends Loxodonta {
    public AfricanElephant(double weight) {
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
