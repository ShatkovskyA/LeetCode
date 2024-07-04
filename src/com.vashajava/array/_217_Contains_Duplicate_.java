package array;

import java.util.HashSet;
import java.util.Set;

/**
 * _217_Contains_Duplicate_.
 *
 * @author Anton Shatkovskiy
 * @created 03.07.2024 г.
 */

/*
Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true

Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109

ПЕРЕВОД: 217. Содержит дубликаты.
Учитывая целочисленный массив nums, верните значение true, если какое-либо значение встречается в массиве как минимум дважды,
и верните значение false, если все элементы различны.

Пример 1:

Входные данные: nums = [1,2,3,1]
Выходные данные: true
Пример 2:

Ввод: nums = [1,2,3,4]
Вывод: false
Пример 3:

Ввод: nums = [1,1,1,3,3,4,3,2,4,2]
Вывод: true

Ограничения:

1 <= цифры.длина <= 105
-109 <= числа[i] <= 109

 */
public class _217_Contains_Duplicate_ {

  public static void main(String[] args) {

    // тут задаем входные данные и реализуем методы из класса
    int[] nums = {1, 2, 3, 1};

    Solution217 solution217 = new Solution217();
    boolean containsDuplicate = solution217.containsDuplicate(nums);
    System.out.println(containsDuplicate);
  }

  static class Solution217 {
    /**
     * Проверяет, содержит ли массив какие-либо дубликаты.
     *
     * @param nums массив целых чисел для проверки на наличие дубликатов.
     * @return значение true, если какое-либо значение встречается в массиве по крайней мере дважды,
     * и значение false, если все элементы различны.
     */
    public boolean containsDuplicate(int[] nums) {
      // инциализируем хэш-набор для хранения уникальных элементов,
      // это нужно для того, чтобы отсечь дубликаты, т. к. дубликаты будут удаляться
      // в качестве реализации хэш-сет
      Set<Integer> uniqueNumbers = new HashSet<>();

      // далее циклом for-each пробегаемся и выполняем итерацию по всем элементам массива
      for(int num : nums) {
        // пытаемся добавить текущий элемент в набор,
        // и если метод add возвращает значение false, это означает, что элемент уже присутствует в наборе
        if(!uniqueNumbers.add(num)) {
          // то тут дубликат, поэтому верните значение true
          return true;
          }
      }
      // в противном случае - дубликатов найдено не было, возвращает значение false
      return false;
    }
  }
}

/*
Основной операцией здесь является преобразование списка в набор, который обычно имеет временную сложность,
равную O(n) где n - количество элементов в списке.
Это связано с тем, что операция должна проходить по всем элементам один раз, добавляя их в набор и проверяя уникальность.
 */
