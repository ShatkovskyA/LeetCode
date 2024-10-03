package com.vashajava.binarytreegeneral;

import com.vashajava.additionalinternalstructures.TreeNode;

/**
 * _98_Validate_Binary_Search_Tree_.
 *
 * @author Anton Shatkovskiy
 * @created 24.09.2024 г.
 */

/*
Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

Example 1:

Input: root = [2,1,3]
Output: true
Example 2:

Input: root = [5,1,4,null,null,3,6]
Output: false
Explanation: The root node's value is 5 but its right child's value is 4.

Constraints:

The number of nodes in the tree is in the range [1, 104].
-231 <= Node.val <= 231 - 1

ПЕРЕВОД: 98. Проверка бинарного поиска дерева.
Учитывая корень бинарного дерева определить, является ли он действительным двоичным деревом поиска (BST).

Действительный по британскому летнему времени определяется следующим образом:

Левое поддерево узла содержит только узлы с ключами меньше, чем ключ узла.
Правое поддерево узла содержит только узлы с ключами, превышающими ключ узла.
Как левое, так и правое поддеревья также должны быть бинарными деревьями поиска.

Пример 1:

Входные данные: root = [2,1,3]
Выходные данные: true
Пример 2:

Ввод: root = [5,1,4,null,null,3,6]
Вывод: false
Пояснение: Значение корневого узла равно 5, а значение его правого дочернего узла равно 4.

Ограничения:

Количество узлов в дереве находится в диапазоне [1, 104].
-231 <= Node.val <= 231 - 1
 */
public class _98_Validate_Binary_Search_Tree_ {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(2);
    root.left = new TreeNode(1);
    root.right = new TreeNode(3);

    Solution98 solution98 = new Solution98();
    boolean isValidBST = solution98.isValidBST(root);
    System.out.println(isValidBST);

  }

  // Использование шаблона DFS подходит для этой задачи,
  // потому что это позволяет нам эффективно сравнивать каждый узел с пределами его поддерева,
  // эффективно проверяя свойство BST по мере прохождения по дереву в глубину.
  /**
   * Этот класс содержит метод, чтобы проверить, если двоичное дерево-это двоичное дерево поиска (BST).
   */
  static class Solution98 {
    // создаем и инициализируем переменную для хранения значения ранее посещенного узла
    private Integer previousValue;

    /**
     * метод проверяет, является ли данное двоичное дерево является допустимым двоичным деревом поиска (BST)
     *
     * @param root это корень двоичного дерева, чтобы проверить.
     * @return true, если данный дерево по британскому летнему времени, и false в противном случае.
     */
    public boolean isValidBST(TreeNode root) {
      // инициализируем предыдущее значение, переменной previousValue, которая была создана ранее, как null перед началом обхода
      previousValue = null;
      // а вот тут вводим рекурсивный метод с аргументом root, который и будет определять соотв. ли бинарное дерево условиям бинарного дерева
      return inOrderTraversal(root);
    }
    /**
     * Рекурсивный метод:
     * Осуществляет в порядке глубину обхода (DFS) бинарных деревьев для проверки BST.
     * Это гарантирует, что значение каждого узла больше, чем значения всех узлов в левом поддереве
     * и меньше значений всех узлов в правом поддереве.
     *
     * @param node узлов текущего узла, который посещают в обход.
     * @return true, если поддерево с корнем в "узел" удовлетворяет BST свойства, и false в противном случае.
     */
    private boolean inOrderTraversal(TreeNode node) {
      // необходимое условие: пустое дерево является допустимым BST,
      // т. е. если узел - node равен нулю, то true, т. к. указывает на достижение конца пути
      if(node == null) {
        return true;
      }
      // начинаем с обхода левого поддерева,
      // если это не BST, то возвращаем false - т. е. опять вызовом рекурсивного метода получаем значение левого узла
      if (!inOrderTraversal(node.left)) {
        return false;
      }
      // сверяем текущее значение узла со значением предыдущего узла, т. е. не должно быть равно нулю и больше или равно значения узла
      // и далее поскольку это обход по порядку, предыдущее значение должно быть меньше значения текущего узла
      if(previousValue != null && previousValue >= node.val) {
        // свойства BST нарушены
        return false;
      }
      // обновляем далее значение текущего узла previousValue
      previousValue = node.val;
      // и также обходим теперь правое поддерево,
      // и если это не BST, то возвращаем false - все то же самое, что и с левым узлом дерева
      if (!inOrderTraversal(node.right)) {
        return false;
      }
      // все проверки пройдены, это действительный соответствует BST
      return true;
    }
  }
}

/*
Временная сложность этого алгоритма составляет O(n), где n - количество узлов в бинарном дереве.
Это связано с тем, что DFS посещает каждый узел ровно один раз, чтобы сравнить его значение со значением ранее посещенного узла.
 */
