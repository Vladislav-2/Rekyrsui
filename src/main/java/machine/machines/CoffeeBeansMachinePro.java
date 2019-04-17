package machine.machines;

import machine.coffee.Americano;
import machine.coffee.Cappuccino;
import machine.coffee.Espresso;
import machine.coffee.Late;
import machine.exceptions.*;

public class CoffeeBeansMachinePro extends AbstractCoffeeMachine {

    private int currentCoffeeBeans = 0;
    private static final int WATER_LIMIT = 2000;
    private static final int COFFEE_LIMIT = 1100;
    private static final int MILK_LIMIT = 1000;
    private static final int BEANS_LIMIT = 1000;

    {
        TANK_CAPACITY = 1000;
    }

    public CoffeeBeansMachinePro() {
        super();
    }

    public CoffeeBeansMachinePro(int coffee, int water, int milk) {
        super(coffee, water, milk);
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

    public void geterCoffeeBeans() {
        if (!isRunning()) {
            return;
        }
        if (getCurrentCoffee() + currentCoffeeBeans <= getCoffeeLimit()) {
            setCurrentCoffee(currentCoffeeBeans + getCurrentCoffee());
            currentCoffeeBeans = 0;
        }
    }

    public void fillWithBeans(int quantityInGramm) {
        if (quantityInGramm + currentCoffeeBeans > getBeansLimit()){
            currentCoffeeBeans = getBeansLimit();
        } else {
            currentCoffeeBeans += quantityInGramm;
        }
    }

    public Late makeLate(int x) throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 22 gramm coffee
        // use 33 ml water
        if (getCurrentCoffee() < 22) {
            throw new NoCoffeeBeansExcepton();
        }
        if (getCurrentWater() < 33) {
            throw new NoWaterException();
        }
        if (getMilkLimit() < x) {
            throw new NoMilkExcepction();
        }
        collectGarbage(20);
        setCurrentCoffee(currentCoffeeBeans - 22);
        setCurrentWater(getCurrentWater() - 33);
        setCurrentMilk(getCurrentMilk() - x);
        return new Late();
    }

    public Cappuccino makeCappuccino(int x) throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 22 gramm coffee
        // use 33 ml water
        // use x ml milk
        if (getCurrentCoffee() < 22) {
            throw new NoCoffeeBeansExcepton();
        }
        if (getCurrentWater() < 33) {
            throw new NoWaterException();
        }
        if (getMilkLimit() < x){
            throw new NoMilkExcepction();
        }
        collectGarbage(20);
        setCurrentCoffee(currentCoffeeBeans - 22);
        setCurrentWater(getCurrentWater() - 33);
        setCurrentMilk(getCurrentMilk() - x);
        return new Cappuccino();
    }

    public Americano makeAmericano() throws CoffeeMachineException {
        if (!isRunning()){
            return null;
        }
        // use 20 gramm coffee
        // use 120 ml water
        if (getCurrentCoffee() < 20){
            throw new NoCoffeeBeansExcepton();
        }
        if (getCurrentWater() < 120){
            throw new NoWaterException();
        }
        collectGarbage(20);
        setCurrentCoffee(getCurrentCoffee() - 20);
        setCurrentWater(getWaterLimit() - 120);
        return new Americano();
    }

    public Espresso makeEspresso() throws CoffeeMachineException {
        if (!isRunning()){
            return null;
        }

        // use 20 gramm coffee
        // use 33 ml water
        if (getCurrentWater() > 33){
            throw new NoWaterException();
        }
        if (getCurrentCoffee() > 22){
            throw new NoCoffeeBeansExcepton();
        }
        collectGarbage(22);
        setCurrentWater(getWaterLimit() - 33);
        setCurrentCoffee(getCurrentCoffee() - 22);
        return new Espresso();
    }

}
