package branch;
import java.util.HashMap;
import java.util.Map;

public class Menu {
	
	public Map<String, Double[]> menuList () {
		Map<String, Double[]> menu = new HashMap<>();
		menu.put("americano", new Double[] {1.5, 2.0, 3.5});
		menu.put("mocha frappuchino", new Double[] {2.25, 3.0, 3.5});
		menu.put("caramel frappuchino", new Double[] {2.0, 3.0, 3.5});
		menu.put("espresso frappuchino", new Double[] {2.75, 3.25, 3.5});
		menu.put("white chocolate frappuchino", new Double[] {3.0, 3.5, 3.75});
		menu.put("decaf coffee", new Double[] {1.5, 1.75, 2.0});
		menu.put("hot chocolate", new Double[] {3.25, 3.75, 4.0});
		menu.put("cold brew coffee", new Double[] {2.0, 2.50, 3.0});
		menu.put("dragon drink", new Double[] {1.75, 2.0, 2.5});
		menu.put("mango guava tropical drink", new Double[] {2.5, 3.0, 3.5});
		menu.put("mango blacktea", new Double[] {2.0, 2., 2.75});
		menu.put("chai iced tea", new Double[] {2.0, 2.25, 2.5});
		menu.put("matcha latte", new Double[] {2.25, 3.0, 3.25});
		menu.put("lemonade", new Double[] {2.0, 2.25, 2.5});
		menu.put("peach tea", new Double[] {2.25, 2.5, 2.75});
		menu.put("black tea", new Double[] {2.25, 2.5, 2.75});
		return menu;
	}

}
