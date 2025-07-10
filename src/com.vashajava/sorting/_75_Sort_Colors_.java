package com.vashajava.sorting;

import java.util.Arrays;

/**
 * Класс _75_Sort_Colors_ - сортировка по цвету.
 *
 * @author Anton Shatkovskiy
 * @created 24.10.2024 г.
 */

/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent,
with the colors in the order red, white, and blue.
We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.

Example 1:
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]

Example 2:
Input: nums = [2,0,1]
Output: [0,1,2]

Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.

Follow up: Could you come up with a one-pass algorithm using only constant extra space?

ПЕРЕВОД: 75. Сортировка по цвету.
Получив массив nums с n объектами, окрашенными в красный, белый или синий цвета, отсортируйте их на месте так, чтобы объекты одного цвета располагались рядом,
а цвета располагались в порядке красного, белого и синего цветов.
Мы будем использовать целые числа 0, 1 и 2 для обозначения красного, белого и синего цветов соответственно.
Вы должны решить эту задачу, не используя библиотечную функцию сортировки.

Пример 1:
Ввод: nums = [2,0,2,1,1,0]
Вывод: [0,0,1,1,2,2]

Пример 2:
Ввод: nums = [2,0,1]
Вывод: [0,1,2]

Ограничения:
n == числа.длина
1 <= n <= 300
чисел[i] равно либо 0, 1, либо 2.

Продолжение: Не могли бы вы предложить однопроходный алгоритм, использующий только постоянное дополнительное пространство?
 */

// используется вариант известного алгоритма определения национального флага Нидерландов, предложенный Эдсгером Дейкстрой
public class _75_Sort_Colors_ {

  public static void main(String[] args) {

    int[] nums = {2, 0, 2, 1, 1, 0};

    int[] nums1 = {2, 0, 1};

    Solution75 solution75 = new Solution75();
    solution75.sortColors(nums);
    solution75.sortColors(nums1);
    System.out.println(Arrays.toString(nums));
    System.out.println(Arrays.toString(nums1));

  }

  static class Solution75 {
    // собственно метод сортировки массива, содержащего значения 0, 1 и 2
    public void sortColors(int[] nums) {
      // создаем и инциализирцем указатели для текущего элемента (currIndex),
      // последней позиции 0 (lastZeroIndex) и первой позиции 2 (firstTwoIndex)
      int lastZeroIndex = -1;
      // тут firstTwoIndex - это емкость-длина массива из аргументов, передаваемых методу
      int firstTwoIndex = nums.length;
      int currIndex = 0;

      // и теперь, используя цикл с условием. обраюатываем элементы до тех пор, пока currIndex не достигнет firstTwoIndex
      while (currIndex < firstTwoIndex) {
        if(nums[currIndex] == 0) {
          // если текущий элемент равен 0, поменяйте его местами после последнего найденного значения 0,
          // применяем swap() метод обмена элементами в списке можно использовать
          swap(nums, ++lastZeroIndex, currIndex++);
        } else if(nums[currIndex] == 2) {
          // далее, если текущий элемент равен 2, поменяйте его местами с элементом в позиции
          // непосредственно перед первыми 2, которые мы нашли - т. е. двигаемся с права налоев, с конца в начало - --firstTwoIndex
          swap(nums, --firstTwoIndex, currIndex);
        } else {
          // и если текущий элемент равен 1, то просто переходим к следующему элементу
          ++currIndex;
        }
      }
    }
    // тут создаем вспомогательный метод для замены двух элементов в массиве, в кач-ве аргументов - необходимые перменные
    private void swap(int[] nums, int i, int j) {
      // тут классическая сортировка - сравниваем и меняем местами
      int temp = nums[i];
      nums[i] = nums[j];
      nums[j] = temp;
    }
  }
}

/*
ременная сложность кода равна O(n), где n - длина входного списка nums. Это связано с тем,
что цикл while выполняет итерацию по каждому элементу списка не более одного раза.
Переменные i, j и k используются для перемещения по массиву без необходимости повторного обращения к элементам.
Операции увеличения и уменьшения для i, j, и k,
а также перестановки, все выполняются с постоянным временем, и цикл выполняется до тех пор, пока k не станет меньше j.
 */
