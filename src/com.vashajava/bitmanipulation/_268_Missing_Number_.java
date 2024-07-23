package com.vashajava.bitmanipulation;

/**
 * _268_Missing_Number_.
 *
 * @author Anton Shatkovskiy
 * @created 17.07.2024 г.
 */

/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.

Constraints:

n == nums.length
1 <= n <= 104
0 <= nums[i] <= n
All the numbers of nums are unique.

Follow up: Could you implement a solution using only O(1) extra space complexity and O(n) runtime complexity?

ПЕРЕВОД: 268. Пропущенный номер.
При наличии массива nums, содержащего n различных чисел в диапазоне [0, n], верните единственное число в диапазоне,
которое отсутствует в массиве.

Пример 1:

Входные данные: nums = [3,0,1]
Выходные данные: 2
Пояснение: n = 3, поскольку имеется 3 числа, поэтому все числа находятся в диапазоне [0,3].
2 - это пропущенное число в диапазоне, поскольку оно не отображается в числах.
Пример 2:

Ввод: nums = [0,1]
Вывод: 2
Пояснение: n = 2, поскольку имеется 2 числа, поэтому все числа находятся в диапазоне [0,2].
2 - это пропущенное число в диапазоне, поскольку оно не отображается в числах.
Пример 3:

Входные данные: nums = [9,6,4,2,3,5,7,0,1]
Результат: 8
Пояснение: n = 9, поскольку существует 9 чисел, поэтому все числа находятся в диапазоне [0,9]. 8 - это пропущенное число в диапазоне, поскольку оно не отображается в числах.

Ограничения:

n == числа.длина
1 <= n <= 104
0 <= nums[i] <= n
Все номера имен уникальны.

Продолжение: Не могли бы вы реализовать решение, используя только O(1) дополнительных пробелов и O(n) сложностей во время выполнения?
 */
public class _268_Missing_Number_ {

  public static void main(String[] args) {

    // вводим параметры метода
    int[] nums = {3, 0, 1};

    Solution268 solution268 = new Solution268();
    int missingNumber = solution268.missingNumber(nums);
    System.out.println(missingNumber);
  }

  static class Solution268 {
    // метод находит недостающее число в массиве, содержащем числа от 0 до n
    public int missingNumber(int[] nums) {
      // тут длина массива должна быть на одно число меньше полного набора
      int n = nums.length;
      // инициализируем ответ последним числом (которое равно n, поскольку массив индексирован на 0)
      int result = n;

      // традиционно пробегаемся циклом, итерируясь по массиву
      for (int i = 0; i < n; ++i) {
        // применяем операцию XOR между текущим индексом и элементом с этим индексом и XOR для этого элемента с текущим результатом
        // т. к. число, сопоставленное с самим собой, равно 0,
        // а число, сопоставленное с 0, является самим числом, в конечном итоге у нас останется только недостающее число
        result ^= i ^ nums[i];
      }
      // озвращаем результат, который является недостающим числом
      return result;
    }
  }
}

/*
Временная сложность кода равна O(n), где n– длина массива nums.
Это связано с тем, что выражение генератора (i ^ v for i, v in enumerate(nums, 1))проходит через каждый элемент массива ровно один раз.
Операция xorвнутри выражения генератора — это операция с постоянным временем, требующая O(1)времени.
Затем функция reduceвыполняет итерацию этих n xorопераций, чтобы объединить их, что также требует O(n)времени.
Таким образом, общее время линейно зависит от длины массива.
 */
