package leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * 题：两数之和
 * 方案：哈希表算法
 * @author renqi
 *
 */
public class Algorithms_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int[]{3, 2, 4};
		// int [] nums2 = new int[]{6, 3, 8, 2, 1};
		int [] res = twoSum(nums, 6);
		System.out.println("["+res[0]+"," + res[1]+"]");
	}

	
    public static int[] twoSum(int[] nums, int target) {
    	
    	Map<Integer,Integer> hashTable = new HashMap<Integer, Integer>(nums.length -1);
    	hashTable.put(nums[0], 0);
    	for (int i = 1; i < nums.length; i++) {
			int value = target - nums[i];
			if (hashTable.containsKey(value)) {
				return new int[]{hashTable.get(value),i};
			}else {
				hashTable.put(nums[i], i);
			}
		}
    	return new int[]{0,0};
    }
}
