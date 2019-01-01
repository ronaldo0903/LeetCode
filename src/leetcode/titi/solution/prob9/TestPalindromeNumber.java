package leetcode.titi.solution.prob9;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPalindromeNumber {

	@Test
	public void test() {
		Assertions.assertTrue(PalindromeNumber.isPalindrome(101));
		Assertions.assertTrue(PalindromeNumber.isPalindrome(52344325));
		//Assertions.assertFalse(PalindromeNumber.isPalindrome(-2147447412));
		Assertions.assertFalse(PalindromeNumber.isPalindrome(1000021));
		Assertions.assertTrue(PalindromeNumber.isPalindrome(100212001));
	}

}
