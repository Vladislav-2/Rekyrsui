package machine.machines;
import machine.coffee.Cappuccino;
import machine.coffee.Late;
import machine.exceptions.CoffeeMachineException;
import machine.exceptions.NoCoffeeException;
import machine.exceptions.NoInacilisetion;
import machine.exceptions.NoWaterException;
import machine.coffee.Americano;
import machine.coffee.Espresso;

public class EconomCoffeeMachine extends AbstractCoffeeMachine {

    private static final int WATER_LIMIT = 1000;
    private static final int COFFEE_LIMIT = 200;

    {
        TANK_CAPACITY = 500;
    }

    public EconomCoffeeMachine() {
        super();
    }

    public EconomCoffeeMachine(int coffee, int water) {
        super(coffee, water);
    }

    int getWaterLimit() {
        return WATER_LIMIT;
    }

    int getCoffeeLimit() {
        return COFFEE_LIMIT;
    }

    int getMilkLimit() { return 0; }

    public Espresso makeEspresso() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 20 gramm coffee
        // use 30 ml water
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        if (getCurrentCoffee() < 20) {
            throw new NoCoffeeException();
        }
        collectGarbage(20);
        setCurrentCoffee(getCurrentCoffee() - 20);
        setCurrentWater(getCurrentWater() - 30);
        return new Espresso();
    }

    public Americano makeAmericano() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 20 gramm coffee
        // use 100 ml water
        if (getCurrentWater() < 100) {
            throw new NoWaterException();
        }
        if (getCurrentCoffee() < 20) {
            throw new NoCoffeeException();
        }
        collectGarbage(20);
        setCurrentCoffee(getCurrentCoffee() - 20);
        setCurrentWater(getCurrentWater() - 100);
        return new Americano();
    }

    public Cappuccino makeCappuccino(int x) throws CoffeeMachineException {
        throw new NoInacilisetion();
    }

    public Late makeLate(int x) throws CoffeeMachineException {
        throw new NoInacilisetion();
    }
}
