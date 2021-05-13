package leecode;

// 14. 最长公共前缀
public class Algorithms_14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//String [] b1 = new String[] {"flower","flow","flight"};
		String [] b2 = new String[] {"dog","racecar","car"};
		
		String res = longestCommonPrefix(b2);
		System.out.println(res);
	}
	

	/**
	 * 最长公共前缀
	 * @param strs
	 * @return
	 */
    public static String longestCommonPrefix(String[] strs) {
    	
    	String r = "";
    	if (strs.length < 1) {
			return r;
		}
    	r = strs[0];
    	for (int i = 1; i < strs.length; i++) {
    		int j = 0;
    		for (j = 0; j < r.length() && j < strs[i].length() ; j++) {
				if (r.charAt(j) != strs[i].charAt(j)) {
					break;
				}
			}
    		r = r.substring(0, j);
		}
    	return r;
    }
}
