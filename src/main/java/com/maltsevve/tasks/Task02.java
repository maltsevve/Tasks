package main.java.com.maltsevve.tasks;

import java.util.HashSet;

public class Task02 {
    static String findDuplicate(int[] arr) {
        boolean flag = false;
        int number = 0;
        int count = 1;
        String str;
        HashSet<Integer> hs = new HashSet<>();

        for (int k : arr) {
            if (!hs.add(k)) {
                if (!flag) {
                    number = k;
                    count++;
                    flag = true;
                } else if (number == k) count++;
            }
        }

        if (count > 1) str = "Result: " + true + "\nЧисло " + number + " повторяется " + count + " раз/раза\n";
        else str = "Result: " + false + "\nДубликатов нет\n";

        return str;
    }

    public static void main(String[] args) {
        int[] arr = {2, 2, 14, 0, 2, 43, 0, 2};
        System.out.println(findDuplicate(arr));

        int[] arr2 = {1, 2, 14, -9, 7, 43, 314, 0};
        System.out.println(findDuplicate(arr2));

        int[] arr3 = {0, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(findDuplicate(arr3));
    }
}
