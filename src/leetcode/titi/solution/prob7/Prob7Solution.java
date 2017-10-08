package leetcode.titi.solution.prob7;
/*
 * Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 * 
 */
public class Prob7Solution {
	public static int reverse(int x) {
        long retVal = 0;
        boolean isNegative = false;
        if(x <0) {
            x=-x;
            isNegative = true;
        }
        if(x < 10 && x >=0) return x;
        while(x > 0) {
            int digit = x % 10;
            retVal = 10 * retVal + digit;
            if(retVal > Integer.MAX_VALUE) return 0;
            x = x / 10;
        }
        return isNegative? -(int)retVal : (int)retVal;
    }
}
