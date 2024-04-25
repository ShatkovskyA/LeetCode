package matrix;

/**
 * _1572_Matrix_Diagonal_Sum_.
 *
 * @author Anton Shatkovskiy
 * @created 24.04.2024 г.
 */

/*
Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

Example 1:

Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25
Explanation: Diagonals sum: 1 + 5 + 9 + 3 + 7 = 25
Notice that element mat[1][1] = 5 is counted only once.

Example 2:

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8

Example 3:

Input: mat = [[5]]
Output: 5

Constraints:

n == mat.length == mat[i].length
1 <= n <= 100
1 <= mat[i][j] <= 100

ПЕРЕВОД: 1572. Сумма диагоналей матрицы
Учитывая квадратную матрицу mit, верните сумму диагоналей матрицы.

Все элементы первичной диагонали и все элементы вторичной диагонали не являются частью первичной диагонали.

Пример 1:

Ввод: с = [[1,2,3],
           [4,5,6],
           [7,8,9]]
Выход: 25
Планирование: сумма диагоналей: 1 + 5 + 9 + 3 + 7 = 25
Обратите внимание, что элемент с[1][1] = 5 подсчитывается только один раз.

Пример 2:

Ввод: с помощью = [[1,1,1,1],
                   [1,1,1,1],
                   [1,1,1,1],
                   [1,1,1,1]]
Выход: 8

Пример 3:

Ввод: с = [[5]]
Выход: 5

Ограничения:

n == mat.length = = = с[i].length
1 <= n <= 100
1 <= с[i][j] <= 100
 */

public class _1572_Matrix_Diagonal_Sum_ {

  public static void main(String[] args) {

    // тут три строки и три столбца, сумма должна быть равна 25
    int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    Solution1572 solution1572 = new Solution1572();
    System.out.println(solution1572.diagonalSum(mat));

  }

  static class Solution1572 {

    public int diagonalSum(int[][] mat) {

      // вводим и инициализируем переменную для хранения диагональной суммы всех элементов,
      // которую надо выводить
      int sum = 0;

      // вводим и инициализируем переменную для определения размера матрицы,
      // хотя это можно и в цикле прописать
      int size = mat.length;

      // применяем циклы
      // тут пробегаемся по i-му элементу для каждой строки матрицы
      for (int i = 0; i < size; i++) {
        // тут вычисляем соответствующий индекс столбца для вторичной диагонали
        int reverseIndex = size - i - 1;

        // добавляем основной диагноальный элемент
        sum += mat[i][i];

        // если это не тот же элемент (что было бы в случае с матрицей нечетного размера)
        // затем добавьте дополнительный диагональный элемент
        if (i != reverseIndex) {
          sum += mat[i][reverseIndex];
        }
      }

      // возвращаем сумму главной и второстепенной диагоналей,
      // исключая средний элемент, если считать его дважды
      return sum;
    }
  }
}

