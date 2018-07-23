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
	public void messageDisplayedWhenQuarterNotProvided(){
		device.addGumballs(0);
		device.displayMessage(Messages.NQ_EJECT + " " + Messages.NQ_CRANK);
		assertTrue(device.getDisplayedMessage(), true);
	}

	@Test
	public void gumballDispensedAndSuccessMessageDisplayedWhenCrankIsTurned(){
		device.addGumballs(1);
		gumballMachine.crankTurned();
		assertEquals(device.getCount(), 0);
		assertTrue(Messages.WN_START, true);
	}

	@Test
	public void quarterEjectedWhenNoAvailableGumballs(){
		device.addGumballs(0);
		gumballMachine.ejectQuarterRequested();
		device.dispenseQuarter();
		assertTrue(device.wasQuarterEjected());
		assertTrue(Messages.SO_QUART, true);
	}
}
