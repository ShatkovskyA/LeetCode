package com.vashajava.array;

import java.util.Arrays;

/**
 * _238_Product_of_Array_Except_Self_.
 *
 * @author Anton Shatkovskiy
 * @created 16.09.2024 г.
 */

/*
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)

ПЕРЕВОД: 238. Произведение массива, за исключением Self.
Учитывая целочисленный массив nums, верните массив answer таким образом, чтобы ответ [i] был равен произведению всех элементов nums, кроме nums[i].

Произведение любого префикса или суффикса nums гарантированно укладывается в 32-разрядное целое число.

Вы должны написать алгоритм, который выполняется за O(n) времени и без использования операции деления.

Пример 1:

Входные данные: nums = [1,2,3,4]
Выходные данные: [24,12,8,6]
Пример 2:

Входные данные: nums = [-1,1,0,-3,3]
Выходные данные: [0,0,9,0,0]

Ограничения:

2 <= числа.длина <= 105
-30 <= числа[i] <= 30
Результат вычисления любого префикса или суффикса nums гарантированно укладывается в 32-разрядное целое число.

Уточнение: Можете ли вы решить задачу с использованием O (1) дополнительной пространственной сложности?
(Выходной массив не считается дополнительным пространством для анализа пространственной сложности).
 */
public class _238_Product_of_Array_Except_Self_ {

  public static void main(String[] args) {

    int[] nums = {1, 2, 3, 4};

    Solution238 solution238 = new Solution238();
    int[] productExceptSelf = solution238.productExceptSelf(nums);

    // вывод на печать массива
    // II способ - без запятой в конце
    System.out.print("[");
    for (int i = 0; i < productExceptSelf.length; i++) {

      System.out.print(productExceptSelf[i]);

      if (i < productExceptSelf.length - 1) {
        System.out.print(", " );
      }

    }
    System.out.print("]");
  }

  static class Solution238 {
    // это сам непосредственно метод вычисления произведения элементов, за исключением self
    public int[] productExceptSelf(int[] nums) {
      // 1. ВВОД НОВЫХ ПЕРЕМЕННЫХ И ИНИЦИАЛИЗАЦИЯ
      // возвращаем длину входного массива nums
      int length = nums.length;
      // создаем и инициализируем массив для ответов той же длины
      int[] answer = new int[length];
      // инициализируем указаатель 'leftProduct' значением 1, чтобы представить произведение элементов слева от текущего индекса
      int leftProduct = 1;
      // инициализируем указаатель 'rightProduct' также значением 1, чтобы представить произведение элементов справа от текущего индекса
      int rightProduct = 1;

      // 2. ПЕРВЫЙ ПРОХОД СЛЕВА НАПРАВО
      // перебираем массив слева направо циклом for
      for (int i = 0; i < length; i++) {
        // создаем и устанавливаем для текущего элемента в результирующем массиве значение 'leftProduct'
        answer[i] = leftProduct;
        // умножаем 'leftProduct' на текущий элемент в числах для следующей итерации (префикс product)
        leftProduct *= nums[i];
      }

      // 3. ВТОРОЙ ПРОХОД СПРАВА НАЛЕВО
      // перебираем массив справа налево циклом for? i-- - потому что в обратном порядке, справо налево
      for (int i = length - 1; i >=0; i--) {
        // умножаем текущий элемент в результирующем массиве на 'rightProduct'
        answer[i] *= rightProduct;
        // и умножаем 'rightProduct' на текущий элемент в числах для следующей итерации (суффикс product)
        rightProduct *= nums[i];
      }
      // озвращаем конечный продукт, за исключением собственного массива
      return answer;
    }
  }
}

/*
Временная сложность решения составляет O(n), поскольку оно проходит через массив дважды, независимо от его размера.
 */
