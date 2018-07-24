package machine;

public class GumballMachine {

	private GumballHardwareDevice device;

	public GumballMachine(GumballHardwareDevice device) {
		this.device = device;
		device.displayMessage(Messages.SO_START);
	}


	public void quarterInserted() {
		boolean quarterInserted = device.totalGumballCount() > 0;
		if(quarterInserted){
			device.displayMessage(Messages.WN_QUART);
		} else {
			device.displayMessage(Messages.NQ_CRANK);
		}
	}


	public void ejectQuarterRequested() {
		device.displayMessage(Messages.HQ_EJECT);
	}

	public void crankTurned() {
		int tgb = device.totalGumballCount();
		boolean crank = device.dispenseGumball();
		if (tgb >= 2 && crank){
			device.displayMessage(Messages.WN_START);
		} else if (crank && tgb == 1){
			device.displayMessage(Messages.SO_START);
		} else {
			device.displayMessage(Messages.SO_CRANK);
		}
	}

	public void reset() {
		device.dispenseQuarter();
	}
}
