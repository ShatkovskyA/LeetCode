package math;

/**
 * _1523_Count_Odd_Numbers_in_an_Interval_Range_.
 *
 * @author Anton Shatkovskiy
 * @created 23.05.2024 г.
 */

/*
Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

Example 1:

Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].

Example 2:

Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].

Constraints:

0 <= low <= high <= 10^9

ПЕРЕВОД: 1523. Подсчитывайте нечетные числа в диапазоне интервалов

Даны два неотрицательных целых числа low и high.
Возвращает количество нечетных чисел между low и high (включительно).

Пример 1:

Входные данные: низкое значение = 3, высокое значение = 7
Выходные данные: 3
Пояснение: Нечетными числами между 3 и 7 являются [3,5,7].

Пример 2:

Входные данные: низкое значение = 8, высокое значение = 10
Выходные данные: 1
Пояснение: Нечетными числами между 8 и 10 являются [9].

Ограничения:

0 <= низкий <= высокий <= 10^9
 */

public class _1523_Count_Odd_Numbers_in_an_Interval_Range_ {

  public static void main(String[] args) {

    int low = 3;
    int hight = 7;

    Solution1523 solution1523 = new Solution1523();
    System.out.println(solution1523.countOdds(low, hight));


  }

  static class Solution1523 {
    public int countOdds(int low, int high) {

      return 0;

          }
  }


}
