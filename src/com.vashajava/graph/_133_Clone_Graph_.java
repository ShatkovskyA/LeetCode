package com.vashajava.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * _133_Clone_Graph_.
 *
 * @author Anton Shatkovskiy
 * @created 29.08.2024 г.
 */

/*
Given a reference of a node in a connected undirected graph.
Return a deep copy (clone) of the graph.
Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.

class Node {
    public int val;
    public List<Node> neighbors;
}

Test case format:

For simplicity, each node's value is the same as the node's index (1-indexed).
For example, the first node with val == 1, the second node with val == 2, and so on. The graph is represented in the test case using an adjacency list.

An adjacency list is a collection of unordered lists used to represent a finite graph.
Each list describes the set of neighbors of a node in the graph.

The given node will always be the first node with val = 1. You must return the copy of the given node as a reference to the cloned graph.

Example 1:

Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
Output: [[2,4],[1,3],[2,4],[1,3]]
Explanation: There are 4 nodes in the graph.
1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
Example 2:

Input: adjList = [[]]
Output: [[]]
Explanation: Note that the input contains one empty list. The graph consists of only one node with val = 1 and it does not have any neighbors.
Example 3:

Input: adjList = []
Output: []
Explanation: This an empty graph, it does not have any nodes.

Constraints:

The number of nodes in the graph is in the range [0, 100].
1 <= Node.val <= 100
Node.val is unique for each node.
There are no repeated edges and no self-loops in the graph.
The Graph is connected and all nodes can be visited starting from the given node.

ПЕРЕВОД: 133. Клонирование графа.
Дана ссылка на узел в связном неориентированном графе.
Возвращает глубокую копию (клон) графика.
Каждый узел в графе содержит значение (int) и список (List[Node]) своих соседей.

узел класса {
    публичный внутренний вал;
    открытый список соседей<Узел>;
}

Формат тестового примера:

Для простоты значение каждого узла совпадает с индексом узла (индексируется на 1).
Например, первый узел с значением val == 1, второй узел с значением val == 2 и так далее. График представлен в тестовом примере с использованием списка смежности.

Список смежности - это набор неупорядоченных списков, используемых для представления конечного графа.
Каждый список описывает набор соседей узла в графе.

Данный узел всегда будет первым узлом с значением val = 1. Вы должны вернуть копию данного узла в качестве ссылки на клонированный граф.

Пример 1:

Ввод: adjList = [[2,4],[1,3],[2,4],[1,3]]
Выходные данные: [[2,4],[1,3],[2,4],[1,3]]
Пояснение: На графике 4 узла.
Соседями 1-го узла (val = 1) являются 2-й узел (val = 2) и 4-й узел (val = 4).
соседями 2-го узла (val = 2) являются 1-й узел (val = 1) и 3-й узел (val = 3).
Соседями 3-го узла (val = 3) являются 2-й узел (val = 2) и 4-й узел (val = 4).
соседями 4-го узла (val = 4) являются 1-й узел (val = 1) и 3-й узел (val = 3).
Пример 2:

Ввод: adjList = [[]]
Вывод: [[]]
Пояснение: Обратите внимание, что входные данные содержат один пустой список. Граф состоит только из одной вершины с значением val = 1 и не имеет соседей.
Пример 3:

Входные данные: adjList = []
Выходные данные: []
Пояснение: Это пустой граф, в нем нет никаких вершин.

Ограничения:

Количество узлов в графе находится в диапазоне [0, 100].
1 <= Node.val <= 100
Значение Node.val уникально для каждого узла.
В графе нет повторяющихся ребер и замкнутых циклов.
Граф является связным, и можно посетить все узлы, начиная с заданного узла.
 */

  // алгоритм включает в себя поиск в глубину (DFS)
public class _133_Clone_Graph_ {

  public static void main(String[] args) {

    // вводим переменные
    // Создаем 4 узла
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);

    // Создаем список смежности узлов по условию задачи
    node1.neighbors.add(node2);
    node1.neighbors.add(node4);

    node2.neighbors.add(node1);
    node2.neighbors.add(node3);

    node3.neighbors.add(node2);
    node3.neighbors.add(node4);

    node4.neighbors.add(node1);
    node4.neighbors.add(node3);

    // Создаем экземпляр класса Solution133 и клонируем граф
    Solution133 solution133 = new Solution133();
    Node cloneGraph = solution133.cloneGraph(node1);

