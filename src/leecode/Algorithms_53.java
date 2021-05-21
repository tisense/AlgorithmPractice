package leecode;

/**
 * leetcode 53 maxinum subarray
 * 
 * 思路1: 动态规划（Dynamic Programming）  O(n)
 * 思路2: 分治（Divide and Conquer） 解法更优
 * 思路3: 贪心算法  O(n)
 *  
 *  
 *  查看官方的视频，介绍的贪心算法和动态规划并不好区分，容易混淆或者混用
 * 
 * @author renqi
 *
 */
public class Algorithms_53 {

	public static void main(String[] args) {
		int[] nums01 = new int[]{-2,1,-3,4,-1,2,1,-5,4};
		int[] nums02 = new int[]{1};
		int[] nums03 = new int[]{5,4,-1,7,8};
		int[] nums04 = new int[]{-2,1};
		System.out.println(maxSubArray02(nums01));
	}

	/**
	 * 动态规划：若当前一个元素>0，则将其加到当前元素上（容易理解）
	 * 
	 * 1、记录下以f(i)结尾的最大值，不是以f(i)为开头的最大值，“开头”和“结尾” 思考方式差距很大
	 * 2、状态转移的时机：f(i-1)<0 决定f(i)的值，
	 * 3、状态转移的过程中 比较 f(i-1)和f(i)最大值
	 * 4、将f(i)的值直接赋值给数组nums[i]可以降低空间复杂度 
	 * 
	 * 
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(1)
	 * @param nums
	 * @return
	 */
	public static int maxSubArray(int[] nums) {
		if (nums.length < 1) {
			return 0;
		}
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < 0) {
				
			}else {
				nums[i] = nums[i - 1] + nums[i];
			}
			sum = Math.max(sum, nums[i]);
		}
		return sum;
    }
	
	/**
	 * 贪心算法: 若当前指针所指元素之前的和小于0，则丢弃当前元素之前的数列，（并不好理解）
	 * 当前值
	 * 之前和
	 * 当前和
	 * 最大和
	 * @param nums
	 * @return
	 */
	public static int maxSubArray02(int[] nums) {
		int currentSum = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (currentSum < 0) {
				currentSum = nums[i];
			}else {
				currentSum += nums[i];
			}
			//不好理解“丢弃当前元素之前数列”
			//currentSum = Math.max(nums[i], currentSum + nums[i]);
			max = Math.max(max, currentSum);
		}
		return max;
	}
}
