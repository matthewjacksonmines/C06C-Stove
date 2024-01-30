
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
		
	}
}
