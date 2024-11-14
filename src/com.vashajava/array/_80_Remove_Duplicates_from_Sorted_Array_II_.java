package com.vashajava.array;

/**
 * _80_Remove_Duplicates_from_Sorted_Array_II_.
 *
 * @author Anton Shatkovskiy
 * @created 02.11.2024 г.
 */

/*
Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice.
The relative order of the elements should be kept the same.

Since it is impossible to change the length of the array in some languages, you must instead have the result be placed
in the first part of the array nums.
More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result.
It does not matter what you leave beyond the first k elements.

Return k after placing the final result in the first k slots of nums.

Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.

Custom Judge:

The judge will test your solution with the following code:

int[] nums = [...]; // Input array
int[] expectedNums = [...]; // The expected answer with correct length

int k = removeDuplicates(nums); // Calls your implementation

assert k == expectedNums.length;
for (int i = 0; i < k; i++) {
    assert nums[i] == expectedNums[i];
}
If all assertions pass, then your solution will be accepted.

Example 1:
Input: nums = [1,1,1,2,2,3]
Output: 5, nums = [1,1,2,2,3,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,0,1,1,1,1,2,3,3]
Output: 7, nums = [0,0,1,1,2,3,3,_,_]
Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Constraints:

1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

ПЕРЕВОД: 80. Удаление дуплиткатов в отсортированном массиве II.
Учитывая, что номера в целочисленном массиве отсортированы в порядке неубывания,
удалите некоторые дубликаты, чтобы каждый уникальный элемент отображался не более двух (2) раз.
Относительный порядок элементов должен оставаться неизменным.

Поскольку в некоторых языках изменить длину массива невозможно, вместо этого вы должны поместить результат в первую часть массива nums.
Более формально, если после удаления дубликатов осталось k элементов, то первые k элементов nums должны содержать конечный результат.
Не имеет значения, что вы оставляете после первых k элементов.

Верните k после размещения конечного результата в первых k ячейках nums.

Не выделяйте дополнительное пространство для другого массива. Вы должны сделать это, изменив входной массив на месте, добавив O(1) дополнительной памяти.

Пользовательский судья:

Судья проверит ваше решение с помощью следующего кода:

int[] nums = [...]; // Вводим массив
int[] expectedNums = [...]; // Ожидаемый ответ правильной длины

int k = removeDuplicates(nums); // Вызываем вашу реализацию

assert k == Ожидаемая длина;
for (int i = 0; i < k; i++) {
    assert nums[i] == Ожидаемые числа[i];
}
Если все утверждения подтвердятся, то ваше решение будет принято.

Пример 1:
Входные данные: nums = [1,1,1,2,2,3]
Выходные данные: 5, nums = [1,1,2,2,3,_]
Пояснение: Ваша функция должна возвращать значение k = 5, при этом первые пять элементов nums должны быть равны 1, 1, 2, 2 и 3 соответственно.
Не имеет значения, что вы оставляете после возвращаемого значения k (следовательно, это символы подчеркивания).

Пример 2:
Ввод: nums = [0,0,1,1,1,1,2,3,3]
Вывод: 7, nums = [0,0,1,1,2,3,3,_,_]
Пояснение: Ваша функция должна возвращать значение k = 7, при этом первые семь элементов nums должны быть равны 0, 0, 1, 1, 2, 3 и 3 соответственно.
Не имеет значения, что вы оставляете за пределами возвращаемого значения k (следовательно, это символы подчеркивания).

Ограничения:

1 <= цифры.длина <= 3 * 104
-104 <= nums[i] <= 104
числа сортируются в порядке неубывания.

 */
public class _80_Remove_Duplicates_from_Sorted_Array_II_ {

  public static void main(String[] args) {

    int[] nums = {1, 1, 1, 2, 2, 3};

    Solution80 solution80 = new Solution80();
    int removeDuplicates = solution80.removeDuplicates(nums);
    System.out.println(removeDuplicates);

  }

  static class Solution80 {
    public int removeDuplicates(int[] nums) {

      // вводим переменную условия.
      // где 'k' - это индекс для размещения следующего уникального элемента
      // или второго вхождения существующего элемента
      // int k = 0;
      int index = 0;

      // пробегаясь облегченным циклом выполняем итерацию по каждому элементу массива
      for(int num : nums) {
        // создаем необходимые условия:
        // итак, если текущая позиция - это index, меньше 2 (т.е. мы находимся в начале массива)
        // или если текущий элемент - это num, отличается от элемента, находящегося на две позиции позади
        //, то рассмотрим его для включения в массив
        if(index < 2 || num != nums[index - 2]) {
          // то помещаем текущий элемент в позицию "index" и увеличьте "index"
          nums[index] = num;
          index++;
        }
      }
      // ну и возвразаем "индекс" представляет длину массива без дубликатов
      // допускается до двух вхождений
      return index;
    }
  }
}

/*
Временная сложность кода составляет O(n), где n - количество элементов во входном списке nums.
Это связано с тем, что код состоит из одного цикла, который проходит по всем элементам списка ровно один раз.
 */
