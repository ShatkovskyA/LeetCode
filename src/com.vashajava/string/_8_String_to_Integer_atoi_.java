package com.vashajava.string;

/**
 * _8_String_to_Integer_atoi_.
 *
 * @author Anton Shatkovskiy
 * @created 05.11.2024 г.
 */

/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer.

The algorithm for myAtoi(string s) is as follows:

Whitespace: Ignore any leading whitespace (" ").
Signedness: Determine the sign by checking if the next character is '-' or '+', assuming positivity if neither present.
Conversion: Read the integer by skipping leading zeros until a non-digit character is encountered or the end of the string is reached.
If no digits were read, then the result is 0.
Rounding: If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then round the integer to remain in the range.
Specifically, integers less than -231 should be rounded to -231, and integers greater than 231 - 1 should be rounded to 231 - 1.
Return the integer as the final result.

Example 1:
Input: s = "42"
Output: 42

Explanation:

The underlined characters are what is read in and the caret is the current reader position.
Step 1: "42" (no characters read because there is no leading whitespace)
         ^
Step 2: "42" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "42" ("42" is read in)
           ^
Example 2:
Input: s = " -042"
Output: -42

Explanation:

Step 1: "   -042" (leading whitespace is read and ignored)
            ^
Step 2: "   -042" ('-' is read, so the result should be negative)
             ^
Step 3: "   -042" ("042" is read in, leading zeros ignored in the result)
               ^
Example 3:
Input: s = "1337c0d3"
Output: 1337

Explanation:

Step 1: "1337c0d3" (no characters read because there is no leading whitespace)
         ^
Step 2: "1337c0d3" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "1337c0d3" ("1337" is read in; reading stops because the next character is a non-digit)
             ^
Example 4:

Input: s = "0-1"

Output: 0

Explanation:

Step 1: "0-1" (no characters read because there is no leading whitespace)
         ^
Step 2: "0-1" (no characters read because there is neither a '-' nor '+')
         ^
Step 3: "0-1" ("0" is read in; reading stops because the next character is a non-digit)
          ^
Example 5:

Input: s = "words and 987"

Output: 0

Explanation:

Reading stops at the first non-digit character 'w'.

Constraints:

0 <= s.length <= 200
s consists of English letters (lower-case and upper-case), digits (0-9), ' ', '+', '-', and '.'.

ПЕРЕВОД: 8. Преобразование строки в целое число (atoi).
Реализуйте функцию myAtoi(string s), которая преобразует строку в 32-разрядное целое число со знаком.

Алгоритм для myAtoi(string s) следующий:

Пробелы: игнорируйте все начальные пробелы (" ").
Знаковость: Определите знак, проверив, является ли следующий символ "-" или "+", предполагая положительный результат, если ни один из них не присутствует.
Преобразование: Считывайте целое число, пропуская начальные нули, пока не встретится нецифровой символ или пока не будет достигнут конец строки.
Если ни одна цифра не была прочитана, то результат равен 0.
Округление: Если целое число выходит за пределы диапазона 32-разрядных целых чисел со знаком [-231, 231 - 1], округлите целое число,
чтобы оно оставалось в этом диапазоне.
В частности, целые числа, меньшие, чем -231, должны быть округлены до -231, а целые числа, большие, чем 231 - 1, должны быть округлены до 231 - 1.
Верните целое число в качестве конечного результата.

Пример 1:
Ввод: s = "42"
Выход: 42

Объяснение:

Подчеркнутые символы - это те, которые считываются, а курсор - текущее положение считывателя.
Шаг 1: "42" (символы не считываются, поскольку нет начального пробела)
         ^
Шаг 2: "42" (символы не читаются, поскольку нет ни "-", ни "+")
         ^
Шаг 3: "42" ("42" читается внутри)
           ^
Пример 2:
Ввод: s = "-042"
Выход: -42

Объяснение:

Шаг 1: "-042" (начальный пробел считывается и игнорируется)
            ^
Шаг 2: "-042" (считывается "-", поэтому результат должен быть отрицательным)
             ^
Шаг 3: "-042" (считывается "042", начальные нули в результате игнорируются)
               ^
Пример 3:
Ввод: s = "1337c0d3"
Вывод: 1337

Объяснение:

Шаг 1: "1337c0d3" (символы не читаются, поскольку нет начального пробела)
         ^
Шаг 2: "1337c0d3" (символы не читаются, поскольку нет ни "-", ни "+")
         ^
