//public class TestLibrary {
//	public static void main (String [] args ) {
//		Book b1 = new Book ("The Alchemist");
//		Book b2 = new Book ("Kite Runner");
//		
//		Member m1 = new Member ("George");
//		
//	}
//}
package com.mmcoe.lib;


public class TestLibrary {

    public static void main(String[] args) {

        Book b1 = new Book("The Alchemist");
        Book b2 = new Book("Kite Runner");

        Member m1 = new Member("Krishna");
        Member m2 = new Member("George");

        b1.status();
        m1.status();

        System.out.println();

        b1.issueTo(m1);

        System.out.println();

        b1.status();
        m1.status();

        System.out.println();

        b1.returnBook();

        System.out.println();

        b1.status();
        m1.status();
    }
}