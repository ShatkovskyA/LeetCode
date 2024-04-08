/**
 * _459_Repeated_Substring_Pattern_.
 *
 * @author Anton Shatkovskiy
 * @created 08.04.2024 г.
 */

/*
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Example 1:

Input: s = "abab"
Output: true
Explanation: It is the substring "ab" twice.

Example 2:

Input: s = "aba"
Output: false
Example 3:

Input: s = "abcabcabcabc"
Output: true
Explanation: It is the substring "abc" four times or the substring "abcabc" twice.

Constraints:

1 <= s.length <= 104
s consists of lowercase English letters.

ПЕРЕВОД:

Получив строку s, проверьте, можно ли ее сконструировать, взяв из нее подстроку и добавив несколько копий подстроки вместе.

Пример 1:

Ввод: s = "abab"
Вывод: true
Пояснение: это подстрока "ab", повторяющаяся дважды.

Пример 2:

Ввод: s = "aba"
Вывод: false
Пример 3:

Ввод: s = "abcabcabcabc"
Вывод: true
Пояснение: Это подстрока "abc" четыре раза или подстрока "abcabc" два раза.

Ограничения:

1 <= сек.длина <= 104
сек. состоит из строчных английских букв.

 */


public class _459_Repeated_Substring_Pattern_ {

  public static void main(String[] args) {

    String s = "abab";

    Solution459 solution459 = new Solution459();
    System.out.println(solution459.repeatedSubstringPattern(s));


  }

  static class Solution459 {
    public boolean repeatedSubstringPattern(String s) {

      return true;

    }
  }




}


