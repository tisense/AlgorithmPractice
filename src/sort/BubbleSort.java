package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 
 * @author renqi
 * [ˈbʌbl]
 */
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] array = new int[] { 4, 4, 0, 5, 1 ,10};
//		sort1(array);
		sort2(array);
//		sort3(array);
	}

	/***
	 * 冒泡排序优化： 设置falg 如果一轮中一次交换都没有, 索命已经排序借宿，就退出循环
	 * 
	 * 思考: 是否可以在只有一次交换的时候退出循环，
	 * @param array
	 */
	public static void sort3(int[] array) {
		int temp = 0;
		boolean flag = false;// 标识是否进行过交换
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					flag = true;
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			// 一轮排序结束
			System.out.println("第" + (i + 1) + "次排序结果" + Arrays.toString(array));
			if (!flag) {
				System.out.println("break");
				break;
			} else {
				flag = false;
			}
		}
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 
	 * @param array
	 */
	public static void sort2(int[] array) {
		int temp = 0;
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - 1 - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
			System.out.println("第" + (i + 1) + "次排序结果" + Arrays.toString(array));
		}
		System.out.println(Arrays.toString(array));
	}

	/**
	 * 推到过程
	 * 
	 * @param array
	 */
	public static void sort1(int[] array) {
		// 4,3,2,1,5
		int temp = 0;
		for (int j = 0; j < array.length - 1; j++) {
			if (array[j] > array[j + 1]) {
				temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
		System.out.println(Arrays.toString(array));

		for (int j = 0; j < array.length - 1 - 1; j++) {
			if (array[j] > array[j + 1]) {
				temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
		System.out.println(Arrays.toString(array));

		for (int j = 0; j < array.length - 1 - 2; j++) {
			if (array[j] > array[j + 1]) {
				temp = array[j];
				array[j] = array[j + 1];
				array[j + 1] = temp;
			}
		}
		System.out.println(Arrays.toString(array));

	}
}
