package leetcode.editor.cn;

import java.util.Arrays;

//排序算法
public class Sort {

    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] array = {1, 5, 2, 9, 3};
        //1 , 2, 5,3,9
//        int[] sortedArray = sort.bubbleSort(array);
//        int[] sortedArray = sort.selectionSort(array);
//        int[] sortedArray = sort.insertionSort(array);
        int[] sortedArray = sort.mergeSort(array, 0, array.length - 1);
//        int[] sortedArray = sort.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(sortedArray));
//        sort.countingSort(array, array.length);
//        System.out.println(Arrays.toString(array));
    }

    //冒泡排序  O(n^2)
    public int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    flag = true;
                    swap(array, j, j + 1);
                }
            }
            if (!flag) {
                break;
            }
        }
        return array;
    }

    //选择排序 O(n^2)
    public int[] selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(array, min, i);
            }
        }
        return array;
    }

    //插入排序 O(n^2)
    public int[] insertionSort(int[] array){

        for (int i = 1; i < array.length; i++) {
            int t = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (t < array[j]) {
                    array[j + 1] = array[j];
                }else{
                    break;
                }
            }
            array[j + 1] = t;
        }
        return array;

    }

    // 归并排序 O(n*logn)
    public int[] mergeSort(int[] array, int l, int r) {

        if (l >= r) {
            return array;
        }

        int mid = l + ((r - l) >> 1);
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);

        return merge(array, l, mid, r);
    }

    private int[] merge(int[] array, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int l0 = l;
        int r0 = mid +1;
        int i = 0;
        while (l0 <= mid && r0 <= r) {
            temp[i++] = array[l0] <= array[r0] ? array[l0++] : array[r0++];
        }

        while (l0 <= mid) {
            temp[i++] = array[l0++];
        }

        while (r0 <= r) {
            temp[i++] = array[r0++];
        }

        for (i = 0; i < temp.length; i++) {
            array[l + i] = temp[i];
        }

        return array;
    }

    // 快排 O(n*logn)
    public int[] quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return array;
        }

        int mid = partition(array, l, r);

        quickSort(array, l, mid - 1);
        quickSort(array, mid + 1, r);

        return array;
    }

    private int partition(int[] array, int l, int r) {

        int x = array[r];
        int i = l;
        for (int j = l; j < r; j++) {
            if (array[j] < x) {
                swap(array, i, j);
                i++;
            }
        }

        swap(array, i, r);
        return i;
    }

    private void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    // 桶排序  O(n) 将数据分桶,桶内使用快排

    // 计数排序 O(n)
    public void countingSort(int[] array, int n) {
        if (n <= 1) {
            return;
        }

        // 求 max
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        // 申请数组,长度 max+1
        int[] c = new int[max + 1];

        //计数
        for (int i = 0; i < n; i++) {
            c[array[i]]++;
        }

        //累加
        for (int i = 1; i < max + 1; i++) {
            c[i] = c[i - 1] + c[i];
        }

        //申请临时数组,存储结果  从后往前取,才是稳定排序
        int[] temp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int index = c[array[i]] - 1;
            c[array[i]]--;
            temp[index] = array[i];
        }

        for (int i = 0; i < n; i++) {
            array[i] = temp[i];
        }

    }

    // 基数排序  O(n)  将待排序数据按照高低位分割,每一位进行桶或者计数排序

}
