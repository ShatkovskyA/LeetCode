package com.vashajava.binarytreegeneral;

/**
 * _101_Symmetric_Tree_.
 *
 * @author Anton Shatkovskiy
 * @created 16.07.2024 г.
 */

/*
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

Example 1:

Input: root = [1,2,2,3,4,4,3]
Output: true
Example 2:

Input: root = [1,2,2,null,3,null,3]
Output: false

Constraints:

The number of nodes in the tree is in the range [1, 1000].
-100 <= Node.val <= 100

Follow up: Could you solve it both recursively and iteratively?

ПЕРЕВОД: 101. Симметричное дерево.
Учитывая корень бинарного дерева, проверьте, является ли он зеркальным отражением самого себя (т.е. симметричным относительно своего центра).

Пример 1:

Входные данные: root = [1,2,2,3,4,4,3]
Выходные данные: true
Пример 2:

Ввод: root = [1,2,2,null,3,null,3]
Вывод: false

Ограничения:

Количество узлов в дереве находится в диапазоне [1, 1000].
-100 <= Node.val <= 100

Продолжение: Не могли бы вы решить эту проблему как рекурсивно, так и итеративно?
 */
public class _101_Symmetric_Tree_ {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(4);
    root.right.right = new TreeNode(3);
    root.right.left = new TreeNode(4);

    Solution101 solution101 = new Solution101();
    Boolean isSymmetric = solution101.isSymmetric(root);
    System.out.println(isSymmetric);
  }

  // вводим дополнитльный внутренний класс
  // который определяет узел дерева
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
 Используем подход поиска в глубину (DFS).
 Решение включает в себя рекурсивное сравнение левого поддерева с правым поддеревом, чтобы убедиться, что они являются зеркалами друг друга.
  */
  static class Solution101 {
    /**
     * Определяет, симметрично ли бинарное дерево относительно своего центра (зеркально отображено).
     *
     * @param root - корень дерева.
     * @return значение true, если дерево симметрично, и значение false в противном случае.
     */
    public boolean isSymmetric(TreeNode root) {
      // тут запускаем вспомогательный метод DFS (см. ниже) из корневого каталога для обоих поддеревьев для сравнения
      return isMirror(root, root);
    }

   /**
    * Вспомогательный метод для выполнения DFS-проверки симметрии путем сравнения узлов,
    * в методе прорабатыва.тся все условия обхода и сравнения дерева
    *
    * @param node1 - Текущий узел из первого поддерева.
    * @param node2 - текущий узел из второго поддерева.
    * @return значение true, если два поддерева являются зеркальными отображениями друг друга, в противном случае значение false.
    */
   private boolean isMirror(TreeNode root, TreeNode root1) {
     // нечнем сначала - если оба узла равны нулю, то это означает, что эта ветвь симметрична
     if (root == null && root1 == null) {
       return true;
     }
     // следующее условие - если только один из узлов равен null или их значения различаются,
     // то дерево не может быть симметричным
     if(root == null || root1 == null || root1.val != root.val) {
       return false;
     }
     // и продолжаем сравнивать левое поддерево узла 1 с правым поддеревом узла 2
     // и правое поддерево узла 1 с левым поддеревом узла 2. Оба сравнения
     // должны быть верными, чтобы поддерево было симметричным, т. е. вызываем опять сами себе функцию рекурсивно
     return isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
   }
 }
}

/*
Временная сложность предоставленного кода равна O(n), где n– количество узлов в двоичном дереве.
Это связано с тем, что в случае идеально симметричного дерева рекурсивная функция dfsпосещает каждый узел ровно один раз,
проверяя симметрию левого и правого поддерева.
 */
