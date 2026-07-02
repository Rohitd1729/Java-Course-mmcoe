import java.util.Scanner;

import com.mmcoe.dao.BookDao;
import com.mmcoe.dao.BookDaoJdbcImpl;
import com.mmcoe.pojo.Book;
import com.mmcoe.service.BookNotFoundException;
import com.mmcoe.service.BookService;
import com.mmcoe.service.BookServiceImpl;

public class TestBookService {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BookDao dao = new BookDaoJdbcImpl();
		BookService service = new BookServiceImpl(dao);

		int choice;

		do {

			System.out.println("\n===== BOOK MANAGEMENT SYSTEM =====");
			System.out.println("1. Add Book");
			System.out.println("2. Find Book");
			System.out.println("3. List All Books");
			System.out.println("4. Delete Book");
			System.out.println("5. Find Books By Price");
			System.out.println("6. List Books Order By Title");
			System.out.println("0. Exit");
			System.out.print("Enter Choice : ");

			choice = sc.nextInt();

			switch (choice) {

			case 1:

				System.out.print("Enter ISBN : ");
				int isbn = sc.nextInt();
				sc.nextLine();

				System.out.print("Enter Title : ");
				String title = sc.nextLine();

				System.out.print("Enter Author : ");
				String author = sc.nextLine();

				System.out.print("Enter Price : ");
				double price = sc.nextDouble();

				if (service.save(new Book(isbn, title, author, price)))
					System.out.println("Book Added Successfully");
				else
					System.out.println("Book Not Added");

				break;

			case 2:

				System.out.print("Enter ISBN : ");
				isbn = sc.nextInt();

				try {

					System.out.println(service.find(isbn));

				} catch (BookNotFoundException e) {

					System.out.println(e.getMessage());
				}

				break;

			case 3:

				System.out.println("\n===== ALL BOOKS =====");

				for (Book b : service.list()) {
					System.out.println(b);
				}

				break;

			case 4:

				System.out.print("Enter ISBN : ");
				isbn = sc.nextInt();

				try {

					service.delete(isbn);
					System.out.println("Book Deleted Successfully");

				} catch (BookNotFoundException e) {

					System.out.println(e.getMessage());
				}

				break;

			case 5:

				System.out.print("Enter Minimum Price : ");
				double min = sc.nextDouble();

				System.out.print("Enter Maximum Price : ");
				double max = sc.nextDouble();

				System.out.println("\n===== BOOKS BETWEEN PRICE RANGE =====");

				for (Book b : service.findByPrice(min, max)) {
					System.out.println(b);
				}

				break;

			case 6:

				System.out.println("\n===== BOOKS ORDER BY TITLE =====");

				service.listOrderByTitle()
						.forEach(System.out::println);

				break;

			case 0:

				System.out.println("Thank You...");
				break;

			default:

				System.out.println("Invalid Choice");
			}

		} while (choice != 0);

		sc.close();
	}
}