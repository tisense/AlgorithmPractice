package leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's triangle. 杨辉三角
 * 
 * @author renqi
 *
 */
public class Algorithms_118 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * 根据索引规律计算：
	 * 
	 * 第m行索引为i的值 是 第 m-1 行 索引为 i-1 和 i 的两个值的和 i-1 不存在时为对应的值取0；i不存在时值也取0
	 * 
	 * @param numRows
	 * @return
	 */
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			if (i == 0) {
				row.add(1);
				results.add(row);
			} else {
				List<Integer> preRow = results.get(i - 1);
				for (int j = 0; j <= i; j++) {
					int first = j - 1 < 0 ? 0 : preRow.get(j - 1);
					int second = j >= preRow.size() ? 0 : preRow.get(j);
					row.add(first + second);
				}
				results.add(row);
			}
		}
		return results;
	}

	/**
	 * leetcode119 输出杨辉三角第rowIndex行
	 * 
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {

		List<Integer> row = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < rowIndex + 1; i++) {

			if (i == 0) {
				result.add(1);
			} else {
				row.clear();
				row.addAll(result);
				result.clear();
				for (int j = 0; j <= i; j++) {
					int first = j - 1 < 0 ? 0 : row.get(j - 1);
					int second = j >= row.size() ? 0 : row.get(j);
					result.add(first + second);
				}
			}
		}
		return result;
	}
}
