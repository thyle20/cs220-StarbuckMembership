package branch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Customer {
	String name;
	String phoneNum;
	String id;
	Set<String> favDrink;
	boolean isMember;
	boolean getOneFree;
	int numCup;
	Map<String, Map<String, Integer>> orderList = new HashMap<>();
	StringBuilder receipt;
	public boolean hasCallBill;
	
	public Customer(String name, String phoneNum) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.id = "";
		favDrink = new HashSet<>();
		isMember = false;
		getOneFree = false;
		numCup = 0;
		orderList = new HashMap<>();
		receipt = new StringBuilder();
		hasCallBill = false;
		
	}
	
	public boolean getHasCallBill() {
		return this.hasCallBill;
	}
	
	public StringBuilder getReceipt() {
		return this.receipt;
	}
	
	public Map<String, Map<String, Integer>> getOrderList(){
		return this.orderList;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<String> getFavDrink() {
		return favDrink;
	}

	public void setFavDrink(Set<String> favDrink) {
		this.favDrink = favDrink;
	}

	public boolean isMember() {
		return isMember;
	}

	public void setMember(boolean isMember) {
		this.isMember = isMember;
	}

	public boolean isGetOneFree() {
		return getOneFree;
	}

	public void setGetOneFree(boolean getOneFree) {
		this.getOneFree = getOneFree;
	}

	public int getNumCup() {
		return numCup;
	}

	public void setNumCup(int numCup) {
		this.numCup = numCup;
	}
	
}
