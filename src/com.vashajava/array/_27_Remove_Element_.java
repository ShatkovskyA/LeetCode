package com.vashajava.array;

import java.util.Arrays;

/**
 * _27_Remove_Element_.
 *
 * @author Anton Shatkovskiy
 * @created 10.10.2024 г.
 */

/*
Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.

Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the elements which are not equal to val.
The remaining elements of nums are not important as well as the size of nums.
Return k.
Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int val = ...; // Value to remove
int[] expectedNums = [...]; // The expected answer with correct length.
                            // It is sorted with no values equaling val.

int k = removeElement(nums, val); // Calls your implementation

assert k == expectedNums.length;
sort(nums, 0, k); // Sort the first k elements of nums
for (int i = 0; i < actualLength; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).

Constraints:

0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100

ПЕРЕВОД: 27. Удалите элемент.
Учитывая целочисленный массив nums и целое значение val, удалите все вхождения val в nums на месте.
Порядок элементов может быть изменен. Затем верните количество элементов в nums, которые не равны val.

Учтите, что количество элементов в nums, которые не равны val, равно k, чтобы их приняли, вам нужно выполнить следующие действия:

Измените массив nums таким образом, чтобы первые k элементов в nums содержали элементы, которые не равны val.
Остальные элементы nums не важны, так же как и размер nums.
Верните k.
Пользовательский судья:

Судья проверит ваше решение с помощью следующего кода:

int[] nums = [...]; // Введите массив
int val = ...; // Значение для удаления
int[] expectedNums = [...]; // Ожидаемый ответ правильной длины.
                            // Он отсортирован без значений, равных val.

int k = removeElement(nums, val); // Вызывает вашу реализацию.

assert k == Ожидаемая длина;
сортировка(nums, 0, k); // Отсортировать первые k элементов nums
по (int i = 0; i < Фактическая длина; i++) {
    assert nums[i] == Ожидаемые числа[i];
}
Если все утверждения подтвердятся, то ваше решение будет принято.

Пример 1:

Входные данные: nums = [3,2,2,3], val = 3
Выходные данные: 2, nums = [2,2,_,_]
Пояснение: Ваша функция должна возвращать k = 2, причем первые два элемента nums должны быть равны 2.
Не имеет значения, что вы оставляете после возвращаемого значения k (следовательно, это символы подчеркивания).
Пример 2:

Ввод: nums = [0,1,2,2,3,0,4,2], val = 2
Результат: 5, nums = [0,1,4,0,3,_,_,_]
Пояснение: Ваша функция должна возвращать значение k = 5, при этом первые пять элементов nums должны содержать значения 0, 0, 1, 3 и 4.
Обратите внимание, что эти пять элементов могут быть возвращены в любом порядке.
Не имеет значения, что вы оставляете за пределами возвращаемого значения k (следовательно, это символы подчеркивания).

Ограничения:

0 <= цифры.длина <= 100
0 <= цифры[i] <= 50
0 <= значение <= 100
 */
public class _27_Remove_Element_ {

  public static void main(String[] args) {

    int[] nums = {3, 2, 2, 3};
    int val = 3;

    Solution27 solution27 = new Solution27();
    int k = solution27.removeElement(nums, val);
    System.out.println(k);
  }

  // спользуем модификацию входного массива на месте nums
  static class Solution27 {
    // собственно метод, позволяющий удалить все экземпляры заданного значения на месте и вернуть новую длину
    public int removeElement(int[] nums, int val) {

      // инициализируем счетчик-индекс для подсчета элементов, которые не = val
      // инициализируем счетчик для новой длины массива
      int newLength = 0;

      // с помощью цикла пробегаемся по исходному массиву, с целью поиска элементов, которые равны val
      // выполняем итерацию по каждому элементу массива
      // тут надо применять "облегченный" цикл for-each

      for (int num : nums) {
        // и далее основное условие, если текущий элемент не является значением, подлежащим удалению, добавляем его в новую позицию массива,
        // соответственно увеличваия счетчик
        if(num != val) {
          nums[newLength++] = num;
        }
      }
      // возвращаем новую длину массива после удаления значения
      return newLength;
    }
  }
}

/*
Временная сложность кода равна O(n), где n - длина массива nums.
Это потому, что код выполняет итерацию по всем элементам массива ровно один раз.
*/
