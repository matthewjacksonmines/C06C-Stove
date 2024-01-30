/*
 * Enum Type: Setting, used for setting of individual burners. Constructor that reads in description
 * of each enum type and toString() method included to be used in corresponding
 * Burner methods.
 * Author(s): Matthew Jackson, Sam Bangapadang
 * Date: 1/29/2024
 * Collaborators: N/A
 * Sources: N/A
 */

// Enum type setting with corresponding strings.
public enum Setting {
	OFF("---"), LOW("--+"), MEDIUM("-++"), HIGH("+++");
	
	// intialize description variable for constructor
	public String setting;
	
	
	// constructor to be used to read in description
	Setting(String setting) {
		this.setting = setting;
	}
	
	
	// used in Burner methods for input / output
	@Override
	public String toString() {
		return setting;
	}
}
