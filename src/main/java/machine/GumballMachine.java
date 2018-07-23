package machine;

public class GumballMachine {

	private GumballHardwareDevice device;

	public GumballMachine(GumballHardwareDevice device) {
		this.device = device;
		device.displayMessage(Messages.SO_START);
	}

	public void quarterInserted() {
		device.displayMessage(Messages.WN_QUART);
	}

	public void ejectQuarterRequested() {
		device.displayMessage(Messages.SO_QUART);
	}

	public void crankTurned() {
		device.dispenseGumball();
		device.displayMessage(Messages.WN_START);
	}

	public void reset() {
	}
}
