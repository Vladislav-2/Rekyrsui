package Test;

import machine.coffee.Americano;
import machine.machines.CoffeeMachine;
import machine.machines.CompactCoffeeMachine;
import org.junit.Assert;
import org.junit.Test;

public class CompactCoffeeMachineTest {
    @Test
    public void compactMachinePositiveTest() throws Exception {
        CoffeeMachine compact = new CompactCoffeeMachine();
        compact.fillWithCoffee(250);
        compact.fillWithWater(500);
        compact.enable();
        Americano americano = compact.makeAmericano();
        Assert.assertNotNull(americano);
    }
}
