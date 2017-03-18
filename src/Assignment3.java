/*
score: 10 + 2 = 10(the total score will be no more than 10)
comments: Your code is really impressive!! Keep doing!
*/
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Rose on 1/27/17.
 * Assignment for your lecture 3. Please finish all the questions under
 * 'Assignment'. Please try to think the extra credit questions. The deadline
 * of this assignment is 02/04/2017 23:59 PST. Please feel free to contact me
 * for any questions. Please write your comments about this assignment in the
 * end.
 */


public class Assignment3 {
    /**
     *  Given an array, reverse the elements within this array and print the result
     *  eg, given{1,2,3,4}, print{4,3,2,1}
     */
    public void reverseArray(int[] nums) {                  //correct
        int temp;

        for (int i = 0; i < nums.length / 2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        System.out.print ("Reversed arrays are: ");
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    /**
     *  Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
     *  Assume the integer do not contain any leading zero, except the number 0 itself.
     *  The digits are stored such that the most significant digit is at the head of the array.
     *  eg, given {1,2,9}, return{1,3,0}.
     */
    public int[] plusOne(int[] digits) {            //correct

        // make a copy of the input digits
        int[] result = digits.clone();

        // carry-over
        int c = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            int sum = result[i] + c;
            if (i == digits.length - 1) {
               sum += 1;
            }
            result[i] = sum % 10;
            c = sum / 10;
        }

        if (c != 0) {
            int[] finalResult = new int[result.length + 1];
            finalResult[0] = c;
            for (int i = 1; i < finalResult.length; i++) {
                finalResult[i] = result[i - 1];
            }
            return finalResult;
        } else {
            return result;
        }
    }

    /**
     *  Write a program that takes an integer as input and returns all the primes between 1 and that integer(inclusive).
     *  eg, input is 18, you should return{2,3,5,7,11,13,17}
     */
    public int[] generatePrimes(int n) {               //correct

        List<Integer> primeList = new ArrayList<>();

        if (n <= 1) {
            return new int[0];
        } else {
            for (int i = 2; i <= n; i++) {
                if (isPrime(i)) {
                    primeList.add(i);
                }
            }

            int[] primes = new int[primeList.size()];

            for (int i = 0; i < primeList.size(); i++) {
                primes[i] = primeList.get(i);
            }

            return primes;
        }
    }

    public boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *  Assume you have a method isSubstring which checks if one word is a substring of another.
     *  Given two strings, s1 and s2, write a program to check if s2 is a rotation of s1, using only one call
     *  to isSubstring
     *  eg, "pineapple" is a rotation of "neapplepi"
     */
    public boolean isRotation(String s1, String s2) {                    //correct
        String doubleS1 = s1 + s1;
        // If String s2 is a rotation of s1, then s2 must be the substring of s1 concatenated by s1.
        if (isSubstring(doubleS1, s2)){
            return true;
        } else {
            return false;
        }
    }

    public boolean isSubstring(String s1, String s2) {
        if (s1.indexOf(s2) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     *  Given two strings, write a method to decide if one is a permutation of the other
     *  hint: the comparison is case sensitive and whitespace is significant
     */
    public boolean isPermutation(String s1, String s2) {           //correct

        if (s1.length() != s2.length()) {
            return false;
        } else {
            int[] charNum = new int[128];

            for (int i = 0; i < 128; i++) {                         //no need to do these, because the initial value of int is 0
                charNum[i] = 0;
            }

            for (int i = 0; i < s1.length(); i++) {
                charNum[s1.charAt(i)]++;
                charNum[s2.charAt(i)]--;
            }

            for (int i = 0; i < charNum.length; i++) {
                if (charNum[i] != 0) {
                    return false;
                }
            }
            return true;
        }

    }

    /**
     *  Write a program to implement encoding and decoding string. The rule is simple: encode successive
     *  repeated characters by the repetition count and the character. For example, the input of encoding()
     *  is "aaaabcccaa", you should return "4a1b3c2a". The decoding of "3e4f2e" returns "eeeffffee". Assume
     *  the string to be encoded consists of letters of the alphabet, with no digits, and the string to be
     *  decoded is a valid encoding.
     */
    public static String encoding(String s) {                   //correct

        if (s.length() == 0) {
            return "";
        } else if (s.length() == 1) {
            return "1" + s;
        } else {
            String result = "";
            int count = 1;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i-1)) {
                    count++;
                } else {
                    result = result + count + s.charAt(i-1);
                    count = 1;
                }
            }
            return result + count + s.charAt(s.length() - 1);
        }
    }

