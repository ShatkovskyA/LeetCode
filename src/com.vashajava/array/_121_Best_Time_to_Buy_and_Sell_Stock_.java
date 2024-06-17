package array;

/**
 * _121_Best_Time_to_Buy_and_Sell_Stock_.
 *
 * @author Anton Shatkovskiy
 * @created 11.06.2024 г.
 */

/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104

ПЕРЕВОД: 121. Лучшее время для покупки и продажи акций.
Вам предоставляется массив цен, где prices[i] - это цена данной акции на i-й день.

Вы хотите максимизировать свою прибыль, выбрав один день для покупки одной акции и другой день в будущем для продажи этой акции.

Верните максимальную прибыль, которую вы можете получить от этой транзакции. Если вы не можете получить никакой прибыли, верните 0.

Пример 1:

Входные данные: цены = [7,1,5,3,6,4]
Выходные данные: 5
Пояснение: Покупайте на 2-й день (цена = 1) и продавайте на 5-й день (цена = 6), прибыль = 6-1 = 5.
Обратите внимание, что покупка на 2-й день и продажа на 1-й день запрещены, поскольку перед продажей вы должны купить.
Пример 2:

Входные данные: цены = [7,6,4,3,1]
Выходные данные: 0
Пояснение: В этом случае транзакции не выполняются, а максимальная прибыль равна 0.

Ограничения:

1 <= цены.длина <= 105
0 <= цены[i] <= 104
 */

  /*
  Временная сложность данной функции равна O(n), где n - длина входного списка prices.
  Это связано с тем, что функция включает в себя единый цикл, который перебирает каждый элемент в списке ровно один раз,
  выполняя постоянный объем работы на каждом шаге; таким образом, общая выполняемая работа линейна по размеру входных данных.

Пространственная сложность функции равна O(1), что указывает на то, что объем дополнительной памяти, используемой функцией,
не зависит от размера входных данных. Функция использует только фиксированное количество дополнительных переменных (ans и mi),
которые требуют постоянного объема пространства независимо от размера входных данных.
   */
public class _121_Best_Time_to_Buy_and_Sell_Stock_ {

  public static void main(String[] args) {

    int[] prices = {7, 1, 5, 3, 6, 4};

    Solution121 solution121 = new Solution121();
    int maxProfit = solution121.maxProfit(prices);
    System.out.println(maxProfit);

  }

  static class Solution121 {

    public int maxProfit(int[] prices) {

      // традиционно - инициализация всех необходимых переменных
      // инициализируем значение "maxProfit"(это и есть прибыль) равным 0, что является минимальной прибылью, которую можно получить
      int maxProfit = 0;

      // предположим, что первая цена - это минимальная цена покупки - т. е. начальное значение - это минимальная цена покупки
      int minProfit = prices[0];

      // а теперь просматриваем все цены, чтобы получить максимальную прибыль, т. е. пробегаемся тупо циклом for-each
      for(int price : prices) {
        // рассчитываем максимальную прибыль, сравнив текущую "maxProfit"
        // с разницей между текущей ценой(price) и "минимальной ценой"(minProfit) с помощью библиотечного метода
        // класса Math - max() – возвращает максимальное значение из двух аргументов. Аргумент может быть int, float, long, double
        maxProfit = Math.max(maxProfit, price - minProfit);

      // обновляем "Минимальную цену", если будет найдена более низкая цена с помощью библиотечного метода
      // класс Math - max() – возвращает минимальное значение из двух аргументов. Аргумент может быть int, float, long, double
      minProfit = Math.min(minProfit, price);
     }
      // возвращаем максимальную прибыль, которая может быть достигнута
      return maxProfit;
    }
  }
}
