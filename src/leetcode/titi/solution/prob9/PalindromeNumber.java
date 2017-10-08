package leetcode.titi.solution.prob9;

public class PalindromeNumber {
	public static boolean isPalindrome(int x) {
        if(x < 0) return false; // Leetcode regards PalindromeNumber are positive
        int numOfDigits = getNumOfDigits(x);
        if(numOfDigits == 1 || x == 0) return true;
        if(numOfDigits == 2) return (x/10 == x%10);
        if(x%10 == (int)(x/Math.pow(10.0,(double)numOfDigits - 1))) {
            return isPalindrome(RemoveFirstAndLastDigits(x));
        }
        else return false;
        
    }
    private static int getNumOfDigits(int y) {
        int numOfDigits = 0;
        while(y > 0) {
            y = y /10;
            numOfDigits ++;
        }
        return numOfDigits;
    }
    private static int RemoveFirstAndLastDigits(int x) {
        int numOfDigitsInX = getNumOfDigits(x);
        int valOfXAfterRemoval = (int)(x/10)%(int)(Math.pow(10.0, (double)(numOfDigitsInX -2)));
        int numOfDigitsInXAfterRemoval = getNumOfDigits(valOfXAfterRemoval);
        if(numOfDigitsInX < 2) return x;
        if(numOfDigitsInXAfterRemoval == numOfDigitsInX -2) 
            return valOfXAfterRemoval;
        if(valOfXAfterRemoval % ((int)(Math.pow(10.0, (double)(numOfDigitsInX -2 - numOfDigitsInXAfterRemoval)))) == 0) {
        	return valOfXAfterRemoval / ((int)(Math.pow(10.0, (double)(numOfDigitsInX -2 - numOfDigitsInXAfterRemoval))));
        }
        else return 12;
    }

}
