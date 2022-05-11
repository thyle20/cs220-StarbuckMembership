package branch;

public enum DrinkChoice {
	AMERICANO,
	MOCHA_FRAPPUCCINO,
	CARAMEL_FRAPPUCCINO,
	ESPRESSO_FRAPPUCCINO,
	WHITE_CHOCOLATE_FRAPPUCCINO,
	DECAF_COFFEE,
	HOT_CHOCOLATE,
	COLD_BREW,
	DRAGON_DRINK,
	MANGO_GUAVA,
	MANGO_BLACKTEA,
	CHAI_TEA,
	MATCHA_LATTE,
	LEMONADE,
	PEACH_TEA,
	BLACK_TEA;
		
	public String getDrink () {
		if (this == DrinkChoice.AMERICANO) {
			return "americano";
		}else if (this == DrinkChoice.MOCHA_FRAPPUCCINO) {
			return "mocha frappuccino";
		}else if (this == DrinkChoice.CARAMEL_FRAPPUCCINO) {
			return "caramel frappuchino";
		}else if (this == DrinkChoice.ESPRESSO_FRAPPUCCINO) {
			return "espresso frappuchino";
		}else if (this == DrinkChoice.MOCHA_FRAPPUCCINO) {
			return "white chocolate frappuchino";
		}else if (this == DrinkChoice.DECAF_COFFEE) {
			return "decaf coffee";
		}else if (this == DrinkChoice.HOT_CHOCOLATE) {
			return "hot chocolate";
		}else if (this == DrinkChoice.COLD_BREW) {
			return "cold brew coffee";
		}else if (this == DrinkChoice.DRAGON_DRINK) {
			return "dragon drink";
		}else if (this == DrinkChoice.MANGO_GUAVA) {
			return "mango guava tropical drink";
		}else if (this == DrinkChoice.MANGO_BLACKTEA) {
			return "mango blacktea";
		}else if (this == DrinkChoice.CHAI_TEA) {
			return "chai iced tea";
		}else if (this == DrinkChoice.MATCHA_LATTE) {
			return "matcha latte";
		}else if (this == DrinkChoice.LEMONADE) {
			return "lemonade";
		}else if (this == DrinkChoice.PEACH_TEA) {
			return "peach tea";
		}else if (this == DrinkChoice.BLACK_TEA) {
			return "black tea";
		} else
			return null;
				
		}

}
