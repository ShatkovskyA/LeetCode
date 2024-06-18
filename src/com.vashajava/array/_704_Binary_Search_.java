package array;

/**
 * _704_Binary_Search_.
 *
 * @author Anton Shatkovskiy
 * @created 15.06.2024 г.
 */

/*
Given an array of integers nums which is sorted in ascending order,
and an integer target, write a function to search target in nums.
If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.

ПЕРЕВОД: 704.Бинарный поиск.
Учитывая массив целых чисел nums, отсортированный в порядке возрастания,
и целочисленный целевой объект, напишите функцию для поиска целевого объекта в nums.
Если целевой объект существует, то верните его индекс. В противном случае верните значение -1.

Вы должны написать алгоритм со сложностью выполнения O(log n).

Пример 1:

Входные данные: nums = [-1,0,3,5,9,12], цель = 9
Выходные данные: 4
Пояснение: в nums существует 9, и его индекс равен 4
Пример 2:

Ввод: nums = [-1,0,3,5,9,12], цель = 2
Вывод: -1
Пояснение: значение 2 не существует в nums, поэтому верните значение -1

Ограничения:

1 <= число.длина <= 104
-104 < nums[i], target < 104
Все целые числа в nums уникальны.
nums сортируется в порядке возрастания.

 */

  /*
  Алгоритм, используемый для поиска target значения, должен иметь сложность во время выполнения O(log n).
  Это убедительный намек на то, что следует реализовать алгоритм бинарного поиска,
  поскольку бинарный поиск имеет логарифмическую временную сложность и обычно работает с отсортированными данными.

  Цикл while будет выполняться до тех пор, пока left не будет равно right.
  На каждой итерации размер интервала уменьшается вдвое, что означает,
  что временная сложность логарифмична по отношению к размеру массива nums.
  Следовательно, временная сложность равна O(log n), где n - длина nums.
   */
public class _704_Binary_Search_ {

  public static void main(String[] args) {

    int[] nums = {-1, 0, 3, 5, 9, 12};
    int target = 9;

    Solution704 solution704 = new Solution704();
    int binSearch = solution704.search(nums, target);
    System.out.println(binSearch);

  }

  static class Solution704 {

    public int search(int[] nums, int target) {
      // согласно концепции бинарного поиска - массив надо разделить на два,
      // т. е. вводим две половины - лево и право и две переменные вводим для них и инициализируем
      // инициализируем начальный индекс диапазона поиска
      int left = 0;
      // инициализируем конечный индекс диапазона поиска
      int right = nums.length - 1;

      // далее вводим цикл while с условием для поиска пока left меньше right
      // поиск продолжается, пока диапазон содержит более одного элемента в диапазоне
      while (left < right) {
        // вычисляем средний индекс текущего диапазона
        /*
        Индекс средней точки mid путем сложения left и right, затем сдвиньте результат вправо на один бит (>> 1).
        Это эквивалентно mid = (left + right) // 2, но более эффективно.
        Переменная mid представляет индекс элемента в середине текущего пространства поиска.

        В выражении (right - left) / 2, сначала производится вычитание right - left,
        чтобы получить интервал между правой и левой границами массива. Затем это значение делится на 2,
        чтобы получить среднюю точку. Это позволяет правильно рассчитать среднюю точку в случае, например, когда левая граница не равна 0.

        Если мы использовали бы просто выражение int mid = left + right / 2, то мы бы делили right на 2,
        что привело бы к неверному результату в случае, когда левая граница массива не равна 0.
         */
        int mid = left + (right - left) / 2;

        // если средний элемент больше или равен целевому,
        // то сужаем диапазон поиска до левой половины (включая средний элемент)
        if (nums[mid] >= target) {
          right = mid;
        } else {
          // если же средний элемент меньше целевого,
          // то сужаем диапазон поиска до правой половины (исключая средний элемент)
          left = mid + 1;
        }
      }
      // И последняя проверка: на данный момент left - это индекс, по которому может быть найден объект, если он существует,
      // проверяем, является ли элемент с индексом "left" объектом.
      // если это так, возвращаем. В противном случае верните значение -1, указывающее, что объект не найден.
      // исп. тернарный оператор
      return nums[left] == target ? left : -1;
    }
  }
}

