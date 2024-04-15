package basicImplementation;

import java.util.HashMap;
import java.util.Map;

/**
 * _13_Roman_to_Integer_.
 *
 * @author Anton Shatkovskiy
 * @created 12.04.2024 г.
 */

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together.
12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.

Example 1:

Input: s = "III"
Output: 3
Explanation: III = 3.

Example 2:

Input: s = "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.

Example 3:

Input: s = "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

Constraints:

1 <= s.length <= 15
s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
It is guaranteed that s is a valid roman numeral in the range [1, 3999].

ПЕРЕВОД: 13. От римского к целому числу
Римские цифры обозначаются семью различными символами: I, V, X, L, C, D и M.

Значение символа
I 1
V 5
X 10
L 50
C 100
D 500
M 1000
Например, римскими цифрами 2 записывается как II, просто две единицы складываются вместе.
12 записывается как XII, что означает просто X + II. Число 27 записывается как XXVII, что означает XX + V + II.

Римские цифры обычно пишутся от наибольшего к наименьшему слева направо.
Однако число, обозначающее четыре, не является IIII.
Вместо этого число четыре записывается как IV.
Поскольку единица стоит перед пятью, мы вычитаем ее, и получается четыре.
Тот же принцип применим к числу девять, которое записывается как IX.
Существует шесть случаев, когда используется вычитание:

I можно поместить перед V (5) и X (10), чтобы получить 4 и 9.
X можно поместить перед L (50) и C (100), чтобы получить 40 и 90.
C можно поместить перед D (500) и M (1000), чтобы получить 400 и 900.
Получив римскую цифру, преобразуйте ее в целое число.

Пример 1:

Ввод: s = "III"
Вывод: 3
Пояснение: III = 3.

Пример 2:

Ввод: s = "LVIII"
Вывод: 58
Пояснение: L = 50, V= 5, III = 3.

Пример 3:

Входные данные: s = "MCMXCIV"
Выходные данные: 1994
Пояснение: M = 1000, CM = 900, XC = 90 и IV = 4.

Ограничения:

1 <= сек.длина <= 15
сек. содержит только символы ('I', 'V', 'X', 'L', 'C', 'D', 'M').
Гарантируется, что s является допустимой римской цифрой в диапазоне [1, 3999].

 */


public class _13_Roman_to_Integer_ {

  public static void main(String[] args) {

    String s = "III";

    Solution13 solution13 = new Solution13();
    System.out.println(solution13.romanToInt(s));

    }

    // решение включает в себя простой процесс, который использует хэш-таблицу
    // и алгоритм моделирования, основанный на правилах обращения с римскими цифрами.
  static  class Solution13 {
    public int romanToInt(String s) {

      // 1. определяем хэш-таблицу, которая сопоставляет каждый символ римской цифры с его целочисленным значением.
      // вводим строку, представляющую римские цифры в порядке возрастания.
      String romanSymbols = "IVXLCDM";
      // теперь отдельно вводим соответствующие значения римских цифр в соответствии с порядком в строке.
      int[] values = {1, 5, 10, 50, 100, 500, 1000};
      // определяем карту для хранения римских цифр и их значений для быстрого доступа.
      Map<Character, Integer> numeralToValue = new HashMap<>();
      // далее заполняем карту парами символ-значение через цикл;
      for (int i = 0; i < values.length; i++) {
        numeralToValue.put(romanSymbols.charAt(i), values[i]);
      }

      // 2. словарь готов. Далее задем переменную отр. длину строки с количеством символов для перембора
      int length = s.length();

      // 3. начинаем со значения последнего символа, так как после него нет ничего для сравнения.
      // карта.метод гет(строка.метод для получения символа из строки по индексу)
      int totalValue = numeralToValue.get(s.charAt(length - 1));

      // 4. для преобразования строки с римскими цифрами в целое число - перебираем строку по одному символу за раз, исследуя символ и тот,
      // который следует за ним (это попарное сравнение). Используем цикл for в сочетании с форматом выражения.
      // перебираем строку в обратном порядке, останавливаясь перед первым символом.
      for (int i = 0; i < length - 1; ++i) {
        // определяем знак, основываясь на том, меньше ли текущий символ следующего за ним.
        // это помогает применять правило вычитания римских цифр.
        // через тернарный оператор
        int sign = numeralToValue.get(s.charAt(i)) < numeralToValue.get(s.charAt(i + 1)) ? -1 : 1;
        // прибавляем или вычитаем значение текущего символа из общего значения.
        // т. е. берем либо -1 либо 1, умножаем на символ и прибавляем либо вычитаем из другого символа...
        totalValue += sign * numeralToValue.get(s.charAt(i));

      }

     // возвращаем вычисленное общее значение в виде целого числа, соответствующего введенной римской цифре.
      return totalValue;

    }
  }

}
