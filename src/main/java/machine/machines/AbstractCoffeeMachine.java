package machine.machines;

import machine.exceptions.CoffeeMachineException;
import machine.exceptions.NoTankCapacityException;

public abstract class AbstractCoffeeMachine implements CoffeeMachine {

    private int currentCoffee;
    private int currentWater;
    private int currentMilk;
    private int mudTank;
    protected int TANK_CAPACITY;
    private boolean isRunning;

    /**
     * Creates EMPTY coffee machine.
     */
    public AbstractCoffeeMachine() {
        this.currentCoffee = 0;
        this.currentWater = 0;
    }

    {
        mudTank = 0;
    }

    public AbstractCoffeeMachine(int coffee, int water) {
        if (coffee > this.getCoffeeLimit()) {
            this.currentCoffee = this.getCoffeeLimit();
        }
        if (water > this.getWaterLimit()) {
            this.currentWater = this.getWaterLimit();
        }
    }

    public  AbstractCoffeeMachine(int coffee, int water, int milk){
        if (coffee > this.getCoffeeLimit()) {
            this.currentCoffee = this.getCoffeeLimit();
        }
        if (water > this.getWaterLimit()) {
            this.currentWater = this.getWaterLimit();
        }
        if (milk > this.getMilkLimit()){
            this.currentMilk = this.getMilkLimit();
        }
    }

    public void enable() {
        if (isRunning == false) {
            isRunning = true;
        }
    }

    public void disable() {
        isRunning = false;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void cleanUp() {
        mudTank = 0;
    }

    public void fillWithWater(int quantityInMl) {
        if (quantityInMl + currentWater > getWaterLimit()) {
            currentWater = getWaterLimit();
        } else {
            currentWater += quantityInMl;
        }
    }

    public void fillWithCoffee(int quantityInGrams) {
        if (quantityInGrams + currentWater > getCoffeeLimit()) {
            currentCoffee = getCoffeeLimit();
        } else {
            currentCoffee += quantityInGrams;
        }
    }

    public void fillWithMilk(int quantityInMl){
        if (quantityInMl + currentMilk > getMilkLimit()){
            currentMilk = getCurrentMilk();
        } else {
            currentMilk += quantityInMl;
        }
    }

    abstract int getWaterLimit();

    abstract int getCoffeeLimit();

    abstract int getMilkLimit();

    boolean availableTankCapacity(int valueToAdd) {
        return mudTank + valueToAdd < TANK_CAPACITY;
    }

    void collectGarbage(int valueToAdd) throws CoffeeMachineException {
        if (availableTankCapacity(valueToAdd)) {
            mudTank += valueToAdd;
        } else {
            throw new NoTankCapacityException();
        }

    }

    public int getCurrentCoffee() {
        return currentCoffee;
    }

    public int getCurrentWater() {
        return currentWater;
    }

    public int getCurrentMilk() { return currentMilk; }

    public void setCurrentCoffee(int currentCoffee) {
        this.currentCoffee = currentCoffee;
    }

    public void setCurrentWater(int currentWater) {
        this.currentWater = currentWater;
    }

    public void setCurrentMilk(int currentMilk) { this.currentMilk = currentMilk;}
}
