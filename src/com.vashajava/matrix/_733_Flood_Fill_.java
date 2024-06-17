package matrix;

/**
 * _733_Flood_Fill_.
 *
 * @author Anton Shatkovskiy
 * @created 15.06.2024 г.
 */

/*
An image is represented by an m x n integer grid image where image[i][j]
represents the pixel value of the image.

You are also given three integers sr, sc, and color.
You should perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel,
plus any pixels connected 4-directionally to the starting pixel of the same color
as the starting pixel, plus any pixels connected 4-directionally
to those pixels (also with the same color), and so on.
Replace the color of all of the aforementioned pixels with color.

Return the modified image after performing the flood fill.

Example 1:

Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
Example 2:

Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation: The starting pixel is already colored 0, so no changes are made to the image.

Constraints:

m == image.length
n == image[i].length
1 <= m, n <= 50
0 <= image[i][j], color < 216
0 <= sr < m
0 <= sc < n

ПЕРЕВОД: 733. Заливка потоком.
Изображение представлено в виде сетки из m x n целых чисел, где изображение [i][j]
представляет собой значение пикселя изображения.

Вам также задаются три целых числа sr, sc и color.
Вы должны выполнить заливку изображения заливкой,
начиная с пиксельного изображения [sr][sc].

Чтобы выполнить заливку заливкой, рассмотрим начальный пиксель,
плюс любые пиксели, соединенные в 4 направлениях с начальным пикселем того же цвета,
что и начальный пиксель, плюс любые пиксели, соединенные в 4 направлениях
с этими пикселями (также того же цвета), и так далее.
Замените цвет всех вышеупомянутых пикселей на color.

Верните измененное изображение после выполнения заливки.

Пример 1:

Ввод: изображение = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Выход: [[2,2,2],[2,2,0],[2,0,1]]
Пояснение: Начиная с центра изображения с позицией (sr, sc) = (1, 1) (т.е. красного пикселя), все пиксели, соединенные линией того же цвета, что и начальный пиксель (т.е. синие пиксели), окрашиваются в новый цвет.
Обратите внимание, что в нижнем углу находится
 */

  /*
  Временная сложность алгоритма заливки флудом составляет O(M*N),
  где M - количество строк и N - количество столбцов в изображении.
  Это связано с тем, что в наихудшем случае алгоритм выполняет поиск в глубину
  (DFS) по каждой ячейке сетки один раз, когда требуется залить новым цветом все изображение.

Сложность пространства также O(M*N) связана, в первую очередь,
с рекурсивным стеком, который потенциально может вырасти до размера всей сетки в случае
большой связанной области с тем же цветом, которую необходимо заполнить.
   */
public class _733_Flood_Fill_ {

  public static void main(String[] args) {

    int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
    int sr = 1;
    int sc = 1;
    int color = 2;
    Solution733 solution733 = new Solution733();
    int[][] resultFloodFill = solution733.floodFill(image, sr, sc, color);
    // System.out.println(resultFloodFill);
    for (int i = 0; i < resultFloodFill.length; i++) {
      for (int j = 0; j < resultFloodFill[0].length; j++)
        System.out.print(resultFloodFill[i][j] + " ");
    }
    System.out.println(" ");
  }


  static class Solution733 {
    // ЗДЕСЬ ОСНОВНЫЕ ПЕРЕМЕННЫЕ
    // вводим векторы направления,
    // представляющие 4 соединенных пикселя (вверх, вправо, вниз, влево)
    private int[] directions = {-1, 0, 1, 0, -1};
    // тут инициализируем изображение, которое нам нужно изменить
    private int[][] image;
    // тут вводим и инициализируем новый цвет, который будет применен к заливке заливкой
    private int newColor;
    // тут вводим и инициализируем оригинальный цвет, подлежащий замене
    private int originalColor;

    // сам оригинальный метод (способ) начала операции заливки паводком
    // sr - startRow
    // sc - startColumn
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      // инициализируем изображение, новый цвет и исходный цвет на основе входных данных
      this.image = image;
      this.newColor = color;
      this.originalColor = image[sr][sc];
      // вызываем рекурсивный метод dfs, начиная с пикселя в точке (sr, sc)
      dfs(sr, sc);
      // и возвращем измененное изображение после операции заливки потоком
      return image;
    }
    // сам оригинальный метод (способ) dfs обхода в глубину
    // метод поиска по глубине (DFS) для применения нового цвета к подключенным компонентам
    private void dfs(int row, int column) {
      // проверяем границы: если пиксель выходит за границы изображения, не соответствует исходному цвету или уже имеет новый цвет, то возвращаемся
      if(row < 0 || row >= image.length || column < 0 || column >= image[0].length ||
      image[row][column] != originalColor || image[row][column] == newColor) {
        return;
      }
      // изменяем цвет текущего пикселя на новый
      image[row][column] = newColor;
      // выполняем итерацию по каждому из 4 подключенных соседей - пиксилей
      for (int k = 0; k < 4; k++) {
        // далее рекурсивно вызоваем dfs для текущего соседа
        dfs(row + directions[k], column + directions[k + 1]);
      }
    }
  }
}
