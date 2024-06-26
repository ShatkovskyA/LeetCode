package math;

/**
 * _50_Pow_x_n_.
 *
 * @author Anton Shatkovskiy
 * @created 28.05.2024 г.
 */

/*
Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

Example 1:

Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:

Input: x = 2.10000, n = 3
Output: 9.26100
Example 3:

Input: x = 2.00000, n = -2
Output: 0.25000
Explanation: 2-2 = 1/22 = 1/4 = 0.25

Constraints:

-100.0 < x < 100.0
-231 <= n <= 231-1
n is an integer.
Either x is not zero or n > 0.
-104 <= xn <= 104

ПЕРЕВОД: 50. Pow(x, n) - вычислительная мощность элементов.
Реализуем pow(x, n), который вычисляет значение x, возведенное в степень n (т.е. xn).

Пример 1:

Входные данные: x = 2,00000, n = 10
Выходные данные: 1024,00000
Пример 2:

Входные данные: x = 2,10000, n = 3
Выходные данные: 9,26100
Пример 3:

Входные данные: x = 2,00000, n = -2
Выходные данные: 0,25000
Пояснение: 2-2 = 1/22 = 1/4 = 0,25

Ограничения:

-100.0 < x < 100.0
-231 <= n <= 231-1
n - целое число.
Либо x не равно нулю, либо n > 0.
-104 <= xn <= 104
 */

  // временная сложность O(log n),
  // итерационный процесс использует парадигму "разделяй и властвуй"

public class _50_Pow_x_n_ {

  public static void main(String[] args) {

    double x = 2.00000;
    int n = 10;

    Solution50 solution50 = new Solution50();
    System.out.println(solution50.myPow(x, n));

  }

  static class Solution50 {
    public double myPow(double x, int n) {

      if(n >= 0) {
        // если мощность n неотрицательна, вычислите мощность с помощью вспомогательного метода
        return quickPow(x, n);
      } else {
        // Если степень n отрицательна, вычислите величину, обратную степени
        return 1 / quickPow(x, -(long) n);
      }
    }
    // собственно сам метод quickPow()
    private double quickPow (double base, long exponent) {
      // инициализируем результат в нейтральный элемент для умножения, т. е. это
      // инициализируем накопитель
      double result = 1;

      // перебираем все биты показателя степени, т. е. это
      // задействуем итерационный процесс, применяя циклы while
      // если мощность n неотрицательна, вычислите мощность с помощью вспомогательного метода
      while (exponent != 0) {
        // если установлен текущий бит, умножьте результат на базу
        if((exponent & 1) == 1) {
          result *= base;
        }
        // возводим в квадрат основание для следующего бита в экспоненте
        base *= base;
        // и сдвиагем побитово экспоненту вправо, чтобы обработать следующий бит
        exponent >>= 1;
     }
      // и возвращаем конечный результат от основания, возведенного в степень
      return result;
    }
  }
}
