package Test;

import machine.machines.CoffeeMachine;
import machine.coffee.Espresso;
import machine.exceptions.CoffeeMachineException;
import machine.exceptions.NoCoffeeException;
import machine.machines.BusinessCoffeeMachine;
import org.junit.Assert;
import org.junit.Test;

public class BusinessCoffeeMachineTest {

    @Test
    public void espressoPositiveTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(50);
        business.fillWithWater(200);
        business.enable();
        //When
        Espresso espresso = business.makeEspresso();
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test
    public void espressoNegativeTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(10);
        business.fillWithWater(200);
        business.enable();
        //When
        Espresso espresso;
        try {
            espresso = business.makeEspresso();
        } catch (CoffeeMachineException exceptionVariableName) {
            if (exceptionVariableName instanceof NoCoffeeException) {
                business.fillWithCoffee(100);
            }
            espresso = business.makeEspresso();
        }
        //Then
        Assert.assertNotNull(espresso);
    }

    @Test(expected = AssertionError.class)
    public void espressoNegativeRealizedTest() throws Exception {
        //Given
        CoffeeMachine business = new BusinessCoffeeMachine();
        business.fillWithCoffee(1000);
        business.fillWithWater(20000);
        business.enable();
        //When
        Espresso espresso = null;
        int i = 0;
        while (i < 14) {
            espresso = business.makeEspresso();
            i++;
        }
        //Then
        Assert.assertTrue(espresso == null);
    }
}