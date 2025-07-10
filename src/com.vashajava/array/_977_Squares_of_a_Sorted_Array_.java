package com.vashajava.array;

/**
 * Класс _977_Squares_of_a_Sorted_Array_ - квадраты отсортированного массива.
 *
 * @author Anton Shatkovskiy
 * @created 31.07.2024 г.
 */

/*
Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.

Follow up: Squaring each element and sorting the new array is very trivial, could you find an O(n) solution using a different approach?

ПЕРЕВОД: 977. Квадраты отсортированного массива.
При заданном целочисленном массиве nums, отсортированном в порядке неубывания,
верните массив квадратов каждого числа, отсортированных в порядке неубывания.

Пример 1:

Входные данные: nums = [-4,-1,0,3,10]
Результат: [0,1,9,16,100]
Пояснение: После возведения в квадрат массив становится [16,1,0,9,100].
После сортировки он становится [0,1,9,16,100].
Пример 2:

Входные данные: nums = [-7,-3,2,3,11]
Выходные данные: [4,9,9,49,121]

Ограничения:

1 <= число.длина <= 104
-104 <= nums[i] <= 104
числа сортируются в порядке неубывания.

Продолжение: Возведение в квадрат каждого элемента и сортировка нового массива очень тривиальны,
не могли бы вы найти решение O (n), используя другой подход?
 */
public class _977_Squares_of_a_Sorted_Array_ {

  public static void main(String[] args) {

    int[] nums = {-4,-1,0,3,10};

    Solution977 solution977 = new Solution977();
    int[] sortedSquares = solution977.sortedSquares(nums);

    // I способ - в конце запятая выодится
//    for (int sortedSquare : sortedSquares)
//    // System.out.print(sortedSquare + ", " + " ");
//     System.out.print(sortedSquare + " ");

    // II способ - без запятой в конце
    System.out.print("[");
    for (int i = 0; i < sortedSquares.length; i++) {

      System.out.print(sortedSquares[i]);

      if (i < sortedSquares.length - 1) {
        System.out.print(", " );
      }

    }
    System.out.print("]");

  }

  static class Solution977 {
    // Метод, который принимает массив целых чисел в качестве входных данных и
    // возвращает новый массив, в котором квадраты каждого числа отсортированы в порядке неубывания.
    public int[] sortedSquares(int[] nums) {
      // задаем переменную, которая сохраняет длину входного массива  - это не массив, это число
      int length = nums.length;
      // оздаем переменную - новый массив для хранения результата
      int[] sortedSquares = new int[length];

      // тут инициализируем указатели для начала и конца входного массива,
       // и указатель 'k' для позиции, которую нужно вставить в результирующий массив, начиная с конца
      // приемняем цикл for
      for(int start = 0, end = length - 1, k = length - 1; start <= end;) {
        // вычисляем площадь начального и конечного элементов - т. е. задаем квадраты
        int startSquare = nums[start] * nums[start];
        int endSquare = nums[end] * nums[end];
        // а теперь через if сравниваем квадраты, чтобы решить, какой из них будет следующим в результирующем массиве
        if(startSquare > endSquare) {
          // если начальный квадрат больше, помещаем его в следующую открытую позицию на "k",
          // затем увеличьте начальный указатель
          sortedSquares[k--] = startSquare;
          ++start;
          // } else if(endSquare >= startSquare) {
          } else {
          // а если конечный квадрат больше или равен, поместите его в следующую открытую позицию на "k",
          // затем уменьшите конечный указатель
          sortedSquares[k--] = endSquare;
          --end;
        }
      }
      // и возвращаем массив с отсортированными квадратами
      return sortedSquares;
    }
  }
}
/*
Временная сложность кода составляет O(n).
Доступ к каждому элементу массива numsосуществляется один раз в течение цикла while.
Несмотря на то, что имеется два указателя (i, j), движущихся навстречу друг другу с противоположных концов массива,
каждый из них перемещается не более чем на несколько nшагов.
Цикл заканчивается, когда они встречаются или пересекаются друг с другом, гарантируя,
что общее количество операций не превысит количество элементов в массиве.
 */
