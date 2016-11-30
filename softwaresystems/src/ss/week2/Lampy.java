package ss.week2;

public class Lampy {
	
	// ------------------ Instance variables ----------------
	
	public enum States { OFF, LOW, MED, HIGH };
	public States setting;
	
	// ------------------ Constructor ------------------------

    /**
     * Creates a <code>Lampy</code> with the pre-provided states.
     * @param setting the possible settings of this <code>Lampy</code>
     */
	
	public Lampy(States setting) {
		this.setting = setting;
	}
	
	// ------------------ Queries --------------------------
	
	//@ ensures this.setting == States.LOW || this.setting == States.MED || this.setting == States.HIGH || this.setting == States.OFF;
	// Returns the current Setting of the Lamp.
	/** @pure */ public int getSetting() {
		assert this.setting == States.LOW || this.setting == States.MED ||  this.setting == States.HIGH ||  this.setting == States.OFF;
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
	
	// ------------------ Commands --------------------------
	
	/**
	 * @ensures \old(this.setting == States.OFF) ==> this.setting == States.LOW;
	 * @ensures \old(this.setting == States.LOW) ==> this.setting == States.MED;
	 * @ensures \old(this.setting == States.MED) ==> this.setting == States.HIGH;
	 * @ensures \old(this.setting == States.HIGH) ==> this.setting == States.OFF;
	 */
	//Switches the Lamp to its next Setting, going back to 0 if it's the case.
	public void switchSetting() {
		assert this.setting == States.LOW || this.setting == States.MED ||  this.setting == States.HIGH ||  this.setting == States.OFF;
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