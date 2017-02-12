package assignment4;

/**
 * @author Xueying Zhao
 */
public class ExtraCredit {
    // 1. Given an array containing n distinct numbers taken from 0, 1, 2 …, n, find the one that is missing from the array.
    // For example, given nums = {0, 1, 3}, return 2.
    public static int missingNumber(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        for (int i = 0; i <= nums.length; i++) {
            result = result ^ i;
        }

        return result;
    }


    // 2.Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of
    // the non-zero elements. For example, given nums = {0, 1, 0, 3, 12}, after calling your function,
    // nums should be {1, 3, 12, 0, 0}, You must do this in-place without making a copy of the array.

    public static void moveZeroes(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length-1; j++) {
                    nums[j] = nums[j + 1];
                }
                nums[nums.length-1] = 0;
            }
        }
    }

    // 3.Given a non-empty array of integers, return the third maximum distinct number in this array. If it does not exist,
    // return the maximum number. For example, given{3,2,1}, return 1; given{1,2}, return 2; given{2,2,3,1}, return 1.

    public static int thirdMax(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if (nums[i] < max1 && nums[i] > max2) {
                max3 = max2;
                max2 = nums[i];
            } else if (nums[i] < max2 && nums[i] > max3) {
                max3 = nums[i];
            }
        }

        if (max3 == Integer.MIN_VALUE || max2 == max3) {
            return max1;
        } else {
            return max3;
        }

    }

    public static void main(String[] args) {

        System.out.println("Test missingNumber with input {0, 1, 3}:");
        System.out.println(missingNumber(new int[] {0,1,3}));

        System.out.println("Test moveZeros with input {0, 1, 0, 3, 12}:");
        int[] nums = new int[] {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        System.out.println("Test thirdMax with input {3, 2, 1}:");
        System.out.println(thirdMax(new int[] {3, 2, 1}));
        System.out.println("Test thirdMax with input {1, 2}:");
        System.out.println(thirdMax(new int[] {1, 2}));
        System.out.println("Test thirdMax with input {2, 2, 3, 1}:");
        System.out.println(thirdMax(new int[] {2, 2, 3, 1}));
    }

}