    public static String decoding(String s) {

        int letterCount = 0;
        String result = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ( c >= 48 && c <= 57) {
                letterCount = letterCount * 10 + (c - 48);
            } else {
                for (int j = 0; j < letterCount; j++) {
                    result = result + c;
                }
                letterCount = 0;
            }
        }

        return result;
    }

    // Extra Credit
    /**
     * Given an m x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
     * For exmaple, given 1 2 3  , return 7 4 1
     *                    4 5,6           8 5 2
     *                    7,8,9           9 6 3
     * tip: image could be a square or a rectangle.
     */
    public void rotate(int[][] matrix) {              //correct
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] rotatedMatrix = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                rotatedMatrix[j][row-i-1] = matrix[i][j];
            }
        }

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

     /**
     *Given a string containing just the characters '(', ')', return the count of valid parentheses. If the
     * intput is not valid, return -1. A valid parentheses is "()". For example, given "(())", return 2;
     * given "(()))", return -1.
     */
     public int countValidParentheses(String s) {          //awesome!!!
         Stack<Character> st = new Stack<>();
         int bracketCount = 0;

         for (int i = 0; i < s.length(); i++) {
             // If it is '(', push it into the stack. If it is ')', pop a '(' from the stack to match the ')'
             if (s.charAt(i) == ')') {
                 if (!st.empty() && st.pop() == '(') {
                     bracketCount++;
                 } else {
                     return -1;
                 }
             } else {
                 st.push(s.charAt(i));
             }
         }

         // If stack is not empty, then there is one or more unmatched '('
         if (!st.empty()) {
             return -1;
         }

         return bracketCount;
     }

    /**
     * Write anything you think about this assignment here. Easy? Difficult? Too many questions? Less fun?
     * You could write any comments here
     */

    public static void main(String[] args) {
        Assignment3 test = new Assignment3();

        System.out.println("---------------------------------------------");
        System.out.println("Test of reverseArray() method:");
        int[] reverseNum = {1,2,3,6,8};
        test.reverseArray(reverseNum);

        System.out.println("---------------------------------------------");
        System.out.println("Test of plusOne() method:");
        int[] plusOneTest = {9,9,9,9};
        System.out.print("After plus one, the array is: ");
        for (int i = 0; i < test.plusOne(plusOneTest).length; i++) {
            System.out.print(test.plusOne(plusOneTest)[i] + " ");
        }
        System.out.println();

        System.out.println("---------------------------------------------");
        System.out.println("Test of generatePrimes() method:");
        for (int i = 0; i < test.generatePrimes(20).length; i++) {
            System.out.print(test.generatePrimes(20)[i] + " ");

        }
        System.out.println();

        System.out.println("---------------------------------------------");
        System.out.println("Test of isRotation() method:");
        System.out.println(test.isRotation("pineapple", "plepineap"));

        System.out.println("---------------------------------------------");
        System.out.println("Test of isPermutation() method:");
        System.out.println(test.isPermutation("pine1ap2pl3 e","plep321ine ap"));

        System.out.println("---------------------------------------------");
        System.out.println("Test of encoding() method:");
        System.out.println(encoding("aaaabcccaa"));

        System.out.println("---------------------------------------------");
        System.out.println("Test of decoding() method:");
        System.out.println(decoding("5e2f1d"));

        System.out.println("---------------------------------------------");
        System.out.println("Test of rotate() method:");
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        test.rotate(matrix);

        System.out.println("---------------------------------------------");
        System.out.println("Test of countValidParenthese() method:");
        System.out.println(test.countValidParentheses("()(()))"));
    }
}
