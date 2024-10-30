package com.vashajava.array;

/**
 * _88_Merge_Sorted_Array_.
 *
 * @author Anton Shatkovskiy
 * @created 09.10.2024 г.
 */

/*
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

Merge nums1 and nums2 into a single array sorted in non-decreasing order.

The final sorted array should not be returned by the function, but instead be stored inside the array nums1.
To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged,
and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

Example 1:

Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
Example 2:

Input: nums1 = [1], m = 1, nums2 = [], n = 0
Output: [1]
Explanation: The arrays we are merging are [1] and [].
The result of the merge is [1].
Example 3:

Input: nums1 = [0], m = 0, nums2 = [1], n = 1
Output: [1]
Explanation: The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.

Constraints:

nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109

Follow up: Can you come up with an algorithm that runs in O(m + n) time?

ПЕРЕВОД: 88. Объединить отсортированный массив
Вам даны два целочисленных массива nums1 и nums2, отсортированных в порядке неубывания,
и два целых числа m и n, представляющие количество элементов в nums1 и nums2 соответственно.

Объедините nums1 и nums2 в один массив, отсортированный в порядке убывания.

Конечный отсортированный массив не должен быть возвращен функцией, а должен храниться внутри массива nums1.
Чтобы учесть это, nums1 имеет длину m + n, где первые m элементов обозначают элементы, которые должны быть объединены,
а последние n элементов имеют значение 0 и должны игнорироваться. nums2 имеет длину n.

Пример 1:

Входные данные: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Выходные данные: [1,2,2,3,5,6]
Пояснение: Массивы, которые мы объединяем, - это [1,2,3] и [2,5,6].
Результатом объединения будет [1,2,2,3,5,6] с подчеркнутыми элементами, исходящими из nums1.
Пример 2:

Входные данные: nums1 = [1], m = 1, nums2 = [], n = 0
Выходные данные: [1]
Пояснение: Мы объединяем массивы [1] и [].
Результатом объединения будет [1].
Пример 3:

Входные данные: nums1 = [0], m = 0, nums2 = [1], n = 1
Выходные данные: [1]
Пояснение: Мы объединяем массивы [] и [1].
Результатом объединения будет [1].
Обратите внимание, что, поскольку m = 0, в nums1 нет элементов. Значение 0 используется только для того, чтобы результат слияния мог поместиться в nums1.

Ограничения:

номера 1.длина == m + n
номеров 2.длина == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[j] <= 109

Продолжение: Можете ли вы предложить алгоритм, который выполняется за O (m + n) времени?
 */
public class _88_Merge_Sorted_Array_ {

  public static void main(String[] args) {

    int[] nums1 = {1, 2, 3, 0, 0, 0};
    int m = 3;
    int[] nums2 = {2, 5, 6};
    int n = 3;

    Solution88 solution88 = new Solution88();
    solution88.merge(nums1, m, nums2, n);
    for(int num : nums1) {
      System.out.print(num + " ");
    }
  }

  static class Solution88 {
    // метод для объединения двух отсортированных массивов, nums1 и nums2, в один отсортированный массив
    public void merge(int[] nums1, int m, int[] nums2, int n) {
      // 1 этап - это инициализируем указатели для nums1, nums2 и объединенного массива
      // указатель на последний элемент в исходной части nums1
      int indexNums1 = m - 1;
      // указатель на последний элемент в nums2
      int indexNums2 = n - 1;
      // указатель на последний элемент объединенного массива (конец nums1)
      int mergeIndex = m + n - 1;
      // и теперь выполняем итерацию по nums2 и nums1 с конца обоих массивов с пом. цикла while
      // т. е. пока указатель больше нуля
      while (indexNums2 >= 0) {
        // и если nums1 исчерпан или текущий элемент в nums2 больше
        if(indexNums1 < 0 || nums1[indexNums1] <= nums2[indexNums2]) {
          // то помещаем элемент nums2 в объединенный массив, роль объединенного массива выполняет nums1, т. к. там есть нули
          nums1[mergeIndex] = nums2[indexNums2];
          // и далее переходим к следующему элементу в nums2 - идем справо налево
          indexNums2--;
        } else {
          // а если текущий элемент в nums1 больше по размеру; поместите его в объединенный массив
          nums1[mergeIndex] = nums1[indexNums1];
          // и соответственно переходим к следующему элементу в nums1
          indexNums1--;
        }
        // и далее перемещаемся на следующую позицию в объединенном массиве
        mergeIndex--;
      }
    }
    // в итоге далее - ет необходимости проверять остальные элементы nums1,
    // и если таковые остались, поскольку они уже находятся в своем отсортированном положении
  }
}
/*
Данный код имеет временную сложность O(m + n), поскольку он включает в себя перебор элементов nums1 и nums2 в обратном порядке,
где m и n - длины соответствующих массивов. Это единственный проход по объединенному размеру обоих массивов, отсюда и добавление m и n.
*/