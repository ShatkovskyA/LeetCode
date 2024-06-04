package math;

/**
 * _1232_Check_If_It_Is_a_Straight_Line_.
 *
 * @author Anton Shatkovskiy
 * @created 28.05.2024 г.
 */

/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
Check if these points make a straight line in the XY plane.

Example 1:

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true
Example 2:

Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Output: false

Constraints:

2 <= coordinates.length <= 1000
coordinates[i].length == 2
-10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
coordinates contains no duplicate point.

ПЕРЕВОД: 1232. Проверьте, если это - прямая линия.
Вам задан массив координат, coordinates[i] = [x, y], где [x, y] представляет собой координату точки.
Проверьте, образуют ли эти точки прямую линию в плоскости XY.

Пример 1:

Ввод: координаты = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Вывод: true
Пример 2:

Ввод: координаты = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
Вывод: false

Ограничения:

2 <= координаты.длина <= 1000
координат[i].длина == 2
-10^4 <= координаты[i][0], координаты[i][1] <= 10^4
координаты не содержат повторяющихся точек.
 */

public class _1232_Check_If_It_Is_a_Straight_Line_ {

  public static void main(String[] args) {

    int[][] coordinates = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};

    Solution1232 solution1232 = new Solution1232();
    System.out.println(solution1232.checkStraightLine(coordinates));
  }

  /**
   * Проверяет, лежат ли все заданные точки на одной прямой.
   *
   * @param определяет координаты массива точек на двумерной плоскости.
   * @return значение true, если все точки лежат на одной прямой, в противном случае значение false.
   */
  static class Solution1232 {
    public boolean checkStraightLine(int[][] coordinates) {
      // Координаты первой точки
      int x1 = coordinates[0][0];
      int y1 = coordinates[0][1];

      // Координаты второй точки
      int x2 = coordinates[1][0];
      int y2 = coordinates[1][1];

      // циклом пробегаемся по остальным точкам, начиная с третьей
      for (int i = 2; i < coordinates.length; i++) {
        // Координаты текущей точки
        int currentX = coordinates[i][0];
        int currentY = coordinates[i][1];

        // а теперь проверка:
        // вводим новые переменные
        // лежит ли текущая точка на линии, образованной первыми двумя точками
        // это делаем с помощью перекрестного произведения, которое должно быть равно нулю для коллинеарных точек
          int deltaX1 = currentX - x1;
          int deltaY1 = y2 - y1;
          int deltaY2 = currentY - y1;
          int deltaX2 = x2 - x1;

        // если текущая точка не удовлетворяет линейному уравнению, то возвращает значение false
        if(deltaX1 * deltaY1 != deltaX2 * deltaY2) {
          return false;
          }
      }
       // ну а если все точки удовлетворяют линейному уравнению, то возвращается значение true
      return true;
    }
  }
}
