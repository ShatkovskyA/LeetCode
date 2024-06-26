package basicImplementation;

/**
 * basicImplementation._66_Plus_One_.
 *
 * @author Anton Shatkovskiy
 * @created 08.04.2024 г.
 */

/*

You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.

Example 1:
Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].

Example 2:
Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].

Example 3:
Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].

Constraints:

1 <= digits.length <= 100
0 <= digits[i] <= 9
digits does not contain any leading 0's.

ПЕРЕВОД:

Вам задано большое целое число, представленное в виде целого массива цифр, где каждая цифра [i] является i-й цифрой целого числа.
Цифры расположены слева направо в порядке от наиболее значимого к наименее значимому. Большое целое число не содержит начальных 0.
Увеличьте большое целое число на единицу и верните результирующий массив цифр.

Пример 1:

Входные данные: цифры = [1,2,3]
Выходные данные: [1,2,4]
Пояснение: Массив представляет собой целое число 123.
Увеличение на единицу дает 123 + 1 = 124.
Таким образом, результат должен быть равен [1,2,4].

Пример 2:

Ввод: цифры = [4,3,2,1]
Вывод: [4,3,2,2]
Пояснение: Массив представляет собой целое число 4321.
При увеличении на единицу получается 4321 + 1 = 4322.
Таким образом, результатом должно быть [4,3,2,2].

Пример 3:

Ввод: цифры = [9]
Результат: [1,0]
Пояснение: Массив представляет собой целое число 9.
При увеличении на единицу получается 9 + 1 = 10.
Таким образом, результат должен быть равен [1,0].

Ограничения:

1 <= цифры.длина <= 100
0 <= цифры[i] <= 9
цифр не содержат никаких начальных 0.
Словарь и онлайн перевод на английский, русский...
translate.yandex.ru
 */

public class _66_Plus_One_ {

  public static void main(String[] args) {

    int[] digits;
    digits = new int[]{1,2,3};

    Solution66 solution66 = new Solution66();
    solution66.plusOne(digits);

//    for (int i = 0; i < digits.length; i++) {
//      System.out.print(digits[i] + " ");
//    }

    for(int digitsout : digits) {
      System.out.println(digitsout);
    }

  }

  static class Solution66 {
    public int[] plusOne(int[] digits) {

      // создаем переменную, которая возвращает количество цифр в массивк
      int n = digits.length;

      // далее, применяем цикл, в котором начальное значение задает n - 1, т. к. в массиве не с 1 исчесление, а  нуля,
      // поэтому чтобы попасть на конечное число - вычитаем один,
      // применяется механизм LSD (least significant digit) — это вариант поразрядной сортировки,
      // при котором записи чисел выравниваются в сторону менее значащих цифр (по правой стороне, в сторону единиц) - т. е. 1, 2, 4, 10, 20 и т. д.
      // но цикл в обратном порядке, поэтому - декремент, т. к. цифры перебираются с варавниванием в сторону менее значищей цифры (LSD) - от большего к меньшему
      for (int i = n -1; i >= 0; --i) {
        // тут соотв. увеличиваемся на единицу
        digits[i]++;

        // если после увеличения цифра равна 10, это означает, что она должна быть равна 0, и мы переносим значение 1 - деление по модулю 10 % 10 = 0
        // Но если после увеличения значение не равно 10, мы можем немедленно вернуть результат - 9 % 10 = 1

        digits[i] %= 10;
        if (digits[i] != 0) {
          return digits;

        }
      }
      // здесь - это означает, что мы выполнили перенос из старшей цифры (MSD)
      // что требует от нас расширения массива. Пример: 999 + 1 = 1000
      int[] result = new int[n + 1];
      // станавливаем для первого элемента значение 1, для остальных - значение по умолчанию 0
      result[0] = 1;

      // возвращаем результат, содержащий дополнительную цифру
      return result;

    }
  }

}
