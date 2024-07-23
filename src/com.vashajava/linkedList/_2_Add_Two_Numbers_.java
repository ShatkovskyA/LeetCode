package linkedList;

/**
 * _2_Add_Two_Numbers_.
 *
 * @author Anton Shatkovskiy
 * @created 31.05.2024 г.
 */

/*
You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order, and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
Example 2:

Input: l1 = [0], l2 = [0]
Output: [0]
Example 3:

Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

ПЕРЕВОД: 2. Сложите два числа
Вам даны два непустых связанных списка, представляющих два неотрицательных целых числа.
Цифры хранятся в обратном порядке, и каждый из их узлов содержит одну цифру.
Сложите два числа и верните сумму в виде связанного списка.

Вы можете предположить, что эти два числа не содержат никакого начального нуля, за исключением самого числа 0.

Пример 1:

Входные данные: l1 = [2,4,3], l2 = [5,6,4]
Выходные данные: [7,0,8]
Пояснение: 342 + 465 = 807.
Пример 2:

Входные данные: l1 = [0], l2 = [0]
Выходные данные: [0]
Пример 3:

Входные данные: l1 = [9,9,9,9,9,9,9,9], l2 = [9,9,9,9,9]
Выходные данные: [8,9,9,9,0,0,0,1]

Ограничения:

Количество узлов в каждом связанном списке находится в диапазоне [1, 100].
0 <= Node.val <= 9
Гарантируется, что список представляет собой число, не содержащее нулей в начале.
*/

public class _2_Add_Two_Numbers_ {

  public static void main(String[] args) {

    ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    Solution2 solution2 = new Solution2();
    ListNode addTwoNumbers = solution2.addTwoNumbers(l1, l2);
    System.out.println(listToString(addTwoNumbers));

  }

  // Вспомогательный метод для печати списка
  public static String listToString(ListNode node) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    while (node != null) {
      sb.append(node.val);
      if (node.next != null) {
        sb.append(", ");
      }
      node = node.next;
    }
    sb.append("]");
    return sb.toString();
  }

  /**
   * Definition for singly-linked list.
   * public class ListNode {
   *     int val;
   *     ListNode next;
   *     ListNode() {}
   *     ListNode(int val) { this.val = val; }
   *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   * }
   */

  /**
   * Definition for singly-linked list.
   */
  static public class ListNode {
    // значение элемента
    int val;
    // ссылка на следующий узел, значение null для последнего узла
    ListNode next;
    // конструкторы
    ListNode() {
    }
    ListNode(int val) {
      this.val = val;
    }
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  static class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      // вводим переменные
      // инициализируем фиктивный узел, который будет выступать как отправная точка отсчета
      ListNode dummyNode = new ListNode();
      // создаем переменную для отслеживания переноса данных
      int curr = 0;
      // создаем переменную для повторения по новому списку - это узлы
      ListNode current = dummyNode;

      // применяем цикл while
      // выполняем итерацию до тех пор,
      // пока в любом из списков не останется узел или не произойдет перенос
      while (l1 != null || l2 != null || curr != 0) {
        // суммируем значения двух узлов, если они не равны нулю,
        // в противном случае добавляем 0 - исп. тернарный оператор
        int sum = (l1 == null ? 0 : l1.val) +
            (l2 == null ? 0 : l2.val) + curr;

        // обновляем перенос для следующей итерации
        curr = sum / 10;

        // и создаем новый узел с цифровым значением суммы
        current.next = new ListNode(sum % 10);

        // переходим к следующему узлу в списке результатов
        current = current.next;

        // продолжаем в каждом списке ввода
        // через тернарный оператор
        l1 = l1 == null ? null : l1.next;
        l2 = l2 == null ? null : l2.next;
        }

      // т. к. первый узел был фиктивным, то реальный список начинается с dummyNode.next
      return dummyNode.next;

    }
  }
}
