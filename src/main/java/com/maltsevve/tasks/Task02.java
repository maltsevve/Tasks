package main.java.com.maltsevve.tasks;

import java.util.HashSet;

public class Task02 {
    static String findDuplicate(int[] arr) {
        int number = 0;
        int count = 1;
        String str;
        HashSet<Integer> hs = new HashSet<>();

        for (int k : arr) {
            if (!hs.add(k) && (number == 0 || number == k)) {
                number = k;
                count++;
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

        int[] arr3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(findDuplicate(arr3));
    }
}
