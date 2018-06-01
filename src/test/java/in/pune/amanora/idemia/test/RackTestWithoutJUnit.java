package in.pune.amanora.idemia.test;

import java.util.ArrayList;
import java.util.List;

import in.pune.amanora.idemia.model.Rack;
import in.pune.amanora.idemia.model.Shelf;

import org.springframework.web.client.RestTemplate;

/*
 * Test Post method by giving Rack details
 * 
 * @author Swarshri
 */

public class RackTestWithoutJUnit {

	public void test1() {
		String testResult = "pass";
		Rack rack = new Rack();
		RestTemplate restTemplate = new RestTemplate();
		rack.setId(1001);
		rack.setNoOfShelves(5);
		Rack respRack = restTemplate.postForObject(
				"http://localhost:8080/rack", rack, Rack.class);
		if (respRack.getId() != 1001) {
			testResult = "fail";
			System.out.println("RackId Mismatch, Hence Test Result is: "
					+ testResult);
		} else {
			System.out.println("RackId matched, Hence Test Result is: "
					+ testResult);
		}
		if (rack.getNoOfShelves() != 5) {
			testResult = "fail";
			System.out
					.println("Shelves capacity Mismatched, Hence Test Result is: "
							+ testResult);
			return;
		}

		else {
			System.out
					.println("Shelves capacity matched, Hence Test Result is: "
							+ testResult);
		}
	}

	/*
	 * Test Get method and get Rack details
	 * 
	 * @author Swarshri
	 */

	public void test2() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		Rack rack = restTemplate.getForObject("http://localhost:8080/rack",
				Rack.class);
		if (rack.getId() != 1001) {
			testResult = "fail";
			System.out.println("RackId Mismatch, Hence Test Result is: "
					+ testResult);
			return;
		} else {
			System.out.println("RackId matched, Hence Test Result is: "
					+ testResult);
		}
		if (rack.getNoOfShelves() != 2) {
			testResult = "fail";
			System.out
					.println("No of Shelves Mismatched, Hence Test Result is: "
							+ testResult);
			return;
		} else {
			System.out.println("No of Shelves matched, Hence Test Result is: "
					+ testResult);
		}

	}

	/*
	 * Test put method it will update Rack details
	 * 
	 * @author Swarshri
	 */

	public void test3() {
		String testResult = "pass";

		RestTemplate restTemplate = new RestTemplate();
		Rack rack = new Rack();
		rack.setId(1002);
		rack.setNoOfShelves(1);
		List<Shelf> shelves = new ArrayList<Shelf>();
		Shelf shelf = new Shelf();
		shelves.add(shelf);
		rack.setShelves(shelves);
		restTemplate.put("http://localhost:8080/rack/1001", rack);
		System.out.println("Data updted successfully for id:" + 1001
				+ " Hence the Test Result is: " + testResult);
	}

	/*
	 * Test delete method .It will delete Rack .
	 * 
	 * @author Swarshri
	 */

	public void test4() {
		String testResult = "pass";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete("http://localhost:8080/rack/1001");
		System.out.println("Delete success for id:" + 1001
				+ " Hence the Test Result is: " + testResult);

	}

	public static void main(String[] args) {
		RackTestWithoutJUnit testWithoutJUnit = new RackTestWithoutJUnit();
		testWithoutJUnit.test1();
		testWithoutJUnit.test2();
		testWithoutJUnit.test3();
		testWithoutJUnit.test4();
	}
}
