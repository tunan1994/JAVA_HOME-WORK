package HW2;
/*Реализовать алгоритм сортировки вставками*/

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите размерность массива: ");
        int n = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = (int) (Math.random() * 50);
        System.out.println("Исходный массив: ");
        printArray(array);
        for (int left = 0; left < array.length; left++) {
            int value = array[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                } else {
                    break;
                }
            }
            array[i + 1] = value;
        }
        printArray(array);
        in.close();
    }

    static void printArray(int array[]) {
        for (int i : array)
            System.out.print(i + " ");
        System.out.println();
        }
    }