import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    static void printProb(String msg) {
        System.out.println("=============================");
        System.out.println(msg);

    }

    static <T> void printAnswer(T answer) {
        System.out.println(answer);
    }

    static void printIntArray(int[] array) {
        for (Integer element : array) {

            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        printProb("Problem 1");
        List<Integer> numArray = new ArrayList(Arrays.asList(-4, -1, 0, 3, 10));
        List<Integer> numArray2 = new ArrayList(Arrays.asList(-7, -3, 2, 3, 11));
        printAnswer("Original List " + numArray);
        printIntArray(problem1(numArray));
        printAnswer("Original List " + numArray2);
        printIntArray(problem1(numArray2));

        List<Integer> problem2 = new ArrayList(Arrays.asList(-7, -3, 2, 3, 11));
        printProb("Problem 2");
        printAnswer("Original List " + problem2);
        printIntArray(problem2(problem2));

        printProb("Problem 3");
        List<Integer> problem3 = new ArrayList(Arrays.asList(0, 1, 0, 3, 12));
        List<Integer> array3 = new ArrayList(Arrays.asList(0));
        printAnswer("Original List " + problem3);
        printIntArray(problem3(problem3));
        printAnswer("Original List " + array3);
        printIntArray(problem3(array3));

        printProb("Problem 4");
        List<Integer> problem4 = new ArrayList(Arrays.asList(0, 1, 0, 3, 12));
        List<Integer> array4 = new ArrayList(Arrays.asList(0));
        printAnswer("Original List " + problem4);
        printIntArray(problem4(problem4));
        printAnswer("Original List " + array4);
        printIntArray(problem4(array4));

        printProb("Problem 5");
        List<Integer> nums1 = new ArrayList(Arrays.asList(1, 2, 3, 0, 0, 0));
        int m = 3;
        List<Integer> nums2 = new ArrayList(Arrays.asList(2, 5, 6));
        int n = 3;
        printAnswer("Original List " + nums1 + " & " + nums2);
        printIntArray(problem5(nums1, nums2, m, n));

        printProb("Problem 6");
        List<Integer> n1 = new ArrayList(Arrays.asList(10, 2, 3, 0, 0, 0));
        int a = 3;
        List<Integer> n2 = new ArrayList(Arrays.asList(2, 5, 9));
        int b = 3;
        printAnswer("Original List " + n1 + " & " + n2);
        printIntArray(problem6(n1, n2, a, b));

    }

    static int[] problem1(List<Integer> numbers) {
        return numbers.stream().mapToInt(e -> (int) Math.pow(e, 2)).sorted().toArray();

    }

    static int[] problem2(List<Integer> numbers) {
        // convert the list to an array
        int[] numsInArray = numbers.stream().mapToInt(Integer::intValue).toArray();

        int n = numsInArray.length, left = 0, right = n - 1;
        int[] result = new int[n];

        for (int index = n - 1; index >= 0; index--) {

            if (Math.abs(numsInArray[left]) > numsInArray[right]) {
                result[index] = numsInArray[left] * numsInArray[left];
                left++;
            } else {
                result[index] = numsInArray[right] * numsInArray[right];
                right--;
            }
        }
        for (int i = 0; i < n; i++) {
            numsInArray[i] = result[i];
        }

        return result;

    }

    static int[] problem3(List<Integer> numbers) {
        // convert the list to an array
        int[] numsInArray = numbers.stream().mapToInt(Integer::intValue).toArray();
        int arrayLength = numsInArray.length;

        if (arrayLength == 0) {
            return numsInArray;
        }

        int counter = 0;
        for (int i = 0; i < arrayLength; i++) {
            if (numsInArray[i] != 0) {
                numsInArray[counter++] = numsInArray[i];
            }
        }
        printAnswer("counter val: " +counter);
        while (counter < arrayLength) {
            numsInArray[counter++] = 0;
        }
        return numsInArray;
    }

    static int[] problem4(List<Integer> numbers) {
        int[] numsInArray = numbers.stream().mapToInt(Integer::intValue).toArray();
        int arrayLength = numsInArray.length;
        int j = -1;
        int i = 0;

        while (i < arrayLength) {
            if (numsInArray[i] == 0 && j == -1) {
                j = i;
            } else if (numsInArray[i] != 0 && j != -1) {
                numsInArray[j] = numsInArray[i];
                numsInArray[i] = 0;
                j++;
            }
            i++;
        }
        return numsInArray;
    }

    public static int[] problem5(List<Integer> nums1, List<Integer> nums2, int m, int n) {

        List<Integer> mergeList = Stream.concat(nums1.stream().limit(m), nums2.stream().limit(n))
                .collect(Collectors.toList());
        int[] mergeArray = mergeList.stream().sorted().mapToInt(Integer::intValue).toArray();
        return mergeArray;
    }

    public static int[] problem6(List<Integer> nums1, List<Integer> nums2, int m, int n) {

        List<Integer> mergeList = Stream.concat(nums1.stream().limit(m), nums2.stream().limit(n))
                .collect(Collectors.toList());
        int[] mergeArray = mergeList.stream().mapToInt(Integer::intValue).toArray();
        int arrayLength = mergeArray.length;

        for (int i = 0; i < arrayLength; i++) {
            for (int j = i + 1; j < arrayLength; j++) {
                if (mergeArray[i] > mergeArray[j]) {
                    swap(mergeArray, i, j);
                   
                }
            }
        }

        return mergeArray;
    }
    private static void swap(int[]arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
