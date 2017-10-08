package leetcode.titi.solution.prob9;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class TestPalindromeNumber {

	@Test
	public void test() {
		Assert.assertTrue(PalindromeNumber.isPalindrome(101));
		Assert.assertTrue(PalindromeNumber.isPalindrome(52344325));
		//Assert.assertFalse(PalindromeNumber.isPalindrome(-2147447412));
		Assert.assertFalse(PalindromeNumber.isPalindrome(1000021));
		Assert.assertTrue(PalindromeNumber.isPalindrome(100212001));
	}

}
