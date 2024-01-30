
public class Burner {
	public enum Temperature {
		BLAZING, HOT, WARM, COLD;
		
		@Override
		public String toString() {
			switch(this) {
			case BLAZING:
				return "VERY HOT! DON'T TOUCH";
			case HOT:
				return "CAREFUL";
			case WARM:
				return "warn";
			case COLD:
				return "cooool";
			default:
				return "Unknown Temp";
			}
		}
	}
	
	public static final int TIME_DURATION = 2;
	
	private Temperature curTemp;
	private Setting curSetting;
	private int timer;
	
	public Burner() {
		curTemp = Temperature.COLD;
		curSetting = Setting.OFF;
		timer = 0;
	}
	
	public void display() {
		System.out.println(curSetting + "....." + curTemp);;
	}
	
	public Temperature getMyTemperature() {
		return curTemp;
	}
	
	public void plusButton() {
        switch (curSetting) {
            case OFF -> curSetting = Setting.LOW;
            case LOW -> curSetting = Setting.MEDIUM;
            case MEDIUM -> curSetting = Setting.HIGH;
            // if already HIGH, do nothing
        }
		timer = TIME_DURATION;
    }
	
	public void minusButton() {
        switch (curSetting) {
            case MEDIUM -> curSetting = Setting.LOW;
            case HIGH -> curSetting = Setting.MEDIUM;
            case LOW -> curSetting = Setting.OFF;
            // if already OFF, do nothing
        }
		timer = TIME_DURATION;
    }
	
	public void updateTemperature() {
		if (timer <= 0) {
			changeTemp();
		}
		timer++;
	}
	
	private void changeTemp() {
		switch (curSetting) {
			case HIGH:
				timer = TIME_DURATION;
				switch (curTemp) {
					case BLAZING -> timer = 0;
					case HOT -> curTemp = Temperature.BLAZING; 
					case WARM -> curTemp = Temperature.HOT; 
					case COLD -> curTemp = Temperature.WARM; 
				}
			break;
			case MEDIUM:
				timer = TIME_DURATION;
				switch (curTemp) {
					case BLAZING -> curTemp = Temperature.HOT;
					case HOT -> timer = 0; 
					case WARM -> curTemp = Temperature.HOT; 
					case COLD -> curTemp = Temperature.WARM; 
				}
			break;
			case LOW:
				timer = TIME_DURATION;
				switch (curTemp) {
					case BLAZING -> curTemp = Temperature.HOT;
					case HOT -> curTemp = Temperature.WARM; 
					case WARM -> timer = 0; 
					case COLD -> curTemp = Temperature.WARM; 
				}
			break;
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
