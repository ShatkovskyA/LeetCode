package com.vashajava.math;

/**
 * Класс _70_Climbing_Stairs_ - подъем по лестнице.
 *
 * @author Anton Shatkovskiy
 * @created 25.06.2024 г.
 */

/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Constraints:

1 <= n <= 45

ПЕРЕВОД: 70. Подъем по лестнице.
Вы поднимаетесь по лестнице. Чтобы достичь вершины, требуется сделать n шагов.

Каждый раз вы можете подняться на 1 или 2 ступеньки.
Сколькими различными способами вы можете подняться на вершину?

Пример 1:

Входные данные: n = 2
Выходные данные: 2
Пояснение: Есть два способа подняться на вершину.
1. 1 шаг + 1 ступенька
2. 2 шага
Пример 2:

Входные данные: n = 3
Выходные данные: 3
Пояснение: Есть три способа подняться на вершину.
1. 1 шаг + 1 ступенька + 1 шаг
2. 1 шаг + 2 ступени
3. 2 ступени + 1 ступенька

Ограничения:

1 <= n <= 45
 */

public class _70_Climbing_Stairs_ {

  public static void main(String[] args) {

    int n = 2;

    Solution70 solution70 = new Solution70();
    int climbStairs = solution70.climbStairs(n);
    System.out.println(climbStairs);

  }

  static class Solution70 {

    // это есть метод вычисляет количество различных способов подняться на вершину
    public int climbStairs(int n) {

      // задаем т. н. начальные значения, т. е. это своего рода два счетчика
      // тут один шаг
      int first = 0;
      // тут два шага
      int second = 1;

      // далее пробегаемся циклом, где n - это количество шагов
      for (int i = 0; i < n; i++) {
        // вычисляем следующие числа в ряду
        int next = first + second;

        // и обновляем предыдущие два числа для следующей итерации
        first = second;
        second = next;
      }
      // возвращаем переменную "second", кот. содержит общее количество способов достижения вершины
      return second;

    }
  }
}

 /*
  Временная сложность этого алгоритма заключается O(n)в том, что мы проходим шаги от 1до n.
  Элегантность этого решения заключается в простом, но мощном использовании шаблона последовательности Фибоначчи,
  где количество способов достижения данного шага представляет собой сумму количества способов достижения двух предыдущих шагов,
  точно так же, как числа Фибоначчи являются сумма двух предыдущих чисел последовательности.
   */
