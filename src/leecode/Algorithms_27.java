package leecode;


/**
 * leetcode 27 移除元素
 * 
 * 
 * 分析：和 leetcode 26 考点相同 方法都是双指针
 * 该双指针 一头、一尾， 有的双指针是一前一后 比如 leetcode 26；
 * leetcode 26 是有序数组，
 * @author renqi
 *
 */
public class Algorithms_27 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = new int []{1,2,3,4};
		System.out.println(removeElement(nums, 1));
		
	}
	
	/**
	 * 头指针查找 目标数字
	 * 尾指针查找 非目标数字 进行交换
	 * @param nums
	 * @param val
	 * @return
	 */
    public static int removeElement(int[] nums, int val) {
    	int start = 0;
    	int end = nums.length - 1;
    	while (start <= end) {
			if (nums[start] == val) {
				while (start <= end) {
					//System.out.println("find end");
					if (nums[end] == val) {
						-- end;
					}else {
						nums[start ++ ] = nums[end --];
						// tips：开始的时候忽略了终止条件
						break;
					}
				}
			}else {
				start ++;
			}
		}
    	return start;
    }

}
