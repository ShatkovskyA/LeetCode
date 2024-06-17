package binarytreegeneral;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * _226_Invert_Binary_Tree_.
 *
 * @author Anton Shatkovskiy
 * @created 06.06.2024 г.
 */

/*
Given the root of a binary tree, invert the tree, and return its root.

Example 1:

Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:

Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

ПЕРЕВОД: 226. Обратно двоичные дерево.
Учитывая корень бинарного дерева, вставьте три и верните его корни.

Пример 1:

Входные данные: root = [4,2,7,1,3,6,9]
Выходные данные: [4,7,2,9,6,3,1]
Пример 2:

Ввод: root = [2,1,3]
Вывод: [2,3,1]
Пример 3:

Ввод: root = []
Вывод: []

Ограничения:

Количество узлов в дереве находится в диапазоне [0, 100].
-100 <= Node.val <= 100
 */
public class _226_Invert_Binary_Tree_ {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(4);
    root.left = new TreeNode(2);
    root.right = new TreeNode(7);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(9);

    Solution226 solution226 = new Solution226();
    TreeNode invertTree = solution226.invertTree(root);

    // это позволит вывести ответ в необходимом виде [4,7,2,9,6,3,1]
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    // добавляем
    queue.add(invertTree);

    // цикл вайл проверяет на пустоту
    while (!queue.isEmpty()) {
      // если очередь не пуста, то создаем объект дерева
      TreeNode current = queue.poll();
      // результат вносим
      result.add(current.val);
      // если левый узел не равен нулю
      if(current.left != null) {
        // то включаем в очередь
        queue.add(current.left);
      }
      // если правый не равен нулю
      if(current.right != null) {
        queue.add(current.right);
        }
    }
    System.out.println(result);
  }

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
    // конструктор для создания конечного узла
    TreeNode() {
    }
    // прочие конструкторы
    // конструктор для создания узла с определенным значением
    TreeNode(int val) {
      this.val = val;
    }
    // прочие конструкторы
    // конструктор для создания узла с определенным значением и левыми/правыми дочерними элементами
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
  // реализуем типичный обход дерева в глубину (DFS) начиная с корневого узла, подход рекурсивный
  // временная сложность O (n), где n - количество узлов в дереве, потому что каждый узел посещается один раз
  // класс решения, содержащий метод инвертирования двоичного дерева
  static class Solution226 {
    // инвертирует двоичное дерево и возвращает корень инвертированного дерева
    public TreeNode invertTree(TreeNode root) {
      // запускаем инверсию поиска в глубину с корневого узла
      depthFirstSearchInvert(root);
      // возвращает новый корень после инверсии
      return root;
      }
    // вспомогательный метод, который использует поиск в глубину (DFS) для рекурсивного инвертирования данного двоичного дерева
    public void depthFirstSearchInvert(TreeNode node) {
      // базовое условие: если текущий узел равен null, инвертировать нечего; немедленно возвращайте
      if(node == null) {
        return;
      }
      // тут меняем местами левый и правый дочерние элементы текущего узла
      TreeNode tempMode = node.left;
      node.left = node.right;
      node.right = tempMode;
      // рекурсивно инвертируем левое поддерево
      depthFirstSearchInvert(node.left);
      // рекурсивно инвертируем правое поддерево
      depthFirstSearchInvert(node.right);
    }
  }
}
