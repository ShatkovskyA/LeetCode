package com.vashajava.additionalinternalstructures;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс GraphNode - вспомогательный класс в виде образца для использования в качестве внутренней структуры
 *  для определения
 *
 * @author Anton Shatkovskiy
 * @created 29.08.2024 г.
 */
public class GraphNode {
  // int-овое значение, которое содержит узел
  public int val;

  // это список соседних узлов
  public List<GraphNode> neighbors;

  // несколько конструкторов
  // 1. Общий конструктор, без параметров, умолчанию, необходим для создания и инициализации узал со значением 0, а также пустого списка узлов.
  public GraphNode() {
    val = 0;
    neighbors = new ArrayList<GraphNode>();
  }

  // 2. Следующий конструктор - инициализирует значение узла как _val и создает список соседних узлов.
  public GraphNode(int _val) {
    val = _val;
    neighbors = new ArrayList<GraphNode>();
  }

  // 3. Следующий конструктор - инициализирует значение узла как _val и устанавливае список соседних узлов из переданного списка _neighbors
  public GraphNode(int _val, ArrayList<GraphNode> _neighbors) {
    val = _val;
    neighbors = _neighbors;
  }
}
