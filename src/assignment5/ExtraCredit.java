package assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Xueying Zhao
 */
public class ExtraCredit {
    /**
     * 1. Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one ascending sorted array.
     * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int count = 0;
        while (count < m + n && i >= 0 && j >= 0) {
            if (nums1[i] >= nums2[j]) {
                nums1[m + n - 1 - count] = nums1[i];
                i--;
            } else {
                nums1[m + n - 1 - count] = nums2[j];
                j--;
            }
            count++;
        }
        if (i < 0) {
            for (; j >= 0; j--) {
                nums1[j] = nums2[j];
            }
        }

        // print to test results
        for (int k = 0; k < m + n; k++) {
            System.out.print(nums1[k] + " ");
        }
        System.out.println();
    }

    /**
     * 2. Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
     * For example,
     * Given the following matrix:
     * {{1,2,3},
     * {4,5,6},
     * {7,8,9}}
     * You should return {1,2,3,6,9,8,7,4,5}.
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiralList = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;

        while (count * 2 < row && count * 2 < col) {
            for (int i = count; i < col - count; i++) {
                spiralList.add(matrix[count][i]);
            }
            for (int i = count + 1; i < row - count; i++) {
                spiralList.add(matrix[i][col - count - 1]);
            }
            if (row - 2 * count == 1 || col - 2 * count == 1) {
                break;
            }

            for (int i = col - count - 2; i >= count; i--) {
                spiralList.add(matrix[row - count - 1][i]);
            }
            for (int i = row - count - 2; i >= count + 1; i--) {
                spiralList.add(matrix[i][count]);
            }
            count++;
        }

        return spiralList;
    }

    public static void main(String args[]) {
        ExtraCredit test = new ExtraCredit();

        int[] num1 = new int[10];
        for (int i = 0; i < 3; i++) {
            num1[i] = i * 5;
        }
        int[] num2 = {3, 6, 9};
        System.out.println("Test of merge()");
        test.merge(num1, 3, num2, 3);

        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        System.out.println("Test of spiralOrder():");
        for (int i = 0; i < test.spiralOrder(matrix).size(); i++) {
            System.out.print(test.spiralOrder(matrix).get(i) + " ");
        }
        System.out.println();
    }

}
