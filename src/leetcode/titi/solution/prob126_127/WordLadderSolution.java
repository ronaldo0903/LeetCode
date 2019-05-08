/*------------------------------------------------------------------------------
 * COPYRIGHT Ericsson 2017
 *
 * The copyright to the computer program(s) herein is the property of
 * Ericsson Inc. The programs may be used and/or copied only with written
 * permission from Ericsson Inc. or in accordance with the terms and
 * conditions stipulated in the agreement/contract under which the
 * program(s) have been supplied.
 *----------------------------------------------------------------------------*/
package leetcode.titi.solution.prob126_127;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

/*
 * Issue #127: Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log","cog"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
    Return 0 if there is no such transformation sequence.
    All words have the same length.
    All words contain only lowercase alphabetic characters.
    You may assume no duplicates in the word list.
    You may assume beginWord and endWord are non-empty and are not the same.
 * 
 *  Issue #126: Find the shortest transformation path of #127.
 * 
 */
public class WordLadderSolution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
	Map<String, ArrayList<String>> wordMap = buildWordMap(beginWord, wordList);
	Deque<QItem> myDeque = new ArrayDeque<QItem>();
	List<String> visitedNodes = new ArrayList<String>();
	myDeque.addLast(new QItem(beginWord, 1));
	visitedNodes.add(beginWord);
	while (!myDeque.isEmpty()) {
	    QItem pair = myDeque.pollFirst();
	    if (pair.key.equals(endWord)) {
		return pair.steps;
	    }
	    if (!visitedNodes.contains(pair.key)) {
		visitedNodes.add(pair.key);
	    }
	    for (String neighbor : wordMap.get(pair.key)) {
		if (!visitedNodes.contains(neighbor)) {
		    myDeque.addLast(new QItem(neighbor, pair.steps + 1));
		}
	    }
	}
	return 0;
    }

    private Map<String, ArrayList<String>> buildWordMap(String beginWord, List<String> wordList) {
	if (!wordList.contains(beginWord)) {
	    wordList.add(beginWord);
	}
	Map<String, ArrayList<String>> wordMap = new HashMap<String, ArrayList<String>>();
	for (int k = 0; k < wordList.size(); k++) {
	    wordMap.put(wordList.get(k), new ArrayList<String>());
	}
	for (int i = 0; i < wordList.size(); i++) {
	    for (int j = i + 1; j < wordList.size(); j++) {
		if (connected(wordList.get(i), wordList.get(j))) {
		    wordMap.get(wordList.get(i)).add(wordList.get(j));
		    wordMap.get(wordList.get(j)).add(wordList.get(i));
		}
	    }
	}
	return wordMap;
    }

    private boolean connected(String key, String curWord) {
	// TODO Auto-generated method stub
	int numOfDiffChars = 0;
	if (key.length() != curWord.length()) {
	    return false;
	}
	for (int i = 0; i < key.length(); i++) {
	    if (key.charAt(i) != curWord.charAt(i)) {
		numOfDiffChars++;
	    }
	}
	return (numOfDiffChars == 1);
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
	Set<String> wordSet = new HashSet<String>(wordList);
	Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

	int len = 1;
	int strLen = beginWord.length();
	HashSet<String> visited = new HashSet<String>();

	beginSet.add(beginWord);
	endSet.add(endWord);
	while (!beginSet.isEmpty() && !endSet.isEmpty()) {
	    if (beginSet.size() > endSet.size()) {
		Set<String> set = beginSet;
		beginSet = endSet;
		endSet = set;
	    }

	    Set<String> temp = new HashSet<String>();
	    for (String word : beginSet) {
		char[] chs = word.toCharArray();

		for (int i = 0; i < chs.length; i++) {
		    for (char c = 'a'; c <= 'z'; c++) {
			char old = chs[i];
			chs[i] = c;
			String target = String.valueOf(chs);

			if (endSet.contains(target)) {
			    return len + 1;
			}

			if (!visited.contains(target) && wordSet.contains(target)) {
			    temp.add(target);
			    visited.add(target);
			}
			chs[i] = old;
		    }
		}
	    }

	    beginSet = temp;
	    len++;
	}

	return 0;
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
	Map<String, ArrayList<String>> wordMap = buildWordMap(beginWord, wordList);
	Vector<QItem> pathVector = new Vector<QItem>();
	Vector<Integer> endWordPosVector = new Vector<Integer>();
	BSF_graph(beginWord, endWord, wordMap, pathVector, endWordPosVector);
	List<List<String>> shortestPaths = new ArrayList<List<String>>();
	for (int i = 0; i < endWordPosVector.size(); i++) {
	    List<String> path = new ArrayList<String>();
	    List<String> resultPath = new ArrayList<String>();
	    int pos = endWordPosVector.get(i);
	    while (pos != -1) {
		QItem item = pathVector.get(pos);
		path.add(item.key);
		pos = item.previousPos;
	    }
	    for (int j = path.size() - 1; j >= 0; j--) {
		resultPath.add(path.get(j));
	    }
	    shortestPaths.add(resultPath);
	}
	return shortestPaths;
    }

    private void BSF_graph(String beginWord, String endWord, Map<String, ArrayList<String>> wordMap,
	    Vector<QItem> pathVector, Vector<Integer> endWordPosVector) {
	Map<String, Integer> visitedMap = new HashMap<String, Integer>();
	int min_steps = 0;
	pathVector.add(new QItem(beginWord, 1, -1));
	visitedMap.put(beginWord, 1);
	int front = 0;
	while (front != pathVector.size()) {
	    QItem nodeItem = pathVector.get(front);
	    int step = nodeItem.steps;
	    if(min_steps != 0 && step > min_steps) break;
	    if (nodeItem.key.equals(endWord)) {
		min_steps = step;
		endWordPosVector.add(front);
	    }
	    List<String> neighbors = wordMap.get(nodeItem.key);
	    for (String neighbor : neighbors) {
		if (!visitedMap.containsKey(neighbor) || (visitedMap.get(neighbor) >= (step + 1))) {
		    visitedMap.put(neighbor, step + 1);
		    pathVector.add(new QItem(neighbor, step + 1, front));
		}
	    }
	    front++;
	}
    }

    class QItem {
	String key;
	int steps;
	int previousPos;

	public QItem(String s, int i) {
	    key = s;
	    steps = i;
	    previousPos = -2;
	}

	public QItem(String s, int i, int pos) {
	    this(s, i);
	    previousPos = pos;
	}
    }
}
