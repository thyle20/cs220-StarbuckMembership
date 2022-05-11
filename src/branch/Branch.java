package branch;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Branch {
	Menu m = new Menu();
	Random rd = new Random();
	String branchName;
	Map<String, Customer> membershipList;
	
	public Branch(String branchName) {
		this.branchName = branchName;
		membershipList = new HashMap<>();
	}
	
	//get the list of membership at a branch
	public Collection<String> getMembership (){
		Set<String> list = new HashSet<>();
		for (Map.Entry<String, Customer> kv : membershipList.entrySet()) {
			String idNumber = (String) kv.getKey();
			String customerName = (String) kv.getValue().getName();
			list.add(idNumber + " - " + customerName);
		}
		return list;
	}
	
	//update the membership
	public void updateMembership(Customer c) {
		if (!c.isMember()) {
			c.id = "MM" + rd.nextInt();
			c.isMember = true;
			this.membershipList.put(c.getId(), c);
		}
	}
	
	//take order from the member customer
	public void takeOrderMember(String id, DrinkType type, DrinkSize size, DrinkChoice DrinkName) throws Exception {
		if (!membershipList.containsKey(id)) {
			throw new Exception ("This is not a member");
		}
		Customer c = membershipList.get(id);
		c.numCup++;
		if (c.getNumCup() == 3) {
			c.getOneFree = true;
			c.numCup = 0;
		}
		if (type == DrinkType.FAVORITE) {
			c.favDrink.add(DrinkName.getDrink());
		}
		if (!c.getOrderList().containsKey(DrinkName.getDrink())) {
			c.getOrderList().put(DrinkName.getDrink(), new HashMap<>());
			c.getOrderList().get(DrinkName.getDrink()).put(size.getSize(), 1);
		} else {
			c.getOrderList().get(DrinkName.getDrink()).computeIfPresent(size.getSize(), (Key, val) -> val +1);
		}
	}
	
	//take order from non-member customer
	public void takeOrderNonMember(Customer c, DrinkSize size, DrinkChoice DrinkName) {
		if (!c.getOrderList().containsKey(DrinkName.getDrink())) {
			c.getOrderList().put(DrinkName.getDrink(), new HashMap<>());
			c.getOrderList().get(DrinkName.getDrink()).put(size.getSize(), 1);
		} else {
			c.getOrderList().get(DrinkName.getDrink()).computeIfPresent(size.getSize(), (Key, val) -> val +1);
		}
	}
	
	//suggest the drink for member customer
	public void suggestDrink(String id) throws Exception {
		if (!membershipList.containsKey(id)) {
			throw new Exception ("This is not a member");
		}
		Customer c = membershipList.get(id);
		if (c.getFavDrink().size() != 0) {
			System.out.println("Drink options for " + c.getName() + ": ");
			for (String drink : c.getFavDrink()) {
				System.out.println(drink);
			}
		}else {
			System.out.println(c.getName() + "does not have a favorite drink");
		}
	}
	
	//choose the drink to apply coupon (if applicable)
	private int applyCoupon (String id, DrinkSize size, DrinkChoice drinkName) throws Exception {
		if (!membershipList.containsKey(id)) {
			throw new Exception ("This is not a member");
		}
		Customer c = membershipList.get(id);
		if (c.getOneFree) {
			if (c.getOrderList().containsKey(drinkName.getDrink())) {
				if (c.getOrderList().get(drinkName.getDrink()).containsKey(size.getSize())) {
					c.getOneFree = false;
					return 2;
				} 
			}else return 1;
		}
		return 0;
	}
	
	//get bill
	public double getBill (Customer c) {
		c.hasCallBill = true;
		//Map<String, Map<String, Integer>> customerOrder = c.getOrderList();
		double totalCost = 0;
		for (Map.Entry<String, Map<String, Integer>> drinkItem : c.getOrderList().entrySet()) {
			Map<String, Integer> item = drinkItem.getValue();
			String drink = drinkItem.getKey();
			for (Map.Entry<String, Integer> orderType : item.entrySet()) {
				String sizeOfDrink = orderType.getKey();
				double toAdd = orderType.getValue() * m.menuList().get(drink)[getIndex(sizeOfDrink)];
				System.out.println(toAdd);
				c.getReceipt().append(drinkItem.getKey()+ ": "  + orderType.getValue() + " "+ orderType.getKey() +
						": Charge $" + toAdd + "\n");
				totalCost += toAdd;
			}
		}
		c.getReceipt().append("Total: $"+totalCost + "\n");
		return totalCost;
	}
	
	//get the index to search for price in the menulist
	public int getIndex(String size) {
		if ( size == "large") {
			return 2;
		}else if (size == "medium") {
			return 1;
		}else if (size == "small") {
			return 0;
		}else 
			return 1; //default 
	}
	
	//get the bill after applying the coupon
	public void totalAfterApplyCoupon (String id, DrinkSize size, DrinkChoice drinkName) throws Exception {
		if (membershipList.containsKey(id)) {
			Customer c = membershipList.get(id);
			double finalTotal = getBill(c);
			if (applyCoupon(id, size, drinkName) == 2) {
				double toMinus = m.menuList().get(drinkName.getDrink())[getIndex(size.getSize())];
				finalTotal -= toMinus;
				c.getReceipt().append(drinkName.getDrink() + ": " + size.getSize() + ": $ -" + toMinus + "\n");
			} else if (applyCoupon(id, size, drinkName) == 1){
				c.getReceipt().append(drinkName.getDrink() + ": " + size.getSize() + ": $0.00 \n");
			}
			c.getReceipt().append("Final total: $"+ finalTotal + "\n");
		} else {
			throw new Exception ("Not in the membership list");
		}
		
	}
	
	//print Receipt
	public void printReceipt(Customer c) {
		System.out.println("Receipt for customer " + c.getName());
		System.out.println(c.getReceipt());
		c.orderList.clear();
		c.receipt.setLength(0);
		c.hasCallBill = false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
