package math;

import com.sun.tools.javac.Main;
import java.sql.Array;

/**
 * _43_Multiply_Strings_.
 *
 * @author Anton Shatkovskiy
 * @created 28.05.2024 г.
 */

/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.

ПЕРЕВОД: 43. Ммножество строк.
При наличии двух неотрицательных целых чисел num1 и num2,
представленных в виде строк, возвращает произведение num1 и num2, также представленное в виде строки.

Примечание: Вы не должны использовать встроенную библиотеку BigInteger или преобразовывать входные данные в целое число напрямую.

Пример 1:

Ввод: num1 = "2", num2 = "3"
Вывод: "6"
Пример 2:

Ввод: num1 = "123", num2 = "456"
Вывод: "56088"

Ограничения:

1 <= num1.length, num2.length <= 200
num1 и num2 состоят только из цифр.
И num1, и num2 не содержат никакого начального нуля, за исключением самого числа 0.
 */

public class _43_Multiply_Strings_ {

  public static void main(String[] args) {

    String num1 = "2";
    String num2 = "3";

    Solution43 solution43 = new Solution43();
    System.out.println(solution43.multiply(num1, num2));

  }

  static class Solution43 {
    public String multiply(String num1, String num2) {
      // проверка наличия нуля: ни num1 ни num2 не являются "0", поэтому продолжаем
      // если любое из этих чисел равно 0, то результат будет равен 0
      if("0".equals(num1) || "0".equals(num2)) {
        return "0";
      }

      // получаем длины обеих чисел
      int lenght1 = num1.length();
      int lenght2 = num2.length();

      // инициализируем массив для сохранения результата перемножения каждой цифры
      int[] productArray = new int[lenght1 + lenght2];

      // далее перебираем каждую цифру в числах num1 и num2 и умножаем их
      // исп. циклы
      for (int i = lenght1 - 1; i >= 0; --i) {
        int digit1 = num1.charAt(i) - '0';
        // второй цикл
        for (int j = lenght2 - 1; j >= 0; --j) {
          int digit2 = num2.charAt(j) - '0';

          // добавляем произведение двух цифр в соответствующую позицию
          productArray[i + j + 1] += digit1 * digit2;
        }
      }

      // преобразовываем(нормализуем) productArray таким образом, чтобы каждая позиция представляла собой одну цифру
      // также исп. цикл
      for (int i = productArray.length -1; i > 0; --i) {
        // переносим десятки в следующую ячейку слева
        productArray[i - 1] += productArray[i] / 10;
        // сохраяем единицы измерения в текущей ячейке
        productArray[i] %= 10;
      }

      // пропускаем начальный 0 в массиве продуктов, если он существует,
      // делаем проверку, исп. тернарный оперетор
      int startIndex = productArray[0] == 0 ? 1 : 0;

      // и преобразуем массив product в строку,
      // исп. StringBuilder
      StringBuilder product = new StringBuilder();

      // опять исп. циклы
      for (int i = startIndex; i < productArray.length; i++) {
        // исп. библиотечная функция append(), который обновляет значение объекта
        product.append(productArray[i]);

      }
      // возвращаем product через toString
      return product.toString();
    }
  }
}
