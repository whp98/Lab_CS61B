package lect2;

/**
 * 打印从2到N的所有素数
 *
 * @author haipeng.wang
 */
public class Primes {

    /**
     * 每一行的数量
     */
    private static final int LINE_LENGTH = 10;

    /**
     * 将到参数args[0]的所有质数打印在一行
     *
     * @param args 输入的参数列表
     */
    public static void main(String[] args) {
        args = new String[]{"101"};
        printPrimes(Integer.parseInt(args[0]));
    }

    /**
     * 将小于等于limit的素数打印出来10个一行
     *
     * @param limit 数字表示素数所在的区间的最大值包含limit
     */
    private static void printPrimes(int limit) {
        int np;
        np = 0;
        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                np++;
                System.out.print(i + " ");
                if (np % LINE_LENGTH == 0) {
                    System.out.println();
                }
            }
        }
        if (np % LINE_LENGTH != 0) {
            System.out.println();
        }
    }

    /**
     * 当且仅当X是素数的时候返回True
     */
    private static boolean isPrime(int x) {
        //判断素数
        if (x <= 1) {
            return false;
        } else {
            return !isDivisible(x, 2);
        }
    }

    /**
     * 判断数字X能不能被大于等于k小于X的数字整除
     */
    private static boolean isDivisible(int x, int k) {
        /* 根据范围排除,守卫   **/
        if (k >= x) {
            return false;
        } else if (x % k == 0) {
            return true;
        } else {
            return isDivisible(x, k + 1);
        }
    }

}
