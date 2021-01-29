package com.prodev.itpec.fe.apr2019;

public class DirectoryDemo {

	public static void main(String[] args) {
		Node home=Node.create("home", Node.Root, true);
		Node user1=Node.create("user1", home, true);
		Node document=Node.create("document", user1, true);
		Node note=Node.create("note.txt", document, false);
		
		
		Node var=Node.create("var", Node.Root, true);
		Node tmp=Node.create("tmp", var, true);
		Node log=Node.create("log", tmp, true);
		Node logfile=Node.create("program.home.log", log, false);
		
		
		System.out.printf("Some nodes info :%n %s%n %s%n %s%n%n",
				Node.Root,logfile,note);
		System.out.printf("Result of Searching Nodes:%n %s%n",
				Search.searchByName(Node.Root, "note.txt"));
	}

}
