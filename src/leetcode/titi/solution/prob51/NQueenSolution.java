package leetcode.titi.solution.prob51;

import java.util.ArrayList;
import java.util.List;

public class NQueenSolution {
	int DIMENSION = 4;
	private List<List<String>> resultList = new ArrayList();
	private List<List<Integer>> markMap = new ArrayList();
	private List<char[]> location = new ArrayList();
	public static final int DX[] = {-1, -1, -1, 0, 1, 1, 1, 0};
	public static final int DY[] = {-1, 0, 1, 1, 1, 0, -1, -1};
	public List<List<String>> solveNQueens(int n) {
        DIMENSION = n;
        for(int i=0; i<DIMENSION; i++) {
        	markMap.add(new ArrayList());
        	location.add(new char[DIMENSION]);
        	for(int j=0;j<DIMENSION; j++) {
        		markMap.get(i).add(j, 0);
        		location.get(i)[j] = '.';
        	}
        }
        process(0,DIMENSION);
        return resultList;
    }
	private void putDownQueenAtPosition(int x, int y) {
		markMap.get(x).set(y, 1);
		for(int i=1; i<markMap.size(); i++) {
			for(int j=0; j<8; j++) {
				int newX = x + (i*DX[j]);
				int newY = y + (i*DY[j]);
				if(newX >=0 && newX < markMap.size() && newY >=0 && newY < markMap.size()) {
					markMap.get(newX).set(newY, 1);
				}
			}
		}
	}
	private void process(int k, int n) {
		if(k == n) {
			resultList.add(copyLocation(location));
			return;
		}
		for(int j=0; j<n; j++) {
			if(markMap.get(k).get(j) == 0) {
				List<List<Integer>> tempMarkMap = copyMap(markMap);
				location.get(k)[j] = 'Q';
				putDownQueenAtPosition(k,j);
				process(k+1,n);
				markMap = tempMarkMap;
				location.get(k)[j] = '.';
			}
		}
	}
	private List<List<Integer>> copyMap(List<List<Integer>> mark) {
		List<List<Integer>> copy = new ArrayList();
		for(List l : mark) {
			copy.add(new ArrayList());
			copy.get(copy.size()-1).addAll(l);
		}
		return copy;
	}
	private List<String> copyLocation(List<char[]> location) {
		List<String> copy = new ArrayList();
		for(char[] l : location) {
			copy.add(new String(l));
		}
		return copy;
	}
}
