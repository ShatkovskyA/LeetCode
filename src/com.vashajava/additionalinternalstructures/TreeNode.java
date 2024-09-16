package com.vashajava.additionalinternalstructures;

/**
 * Класс TreeNode - вспомогательный образец класса для использования вкачестве внутренней структуры для определения ущлов дерева,
 * применяется для BinaryTree.
 *
 * @author Anton Shatkovskiy
 * @created 16.07.2024 г.
 */
public class TreeNode {

  // int-овое значение, которое содержится в узле
  public int val;
  // ссылка на дочерний элемент слева,
  // по простому узел слева
  public TreeNode left;
  // ссылка на дочерний элемент дерева справа,
  // по простому узел справа
  public TreeNode right;

  // тут различные виды / типы конструкторов
  // 1. пустой, дефолтный конструктор для инициализации конечного узла
  public TreeNode() {

  }

  // 2. констурктор для инициализации значения узла дерева определенным занчением
  public TreeNode(int val) {
    this.val = val;
  }

  // 3. констурктор для инициализации значения узла определенным значением,
  // а также ссылок на левыми/правыми дочерними элементами
  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
