package com.vashajava.array;

/**
 * _26_Remove_Duplicates_from_Sorted_Array_.
 *
 * @author Anton Shatkovskiy
 * @created 30.10.2024 г.
 */

/*
Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once.
The relative order of the elements should be kept the same. Then return the number of unique elements in nums.

Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:

Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially.
The remaining elements of nums are not important as well as the size of nums.
Return k.
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
Input: nums = [1,1,2]
Output: 2, nums = [1,2,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Example 2:
Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums being 0, 1, 2, 3, and 4 respectively.
It does not matter what you leave beyond the returned k (hence they are underscores).

Constraints:

1 <= nums.length <= 3 * 104
-100 <= nums[i] <= 100
nums is sorted in non-decreasing order.

ПЕРЕВОД: 26. Удаление дуплиткатов в отсортированном массиве.
При наличии целочисленного массива nums, отсортированного в порядке неубывания, удалите дубликаты на месте,
чтобы каждый уникальный элемент отображался только один раз.
Относительный порядок элементов должен оставаться неизменным. Затем верните количество уникальных элементов в nums.

Предположим, что количество уникальных элементов nums равно k, для того, чтобы их приняли, вам нужно выполнить следующие действия:

Измените массив nums таким образом, чтобы первые k элементов nums содержали уникальные элементы в том порядке,
в котором они изначально присутствовали в nums.
Остальные элементы nums не важны, так же как и размер nums.
Верните k.
Пользовательский судья:

Судья проверит ваше решение с помощью следующего кода:

int[] nums = [...]; // Введите массив
int[] expectedNums = [...]; // Ожидаемый ответ правильной длины

int k = removeDuplicates(nums); // Вызывает вашу реализацию

assert k == Ожидаемая длина;
for (int i = 0; i < k; i++) {
    assert nums[i] == Ожидаемые числа[i];
}
Если все утверждения подтвердятся, то ваше решение будет принято.

Пример 1:
Входные данные: nums = [1,1,2]
Выходные данные: 2, nums = [1,2,_]
Пояснение: Ваша функция должна возвращать значение k = 2, при этом первые два элемента nums равны 1 и 2 соответственно.
Не имеет значения, что вы оставляете после возвращаемого значения k (следовательно, это символы подчеркивания).

Пример 2:
Ввод: nums = [0,0,1,1,1,2,2,3,3,4]
Результат: 5, nums = [0,1,2,3,4,_,_,_,_,_]
Пояснение: Ваша функция должна возвращать значение k = 5, при этом первые пять элементов nums должны быть равны 0, 1, 2, 3 и 4 соответственно.
Не имеет значения, что вы оставляете за пределами возвращаемого значения k (следовательно, это символы подчеркивания).

Ограничения:

1 <= цифры.длина <= 3 * 104
-100 <= nums[i] <= 100
чисел сортируется в порядке неубывания.
 */
public class _26_Remove_Duplicates_from_Sorted_Array_ {

  public static void main(String[] args) {

    // вводим данные
    int[] nums = {1, 1, 2};

    Solution26 solution26 = new Solution26();
    int removeDuplicates = solution26.removeDuplicates(nums);
    System.out.println(removeDuplicates);

  }

  static class Solution26 {
    // собственно говоря сам метож для удаления дубликатов из отсортированного массива
    // и возврата длины массива после удаления дубликатов
    public int removeDuplicates(int[] nums) {
      // вводим и инициализируем переменную для подсчета количества уникальных элементов
      int uniqueCount = 0;

      // пробегаемся циклом для выполнения итерации по каждому элементу массива, облегченным циклом
      for(int currentNum : nums) {
        // и вводим основные условия: если это первый элемент(uniqueCount), котороый и так равен 0 как уникальный элемент
        // или(||) он не равен предыдущему элементу
        // (что означает, что это не дубликат)
        if(uniqueCount == 0 || currentNum != nums[uniqueCount - 1]) {
          // то, присваиваем текущий номер следующей уникальной позиции в массиве
          nums[uniqueCount++] = currentNum;
        }
      }
      // и тут возвращаем количество уникальных элементов, которое также является новой длиной массива
      return uniqueCount;
    }
  }
}
/*
Данный алгоритм выполняет итерацию по каждому элементу списка ровно один раз.
Во время каждой итерации алгоритм выполняет постоянное количество операций: сравнение, присвоение (при необходимости) и приращение k счетчика.
Следовательно, временная сложность линейна относительно длины входного списка nums.
Если n представляет количество элементов в nums, временную сложность можно выразить как O(n).
 */
