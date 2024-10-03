package matrix;


/**
 * _73_Set_Matrix_Zeroes_.
 *
 * @author Anton Shatkovskiy
 * @created 26.04.2024 г.
 */

/*
Given an m x n integer matrix matrix, if an element is 0,
set its entire row and column to 0's.

You must do it in place.

Example 1:

Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]

Example 2:

Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1

Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?

ПЕРЕВОД: 73.Установите матричные нули
Для заданной матрицы m x n целых чисел, если элемент равен 0,
установите для всей его строки и столбца значения 0.

Вы должны сделать это на месте.

Пример 1:

Входные данные: матрица = [[1,1,1],[1,0,1],[1,1,1]]
Выходные данные: [[1,0,1],[0,0,0],[1,0,1]]

Пример 2:

Входные данные: матрица = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Выходные данные: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]

Ограничения:

m == длина матрицы.
n == матрица[0].длина
1 <= m, n <= 200
-231 <= матрица[i][j] <= 231 - 1

Следовать за:
Простое решение с использованием O(mn) пространства, вероятно, является плохой идеей.
Простое усовершенствование использует O (m + n) пространства, но все равно это не лучшее решение.
Не могли бы вы разработать решение с постоянным пространством?
 */
public class _73_Set_Matrix_Zeroes_ {

  public static void main(String[] args) {

    int[][] matrix = {{1,1,1}, {1,0,1}, {1,1,1}};

    Solution73 solution73 = new Solution73();
    solution73.setZeroes(matrix);

    // TODO: проработать вывод
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++)
      System.out.print(matrix[i][j] + " ");
    }
    System.out.println(" ");
  }

  static class Solution73 {
    public void setZeroes(int[][] matrix) {
      // определяем размеры двумерной матрицы
      // количество строк в матрице
      int rowCount = matrix.length;
      // количество столбцов в матрице
      int colCount = matrix[0].length;
      // флажок(булево значение)) для проверки, содержит ли первая строчка ноль
      boolean firstRowHasZero = false;
      // флажок(булево значение)) для проверки, содержит ли первый столбец ноль
      boolean firstColHasZero = false;

      // применяем циклы
      // проверка, есть ли нули в первой строчке
      for (int col = 0; col < colCount; ++col) {
        // робегаемся по строчке, если первый элемент равен 0, то труе
        if(matrix[0][col] == 0) {
          firstRowHasZero = true;
          break;
        }
      }
      // аналогично проверка, есть ли нули в первом столбце
      for (int row = 0; row < rowCount; ++row) {
        if (matrix[row][0] == 0) {
          firstColHasZero = true;
          break;
        }
      }
      // используем первую строку и столбец в качестве маркеров.
      // для матрицы[i][0] и матрицы[0][j] устанавливаем значение 0,
      // если матрица[i][j] равна 0
      for (int row = 1; row < rowCount; ++row) {
        for (int col = 1; col < colCount; ++col) {
          if(matrix[row][col] == 0) {
            matrix[row][0] = 0;
            matrix[0][col] = 0;
          }
        }
      }
      // повторяем итерацию по матрице,
      // используя первую строку и столбец в качестве ссылки,
      // и устанавливаем для элементов значение 0 соответственно.
      for (int row = 1; row < rowCount; ++row) {
        for (int col = 1; col < colCount; ++col) {
          if(matrix[row][0] == 0 || matrix[0][col] == 0) {
            matrix[row][col] = 0;
          }
        }
      }
      // если необходимо, обнуляем первую строку
      if(firstRowHasZero) {
        for (int col = 0; col < colCount; ++col) {
          matrix[0][col] = 0;
        }
      }
      // если необходимо, обнуляем первый столбец
      if(firstColHasZero) {
        for (int row = 0; row < rowCount; ++row) {
          matrix[row][0] = 0;

        }
      }
    }
  }
}
