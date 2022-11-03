import java.util.Scanner;

public class home_work2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = (int) (Math.random() * 50);
        System.out.print("Исходный массив: ");
        printArray(array);
        sort(array);
        System.out.print("Отсортированный массив пирамидальной сортировкой: ");
        printArray(array);
        in.close();
    }

    static void printArray(int array[]) {
        for (int i : array)
            System.out.print(i + " ");
        System.out.println();
    }

    static void sort(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    static void heapify(int arr[], int n, int i) {
        int biggest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[biggest])
            biggest = left;
        if (right < n && arr[right] > arr[biggest])
            biggest = right;
        if (biggest != i) {
            int swap = arr[i];
            arr[i] = arr[biggest];
            arr[biggest] = swap;
            heapify(arr, n, biggest);
        }
    }

}