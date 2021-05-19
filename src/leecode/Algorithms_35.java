package leecode;

/**
 * leetcode 35 search insert position
 * 
 * runtime complexity: O(log n)
 * 
 * 潜在的要求：找到第一个 >= target 的数字索引
 * @author renqi
 * 
 *
 */
public class Algorithms_35 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] nums = new int[] {1,3,5,6};
		int target = 2;
		System.out.println(searchInsert(nums, target));
	}

	/**
	 * tips: 假设数组中无重复元素
	 * 找到第一个 >= target 的数字
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int searchInsert(int[] nums, int target) {
		
		if (nums[nums.length - 1] < target) {
			return nums.length;
		}
		if (nums[0] > target) {
			return 0;
		}
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int middle = left + (right - left)/2;
			//System.out.format("left=%d right=%d middle=%d\n", left, right, middle);
			if (nums[middle] < target) {
				left = middle + 1;
			}else {
				// 这里这里的区间
				right = middle;
			}
		}
		return left;
    }
}
