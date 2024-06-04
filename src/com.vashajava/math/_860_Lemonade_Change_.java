package math;

/**
 * _860_Lemonade_Change_.
 *
 * @author Anton Shatkovskiy
 * @created 26.05.2024 г.
 */

/*
At a lemonade stand, each lemonade costs $5. Customers are standing in a queue to buy from you and order one at a time (in the order specified by bills).
Each customer will only buy one lemonade and pay with either a $5, $10, or $20 bill.
You must provide the correct change to each customer so that the net transaction is that the customer pays $5.

Note that you do not have any change in hand at first.
Given an integer array bills where bills[i] is the bill the ith customer pays, return true if you can provide every customer with the correct change, or false otherwise.

Example 1:

Input: bills = [5,5,5,10,20]
Output: true
Explanation:
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.

Example 2:

Input: bills = [5,5,10,10,20]
Output: false
Explanation:
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can not give the change of $15 back because we only have two $10 bills.
Since not every customer received the correct change, the answer is false.

Constraints:

1 <= bills.length <= 105
bills[i] is either 5, 10, or 20.

ПЕРЕВОД: 860. Лемонадный обмен.
В киоске с лимонадом каждый лимонад стоит 5 долларов.
Клиенты выстраиваются в очередь, чтобы купить у вас и сделать заказ по очереди (в порядке, указанном в биллах).
Каждый клиент покупает только один лимонад и расплачивается купюрой на 5, 10 или 20 долларов.
Вы должны предоставить каждому клиенту правильную сдачу, чтобы в итоге клиент заплатил 5 долларов.

Обратите внимание, что сначала у вас на руках нет сдачи.

Задан целочисленный массив bills, где bills[i] - это счет, который оплачивает i-й клиент,
верните значение true, если вы можете предоставить каждому клиенту правильную сдачу, или значение false в противном случае.

Пример 1:

Ввод: счета = [5,5,5,10,20]
Вывод: true
Объяснение:
От первых 3 клиентов мы получаем три счета по 5 долларов в порядке очередности.
От четвертого клиента мы получаем счет на 10 долларов и возвращаем 5 долларов.
От пятого клиента мы получаем чек на 10 долларов и чек на 5 долларов.
Поскольку все клиенты получили правильную сдачу, мы выводим значение true.

Пример 2:

Ввод: счета = [5,5,10,10,20]
Вывод: false
Объяснение:
От первых двух клиентов по заказу мы получаем две купюры по 5 долларов.
Для следующих двух клиентов по заказу мы получаем купюру по 10 долларов и возвращаем купюру по 5 долларов.
Последнему клиенту мы не можем вернуть сдачу в размере 15 долларов, поскольку у нас есть только две купюры по 10 долларов.
Поскольку не все клиенты получили сдачу правильно, ответ будет неверным.

Ограничения:

1 <= счета.длина <= 105
купюр[i] равна 5, 10 или 20.
 */


public class _860_Lemonade_Change_ {

  public static void main(String[] args) {

    int[] bills = {5, 5, 10, 10, 20};

    Solution860 solution860 = new Solution860();
    System.out.println(solution860.lemonadeChange(bills));

  }

  static class Solution860 {
    public boolean lemonadeChange(int[] bills) {

      // инициализация счетчиков для 5 и 10 долларов
      int fiveDollarsBills = 0;
      int tenDollarsBills = 0;

     // выполняем итерацию и пробегаемся циклом по каждому счету за лимонад в массиве
      for (int bill : bills) {
        // тут используем цикл switch-case для обработки разных номиналов валюты
        switch (bill) {
          // тут это банкнота номиналом 5 долларов, сдача не требуется, увеличьте количество банкнот номиналом 5 долларов
          case 5: fiveDollarsBills++;
          break;
          // тут дял банкноты номиналом 10 долларов нам нужно внести одну банкноту номиналом 5 долларов в качестве сдачи соответсвенно
          case  10: tenDollarsBills++; // тут увеличиваем количество купюр на 10 долларов, т. е. счетчик увеличивается
            fiveDollarsBills--; // а тут уменьшаем количество купюр на 5 долларов, так как мы даем их в качестве сдачи, т. е. счетчик на 5 долларов уменьшается
            break;
          // при покупке 20-долларовой купюры предпочтите одну купюру на 10 долларов и одну купюру на 5 долларов в качестве сдачи, если это возможно
          case 20:
            // вот это вот, если возможно оборачиваем в if
            if(tenDollarsBills > 0) {
              tenDollarsBills--; // тут сдача на 10 долларов - счетчик уменьшаем
              fiveDollarsBills--; // тут сдача на 5 долларов - счетчик уменьшаем
            } else {
              // если нет купюр по 10 долларов, нам нужно дать три купюры по 5 долларов в качестве сдачи
              fiveDollarsBills -= 3;
            }
            break;

        }
        // а если в какой-то момент у нас не хватит уж и 5-долларовых купюр для сдачи, то возвращаем false
        if (fiveDollarsBills < 0) {
          return false;
        }

      }
      // и последнее, если мы сможем внести изменения для всех клиентов, верните значение true
      return true;
    }
  }
}