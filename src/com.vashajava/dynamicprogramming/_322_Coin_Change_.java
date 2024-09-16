package com.vashajava.dynamicprogramming;

import java.util.Arrays;

/**
 * _322_Coin_Change_.
 *
 * @author Anton Shatkovskiy
 * @created 12.09.2024 г.
 */

/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount.
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104

ПЕРЕВОД: 322. Разменять монету.
Вам выдается целочисленный массив coins, представляющий монеты разного достоинства, и целочисленная сумма, представляющая общую сумму денег.

Верните наименьшее количество монет, необходимое для получения этой суммы.
Если эта сумма денег не может быть получена с помощью какой-либо комбинации монет, верните -1.

Вы можете предположить, что у вас есть бесконечное количество монет каждого вида.

Пример 1:

Входные данные: монеты = [1,2,5], сумма = 11
Выходные данные: 3
Пояснение: 11 = 5 + 5 + 1
Пример 2:

Ввод: монеты = [2], сумма = 3
Вывод: -1
Пример 3:

Ввод: монеты = [1], сумма = 0
Вывод: 0

Ограничения:

1 <= монеты.длина <= 12
1 <= монеты[i] <= 231 - 1
0 <= количество <= 104

 */
public class _322_Coin_Change_ {

  public static void main(String[] args) {

    // вводим данные
    int[] coins = {1, 2, 5};
    int amount = 11;

    // реализация
    Solution322 solution322 = new Solution322();
    int coinChange = solution322.coinChange(coins, amount);
    System.out.println(coinChange);
  }

  static class Solution322 {
    public int coinChange(int[] coins, int amount) {
      // определяем и вводим большое значение, которое будет служить нашей заменой "бесконечности"
      final int INF = 1 << 30;

      // создаем массив 'dp' будет содержать наши оптимальные решения подзадач,
      // dp[i] будет хранить минимальное количество монет, необходимое для получения суммы 'i'
      int[] dp = new int[amount + 1];

      // инциализируем массив dp с помощью INF, чтобы указать, что эти суммы в настоящее время недостижимы с помощью данных монет,
      // где fill(dp, INF) - это "заводской", стандартный метод в классе Arrays, который заполняет весь массив одним и тем же значением
      Arrays.fill(dp, INF);

      // тут инициализируем базовый вариант, когда для получения суммы, равной 0, не требуется никаких монет
      dp[0] = 0;

      // теперь простым циклом перебираем все доступные типы монет
      for (int coin : coins) {
        // для0 каждой монеты стараемся увеличивать целевую сумму, начиная с номинала самой монеты и заканчивая "суммой"
        // тут также задействуем цикл, но модифицированный
        for(int currentAmount = coin; currentAmount <= amount; ++currentAmount) {
          // проверяем, может ли текущая монета внести свой вклад в решение проблемы "currentAmount"
        // если это так, обновляем dp[currentAmount] до минимального значения между текущим и новым возможным количеством используемых монет
          // реализуем тут формулу f[j] = min(f[j], f[j - x] + 1),
          // где Math.min() - стандартный, "заводской", библиотечный метод, который возвращает минимальное значение из двух аргументов
          dp[currentAmount] = Math.min(dp[currentAmount], dp[currentAmount - coin] + 1);
        }
      }
      // возвращаем ответ на заданную "сумму",
      // если значение dp[сумма] по-прежнему равно INF, значит, было невозможно внести сумму, используя данные монеты,
      // исп. тернарный оператор
      return dp[amount] >= INF ? -1 : dp[amount];
    }
  }
}

/*
Временная сложность алгоритма составляет O(S * n), где S - это amount время, за которое нужно разменять,
и n - количество доступных монет разного номинала.
Это связано с тем, что для каждого номинала монеты мы перебираем все значения от номинала монеты до суммы,
постепенно вычисляя наименьшее количество монет, необходимое для внесения изменений для каждого номинала.

 */
