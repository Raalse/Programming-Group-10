package ss.week1;

public class Lampy {
	public enum States { OFF, LOW, MED, HIGH };
	public States setting;
	
	public Lampy(States setting) {
		this.setting = setting;
	}
	
	
	//Returns the current Setting of the Lamp.
	public int getSetting() {
		switch (setting) {
			case OFF:
				return 0;
			case LOW:
				return 1;
			case MED:
				return 2;
			case HIGH:
				return 3;
			default:
				return 0;
		}
	}
	
	//Switches the Lamp to its next Setting, going back to 0 if it's the case.
	public void switchSetting() {
		switch (setting) {
			case OFF:
				setting = States.LOW;
				break;
			case LOW:
				setting = States.MED;
				break;
			case MED:
				setting = States.HIGH;
				break;
			case HIGH:
				setting = States.OFF;
				break;
			default:
				setting = States.OFF;
				break;
		}
	}
}