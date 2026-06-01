package utils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 对数器可以使用的公共方法。
 */
public class ComparatorUtils {

    private ComparatorUtils() {
    }

    /**
     * 生成长度为 [0, maxLength]、值为 [-maxValue, maxValue] 的随机数组。
     */
    public static int[] generateRandomArray(int maxLength, int maxValue) {
        if (maxLength < 0 || maxValue < 0) {
            throw new IllegalArgumentException("maxLength and maxValue must not be negative");
        }
        int[] arr = new int[ThreadLocalRandom.current().nextInt(maxLength + 1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ThreadLocalRandom.current().nextInt(maxValue + 1)
                    - ThreadLocalRandom.current().nextInt(maxValue + 1);
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        return arr == null ? null : Arrays.copyOf(arr, arr.length);
    }

    /**
     * 使用 JDK 排序作为可靠的参照实现。
     */
    public static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    public static boolean isEqual(int[] arr1, int[] arr2) {
        return Arrays.equals(arr1, arr2);
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }
}
