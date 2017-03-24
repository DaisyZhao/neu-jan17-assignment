package midtermexam;

import java.util.*;

/**
 * @author Xueying Zhao
 */
public class MidtermExam {
    /**
     * Question 1: reverse the order of elements in an ArrayList<E> without creating a new ArrayList
     */
    public static <E> void reverse(ArrayList<E> list) {                //correct
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                list.add(list.remove(i));
            }
        }
    }

    /**
     * Question 2: return a string that contains all unique two-character strings whose first character comes from the
     * first string and second character comes from the second string.
     *
     * Solution A
     */
    public static String generateStrings(String s1, String s2) {       //correct
        Set<String> resultSet = new TreeSet<>();

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                resultSet.add(String.valueOf(s1.charAt(i)) + String.valueOf(s2.charAt(j)));
            }
        }

        return String.join(" ", resultSet);
    }

    /**
     * Solution B of Question 2
     */
    public static String anotherGenerateStrings(String s1, String s2) {
        char[] s1Array = s1.toCharArray();
        char[] s2Array = s2.toCharArray();
        Arrays.sort(s1Array);
        Arrays.sort(s2Array);

        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < s1Array.length; i++) {
            for (int j = 0; j < s2Array.length; j++) {
                if ((i == 0 || s1Array[i] != s1Array[i-1]) && (j == 0 || s2Array[j] != s2Array[j-1])) {
                    resultList.add(String.valueOf(s1Array[i]) + String.valueOf(s2Array[j]));
                }
            }
        }

        return String.join(" ", resultList);
    }

    /**
     * Question 3: find the single element from an array of integers
     */
    public static int singleNumber(int[] nums) {          //correct
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                i++;
            } else {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }

    /**
     * Question 4: find indices of the two numbers such that they add up to a specific target
     */
    public int[] twoSum(int[] nums, int target) {          //correct
        Map<Integer, Integer> map = new HashMap<>();
        int[] position = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                position[0] = map.get(target - nums[i]);
                position[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }

        return position;
    }

    /**
     * Extra credit: return the kth row of the Pascal's triangle
     */
    public List<Integer> getRow(int rowIndex) {                     //correct
        List<Integer> listOfRow = new ArrayList<>();
        if (rowIndex == 0) {
            listOfRow.add(1);
        } else if (rowIndex == 1) {
            listOfRow.add(1);
            listOfRow.add(1);
        } else {
            listOfRow.add(1);
            List<Integer> lastRow = getRow(rowIndex - 1);
            for (int i = 0; i < lastRow.size() - 1; i++) {
                listOfRow.add(lastRow.get(i) + lastRow.get(i + 1));
            }
            listOfRow.add(1);
        }

        return listOfRow;
    }

    public static void main(String[] args) {
        // Test for reverse()
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(4, 5, 6, 7));
        reverse(list);
        System.out.print("Reversed ArrayList: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        // Test for generateStrings()
        String s1 = "ACDC";
        String s2 = "ABBA";
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.println("All two unique two-character strings: " + generateStrings(s1, s2));
        System.out.println("The result of Solution B is: " + anotherGenerateStrings(s1,s2));

        // Test for singleNumber()
        int[] nums1 = {2, 2, 5, 4, 5, 6, 4};
        System.out.println("-------------------------------------------");
        System.out.println("The single element is: " + singleNumber(nums1));

        // Test for twoSum()
        MidtermExam test = new MidtermExam();
        int[] nums2 = {2, 7, 11, 15};
        System.out.println("-------------------------------------------");
        System.out.print("The indices of the two numbers are: ");
        for (int i = 0; i < test.twoSum(nums2, 9).length; i++) {
            System.out.print(test.twoSum(nums2, 9)[i] + " ");
        }

        // Test for getRow()
        System.out.println();
        System.out.println("-------------------------------------------");
        System.out.print("The 3rd row of the Pascal's triangle is: ");
        for (int i = 0; i < test.getRow(3).size(); i++) {
            System.out.print(test.getRow(3).get(i) + " ");
        }


    }

}
