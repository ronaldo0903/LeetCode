package prob2.test.leet.titi;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import prob2.code.leet.titi.*;

public class TestSolution {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testReverseList() {
		ListNode node_1 = new ListNode(1);
		ListNode node_2 = new ListNode(2);
		ListNode node_3 = new ListNode(3);
		node_1.setNext(node_2);
		node_2.setNext(node_3);
		Assert.assertTrue(node_1.toString().equals("123"));
		Assert.assertTrue(Prob2Solution.reverseList(node_1).toString().equals("321"));
	}
	
	@Test
	public void testIntValue() {
		ListNode node_1 = new ListNode(1);
		ListNode node_2 = new ListNode(2);
		ListNode node_3 = new ListNode(3);
		ListNode node_4 = new ListNode(0);
		node_1.setNext(node_2);
		node_2.setNext(node_3);
		node_3.setNext(node_4);
		Assert.assertTrue(Prob2Solution.getIntValue(node_1) == 321);
	}
	
	@Test
	public void testAddTwoNumbers() {
		ListNode node_1_1 = new ListNode(2);
		ListNode node_1_2 = new ListNode(4);
		ListNode node_1_3 = new ListNode(3);
		node_1_1.setNext(node_1_2);
		node_1_2.setNext(node_1_3);
		
		ListNode node_2_1 = new ListNode(5);
		ListNode node_2_2 = new ListNode(6);
		ListNode node_2_3 = new ListNode(4);
		node_2_1.setNext(node_2_2);
		node_2_2.setNext(node_2_3);
		
		Assert.assertTrue(Prob2Solution.getIntValue(node_1_1) == 342);
		Assert.assertTrue(Prob2Solution.getIntValue(node_2_1) == 465);
		
		ListNode resultNode = Prob2Solution.addTwoNumbers(node_1_1, node_2_1);
		System.out.println(node_2_1.toString());
		System.out.println(resultNode.toString());
		
		//Assert.assertTrue(Prob2Solution.getIntValue(Prob2Solution.addTwoNumbers(node_1_1, node_2_1)) == 807);
	}

}
