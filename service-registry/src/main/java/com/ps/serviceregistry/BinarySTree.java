package com.ps.serviceregistry;

public class BinarySTree {

	
	public static class Node{
		int data;
		Node left;
		Node right;
		
		public Node(int data){
			this.data= data;
			this.left=null;
			this.right=null;
		}
	}
	

	
	public Node root;
	public BinarySTree() {
		root=null;
		
	}
	Node node=new Node(data);
	if(root==null) {
		root=node;
	}else {
		 Node current = root, parent = null;  
		  
		 
		 while(true) {
			 
			 parent=current;
			 
			 if(data<current.data) {
				 current=current.left;
				 if(current==null) {
					 parent.left=node;
				 }
			 }else {
				 current=current.right;
				 if(current==null) {
					 parent.right=node;
				 }
			 }
		 }
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
