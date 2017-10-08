package leetcode.titi.solution.prob2;

import junit.framework.Assert;

import org.junit.Test;

public class TestProb2Solution {
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

        ListNode resultNode = Prob2Solution.addTwoNumbers(node_1_1, node_2_1);

        System.out.println(resultNode.toString());
        Assert.assertTrue(resultNode.toString().equals("708"));
    }

    @Test
    public void testAddTwoNumbers2() {
        ListNode node_1_1 = new ListNode(9);

        ListNode node_2_1 = new ListNode(1);
        ListNode node_2_2 = new ListNode(9);
        ListNode node_2_3 = new ListNode(9);
        ListNode node_2_4 = new ListNode(9);
        ListNode node_2_5 = new ListNode(9);
        ListNode node_2_6 = new ListNode(9);
        ListNode node_2_7 = new ListNode(9);
        ListNode node_2_8 = new ListNode(9);
        ListNode node_2_9 = new ListNode(9);
        ListNode node_2_10 = new ListNode(9);

        node_2_1.setNext(node_2_2);
        node_2_2.setNext(node_2_3);
        node_2_3.setNext(node_2_4);
        node_2_4.setNext(node_2_5);
        node_2_5.setNext(node_2_6);
        node_2_6.setNext(node_2_7);
        node_2_7.setNext(node_2_8);
        node_2_8.setNext(node_2_9);
        node_2_9.setNext(node_2_10);

        ListNode resultNode = Prob2Solution.addTwoNumbers(node_1_1, node_2_1);
        Assert.assertTrue(resultNode.toString().equals("00000000001"));

    }

}
