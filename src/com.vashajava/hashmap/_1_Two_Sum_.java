package hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * _1_Two_Sum_.
 *
 * @author Anton Shatkovskiy
 * @created 05.06.2024 г.
 */

/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?

ПЕРЕВОД: 1. Две суммы.
Учитывая массив целых чисел nums и целочисленную цель, верните индексы двух чисел таким образом, чтобы они в сумме давали цель.

Вы можете предположить, что у каждого входного сигнала будет ровно одно решение, и вы не сможете использовать один и тот же элемент дважды.

Вы можете вернуть ответ в любом порядке.

Пример 1:

Входные данные: nums = [2,7,11,15], цель = 9
Выходные данные: [0,1]
Пояснение: Поскольку nums[0] + nums[1] == 9, мы возвращаем [0, 1].
Пример 2:

Входные данные: числа = [3,2,4], цель = 6
Выходные данные: [1,2]
Пример 3:

Входные данные: числа = [3,3], цель = 6
Выходные данные: [0,1]

Ограничения:

2 <= цифры.длина <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Существует только один правильный ответ.

Продолжение: Можете ли вы предложить алгоритм, который по времени не превышает O(n2)?
 */

  /*
  Временная сложность кода равна O(n), где n - длина массива nums.
  Это связано с тем, что код перебирает каждый элемент в nums ровно один раз, и каждая операция в цикле,
  включая проверку наличия элемента на карте m и добавление элемента в m — это O(1).

Пространственная сложность кода также O(n), поскольку в худшем случае код может вставить каждый элемент массива nums в карту m.
Следовательно, пространство, используемое картой, m растет линейно с количеством элементов в nums.
   */
public class _1_Two_Sum_ {

  public static void main(String[] args) {

//    int[] nums = {3, 2, 4};
//    int target = 9;

    int[] nums = {2, 7, 11, 15};
    int target = 9;

    Solution1 solution1 = new Solution1();
    int[] resultTwoSum = solution1.twoSum(nums, target);

    // добавляем проверку тут с исключениями
    if (resultTwoSum != null) {
      System.out.println(Arrays.toString(resultTwoSum));
    } else {
      System.out.println("No two sum solution found");
    }
  }

  static class Solution1 {

    public int[] twoSum(int[] nums, int target) {

      // инициализируем пустую хэш-таблицу, в качестве словаря,
      // для хранения значения и его индекса
      Map<Integer, Integer> indexMap = new HashMap<>();

      // далее перебираем массив, циклом for - ыполняем итерацию по элементам массива
      for (int i = 0; i < nums.length; i++) {
        // устаавливаем текущее значение элемент - задаем начало
        int current = nums[i];
        // дополнение, которое при добавлении к "текущему" равно "целевому", т. е. задаем условие
        int complement = target - current;

        // далее проверка, есть ли дополнение уже на хэш-таблице, с помощью библиотечного метода
        // метод java.util.HashMap.containsKey() используется для проверки того, отображается ли конкретный ключ в HashMap или нет.
        // он принимает ключевой элемент в качестве параметра и возвращает значение True, если этот элемент сопоставлен в сопоставлении.
        if (indexMap.containsKey(complement)) {
          // если дополнение, то возвращаем индексы двух чисел
          return new int[]{indexMap.get(complement), i};

        }
        // сохраняем текущее значение и его индекс в indexMap
        indexMap.put(current, i);
      }
      // Примечание: Формулировка проблемы гарантирует, что всегда будет только одно решение,
      // поэтому здесь нет необходимости возвращать значение null или генерировать исключение.
      // throw new IllegalArgumentException("No two sum solution found");
      return null;
    }
  }
}
