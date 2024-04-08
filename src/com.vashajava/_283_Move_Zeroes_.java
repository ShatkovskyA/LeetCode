/**
 * _283_Move_Zeroes_.
 *
 * @author Anton Shatkovskiy
 * @created 08.04.2024 г.
 */


/*

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:

Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:

Input: nums = [0]
Output: [0]

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1

Follow up: Could you minimize the total number of operations done?

ПЕРЕВОД:

Если задан целочисленный массив nums, переместите все 0 в его конец, сохраняя относительный порядок ненулевых элементов.
Обратите внимание, что это необходимо сделать на месте, не создавая копию массива.

Пример 1:

Ввод: nums = [0,1,0,3,12]
Вывод: [1,3,12,0,0]

Пример 2:

Ввод: nums = [0]
Вывод: [0]

Ограничения:

1 <= цифры.длина <= 104
-231 <= nums[i] <= 231 - 1

Уточнение: Не могли бы вы минимизировать общее количество выполняемых операций?
Словарь и онлайн перевод на английский, русский...

 */
public class _283_Move_Zeroes_ {

  public static void main(String[] args) {

    int[] nums;
    nums = new int[]{0, 1, 0, 3, 12};

    Solution283 solution283 = new Solution283();
    solution283.moveZeroes(nums);


    // TODO: проработать вывод
    for (int i = 0; i < nums.length; i++) {
      System.out.print(nums[i] + " ");
    }
  }

  static class Solution283 {
    public void moveZeroes(int[] nums) {

    }
  }

}
