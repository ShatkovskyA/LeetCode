package com.vashajava.hashtablestring;

/**
 * Класс _409_Longest_Palindrome_ - длинный палиандром.
 *
 * @author Anton Shatkovskiy
 * @created 27.06.2024 г.
 */

/*
Given a string s which consists of lowercase or uppercase letters, return the length of the longest
palindrome, that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.

ПЕРЕВОД: 409. Длинный палиандром.
Если задана строка s, состоящая из строчных или прописных букв, верните длину самого длинного
палиндрома, который можно составить из этих букв.

Буквы чувствительны к регистру, например, "Aa" не считается палиндромом.

Пример 1:

Ввод: s = "abccccdd"
Вывод: 7
Пояснение: Один из самых длинных палиндромов, который можно построить, - это "dccaccd", длина которого равна 7.
Пример 2:

Ввод: s = "a"
Вывод: 1
Пояснение: Самый длинный палиндром, который можно построить, - это буква "а", длина которой равна 1.

Ограничения:

1 <= сек.длина <= 2000
сек. состоит только из строчных и/или прописных английских букв.
 */
public class _409_Longest_Palindrome_ {

  public static void main(String[] args) {

    String s = "abccccdd";

    Solution409 solution409 = new Solution409();
    int longestPalindrome = solution409.longestPalindrome(s);
    System.out.println(longestPalindrome);
  }

  static  class Solution409 {
    public int longestPalindrome(String s) {
      // создаем массив для подсчета встречаемости каждого символа,
      // где в качестве индекса будет использоваться значение символа в формате ASCII - их как раз 128
      int[] charCounts = new int[128];
      // подключаем цикл для подсчета
      for(int i = 0; i < s.length(); i++) {
        // количества встречений каждого персонажа
        // где исп. библ. метод charAt() - для получения элемента по индексу
        charCounts[s.charAt(i)]++;
      }
      // задаем переменную для длины палиандрома
      int lengthOfLongestPalindrome = 0;
      // для быстрого доступа пробегаемся циклом for-each
      for(int count : charCounts) {
        // добавляем наибольшее четное число, меньшее или равное текущему количеству символов
        // это эквивалентно count - (count% 2)
        lengthOfLongestPalindrome += count - (count % 2);
        // если текущая длина палиндрома четная, а количество нечетное,
        // мы можем добавить еще один символ в центр палиндрома
        if(lengthOfLongestPalindrome % 2 == 0 && count % 2 == 1) {
          lengthOfLongestPalindrome++;
        }
      }
      // возвращаем в итоге длину как можно более длинного палиндрома
      return lengthOfLongestPalindrome;
    }
  }
}

/*
Временная сложность данного кода в первую очередь определяется обходом символов строки sи значений cntобъекта (счетчика).
Первая операция — создание счетчика частоты ( cnt) для символов в строке, Counter(s)который занимает O(n)время где n— длина строки s.
Вторая часть включает в себя перебор значений объекта cnt.
Количество уникальных символов в sбудет не более k, где k- размер набора символов (например,
26 для строчных английских букв и т. д.), таким образом, эта итерация равна O(k).
При объединении этих шагов, поскольку kэто может быть самое большее, nкогда все символы уникальны, общая временная сложность составит O(n).
 */
