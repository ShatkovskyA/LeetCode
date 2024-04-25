package builtInFunctions;

import java.security.spec.RSAOtherPrimeInfo;

/**
 * _709_To_Lower_Case_.
 *
 * @author Anton Shatkovskiy
 * @created 13.04.2024 г.
 */

/*
Given a string s, return the string after replacing every uppercase
letter with the same lowercase letter.

Example 1:

Input: s = "Hello"
Output: "hello"

Example 2:

Input: s = "here"
Output: "here"

Example 3:

Input: s = "LOVELY"
Output: "lovely"

Constraints:

1 <= s.length <= 100
s consists of printable ASCII characters.

ПЕРЕВОД: 709. В нижний регистр
Учитывая строку s, верните строку после замены каждой
заглавной буквы на ту же строчную букву.

Пример 1:

Ввод: s = "Привет"
Вывод: "привет"

Пример 2:

Ввод: s = "здесь"
Вывод: "здесь"

Пример 3:

Ввод: s = "ПРЕКРАСНЫЙ"
Вывод: "прекрасный"

Ограничения:

1 <= сек.длина <= 100
сек. состоит из печатных символов ASCII.

 */

public class _709_To_Lower_Case_ {

  public static void main(String[] args) {

    String s = "Hello";

    Solution709 solution709 = new Solution709();
    System.out.println(solution709.toLowerCase(s));

  }

  static class Solution709 {
    public String toLowerCase(String s) {

      // сначала объявляем массив чаров, длиной в количество символов в строке.
      // toCharArray() — это встроенная функция Java, которая позволяет
      // преобразовать строку в массив символов, превращая каждый символ строки в элемент массива.
      char[] arr = s.toCharArray();

      // далее формируем цикл, чтобы пробежаться по массиву
      for (int i = 0; i < arr.length; i++) {
        // тут, в цикле реверсный символ кладем в него.
        char c = arr[i];
        // и услловие, если Character – это специальный "контейнер"
        // для хранения одного символа, например, буквы или цифры.
        // Он помогает работать с текстом, используя мощь Юникода,
        // чтобы понимать и представлять символы со всего мира
        // в общем и целом Character.isUpperCase () — в Java определяет,
        // находится ли указанное значение типа char в верхнем регистре (заглавной буквой)
        if(Character.isUpperCase(c)) {
          // если верхний регистр, то меняем
          arr[i] = Character.toLowerCase(c);
       } else if (Character.isLowerCase(c)) {
          // и наоборот, если нижний регистр, то меняем
          arr[i] = Character.toLowerCase(c);
        }
      }
      return new String(arr);
    }
  }
}
