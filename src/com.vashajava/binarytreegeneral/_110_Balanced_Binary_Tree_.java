package binarytreegeneral;

import binarytreegeneral._226_Invert_Binary_Tree_.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * _110_Balanced_Binary_Tree_.
 *
 * @author Anton Shatkovskiy
 * @created 17.06.2024 г.
 */

/*
Given a binary tree, determine if it is
height-balanced.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: true
Example 2:

Input: root = [1,2,2,3,3,null,null,4,4]
Output: false
Example 3:

Input: root = []
Output: true

Constraints:

The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104

ПЕРЕВОД: 110. Сбалансированное бинарное дерево.
Для получения бинарного дерева определите, сбалансировано ли оно
по высоте.

Пример 1:

Входные данные: root = [3,9,20,null,null,15,7]
Выходные данные: true
Пример 2:

Ввод: root = [1,2,2,3,3,null,null,4,4]
Вывод: false
Пример 3:

Ввод: root = []
Вывод: true

Ограничения:

Число узлов в дереве находится в диапазоне [0, 5000].
-104 <= Node.val <= 104

 */
public class _110_Balanced_Binary_Tree_ {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(0);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    Solutio110 solutio110 = new Solutio110();
    boolean isBalance = solutio110.isBalanced(root);
    System.out.println(isBalance);

//    // это позволит вывести ответ в необходимом виде
//    List<Integer> result = new ArrayList<>();
//    Queue<TreeNode> queue = new LinkedList<>();
//
//    // добавляем
//    queue.add(search);
//
//    // проверяем на пустоту
//    while (!queue.isEmpty()) {
//      // если очередь не пуста, то создаем объект дерева
//      TreeNode current = new TreeNode();
//      // результат вносим - значение каррент
//      result.add(current.val);
//      // если левый узел не равен нулю
//      if (current.left != null) {
//        // то включаем в очередь
//        queue.add(current.left);
//      }
//      // если правый не равен нулю
//      if (current.right != null) {
//        queue.add(current.right);
//      }
//      System.out.println(result);
//    }

  }

  /**
   * Definition for a binary tree node.
   * public class TreeNode {
   *     int val;
   *     TreeNode left;
   *     TreeNode right;
   *     TreeNode() {}
   *     TreeNode(int val) { this.val = val; }
   *     TreeNode(int val, TreeNode left, TreeNode right) {
   *         this.val = val;
   *         this.left = left;
   *         this.right = right;
   *     }
   * }
   */
  /**
   * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode() {} TreeNode(int val) {
   * this.val = val; } TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left = left; this.right = right; } }
   */
  // Определение для узла бинарного дерева.
  public static class TreeNode {
    // значение, которое содержится в узле
    int val;
    // узел слева, или же
    // ссылка на дочерний элемент слева
    TreeNode left;
    // узел справа, или же
    // ссылка на дочерний элемент справа
    TreeNode right;
    // конструктор по дефолту, или же
    // конструктор для инициализации конечного узла
    TreeNode() {
    }
    // прочие конструкторы
    // конструктор для инициализации узла с определенным значением
    TreeNode(int val) {
      this.val = val;
    }
    // прочие конструкторы
    // конструктор для инициализации узла с определенным значением и левыми/правыми дочерними элементами
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  /*
  Временная сложность данной рекурсивной функции равна O(N),
  где N - количество узлов в дереве. Каждый узел в дереве посещается один раз,
  и вычисляется высота. Функция возвращает -1 немедленно, если обнаруживается, что поддерево несбалансировано,
  что устраняет необходимость в дальнейших вычислениях для этого поддерева.
  Проверка баланса (abs(l - r) > 1) проводится O(1) для каждого узла.
   */
  static class Solutio110 {

    /**
     * Определяет, сбалансировано ли двоичное дерево. В сбалансированном дереве высота двух поддеревьев любого узла никогда не отличается
     * более чем на единицу.
     *
     * @param root - корень двоичного дерева.
     * @return значение true, если дерево сбалансировано, и значение false в противном случае.
     */
    public boolean isBalanced(TreeNode root) {

      // тут задаем условие, с пом. метода - неотрицательная высота указывает на то, что дерево сбалансировано,
      // в то время как -1 означает дисбаланс
      return calculateHeight(root) >= 0;
    }

    /**
     * Метод для рекурсивного вычисления высоты бинарного дерева. Возвращает значение -1, если поддерево несбалансировано.
     *
     * @param node - узел, высота которого вычисляется.
     * @return высоту дерева, если оно сбалансировано, в противном случае -1.
     */
    private int calculateHeight(TreeNode node) {
      // определяем начальную точку, т. е. дерево без узлов имеет высоту 0
      if (node == null) {
        return 0;
      }
      // далее рекурсивно ищем высоту левого и правого поддеревьев
      int leftHeight = calculateHeight(node.left);
      int rightHeight = calculateHeight(node.right);

      // тут производим проверку, не разбалансировано ли левое или правое поддерево и не отличаются ли они по высоте более чем на 1
      // где библиотечная функция Math.abs() возвращает абсолютное значение аргумента (модуль числа)
      if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
        // возвращает признак того, что дерево не сбалансировано - -1
        return -1;
      }
      // вычисляем текущую высоту узла равной максимальной высоте левого и правого поддеревьев плюс 1 (для текущего узла)
      // где, math.max() — это библиотечная функция в Java, которая возвращает максимальное значение двух чисел
      return 1 + Math.max(leftHeight, rightHeight);
    }
  }
}

