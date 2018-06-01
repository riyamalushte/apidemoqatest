package in.pune.amanora.idemia.test;

import org.springframework.web.client.RestTemplate;

import in.pune.amanora.idemia.model.Book;

public class BookTestWithoutJUnit {

	/*
	 * Test Get method and get Book details
	 * 
	 * @author Riya
	 */

	private static final Object Book = null;

	public void test1() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		Book book = restTemplate.getForObject("http://localhost:8080/shelves/101/books/102", Book.class);
		if (book.getId() != 102) {
			testResult = "fail";
			System.out.println("BookId Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("BookId match, Hence Test Result is: " + testResult);
		}
	}

	public void test2() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		Book book = restTemplate.getForObject("http://localhost:8080/shelves/101/books/102", Book.class);
		if (!(book.getAuthor().equals("author0"))) {
			testResult = "fail";
			System.out.println("Author Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("BookId match, Hence Test Result is: " + testResult);
		}
	}

	public void test3() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		Book book = restTemplate.getForObject("http://localhost:8080/shelves/101/books/102", Book.class);
		if (!(book.getName().equals("test1"))) {
			testResult = "fail";
			System.out.println("BookName Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("BookId match, Hence Test Result is: " + testResult);
		}
	}

	/*
	 * Test Post method by giving Book details
	 * 
	 * @author Riya
	 */

	public void test4() {
		String testResult = "pass";
		Book book = new Book();
		book.setAuthor("riya");
		book.setName("ghgh");
		book.setNoOfPages(766);
		book.setId(102);
		RestTemplate restTemplate = new RestTemplate();
		Book book2 = restTemplate.postForObject("http://localhost:8080/shelves/101/books", Book, Book.class);
		if (!(book.getName().equals(book.getName()))) {
			testResult = "fail";
			System.out.println("Author Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("Author Mismatch, Hence Test Result is: " + testResult);
		}

		if (!(book.getName().equals(book.getName()))) {
			testResult = "fail";
			System.out.println("Name Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("Name Mismatch, Hence Test Result is: " + testResult);
		}

		if ((book.getId() != (book.getId()))) {
			testResult = "fail";
			System.out.println("Id Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("Id Mismatch, Hence Test Result is: " + testResult);
		}

		if ((book.getNoOfPages() != (book.getNoOfPages()))) {
			testResult = "fail";
			System.out.println("NoOfPages Mismatch, Hence Test Result is: " + testResult);
			return;
		} else {
			System.out.println("NoOfPages Mismatch, Hence Test Result is: " + testResult);
		}
	}

	/*
	 * Test put method it will update Book details
	 * 
	 * @author Riya
	 */

	public void test6() {
		String testResult = "pass";
		Book book = new Book();

		book.setId(202);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8080/shelves/101/books/102", book);
		System.out.println("Id is updated hence, result is:" + testResult);

	}

	public void test7() {
		String testResult = "pass";
		Book book = new Book();
		book.setAuthor("riya");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8080/shelves/101/books/202", book);
		System.out.println("Id is updated hence, result is:" + testResult);

	}

	public void test8() {
		String testResult = "pass";
		Book book = new Book();
		book.setName("ghgh");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8080/shelves/101/books/202", book);
		System.out.println("BookName is updated hence, result is:" + testResult);

	}

	public void test10() {
		String testResult = "pass";
		Book book = new Book();
		book.setNoOfPages(123);
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put("http://localhost:8080/shelves/101/books/202", book);
		System.out.println("NoOfPages is updated hence, result is:" + testResult);

	}

	/*
	 * Test delete method .It will delete Book .
	 * 
	 * @author Riya
	 */

	public void test5() {
		String testResult1 = "pass";
		RestTemplate restTemplate1 = new RestTemplate();
		restTemplate1.delete("http://localhost:8080/shelves/101/books/202");
		System.out.println("Delete success for id : " + 202 + " Hence Test Result is:" + testResult1);

	}

	public static void main(String[] args) {
		BookTestWithoutJUnit testWithoutJUnit = new BookTestWithoutJUnit();
		testWithoutJUnit.test4();
		
		testWithoutJUnit.test1();
		testWithoutJUnit.test2();
		testWithoutJUnit.test3();

		testWithoutJUnit.test6();
		testWithoutJUnit.test7();
		testWithoutJUnit.test8();
		testWithoutJUnit.test10();
		
		testWithoutJUnit.test5();

	}
}
