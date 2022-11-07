package HW2;
/*Написать программу, показывающую 
последовательность действий для игры “Ханойская башня”*/

import java.util.Scanner;

public class Task3 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
    	System.out.print("Сколько будет всего колец? ");
    	int count = in.nextInt();
		moveRing('A', 'B', 'C', count);
		in.close();
	}

	public static void moveRing(char a, char b, char c, int count) {
		if (count == 1) {
			System.out.println(String.format("from %s to %s", a, b));
		}
		else {
			moveRing(a, c, b, count - 1);
			System.out.println(String.format("from %s to %s", a, b));
			moveRing(c, b, a, count - 1);
		}
	}
}