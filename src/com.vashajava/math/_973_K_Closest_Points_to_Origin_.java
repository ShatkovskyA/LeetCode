package com.vashajava.math;

import java.util.Arrays;

/**
 * _973_K_Closest_Points_to_Origin_.
 *
 * @author Anton Shatkovskiy
 * @created 23.08.2024 г.
 */

/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).

Example 1:

Input: points = [[1,3],[-2,2]], k = 1
Output: [[-2,2]]
Explanation:
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
Example 2:

Input: points = [[3,3],[5,-1],[-2,4]], k = 2
Output: [[3,3],[-2,4]]
Explanation: The answer [[-2,4],[3,3]] would also be accepted.

Constraints:

1 <= k <= points.length <= 104-104 <= xi, yi <= 104

ПЕРЕВОД: 973. K ближайших точек к началу координат.
Учитывая массив точек, где точки [i] = [xi, yi] представляют точку на плоскости X-Y и целое число k, верните k ближайших точек к началу координат (0, 0).

Расстояние между двумя точками на плоскости X-Y равно Евклидову расстоянию (т.е. √(x1 - x2)2 + (y1 - y2)2).

Вы можете вернуть ответ в любом порядке. Гарантируется, что ответ будет уникальным (за исключением порядка, в котором он указан).

Пример 1:

Входные данные: баллы = [[1,3],[-2,2]], k = 1
Выходные данные: [[-2,2]]
Объяснение:
Расстояние между (1, 3) и началом координат равно sqrt(10).
Расстояние между (-2, 2) и началом координат равно sqrt(8).
Поскольку sqrt(8) < sqrt(10), то (-2, 2) ближе к началу координат.
Нам нужны только самые близкие к = 1 точки от начала координат, поэтому ответ будет просто [[-2,2]].
Пример 2:

Входные данные: баллы = [[3,3],[5,-1],[-2,4]], k = 2
Выходные данные: [[3,3],[-2,4]]
Пояснение: Также будут приняты ответы [[-2,4],[3,3]].

Ограничения:

1 <= k <= точек.длина <= 104-104 <= xi, yi <= 104
 */
public class _973_K_Closest_Points_to_Origin_ {

  public static void main(String[] args) {

    int[][] points = {{1, 3}, {-2,2}};
    int k = 1;

    Solution973 solution973 = new Solution973();
    int[][] kClosest = solution973.kClosest(points, k);
    System.out.println(Arrays.deepToString(kClosest));

  }

  static class Solution973 {
    // метод находит "k" ближайших точек к началу координат
    public int[][] kClosest(int[][] points, int k) {
      // тут происходит сортировка массива точек по их евклидову расстоянию от начала координат,
      // с приминением лямбды-выражения
      // где  Arrays.sort - стандартный библиотечный метод сортировки
      Arrays.sort(points, (point1, point2) -> {
        // вычисляем квадрат расстояния для первой точки от начала координат
        int distance1 = point1[0] * point1[0] + point1[1] * point1[1];
        // вычисляем квадрат расстояния для второй точки от начала координат
        int distance2 = point2[0] * point2[0] + point2[1] * point2[1];
        // и сравниваем жва расстояния путем вычисления друг из друга
        return distance1 - distance2;
      });
      // и возвращаем первые "k" элементов отсортированного массива, которые являются k наиболее близкими к началу координат
      // где  Arrays.copyOfRange - стандартный библиотечный метод тоже создает новый массив, но заполняет его данными из произвольного места исходного массива.
      // Где первый и последний — это номера первой и последней ячеек, которые должны быть в новом массиве.
      return Arrays.copyOfRange(points, 0, k);
    }
  }
}

/*
Временная сложность кода равна O(n log n), где n - количество точек.
Это связано с использованием .sort() метода, который имеет O(n log n) сложность сортировки списка точек на основе их расстояния от начала координат,
вычисляемого ключевой функцией (lambda p: p[0] * p[0] + p[1] * p[1]).
 */
