package com.vashajava.binarytreegeneral;

import com.vashajava.additionalinternalstructures.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Класс _102_Binary_Tree_Level_Order_Traversal_ - обход порядка на уровне бинарного дерева.
 *
 * @author Anton Shatkovskiy
 * @created 04.09.2024 г.
 */

/*
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

Example 1:

Input: root = [3,9,20,null,null,15,7]
Output: [[3],[9,20],[15,7]]
Example 2:

Input: root = [1]
Output: [[1]]
Example 3:

Input: root = []
Output: []

Constraints:

The number of nodes in the tree is in the range [0, 2000].
-1000 <= Node.val <= 1000

ПЕРЕВОД: 102. Обход порядка на уровне бинарного дерева.
Учитывая корень двоичного дерева, возвращаем порядок прохождения значений его узлов по уровням. (т.е. слева направо,
уровень за уровнем, снизу вниз).

Пример 1:

Ввод: root = [3,9,20,null,null,15,7]
Вывод: [[3],[9,20],[15,7]]
Пример 2:

Ввод: root = [1]
Вывод: [[1]]
Пример 3:

Ввод: root = []
Вывод: []

Ограничения:

Количество узлов в дереве находится в диапазоне [0, 2000].
-1000 <= Node.val <= 1000

 */
public class _102_Binary_Tree_Level_Order_Traversal_ {

  public static void main(String[] args) {

    // вводим переменные бинарного дерева
    TreeNode root = new TreeNode(3);
    root.left = new TreeNode(9);
    root.right = new TreeNode(20);
    root.left.left = new TreeNode(0);
    root.left.right = new TreeNode(0);
    root.right.left = new TreeNode(15);
    root.right.right = new TreeNode(7);

    Solution102 solution102 = new Solution102();
    List<List<Integer>> levelOrder =  solution102.levelOrder(root);
    System.out.println(levelOrder);

  }

//  // класстчнеская структура узлов бинарного дерева для внутреннего использования,
//  // но мы применим уже готовую из пакета com.vashajava.additionalinternalstructures
//  public static class TreeNode {
//    // переменные
//    // значения узлов
//    int val;
//    // ссылки на узлы
//    TreeNode left;
//    TreeNode right;
//    // конструкторы
//    // пустой
//    public TreeNode() {    }
//    // для значений
//    public TreeNode(int val) {
//      this.val = val;
//         }
//    // общий
//    public TreeNode(int val, TreeNode left, TreeNode right) {
//      this.val = val;
//      this.left = left;
//      this.right = right;
//    }
//  }

  // используем алгоритм, известный как поиск в ширину (BFS).
  // BFS - это метод обхода, который исследует соседние узлы перед переходом на следующий уровень.
  // Эта характеристика BFS делает его идеально подходящим для обхода порядка уровней.
  static class Solution102 {

    // Србственно говоря сам метод для выполнения обхода бинарного дерева по уровням
    public List<List<Integer>> levelOrder(TreeNode root) {
      // 1. ИНИЦИАЛИЗАЦИЯ
      // создаем список для хранения результата, его же и будем возвращать
      List<List<Integer>> result = new ArrayList<>();
      // тут проверка дополнительная - возвращаем пустой список, если дерево пусто
      if(root == null) {
        return result;
      }

      // 2. НАСТРОЙКА ДВУСТРОННЕЙ ОЧЕРЕДИ
      // создаем двустороннюю очередь для хранения узлов на каждом уровне
      Deque<TreeNode> queue  = new ArrayDeque<>();
      // ачинаем обход порядка уровней с самого начала,
      // где offer(ee) - метод интерфейса Queue, вставляет указанный элемент в эту очередь,
      // если это возможно сделать немедленно, не нарушая ограничений по емкости.
      // Этот метод предпочтительнее метода add(), поскольку этот метод не генерирует исключение,
      // когда емкость контейнера заполнена, поскольку он возвращает значение false.
      queue.offer(root);

      // 3. НАСТРОЙКА ЦИКЛА ОБХОДА WHILE
      // пока есть узлы для обработки, а узлы у нас в очереди, применяем библиотечный метод провекри на пустоту - isEmpty()
      while (!queue.isEmpty()) {
        // создаем временный список для хранения значений узлов на текущем уровне
        List<Integer> level = new ArrayList<>();

        // 4. ОБРАБОТКА УРОВНЕЙ ДЕРЕВА В ШИРИНУ
        // брабатываем все узлы на текущем уровне
        // где size() - это "заводской" библиотечный метод, возвращает количество элементов в очереди
        int levellength = queue.size();
        for (int i = 0; i < levellength; ++i) {
          // извлекаем и удаляем начало очереди опять же используя "заводской" библиотечный метод удаления элементов poll()
          TreeNode currentNode = queue.poll();
          // и тут далее добавляем значение узла во временный список,
          // где val - это int-ое значение, которое содержится в узле, из класса структуры
          level.add(currentNode.val);
          // и если оставшийся дочерний элемент существует, добавляем его в очередь на следующий уровень
          // это для левого узла + метод добавления тот же offer()
          if(currentNode.left != null) {
            queue.offer(currentNode.left);
          }
          // а это для правого,
          // если нужный дочерний элемент существует, добавьте его в очередь для перехода на следующий уровень,
          // то же самое
          if(currentNode.right != null) {
            queue.offer(currentNode.right);
          }
        }
        // 5. ДОБАВЛЕНИЕ К РЕЗУЛЬТАТУ
        // теперь доабвляем временный список в список результатов
       result.add(level);

      }
      // 6. ЗАВЕРШЕНИЕ
      // и возвращаем список уровней
      return result;
    }
  }
}

/*
Временная сложность этого алгоритма равна O(n), где n - общее количество узлов в двоичном дереве.
Это связано с тем, что каждый узел в дереве посещается ровно один раз во время обхода.
 */
