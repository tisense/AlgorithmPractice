package leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 17 电话号码的字符组合
 * @author renqi
 *	搜索算法： 深度优先、广度优先
 *  回溯 深度优先
 *  队列 广度优先
 */
public class Algorithms_17 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> reList = letterCombinations("23");
		for (int i = 0; i < reList.size(); i++) {
			System.out.println(reList.get(i));
		}
	}
	
    public static List<String> letterCombinations(String digits) {
    	List<String> combinations = new ArrayList<String>();
    	if (digits == null || digits.length() == 0) {
			return combinations;
		}
    	Map<Character, String> phoneMap = new HashMap<Character, String>() {
			private static final long serialVersionUID = 1L;

		{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        particalAnswer(combinations, phoneMap, digits, 0, new StringBuffer(""));
    	return combinations;
    }

    public static void particalAnswer(
    		List<String> combinations, 
    		Map<Character, String> phoneMap, 
    		String digits, 
    		int index, 
    		StringBuffer combination) {
		if (index == digits.length()) {
			//System.out.println(combination);
			combinations.add(combination.toString());
		}else {
			// 获取当前深度所需要的数据
			String currentDur =  phoneMap.get(digits.charAt(index));
			// 当前深度的循环
			for (int i = 0; i < currentDur.length(); i++) {
				combination.append(currentDur.charAt(i));
				// 进入下一个深度
				particalAnswer(combinations, phoneMap, digits, index+1, combination);
				// 删掉上一个循环需要的char 好进行下一次循环
				combination.deleteCharAt(index);
			}
		}
	}
}
