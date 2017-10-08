package leetcode.titi.solution.prob6;

public class Prob6Solution {
	public String ZigZagConvert(String s, int nRows) {
		int len = s.length(), k = 0, interval = (nRows<<1)-2;
		if(nRows == 1 || nRows >= len)	return s;  
        char[] res = new char[len];
        for(int j = 0; j < len ; j += interval)//处理第一行
            res[k++] = s.charAt(j);
        for(int i = 1; i < nRows-1; i++)//处理中间行
        {
            int inter = (i<<1);
            for(int j = i; j < len; j += inter)
            {
                res[k++] = s.charAt(j);
                inter = interval - inter;
            }
        }
        for(int j = nRows-1; j < len ; j += interval)//处理最后一行
            res[k++] = s.charAt(j);
        return String.valueOf(res);
	}
}
