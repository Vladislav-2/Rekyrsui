package Test;

import machine.coffee.Cappuccino;
import machine.machines.CoffeeBeansMachinePro;
import machine.machines.CoffeeMachine;
import org.junit.Assert;
import org.junit.Test;

public class CoffeeBeansMachineProTest {

    @Test
    public void CoffeeBeansMachineProRight() throws Exception{
        CoffeeMachine beansMachine = new CoffeeBeansMachinePro();
        beansMachine.fillWithCoffee(99999);
        beansMachine.fillWithWater(99999);
        beansMachine.fillWithMilk(99999);
        beansMachine.enable();
        Cappuccino cappuccino = beansMachine.makeCappuccino(20);
        Assert.assertNotNull(cappuccino);
    }
}
