package com.mmcoe.ds;

public class LinkedList<T> {
	private class Node{
		private T data;
		private Node next;
		
		public Node(T data) {
			this.data = data;
			
			
		}

		public T getData() {
			return data;
		}
		
}
	private  Node head, last;
	private int size;
	public void add (T data) {
		Node n = new Node (data);
			if (head== null)
				head = n;
			else 
				last.next=n;
			last=n;
			size++;
			
		
}
	public void insert (int idx, T data) {
		if (idx < 0 || idx > size)
			throw new IllegalArgumentException("Index out of bound");
		Node n = new Node(data);
		if (idx==0) {
			n.next = head;
			head = n;
			if(last == null)
		        last = n;
			size++;
			return;
		}
			 Node t = head;
			    for (int i = 0; i < idx - 1; i++) {
			        t = t.next;
	}
			    n.next = t.next;
			    t.next = n;
			    if (n.next == null)
			        last = n;
			    size++;
			
		}
	public void remove(int idx) {
		if (idx < 0 || idx >= size)
			throw new IllegalArgumentException("Invalid Index ");
		
		if (idx==0) {
			head = head.next;
			if(head==null)
				last=null;
			size--;
			return;		
		}
		Node t = head;
		for (int i=0; i<idx-1;i++) {
			t = t.next;	
		}
		if (t.next ==last) {
			last = t;
		}
		t.next= t.next.next;
		size--;			
		}
	
	
	public void print() {
		Node t = head ;
		while (t != null) {
			System.out.print(t.getData() + " ");

	        t = t.next;
		}
		System.out.println();
		
	}
}