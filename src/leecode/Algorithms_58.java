package leecode;

/**
 * 
 * leetcode 58 length of last word
 * 
 * 
 * @author renqi
 *
 */
public class Algorithms_58 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// ' ' == 32
		System.out.println("        ".trim().length());
		System.out.println(lengthOfLastWord(" a"));
		
	}
	
	/**
	 * ASCII Table:https://www.cs.cmu.edu/~pattis/15-1XX/common/handouts/ascii.html
	 * @param s   s consists of only English letters and spaces ' '  
	 * @return
	 * 
	 * 耗时 0 ms
	 * 时间复杂度 O(n)
	 * 
	 */
	public static int lengthOfLastWord(String s) {
		if (null == s || (s =s.trim()).equals("")) {
			return 0;
		}
		int i = s.length() - 1;
		boolean hasSpace = false;
		for (; i > 0; i--) {
			if (s.charAt(i) == 32) {
				hasSpace = true;
				break;
			}
		}
		return s.length() - i - (hasSpace?1:0);
    }

}
