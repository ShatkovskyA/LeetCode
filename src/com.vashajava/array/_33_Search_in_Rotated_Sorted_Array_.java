package com.vashajava.array;

/**
 * Класс _33_Search_in_Rotated_Sorted_Array_ - поиск в повернутом и отсортированном массиве.
 *
 * @author Anton Shatkovskiy
 * @created 27.09.2024 г.
 */

/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target,
return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1

Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104

ПЕРЕВОД: 33. Поиск в повернутом и отсортированном массиве.
Существует целочисленный массив nums, отсортированный в порядке возрастания (с различными значениями).

Перед передачей в вашу функцию nums, возможно, поворачивается на неизвестный сводный индекс k (1 <= k < nums.длина).
таким образом, результирующий массив будет иметь вид [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (с индексом 0).
Например, [0,1,2,4,5,6,7] может быть повернуто по сводному индексу 3 и стать [4,5,6,7,0,1,2].

Учитывая массив nums после возможного поворота и целочисленную цель,
верните индекс цели, если он находится в числах, или -1, если он не находится в числах.

Вы должны написать алгоритм со сложностью выполнения O(log n).

Пример 1:

Входные данные: nums = [4,5,6,7,0,1,2], цель = 0
Выходные данные: 4
Пример 2:

Ввод: nums = [4,5,6,7,0,1,2], цель = 3
Вывод: -1
Пример 3:

Ввод: nums = [1], цель = 0
Вывод: -1

Ограничения:

1 <= цифры.длина <= 5000
-104 <= nums[i] <= 104
Все значения nums уникальны.
nums - это возрастающий массив, который можно поворачивать.
-104 <= target <= 104
 */
public class _33_Search_in_Rotated_Sorted_Array_ {

  public static void main(String[] args) {
  int[] nums = {4, 5, 6, 7, 0, 1, 2};
  int target = 0;

  Solution33 solution33 = new Solution33();
  int search = solution33.search(nums, target);
    System.out.println(search);

  }

  static class Solution33 {
    public int search(int[] nums, int target) {
      // определяем прежде всего длину массива
      int arrayLength = nums.length;

      // далее для бинарного поиска инициализирцем начальный и конечный указатели, т. е. левый и правый,
      // это стандартная процедура при осуществлении бинарного поиска
      // левый
      int start = 0;
      // и правый
      int end = arrayLength - 1;

      // теперь активируем алгоритм бинарного поиска для поиска цели, задаем с помощью цикла while условие,
      // пока лево меньше чем право
      while (start < end) {
        // вычисляем средний индекс текущего сегмента - простым делением на 2
        int mid = (start + end) / 2;
        // и теперь, когда средний элемент находится в неповоротной части массива
        if(nums[0] <= nums[mid]) {
          // проверяем, находится ли мишень (искомый элемент) также на невращающейся части, и соответствующим образом отрегулируйте конец
          if(nums[0] <= target && target <= nums[mid]) {
            // т. е. конец равен середине
            end = mid;
          } else {
            // иначе перемещаемся влево и приравниваем середину + 1
            start = mid + 1;
          }
          // и когда средний элемент находится на повернутой части массива
        } else {
          // проверяем, находится ли мишень (искомый элемент) также на повернутом участке, и соответствующим образом отрегулируйте пуск, т. е. старт - приравниваем mid
          if(nums[mid] < target && target <= nums[arrayLength - 1]) {
            // аналогично корректируем
            start = mid + 1;
            } else {
            end = mid;
          }
        }
      }
      // после повторения цикла сокращения(уменьшения) до одного элемента ппроверяем, является ли он целевым,
      // и если целью является nums[start], верните его индекс, в противном случае верните значение -1
      // применяем тернаный оператор
      return nums[start] == target ? start : -1;
    }
  }
}
/*
Данный код выполняет двоичный поиск по массиву. На каждой итерации цикла while алгоритм разбивает массив пополам,
исследуя либо левую, либо правую сторону.
Поскольку размер доступной для поиска части массива уменьшается вдвое с каждой итерацией цикла,
временная сложность этой операции составляет O(log n), где n - количество элементов в массиве nums.
 */

