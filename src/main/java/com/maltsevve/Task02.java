package main.java.com.maltsevve;

public class Task02 {
    static String findDuplicate(int[] arr) {
        boolean result = false;
        int number = 0;
        int count = 0;
        String str;

        for (int k : arr) {
            if (result) break;
            for (int i : arr) {
                if (k == i) {
                    result = true;
                    count++;
                    number = k;
                }
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
