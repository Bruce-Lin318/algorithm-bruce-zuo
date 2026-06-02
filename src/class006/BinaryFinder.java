package class006;

import javax.sound.midi.MidiChannel;
import java.util.Arrays;
import java.util.MissingFormatArgumentException;

/**
 * 二分查找
 * 1.二分查找
 * 2.查找小于 num 的最大位置
 * 3.查找大于 num 的最小位置
 * 4.寻找峰值元素
 */

public class BinaryFinder {

    /**
     * 有序数组中，是否存在指定数字
     */
    public static boolean exist(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return false;
        }

        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else if (arr[mid] > num) {
                r = mid - 1;
            }
        }
        return false;
    }

    /**
     * 有序数组里，查找小于等于 num 的最大位置，不存在则-1
     * [10, 20, 30, 40, 50, 60, 70]  45
     *  0   1   2   3   4   5   6
     */
    public static int findRight(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0, r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (arr[mid] <= num) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 有序数组里，查找大于等于 num 的最小位置，不存在则-1
     * [10, 20, 30, 40, 50, 60, 70]  45
     *  0   1   2   3   4   5   6
     */
    public static int findLeft(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return  -1;
        }
        int l = 0, r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + ((r - l ) / 2);
            if (arr[mid] >= num) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return ans;
    }

    /**
     * 查找峰值元素
     */
    public static int findPeekElement(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        if (arr.length == 1) {
            return 0;
        }
        if (arr[0] > arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] > arr[arr.length - 2]) {
            return arr.length - 1;
        }

        int l = 1, r = arr.length - 2;
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (arr[mid] < arr[mid - 1]) {
                r = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;

    }


    // 为了验证
    public static void main(String[] args) {
        int N = 100;
        int V = 1000;
        int testTime = 500000;
        System.out.println("测试开始");
        for (int i = 0; i < testTime; i++) {
            int n = (int) (Math.random() * N);
            int[] arr = randomArray(n, V);
            Arrays.sort(arr);
            int num = (int) (Math.random() * V);
            if (right(arr, num) != findLeft(arr, num)) {
                System.out.println("出错了!");
            }
        }
        System.out.println("测试结束");
    }


    // 为了验证
    public static int[] randomArray(int n, int v) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (int) (Math.random() * v) + 1;
        }
        return arr;
    }

    // 为了验证
    // 保证arr有序，才能用这个方法
    public static int right(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= num) {
                return i;
            }
        }
        return -1;
    }

}
