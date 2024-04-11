import java.util.Arrays;

/**
 * _1502_Can_Make_Arithmetic_Progression_From_Sequence_.
 *
 * @author Anton Shatkovskiy
 * @created 10.04.2024 г.
 */

/*
A sequence of numbers is called an arithmetic progression if the difference between any two consecutive elements is the same.

Given an array of numbers arr, return true if the array can be rearranged to form an arithmetic progression. Otherwise, return false.

Example 1:

Input: arr = [3,5,1]
Output: true
Explanation: We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.

Example 2:

Input: arr = [1,2,4]
Output: false
Explanation: There is no way to reorder the elements to obtain an arithmetic progression.

Constraints:

2 <= arr.length <= 1000
-106 <= arr[i] <= 106

ПЕРЕВОД:

Последовательность чисел называется арифметической прогрессией, если разница между любыми двумя последовательными элементами одинакова.
Если задан массив чисел arr, верните значение true, если массив можно перестроить, чтобы сформировать арифметическую прогрессию.
В противном случае верните значение false.

Пример 1:

Входные данные: arr = [3,5,1]
Выходные данные: true
Пояснение: Мы можем изменить порядок элементов в виде [1,3,5] или [5,3,1] с разницей в 2 и -2 соответственно между каждым последующим элементом.

Пример 2:

Ввод: arr = [1,2,4]
Вывод: false
Пояснение: Невозможно изменить порядок элементов, чтобы получить арифметическую прогрессию.

Ограничения:

2 <= обход.длина <= 1000
-106 <= обход[i] <= 106

 */
public class _1502_Can_Make_Arithmetic_Progression_From_Sequence_ {

  public static void main(String[] args) {

    int[] arr;
    arr = new int[]{3,5,1};

    Solution1502 solution1502 = new Solution1502();
    // solution1502.canMakeArithmeticProgression(arr);

    System.out.println(solution1502.canMakeArithmeticProgression(arr));

//    for (int i = 0; i < digits.length; i++) {
//      System.out.print(digits[i] + " ");
//    }

//    for (int arrout : arr) {
//      System.out.println(arrout);
//
//    }

  }

  // здесь сначала надо отсортировать, потом надо пройтись циклом по всем элементам с условием
  // сортировка дает возможность видеть - возможно ли прогрессия или нет
  static class Solution1502 {

    // O(n log n) - только из за операция сортировки
    // функция для проверки возможности построения арифметической прогрессии
    public boolean canMakeArithmeticProgression(int[] arr) {

      // 1. Сортировка массива. Сортировка с помощью библиотечного метода - класс Arrays, метод sort.
      // сортируем массив в порядке неубывания
      Arrays.sort(arr);

     // 2. Находим общее различие
      // находим общее различие "difference", вычитая из второго первый элемент по индексу
      int diff = arr[1] - arr[0];

      // 3. Проверка прогрессии
      // выполняем итерацию по отсортированному массиву, начиная с третьего элемента - в цикле (2 в массиве - это 3)
      for (int i = 2; i < arr.length; ++i) {
        // тут проверяем, равна ли текущая разница общей разнице 'int diff'
        // если нет, верните значение false, поскольку оно не может образовывать арифметическую прогрессию

        if (arr[i] - arr[i - 1] != diff) {
          return false;
        }
      }
      // если цикл завершается без возврата значения false, это означает,
      // что массив может образовывать арифметическую прогрессию
      return true;
    }
  }
}
