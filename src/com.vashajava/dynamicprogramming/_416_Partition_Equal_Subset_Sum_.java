package com.vashajava.dynamicprogramming;

/**
 * _416_Partition_Equal_Subset_Sum_.
 *
 * @author Anton Shatkovskiy
 * @created 02.11.2024 г.
 */

/*
Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets
is equal or false otherwise.

Example 1:
Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].

Example 2:
Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100

ПЕРЕВОД: 416. Разделите равную сумму подмножества.
Если задан целочисленный массив nums, верните значение true, если вы можете разбить массив на два подмножества таким образом,
чтобы сумма элементов в обоих подмножествах была одинаковой, или значение false в противном случае.

Пример 1:
Входные данные: nums = [1,5,11,5]
Выходные данные: true
Пояснение: Массив может быть разбит на [1, 5, 5] и [11].

Пример 2:
Входные данные: nums = [1,2,3,5]
Выходные данные: false
Пояснение: Массив не может быть разбит на подмножества с равной суммой.

Ограничения:

1 <= цифры.длина <= 200
1 <= цифры[i] <= 100
 */

  // решение основано на концепции динамического программирования, в частности, на задаче о рюкзаке 0/1
public class _416_Partition_Equal_Subset_Sum_ {

  public static void main(String[] args) {

    int[] nums = {1, 5, 11, 5};

    Solution416 solution416 = new Solution416();
    boolean canPartition = solution416.canPartition(nums);
    System.out.println(canPartition);

  }

  static class Solution416 {
    public boolean canPartition(int[] nums) {

      // I ЭТАП - основная проверка
      // вычисляем сумму всех элементов массива - 1 вариант сложный
      // объявляем и инициализируем нулем перменную суммы
      int sum = 0;
      for(int i = 0; i < nums.length; i++) {
        sum += nums[i];
      }

      // вычисляем сумму всех элементов массива - 2 вариант облегченный
//      for(int num : nums) {
//        sum += num;
//      }

      // далее, задаем условие, чтобы выполнить основную проверку для допуска к дальнейшим операциям с массивом
      // если сумма нечетная, то невозможно разделить массив на два подмножества с одинаковой суммой
      if(sum % 2 != 0) {
        return false;
      }

      // вводим переменную и вычисляем целевую сумму для каждого подмножества равна половине от общей суммы
      int targetSum = sum / 2;

      // создаем логический массив (boolean) для хранения подмножеств сумм, достижимых вплоть до целевой суммы
      boolean[] subsetSums = new boolean[targetSum + 1];

      // отбрасываем риск, т. е. всегда есть одно подмножество с суммой 0, пустое множество
      subsetSums[0] = true;

      // II ЭТАП - после ввода всех переменных и проверки основной, т. е. если массив подходит, то
      // пробегаемся облегченным циклом и проверяем каждое число в заданном массиве
      for(int num : nums) {
        // тут пробегаемся по массиву subsetSums в обратном порядке, чтобы избежать многократного использования элемента
        // т. е. задаем i = targetSum - это половина массива, и пока i больше num, j-- - это в обратном порядке
        for(int j = targetSum; j >= num; j--) {
          // обновляем достижимые суммы подмножеств
          // если j-число достижимо, установите j как достижимое (потому что мы добавляем num к подмножеству)
          subsetSums[j] = subsetSums[j] || subsetSums[j - num];
        }
      }
      // результатом является то, достижима ли целевая сумма в виде суммы подмножеств
      return subsetSums[targetSum];
    }
  }
}

/*
Временная сложность равна O(n * m) где n - количество элементов в nums и m равна половине суммы всех элементов в nums, если сумма четная.
Эта сложность возникает из-за структуры двойного цикла: внешний цикл, повторяющийся по каждому числу x в nums,
и внутренний цикл, повторяющийся в обратном направлении от m к x.
Внутренний цикл выполняется не более m итераций (представляющих возможные суммы до половины общей суммы), и это делается для каждого из n чисел.
 */
