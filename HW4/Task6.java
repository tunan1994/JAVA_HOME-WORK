package HW4;

import java.util.Scanner;

public class Task6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
        array[i] = (int) (Math.random() * 50);
        System.out.println("Исходный массив: ");
        printArray(array);
        QuickSort(array, 0, array.length - 1);
        System.out.println("Отсортированный массив: ");
        printArray(array);
        in.close();
    }
    static void QuickSort(int[] arr, int minIndex, int maxIndex) {
        if (minIndex >= maxIndex) return;
        int pivot = GetPivotIndex(arr, minIndex, maxIndex);
        QuickSort(arr, minIndex, pivot - 1);
        QuickSort(arr, pivot + 1, maxIndex);
        return;
        }

    static int GetPivotIndex(int[] arr, int minIndex, int maxIndex){
        int pivotIndex = minIndex - 1;
        for (int i = minIndex; i <= maxIndex; i++)
        {
            if (arr[i] < arr[maxIndex])
            {
                pivotIndex++;
                Swap(arr, i, pivotIndex);
            }
        }
        pivotIndex++;
        Swap(arr, pivotIndex, maxIndex);
        return pivotIndex;
    }

    static void Swap(int[] arr, int leftValue, int rightValue) {
        int temp = arr[leftValue];
        arr[leftValue] = arr[rightValue];
        arr[rightValue] = temp;
    }

    static void printArray(int arr[]) {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
        }
    }