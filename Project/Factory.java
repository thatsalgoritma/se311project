package Project;

// Abstract class for all cattle types
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

    // Subclasses will define how the cattle is fed
    public abstract void feed();
}

// Concrete class for dairy cattle
class DairyCattle extends Cattle {
    public DairyCattle(String id) {
        super(id);
    }

    @Override
    public void feed() {
        System.out.println("Feeding Dairy Cattle " + id + " with corn (carbs) and soybean (protein).");
    }
}

// Concrete class for beef cattle
class BeefCattle extends Cattle {
    public BeefCattle(String id) {
        super(id);
    }

    @Override
    public void feed() {
        System.out.println("Feeding Beef Cattle " + id + " with wheat (carbs) and canola (protein).");
    }
}

// Factory base class
abstract class CattleFactory {
    // Subclasses will implement how to create cattle
    public abstract Cattle createCattle(String id);
}

// Factory for dairy cattle
class DairyCattleFactory extends CattleFactory {
    @Override
    public Cattle createCattle(String id) {
        return new DairyCattle(id);
    }
}

// Factory for beef cattle
class BeefCattleFactory extends CattleFactory {
    @Override
    public Cattle createCattle(String id) {
        return new BeefCattle(id);
    }
}
