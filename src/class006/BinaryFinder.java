package class006;

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
        while (l <= r) {
            int mid = l + ((r - l) / 2);
            if (arr[mid] == num) {
                return mid;
            } else if (arr[mid] < num) {
                l = mid + 1;
            } else if (arr[mid] > num) {
                r = mid - 1;
            }
        }
        return r;
    }

}
