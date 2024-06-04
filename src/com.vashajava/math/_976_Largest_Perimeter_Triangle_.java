package math;

import java.util.Arrays;

/**
 * _976_Largest_Perimeter_Triangle_.
 *
 * @author Anton Shatkovskiy
 * @created 26.05.2024 г.
 */

/*
Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths.
If it is impossible to form any triangle of a non-zero area, return 0.

Example 1:

Input: nums = [2,1,2]
Output: 5
Explanation: You can form a triangle with three side lengths: 1, 2, and 2.

Example 2:

Input: nums = [1,2,1,10]
Output: 0
Explanation:
You cannot use the side lengths 1, 1, and 2 to form a triangle.
You cannot use the side lengths 1, 1, and 10 to form a triangle.
You cannot use the side lengths 1, 2, and 10 to form a triangle.
As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.

Constraints:

3 <= nums.length <= 104
1 <= nums[i] <= 106

ПЕРЕВОД: 976. Наибольший период триангла (треугольника).
Учитывая целочисленный массив nums, верните наибольший периметр треугольника с ненулевой площадью, сформированный из трех из этих длин.
Если невозможно сформировать какой-либо треугольник ненулевой площади, верните 0.

Пример 1:

Ввод: nums = [2,1,2]
Вывод: 5
Пояснение: Можно сформировать треугольник с тремя длинами сторон: 1, 2 и 2.

Пример 2:

Ввод: nums = [1,2,1,10]
Вывод: 0
Объяснение:
Вы не можете использовать длины сторон 1, 1 и 2 для формирования треугольника.
Вы не можете использовать длины сторон 1, 1 и 10 для формирования треугольника.
Вы не можете использовать длины сторон 1, 2 и 10 для формирования треугольника.
Поскольку мы не можем использовать какие-либо три длины сторон для формирования треугольника ненулевой площади, мы возвращаем 0.

Ограничения:

3 <= цифры.длина <= 104
1 <= цифры[i] <= 106

 */

  // Треугольник может существовать только в том случае, если сумма длин любых двух сторон больше длины третьей стороны.

public class _976_Largest_Perimeter_Triangle_ {

  public static void main(String[] args) {
    int[] nums = {2, 1, 2};

    Solution976 solution976 = new Solution976();
    System.out.println(solution976.largestPerimeter(nums));

  }

  static  class Solution976 {
    public int largestPerimeter(int[] nums) {

      // сортируем этот массив в порядке возрастания, чтобы расположить потенциальные длины сторон от наименьшей к наибольшей
      // сортируем массив по длине сторон в порядке неубывания.
      Arrays.sort(nums);

      // перебираем в цикле от конца отсортированного массива к началу,
      // чтобы попытаться найти три самые длинные стороны, которые могут образовать треугольник
      // проходим по отсортированному массиву в обратном порядке, чтобы проверить правильность треугольника.
      // поэтому i >= 2
      for (int i = nums.length - 1; i >= 2; --i) {
        // Для невырожденного треугольника сумма длин двух
        // более коротких сторон (nums[i-2] и nums[i-1]) должна быть больше, чем
        // длина самой длинной стороны (nums[i]).
        int sumOfShorterSides = nums[i - 2] + nums[i - 1];

        // Если сумма двух коротких сторон больше, чем самая длинная сторона,
        // может быть сформирован правильный треугольник, поэтому верните периметр треугольника.
        if (nums[i] < sumOfShorterSides) {
          // вычисляем периметр треугольника.
          int perimetr = sumOfShorterSides + nums[i];
          // возвращаем периметр, так как это самый большой из найденных.
          return perimetr;
        }
        // если из текущего триплета не удается сформировать правильный треугольник,
        // цикл продолжает проверку на наличие правильного треугольника со
        // следующим набором длин сторон в отсортированном массиве.
      }
      return 0;
    }
  }
}
