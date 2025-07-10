package com.vashajava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс _57_Insert_Interval_ - вставка интервала.
 *
 * @author Anton Shatkovskiy
 * @created 01.08.2024 г.
 */

/*
You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent
the start and the end of the ith interval and intervals is sorted in ascending order by starti.
You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti
and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
Example 2:

Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

Constraints:

0 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 105
intervals is sorted by starti in ascending order.
newInterval.length == 2
0 <= start <= end <= 105

ПЕРЕВОД: 57. Вставка интервала.
Вам предоставляется массив непересекающихся интервалов intervals, где интервалы[i] = [starti, endi] представляют
начало и конец i-го интервала, а интервалы отсортированы в порядке возрастания по starti.
Вам также будет задан интервал newInterval = [начало, конец], который представляет начало и конец другого интервала.

Вставьте newInterval в интервалы таким образом, чтобы интервалы по-прежнему сортировались в порядке возрастания по началу,
а интервалы по-прежнему не имели перекрывающихся интервалов (при необходимости объедините перекрывающиеся интервалы).
Возвращайте интервалы после установки.
Обратите внимание, что вам не нужно изменять интервалы на месте. Вы можете создать новый массив и вернуть его.

Пример 1:

Ввод: интервалы = [[1,3],[6,9]], newInterval = [2,5]
Вывод: [[1,5],[6,9]]
Пример 2:

Ввод: интервалы = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Вывод: [[1,2],[3,10],[12,16]]
Пояснение: Поскольку новый интервал [4,8] перекрывается с [3,5],[6,7],[8,10].

Ограничения:

0 <= интервалы.длина <= 104
интервала[i].длина == 2
0 <= начало <= конец <= 105
интервалов отсортированы по началу в порядке возрастания.
newInterval.length == 2
0 <= начало <= конец <= 105

 */
public class _57_Insert_Interval_ {

  public static void main(String[] args) {

    int[][] intervals = {{1, 3}, {6, 9}};
    int[] newInterval = {2, 5};

    Solution57 solution57 = new Solution57();
    int[][] insert = solution57.insert(intervals, newInterval);

    // вывод на печать
//    for (int i = 0; i < insert.length; i++) {
//      for (int j = 1; j < insert[0].length; j++) {
//        System.out.print(insert[i][j] + " ");
//      }
//      System.out.println(" ");
//    }

    // вывод на печать - как требуется по условию,
    // где Arrays.deepToString() - библиотечный метод, предназначен только для преобразования многомерных массивов в строки
    System.out.println(Arrays.deepToString(insert));

  }

  static class Solution57 {

    // это есть функция для вставки нового интервала в существующий список интервалов
    public int[][] insert(int[][] intervals, int[] newInterval) {

      // инициализируем расширенный массив для хранения существующих интервалов и нового интервала,
      // где определяем существующий массив intervals (length - это длина массива, возвращает кол-во его элементов)
      int[][] expandedIntervals = new int[intervals.length + 1][2];

      // теперь, с помощью цикла, копируем существующие интервалы в расширенный вновь созданный массив
      for (int i = 0; i < intervals.length; ++i) {
        expandedIntervals[i] = intervals[i];
      }
      // и здесь добавляем новый интервал в конец расширенного массива intervals
      expandedIntervals[intervals.length] = newInterval;

      // объеденяем перекрывающиеся интервалы (с помощью отдельно реализованного метода) и возвращаем результат
      return merge(expandedIntervals);
    }

    // вот тут вспомогательный отдельно реализованный метод для объединения перекрывающихся интервалов,
    // куда в качестве аргумента мы передаем хаданный изначально массив int[][] intervals
    private int[][] merge(int[][] intervals) {
      // тут производится сртировка интервалов в зависимости от времени начала,
      // с приминением библиотечных методов sort() и лямбда выражения,
      // где Integer.compare - используется для сравнения вводимых параметров, в данном случае аргументов
      Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

      // оздаем список для хранения объединенных интервалов
      List<int[]> mergeIntervals = new ArrayList<>();
      // и для инициализации добавляем первый интереал в созданный список
      mergeIntervals.add(intervals[0]);

      // а теперь активируем список и пробегаемся по всем / каждому интервалу и при необходимости объединяем
      for (int i = 0; i < intervals.length; ++i) {
        // тут получаем время (значение) начала и окончания текущего интервала,
        // т. е. создаем и инициализируем новые перменные начала и конца интервала
        int stert = intervals[i][0];
        int end = intervals[i][1];

        // далее возвращаем время / значение окончания последнего интервала в списке,
        // опять с помощью создания новой переменной и получения с помощью метода get из списка,
        // mergeIntervals.size() - размер элментов списка
        int lastEnd = mergeIntervals.get(mergeIntervals.size() - 1)[1];

        // и если текущий интервал не совпадает с предыдущим, просто добавляем его в списко методом add,
        // т. е. применяем условие - сравниваем
        if(lastEnd < stert) {
          mergeIntervals.add(intervals[i]);
        } else {
          //  в противном случае объеденяем текущий интервал с предыдущим, обновив время окончания,
          // опять же применяя стандартную функция вычисления максимума - Math.max
          mergeIntervals.get(mergeIntervals.size() - 1)[1]=Math.max(lastEnd, end);
        }
      }
       // далее преобразуем список обратно в массив и возвращаем его,
      // применяем библиотечную стандартную функцию
      return mergeIntervals.toArray(new int[mergeIntervals.size()][]);
    }
  }
}

/*
Общая временная сложность этого подхода определяется операцией сортировки, которая определяет O(n log n)количество n интервалов, включая новый интервал.
Однако, если интервалы уже были отсортированы (кроме добавленного newInterval), это потенциально можно оптимизировать,
O(n)осторожно вставив newIntervalв правильную позицию.
Поскольку эта оптимизация не представлена в данном решении, здесь она остается академической.
 */
