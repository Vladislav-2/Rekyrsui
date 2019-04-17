package machine.machines;

import machine.coffee.Cappuccino;
import machine.coffee.Late;
import machine.exceptions.CoffeeMachineException;
import machine.exceptions.NoCoffeeException;
import machine.exceptions.NoInacilisetion;
import machine.exceptions.NoWaterException;
import machine.coffee.Americano;
import machine.coffee.Espresso;

public class BusinessCoffeeMachine extends AbstractCoffeeMachine {

    private static final int WATER_LIMIT = 10000;
    private static final int COFFEE_LIMIT = 2000;

    {
        TANK_CAPACITY = 750;
    }

    public BusinessCoffeeMachine() {
        super();
    }

    public BusinessCoffeeMachine(int coffee, int water) {
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
        if (getCurrentCoffee() < 50) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 50) {
            throw new NoWaterException();
        }
        // use 50 gramm coffee
        // use 50 ml water
        collectGarbage(50);
        setCurrentCoffee(getCurrentCoffee() - 50);
        setCurrentWater(getCurrentWater() - 50);
        return new Espresso();
    }

    public Americano makeAmericano() throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 50 gramm coffee
        // use 150 ml water
        if (getCurrentCoffee() < 50) {
            throw new NoCoffeeException();
        }
        if (getCurrentWater() < 150) {
            throw new NoWaterException();
        }
        collectGarbage(50);
        setCurrentCoffee(getCurrentCoffee() - 50);
        setCurrentWater(getCurrentWater() - 150);
        return new Americano();
    }

    public Cappuccino makeCappuccino(int x) throws CoffeeMachineException {
        throw new NoInacilisetion();
    }

    public Late makeLate(int x) throws CoffeeMachineException {
        throw new NoInacilisetion();
    }
}
