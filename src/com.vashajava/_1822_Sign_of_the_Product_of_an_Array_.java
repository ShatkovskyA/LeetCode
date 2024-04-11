/**
 * _1822_Sign_of_the_Product_of_an_Array_.
 *
 * @author Anton Shatkovskiy
 * @created 10.04.2024 г.
 */

/*
There is a function signFunc(x) that returns:

1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.

Return signFunc(product).

Example 1:

Input: nums = [-1,-2,-3,-4,3,2,1]
Output: 1
Explanation: The product of all values in the array is 144, and signFunc(144) = 1

Example 2:

Input: nums = [1,5,0,2,-3]
Output: 0
Explanation: The product of all values in the array is 0, and signFunc(0) = 0

Example 3:

Input: nums = [-1,1,-1,1,-1]
Output: -1
Explanation: The product of all values in the array is -1, and signFunc(-1) = -1

Constraints:

1 <= nums.length <= 1000
-100 <= nums[i] <= 100

ПЕРЕВОД: 1822. Знак произведения массива
Существует функция со знаком Func(x), которая возвращает:

1, если x положительно.
-1, если x отрицательно.
0, если x равно 0.

Вам задан целочисленный массив nums.
Пусть product - это произведение всех значений в массиве nums.
Возвращает значение signFunc(product).

Пример 1:

Ввод: nums = [-1,-2,-3,-4,3,2,1]
Вывод: 1
Пояснение: Произведение всех значений в массиве равно 144, а значение signFunc(144) = 1

Пример 2:

Входные данные: nums = [1,5,0,2,-3]
Выходные данные: 0
Пояснение: Произведение всех значений в массиве равно 0, а signFunc(0) = 0

Пример 3:

Ввод: nums = [-1,1,-1,1,-1]
Вывод: -1
Пояснение: Произведение всех значений в массиве равно -1, а signFunc(-1) = -1

Ограничения:

1 <= числа.длина <= 1000
-100 <= числа[i] <= 1

 */

public class _1822_Sign_of_the_Product_of_an_Array_ {

  public static void main(String[] args) {

    int[] nums;
    nums = new int[]{-1, -2, -3, -4, 3, 2, 1};

    Solution1822 solution1822 = new Solution1822();
//    solution1822.arraySign(nums);

    System.out.println(solution1822.arraySign(nums));

//    for (int i = 0; i < digits.length; i++) {
//      System.out.print(digits[i] + " ");
//    }

//    for (int numsout : nums) {
//      System.out.println(numsout);
//
//    }
  }

  // не нужно вычислять фактическое произведение, потому что нас интересует только знак.
// Таким образом, мы можем использовать эти правила для определения знака, перебирая массив и отслеживая две вещи:
// встретили ли мы ноль, и количество отрицательных чисел.
  static class Solution1822 {

    /**
     * Определяет знак произведения массива чисел. Результат равен 1, если произведение положительное, -1, если отрицательное, и 0, если
     * любое число равно 0.
     *
     * @param // нумеруется массив целых чисел
     * @возвращает знак произведения входного массива
     */
    public int arraySign(int[] nums) {

      // инициализация переменной для отслеживания знака "аккумулятор знака", инициализируем как положительный
      int batterySign = 1;

      // выполняем итерацию в цикле, где проверяется каждое значение в массиве
      // for(int i = 0; i < nums.length; i++) {
      for (int value : nums) {
        // Если какое-либо число равно нулю, то и произведение равно нулю, поэтому верните 0
        if (value == 0) {
          return 0;
          // если число отрицательное, переверните текущий знак
        } else if (value < 0) {
          // тут смотрим на произведение
          batterySign *= -1;
        }
      }
      // возвращаем изначальный знак
      return batterySign;
    }
  }
}
