package linkedList;

/**
 * _876_Middle_of_the_Linked_List_.
 *
 * @author Anton Shatkovskiy
 * @created 28.06.2024 г.
 */

/*
Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

Example 1:

Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.
Example 2:

Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.

Constraints:

The number of nodes in the list is in the range [1, 100].
1 <= Node.val <= 100

ПЕРЕВОД: 876. Середина LinkedList.
Учитывая начало односвязного списка, верните средний узел связанного списка.

Если есть два средних узла, верните второй средний узел.

Пример 1:

Входные данные: head = [1,2,3,4,5]
Выходные данные: [3,4,5]
Пояснение: Средним узлом списка является узел 3.
Пример 2:

Входные данные: head = [1,2,3,4,5,6]
Выходные данные: [4,5,6]
Пояснение: Поскольку в списке есть два средних узла со значениями 3 и 4, мы возвращаем второй узел.

Ограничения:

Количество узлов в списке находится в диапазоне [1, 100].
1 <= Node.val <= 100
 */

  // используется алгоритм "черепаха и заяц"
  // временная сложность равна O(n), где n - количество узлов в списке
public class _876_Middle_of_the_Linked_List_ {
  public static void main(String[] args) {

    // входные данные
    ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

    Solution876 solution876 = new Solution876();
    ListNode middleNode = solution876.middleNode(head);
    System.out.println(linkedListToString(middleNode));
  }

  // выспомогательный метод для печати списка
  public static String linkedListToString(ListNode node) {
    // создали объект StringBuilder
    StringBuilder sb = new StringBuilder();
    // скобочку открыли
    // преобразовали переданный объект в строку и добавили к текущей строке
    sb.append("[");
    // цикл, если нода не равна null
    while (node != null) {
      // фабричный метод append, класса StringBuilder -
      // преобразовывает переданный объект в строку и добавляет к текущей строке
      sb.append(node.val);
      // а если и следующий элемент не равен null, то запаятая
      if(node.next != null) {
        sb.append(", ");
      }
      node = node.next;
    }
    // скобочку закрыли
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

  // тут создаем внутренний класс
    private static class ListNode {
      // значение узла
    int val;
    // ссылка на следующий узел
    // ссылка на следующий узел, значение null для последнего узла
    ListNode next;
    // тут - кучка конструкторов
    // пустой контсруктор
    ListNode() {}
    // констурктор со значением
      ListNode(int val) {
      this.val = val;
    }
    // и констурктор со значением и ссылкой
    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }

  static class Solution876 {
    /**
     * Находит средний узел односвязного списка.
     *
     * @param head - начало связанного списка.
     * @return средний узел связанного списка.
     */
    public ListNode middleNode(ListNode head) {
      // водим в дело и инициализируем два указателя, медленный и быстрый
      // т. к. они внутри стурктуры, то это не int!
      // быстрый - на два шага вперед
      ListNode fastPointer = head;
      // а это медленный - на один шаг вперед
      ListNode slowPointer = head;

      // далее подключаем цикл - while, т. к. нам необходимо пробегаться
      // выполняем итерацию по списку, где
      // быстрый указатель перемещается на два шага за раз, медленный - на один шаг за раз
      // т. е. пока быстрый указатель не равен нулю и следующий быстрый указатель не равен нулю, то
      while (fastPointer != null && fastPointer.next != null) {
        // перемещаем медленный указатель на один шаг
        slowPointer = slowPointer.next;
        //  тут перемещаем быстрый указатель на два шага
        fastPointer = fastPointer.next.next;
      }

        // и тут основное условие, когда быстрый указатель достигнет конца списка,
        // медленный указатель окажется в среднем элементе
        return slowPointer;
      }
    }
  }

/*
Временная сложность данного кода равна O(n), где n - количество узлов в связанном списке.
Это происходит потому, что быстрый указатель перемещается на два шага за раз, а медленный указатель перемещается на один шаг за раз.
Они начинаются с одной и той же точки, поэтому, когда быстрый указатель достигает конца списка, медленный указатель должен быть в середине.
Поскольку быстрый указатель проходит не более чем через n узлы (где n четно) или n-1 узлы (где n нечетно),
и для перемещения быстрого указателя на два узла вперед требуется две итерации цикла, цикл выполняется приблизительно n/2 итерации,
что линейно по отношению к количеству узлов.
 */
