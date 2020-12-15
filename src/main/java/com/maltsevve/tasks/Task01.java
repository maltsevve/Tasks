package main.java.com.maltsevve.tasks;

import java.util.HashMap;
import java.util.Map;

public class Task01 {
    static int[] findItems(int[] arr, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int k : arr) {
            hm.put(k, sum - k);
        }

        for (int i : arr) {
            if (hm.containsKey(sum - i))
                return new int[]{i, sum - i};
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 14, 64, 0, 43, 2, -8};

        int[] temp = findItems(arr, 15);
        for (int i : temp) {
            System.out.print(i + " ");
        }
        System.out.println();

        temp = findItems(arr, -6);
        for (int i : temp) {
            System.out.print(i + " ");
        }
        System.out.println();

        temp = findItems(arr, 64);
        for (int i : temp) {
            System.out.print(i + " ");
        }
    }
}
