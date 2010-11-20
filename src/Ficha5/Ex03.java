
package Ficha5;

/**
 *
 * @author heldercorreia
 */
class Ex03 {

    public static int[] arrayslice(int[] a, int pos, int len) {
        int[] slice = new int[len];
        System.arraycopy(a, pos, slice, 0, len);
        return slice;
    }

    public static int[] sortedMerge(int[] a, int[] b) {
        int counter = 0;
        int pointer = 0;
        int[] biggest  = a;
        int[] smallest = b;
        int[] merge = new int[a.length + b.length];

        if (a[a.length-1] < b[b.length-1]) {
            biggest  = b;
            smallest = a;
        }

        for (int i = 0; i < biggest.length; i++) {
            while (pointer < smallest.length && smallest[pointer] < biggest[i]) {
                if (put(merge, counter, smallest[pointer++])) {
                    counter++;
                }
            }
            if (put(merge, counter, biggest[i])) {
                counter++;
            }
        }

        return arrayslice(merge, 0, counter);
    }

    private static boolean put(int[] a, int pos, int value) {
        if (pos > 0 && a[pos-1] == value) {
            return false;
        }
        a[pos] = value;
        return true;
    }

}
