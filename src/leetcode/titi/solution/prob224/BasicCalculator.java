/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob224;

import java.util.Stack;

public class BasicCalculator {
    private static final int STATE_BEGIN = 0;
    private static final int STATE_NUMBER = 1;
    private static final int STATE_OPERATOR = 2;

    public static int calculate(String s) {
	Stack<Integer> numStack = new Stack<Integer>();
	Stack<Character> operatorStack = new Stack<Character>();
	int number = 0;
	int state = STATE_BEGIN;
	boolean can_compute = false;
	for (int i = 0; i < s.length(); i++) {
	    char c = s.charAt(i);
	    if (c == ' ') {
		continue;
	    }
	    switch (state) {
	    case STATE_BEGIN:
		if ((c >= '0') && (c <= '9')) {
		    state = STATE_NUMBER;
		    number = (number * 10) + (c - '0');
		}
		break;
	    case STATE_NUMBER:
		if ((c >= '0') && (c <= '9')) {
		    number = (number * 10) + (c - '0');
		} else {
		    numStack.push(number);
		    if (can_compute) {
			compute(numStack, operatorStack);
		    }
		    number = 0;
		    i--;
		    state = STATE_OPERATOR;
		}
		break;
	    case STATE_OPERATOR:
		if ((c == '+') || (c == '-')) {
		    operatorStack.push(c);
		    can_compute = true;
		} else if (c == '(') {
		    state = STATE_NUMBER;
		    can_compute = false;
		} else if ((c >= '0') && (c <= '9')) {
		    state = STATE_NUMBER;
		    i--;
		} else if (c == ')') {
		    compute(numStack, operatorStack);
		}
		break;

	    default:
		break;
	    }
	}
	if (number != 0) {
	    numStack.push(number);
	    compute(numStack, operatorStack);
	}
	if (numStack.isEmpty()) {
	    return 0;
	}
	return numStack.peek();
    }

    private static void compute(Stack<Integer> numStack, Stack<Character> operatorStack) {
	if (numStack.size() < 2) {
	    return;
	}
	int num2 = numStack.pop();
	int num1 = numStack.pop();
	switch (operatorStack.pop()) {
	case '+':
	    numStack.push(num1 + num2);
	    break;
	case '-':
	    numStack.push(num1 - num2);
	    break;
	default:
	    break;
	}
    }
}
