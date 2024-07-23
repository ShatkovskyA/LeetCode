package com.vashajava.binarytreegeneral;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * _108_Convert_Sorted_Array_to_Binary_Search_Tree_.
 *
 * @author Anton Shatkovskiy
 * @created 22.07.2024 г.
 */

/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a
height-balanced binary search tree.

Example 1:

Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:

Input: nums = [1,3]
Output: [3,1]
Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in a strictly increasing order.

ПЕРЕВОД: 108. Преобразование отсортированного массива в двоичное дерево поиска.
Получив целочисленный массив nums, элементы которого отсортированы в порядке возрастания, преобразуйте его
в двоичное дерево поиска, сбалансированное по высоте.

Пример 1:

Входные данные: nums = [-10,-3,0,5,9]
Выходные данные: [0,-3,9,-10,null,5]
Также допускается объяснение: [0,-10,5,null,-3,null,9]:

Пример 2:

Входные данные: nums = [1,3]
Выход: [3,1]
Пояснения: [1,нуль,3] и [3,1] как высота сбалансированный по британскому летнему времени.

Ограничения:

1 <= число.длина <= 104
-104 <= nums[i] <= 104
числа сортируются в строго возрастающем порядке.
 */
public class _108_Convert_Sorted_Array_to_Binary_Search_Tree_ {

  public static void main(String[] args) {

    int[] nums = {-10, -3, 0, 5, 9};

//    TreeNode nums = new TreeNode(0);
//    nums.left = new TreeNode(-3);
//    nums.right = new TreeNode(9);
//    nums.left.left = new TreeNode(-10);
//    nums.right.left = new TreeNode(5);

    Solution108 solution108 = new Solution108();
    TreeNode sortedArrayToBST = solution108.sortedArrayToBST(nums);

    // это позволит вывести ответ в необходимом виде [4,7,2,9,6,3,1]
    List<Integer> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    // добавляем
    queue.add(sortedArrayToBST);

    // цикл вайл проверяет на пустоту
    while (!queue.isEmpty()) {
      // если очередь не пуста, то создаем объект дерева
    TreeNode current = queue.poll();
      // результат вносим
      result.add(current.val);
      // если левый узел не равен нулю
      if(current.left != null) {
        // то включаем в очередь
        queue.add(current.left);
      }
      // если правый не равен нулю
      if(current.right != null) {
        queue.add(current.right);
      }
    }
    System.out.println(result);
//    System.out.println(sortedArrayToBST);

  }

  // вводим дополнитльный внутренний класс
  // который определяет узел дерева
  static class TreeNode {

    // int-овое значение, которое содержится в узле
    int val;
    // ссылка на дочерний элемент слева,
    // по простому узел слева
    TreeNode left;
    // ссылка на дочерний элемент дерева справа,
    // по простому узел справа
    TreeNode right;

    // тут различные виды / типы конструкторов
    // пустой, дефолтный конструктор для инициализации конечного узла
    public TreeNode() {

    }

    // констурктор для инициализации значения узла дерева определенным занчением
    public TreeNode(int val) {
      this.val = val;
    }

    // констурктор для инициализации значения узла определенным значением,
    // а также ссылок на левыми/правыми дочерними элементами
    public TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  static class Solution108 {
    public int[] nums;
    /**
     * Преобразует отсортированный массив в двоичное дерево поиска, сбалансированное по высоте (BFS).
     *
     * @param nums отсортированный массив целых чисел
     * @return корень двоичного дерева поиска, сбалансированного по высоте
     */
    public TreeNode sortedArrayToBST(int[] nums) {
      this.nums = nums;
      return constructBSTRecursive(0, nums.length - 1);
    }

    /**
     * Рекурсивный вспомогательный метод для создания по британскому летнему времени из отсортированного массива.
     *
     * @param left начальный индекс подмассива
     * @param right конечный индекс подмассива
     * @return корень поддерева построены по британскому летнему времени из подмассива
     */
    private TreeNode constructBSTRecursive(int left, int right) {
      // базовое условие дерева: если слева > справа, подмассив пуст и должен возвращать значение null
      if(left > right) {
        return null;
      }
      // а тут далее находим средний элемент для поддержания свойств по британскому летнему времени,
      // используем левый + (вправо - влево) / 2`, чтобы избежать целочисленного переполнения
      int mid = left + (right - left) / 2;
      // применяем рекурсию, строя левое поддерево
      TreeNode leftSubtree = constructBSTRecursive(left, mid - 1);
      // применяем рекурсию, строя правое поддерево
      TreeNode rightSubtree = constructBSTRecursive(mid + 1, right);
      // затем создаем новый узел дерева со средним элементом и ранее созданными левым и правым поддеревьями
      TreeNode node = new TreeNode(nums[mid], leftSubtree, rightSubtree);
      return node;
    }
  }
}
/*
Временная сложность данного кода равна O(n), где n– количество элементов во входном списке nums.
Это связано с тем, что каждый элемент массива посещается ровно один раз
для построения каждого узла результирующего двоичного дерева поиска (BST).
 */
