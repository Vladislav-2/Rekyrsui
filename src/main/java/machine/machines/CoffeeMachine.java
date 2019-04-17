package machine.machines;
import machine.coffee.Americano;
import machine.coffee.Espresso;
import machine.coffee.Late;
import machine.coffee.Cappuccino;
import machine.exceptions.CoffeeMachineException;

public interface CoffeeMachine {

    void enable();

    void disable();

    Espresso makeEspresso() throws CoffeeMachineException;

    Americano makeAmericano() throws CoffeeMachineException;

    Cappuccino makeCappuccino(int x) throws CoffeeMachineException;

    Late makeLate(int x) throws CoffeeMachineException;

    void cleanUp();

    void fillWithWater(int quantityInMl);

    void fillWithCoffee(int quantityInGrams);

    void fillWithMilk(int quantityInMl);
}
