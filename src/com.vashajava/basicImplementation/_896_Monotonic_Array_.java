package basicImplementation;

/**
 * basicImplementation._896_Monotonic_Array_.
 *
 * @author Anton Shatkovskiy
 * @created 10.04.2024 г.
 */

/*
An array is monotonic if it is either monotone increasing or monotone decreasing.

An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j].
An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].

Given an integer array nums, return true if the given array is monotonic, or false otherwise.

Example 1:

Input: nums = [1,2,2,3]
Output: true
Example 2:

Input: nums = [6,5,4,4]
Output: true

Example 3:

Input: nums = [1,3,2]
Output: false

Constraints:

1 <= nums.length <= 105
-105 <= nums[i] <= 105

ПЕРЕВОД:
Массив является монотонным, если он либо монотонно увеличивается, либо монотонно уменьшается.

Массив nums является монотонно увеличивающимся, если для всех i <= j, nums[i] <= nums[j].
Массив nums является монотонно убывающим, если для всех i <= j, nums[i] >= nums[j].

При заданном целочисленном массиве nums верните значение true, если данный массив монотонный, или значение false в противном случае.

Пример 1:

Ввод: nums = [1,2,2,3]
Вывод: true

Пример 2:

Ввод: nums = [6,5,4,4]
Вывод: true

Пример 3:

Ввод: nums = [1,3,2]
Вывод: false

Ограничения:

1 <= числа.длина <= 105
-105 <= числа[i] <= 105

 */
public class _896_Monotonic_Array_ {

  public static void main(String[] args) {

    int[] nums;
    nums = new int[]{1, 2, 2, 3};

    Solution896 solution896 = new Solution896();
    solution896.isMonotonic(nums);

//    for (int i = 0; i < digits.length; i++) {
//      System.out.print(digits[i] + " ");
//    }

    for (int numsout : nums) {
      System.out.println(numsout);


    }
  }

  static class Solution896 {

    // методо для проверки монотонности массива
    public boolean isMonotonic(int[] nums) {

      // сначала создаем переменную, которая возвращает количество цифр в массивк
      int n = nums.length;

      // вводим также bool переменные для удоства и "красивости" кода
      boolean inc = true;
      boolean dec = true;

      // далее, применяем цикл, пробегаемся по массиву, в сторону увеличения, и, также вводим необходимые условия по задаче
     for (int i = 0; i < n - 1; i++) {
        // проверка - не увеличивается ли массив
        if(nums[i] > nums[i + 1]) {
          inc = false;
          // проверка - не уменьшается ли массив
        } else if (nums[i] < nums[i + 1]) {
          dec = false;
        }
      }

      // выбераем один из них, будь то inc или dec
      return inc || dec;

    }
  }


}
