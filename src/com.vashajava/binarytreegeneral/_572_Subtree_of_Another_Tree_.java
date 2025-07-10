package com.vashajava.binarytreegeneral;

import com.vashajava.additionalinternalstructures.TreeNode;
import java.sql.SQLOutput;

/**
 * Класс _572_Subtree_of_Another_Tree_ - поддерево из дерева другого дерева.
 *
 * @author Anton Shatkovskiy
 * @created 24.07.2024 г.
 */

/*
Given the roots of two binary trees root and subRoot,
return true if there is a subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
The tree tree could also be considered as a subtree of itself.

Example 1:

Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
Example 2:

Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104

ПЕРЕВОД: 572. Поддерево из дерева другого дерева.
Учитывая корни двух бинарных деревьев root и subRoot,
верните значение true, если существует поддерево root с такой же структурой и значениями узлов subRoot, и значение false в противном случае.

Поддерево бинарного дерева - это дерево, состоящее из узла в дереве и всех потомков этого узла.
Дерево также может рассматриваться как поддерево само по себе.

Пример 1:

Входные данные: root = [3,4,5,1,2], subRoot = [4,1,2]
Выходные данные: true
Пример 2:

Ввод: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Вывод: false

Ограничения:

Число узлов в корневом дереве находится в диапазоне [1, 2000].
Число узлов в подкорневом дереве находится в диапазоне [1, 1000].
-104 <= root.val <= 104
-104 <= Подкорневой файл.val <= 104

 */
public class _572_Subtree_of_Another_Tree_ {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(4);
    root.right = new TreeNode(5);
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(2);

    TreeNode subRoot = new TreeNode(4);
    subRoot.left = new TreeNode(1);
    subRoot.right = new TreeNode(2);

    Solution572 solution572 = new Solution572();
    Boolean isSubtree = solution572.isSubtree(root, subRoot);
    System.out.println(isSubtree);

  }

  // Реализация предоставленного решения применяет использования поиска в глубину (DFS).

  static class Solution572 {
    /**
     * Определяет, есть ли в бинарном дереве поддерево, соответствующее данному поддереву.
     *
     * @param root - корневой узел главного дерева.
     * @param subRoot - корневой узел поддерева, которое мы ищем в главном дереве.
     * @return логическое значение, указывающее, присутствует ли поддерево в главном дереве.
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
      // задаем основное условие - если значение основного дерева равно null,
      // то подкорневой элемент не может быть поддеревом
      if(root == null) {
        return false;
      }
      // теперь возвращаем с проверками (еще одни доп. слелующие проверки),
      // совпадает ли корневое дерево в этом узле с подкорневым
      // или является ли подкорневое дерево поддеревом левого или правого дочернего элемента - с рекурсивным вызовом метода!!!!
      return isIdentical(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    /**
     * Вспомогательный метод для рекурсии, позволяющий определить, идентичны ли два бинарных дерева.
     *
     * @param root1 - корневой узел первого дерева.
     * @param root2 - корневой узел второго дерева.
     * @return логическое значение, указывающее, идентичны деревья или нет.
     */
    private boolean isIdentical(TreeNode root1, TreeNode root2) {
      // опять базовое условия на пустоту - если оба дерева пусты, то они идентичны
      if(root1 == null && root2 == null) {
        return true;
      }
      // а теперь тут следующие условия - если оба значения не равны null, то возвращаем -
      // сравните их значения и проверьте их левое и правое поддеревья
      if(root1 != null && root2 !=null) {
        return root1.val == root2.val && isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
      }
      // м в итоге - если одно из них равно null, а другое - нет, то они не идентичны
      return false;
    }
  }
}

/*
Временная сложность данного кода составляет O(m*n), где m - количество узлов в root дереве и n - количество узлов в subRoot дереве.
Для каждого узла root мы выполняем сравнение поиска в глубину (DFS) с subRoot, которое выполняется O(n) для каждого вызова.
Поскольку DFS может вызываться для каждого узла в root, это приводит к O(m*n) в худшем случае.
 */
