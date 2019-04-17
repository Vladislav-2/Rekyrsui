package machine.machines;

import machine.coffee.Americano;
import machine.coffee.Cappuccino;
import machine.coffee.Espresso;
import machine.coffee.Late;
import machine.exceptions.*;

public class CoffeeBeansMachine extends AbstractCoffeeMachine {

    private int currentCoffeeBeans = 0;
    private static final int WATER_LIMIT = 2000;
    private static final int COFFEE_LIMIT = 1000;
    private static final int MILK_LIMIT = 1000;
    private static final int BEANS_LIMIT = 800;

    {
        TANK_CAPACITY = 800;
    }

    public CoffeeBeansMachine() {
        super();
    }

    public CoffeeBeansMachine(int coffee, int water, int milk) {
        super(coffee, water, milk);
    }

    public void geterCoffeeBeans(int beansInQuantityGramm) {
        if (!isRunning()) {
            return;
        }
        if (getCurrentCoffee() + beansInQuantityGramm <= getCoffeeLimit()) {
            setCurrentCoffee(currentCoffeeBeans + beansInQuantityGramm);
        }
    }

    public void fillWithBeans(int quantityInGramm) {
        if (quantityInGramm + currentCoffeeBeans > getBeansLimit()){
            currentCoffeeBeans = getBeansLimit();
        } else {
            currentCoffeeBeans += quantityInGramm;
        }
    }

    int getBeansLimit() {
        return BEANS_LIMIT;
    }

    int getWaterLimit() {
        return WATER_LIMIT;
    }

    int getCoffeeLimit() {
        return COFFEE_LIMIT;
    }

    int getMilkLimit() {
        return MILK_LIMIT;
    }

    public Late makeLate(int x) throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 22 gramm coffee
        // use 30 ml water
        if (getCurrentCoffee() < 22) {
            throw new NoCoffeeBeansExcepton();
        }
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        if (getMilkLimit() < x) {
            throw new NoMilkExcepction();
        }
        collectGarbage(20);
        setCurrentCoffee(currentCoffeeBeans - 22);
        setCurrentWater(getCurrentWater() - 30);
        setCurrentMilk(getCurrentMilk() - x);
        return new Late();
    }

    public Cappuccino makeCappuccino(int x) throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 22 gramm coffee
        // use 30 ml water
        // use x ml milk
        if (getCurrentCoffee() < 22) {
            throw new NoCoffeeBeansExcepton();
        }
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        if (getMilkLimit() < x){
            throw new NoMilkExcepction();
        }
        collectGarbage(20);
        setCurrentCoffee(currentCoffeeBeans - 22);
        setCurrentWater(getCurrentWater() - 30);
        setCurrentMilk(getCurrentMilk() - x);
        return new Cappuccino();
    }

    public Americano makeAmericano() throws CoffeeMachineException {
        if (!isRunning()){
            return null;
        }
        // use 20 gramm coffee
        // use 110 ml water
        if (getCurrentCoffee() < 20){
            throw new NoCoffeeBeansExcepton();
        }
        if (getCurrentWater() < 110){
            throw new NoWaterException();
        }
        collectGarbage(20);
        setCurrentCoffee(getCurrentCoffee() - 20);
        setCurrentWater(getWaterLimit() - 110);
        return new Americano();
    }

    public Espresso makeEspresso() throws CoffeeMachineException {
        if (!isRunning()){
            return null;
        }

        // use 22 gramm coffee
        // use 30 ml water
        if (getCurrentWater() > 30){
            throw new NoWaterException();
        }
        if (getCurrentCoffee() > 22){
            throw new NoCoffeeBeansExcepton();
        }
        collectGarbage(22);
        setCurrentWater(getWaterLimit() - 30);
        setCurrentCoffee(getCurrentCoffee() - 22);
        return new Espresso();
    }

}