    // рапечатываем и выводим на консоль в том виде, как того требует условие задачи - в печать передаем полученный клонированный граф
    printGraph(cloneGraph);

  }

  // оснонвой метод печати графа
  private static void printGraph(Node node) {
    // традиционная на нулл
    if (node == null) {
      System.out.println("Output: []");
      return;
    }

    // это создается список того, что посетили раньше
    Set<Node> visited = new HashSet<>();
    // это создается для хранения списка соседей кажого узла
    List<List<Integer>> result = new ArrayList<>();
    // рекурсивный вспомогательный метод, начинает обход с переданной корневой вершины
    dfsCollectNodes(node, visited, result);
    // вывод на печать информации о соседях каждой вершины
    System.out.println("Output: " + result);
  }

  // вспомогательный метод обхода в глубину графа по передаваемым аргуменам, т. е. подготовка перед передачей на печать,
  // обход в глубину и сбор о соседях каждого узла
  private static void dfsCollectNodes(Node node, Set<Node> visited, List<List<Integer>> result) {
    // традиционно проверку на нулл
    if (node == null || visited.contains(node)) {
      return;
    }
    visited.add(node);
    // тут для каждой вершины формируется список
    List<Integer> neighborsList = new ArrayList<>();
    for (Node neighbor : node.neighbors) {
      neighborsList.add(neighbor.val);
    }
    // и передается в результат
    result.add(neighborsList);
    // тут опять рекурсивно метод вызывает сам себя
    for (Node neighbor : node.neighbors) {
      dfsCollectNodes(neighbor, visited, result);
    }
  }

  // Определение для узла графа.
  // создадим воспомогательную структуру
  static class Node {

    // int-овое значение, которое содержит узел
    public int val;

    // это список соседних узлов
    public List<Node> neighbors;

    // несколько конструкторов
    // 1. Общий конструктор, без параметров, умолчанию, необходим для создания и инициализации узал со значением 0, а также пустого списка узлов.
    public Node() {
      val = 0;
      neighbors = new ArrayList<Node>();
    }

    // 2. Следующий конструктор - инициализирует значение узла как _val и создает список соседних узлов.
    public Node(int _val) {
      val = _val;
      neighbors = new ArrayList<Node>();
    }

    // 3. Следующий конструктор - инициализирует значение узла как _val и устанавливае список соседних узлов из переданного списка _neighbors
    public Node(int _val, ArrayList<Node> _neighbors) {
      val = _val;
      neighbors = _neighbors;
    }
  }

    static class Solution133 {

      // 1. ИНИЦИАЛИЗАЦИЯ
      // создаем и инициализируем хэш-карту для отслеживания всех узлов, которые уже были скопированы, туда все и убдем класть
      private HashMap<Node, Node> visited = new HashMap<>();

      // рекурсивная функция возвращает клон графика
      public Node cloneGraph(Node node) {
        // задаем условия - проверки
        // 1. если входной узел равен null, то возвращает значение null
        if (node == null) {
          return null;
        }

        // 2. а если узел уже был посещен, т.е. уже клонирован,
        // то возвращаем клонированный узел с карты,
        // где containsKey(node) - "заводской", библиотечный метод, определённый в классе HashMap,
        // используется для проверки того, сопоставлен ли переданный ключ в HashMap.
        // Другими словами, метод проверяет, существует ли данный ключ в HashMap.
        if (visited.containsKey(node)) {
          // get() - такде стандартный заводской метод - на получение
          return visited.get(node);
        }

        // 2. ПРОЦЕСС КЛОНИРОВАНИЯ
        // создаем новый узел (объект класса + занчение) со значением входного узла (клонируйте его)
        Node cloneNode = new Node(node.val);
        // отмечаем этот узел как посещенный, поместив его в карту посещений,
        // где put() опять же "заводской", библиотечный метод для того чтобы поместить узел в карту,
//      public V put(K key, V value) {
//        return putVal(hash(key), key, value, false, true);
//      }
        visited.put(node, cloneNode);

        // 3. ЗАПОЛНЕНИЕ ГРАФА
        // и теперь, посредством цикла foreach, выполняем итерацию по всем соседям входного узла формирую новые узлы
        for (Node neighbor : node.neighbors) {
          // выполняем рекурсивно поиск в глубину (DFS) для каждого соседа, рекурсивно вызывая функцию cloneGraph(neighbor)
          // и добавьте клон соседа (метод add(cloneGraph(neighbor))) в список соседей узла-клона
          cloneNode.neighbors.add(cloneGraph(neighbor));
        }

        // 4. ВОЗВРАТ
        // и возвращаем клонированный узел графа
        return cloneNode;
      }
    }
}

/*
Сложность алгоритма равна O (N + M), где N - количество узлов,
а M - количество ребер в графе, поскольку каждый узел и ребро посещаются один раз в процессе обхода и копирования.
 */
