package com.vashajava.dynamicprogramming;

/**
 * _122_Best_Time_to_Buy_and_Sell_Stock_II_.
 *
 * @author Anton Shatkovskiy
 * @created 06.11.2024 г.
 */

/*
You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
However, you can buy it then immediately sell it on the same day.

Find and return the maximum profit you can achieve.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.

Example 2:
Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.

Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104

ПЕРЕВОД: 122. Лучшее время для покупки и продажи акций II.
Вам предоставляется целочисленный массив prices, где prices[i] - это цена данной акции на i-й день.

В каждый день вы можете принять решение о покупке и/или продаже акции. Вы можете владеть не более чем одной акцией в любое время.
Однако вы можете купить его, а затем сразу же продать в тот же день.

Найдите и верните максимальную прибыль, которую вы можете получить.

Пример 1:
Входные данные: цены = [7,1,5,3,6,4]
Выходные данные: 7
Пояснение: Покупайте на 2-й день (цена = 1) и продавайте на 3-й день (цена = 5), прибыль = 5-1 = 4.
Затем покупайте на 4-й день (цена = 3) и продавайте на 5-й день (цена = 6), прибыль = 6-3 = 3.
Общая прибыль равна 4 + 3 = 7.

Пример 2:
Входные данные: цены = [1,2,3,4,5]
Результат: 4
Пояснение: Покупайте в первый день (цена = 1) и продавайте в пятый день (цена = 5), прибыль = 5-1 = 4.
Общая прибыль равна 4.
Пример 3:

Входные данные: цены = [7,6,4,3,1]
Выходные данные: 0
Пояснение: Нет способа получить положительную прибыль, поэтому мы никогда не покупаем акции для достижения максимальной прибыли, равной 0.

Ограничения:

1 <= цены.длина <= 3 * 104
0 <= цены[i] <= 104
 */

  // используется простой, но эффективный жадный алгоритм
public class _122_Best_Time_to_Buy_and_Sell_Stock_II_ {

  public static void main(String[] args) {

    int[] prices = {7, 1, 5, 3, 6, 4};

    Solution122 solution122 = new Solution122();
    int maxProfit = solution122.maxProfit(prices);
    System.out.println(maxProfit);

  }

  static class Solution122 {
    // собственно сам метод для расчета максимальной прибыли, которую можно получить
    // покупая и продавая акции в разные дни
    public int maxProfit(int[] prices) {
      // тут вводим и инициализируем нулем общую прибыль
      int totalProfit = 0;

      // традиционно пробегаемся циклом для просмотра массива цен
      for (int i = 1; i < prices.length; ++i) {
        // теперь по формуле рассчитываем прибыль за текущий день, вычтя цену предыдущего дня из цены текущего дня,
        // используем "заводскую" фабричную функцию Math.max - для нахождения максимального элемента из двух
        int dailyProfit = Math.max(0, prices[i] - prices[i - 1]);

        // далее прибавляем дневную прибыль к общей прибыли
        // и эта сумма будет накапливаться, если покупка в i-й день и продажа в i-й день будут прибыльными
        totalProfit += dailyProfit;
      }
      // возвращаем всю накопленную прибыль
      return  totalProfit;
    }
  }
}
/*
Временная сложность предоставленного кода составляет O(n), где n - длина prices списка.
Это происходит потому, что код выполняет итерацию по списку один раз с помощью pairwise функции,
которая генерирует кортеж для каждой смежной пары элементов.
 */
