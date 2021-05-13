package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和 \ 三元组
 * @author renqi
 *
 */
public class Algorithms_15 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//
		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		threeSum(nums);
//		List<List<Integer>> resultList = threeSum(nums);
//		for (int i = 0; i < resultList.size(); i++) {
//			List<Integer> item = resultList.get(i);
//			System.out.println(item.get(0) + "," + item.get(1) + "," + item.get(2) + "\n");
//		}
	}

	// a + b + c = 0;
	// a + b = 0 - c;
	// 排序 + 双指针
	// 1、一般思路三层循环
	// 2、因为不能重复，第2层♻️和第3层♻️是此消彼长的关系，例如 a + b + c = 0，如果a确定，b、c 动态的，b增加，c 一定减小
	// 3、注意 第2、3层循环 一定要找一个和上次不一样的数字
	// tips：
	// 双指针 是不可以使用for循环的 指针的移动 一定是在同一层循环
    public static List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    	if (nums == null || nums.length < 3) {
			return resultList;
		}
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length; i++) {
    		// 当前数字i 大于0 直接退出循环
    		if (nums[i] > 0) break;
    		// 相同的两个值则跳到下一个不同的值
    		if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
    		int L = i + 1;
    		int R = nums.length -1;
    		while ( L < R) {
				int sum = nums[i] + nums[L] + nums[R];
				if (sum == 0) {
					resultList.add(Arrays.asList(nums[i], nums[L], nums[R]));
					System.out.println(nums[i] + "," + nums[L] + "," + nums[R]);
					while ( L < R && nums[L] == nums[L + 1]) L++;
					while ( L < R && nums[R] == nums[R - 1]) R--;
					L ++;
					R --;
				}else if (sum < 0) {
					L ++;
				}else if (sum > 0) {
					R --;
				}
			}
		}
    	return resultList;
    }
	
    /**
     * 3层for循环
     * 超出时间限制
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
    	List<List<Integer>> resultList = new ArrayList<List<Integer>>();
    	if (nums == null || nums.length < 3) {
			return resultList;
		}
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length; i++) {
    		// 当前数字i 大于0 直接退出循环
    		if (nums[i] > 0) break;
    		// 相同的两个值则跳到下一个不同的值
    		if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
    		for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				for (int k = nums.length - 1; k > j; k--) {
					if (nums[i] + nums[k] + nums[j] < 0) {
						break;
					}
					if (k < nums.length - 1  && nums[k] == nums[k + 1] || nums[i] + nums[k] + nums[j] > 0) {
						continue;
					}
					if (nums[i] + nums[k] + nums[j] == 0) {
						List<Integer> item = new ArrayList<Integer>(3);
						item.add(nums[i]);
						item.add(nums[j]);
						item.add(nums[k]);
						resultList.add(item);
						System.out.println(nums[i] + "," + nums[j] + "," + nums[k]);
					}
				}
			}
    	}
    	return resultList;
    }
}
