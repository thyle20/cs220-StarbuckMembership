package branch;

import branch.DrinkSize;

public enum DrinkSize {
	SMALL,
	MEDIUM,
	LARGE;
	
	public String getSize() {
		if (this == DrinkSize.LARGE) {
			return "large";
		}else if (this == DrinkSize.MEDIUM) {
			return "medium";
		}else if (this == DrinkSize.SMALL) {
			return "small";
		}else 
			return "medium"; //default 
	}
}

