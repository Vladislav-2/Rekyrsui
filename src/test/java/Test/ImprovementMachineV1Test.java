package Test;

import machine.coffee.Late;
import machine.machines.CoffeeMachine;
import machine.machines.ImprovedCoffeeMachineFullEdition;
import org.junit.Assert;
import org.junit.Test;

public class ImprovementMachineV1Test {

    @Test
    public void isImprovementMachineV1Right() throws Exception{
        CoffeeMachine improvementV1 = new ImprovedCoffeeMachineFullEdition();
        improvementV1.fillWithCoffee(800);
        improvementV1.fillWithWater(2000);
        improvementV1.fillWithMilk(500);
        improvementV1.enable();
        Late late = improvementV1.makeLate(20);
        Assert.assertNotNull(late);
    }
}
