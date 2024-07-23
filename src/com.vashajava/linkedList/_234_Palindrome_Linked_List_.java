package com.vashajava.linkedList;

/**
 * _234_Palindrome_Linked_List_.
 *
 * @author Anton Shatkovskiy
 * @created 16.07.2024 г.
 */

/*
Given the head of a singly linked list, return true if it is a
palindrome or false otherwise.

Example 1:

Input: head = [1,2,2,1]
Output: true
Example 2:

Input: head = [1,2]
Output: false

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9

Follow up: Could you do it in O(n) time and O(1) space?

ПЕРЕВОД: 234. Связанный список палиндромов.
Если задан заголовок односвязного списка, верните значение true, если это
палиндром, или false в противном случае.

Пример 1:

Ввод: head = [1,2,2,1]
Вывод: true
Пример 2:

Ввод: head = [1,2]
Вывод: ложь

Ограничения:

Количество узлов в списке находится в диапазоне [1, 105].
0 <= Node.val <= 9

Уточнение: Не могли бы вы сделать это за O(n) времени и O(1) интервала?

 */
public class _234_Palindrome_Linked_List_ {

  public static void main(String[] args) {

    ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));

    Solution234 solution234 = new Solution234();
    Boolean isPalindrome = solution234.isPalindrome(head);
    System.out.println(isPalindrome);
  }

  // вспомогательный метод для печати списка
  public static String listToString(ListNode node) {
    // создали объект StringBuilder
    StringBuilder sb = new StringBuilder();
    // скобочку открыли
    // преобразовали переданный объект в строку и добавили к текущей строке
    // фабричный метод append, класса StringBuilder -
    // преобразовывает переданный объект в строку и добавляет к текущей строке
    sb.append("[");
    // цикл, если нода не равна null
    while (node != null) {
      // фабричный метод append, класса StringBuilder -
      // преобразовывает переданный объект в строку и добавляет к текущей строке
      sb.append(node.val);
      // а если и следующий элемент не равен null, то запаятая
      if (node.next != null) {
        sb.append(", ");
      }
      node.next = node;
     }
    // и скобку закрываем
    sb.append("]");
    // возвращем объект типа StringBuilder, изначально созданный в виде строки
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

  // Определение для односвязного списка.
  // Вспомогательный класс обпределения узлов для односвязного списка.
  // Класс-структура ListNode для односвязного списка.
  static class ListNode {
    // значение элемента
    int val;
    // ссылка на следующий узел, значение null для последнего узла
    ListNode next;
    // традиционно конструкторы
    // пустой конструктор
    ListNode() {}
    // констурктор для значения
    ListNode(int val) {
      this.val = val;
    }
    // общий конструктор для инициализации значений элементов и ссылки на следующий узел
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  static class Solution234 {
    public boolean isPalindrome(ListNode head) {
      // вводим и используем два указателя: медленно двигайтесь по одному шагу за раз, а быстро - по два шага за раз
      // медленный указатель - указывает на head как на начальную точку
      ListNode slow = head;
      // быстрый указатель - указывает на head как на начальную точку
      ListNode fast = head;

      // перемещаем быстрый указатель в конец списка и медленный - в середину
      // медленный делает на один шаг, быстрый на два
      while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
      }

      // доходим до конца списка fast == null, а slow в этом случае оказывается в середине и переворачиваем вторую половину списка
      // и тут вводим новые переменные указатели для того, чтобы идти в обратную сторону
      // prev = null - тут дошли до конца и начинаем с другого конца списка
      ListNode prev = null;
      // тут указатель приравниваем к медленному
      ListNode current = slow;
      // и теперь, также, циклом дивгаемся обратно
      while (current != null) {
        // сохраняем следующий узел - т. е. вводим некую условно временную переменную для этого сохранения
        ListNode temp = current.next;
        // отменяем связь - тут как бы переворачиваем
        current.next = prev;
        // перемещаем предыдущий узел на текущий
        prev = current;
        // и переходим к следующему узлу в исходном списке
        current = temp;
      }
      // тепереь после прохождения туда и обратно - сравниваем перевернутую вторую половину с первой половиной
      // также вводим некие переменные
      ListNode firstHalfIterator = head;
      ListNode secondHalfIterator = prev;
      // опять задействуем цикл while
      while (secondHalfIterator != null) {
        // сраниваем, если значения разные, то это не палиндром
        if(firstHalfIterator.val != secondHalfIterator.val) {
          return false;
        }
        // переходим к следующим узлам в обеих половинах
        firstHalfIterator = firstHalfIterator.next;
        secondHalfIterator = secondHalfIterator.next;
      }
      // ну а тут все значения совпадают, так что это палиндром, т. е. возвращаем true
      return true;
    }
  }
}

/*
Алгоритм использует два указателя ( slowи fast) для поиска середины связанного списка.
Указатель fastперемещается на два шага за каждый шаг slow. Этот цикл будет выполняться во O(n/2)времени,
которое O(n)определяет nколичество узлов в списке.

Найдя середину списка, код переворачивает вторую половину связанного списка.
Это еще один цикл, который выполняется от середины до конца списка, что также O(n/2)упрощается до O(n).

Наконец, код сравнивает значения узлов с начала списка и начала перевернутой второй половины.
Это сравнение прекращается, когда достигается конец перевернутой половины, то есть не более n/2шагов, так O(n/2)или O(n).

Общая временная сложность представляет собой сумму этих шагов,
которые все линейны относительно длины связанного списка: O(n) + O(n) + O(n)или O(3n)просто O(n).
 */
