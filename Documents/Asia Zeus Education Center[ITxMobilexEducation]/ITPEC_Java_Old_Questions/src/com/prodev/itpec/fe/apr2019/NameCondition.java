package com.prodev.itpec.fe.apr2019;

public class NameCondition implements ICondition{

	private  String name;
	
	public NameCondition(String name) {
		this.name = name;
	}
	public String getName() {
	return name;
}

	@Override
	public boolean isSatisfied(Node node) {
		// TODO Auto-generated method stub
		return node.getName().equals(this.getName());
	}

}
