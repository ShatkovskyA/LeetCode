package com.vashajava.linkedList;

/**
 * Класс _206_Reverse_Linked_List_ - обратный ссылочный список.
 *
 * @author Anton Shatkovskiy
 * @created 31.05.2024 г.
 */

/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:

Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]
Example 2:

Input: head = [1,2]
Output: [2,1]
Example 3:

Input: head = []
Output: []

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?

ПЕРЕВОД: 206. Обратный ссылочный список.
Учитывая заголовок односвязного списка, переверните список и верните перевернутый список.

Пример 1:

Входные данные: заголовок = [1,2,3,4,5]
Выходные данные: [5,4,3,2,1]
Пример 2:

Ввод: head = [1,2]
Вывод: [2,1]
Пример 3:

Ввод: head = []
Вывод: []

Ограничения:

Количество узлов в списке находится в диапазоне [0, 5000].
-5000 <= Node.val <= 5000

Продолжение: Связанный список можно изменять либо итеративно, либо рекурсивно. Не могли бы вы реализовать оба варианта?
 */
public class _206_Reverse_Linked_List_ {

  public static void main(String[] args) {

   ListNode head = new ListNode(1, new ListNode(2, new ListNode(4, new ListNode(5))));

   Solution206 solution206 = new Solution206();
   ListNode reverseLinkedList = solution206.reverseList(head);
   System.out.println(listToString(reverseLinkedList));

  }

  // Вспомогательный метод для печати списка в виде строки
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
    // значение элемента -
    int val;
    // ссылка на следующий узел, значение null для последнего узла
    ListNode next;
    // конструкторы
    ListNode() {}
    ListNode(int val) {
      this.val = val;
    }
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  /**
   * Переворачивает данный связанный список.
   *
   * @param head - Начало исходного односвязного списка.
   * @return начало обратного односвязного списка.
   */
  static class Solution206 {
    public ListNode reverseList(ListNode head) {
      // нам понадобятся вспомогательные объекты класса ListNode, иницализируем их
     // это объект класса для нового списка, заполнитель, собственно его и должны получить
      // фиктивный узел, который поможет перевернуть список
      ListNode dummy = new ListNode();
      // этот указатель будет использоваться для добавления новых элементов в объединенный список
      ListNode current = head;

      // пробегаемся циклом while,
      // перебирая каждый узел в списке
      while (current != null) {
        // временно сохраняем следующий узал
        ListNode nextTemp = current.next;

        // изменяем(перемещаем) ссылку так, чтобы current.next указывал на новый заголовок (dummy.next),
        current.next = dummy.next;

        // перемещаем фиктивный элемент dummy рядом с текущим узлом,
        // сделав его новым началом перевернутого списка
        dummy.next = current;

        // и переходим к следующему узлу в исходном списке
        current = nextTemp;
      }
      // возвращаем обратный связанный список, на который указывает dummy's next
      return dummy.next;
    }
  }
}

/*
Временная сложность предоставленного кода равна O(n),
где n - количество узлов в связанном списке.
Это связано с тем, что код выполняет итерацию по всем узлам в списке за один раз.

Пространственная сложность кода O(1).
 */
