package com.vashajava.binarytreegeneral;

import com.vashajava.additionalinternalstructures.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_.
 *
 * @author Anton Shatkovskiy
 * @created 04.12.2024 г.
 */

/*
Given two integer arrays preorder and inorder where preorder is the preorder traversal
of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.

Example 1:
Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
Output: [3,9,20,null,null,15,7]

Example 2:
Input: preorder = [-1], inorder = [-1]
Output: [-1]

Constraints:

1 <= preorder.length <= 3000
inorder.length == preorder.length
-3000 <= preorder[i], inorder[i] <= 3000
preorder and inorder consist of unique values.
Each value of inorder also appears in preorder.
preorder is guaranteed to be the preorder traversal of the tree.
inorder is guaranteed to be the inorder traversal of the tree.

ПЕРЕВОД: 105. Построение бинарного дерева на основе предварительного заказа и обхода по порядку.
Для двух целочисленных массивов preorder и inorder, где preorder - это обход
двоичного дерева по порядку, а in order - обход того же дерева по порядку, постройте и верните двоичное дерево.

Пример 1:
Ввод: предварительный заказ = [3,9,20,15,7], дополнительный заказ = [9,3,15,20,7]
Вывод: [3,9,20,null,null,15,7]

Пример 2:
Ввод: предварительный заказ = [-1], дополнительный заказ = [-1]
Вывод: [-1]

Ограничения:

1 <= предварительный заказ.длина <=
3000 в порядке.длина == предварительный заказ.длина
-3000 <= предварительный заказ[i], дополнительный заказ[i] <= 3000
предварительный заказ и дополнительный заказ состоят из уникальных значений.
Каждое значение параметра "дополнительный заказ" также отображается в предварительном заказе.
при предварительном заказе гарантированно выполняется обход дерева по предварительному заказу.
при предварительном заказе гарантированно выполняется обход дерева по предварительному заказу.
 */
public class _105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal_ {

  public static void main(String[] args) {

    int[] preorder = {3, 9, 20, 15, 7};
    int[] inorder = {9, 3, 15, 20, 7};

    Solution105 solution105 = new Solution105();
    TreeNode buildTree = solution105.buildTree(preorder, inorder);

    System.out.println(treeToArray(buildTree));

  }

  /*
  функционал из методов для преобразования и вывода в виде печати на консоль лерева в массмв
   */
  // метод для преобразования дерева в массив
  public static List<Integer> treeToArray(TreeNode root) {
    // вводим локальную переменную в виде листа для получения результата в конце
    List<Integer> result = new ArrayList<>();
    // тут базовый случай-проверка на null
    if (root == null) {
      return result;
    }

    // далее вводим новую переменную - используем очередь для обхода дерева в порядке уровней (BFS)
    Queue<TreeNode> queue = new LinkedList<>();
    // "заводской" библиотечный базовый метод для добавления элемента в очередь, начинаем с корня
    queue.offer(root);

    // цикл, если очередеь не пуста
    while (!queue.isEmpty()) {
      // poll() - "заводской" библиотечный базовый метод возвращает элемент из головы очереди
      TreeNode current = queue.poll();
      // если этот элемент не null
      if (current != null) {
        // то добавляесм в результат значение
        result.add(current.val);
        // тут добавляем головной элемент слева
        queue.offer(current.left);
        // тут добавляем головной элемент справа
        queue.offer(current.right);
      } else {
        // иначе добавляем null для отсутствующих узлов
        result.add(null);
      }
    }
    // затем все null в конце массива
    while (!result.isEmpty() && result.get(result.size() - 1) == null) {
      result.remove(result.size() - 1);
    }
    // возвращаем изначальный result
    return result;
  }

  static class Solution105 {
    // создаем массив для хранения предзаказа обхода дерева
    private int[] preorderTraversal;
    // и создаем структуру хранения в виде карты для хранения индексов значений при обходе по порядку
    private Map<Integer, Integer> inorderIndices = new HashMap<>();

    // Функция строит двоичное дерево с заданными массивами обхода предзаказа и непорядка
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      // локальная переменная количества узлов в дереве, собственно говоря с пом. вызова length
      int n = preorder.length;
      // тут создаем новую локальну перменную - присвоение массива обхода предварительного заказа переменной класса для глобального доступа в этом контексте,
      // через this как в конструкторе
      this.preorderTraversal = preorder;

      // теперь сопостовляем каждое значения из массива inorder с его индексом для быстрого поиска - используем цикл
      for(int i = 0; i < n; ++i) {
        // тут используем "заводской" фабричный метод put ля вставки новой пары «ключ — значение» в HashMap - т. е. создаем словарь
        // inorder[i], i - тут берем - первое, это значение, второе это индекс, и все это в цикле
        inorderIndices.put(inorder[i], i);
      }
      // и далее, путем вызова рекурсивной функции, которую пишем далее,
      // инициируем рекурсивный процесс построения дерева из всего диапазона заданных массивов
      return buildTreeRecursive(0, 0, n);
    }

    // А это уже сам, непосредственно рекурсивный метод построения бинарного дерева
    private TreeNode buildTreeRecursive(int prorderStart, int inorderStart, int size) {
      // начнем с базового случая: если нет элементов, которые нужно учитывать, верните значение null
      if(size <= 0) {
        return null;
      }
      // затем выборка текущего значения из массива предварительного заказа (корень поддерева)
      int rootValue = preorderTraversal[prorderStart];
      // далее получение индекса текущего корневого файла в массиве inorder
      int inorderRootIndex = inorderIndices.get(rootValue);
      // и затем вычисление количества узлов в левом поддереве
      int leftSubtreeSize = inorderRootIndex - inorderStart;

      // тут рекурсивно строим левого поддерева - исп. ранее созданную структурк
      TreeNode leftSubtree = buildTreeRecursive(prorderStart + 1, inorderStart, leftSubtreeSize);
      // тут рекурсивно строим правое поддерево - исп. ранее созданную структурк
      // необходимо затем перейти к левому поддереву в массиве предварительного заказа, следовательно, "preorderStart + 1 + leftSubtreeSize"
      TreeNode rightSubtree = buildTreeRecursive(prorderStart + 1 + leftSubtreeSize, inorderRootIndex + 1, size - 1 - leftSubtreeSize);

      // и в заключение создаем текущий корневоой узл с вычисленными левым и правым поддеревьями?
      // соотв. подставляем в изначальную структуру изначально созданные перменные - корень и левое и правое поддеревья
      return new TreeNode(rootValue, leftSubtree, rightSubtree);
    }
  }
}
/*
Временная сложность данной рекурсивной функции равна O (N), где N - количество узлов в дереве.
Поскольку каждый узел в дереве обрабатывается ровно один раз, основные операции включают:

- Выборка значения предварительного заказа: O (1) для каждого узла,
- Определение индекса по порядку из хэш-карты: O (1) для каждого узла.
Рекурсивный процесс продолжается до тех пор, пока не будут обработаны все узлы.
Из-за использования hashmap для хранения и извлечения индекса каждого значения доступ осуществляется за постоянное время,
минуя необходимость линейного поиска, который в противном случае привел бы к O (N ^ 2) временной сложности, если бы выполнялся наивно.
 */
