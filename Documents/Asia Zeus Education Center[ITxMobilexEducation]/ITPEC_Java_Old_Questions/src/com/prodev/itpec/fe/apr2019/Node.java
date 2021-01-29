package com.prodev.itpec.fe.apr2019;

import java.util.ArrayList;
import java.util.List;

public class Node {
	
public static final Node Root=new Node("",null,true);

private  String name;
private  Node parent;
private  String extension;
private  List<Node> children;
private  String fullPath;

private Node(String name,Node parent,boolean directory) {
	this.name=name;
	this.parent=parent;
	if(directory) {
		extension=null;
	    children=new ArrayList<>();
	}else {
		extension=name.substring(name.lastIndexOf("."));
	}
	if(parent==null || parent==Root) {
		fullPath="/"+name;
	}else {
		fullPath=parent.fullPath+"/"+name;
	}
}
public static Node create(String name,Node parent,boolean diectory) {
	Node node=new Node(name,parent,diectory);
	parent.children.add(node);
	return node;
}
@Override
public String toString() {
	return  "/"+fullPath+"/"+(extension==null?"":""+extension);
}
public String getName() {
	return name;
}
public String getExtension() {
	return extension;
}
public String getFullPath() {
	return fullPath;
}

public Node getParent() {
	return parent;
}
public List<Node> getChildren() {
	return isDirectory()?new ArrayList(children):null;
}

public boolean isDirectory() {
	return this.children!=null;
}



}
