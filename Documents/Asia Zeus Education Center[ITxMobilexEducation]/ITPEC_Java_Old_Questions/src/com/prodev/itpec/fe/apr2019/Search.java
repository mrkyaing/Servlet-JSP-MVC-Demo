package com.prodev.itpec.fe.apr2019;

import java.util.ArrayList;
import java.util.List;

public class Search {
	
private static List<Node> searchList(Node root,ICondition condition){
	List<Node> result=new ArrayList<>();
	doSearchList(root,condition,result);
	return result;
}

private static void doSearchList(Node current, ICondition condition, List<Node> result) {
	if(condition.isSatisfied(current)) {
		result.add(current);
	}
	if(current.isDirectory()) {
		for(Node child:current.getChildren()) {
			doSearchList(child, condition, result);
		}
	}
}

public static List<Node> searchByName(Node root,String name){
	ICondition condition=new NameCondition(name);
	return searchList(root, condition);
}
}