Шаг 3: "1337c0d3" (считывается "1337"; чтение прекращается, поскольку следующий символ не является цифрой)
             ^
Пример 4:

Ввод: s = "0-1"

Вывод: 0

Объяснение:

Шаг 1: "0-1" (символы не читаются, так как нет начального пробела)
         ^
Шаг 2: "0-1" (символы не читаются, поскольку нет ни "-", ни "+")
         ^
Шаг 3: "0-1" (считывается "0"; чтение прекращается, поскольку следующий символ не является цифрой)
          ^
Пример 5:

Ввод: s = "слова и 987"

Выход: 0

Объяснение:

Чтение останавливается на первом нецифровом символе "w".

Ограничения:

0 <= сек.длина <= 200
сек. состоит из английских букв (строчных и прописных), цифр (0-9), ' ', '+', '-', и '.'.

 */
public class _8_String_to_Integer_atoi_ {

  public static void main(String[] args) {

    String s = "42";

    Solution8 solution8 = new Solution8();
    int myAtoi = solution8.myAtoi(s);
    System.out.println(myAtoi);

  }

  static class Solution8 {
    public int myAtoi(String s) {

      // проверка, что входная строка не равна null
      if(s == null) {
        return 0;
      }
      // I. Инициализация.
      int length = s.length();

      // если строка пуста, возвращаем 0 - равенство 0, т. к. уже int
      if(length == 0) {
        return 0;
      }

      // вводим переменную и инициализируем нулем индекс - это своего рода счетчик
      int index = 0;
      // II. Пропуск пробела.
      // пропускаем пробельные элементы(символы) - т. е. пока индекс(счетчик) меньше длины, и эдемент равен проблеу - то счетчик увеличиваем,
      // где charAt(index) - это "заводской", библиотечный метод для поиска получения элемента(ну или же символа)
    while (index < length && s.charAt(index) == ' ') {
      index++;
    }

      // если дошли до конца строки после пропуска пробелов, вернем 0
      if(index == length) {
        return 0;
      }

      // III. Обнаружение знака.
      // тут определяем знак на основе текущего элемента
      // вводим переменную-флаг для знака
      int sign = 1;
      // опять используем charAt(index) - т. е. если элемент равен минус, то флажок -1 и увеличиваем счетчик
      if(s.charAt(index) == '-') {
        sign = -1;
        index++;
        // в противном случае, если плюс, то флажок остается тот же 1, но счетчик тоже увеличивается
      } else if(s.charAt(index) == '+') {
        index++;
      }

      // объявляем переменную для результата
      int res = 0;

      // IV. Обработка переполнения.
      // предварительно рассчитываем пороговое значение для проверки на переполнение, что значит,
      // переменная treeshold будет содержать значение, которое равно максимально возможному значению для типа данных Integer, деленному на 10.
      // В данном случае, это будет значение 214748364.
      int treeshold = Integer.MAX_VALUE / 10;

      // V. Преобразование целых чисел.
      while (index < length) {
        // тут просто берем из строки элемент и присваиваем его символу, т. е. он становится символом
        char currentChar = s.charAt(index);

        // прерываем, если текущий символ не является цифрой (цифра - это от 0 до 9)
        if(currentChar < '0' || currentChar > '9') {
          break;
        }

        // опять проверяем, нет ли переполнения при добавлении новой цифры,
        // где (поскольку 2**31 - 1 заканчивается на 7)
        if(res > treeshold || (res == treeshold && currentChar > '7')) {
          // тернарный оператор
          return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        // обновляем результат новой цифрой
        res = res * 10 + (currentChar - '0');
        index++;
      }
      // VI. Возврат результата.
      // применяем определенный знак к результату и возвращаем, sign - это переменная-флаг для знака
      return sign * res;
    }
  }
}

/*
Временная сложность данной функции равна O(n), где n - длина строки. Вот разбивка:

Мы выполняем итерацию один раз по строке для обрезки пробелов, что выполняется O(n) в худшем случае (если все символы являются пробелами).
Проверка того, является ли символ знаком ('+' или '-') O(1).
Следующий цикл while выполняет итерацию по остальной части строки, но он выполняется не более n раз, что также является O(n) наихудшим случаем.
Каждая операция внутри цикла while, включая проверку того, является ли символ цифрой, преобразование его в целое число,
проверку на переполнение и обновление результата, выполняется за постоянное время O(1).
Следовательно, доминирующим фактором временной сложности является длина строки n, что приводит к O(n) общему.
 */
