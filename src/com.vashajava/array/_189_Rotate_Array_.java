package com.vashajava.array;

import java.util.Arrays;

/**
 * _189_Rotate_Array_.
 *
 * @author Anton Shatkovskiy
 * @created 05.11.2024 г.
 */

/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105

Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

ПЕРЕВОД: 189. Вращающийся массив.
Учитывая массив целых чисел nums, поверните массив вправо на k шагов, где k неотрицательно.

Пример 1:
Входные данные: nums = [1,2,3,4,5,6,7], k = 3
Результат: [5,6,7,1,2,3,4]
Объяснение:
поверните на 1 шаг вправо: [7,1,2,3,4,5,6]
поверните на 2 шага вправо: [6,7,1,2,3,4,5]
поверните на 3 шага вправо: [5,6,7,1,2,3,4]

Пример 2:
Входные данные: nums = [-1,-100,3,99], k = 2
Выходные данные: [3,99,-1,-100]
Объяснение:
поверните на 1 шаг вправо: [99,-1,-100,3]
поверните на 2 шага вправо: [3,99,-1,-100]

Ограничения:

1 <= число.длина <= 105
-231 <= числа[i] <= 231 - 1
0 <= k <= 105

Следовать за:

Постарайтесь придумать как можно больше решений. Существует как минимум три различных способа решения этой проблемы.
Не могли бы вы сделать это на месте, используя O(1) дополнительного места?

 */
public class _189_Rotate_Array_ {

  public static void main(String[] args) {

    int[] nums = {1, 2, 3, 4, 5, 6, 7};
    int k = 3;

    Solution189 solution189 = new Solution189();
    solution189.rotate(nums, k);

    System.out.print("[ ");
    for(int i = 0; i < nums.length; i++) {
      System.out.print(nums[i]);
      if(i < nums.length - 1) {
        System.out.print(", ");
      }
    }
//    for(int num : nums) {
//      System.out.print(num);
//    }
    System.out.print(" ]");
  }

  static class Solution189 {

    // вводим переменную уровня класса для хранения входного массива
    private int[] nums;

    /**
     * Поворачивает заданный массив вправо на k шагов.
     * @param nums числовой массив, который нужно повернуть..
     * @param k количество шагов, на которые нужно повернуть массив вправо.
     */
    public void rotate(int[] nums, int k) {
      // присваиваем входной массив переменной уровня класса
      this.nums = nums;
      // ввоим переменную для подсчета уоличества элементов в массиве
      int n = nums.length;
      // нормализуем количество шагов k, чтобы избежать дополнительных поворотов
      k %= n;
      // переворачиваем весь массив,
      reverse(0, n - 1);
      // переворачиваем первую часть (до k элементов)
      reverse(0, k - 1);
      // переворачиваем вторую часть (от k до конца массива)
      reverse(k, n - 1);
    }

      /**
       * Собственно метод, который меняет местами элементы массива с индексами i на j.
       * @param i - начальный индекс для изменения.
       * @param j - конечный индекс для изменения.
       */
      public void reverse(int i, int j) {
        // испольщуем подход с двумя указателями, меняйте местами элементы до тех пор, пока указатели не встретятся или не пересекутся,
        // т. е. пока начало меньше конца
        while (i < j) {
          // временная переменная для хранения значения во время обмена - создаем и приравниваем к элементу массива вначала
          int temp = nums[i];
          // выполняем перестановку - т. е. идем в конец
          nums[i] = nums[j];
          nums[j] = temp;
          // и перемещаем указатели навстречу друг другу
          ++i;
          --j;
        }
      }
  }
}

/*
Временная сложность кода составляет, O(n) где n - длина массива, потому что он включает в себя разделение массива на две части
и последующее их объединение, оба из которых требуют O(n) операций.
 */
