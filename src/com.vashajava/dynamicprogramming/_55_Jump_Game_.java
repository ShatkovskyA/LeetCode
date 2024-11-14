package com.vashajava.dynamicprogramming;

/**
 * _55_Jump_Game_.
 *
 * @author Anton Shatkovskiy
 * @created 13.11.2024 г.
 */

/*
You are given an integer array nums. You are initially positioned at the array's first index,
and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what.
Its maximum jump length is 0, which makes it impossible to reach the last index.

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105

ПЕРЕВОД: 55. Игра в прыжки.
Вам задан целочисленный массив nums. Изначально вы располагаетесь по первому индексу массива,
и каждый элемент в массиве представляет максимальную длину вашего перехода в этой позиции.

Верните значение true, если вы можете достичь последнего индекса, или значение false в противном случае.

Пример 1:
Ввод: nums = [2,3,1,1,4]
Вывод: true
Пояснение: Переход на 1 шаг от индекса 0 к 1, затем на 3 шага к последнему индексу.

Пример 2:
Ввод: nums = [3,2,1,0,4]
Вывод: false
Пояснение: Вы всегда будете приходить к индексу 3, несмотря ни на что.
Максимальная длина перехода равна 0, что делает невозможным достижение последнего индекса.

Ограничения:

1 <= цифры.длина <= 104
0 <= цифры[i] <= 105
 */
public class _55_Jump_Game_ {

  public static void main(String[] args) {

    int[] nums = {2, 3, 1, 1, 4};

    Solution55 solution55 = new Solution55();
    boolean canJump = solution55.canJump(nums);
    System.out.println(canJump);

  }

  // используется простой, но эффективный жадный алгоритм
  static class Solution55 {
    public boolean canJump(int[] nums) {
      // водим и инициализируем максимально достижимый индекс равным 0
      int maxIndex = 0;
      // теперь пробегаемся циклом и выполняем итерацию по каждому индексу в массиве
      for(int i = 0; i < nums.length; ++i) {
        // и если текущий индекс больше максимально достижимого,
        // то это означает, что двигаться дальше не можем, поэтому возвращаем false
        if(maxIndex < i) {
          return false;
        }
        // далее обновляем максимально достижимый индекс, если индекс достижимости
        // из текущей позиции больше предыдущего максимального значения
        maxIndex = Math.max(maxIndex, i + nums[i]);
      }
      // и если цикл завершается без возврата false, то это означает, что можно
      // достичь последнего индекса, поэтому возвращаем true
      return true;
    }
  }
}
/*
Временная сложность кода равна O(n), где n - длина массива nums.
Это связано с тем, что функция включает в себя один цикл, который проходит через массив один раз,
выполняя проверку и обновление в постоянное время на каждом шаге.
 */
