import java.util.Scanner;

public class home_work1 {
  /// Вычисление треугольного числа:
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.print("Для вычисления n-ого треугольного числа, введите значение 'n': ");
    int n = in.nextInt();
    var triangular_num = (n * (n + 1)) / 2;
    System.out.printf("Треугольное число с 'n'-ым значение равно: %d", triangular_num);
    in.close();
  }
}
