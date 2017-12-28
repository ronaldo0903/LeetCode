/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob232;

import java.util.Stack;

public class MyQueueUsingStack {
    private Stack<Integer> elementStack;
    private Stack<Integer> auxiliaryStack;
    private int frontElement = -1;

    /** Initialize your data structure here. */
    public MyQueueUsingStack() {
	elementStack = new Stack<Integer>();
	auxiliaryStack = new Stack<Integer>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
	elementStack.push(x);
	if (elementStack.size() == 1) {
	    frontElement = x;
	}
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
	while (elementStack.size() > 1) {
	    auxiliaryStack.push(elementStack.pop());
	}
	int top = elementStack.pop();
	while (!auxiliaryStack.isEmpty()) {
	    int curElement = auxiliaryStack.pop();
	    elementStack.push(curElement);
	    if (elementStack.size() == 1) {
		frontElement = curElement;
	    }
	}
	return top;
    }

    /** Get the front element. */
    public int peek() {
	if (!elementStack.isEmpty()) {
	    return frontElement;
	} else {
	    return -1;
	}
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
	return elementStack.isEmpty();
    }
}
