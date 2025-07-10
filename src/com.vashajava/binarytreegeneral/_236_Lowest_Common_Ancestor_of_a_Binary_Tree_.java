package com.vashajava.binarytreegeneral;


import com.vashajava.additionalinternalstructures.TreeNode;

/**
 * Класс _236_Lowest_Common_Ancestor_of_a_Binary_Tree_ - наименьший общий предок бинарного дерева.
 *
 * @author Anton Shatkovskiy
 * @created 08.10.2024 г.
 */

/*
Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p
and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Output: 3
Explanation: The LCA of nodes 5 and 1 is 3.
Example 2:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Output: 5
Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [1,2], p = 1, q = 2
Output: 1

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the tree.

ПЕРЕВОД: 236. Наименьший общий предок бинарного дерева.
Учитывая бинарное дерево, найдите наименьшего общего предка (LCA) из двух заданных узлов в дереве.

Согласно определению LCA в Википедии: “Наименьший общий предок определяется между двумя узлами p
и q как наименьший узел в T, который имеет как p, так и q в качестве потомков (где мы разрешаем узлу быть потомком самого себя)”.

Пример 1:

Входные данные: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
Выходные данные: 3
Пояснение: LCA узлов 5 и 1 равен 3.
Пример 2:

Входные данные: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
Выходные данные: 5
Пояснение: LCA узлов 5 и 4 равен 5, поскольку узел может быть потомком самого себя в соответствии с определением LCA.
Пример 3:

Входные данные: root = [1,2], p = 1, q = 2
Выходные данные: 1

Ограничения:

Число узлов в дереве находится в диапазоне [2, 105].
-109 <= Node.val <= 109
Все узлы.val уникальны.
p != q
в дереве будут существовать значения p и q.

 */
public class _236_Lowest_Common_Ancestor_of_a_Binary_Tree_ {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(5);
    root.left.left = new TreeNode(6);
//    root.left.left.left = new TreeNode(0);
//    root.left.left.right = new TreeNode(0);
    root.left.right = new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(8);

    // указываем существующие узлы дерева для p и q - по условию задачи
    // Узел с значением 5
    TreeNode p = root.left;
    // Узел с значением 1
    TreeNode q = root.right;

//    TreeNode p = new TreeNode(5);
//    TreeNode q = new TreeNode(1);

    Solution236 solution236 = new Solution236();
    TreeNode lowestCommonAncestor = solution236.lowestCommonAncestor(root, p, q);
    // тут применяем получение int-ового значения, которое содержится в узле из вспомогательного класса в качестве внутренней структуры бинарного дерева
    System.out.println(lowestCommonAncestor.val);

  }

  // для решения этой задачи применяем DFS (поиск в глубину)
  static class Solution236 {
    /**
     * Находит наименьшего общего предка двух узлов бинарного дерева. - рекурсивная функция
     * @param root - корневой узел бинарного дерева.
     * @param p - Первый узел, для которого нужно найти предка.
     * @param q - Второй узел, для которого нужно найти предка.
     * @return наименьший общий предковый узел или значение null, если он не найден.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      // задаем базовое условие выполнения - если значение root равно null или root равно p или q, то root - это lowest common ancestor - LCA
      // то и возвращаем соответсвенно root
      if(root == null || root == p || root == q) {
        return root;
      }
      // идем дальше - выполняем рекурсию по левому поддереву, чтобы найти LCA из p и q
      TreeNode left = lowestCommonAncestor(root.left, p, q);
      // анлогично - выполняем рекурсию по правому поддереву, чтобы найти LCA из p и q
      TreeNode right = lowestCommonAncestor(root.right, p, q);

      // и если поиск LCA в левом поддереве возвращает значение null, то LCA находится в правом поддереве
      if(left == null) {
        return right;
      }

      // налогично если поиск LCA в правом поддереве возвращает значение null, то LCA находится в левом поддереве
      if (right == null) {
        return left;
      }
      // в результате, если и left, и right не равны нулю, мы нашли LCA в корне - т. е. возвращаем root
      return root;
    }
  }
}
/*
Временная сложность данного кода для поиска наименьшего общего предка (lowest common ancestor - LCA) в двоичном дереве равна O(N),
где N - количество узлов в дереве.
Эта сложность возникает из-за того, что в наихудшем сценарии коду придется посетить каждый узел по одному разу, чтобы определить LCA.
 */
