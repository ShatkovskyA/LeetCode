package simulation;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * _682_Baseball_Game_.
 *
 * @author Anton Shatkovskiy
 * @created 14.04.2024 г.
 */

/*
You are keeping the scores for a baseball game with strange rules.
At the beginning of the game, you start with an empty record.

You are given a list of strings operations, where operations[i]
is the ith operation you must apply to the record and is one of the following:

An integer x.
Record a new score of x.
'+'.
Record a new score that is the sum of the previous two scores.
'D'.
Record a new score that is the double of the previous score.
'C'.
Invalidate the previous score, removing it from the record.
Return the sum of all the scores on the record after applying all the operations.

The test cases are generated such that the answer and all
intermediate calculations fit in a 32-bit integer and that all operations are valid.

Example 1:

Input: ops = ["5","2","C","D","+"]
Output: 30
Explanation:
"5" - Add 5 to the record, record is now [5].
"2" - Add 2 to the record, record is now [5, 2].
"C" - Invalidate and remove the previous score, record is now [5].
"D" - Add 2 * 5 = 10 to the record, record is now [5, 10].
"+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15].
The total sum is 5 + 10 + 15 = 30.
Example 2:

Input: ops = ["5","-2","4","C","D","9","+","+"]
Output: 27
Explanation:
"5" - Add 5 to the record, record is now [5].
"-2" - Add -2 to the record, record is now [5, -2].
"4" - Add 4 to the record, record is now [5, -2, 4].
"C" - Invalidate and remove the previous score, record is now [5, -2].
"D" - Add 2 * -2 = -4 to the record, record is now [5, -2, -4].
"9" - Add 9 to the record, record is now [5, -2, -4, 9].
"+" - Add -4 + 9 = 5 to the record, record is now [5, -2, -4, 9, 5].
"+" - Add 9 + 5 = 14 to the record, record is now [5, -2, -4, 9, 5, 14].
The total sum is 5 + -2 + -4 + 9 + 5 + 14 = 27.
Example 3:

Input: ops = ["1","C"]
Output: 0
Explanation:
"1" - Add 1 to the record, record is now [1].
"C" - Invalidate and remove the previous score, record is now [].
Since the record is empty, the total sum is 0.

Constraints:

1 <= operations.length <= 1000
operations[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104].
For operation "+", there will always be at least two previous scores on the record.
For operations "C" and "D", there will always be at least one previous score on the record.

ПЕРЕВОД: 682. Игра в бейсбол.
Вы ведете счет в бейсбольном матче со странными правилами.
В начале игры вы начинаете с пустой записи.

Вам предоставляется список операций со строками,
где operations[i] - это i-я операция, которую вы должны применить к записи,
и она является одной из следующих:

Целое число x.
Запишите новый балл, равный x.
"+".
Запишите новый балл, который является суммой двух предыдущих баллов.
"D".
Запишите новый балл, который в два раза больше предыдущего.
"C".
Аннулирует предыдущую оценку, удаляя ее из записи.
Возвращает сумму всех оценок в записи после применения всех операций.

Тестовые задания генерируются таким образом,
чтобы ответ и все промежуточные вычисления укладывались в 32-разрядное целое число и
чтобы все операции были допустимыми.

Пример 1:

Ввод: ops = ["5","2"," C","D","+"]
Вывод: 30
Объяснение:
"5" - добавьте 5 к записи, теперь запись равна [5].
"2" - Добавляем 2 к записи, теперь запись равна [5, 2].
"C" - Аннулируем и удаляем предыдущую оценку, теперь запись равна [5].
"D" - Добавляем к записи 2 * 5 = 10, теперь запись равна [5, 10].
"+" - Добавляем к записи 5 + 10 = 15, теперь запись будет [5, 10, 15].
Общая сумма равна 5 + 10 + 15 = 30.

Пример 2:

Ввод: ops = ["5","-2","4"," C","D"","9","+","+"]
Вывод: 27
Объяснение:
"5" - Добавляем 5 к записи, теперь запись равна [5].
"-2" - Добавляем -2 к записи, теперь запись равна [5, -2].
"4" - Добавляем 4 к записи, теперь запись равна [5, -2, 4].
"C" - Аннулируем и удаляем предыдущую оценку, теперь запись равна [5, -2].
"D" - Добавляем к записи 2 * -2 = -4, запись теперь равна [5, -2, -4].
"9" - Добавляем к записи 9, запись теперь равна [5, -2, -4, 9].
"+" - Добавьте -4 + 9 = 5 к записи, запись теперь доступна. [5, -2, -4, 9, 5].
"+" - Добавляем к записи 9 + 5 = 14, теперь запись равна [5, -2, -4, 9, 5, 14].
Общая сумма равна 5 + -2 + -4 + 9 + 5 + 14 = 27.

Пример 3:

Ввод: ops = ["1","C"]
Вывод: 0
Объяснение:
"1" - Добавляем 1 к записи, теперь запись равна [1].
"C" - Аннулируем и удаляем предыдущую оценку, теперь запись равна [].
Поскольку запись пуста, общая сумма равна 0.

Ограничения:

1 <= операции.длина <= 1000
операций[i] - это "C", "D", "+" или строка, представляющая целое число в диапазоне [-3 * 104, 3 * 104].
Для операции "+" в записи всегда будет по крайней мере две предыдущие оценки.
Для операций "C" и "D" в записи всегда будет по крайней мере одна предыдущая оценка.

 */
