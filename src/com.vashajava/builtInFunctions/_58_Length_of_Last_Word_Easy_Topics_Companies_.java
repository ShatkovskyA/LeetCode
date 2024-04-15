package builtInFunctions;

/**
 * _58_Length_of_Last_Word_Easy_Topics_Companies_.
 *
 * @author Anton Shatkovskiy
 * @created 13.04.2024 г.
 */

/*
Given a string s consisting of words and spaces,
return the length of the last word in the string.

A word is a maximal substring
consisting of non-space characters only.

Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:

Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:

Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6.

Constraints:

1 <= s.length <= 104
s consists of only English letters and spaces ' '.
There will be at least one word in s.

ПЕРЕВОД: 58. Длина последнего слова
Если задана строка s, состоящая из слов и пробелов,
верните длину последнего слова в строке.

Слово - это максимальная подстрока,
состоящая только из символов без пробелов.

Пример 1:

Ввод: s = "Hello World"
Вывод: 5
Пояснение: Последнее слово - "Мир" длиной 5.

Пример 2:

Ввод: s = "полетай со мной на Луну"
Вывод: 4
Пояснение: Последнее слово - "луна" длиной 4.

Пример 3:

Ввод: s = "Луффи все еще джойбой"
Результат: 6
Пояснение: Последнее слово - "джойбой" длиной 6.

Ограничения:

1 <= s.длина <= 104
s. Состоит только из английских букв и пробелов ' '.
В s должно быть хотя бы одно слово.



 */
public class _58_Length_of_Last_Word_Easy_Topics_Companies_ {

  public static void main(String[] args) {

    String s = "luffy is still joyboy";

    Solution58 solution58 = new Solution58();
    System.out.println(solution58.lengthOfLastWord(s));

  }

  static class Solution58 {
    public int lengthOfLastWord(String s) {

      // находим количество слов в предложении, используя пробел.
      // вводим переменную
      int len = 0;

      // Метод trim() удаляет у строки пробелы с начала и с конца строки.
      // В данном коде последнее слово определяется именно за счет использования метода trim(),
      // который удаляет пробелы в начале и в конце строки.
      // Таким образом, если в строке есть пробелы до последнего слова,
      // они будут удалены, и в результате останется только последнее слово.
      String x = s.trim();

      // пробегаемся циклом по строке с удаленными пробелами с начала и конца строки
      for (int i = 0; i < x.length(); i++) {
        // тут если находим пробел
        if (x.charAt(i) == ' ')
          // переменная len обнуляется
          // далее, в цикле происходит перебор символов строки,
          // и если текущий символ равен пробелу, переменная len обнуляется.
          // Таким образом, при обнаружении пробела длина слова снова начинается с 0.
          // В конце цикла будет возвращено значение переменной len,
          // которая содержит количество букв в последнем слове строки.
          len = 0;
        else
          len++;
      }
      return len;
    }
  }

}
