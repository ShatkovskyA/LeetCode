package com.vashajava.binarytreegeneral;

/**
 * Класс _104_Maximum_Depth_of_Binary_Tree_ - максимальная глубина бинарного дерева.
 *
 * @author Anton Shatkovskiy
 * @created 03.07.2024 г.
 */

/*
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: 3
Example 2:

Input: root = [1,null,2]
Output: 2

ПЕРЕВОД: 104. Максимальная глубина бинарного дерева.
Учитывая корень двоичного дерева, верните его максимальную глубину.

Максимальная глубина двоичного дерева - это количество узлов вдоль самого длинного пути от корневого узла до самого дальнего конечного узла.

Пример 1:

Ввод: root = [3,9,20,null,null,15,7]
Вывод: 3
Пример 2:

Ввод: root = [1,null,2]
Вывод: 2
 */
public class _104_Maximum_Depth_of_Binary_Tree_ {

  public static void main(String[] args) {

    // тут задаем входные данные и реализуем методы из класса
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right= new TreeNode(20);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(0);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    Solution104 solution104 = new Solution104();
    int maxDepth = solution104.maxDepth(root);
    System.out.println(maxDepth);

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

  // тут создаем внутренний класс
    public static class TreeNode {
      // тут значение узла
      // значение, которое содержится в узле
    int val;
    // тут ссылка на дочерний элемент справа
    TreeNode right;
    // тут ссылка на дочерний элемент слева
    TreeNode left;
    // традиционно три конструктора
    // пустой
    TreeNode() {}
    // для значения val
    // конструктор для создания узла с определенным значением
    // конструктор для создания узла с определенным значением и левыми/правыми дочерними элементами
    TreeNode(int val) {
      this.val = val;
    }
    // и общий для значения и ссылок на лево и право
    TreeNode(int val, TreeNode right, TreeNode left) {
      this.val = val;
      this.right = right;
      this.left = left;
    }
  }

  // используем стратегию-алгоритм, известную как поиск в глубину (DFS)
 static class Solution104 {

    // вычисляем максимальную глубину бинарного дерева
    public int maxDepth(TreeNode root) {
      // вводим условие корень(root) равен null, то глубина равна 0, return 0;
      if(root == null) {
        return 0;
      }
      // рекурсивно вычисляем глубину левого поддерева - опять же вызываем сами себя, т. к. это рекурсия
      int leftDepth = maxDepth(root.left);
      // рекурсивно вычисляем глубину правого поддерева - опять же вызываем сами себя, т. к. это рекурсия
      int rightDepth = maxDepth(root.right);

      // и теперь возвращаем лубину текущего узла равна большей из двух его дочерних глубин плюс единица,
      // опять же, исп. библиотечный метод класса Math,
      // где Math.max - это библиотечный метод поиска максимума из двух переменных
      return 1 + Math.max(leftDepth, rightDepth);
    }
  }
}

/*
Временная сложность: Временная сложность кода равна O(n), где n - количество узлов в дереве.
Это связано с тем, что алгоритм выполняет поиск в глубину, и он посещает каждый узел ровно один раз, чтобы определить максимальную глубину.
 */
