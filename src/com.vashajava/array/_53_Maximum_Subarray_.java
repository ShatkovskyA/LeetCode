package com.vashajava.array;

/**
 * _53_Maximum_Subarray_.
 *
 * @author Anton Shatkovskiy
 * @created 31.07.2024 г.
 */

/*
Given an integer array nums, find the subarray with the largest sum, and return its sum.

Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

Follow up: If you have figured out the O(n) solution,
try coding another solution using the divide and conquer approach, which is more subtle.

ПЕРЕВОД: 53. Максимальный подмассив.
В заданном целочисленном массиве nums найдите подмассив с наибольшей суммой и верните его сумму.

Пример 1:

Ввод: nums = [-2,1,-3,4,-1,2,1,-5,4]
Вывод: 6
Пояснение: Подмассив [4,-1,2,1] имеет наибольшую сумму 6.
Пример 2:

Входные данные: nums = [1]
Выходные данные: 1
Пояснение: Подмассив [1] имеет наибольшую сумму 1.
Пример 3:

Входные данные: nums = [5,4,-1,7,8]
Выходные данные: 23
Пояснение: Подмассив [5,4,-1,7,8] имеет наибольшую сумму 23.

Ограничения:

1 <= цифры.длина <= 105
-104 <= nums[i] <= 104

Продолжение: если вы нашли O(n) решение,
попробуйте придумать другое решение, используя более тонкий подход "разделяй и властвуй".
 */
public class _53_Maximum_Subarray_ {

  public static void main(String[] args) {

    int[] nums= {-2, 1, -3, 4, -1, 2, 1, -5, 4};

    Solution53 solution53 = new Solution53();
    int maxSubArray = solution53.maxSubArray(nums);
    System.out.println(maxSubArray);

  }

  // используем алгоритм, называемый алгоритмом Кадане
  static class Solution53 {
    public int maxSubArray(int[] nums) {
      // тут вводим переменную `maxSoFar` содержит максимальную сумму подмассивов, найденную на данный момент
      int maxSoFar = nums[0];
      // тут, аналогично, вводим другую переменную`currentMax` содержит максимальную сумму подмассива, заканчивающегося в текущей позиции
      int currentMax = nums[0];

      // дале запускаем цикл for - для того, чтобы перебрать массив, начиная со второго элемента
      for (int i = 1; i < nums.length; ++i) {
        // теперь обновляем значение `currentMax` до максимального значения `currentMax` + текущий элемент или 0 + текущий элемент
        // В этом суть алгоритма Кадана, который решает, начинать ли новый подмассив или продолжить с текущего,
        // где Math.max() - это библиотечный метод, находи максимум из двух передоваемых аргументов
        currentMax = Math.max(currentMax, 0) + nums[i];

        // и если текущее вычисленное значение `currentMax` больше, чем `maxSoFar`, обновите значение `maxSoFar`
        maxSoFar = Math.max(maxSoFar, currentMax);
      }
      // возвращаем самую крупную сумму
      return maxSoFar;
    }
  }
}

/*
Данный фрагмент кода состоит из одного цикла, который проходит по списку nums.
Цикл начинается со второго элемента и продолжается до последнего элемента, выполняя операции с постоянным временем на каждой итерации.
Функция maxтакже O(1). Следовательно, временная сложность равна O(n), где n— количество элементов во входном списке nums.
 */
