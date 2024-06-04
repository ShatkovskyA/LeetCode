package linkedList;

/**
 * _21_Merge_Two_Sorted_Lists_.
 *
 * @author Anton Shatkovskiy
 * @created 30.05.2024 г.
 */

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list.
The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.

ПЕРЕВОД: 21. Объединить два отсортированных списка.
Вам даны заголовки двух отсортированных связанных списков list1 и list2.

Объедините два списка в один отсортированный список.
Список должен быть создан путем объединения узлов первых двух списков.

Верните заголовок объединенного связанного списка.

Пример 1:

Входные данные: список 1 = [1,2,4], список 2 = [1,3,4]
Выходные данные: [1,1,2,3,4,4]
Пример 2:

Входные данные: список 1 = [], список 2 = []
Выходные данные: []
Пример 3:

Входные данные: list1 = [], list2 = [0]
Выходные данные: [0]

Ограничения:

Количество узлов в обоих списках находится в диапазоне [0, 50].
-100 <= Node.val <= 100
Как list1, так и list2 отсортированы в порядке неубывания.

 */

// Временная сложность O (n),
// где n - общее количество узлов в обоих списках вместе взятых,
// потому что каждый узел посещается ровно один раз.
public class _21_Merge_Two_Sorted_Lists_ {

  public static void main(String[] args) {

//    int[] list1 = new int[]{1, 2, 4};
////    int[] list2 = {1, 3, 4};
////   int[] list2 = {1, 3, 4};
//    int[] list2 = new int[]{1, 3, 4};

//    ListNode list1 = new ListNode(1, 2, 4);
//    ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

    ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

    Solution21 solution21 = new Solution21();
    ListNode mergedList = solution21.mergeTwoLists(list1, list2);
    System.out.println(listToString(mergedList));

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

    int val;
    ListNode next;

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

  /**
   * Объедините два отсортированных связанных списка и верните его в виде нового отсортированного списка. Новый список должен быть создан
   * путем объединения узлов первых двух списков.
   *
   * @param list1 - Первый отсортированный связанный список.
   * @param list2 - второй отсортированный связанный список.
   * @return начало объединенного отсортированного связанного списка.
   */
  static class Solution21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
      // инициализируем фиктивный узел, который будет выступать в качестве главы объединенного списка
      ListNode dummyHead = new ListNode();
      // этот указатель будет использоваться для добавления новых элементов в объединенный список
      ListNode current = dummyHead;

      // пока в списках есть элементы, мы будет продолжать итеррацию,
      // исп. цикл while
      while (list1 != null && list2 != null) {
        // eсли значение list1 меньше или равно, добавьте его следующим
        // исп. библиотченые функции val и next из класса вверху ListNode
        if (list1.val <= list2.val) {
          current.next = list1;
          // переходим к следующему элементу в списке1
          list1 = list1.next;
        } else {
          // в противном случае, если значение list2 меньше, добавляем его следующим
          current.next = list2;
          list2 = list2.next;
        }
        // далее идем вперед по объединенному списку
        current = current.next;
      }
      // в случае, если в одном из списков остались элементы, привяжите их к концу - т. е. перебрасываем их в конец
      // исп. тернарный оператор
      current.next = (list1 == null) ? list2 : list1;

      // фиктивный заголовок.далее указывает на начало объединенного списка
      return dummyHead.next;

    }
  }
}
