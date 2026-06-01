package class004;

import utils.ComparatorUtils;

import java.util.function.Consumer;

/**
 * 选择排序
 * 冒泡排序
 * 插入排序
 */

public class SelectBubbleInsert {

    /**
     * 选择排序
     * 从未排序空间内选择最小的，交换到第一个位置，然后往后推
     */
    public static void selectSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int target = i;
            for (int j = i; j < arr.length; j++) {
                target = arr[j] < arr[target] ? j : target;
            }
            swap(arr, i,  target);
        }
    }

    /**
     * 冒泡排序
     * 从左到右两两比较，如果左大，则左右交换，遍历一次后确定了最右端的位置，然后逐级缩小比较范围
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 插入排序
     * 从左开始的每个数字回头望，能插入则插入，插入不进去则停止
     */
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
                swap(arr, j, j + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 对数器：用 JDK 排序作为参照，验证指定排序方法是否正确。
     */
    public static boolean verifySort(String sortName, Consumer<int[]> sortMethod,
                                     int testTimes, int maxLength, int maxValue) {
        for (int i = 0; i < testTimes; i++) {
            int[] originalArr = ComparatorUtils.generateRandomArray(maxLength, maxValue);
            int[] actualArr = ComparatorUtils.copyArray(originalArr);
            int[] expectedArr = ComparatorUtils.copyArray(originalArr);

            sortMethod.accept(actualArr);
            ComparatorUtils.comparator(expectedArr);

            if (!ComparatorUtils.isEqual(actualArr, expectedArr)) {
                System.out.println(sortName + "验证失败");
                System.out.print("原始数组: ");
                ComparatorUtils.printArray(originalArr);
                System.out.print("排序结果: ");
                ComparatorUtils.printArray(actualArr);
                System.out.print("正确结果: ");
                ComparatorUtils.printArray(expectedArr);
                return false;
            }
        }
        System.out.println(sortName + "验证通过");
        return true;
    }

    public static void main(String[] args) {
        int testTimes = 100_000;
        int maxLength = 100;
        int maxValue = 1_000;

        boolean selectSortSuccess = verifySort(
                "选择排序", SelectBubbleInsert::selectSort, testTimes, maxLength, maxValue);
        boolean bubbleSortSuccess = verifySort(
                "冒泡排序", SelectBubbleInsert::bubbleSort, testTimes, maxLength, maxValue);
        boolean insertSortSuccess = verifySort(
                "插入排序", SelectBubbleInsert::insertSort, testTimes, maxLength, maxValue);

        System.out.println(selectSortSuccess && bubbleSortSuccess && insertSortSuccess
                ? "三种排序算法全部验证通过"
                : "存在排序算法验证失败");
    }
}
