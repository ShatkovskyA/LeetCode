package com.vashajava.binarytreegeneral;

/**
 * _100_Same_Tree_.
 *
 * @author Anton Shatkovskiy
 * @created 10.07.2024 г.
 */

/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:

Input: p = [1,2,3], q = [1,2,3]
Output: true
Example 2:

Input: p = [1,2], q = [1,null,2]
Output: false
Example 3:

Input: p = [1,2,1], q = [1,1,2]
Output: false

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104

ПЕРЕВОД: 100. Одно и тоже дерево.
Учитывая корни двух бинарных деревьев p и q, напишите функцию, чтобы проверить, совпадают ли они.

Два бинарных дерева считаются одинаковыми, если они структурно идентичны, а вершины имеют одинаковое значение.

Пример 1:

Ввод: p = [1,2,3], q = [1,2,3]
Вывод: true
Пример 2:

Ввод: p = [1,2], q = [1,null,2]
Вывод: false
Пример 3:

Входные данные: p = [1,2,1], q = [1,1,2]
Выходные данные: false

Ограничения:

Число узлов в обоих деревьях находится в диапазоне [0, 100].
-104 <= Node.val <= 104
 */
public class _100_Same_Tree_ {

  public static void main(String[] args) {

    TreeNode p =  new TreeNode(1);
    p.left = new TreeNode(2);
    p.right = new TreeNode(3);

    TreeNode q =  new TreeNode(1);
    q.left = new TreeNode(2);
    q.right = new TreeNode(3);

    Solution100 solution100 = new Solution100();
    boolean isSameTree = solution100.isSameTree(p, q);
    System.out.println(isSameTree);

  }

  // внутренняя структура бинарного дерева
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
    TreeNode(int val, TreeNode left, TreeNode reight) {
      this.val = val;
      this.left = left;
      this.right = reight;
    }
  }

  /*
  Использует рекурсивный шаблон поиска в глубину (DFS) для одновременного исследования обоих деревьев.
  Алгоритм DFS многократно исследует ветвь как можно глубже,
  прежде чем вернуться назад. Этот подход реализуется путем рекурсивной проверки каждой пары узлов обоих деревьев.
   */
  static class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
      // начнем с корней обходить рекурсивно в глубин, итак, если оба дерева пусты, то они одинаковы,
      // т. е. берем p и q, где && - логический оператор И
      if(p == null && q == null) {
        return true;
      }
      // теперь, другой случай, а если одно из деревьев пусто или значения текущих узлов не совпадают,
      // то и деревья не совпадают
      if(p == null || q == null || p.val != q.val) {
        return false;
      }
      //  а теперь тут рекурсивно проверяем - совпадают ли левое поддерево обоих деревьев
      // и правое поддерево обоих деревьев одинаковы,
      // т. е. опять же вызываем метод сам в себе - рекурсия, с параметрами левого и правого узлов
      return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
  }
}
/*
Временная сложность данной isSameTreeфункции равна O(N)где N- количество узлов в меньшем из двух сравниваемых деревьев.
Это происходит потому, что функция вызывается рекурсивно на каждом узле дерева до тех пор,
пока она либо не обнаружит несоответствие, либо не проверит все пары соответствующих узлов.
 */