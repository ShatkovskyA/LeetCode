package com.vashajava.linkedList;

import linkedList._2_Add_Two_Numbers_.ListNode;

/**
 * Класс _141_Linked_List_Cycle_ - связанный список циклов.
 *
 * @author Anton Shatkovskiy
 * @created 18.06.2024 г.
 */

/*
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.

Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
Example 2:

Input: head = [1,2], pos = 0
Output: true
Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
Example 3:

Input: head = [1], pos = -1
Output: false
Explanation: There is no cycle in the linked list.

Constraints:

The number of the nodes in the list is in the range [0, 104].
-105 <= Node.val <= 105
pos is -1 or a valid index in the linked-list.

Follow up: Can you solve it using O(1) (i.e. constant) memory?

ПЕРЕВОД: 141. Связанный список циклов.
По заданному заголовку, началу связанного списка, можно определить, есть ли в связанном списке цикл.

В связанном списке есть цикл, если в списке есть какой-либо узел, к которому можно снова перейти, непрерывно следуя следующему указателю.
Внутренне pos используется для обозначения индекса узла, к которому подключен следующий указатель tail.
Обратите внимание, что pos не передается в качестве параметра.

Верните значение true, если в связанном списке есть цикл. В противном случае верните значение false.

Пример 1:

Входные данные: head = [3,2,0,-4], pos = 1
Выходные данные: true
Пояснение: В связанном списке есть цикл, в котором конец подключается к 1-му узлу (индексированному 0).
Пример 2:

Входные данные: head = [1,2], pos = 0
Выходные данные: true
Объяснение: В связанном списке есть цикл, в котором конечная точка подключается к 0-му узлу.
Пример 3:

Входные данные: head = [1], pos = -1
Выходные данные: false
Объяснение: В связанном списке нет цикла.

Ограничения:

Количество узлов в списке находится в диапазоне [0, 104].
-105 <= Node.val <= 105
значение pos равно -1 или допустимому индексу в связанном списке.

Продолжение: Можете ли вы решить эту проблему, используя O(1) (т.е. постоянную) память?
 */
public class _141_Linked_List_Cycle_ {

  public static void main(String[] args) {

//    // заготовка на будущее
//    ListNode node1 = new ListNode(3);
//    ListNode node2 = new ListNode(2);
//    ListNode node3 = new ListNode(0);
//    ListNode node4 = new ListNode(-4);
//
//    node1.next = node2;
//    node2.next = node3;
//    node3.next = node4;
//    node4.next = null;

    ListNode head = new ListNode(3, new ListNode(2, new ListNode(0, new ListNode(-4))));

    Solution141 solution141 = new Solution141();
    Boolean hasCycle = solution141.hasCycle(head);
    System.out.println(hasCycle);
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
   * Класс-структура ListNode для односвязного списка
   */
  static class ListNode {
    // значение элемента
    int val;
    // ссылка на следующий узел, значение null для последнего узла
    ListNode next;
    // конструкторы
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

 static public class Solution141 {
   /**
    * Определяет, есть ли цикл в связанном списке.
    *
    * @param head - начало односвязного списка.
    * @return значение true, если цикл есть, и значение false в противном случае.
    */
    public boolean hasCycle(ListNode head) {
      // создаем и инициализируем два указателя,
      // медленный указатель перемещается на один шаг за раз
      ListNode slow = head;
      // и быстрый указатель перемещается на два шага за раз
      ListNode fast = head;

      // И далее циклом while продолжаем просматривать список до тех пор,
      // пока быстрый указатель (fast) и его следующий (fast.next) не будут равны нулю
      while (fast != null && fast.next != null) {
        // медленно перемещаем указатель на один шаг
        slow = slow.next;
        // в свою очередь указатель быстрого перемещения перемещаем на два шага
        fast = fast.next.next;
        // и основное условие - медленный и быстрый указатели совпадают, то существует цикл
        if(slow == fast) {
          return true;
        }
      }
      // если же цикл завершается без встречи указателей, то цикла нет
      return false;
    }
  }
}

  /*
  Временная сложность данного кода равна O(H), где H– высота двоичного дерева. Это связано с тем,
  что код проходит дерево от корня до наименьшего общего предка (LCA), не посещая узлы более одного раза.
  В худшем случае, когда двоичное дерево несбалансировано,
  высота Hможет быть линейной относительно количества узлов, Nчто приводит к временной сложности O(N).
  Однако в сбалансированном дереве временная сложность заключается O(log N)в том,
  что высота дерева логарифмически зависит от количества узлов.
   */
