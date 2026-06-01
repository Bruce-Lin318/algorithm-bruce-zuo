package class003;

/**
 * @author bruce
 * @ClassName BinarySystem
 * @description: TODO
 * @date 2026年06月01日
 * @version: 1.0
 */

public class BinarySystem {
    /**
     * 打印一个数字的二进制表示
     */
    public static void printBinary(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) != 0 ? "1" : "0");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // 非负数
        int a = 78;
        System.out.println(a);
        printBinary(a);
        System.out.println(Integer.toBinaryString(a));
        System.out.println("===a===");

    }

}
