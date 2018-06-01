package in.pune.amanora.idemia.test;

import org.springframework.web.client.RestTemplate;

import in.pune.amanora.idemia.model.Book;

public class TestWithoutJUnit {
	
	public void test1() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		Book book = restTemplate.getForObject("http://localhost:8080/shelves/101/books/111", Book.class);
		if (book.getId() != 111) {
			testResult = "fail";
			System.out.println("BookId Mismatch, Hence Test Result is: " + testResult);
			return;
		}else {
			System.out.println("BookId match, Hence Test Result is: " + testResult);
		}
	}
	
	public void test2() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		Book book = restTemplate.getForObject("http://localhost:8080/shelves/101/books/111", Book.class);
		if (! (book.getAuthor().equals("author0"))) {
			testResult = "fail";
			System.out.println("Author Mismatch, Hence Test Result is: " + testResult);
			return;
		}else {
			System.out.println("BookId match, Hence Test Result is: " + testResult);
		}
	}

	public void test3() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		Book book = restTemplate.getForObject("http://localhost:8080/shelves/101/books/111", Book.class);
		if (! (book.getName().equals("test1"))) {
			testResult = "fail";
			System.out.println("BookName Mismatch, Hence Test Result is: " + testResult);
			return;
		}else {
			System.out.println("BookId match, Hence Test Result is: " + testResult);
		}
	}
	
	public static void main(String[] args) {
		TestWithoutJUnit testWithoutJUnit = new TestWithoutJUnit();
		testWithoutJUnit.test1();
		testWithoutJUnit.test2();
		testWithoutJUnit.test3();
	}
}
