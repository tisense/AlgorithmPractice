package leecode;

/**
 * 
 * primary
 * 删除数组中重复的项，要求空间复杂度是O(1)
 * 方法：双指针
 * @author renqi
 *
 */
public class Algorithms_26 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 3;
		System.out.println(a++);
		System.out.println(++a);
	}

	public static int removeDuplicates(int[] nums) {
		
		if (nums.length == 1) {
			return nums.length;
		}
		int start = 0;
		int end = start + 1;
		while (end <= nums.length -1) {
			if (nums[start] == nums[end]) {
				end ++;
			}else {
				nums[++start] = nums[end++];
			}
		}
		return ++start;
    }
}
