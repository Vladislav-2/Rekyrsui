package machine.machines;

import machine.coffee.Cappuccino;
import machine.coffee.Late;
import machine.exceptions.NoCoffeeException;
import machine.exceptions.NoInacilisetion;
import machine.exceptions.NoWaterException;
import machine.coffee.Americano;
import machine.coffee.Espresso;
import machine.exceptions.CoffeeMachineException;

public class CompactCoffeeMachine extends AbstractCoffeeMachine {

    private static final int WATER_LIMIT = 500;
    private static final int COFFEE_LIMIT = 250;

    public CompactCoffeeMachine() {
        super();
    }

    public CompactCoffeeMachine(int coffee, int water) {
        super(coffee, water);
    }

    {
        TANK_CAPACITY = 250;
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
        if (getCurrentCoffee() < 20) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
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
        if (getCurrentCoffee() < 20) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 100) {
            throw new NoWaterException();
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
