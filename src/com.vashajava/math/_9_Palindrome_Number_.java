package com.vashajava.math;

/**
 * Класс _9_Palindrome_Number_ - номер палиандрома.
 *
 * @author Anton Shatkovskiy
 * @created 22.07.2024 г.
 */

/*
Given an integer x, return true if x is a palindrome, and false otherwise.

Example 1:

Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.
Example 2:

Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Constraints:

-231 <= x <= 231 - 1

Follow up: Could you solve it without converting the integer to a string?

ПЕРЕВОД: 9. Номер палиандрома.
Если задано целое число x, верните значение true, если x является палиндромом, и значение false в противном случае.

Пример 1:

Входные данные: x = 121
Выходные данные: true
Пояснение: 121 читается как 121 слева направо и справа налево.
Пример 2:

Ввод: x = -121
Вывод: false
Пояснение: Слева направо значение равно -121. Справа налево значение равно 121-. Следовательно, это не палиндром.
Пример 3:

Ввод: x = 10
Вывод: false
Пояснение: Читается 01 справа налево. Следовательно, это не палиндром.

Ограничения:

-231 <= x <= 231 - 1

Уточнение: Не могли бы вы решить это без преобразования целого числа в строку?
 */
public class _9_Palindrome_Number_ {

  public static void main(String[] args) {

    int x = 121;
    Solution9 solution9 = new Solution9();
    Boolean isPalindrome = solution9.isPalindrome(x);
    System.out.println(isPalindrome);
  }

  static class Solution9 {

    public boolean isPalindrome(int x) {
      // тут сперва проверка основный условий:
      // - любое отрицательное число не может быть палиндромом
      // - если последняя цифра равна 0 (т. е. это кратно 10), число не может быть палиндромом
      // - или только само число не равно 0
      if(x < 0 || (x !=0 && x % 10 == 0)) {
        return false;
      }
      // вводим переменную для переворачивания, инициализируем нулем - т. е. это перевернутое
      int reversedHalf = 0;

      // теперь цикл while, при котором - нужно перевернуть только половину числа, чтобы сравнить с другой половиной
      // и если исходное число меньше перевернутого, это означает, что обработали половину цифр
      // т. е. пока число больше перевертыша, то
      while (x > reversedHalf) {
        // извлекаем последнюю цифру числа и перемещаем ее на место десятки (десятичное место) в перевернутой половине
        reversedHalf = reversedHalf * 10 + x % 10;
        // и удаляем последнюю цифру из исходного номера
        x /= 10;
      }
      // в конце цикла есть два случая:
      // 1. Длина числа нечетная, и тогда нужно отбросить среднюю цифру на обратную половину / 10
      // 2. Длина числа четная, и перевернутая половина должна быть равна этому числу

      return x == reversedHalf || x == reversedHalf / 10;

    }
  }
}

/*
Временная сложность данного кода равна O(n), где n– количество цифр во входном целом числе x.
Это связано с тем, что цикл выполняется до тех пор, пока перевернутое число yне станет больше или равно входному номеру x,
что происходит после n/2итераций в худшем случае (когда целое число является палиндромом).
 */
