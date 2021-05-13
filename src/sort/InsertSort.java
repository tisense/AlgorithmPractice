package sort;

import java.util.Arrays;

/**
 * 插入排序 思想： 有顺序表和无序表
 * 
 * @author renqi
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[] { 17, 3, 25, 14, 20, 9 };

		// 推倒过程
		// sort1(array);
		// 转化方程式
		sort3(array);
	}
	/**
	 * 优化方程式 
	 * @param array
	 */
	public static void sort3(int[] array) {
		
		for (int i = 0; i < array.length - 1; i++) {
			int insertIndex = i + 1;
			int temp = array[insertIndex];
			while ( insertIndex > 0 ) {
				if (array[insertIndex - 1] <= array[insertIndex]) {
					insertIndex = insertIndex - 1;
					break;
				}
				insertIndex --;
			}
			int rightIndex = i + 1;
			while (rightIndex > insertIndex) {
				array[rightIndex] = array[rightIndex - 1];
				rightIndex--;
			}
			array[insertIndex] = temp;
			System.out.println(Arrays.toString(array));
		}
	}
	
	/**
	 * 转化方程式 
	 * @param array
	 */
	public static void sort2(int[] array) {
		
		for (int i = 0; i < array.length - 1; i++) {
			int rightIndex = i + 1;
			int leftIndex = 0;
			int insertIndex = rightIndex; // 默认不用做插入
			while (leftIndex < rightIndex) {
				if (array[leftIndex] >= array[rightIndex]) {
					insertIndex = leftIndex;
					break;
				}
				leftIndex++;
			}
			
			int temp = array[rightIndex];
			while (rightIndex > insertIndex) {
				array[rightIndex] = array[rightIndex - 1];
				rightIndex--;
			}
			array[insertIndex] = temp;
			System.out.println(Arrays.toString(array));
		}
	}

	/**
	 * 推倒过程:
	 *     1. 寻找左边数组插入的位置
	 *     2. 完成插入操作
	 */
	public static void sort1(int[] array) {
		System.out.println(Arrays.toString(array));
		// 初始状态 17 | 3, 25, 14, 20, 9
		// 第一次   3, 17 | 25, 14, 20, 9

		int rightIndex = 1;
		int leftIndex = 0;
		int insertIndex = rightIndex; // 默认不用做插入
		while (leftIndex < rightIndex) {
			if (array[leftIndex] >= array[rightIndex]) {
				insertIndex = leftIndex;
				break;
			}
			leftIndex++;
		}
		
		int temp = array[rightIndex];
		while (rightIndex > insertIndex) {
			array[rightIndex] = array[rightIndex - 1];
			rightIndex--;
		}
		array[insertIndex] = temp;
		System.out.println(Arrays.toString(array));
		
		
		// 第二次 3, 17 ,25 | 14, 20, 9

		rightIndex = 1+1;
		leftIndex = 0;
		insertIndex = rightIndex; // 默认不用做插入
		while (leftIndex < rightIndex) {
			if (array[leftIndex] >= array[rightIndex]) {
				insertIndex = leftIndex;
				break;
			}
			leftIndex++;
		}

	    temp = array[rightIndex];
		while (rightIndex > insertIndex) {
			array[rightIndex] = array[rightIndex - 1];
			rightIndex--;
		}
		array[insertIndex] = temp;
		System.out.println(Arrays.toString(array));
		
		
		// 第三次 3, 14, 17 ,25| 20, 9
		rightIndex = 1+2;
		leftIndex = 0;
		insertIndex = rightIndex; // 默认不用做插入
		while (leftIndex < rightIndex) {
			if (array[leftIndex] >= array[rightIndex]) {
				insertIndex = leftIndex;
				break;
			}
			leftIndex++;
		}
	    temp = array[rightIndex];
		while (rightIndex > insertIndex) {
			array[rightIndex] = array[rightIndex - 1];
			rightIndex--;
		}
		array[insertIndex] = temp;
		System.out.println(Arrays.toString(array));
	}
}
