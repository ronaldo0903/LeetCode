/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob155;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> elementStack;
    private Stack<Integer> minStack;

    public MinStack() {
	elementStack = new Stack<Integer>();
	minStack = new Stack<Integer>();
    }

    public void push(int x) {
	elementStack.push(x);
	if (minStack.isEmpty()) {
	    minStack.push(x);
	} else if (x < minStack.peek()) {
	    minStack.push(x);
	} else {
	    minStack.push(minStack.peek());
	}
    }

    public void pop() {
	if (!elementStack.isEmpty()) {
	    elementStack.pop();
	    minStack.pop();
	}
    }

    public int top() {
	if (!elementStack.isEmpty()) {
	    return elementStack.peek();
	}
	return -1;
    }

    public int getMin() {
	if (!minStack.isEmpty()) {
	    return minStack.peek();
	}
	return -1;
    }
}
