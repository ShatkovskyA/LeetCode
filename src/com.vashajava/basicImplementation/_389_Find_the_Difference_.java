package basicImplementation;

/**
 * basicImplementation._389_Find_the_Difference_.
 *
 * @author Anton Shatkovskiy
 * @created 06.04.2024 г.
 */

/*
You are given two strings s and t.
String t is generated by random shuffling string s and then add one more letter at a random position.
Return the letter that was added to t.

Example 1:

Input: s = "abcd", t = "abcde"
Output: "e"
Explanation: 'e' is the letter that was added.

Example 2:
Input: s = "", t = "y"
Output: "y"

Constraints:

0 <= s.length <= 1000
t.length == s.length + 1
s and t consist of lowercase English letters.

ПЕРЕВОД: 389. Найдите разницу.

Вам даны две строки s и t.
Строка t генерируется путем случайного перетасовывания строк, а затем добавления еще одной буквы в случайном месте.
Возвращает букву, которая была добавлена к t.

Пример 1:
Ввод: s = "abcd", t = "abcde"
Вывод: "e"
Пояснение: "e" - это буква, которая была добавлена.

Пример 2:
Ввод: s = "", t = "y"
Вывод: "y"

Ограничения:
0 <= s.длина <= 1000
t.длина == s.длина + 1
s и t состоят из строчных английских букв.
 */

public class _389_Find_the_Difference_ {

  public static void main(String[] args) {

    String s = "abcd";
    String t = "abcde";

    Solution389 solution389 = new Solution389();
    System.out.println(solution389.findTheDifference(s, t));

  }

  static class Solution389 {

    public char findTheDifference(String s, String t) {

      // создаем массив (счетчмк) для хранения количества символов алфавита в строке s
      int[] count = new int[26];

      // увеличиваем количество для каждого символа в первой строке s
      for (int i = 0; i < s.length(); i++) {
        // s.charAt(i) - 'a' преобразует символ c в индекс (0-25), соответствующий символам 'a'-'z', в строчке s
        count[s.charAt(i) - 'a']++;
      }

      // выполняем итерацию для второй строке t
      for (int i = 0; i < t.length(); i++) {
        // уменьшаем количество символов для текущего символа
        // если счетчик count становится отрицательным, мы находим дополнительный символ в t
        // иными словами, если значение меньше нуля, это означает, что в 't' есть дополнительный символ, которого нет в 's'
        if (--count[t.charAt(i) - 'a'] < 0) {
          return t.charAt(i);
        }
      }
        // return является заполнителем; логика кода гарантирует, что функция выполнит возврат из цикла.
        // т. к. известно, что в строке t есть один дополнительный символ,
        // цикл всегда будет возвращать этот дополнительный символ до этого момента.
        // значит, код никогда не достигнет этой инструкции, но синтаксис Java требует здесь инструкции return.
        return '\0';

      }
    }
  }


//      // можно использовать цикл while или же for
//      // задаем начальное значение
//     int sum = 0;
//
//      for(int i = 0; i < s.length(); i++) {
//        // метод charAt(i) находит символ в указанной позиции
//        sum += s.charAt(i);
//
//      }
//
////      // сначала для s
////      for(int i = 0; i < s.length(); i++) {
////        // метод charAt(i) находит символ в указанной позиции
////        sum += s.charAt(i);
////      }
//
//      // далее для t
//      for(int i = 0; i < t.length(); i++) {
//        // метод charAt(i) находит символ в указанной позиции
//        sum -= t.charAt(i);
//      }
//
//      // выводим конечную сумму, приведя к чару, т. е. в первом методе прибавляем к сумме символ, во втором вычитаем и выводим полученную сумму
//      return (char) sum;
//
//      // return replaceAll("ĥ", "e")
//
//       }

//      count = {}
//
//      for char in t:
//      if char in count:
//      count[char] += 1
//        else:
//      count[char] = 1
//
//      for char in s:
//      count[char] -= 1
//      if count[char] == 0:
//      del count[char]
//
//      return list(count.keys())[0]