public class _682_Baseball_Game_ {

  public static void main(String[] args) {

    // инициализация массива - { }
    String[] operations = {"5","-2","4","C","D","9","+","+"};

    Solution682 solution682 = new Solution682();
    System.out.println(solution682.calPoints(operations));

  }

  // для реализации задачи используется стек - очередь!
  static class Solution682 {
    public int calPoints(String[] operations) {

      // инициализируем пустой стек-чередь, для отслеживания результатов по мере их записи
      // создаем таблицу для использования в качестве стека для отслеживания очков.
      Deque<Integer> stack = new ArrayDeque<>();

      // далее вводим цикл, и пробегаемся по этому циклу - цикл foreach
      for (String ops : operations) {
        // применяем цикл switch-case
        switch (ops) {
          // операция равна "+", это значит, сумма двух последних элементов в стеке-очереди.
          case "+":
            // удаляем последний результат (элемент) из списка с помощью стандартного метода
            int last = stack.pop();
            // далее извлекаем элемент в начале стека-очереди, также стандартный метод
            int newTop = stack.peek();
            // далее помещаем в стек-очередь последний результат (элемент) last
            stack.push(last);
            // далее помещаем сумму последних результатов(элементов) обратно в стек
            stack.push(last + newTop);
            // переход
            break;
          // следующая операция "D" - для удвоения последнего результата
          case "D":
            // смотрим последний балл(результат-оценку), удваиваем его и помещаем в стек
            stack.push(stack.peek() * 2);
            break;
          // следующая операция "C" - для аннулирования и удаления предыдущей оценки
          case "C":
            // удаляем последнюю балл(результат-оценку) из стека
            // метод pop() в Java используется для удаления или возврата элемента из головы очереди
            stack.pop();
            break;
          // для любого числа (не буквы) разберите его и поместите в стек
          default:
            // преобразует строку (метод parseInt) в целое число и помещает ее в стек
            stack.push(Integer.parseInt(ops));
            break;
        }
      }

        // далее по условию суммируем все баблы и кладем в стек-очередь
        // для начала вводим и инициализируем переменную суммы
        int sum = 0;

        // далее вводим упрощенный цикл for-each, пробегаемся по очереди
        for (int score : stack) {
          // накапливаем баллы
          sum += score;
        }
        // возвращаем новую сумму
        return sum;
      }
    }
  }


