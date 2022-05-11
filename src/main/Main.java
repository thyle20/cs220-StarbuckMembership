package main;

import java.util.Map;

import branch.Branch;
import branch.Customer;
import branch.DrinkChoice;
import branch.DrinkSize;
import branch.DrinkType;

public class Main {
	public static void main (String[] args) throws Exception {
		Customer c1 =new Customer("Doan","2174478996");
		Customer c2 =new Customer("Avie","2174988996");
		Customer c3 =new Customer("Luke","3098765541");
		
		Branch GB = new Branch("galesburg");
		
		GB.updateMembership(c3);
		//System.out.println(c3.getId());
		//System.out.println(c3.isMember());
		//System.out.println(c3.getOrderList().size());

		GB.takeOrderMember(c3.getId(), DrinkType.FAVORITE, DrinkSize.LARGE, DrinkChoice.AMERICANO);
		GB.takeOrderMember(c3.getId(), DrinkType.FAVORITE, DrinkSize.MEDIUM, DrinkChoice.BLACK_TEA);
		GB.takeOrderMember(c3.getId(), DrinkType.FAVORITE, DrinkSize.MEDIUM, DrinkChoice.BLACK_TEA);
		GB.takeOrderMember(c3.getId(), DrinkType.RANDOM, DrinkSize.SMALL, DrinkChoice.ESPRESSO_FRAPPUCCINO);
		
		//System.out.println(c3.getNumCup());
		//System.out.println(c3.isGetOneFree());
		
		GB.totalAfterApplyCoupon(c3.getId(), DrinkSize.LARGE, DrinkChoice.CARAMEL_FRAPPUCCINO);
		
		GB.takeOrderNonMember(c1, DrinkSize.SMALL, DrinkChoice.HOT_CHOCOLATE);
		GB.getBill(c1);
		GB.printReceipt(c1);
		GB.printReceipt(c3);
		//System.out.println(c3.hasCallBill);
	
		//GB.takeOrderMember(c1.getId(), DrinkType.RANDOM, DrinkSize.SMALL, DrinkChoice.PEACH_TEA);
		
		GB.suggestDrink(c3.getId());
		
		//GB.suggestDrink(c1.getId());
		
	}
	
}
