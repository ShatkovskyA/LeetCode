package matrix;

/**
 * _1672_Richest_Customer_Wealth_.
 *
 * @author Anton Shatkovskiy
 * @created 24.04.2024 г.
 */

/*
You are given an m x n integer grid accounts where accounts[i][j] is the amount of money
the i​​​​​​​​​​​th​​​​ customer has in the j​​​​​​​​​​​th​​​​ bank.
Return the wealth that the richest customer has.

A customer's wealth is the amount of money they have in all their bank accounts. The richest customer is the customer that has the maximum wealth.

Example 1:

Input: accounts = [[1,2,3],[3,2,1]]
Output: 6
Explanation:
1st customer has wealth = 1 + 2 + 3 = 6
2nd customer has wealth = 3 + 2 + 1 = 6
Both customers are considered the richest with a wealth of 6 each, so return 6.

Example 2:

Input: accounts = [[1,5],[7,3],[3,5]]
Output: 10
Explanation:
1st customer has wealth = 6
2nd customer has wealth = 10
3rd customer has wealth = 8
The 2nd customer is the richest with a wealth of 10.

Example 3:

Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
Output: 17

Constraints:

m == accounts.length
n == accounts[i].length
1 <= m, n <= 50
1 <= accounts[i][j] <= 100

ПЕРЕВОД: 1672. Богатство самых богатых клиентов
Вам предоставляется таблица из m x n целочисленных счетов, где счета [i][j] - это сумма денег, которая есть у i-го клиента в j-м банке.
Верните состояние, которое есть у самого богатого клиента.

Состояние клиента - это сумма денег, которая есть у него на всех его банковских счетах.
Самый богатый клиент - это клиент, обладающий максимальным состоянием.

Пример 1:

Входные данные: счета = [[1,2,3],[3,2,1]]
Выходные данные: 6
Объяснение:
1-й клиент богат = 1 + 2 + 3 = 6
2-й клиент богат = 3 + 2 + 1 = 6
Оба клиента считаются самыми богатыми с состоянием в 6 долларов у каждого, поэтому верните 6.

Пример 2:

Ввод: счета = [[1,5],[7,3],[3,5]]
Вывод: 10
Объяснение:
у 1-го клиента состояние = 6
у 2-го клиента состояние = 10
состояние 3-го клиента равно 8
Второй клиент является самым богатым с состоянием 10.

Пример 3:

Входные данные: счета = [[2,8,7],[7,1,3],[1,9,5]]
Выходные данные: 17

Ограничения:

m == учетных записей.длина
n == аккаунтов[i].длина
1 <= m, n <= 50
1 <= аккаунтов[i][j] <= 100

 */

public class _1672_Richest_Customer_Wealth_ {

  public static void main(String[] args) {

    // две строки и три столбца
    int[][] accounts = {{1,2,3}, {3,2,1}};

    Solution1672 solution1672 = new Solution1672();
    System.out.println(solution1672.maximumWealth(accounts));

  }

  static class Solution1672 {
    public int maximumWealth(int[][] accounts) {

      // вводим и инициализируем переменную богатства для клиента в банке
      int wealth = 0;

      // применяем циклы
      // тут пробегаемся по i-му - по строкам
      for (int i = 0; i < accounts.length; i++) {

        // вводим и инициализируем переменную максимума богатства для клиента в банке
        // которую собственно нам надо найти для каждого клиента в банке
        int maxWealth = 0;

        // применяем опять цикл и высчитываем максисму
        // тут пробегаемся по j-му - по столбцам
        for (int j = 0; j < accounts[0].length; j++) {
          // здесь сумма равна сумме +
          maxWealth += accounts[i][j];
        }

        // тут условие применяем, что если богатсво меньше максиума то оно приравнивается
        if (wealth < maxWealth) {
          wealth = maxWealth;
        }
      }
      // и возвращаем богатство
      return wealth;

    }
  }

}
