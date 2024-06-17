package binarytreegeneral;

/**
 * _704_Binary_Search_.
 *
 * @author Anton Shatkovskiy
 * @created 15.06.2024 г.
 */

/*
Given an array of integers nums which is sorted in ascending order,
and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.

ПЕРЕВОД: 704.Бинарный поиск.
Учитывая массив целых чисел nums, отсортированный в порядке возрастания,
и целочисленный целевой объект, напишите функцию для поиска целевого объекта в nums.
Если целевой объект существует, то верните его индекс. В противном случае верните значение -1.

Вы должны написать алгоритм со сложностью выполнения O(log n).

Пример 1:

Входные данные: nums = [-1,0,3,5,9,12], цель = 9
Выходные данные: 4
Пояснение: в nums существует 9, и его индекс равен 4
Пример 2:

Ввод: nums = [-1,0,3,5,9,12], цель = 2
Вывод: -1
Пояснение: значение 2 не существует в nums, поэтому верните значение -1

Ограничения:

1 <= число.длина <= 104
-104 < nums[i], target < 104
Все целые числа в nums уникальны.
nums сортируется в порядке возрастания.



 */
public class _704_Binary_Search_ {

  public static void main(String[] args) {

    int[] nums = {-1, 0, 3, 5, 9, 12};
    int target = 9;

    Solution704 solution704 = new Solution704();
    int binSearch = solution704.search(nums, target);
    System.out.println(binSearch);

  }

  static class Solution704 {
    public int search(int[] nums, int target) {

      return 0;

    }
  }

}
