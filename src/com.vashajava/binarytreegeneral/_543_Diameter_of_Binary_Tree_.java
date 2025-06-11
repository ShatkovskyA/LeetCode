package com.vashajava.binarytreegeneral;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Класс _543_Diameter_of_Binary_Tree_ - диаметр бинарного дерева.
 *
 * @author Anton Shatkovskiy
 * @created 28.06.2024 г.
 */

/*
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.

Example 1:

Input: root = [1,2,3,4,5]
Output: 3
Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
Example 2:

Input: root = [1,2]
Output: 1

Constraints:

The number of nodes in the tree is in the range [1, 104].
-100 <= Node.val <= 100

ПЕРЕВОД: 543. Диаметр бинарного дерева.
Учитывая корень двоичного дерева, верните значение длины, равное диаметру дерева.

Диаметр двоичного дерева - это длина самого длинного пути между любыми двумя вершинами дерева.
Этот путь может проходить, а может и не проходить через корень.

Длина пути между двумя узлами определяется количеством ребер между ними.

Пример 1:

Входные данные: root = [1,2,3,4,5]
Выходные данные: 3
Пояснение: 3 - это длина пути [4,2,1,3] или [5,2,1,3].
Пример 2:

Входные данные: root = [1,2]
Выходные данные: 1

Ограничения:

Количество узлов в дереве находится в диапазоне [1, 104].
-100 <= Node.val <= 100
 */

  // Общая сложность решения составляет O(N), где N - количество узлов в двоичном дереве, поскольку каждый узел посещается ровно один раз.
public class _543_Diameter_of_Binary_Tree_ {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);

    Solution543 solution543 = new Solution543();
    int diameterOfBinaryTree = solution543.diameterOfBinaryTree(root);
    System.out.println(diameterOfBinaryTree);

    // это позволит вывести ответ в необходимом виде
//    List<Integer> result = new ArrayList<>();
//    Queue<TreeNode> queue = new LinkedList<>();
    // добавляем
//    queue.add();

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

  // внутренний класс - Определение для узла бинарного дерева.
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
    TreeNode() {}
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
  /**
   * Этот класс содержит методы для определения диаметра бинарного дерева.
   */
  static class Solution543 {

    // вводим переменную для определения максимального диамтеры - одержит максимальный найденный диаметр
    private int maxDiametr;

    /**
     * Находит диаметр двоичного дерева, который является длиной самого длинного пути между любыми двумя узлами в дереве.
     * Этот путь может проходить, а может и не проходить через корень.
     *
     * @param root - корневой узел двоичного дерева
     * @return диаметр двоичного дерева
     */
    public int diameterOfBinaryTree(TreeNode root) {
      // инициализируем переменную максимального диаметра в этом методе
      maxDiametr = 0;
      // тут - вызов метода поиска в глубину (DFS) с передачей в качестве параметра корневего узла, реализация метода ниже
      depthFirstSearch(root);
      // возвращаем диаметр
      return maxDiametr;
    }

    /**
     * тут вот эта реализация метода и есть, пишем:
     * Рекурсивный метод, который вычисляет глубину дерева и обновляет максимальный диаметр.
     * Длина пути между узлами вычисляется как сумма высот левого и правого поддеревьев.
     *
     * @param node - текущий узел
     * @return максимальную высоту текущего узла.
     */
    private int depthFirstSearch(TreeNode node) {
      // итак, если нода равно null, то
      if(node == null) {
        // в базовом варианте: если текущий узел равен null, верните высоту, равную 0
        return 0;
      }
      // теперь, с помощью вызова рекурсии находим высоту левого и правого поддеревьев
      // т. е. рекурсия это вызов сам себе, что мы и делаем, вызываем сами себя и берем из class TreeNode - ссылки на дочерние элементы
      int leftHeight = depthFirstSearch(node.left);
      int rightHeight = depthFirstSearch(node.right);

      // тут обновляем максимальный диаметр, если сумма высот поддеревьев текущего узла больше
      // где Math.max - это библиотечный метод поиска максимума из двух переменных
      maxDiametr = Math.max(maxDiametr, leftHeight + rightHeight);

      // и теперь возвращаем максимальную высоту,
      // видимую до текущего узла, включая высоту текущего узла (которая равна 1)
      // где Math.max - это библиотечный метод поиска максимума из двух переменных
      return 1 + Math.max(leftHeight, rightHeight);
    }
  }
}

/*
Временная сложность diameterOfBinaryTree метода составляет O(n),
где n - количество узлов в двоичном дереве. Это связано с тем,
что вспомогательная функция dfs вызывается ровно один раз для каждого узла в дереве.
В dfs функции работа, выполняемая в каждом узле, выполняется за постоянное время,
в основном состоящее из вычисления максимальной левой и правой высоты и обновления ans переменной при необходимости.
 */
