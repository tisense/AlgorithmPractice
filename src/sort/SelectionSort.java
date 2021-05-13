package sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[] { 4, 20, 0, 5, 1 ,10};
		//sort(array);
		sort2(array);
	}
	
	/**
	 *  优化
	 * @param array
	 */
	public static void sort3(int array[]) {
		
		for (int i = 0; i < array.length; i++) {
			// 
			int index = i;
			int temp = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (temp > array[j]) {
					temp = array[j];
					index = j;
				}
			}
			if (index != i) {
				array[index] = array[i];
				array[i] = temp;
			}
			System.out.println("第" + (i) + "次排序结果" + Arrays.toString(array));
		}
	}
	
	/**
	 * 结果
	 * @param array
	 */
	public static void sort2(int array[]) {
		
		for (int i = 0; i < array.length; i++) {
			// 
			int index = i;
			int temp = array[i];
			for (int j = i + 1; j < array.length; j++) {
				if (temp > array[j]) {
					temp = array[j];
					index = j;
				}
			}
			array[index] = array[i];
			array[i] = temp;
			System.out.println("第" + (i) + "次排序结果" + Arrays.toString(array));
		}
	}
	
	/**
	 * 推倒过程
	 * @param array
	 */
	public static void sort(int array[]) {
		
		// 
		int index = 0;
		int temp = array[0];
		for (int j = 0 + 1; j < array.length; j++) {
			if (temp > array[j]) {
				temp = array[j];
				index = j;
			}
		}
		array[index] = array[0];
		array[0] = temp;
		System.out.println("第" + (1) + "次排序结果" + Arrays.toString(array));
		
		
		
		index = 1;
		temp = array[1];
		for (int j = 1 + 1 ; j < array.length; j++) {
			if (temp > array[j]) {
				temp = array[j];
				index = j;
			}
		}
		array[index] = array[1];
		array[1] = temp;
		System.out.println("第" + (2) + "次排序结果" + Arrays.toString(array));
		
		
		
		index = 2;
		temp = array[2];
		for (int j = 2 + 1; j < array.length; j++) {
			if (temp > array[j]) {
				temp = array[j];
				index = j;
			}
		}
		array[index] = array[2];
		array[2] = temp;
		System.out.println("第" + (3) + "次排序结果" + Arrays.toString(array));
	}
}
