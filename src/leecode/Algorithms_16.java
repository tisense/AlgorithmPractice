package leecode;

import java.util.Arrays;

/**
 * 16 最接近的3数只和
 * 
 * @author renqi
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 */
public class Algorithms_16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// int [] data = new int []{-1,2,1,-4};
		// int [] data2 = new int []{0,2,1,-3}; // -3, 0, 1, 2
		// [-1,0,1,1,55] 3
		int [] data3 = new int []{-1,0,1,1,55};
		System.out.println(threeSumClosest(data3, 1));
	}

	/**
	 * 1、排序
	 * 2、指针
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int threeSumClosest(int[] nums, int target) {
    	if (nums == null || nums.length < 3) {
			return 0;
		}
    	Arrays.sort(nums);
    	int result = nums[0] + nums[1] + nums[2];
    	for (int i = 0; i < nums.length; ++i) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int L = i + 1;
			int R = nums.length -1;       
			while (L < R) {
				int tar = nums[i] + nums[L] + nums[R];
				if (tar == target) {
					return tar;
				}
				System.out.println(nums[i] + "," + nums[L] + "," + nums[R]);  
				if (Math.abs(tar - target) < Math.abs(result - target)) {
					result = tar;
				}
				if (tar > target) {
					--R; // 我这里出错了
					while (L < R && nums[R] == nums[R + 1]) --R;
				}else {
					++L; // 我这里出错了
					while (L < R && nums[L] == nums[L - 1]) ++L;
				}
			}
		}
    	return result;
    }
}
