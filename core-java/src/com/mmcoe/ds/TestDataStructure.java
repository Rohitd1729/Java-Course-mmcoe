package com.mmcoe.ds;

public class TestDataStructure {
	public static void main(String[] args) {
		//LinkedList list = new LinkedList();
	/*	LinkedList<Integer>list = new LinkedList<Integer>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		list.print();
		System.out.println("-----------------------");
		list.insert(2,25);
		list.insert(0,5);
		list.print();
		System.out.println("-----------------------");
		list.remove(6);
		list.remove(4);
		
		list.add(80);
		list.print();
	
*/
		
	/*
	 * BinaryTree tree = new BinaryTree(); tree.add(50); tree.add(40); tree.add(30);
	 * tree.add(20); tree.add(60); tree.add(80); tree.add(75); tree.preorder();
	 */
		//Stack 
		Stack<Integer> st = new Stack<>();

        st.push(10);
        st.push(20);
        st.push(30);

        st.print();

        System.out.println("-------------");

        System.out.println("Popped : " + st.pop());

        System.out.println("-------------");

        st.print();
}
}