/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob225;

import java.util.ArrayDeque;
import java.util.Deque;

class MyStack {
    private Deque<Integer> elementQueue;

    /** Initialize your data structure here. */
    public MyStack() {
	elementQueue = new ArrayDeque<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
	elementQueue.addLast(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
	if (!elementQueue.isEmpty()) {
	    return elementQueue.pollLast();
	}
	return -1;
    }

    /** Get the top element. */
    public int top() {
	if (!elementQueue.isEmpty()) {
	    return elementQueue.peekLast();
	}
	return -1;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
	return elementQueue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
