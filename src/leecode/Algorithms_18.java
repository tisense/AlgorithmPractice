package leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4数之和 
 * 方法：排序 + 双指针
 * @author renqi
 *
 */
public class Algorithms_18 {
	

	public static void main(String[] args) {
		//int [] data = new int[] {1,0,-1,0,-2,2};
		//int [] data2 = new int[] {-2,-1,-1,1,1,2,2};
		//int [] data3 = new int[] { 0, 0, 0, 0};
		int [] data4 = new int[] { -5,-4,-3,-2,-1,0,0,1,2,3,4,5};
		// []

		// -2,-1,-1,1,1,2,2  0
		fourSum(data4, 0);
	}
	
	
    public static List<List<Integer>> fourSum(int[] nums, int target) {

    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (nums == null || nums.length < 3) {
			return result;
		}
    	// 排序
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length - 3; i++) {
    		// 过滤条件要严谨
    		if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
    		
    		if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
    		for (int j = i+1; j < nums.length - 2; j++) {
    			// 过滤条件要严谨
    			if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }

				// 小心这里的过滤条件：j > i+1
				if (j > i+1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int L = j + 1;
				int R = nums.length - 1;
				while (L < R) {
					if (nums[i] + nums[j] + nums[L] + nums[R] == target) {
						result.add(Arrays.asList(nums[i], nums[j], nums[L], nums[R]));
						System.out.format("%d,%d,%d,%d%s",nums[i], nums[j], nums[L], nums[R],"\n");
						L ++;
						R --;
						//去重
						while (L < R && nums[L] == nums[L - 1]) {
							L ++;
						}
						// 去重
						while (L < R && nums[R] == nums[R + 1]) {
							R --;
						}
					}else if (nums[i] + nums[j] + nums[L] + nums[R] < target){
						L ++;
					}else {
						R --;
					}
				}
			}
		}
    	return result;
    }

}
