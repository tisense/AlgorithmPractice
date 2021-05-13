package leecode;

/**
 * 11 盛最多水的容器
 * @author renqi
 *
 */
public class Algorithms_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 方法：双指针法
	 * @param height
	 * @return
	 */
	public static int maxArea(int[] height) {
		
		int area = 0;
		int l = 0;
		int r = height.length -1;
		while (l < r) {
			int newArea = (r - l) * Math.min( height[l], height[r]);
			area = Math.max(area, newArea);
			if (height[l] > height[r]) {
				-- r;
			}else {
				++l;
			}
		}
		return area;
    }
}
