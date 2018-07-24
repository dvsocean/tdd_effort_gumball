package machine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GumballMachineTest {

	private TestDevice device = new TestDevice();
	private GumballMachine gumballMachine;

	public TestDevice getDevice() {
		return device;
	}

	@Before
	public void setup() {
		gumballMachine = new GumballMachine(device);
	}

	@Test
	public void initialConditionsEmptyMachineShouldShowSO_StartMessage() {
		assertEquals(Messages.SO_START, device.getDisplayedMessage());
	}

	@Test
	public void initialConditionsEmptyMachineShouldNotDispenseQuarter() {
		assertFalse(device.wasQuarterEjected());
	}

	@Test
	public void initialConditionsDontTreatMeLikeASlutMachine(){
		gumballMachine.ejectQuarterRequested();
		gumballMachine.ejectQuarterRequested();
		gumballMachine.ejectQuarterRequested();
		device.displayMessage(Messages.SO_EJECT);
	}

	@Test
	public void initialConditionsMachineIsSoldOut(){
		device.addGumballs(1);
		gumballMachine.quarterInserted();
		gumballMachine.crankTurned();
		device.displayMessage(Messages.SO_CRANK);
	}

	//----------------------------------------------------------

	@Test
	public void initialConditionsMessageDisplayed(){

	}

	@Test
	public void displayMessageIfCrankTurnedWithNoQuarter(){

	}

	@Test
	public void displayMessageWhenQuarterIsNotReturnedUponEjectButton(){

	}

	@Test
	public void displayMessageWhenCrankIsTurnedWithoutAQuarter(){

	}

	//------------------------------------------------------------

	@Test
	public void displayMessageWhenQuarterIsPresentButCrankNotYetTurned(){

	}

	@Test
	public void displayMessageIfUserAttempsToInsertASecondQuarter(){

	}

	@Test
	public void displayMessageWhenEjectQuarterBUttonHasBeenPressed(){

	}

	@Test
	public void displayMessageWhenQaurterInsertedAndCrankTurned(){

	}

	//-------------------------------------------------------------

	@Test
	public void winSituationDisplayMessageIfWinner(){

	}

	@Test
	public void winSituationDisplayMessageIfWinnerAttempsToInsertAnotherQuarter(){

	}

	@Test
	public void winSituationDisplayMessageIfWinnerPressesTheEjectBUtton(){

	}

	@Test
	public void winSituationDisplayMessageIfWinnerTurnsTheCrank(){

	}


}
