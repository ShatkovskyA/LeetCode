package binarytreegeneral;

/**
 * _543_Diameter_of_Binary_Tree_.
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

public class _543_Diameter_of_Binary_Tree_ {

  public static void main(String[] args) {

    TreeNode root = {1, 2, 3, 4, 5};

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
  class Solution {
    public int diameterOfBinaryTree(TreeNode root) {

      return 0;

    }
  }

}
