package Project;

 abstract class Cattle {
    protected String id;
    protected Integer distanceToFarm;
    protected boolean hasVaccinated;

    public Cattle(String id) {
        this.id = id;
        this.distanceToFarm = 0;
        hasVaccinated = false;
    }

    public String getId() {
        return id;
    }
    public int getDistanceToFarm() {
        return distanceToFarm;
    }
    public boolean hasVaccinated() {
        return hasVaccinated;
    }

    public abstract void feed();
}
 class DairyCattle extends Cattle {

    public DairyCattle(String id) {
        super(id);
        hasVaccinated = false;
    }

    @Override
    public void feed() {
        System.out.println("Feeding Dairy Cattle " + id + " with corn (carbs) and soybean (protein).");
    }
}
class BeefCattle extends Cattle {

    public BeefCattle(String id) {
        super(id);
        hasVaccinated = false;
    }

    @Override
    public void feed() {
        System.out.println("Feeding Beef Cattle " + id + " with wheat (carbs) and canola (protein).");
    }
}
abstract class CattleFactory {
    public abstract Cattle createCattle(String id);
}
class DairyCattleFactory extends CattleFactory {

    @Override
    public Cattle createCattle(String id) {
        return new DairyCattle(id);
    }
}
class BeefCattleFactory extends CattleFactory {

    @Override
    public Cattle createCattle(String id) {
        return new BeefCattle(id);
    }
}