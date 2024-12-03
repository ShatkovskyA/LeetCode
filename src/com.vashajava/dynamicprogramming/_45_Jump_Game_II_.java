package com.vashajava.dynamicprogramming;

/**
 * _45_Jump_Game_II_.
 *
 * @author Anton Shatkovskiy
 * @created 19.11.2024 г.
 */

/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i.
In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1].
The test cases are generated such that you can reach nums[n - 1].

Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].

ПЕРЕВОД: 45. Игра в прыжки II.
Вам предоставляется массив целых чисел nums с индексом 0 длиной n. Изначально вы находитесь в позиции nums[0].

Каждый элемент nums[i] представляет максимальную длину перехода вперед от индекса i.
Другими словами, если вы находитесь в nums[i], вы можете перейти к любому nums[i + j], где:

0 <= j <= nums[i] и
i + j < n
Возвращает минимальное количество переходов для достижения значений nums[n - 1].
Тестовые примеры генерируются таким образом, чтобы вы могли достичь значений nums[n - 1].

Пример 1:
Входные данные: nums = [2,3,1,1,4]
Выходные данные: 2
Пояснение: Минимальное количество переходов для достижения последнего индекса равно 2.
Перейдите на 1 шаг от индекса 0 к 1, затем на 3 шага к последнему индексу.

Пример 2:
Входные данные: nums = [2,3,0,1,4]
Выходные данные: 2

Ограничения:

1 <= nums.длина <= 104
0 <= nums[i] <= 1000
Гарантируется, что вы сможете получить доступ к nums[n - 1].
 */
public class _45_Jump_Game_II_ {

  public static void main(String[] args) {

    int[] nums = {2, 3, 1, 1, 4};

    Solution45 solution45 = new Solution45();
    int jump = solution45.jump(nums);
    System.out.println(jump);

  }

  // используется жадный алгоритм
  static class Solution45 {
    public int jump(int[] nums) {
    // СОЗДАНИЕ НЕОБХОДИМЫХ ПЕРЕМЕННЫХ
    // создаем и инициализируем счетчик шагов, чтобы отслеживать количество выполненных переходов
    int steps = 0;
    // аналогично создаем и инициализируем максимальную досягаемость с текущей позиции
    int maxReach = 0;
    // аналогично создаем и инициализируем максимальную дальность последнего прыжка
    int lastJampMaxReach = 0;

    // теперь выполняем циклом итерацию по массиву, за исключением последнего элемента,
    // потому что необходимо достичь последнего индекса, а не выходить за его пределы
    for(int i = 0; i < nums.length - 1; i++ ) {
      // обновляем максимальный охват - т. е. это максимальная досягаемость, взяв максимум между текущим значением
      // и позицией, которую мы могли бы достичь по текущему индексу (i + nums[i]),
      // используем как всегда стандартную "завосдкую" функцию, для определения максимального значения из двух
      maxReach = Math.max(maxReach, i + nums[i]);

      // далее, если текущий индекс достигнет максимального значения последнего скачка,
      // то это означает, что совершаем еще один скачок, чтобы двигаться дальше
      if(lastJampMaxReach == i) {
        // ооотв. увеличиваем счетчик шагов, потому что мы совершаем еще один прыжок
        steps++;
        // и обновляем максимальную дальность последнего прыжка до текущей максимальной дальности
        lastJampMaxReach = maxReach;

        // тут уже нет необходимости продолжать, если максимальный охват уже превышает последний индекс,
        // поскольку мы гарантированно завершим цикл
        if(maxReach >= nums.length - 1) {
          break;
        }
      }
    }
      // ну и возвращаем минимальное количество переходов, необходимое для достижения последнего индекса
      return steps;
    }
  }
}

/*
Временная сложность заключается в том, что существует один цикл for, который проходит через массив один раз.
Несмотря на то, что в цикле есть максимальное вычисление, это не меняет общую линейную временную сложность,
так как для вычисления максимума из двух чисел требуется только постоянное время.O(n)nums
 */