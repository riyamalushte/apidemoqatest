package in.pune.amanora.idemia.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import in.pune.amanora.idemia.model.Book;
import in.pune.amanora.idemia.model.Shelf;

public class ShelfTestWithoutJUnit {

	/*
	 * Test Post method by giving Shelf details
	 * 
	 * @author Shraddha
	 */

	public void test1() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		Shelf shelf = new Shelf();
		shelf.setId(106);
		shelf.setCapacity(3);
		List<Book> books = new ArrayList<Book>(3);
		Book book = new Book();
		books.add(book);
		shelf.setBooks(books);

		Shelf resShelf = restTemplate.postForObject("http://localhost:8080/shelves", shelf, Shelf.class);

		if (resShelf.getId() != shelf.getId()) {
			testResult = "fail";
			System.out.println("ID Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("ShelfId match, Hence Test Result is: " + testResult);
		}

		if (resShelf.getCapacity() != shelf.getCapacity()) {
			testResult = "fail";
			System.out.println("Capacity Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("Capacity match, Hence Test Result is: " + testResult);
		}

		if (resShelf.getBooks().size() != shelf.getBooks().size()) {
			testResult = "fail";
			System.out.println("Book List Size Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("Book List Size match for post request, Hence Test Result is: " + testResult);
		}

	}

	/*
	 * Test Get method and get Shelf details
	 * 
	 * @author Shraddha
	 */
	public void test2() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		Shelf shelf = restTemplate.getForObject("http://localhost:8080/shelves/106", Shelf.class);
		if (shelf.getId() != 106) {
			testResult = "fail";
			System.out.println("shelfId Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("shelfId match, Hence Test Result is: " + testResult);
		}
	}

	public void test3() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		Shelf shelf = restTemplate.getForObject("http://localhost:8080/shelves/106", Shelf.class);
		if (shelf.getCapacity() != 3) {
			testResult = "fail";
			System.out.println("Shelf Capacity Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("Shelf Capacity match, Hence Test Result is: " + testResult);
		}
	}

	public void test4() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		Shelf shelf = restTemplate.getForObject("http://localhost:8080/shelves/106", Shelf.class);
		if (shelf.getBooks().size() != 3) {
			testResult = "fail";
			System.out.println("Book List Size Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("Book List Size match for get request, Hence Test Result is: " + testResult);
		}
	}

	/*
	 * Test put method it will update Shelf details
	 * 
	 * @author Shraddha
	 */
	public void test5() {

		String testResult = "pass";
		Shelf shelf = new Shelf();
		shelf.setId(107);
		List<Book> books = new ArrayList<Book>(3);
		Book book = new Book();
		books.add(book);
		shelf.setBooks(books);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8080/shelves/106", shelf);

		System.out.println("ShelfId is Updated, Hence Test Result is: " + testResult);

	}

	public void test6() {

		String testResult = "pass";
		Shelf shelf = new Shelf();
		shelf.setCapacity(10);
		List<Book> books = new ArrayList<Book>(3);
		Book book = new Book();
		books.add(book);
		shelf.setBooks(books);

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8080/shelves/107", shelf);

		System.out.println("Shelf Capacity is Updated, Hence Test Result is: " + testResult);

	}

	/*
	 * Test delete method .It will delete Shelf .
	 * 
	 * @author Shraddha
	 */
	public void test7() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8080/shelves/107");
		System.out.println("Delete success for id : " + 107 + " Hence Test Result is:" + testResult);
	}

	public static void main(String[] args) {
		ShelfTestWithoutJUnit shelfTestWithoutJUnit = new ShelfTestWithoutJUnit();
		;
		shelfTestWithoutJUnit.test1();
		shelfTestWithoutJUnit.test2();
		shelfTestWithoutJUnit.test3();
		shelfTestWithoutJUnit.test4();
		shelfTestWithoutJUnit.test5();
		shelfTestWithoutJUnit.test6();
		shelfTestWithoutJUnit.test7();

	}
}
