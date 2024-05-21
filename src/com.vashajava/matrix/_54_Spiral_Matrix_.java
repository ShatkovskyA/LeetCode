package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * _54_Spiral_Matrix_.
 *
 * @author Anton Shatkovskiy
 * @created 26.04.2024 г.
 */

/*

Given an m x n matrix, return all elements of the matrix in spiral order.

Example 1:

Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [1,2,3,6,9,8,7,4,5]

Example 2:

Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]

Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100

ПЕРЕВОД: 54.Спиральная матрица
Учитывая матрицу m x n, верните все элементы матрицы в спиральном порядке.

Пример 1:

Входные данные: матрица = [[1,2,3],[4,5,6],[7,8,9]]
Выходные данные: [1,2,3,6,9,8,7,4,5]

Пример 2:

Входные данные: матрица = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
Выходные данные: [1,2,3,4,8,12,11,10,9,5,6,7]

Ограничения:

m == длина матрицы.
n == матрица[i].длина
1 <= m, n <= 10
-100 <= матрица[i][j] <= 100
 */

public class _54_Spiral_Matrix_ {

  public static void main(String[] args) {

    int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};

    Solution54 solution54 = new Solution54();
    System.out.println(solution54.spiralOrder(matrix));

  }

  static class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {

      // определяем размеры двумерной матрицы
      // строчки
      int rowCount = matrix.length;
      // колонки
      int colCount = matrix[0].length;

      // теперь определяем массив перемещений,
      // направления вправо, вниз, влево и вверх
      // по строчкам
      int[] directionRow = {0, 1, 0, -1};
      // по колонкам
      int[] directionCol = {1, 0, -1, 0};

      // определяем начальную точку пути прохода по марице - с левого угла
      // строчка
      int row = 0;
      // колонка
      int col = 0;

      // определяем начальный индекс для векторов направления
      int directionIndex = 0;

      // вводим переменную итогового списка для сохранения спирального порядка
      // его же и надо вывести в итоге
      List<Integer> result = new ArrayList<>();

      // теперь вводим массив для отслеживания пройденных ячеек
      boolean[][] visited = new boolean[rowCount][colCount];

      // применяем циклы
      // тут вводим h = произведение размера строчек на столбцы, пробегаемся по матрице
      // --h
      for (int h = rowCount * colCount; h > 0; --h) {
      // добавляем текущий элемент к результату, начиная с нулевой точки
        result.add(matrix[row][col]);
      // отмечаем текущую ячейку как посещенную, с помощью введеной ранее
      // булевой переменной, т. е. true
        visited[row][col] = true;
      // вводим вычисляем положение следующей ячейки
        // по строчкам - строчка + направление перемещения из массива с индексом
        int nextRow = row + directionRow[directionIndex];
        // по колонкам - колонка + направление перемещения из массива с индексом
        int nextCol = col + directionCol[directionIndex];
      // проверяем, находится ли следующая ячейка за пределами поля или посещена
        if(nextRow < 0 || nextRow >= rowCount || nextCol < 0 || nextCol >= colCount ||
        visited[nextRow][nextCol]) {
          // обновляем указатель направления, чтобы повернуть направо в порядке спирали
          directionIndex = (directionIndex + 1) % 4;
          // пересчитываем следующую ячейку, используя новое направление
          // по строчкам - строчка + направление перемещения из массива с индексом
          nextRow = row + directionRow[directionIndex];
          // по колонкам - колонка + направление перемещения из массива с индексом
          nextCol = col + directionCol[directionIndex];
        }
        // переходим к следующим ячейкам
        row = nextRow;
        col = nextCol;
    }
      return result;
    }
  }
}
