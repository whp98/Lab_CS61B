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
        /*
         * 版本1
         * 采用递归思想，从2开始除，符合条件就返回，否则就一步一步递归下去，直到除到k=x 或者 被k整除
         */
//        if (k >= x) {
//            return false;
//        } else if (x % k == 0) {
//            return true;
//        } else {
//            return isDivisible(x, k + 1);
//        }
        /* 版本2 和上面的代码效果相同
         * 采用while循环从2开始到 k=x结束，中途如果符合x整除k就返回
         */
//        while (k < x) {
//            if (x % k == 0) {
//                return true;
//            }
//            k = k + 1;
//        }
//        return false;
        /* 版本3
         * 主要思想 while循环 ，不过采用了一个临时变量作为循环变量
         * */
//        int k1 = k;
//        while (k1 < x) {
//            if (x % k1 == 0) {
//                return true;
//            }
//            k1++;
//        }
//        return false;
        /* 版本4
         *  主要思想是for循环，使用for循环便利从 k到x之间的数如果又符合整除条件的数就会放回true
         */
        for (int k1 = k; k1 < x; k1++) {
            if (x % k1 == 0) {
                return true;
            }
        }
        return false;
    }

}
