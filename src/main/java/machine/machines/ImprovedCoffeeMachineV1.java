package machine.machines;
import machine.coffee.Cappuccino;
import machine.coffee.Late;
import machine.exceptions.CoffeeMachineException;
import machine.exceptions.NoCoffeeException;
import machine.exceptions.NoMilkExcepction;
import machine.exceptions.NoWaterException;
import machine.coffee.Americano;
import machine.coffee.Espresso;

public class ImprovedCoffeeMachineV1 extends AbstractCoffeeMachine{

    private static final int WATER_LIMIT = 2000;
    private static final int COFFEE_LIMIT = 800;
    private static final int MILK_LIMIT = 500;

    {
        TANK_CAPACITY = 800;
    }

    public ImprovedCoffeeMachineV1() {
        super();
    }

    public ImprovedCoffeeMachineV1(int coffee, int water, int milk) {
        super(coffee, water, milk);
    }

    int getWaterLimit() {
        return WATER_LIMIT;
    }

    int getCoffeeLimit() {
        return COFFEE_LIMIT;
    }

    int getMilkLimit() { return MILK_LIMIT; }

    public Late makeLate(int x) throws CoffeeMachineException {
        if (!isRunning()) {
            return null;
        }
        // use 22 gramm coffee
        // use 30 ml water
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        if (getCurrentCoffee() < 22) {
            throw new NoCoffeeException();
        }
        if (getMilkLimit() < x){
            throw new NoMilkExcepction();
        }
        collectGarbage(20);
        setCurrentCoffee(getCurrentCoffee() - 22);
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
        if (getCurrentWater() < 30) {
            throw new NoWaterException();
        }
        if (getCurrentCoffee() < 22) {
            throw new NoCoffeeException();
        }
        if (getMilkLimit() < x){
            throw new NoMilkExcepction();
        }
        collectGarbage(20);
        setCurrentCoffee(getCurrentCoffee() - 22);
        setCurrentWater(getCurrentWater() - 30);
        setCurrentMilk(getCurrentMilk() - x);
        return new Cappuccino();
    }


    public Americano makeAmericano() throws CoffeeMachineException {
        if (!isRunning()){
            return null;
        }
        // use 20 gramm coffee
        // use 100 ml water
        if (getCurrentWater() < 20){
            throw new NoCoffeeException();
        }
        if (getCurrentCoffee() < 100){
            throw new NoWaterException();
        }
        collectGarbage(20);
        setCurrentCoffee(getCurrentCoffee() - 20);
        setCurrentWater(getWaterLimit() - 100);
        return new Americano();
    }

    public Espresso makeEspresso() throws CoffeeMachineException {
        if (!isRunning()){
            return null;
        }

        // use 20 gramm coffee
        // use 30 ml water
        if (getCurrentCoffee() > 20){
            throw new NoCoffeeException();
        }
        if (getCurrentWater() > 30){
            throw new NoWaterException();
        }
        collectGarbage(20);
        setCurrentWater(getWaterLimit() - 30);
        setCurrentCoffee(getCurrentCoffee() - 20);
        return new Espresso();
    }

}
