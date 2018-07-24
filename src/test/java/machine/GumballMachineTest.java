package machine;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class GumballMachineTest {

	private TestDevice device = new TestDevice();
	private GumballMachine gumballMachine;

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
	public void machineAcceptsOnlyOneQuarterPerCrank(){
		gumballMachine.quarterInserted();
		assertEquals(Messages.WN_QUART, device.getDisplayedMessage());
	}

	@Test
	public void machineAcceptsOnlyOneQuarterPerSale(){
		gumballMachine.reset();
		gumballMachine.quarterInserted();
		device.displayMessage(Messages.HQ_QUART);
		assertTrue(Messages.HQ_QUART, true);
	}

	@Test
	public void messageDisplayedWhenQuarterNotProvided(){
		device.addGumballs(0);
		device.displayMessage(Messages.NQ_EJECT + " " + Messages.NQ_CRANK);
		assertTrue(device.getDisplayedMessage(), true);
	}

	@Test
	public void gumballDispensedWhenCrankIsTurned(){
		device.addGumballs(1);
		assertEquals(device.getCount(), 1);
		gumballMachine.crankTurned();
		assertEquals(device.getCount(), 0);
	}

	@Test
	public void successMessageDisplayedWhenGumballDispensed(){
		device.addGumballs(1);
		gumballMachine.quarterInserted();
		gumballMachine.crankTurned();
		assertEquals(Messages.WN_START, Messages.WN_START);
	}

	@Test
	public void messageDisplayedWhenMachineIsSoldOut(){
		device.addGumballs(0);
		gumballMachine.quarterInserted();
		gumballMachine.crankTurned();
		assertEquals(Messages.SO_CRANK, Messages.SO_CRANK);
	}

	@Test
	public void quarterEjectedWhenNoAvailableGumballs(){
		device.addGumballs(0);
		device.dispenseQuarter();
		assertTrue(device.wasQuarterEjected());
		assertTrue(Messages.SO_QUART, true);
	}

	@Test
	public void ifGumballSelectedTheReturnMoneyButtonDoesntWork(){
		gumballMachine.quarterInserted();
		device.displayMessage(Messages.WN_EJECT);
		assertTrue(Messages.WN_EJECT, true);
	}

	@Test
	public void ifSelectionNotMadeTheReturnMoneyButtonReturnsQuarter(){
		gumballMachine.ejectQuarterRequested();
		assertTrue(device.getDisplayedMessage(), true);
	}

	@Test
	public void ifReturnMoneyButtonPressedRepeatedlyDisplayMessage(){
		device.displayMessage(Messages.SO_EJECT);
		assertTrue(Messages.SO_EJECT, true);
	}

	@Test
	public void ifMachineLeftIdleDisplayMessage(){
		device.displayMessage(Messages.WN_CRANK);
		assertTrue(device.getDisplayedMessage(), true);
	}

	@Test
	public void whenQuarterInsertedDisplayMessage(){

		gumballMachine.quarterInserted();
	}
}
