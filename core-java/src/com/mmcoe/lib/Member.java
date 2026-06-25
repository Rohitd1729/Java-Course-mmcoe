//public class Member {
//	private String name;
//	private Book bk;
//	
//		
//		public Member (String name) {
//			this.name=name;
//			
//		}
//		@Override
//		public String toString () {
//			return "Member [Name = " + name + "]";
//			
//		}
//		public void status () {
//			if (bk == null)
//				System.out.println(name + "has not issued the book");
//			else 
//				System.out.println(name + "has issued " + bk);
//		}
//	}
//
package com.mmcoe.lib;


public class Member {

    private String name;
    private Book book;

    public Member(String name) {
        this.name = name;
    }

    // Helper method used only by Book class
    void setBook(Book book) {
        this.book = book;
    }

    Book getBook() {
        return book;
    }

    public String getName() {
        return name;
    }

    public void status() {

        if (book == null)
            System.out.println(name + " has not issued any book.");
        else
            System.out.println(name + " has issued " + book.getTitle());
    }

    @Override
    public String toString() {
        return "Member [Name=" + name + "]";
    }
}