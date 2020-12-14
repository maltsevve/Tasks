package main.java.com.maltsevve.tasks;

public class Task01 {
    static int[] findItems(int[] arr, int sum) {
        for (int j : arr) {
            for (int k : arr) {
                if (j + k == sum) return new int[]{j, k};
            }
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
