package com.vashajava.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * _207_Course_Schedule_.
 *
 * @author Anton Shatkovskiy
 * @created 10.09.2024 г.
 */

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.

ПЕРЕВОД: 207. Расписание занятий.
Вам необходимо пройти в общей сложности несколько курсов numCourses, обозначенных от 0 до numCourses - 1.
Вам предоставляется массив предварительных условий, где предварительные условия[i] = [ai, bi] означают,
что вы должны сначала пройти курс bi, если хотите пройти курс ai.

Например, пара [0, 1] указывает, что для прохождения курса 0 вы должны сначала пройти курс 1.
Верните значение true, если вы можете пройти все курсы. В противном случае верните значение false.

Пример 1:

Входные данные: количество курсов = 2, предварительные требования = [[1,0]]
Выходные данные: true
Пояснение: Всего необходимо пройти 2 курса.
Чтобы пройти курс 1, вы должны были закончить курс 0. Таким образом, это возможно.
Пример 2:

Вводные данные: numCourses = 2, предварительные требования = [[1,0],[0,1]]
Вывод: false
Пояснение: Всего необходимо пройти 2 курса.
Чтобы пройти курс 1, вы должны пройти курс 0, а чтобы пройти курс 0, вы также должны пройти курс 1. Так что это невозможно.

Ограничения:

1 <= Количество курсов <= 2000
0 <= предварительные условия.длина <= 5000
предварительные условия[i].длина == 2
0 <= ai, bi < количество курсов
Все
 */

  // используем топографическую сортировку на основе алгоритма Кана,
// который представляет собой стратегию сортировки узлов в ориентированном графе
public class _207_Course_Schedule_ {

  public static void main(String[] args) {

    // ввод данных
    int numCourses = 2;
    int[][] prerequisites = {{1, 0}};

    // запуск и реализация по вводимым данным
    Solution207 solution207 = new Solution207();
    Boolean canFinish = solution207.canFinish(numCourses, prerequisites);
    System.out.println(canFinish);

  }

  static class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

      // СНОВНЫЕ ЭТАПЫ
      // 1. ПРЕДСТАВЛЕНИЕ ГРАФА
      // создаем граф, представленный списком смежности, где каждый курс указывает на свои предварительные условия
      List<List<Integer>> graph = new ArrayList<>();
      // тут цикл, пока numCourses меньше нуля, вносим в граф список, т. е. заполняем граф
      for (int i = 0; i < numCourses; i++) {
        // где add() - традиционный "заводской" библиотечный метод
        graph.add(new ArrayList<>());
      }

      // 2. НАБОР СТЕПЕНЕЙ
      // создаем массив для хранения степеней (количества обязательных предметов) для каждого курса
      int[] inDegrees = new int[numCourses];

      // 3. ПОСТРОЕНИЕ ГРАФА И МАССИВА СТЕПЕНЕЙ
      //  в итоге заполняем граф и обновляем значения в градусах на основе предварительных условий
      // применяем "облегченный" цикл for
      for (int[] prerequisite : prerequisites) {
        // тут начинаем с нулевого элемента
        int course = prerequisite[0];
        int prerequisiteCourse = prerequisite[1];
        // тут с помощью "заводских" библиотечных методов заполняем граф
        graph.get(prerequisiteCourse).add(course);
        // увеличиваем-инкрементим продолжительность курса
        inDegrees[course]++;
      }

      // 4. ОБРАБОТКА УЗЛОВ С НУЛЕВЫМИ ЗНАЧЕНИЯМИ В ГРАДУСАХ
      // создаем и инциализируем на обучение на курсах с нулевой степенью (без предварительных условий)
      Deque<Integer> queue = new ArrayDeque<>();
      // ставим в очередь все курсы, для которых нет предварительных требований
      // тут цикл, пока numCourses меньше нуля
      for(int i = 0; i < numCourses; i++) {
        // если inDegrees[i] равен нулю,
        if(inDegrees[i] == 0) {
          // включаем элемент в очередь стандартным "заводским" библиотечным методом offer(), который не выбрасывает исключений,
          // и не нарушает ограничений по емкости
          queue.offer(i);
        }
     }

      // 5. ТОПОЛОГИЧЕСКАЯ СОРТИРОВКА
      // вводим и инициализируем переменную счетчика количества обработанных блюд
      int processedCourse = 0;

      // теперь обрабатываем курсы в очереди с помощью цикла while
      // пока очередь не пуста
      while (!queue.isEmpty()) {
        // где poll() - возвращает элемент из головы очереди и удаляет его,
        // а если очередь пуста, метод poll() возвращает null
        int course = queue.poll();
        // увеличиваем по счетчик количество обработанных блюд
        processedCourse++;
        // и далее посредством цикла for-each выполняем итерацию по соседям текущего курса
        for (int neighbor : graph.get(course)) {
          // уменьшаем значение в массиве inDegrees для каждого соседа, поскольку мы обработали одно из его предварительных условий
          inDegrees[neighbor]--;
          // тут если значение в массиве inDegrees равно 0, это означает, что все предварительные условия выполнены,
          if(inDegrees[neighbor] == 0) {
            // поэтому поставьте курс в очередь,
            // включаем элемент в очередь стандартным "заводским" библиотечным методом offer(), который не выбрасывает исключений,
            // и не нарушает ограничений по емкости
            queue.offer(neighbor);
           }
        }
      }
      // 6. ВОЗВРАЩАЕМОЕ ЗНАЧЕНИЕ
      // если количество обработанных курсов равно общему количеству курсов, все они могут быть завершены
      return processedCourse == numCourses;
    }
  }
}

/*
Временную сложность данного алгоритма можно проанализировать следующим образом:

- Построение графика (g) и массива indegree (indeg) включает перебор всех ребер в prerequisites списке.
Если есть E дополнительные требования), эта часть требует O(E) времени.

- Создание начальной очереди q со всеми курсами, имеющими 0 indegree,
требует однократного перебора массива indegree, что занимает O(V) время, где V - количество курсов (numCourses).

- while Цикл обрабатывает каждый узел (курс) ровно один раз и уменьшает степень его соседей.
Поскольку в нем рассматриваются узлы indegree и ставятся в очередь, в худшем случае этот цикл выполняется по всем V узлам и E ребрам.
Следовательно, цикл выполняется за O(V + E) время.

- Общая временная сложность всех вышеперечисленных компонентов составляет O(E) + O(V) + O(V + E), что упрощает O(V + E).

Таким образом, общая временная сложность выполнения функции составляет O(V + E).
 */
