package com.vashajava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Класс _56_Merge_Intervals_ - интервалы слияния.
 *
 * @author Anton Shatkovskiy
 * @created 04.10.2024 г.
 */

/*
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.

Constraints:

1 <= intervals.length <= 104
intervals[i].length == 2
0 <= starti <= endi <= 104

ПЕРЕВОД: 56. Интервалы слияния.
Учитывая массив интервалов, где интервалы[i] = [начало i, конец], объединяем все перекрывающиеся интервалы
и возвращаем массив непересекающихся интервалов, которые охватывают все интервалы во входных данных.

Пример 1:

Ввод: интервалы = [[1,3],[2,6],[8,10],[15,18]]
Вывод: [[1,6],[8,10],[15,18]]
Пояснение: Поскольку интервалы [1,3] и [2,6] перекрываются, объедините их в [1,6].
Пример 2:

Входные данные: интервалы = [[1,4],[4,5]]
Выходные данные: [[1,5]]
Пояснение: Интервалы [1,4] и [4,5] считаются перекрывающимися.

Ограничения:

1 <= интервалы.длина <= 104
интервала[i].длина == 2
0 <= начало <= конец <= 104
 */
public class _56_Merge_Intervals_ {

  public static void main(String[] args) {

    int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

    Solution56 solution56 = new Solution56();
    int[][] merge = solution56.merge(intervals);

    // преобразование к нужному виду при печати
    System.out.println(Arrays.deepToString(merge));

  }

  static class Solution56 {

    // непосредственно сам метод объединения перекрывающихся интервалов
    public int[][] merge(int[][] intervals) {
      // сортируем интервалы исходного массива по времени их начала - т. е. в порядке возрастания
      Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
      // далее создаем список, который будет содержать объединенные интервалы
      List<int[]> mergeIntervals = new ArrayList<>();
      // и добавляем первый интервал в качестве начального элемента в список в качестве начального интервала для объединения
      mergeIntervals.add(intervals[0]);

      // теперь циклом, перебираем все интервалы, начиная со второго
      for(int i = 1; i < intervals.length; ++i) {
        // получаем время начала и окончания текущего интервала
        int start = intervals[i][0];
        int end = intervals[i][1];

        // возвращаем последний интервал в объединенном списке - вызываем метод ГЕТ, который получает полседний эелемнт массива - это размер минус 1
        int[] lastMergeInterval = mergeIntervals.get(mergeIntervals.size() - 1);

        // вводим проверку через if, нет ли совпадения с последним интервалом в объединенном списке
        if(lastMergeInterval[1] < start) {
          // если ничего не пересекается, то добавляем текущий интервал таким, какой он есть
          mergeIntervals.add(intervals[i]);
        } else {
          // в противном случае есть перечением, продлеваем время окончания последнего интервала,
          // исп. все те же "заводские" библ. стандартный метод класса Math нахождения максимального элемента из двух
          lastMergeInterval[1] = Math.max(lastMergeInterval[1], end);
        }
      }
      // на последнем этапе преобразуем список объединенных интервалов в двумерный массив и возвращаем его
      return mergeIntervals.toArray(new int[mergeIntervals.size()][]);
    }
  }
}

/*
Общая временная сложность равна сумме этих двух операций, то есть O(n log n) + O(n).
Поскольку O(n log n) это член высшего порядка, он доминирует в общей временной сложности, что упрощает до O(n log n).
 */
