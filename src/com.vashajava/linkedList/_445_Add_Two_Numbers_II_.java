package linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * _445_Add_Two_Numbers_II_.
 *
 * @author Anton Shatkovskiy
 * @created 03.06.2024 г.
 */

/*
You are given two non-empty linked lists representing two non-negative integers.
The most significant digit comes first and each of their nodes contains a single digit.
Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example 1:

Input: l1 = [7,2,4,3], l2 = [5,6,4]
Output: [7,8,0,7]
Example 2:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [8,0,7]
Example 3:

Input: l1 = [0], l2 = [0]
Output: [0]

Constraints:

The number of nodes in each linked list is in the range [1, 100].
0 <= Node.val <= 9
It is guaranteed that the list represents a number that does not have leading zeros.

Follow up: Could you solve it without reversing the input lists?

ПЕРЕВОД: 445. Сложите два числа II.
Вам даны два непустых связанных списка, представляющих два неотрицательных целых числа.
Старшая цифра идет первой, и каждый из их узлов содержит одну цифру.
Сложите два числа и верните сумму в виде связанного списка.

Вы можете предположить, что эти два числа не содержат никакого начального нуля, за исключением самого числа 0.

Пример 1:

Входные данные: l1 = [7,2,4,3], l2 = [5,6,4]
Выходные данные: [7,8,0,7]
Пример 2:

Входные данные: l1 = [2,4,3], l2 = [5,6,4]
Выходные данные: [8,0,7]
Пример 3:

Входные данные: l1 = [0], l2 = [0]
Выходные данные: [0]

Ограничения:

Количество узлов в каждом связанном списке находится в диапазоне [1, 100].
0 <= Node.val <= 9
Гарантируется, что список представляет собой число, не содержащее нулей в начале.

Продолжение: Не могли бы вы решить эту проблему, не меняя местами входные списки?
 */

public class _445_Add_Two_Numbers_II_ {

  public static void main(String[] args) {

    ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
    ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

    Solution445 solution445 = new Solution445();
    ListNode addTwoNumbersII = solution445.addTwoNumbers(l1, l2);
    System.out.println(listToString(addTwoNumbersII));

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
   * Определение для односвязного списка.
  */
static public class ListNode {
    // значение элемента
int val;
    // ссылка на следующий узел, значение null для последнего узла
ListNode next;
    // конструкторы
ListNode() {}
ListNode(int val) { this.val = val; }
ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

  static class Solution445 {
    /**
     * Добавляет два числа, представленные двумя связанными списками, где каждый узел содержит одну цифру.
     * Цифры хранятся в обратном порядке, так что цифра 1 находится в начале списка.
     *
     * @param l1 - Первый связанный список, представляющий первое число.
     * @param l2 - Второй связанный список, представляющий второе число.
     * @return dummyNode.next - связанный список, представляющий сумму двух чисел.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      // для решения этой задачи потребуется ввод новый переменных, в частности - стеков и фиктивного узла
      // создаем и инициализируем стеки, для хранения цифр из двух связанных списков, гарантируя,
      // что мы сможем обрабатывать их в порядке от наименее значимых к наиболее значимым
      // cтеки для хранения цифр двух чисел
      Deque<Integer> stack1 = new ArrayDeque<>();
      Deque<Integer> stack2 = new ArrayDeque<>();

      // вставка всех цифр из l1 в созданную стурктуру данных stack1 - пока l1 не равен нулю!!!
      while (l1 != null) {
        // готовый библиотечный метод
        stack1.push(l1.val);
        // меняем местами для следующего
        l1 = l1.next;
      }

      // аналогично, вставляем все цифры из l2 в stack2  - пока l2 не равен нулю!!!
      while (l2 != null) {
        // готовый библиотечный метод
        stack2.push(l2.val);
        // меняем местами для следующего
        l2 = l2.next;
      }

      // создаеми инициализируем фиктивный узел, создается для облегчения добавления новых узлов в начале результирующего связанного списка
      // 'dummyHead' - это заполнитель для связанного списка результатов
      ListNode dummyNode = new ListNode();
      // инициалищируем перенос до нуля, вот эта переменная нужна для того, что реализовать правило сложения,
      // в котором при сложении двух чисел получается чилсо больше нуля
      // Carry (перенос) используется для хранения значения, которое нужно будет прибавить к следующему разряду числа в случае,
      // если сумма текущего разряда будет больше 9.
      int curry = 0;

      // повторяем цикл до тех пор, пока оба стека не опустеют и не останется места для переноса
      // т. е. тут проверки на пустоту стеков - т. е. вводим условие, пока ....
      while (!stack1.isEmpty() || !stack2.isEmpty() || curry != 0) {
        // если стек пуст, используйте 0 в качестве цифры, в противном случае введите верхнюю цифру,
        // тут результирующая сумма сложения двух стеков попарно и добавления curry, если это необходимо, т. е. > 9
        int sum = (stack1.isEmpty() ? 0 : stack1.pop()) +
            // также исп. библиотечный метод pop для stack
            (stack2.isEmpty() ? 0 : stack2.pop()) + curry;

        /*
        Итак, когда мы находим сумму значений текущих узлов из двух связанных списков (по одному значению из каждого списка,
        добавляем к этой сумме "carry" - перенос от предыдущего шага),
        мы записываем эту сумму в переменную sum. Затем, чтобы создать новый узел для этой суммы,
        мы берем остаток от деления этой суммы на 10, чтобы сохранить только одну цифру в новом узле.
         */

        // создаем новый узел с наименьшей значащей цифрой суммы и добавляем его в начало связанного списка "dummyHead",
        // который будет содержать остаток от деления суммы переменной sum на 10.
        // Это необходимо, так как цифры в каждом узле связанного списка могут быть от 0 до 9,
        // и остаток от деления на 10 позволяет оставить только одну цифру для этого узла.
        // Далее, мы создаем объект newNode типа ListNode с этим остатком (sum % 10)
        // и устанавливаем его следующим узлом для dummyHead. Таким образом, мы создаем новый узел и добавляем его в связанный список,
        // сохраняя порядок цифр.
        ListNode newNode = new ListNode(sum % 10);
        // тут добавляем
        newNode.next = dummyNode.next;
        // меняем местами
        dummyNode.next = newNode;

        // вычисляем новую стоимость переноса, тут суть в следующем - с помощью введенной переменной carry
        // мы можем контролировать перенос при сложении цифр.
        // Если сумма текущих цифр (из стеков и carry) больше 9,
        // мы создаем новый узел связного списка с остатком от деления этой суммы на 10
        // и устанавливаем значение carry равным частному от деления суммы на 10.
        // Таким образом, при следующем сложении цифр мы учтем значение carry.
        curry = sum / 10;
      }
      // возвращаем суммарный связанный список, который называется "dummyHead.next", потому что "dummyHead" - это фиктивный узел
      return dummyNode.next;
    }
  }
}