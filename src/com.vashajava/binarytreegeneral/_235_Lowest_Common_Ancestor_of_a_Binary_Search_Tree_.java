package com.vashajava.binarytreegeneral;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Класс _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree_ - наименьший общий предок для дерева бинарного поиска.
 *
 * @author Anton Shatkovskiy
 * @created 17.06.2024 г.
 */

/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.

According to the definition of LCA on Wikipedia:
“The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
(where we allow a node to be a descendant of itself).”

Example 1:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
Example 2:

Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
Example 3:

Input: root = [2,1], p = 2, q = 1
Output: 2

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.

ПЕРЕВОД: 235. Наименьший общий предок для дерева бинарного поиска.
Дано двоичное дерево поиска (по британскому летнему времени), найти наименьший общий предок (ДМС) узел из двух заданных узлов по британскому летнему времени.

В соответствии с определением ДМС на Википедии:
“Наименьший общий предок определяется между двумя узлами p и q как наименьший узел в T, который имеет как p, так и q в качестве потомков
(где мы разрешаем узлу быть потомком самого себя).”

Пример 1:

Входные данные: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Выходные данные: 6
Пояснение: LCA узлов 2 и 8 равен 6.
Пример 2:

Входные данные: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Выходные данные: 2
Пояснение: LCA узлов 2 и 4 равен 2, поскольку узел может быть потомком самого себя в соответствии с определением LCA.
Пример 3:

Входные данные: root = [2,1], p = 2, q = 1
Выходные данные: 2

Ограничения:

Число узлов в дереве находится в диапазоне [2, 105].
-109 <= Node.val <= 109
Все узлы.val уникальны.
p != q
p и q будут существовать в ЛУЧШЕМ случае.
 */
public class _235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree_ {

  public static void main(String[] args) {

    TreeNode p = new TreeNode(2);
    TreeNode q = new TreeNode(8);

    TreeNode root = new TreeNode(6);
    root.left = new TreeNode(2);
    root.right = new TreeNode(8);

    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(4);
    root.left.right.left = new TreeNode(3);
    root.left.right.right = new TreeNode(5);

    root.right.left = new TreeNode(7);
    root.right.right = new TreeNode(9);

    Solution235 solution235 = new Solution235();
    TreeNode lowestCommonAncestor = solution235.lowestCommonAncestor(root, p, q);
     System.out.println(lowestCommonAncestor.val);

//    // это позволит вывести ответ в необходимом виде [4,7,2,9,6,3,1]
//    List<Integer> result = new ArrayList<>();
//    Queue<TreeNode> queue = new LinkedList<>();
//    // добавляем
//    queue.add(lowestCommonAncestor);
//
//    // цикл вайл проверяет на пустоту
//    while (!queue.isEmpty()) {
//      // если очередь не пуста, то создаем объект дерева
//     TreeNode current = queue.poll();
//      // результат вносим
//      result.add(current.val);
//      // если левый узел не равен нулю
//      if(current.left != null) {
//        // то включаем в очередь
//        queue.add(current.left);
//      }
//      // если правый не равен нулю
//      if(current.right != null) {
//        queue.add(current.right);
//      }
//    }
//    System.out.println(result);
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

    //    // конструктор по дефолту, или же
//    // конструктор для создания конечного узла
//    TreeNode() {
//    }
    // прочие конструкторы
    // конструктор для создания узла с определенным значением
    // конструктор для создания нового узла с заданным значением
    TreeNode(int value) {
      val = value;
    }
//    // прочие конструкторы
//    // конструктор для создания узла с определенным значением и левыми/правыми дочерними элементами
//    TreeNode(int val, TreeNode left, TreeNode right) {
//      this.val = val;
//      this.left = left;
//      this.right = right;
//    }
  }

  static class Solution235 {

    // Функция для поиска наименьшего общего предка двух узлов в дереве бинарного поиска
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      // проходим по дереву сразу, исп. цикл while, начиная с корня - root
      while (root != null) {
        // если оба узла больше текущего, выполняем поиск в правом поддереве,
        // исп библиотечную функцию math.min() — это библиотечная функция в Java, которая возвращает минимальное значение двух чисел
        if (root.val < Math.min(p.val, q.val)) {
          // перемщаемся к нужному(правому) дочернему элементу
          root = root.right;
        }
        // сли же оба узла меньше текущего, выполните поиск в левом поддереве (см. св-ва дерева)
        // исп библиотечную функцию math.max() — это библиотечная функция в Java, которая возвращает аксимальное значение двух чисел
        else if (root.val > Math.max(p.val, q.val)) {
          // перемщаемся к нужному(левому) дочернему элементу
          root = root.left;
        }
        // тут находим узел с наименьшим общим предком
        else {
          return root;
        }
      }
      // тут случай, если цикл while завершается без возврата (при правильном использовании этого не должно быть), возвращает значение null
      return null;
    }
  }
}
