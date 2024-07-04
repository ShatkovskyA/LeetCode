package com.vashajava.dynamicprogramming;

import java.util.Arrays;

/**
 * _338_Counting_Bits_.
 *
 * @author Anton Shatkovskiy
 * @created 04.07.2024 г.
 */

/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i]
is the number of 1's in the binary representation of i.

Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

Constraints:

0 <= n <= 105

Follow up:

It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?

ПЕРЕВОД: 338. Подсчет бит.
Учитывая целое число n, возвращаем массив длиной n + 1 таким образом, чтобы для каждого i (0 <= i <= n) значение ans[i]
было равно 1 в двоичном представлении i.

Пример 1:

Входные данные: n = 2
Результат: [0,1,1]
Объяснение:
0 --> 0
1 --> 1
2 --> 10
Пример 2:

Входные данные: n = 5
Выходные данные: [0,1,1,2,1,2]
Объяснение:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101

Ограничения:

0 <= n <= 105

Следовать за:

Очень легко найти решение с временем выполнения O(n log n). Можете ли вы сделать это за линейное время O(n) и, возможно, за один проход?
Можете ли вы сделать это без использования какой-либо встроенной функции (например, как __builtin_popcount в C++)?
 */
public class _338_Counting_Bits_ {

  public static void main(String[] args) {

    // вводим и инициализируем переменные, согласно условию,
    // а также задействуем методы класса
    int n = 5;

    Solution338 solution338 = new Solution338();
    int[] countBits = solution338.countBits(n);

    // тут надо использовать так Arrays.toString для вывода массива в формате [0, 1, 1]
    System.out.println(Arrays.toString(countBits));


  }

  static class Solution338 {
    public int[] countBits(int n) {
      // значит создаем массив 'bitCounts' размером n+1, чтобы содержать количество единиц для каждого числа от 0 до n
      int[] bitCounts = new int[n + 1];
      // традицонно циклом выполняем итерацию по каждому числу от 1 до n, чтобы вычислить количество битов, начинаем с единички
      for (int i = 1; i <= n; i++) {
        // используем ранее вычисленные результаты (т. к. это динамическое программирование), чтобы найти количество битов текущего числа.
        // реализуемая формула в цикле 'i & (i - 1)' удаляет самый младший установленный бит из i.
        // Таким образом, 'bitCounts[i & (i - 1)]' дает нам
        // количество битов для текущего числа без учета младшего установленного бита.
        // Затем добавляем 1 к пропущенному биту, чтобы получить итоговое значение для текущего числа.
        bitCounts[i] = bitCounts[i & (i - 1)] + 1;
      }
      // и далее возвращаем заполненный массив, содержащий количество битов для всех чисел от 0 до n
      return bitCounts;
    }
  }
}

/*
  Временная сложность предоставленного кода составляет O(n).
  Это связано с тем, что цикл выполняется от 1до nи внутри цикла операция i & (i - 1)вычисляется за постоянное время,
  а также за постоянное приращение + 1.
  Таким образом, цикл является основным фактором временной сложности, которая линейно зависит от n.
*/