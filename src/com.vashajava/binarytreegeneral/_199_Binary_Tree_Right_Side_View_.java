package com.vashajava.binarytreegeneral;

import com.vashajava.additionalinternalstructures.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * _199_Binary_Tree_Right_Side_View_.
 *
 * @author Anton Shatkovskiy
 * @created 07.11.2024 г.
 */

/*
Given the root of a binary tree, imagine yourself standing on the right side of it,
return the values of the nodes you can see ordered from top to bottom.

Example 1:
Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]

Example 2:
Input: root = [1,null,3]
Output: [1,3]
Example 3:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100

ПЕРЕВОД: 199. Вид двоичного дерева справа.
Получив корень бинарного дерева, представьте, что вы стоите справа от него,
и верните значения узлов, которые вы видите упорядоченными сверху вниз.

Пример 1:
Ввод: root = [1,2,3,null,5,null,4]
Выходные данные: [1,3,4]

Пример 2:
Входные данные: root = [1,null,3]
Выходные данные: [1,3]
Пример 3:

Входные данные: root = []
Выходные данные: []

Ограничения:

Количество узлов в дереве находится в диапазоне [0, 100].
-100 <= Node.val <= 100

 */
public class _199_Binary_Tree_Right_Side_View_ {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(5);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(0);
    root.right.right = new TreeNode(4);

    Solution199 solution199 = new Solution199();
    List<Integer> rightSideView = solution199.rightSideView(root);
    System.out.println(rightSideView);
  }

//  public class TreeNode {
//    public int val;
//    public TreeNode left;
//    public TreeNode right;
//    TreeNode() { }
//    TreeNode(int val) {
//    this.val = val;
//    }
//    TreeNode(int val, TreeNode left, TreeNode right) {
//      this.val = val;
//      this.left = left;
//      this.right = right;
//    }
//  }

  static class Solution199 {

    // Собственно функция для получения списка целых чисел, представляющих вид двоичного дерева с правой стороны
    public List<Integer> rightSideView(TreeNode root) {
      // вводим переменную и инициализируем список ответов для сохранения вида справа
      List<Integer> rightResult = new ArrayList<>();
      // задаем первоначальное основное условие - этр возвращаем пустой список, если значение root равно null
      if(root == null) {
        return rightResult;
      }

      // создаем переменную и инициализируем удаление из очереди для выполнения обхода порядка уровней
      Deque<TreeNode> queue = new ArrayDeque<>();

      // добавляем корень в очередь в качестве начала обхода - это есть начальная точка
      // используем стандартный заводской метод для очередей, который позволяет добавлять в очередь элемент не выбрасывая исключений,
      // в случае, если это возможно
      queue.offer(root);

      // теперь выполняем обход по порядку уровней, чтобы захватить самый правый элемент на каждом уровне,
      // т. е. если очередь - не пуста - это условие, то
      while (!queue.isEmpty()) {
        // находим самый правый элемент текущего уровня и добавляем его в список ответов,
        // где peekLast() - это стандартный заводской метод очереди,
        // который исп. для извлечения и возврата последнего элемента, если ничего нет, то возвразается null
        rightResult.add(queue.peekLast().val);
        // затем выполняем итерацию по узлам на текущем уровне, соотв. начальная точка это queue.size(), должно быть больше нуля
        for(int n = queue.size(); n > 0; --n) {
          // опрашиваем узел из начала очереди,
          // где метод pull() - удаляет и возвращает элемент из очереди, не вызывая исключений, если очередь пуста - кидает null
          TreeNode node = queue.poll();
          // и если левый дочерний элемент существует, добавляем его в очередь
          if(node.left != null) {
            queue.offer(node.left);
          }
          // а если правый дочерний элемент существует, добавляем его в очередь
          if(node.right != null) {
            queue.offer(node.right);
          }
        }
      }
      // тут возврат списка, содержащий вид дерева справа
      return rightResult;
    }
  }

}
/*
Функция rightSideView выполняет обход бинарного дерева в порядке уровней с использованием очереди.
В худшем случае она посетит все узлы дерева один раз.
Следовательно, если в дереве N узлов, временная сложность равна: O(N)
 */
