/*
 * Class: Burner, methods for stove class simulation. Display() to print to console current state of burner. getMyTemperature() as a getter
 * for the current temperature of the burner. plusButton() to increase the setting of the burner. minusButton to decrease. updateTemperature
 * for Stove logic. Helper function changeTemp included for logic.
 * Author(s): Matthew Jackson, Sam Bangapadang
 * Date: 1/29/2024
 * Collaborators: N/A
 * Sources: N/A
 */

public class Burner {
	// enum type for burner temperature
	public enum Temperature {
		BLAZING, HOT, WARM, COLD;
		
		// toString method returns description of state
		@Override
		public String toString() {
			switch(this) {
			case BLAZING:
				return "VERY HOT! DON'T TOUCH";
			case HOT:
				return "CAREFUL";
			case WARM:
				return "warm";
			case COLD:
				return "cooool";
			default:
				return "Unknown Temp";
			}
		}
	}
	
	// initialize time, current temperature, setting, for burner object
	public static final int TIME_DURATION = 2;
	
	private Temperature curTemp;
	private Setting curSetting;
	private int timer;
	
	// initial state of burner - constructor 
	public Burner() {
		curTemp = Temperature.COLD;
		curSetting = Setting.OFF;
		timer = 0;
	}

	// display current state of burner
	public void display() {
		System.out.println("[" + curSetting + "]....." + curTemp);;
	}
	
	public Temperature getMyTemperature() {
		return curTemp;
	}
	
	// increase setting of burner
	public void plusButton() {
        switch (curSetting) {
            case OFF -> curSetting = Setting.LOW;
            case LOW -> curSetting = Setting.MEDIUM;
            case MEDIUM -> curSetting = Setting.HIGH;
            // if already HIGH, do nothing
        }
		timer = TIME_DURATION;
    }
	
	// decrease setting of burner
	public void minusButton() {
        switch (curSetting) {
            case MEDIUM -> curSetting = Setting.LOW;
            case HIGH -> curSetting = Setting.MEDIUM;
            case LOW -> curSetting = Setting.OFF;
            // if already OFF, do nothing
        }
		timer = TIME_DURATION;
    }
	
	// decrement timer and change temperature
	public void updateTemperature() {
		timer--;
		if (timer <= 0) {
			changeTemp();
		}
	}
	
	// helper function for updateTemperature()
	private void changeTemp() {
		
		switch (curSetting) {
			// heat if temp is below blazing
			case HIGH:
				timer = TIME_DURATION;
				switch (curTemp) {
					case BLAZING -> timer = 0;
					case HOT -> curTemp = Temperature.BLAZING; 
					case WARM -> curTemp = Temperature.HOT; 
					case COLD -> curTemp = Temperature.WARM; 
				}
				break;
				// heat if temp is below hot
				// cool if bazing
			case MEDIUM:
				timer = TIME_DURATION;
				switch (curTemp) {
					case BLAZING -> curTemp = Temperature.HOT;
					case HOT -> timer = 0; 
					case WARM -> curTemp = Temperature.HOT; 
					case COLD -> curTemp = Temperature.WARM; 
				}
				break;
				// heat if temp is below warm
				// cool if hot
			case LOW:
				timer = TIME_DURATION;
				switch (curTemp) {
					case BLAZING -> curTemp = Temperature.HOT;
					case HOT -> curTemp = Temperature.WARM; 
					case WARM -> timer = 0; 
					case COLD -> curTemp = Temperature.WARM; 
				}
				break;
				// cool if temp above cold
			case OFF:
				timer = TIME_DURATION;
				switch (curTemp) {
					case BLAZING:
						curTemp = Temperature.HOT;
						break;
					case HOT:
						curTemp = Temperature.WARM;
						break;
					case WARM: 
						curTemp = Temperature.COLD; 
						timer = 0;
						break;
					case COLD:
						timer = 0; 
						break;
				}
				break;
		}
	}
}
