
public enum Setting {
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	
	public String setting;
	
	Setting(String setting) {
		this.setting = setting;
	}
	
	@Override
	public String toString() {
		return setting;
	}
}
