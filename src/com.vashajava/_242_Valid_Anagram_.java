
/**
 * _242_Valid_Anagram_.
 *
 * @author Anton Shatkovskiy
 * @created 06.04.2024 г.
 */

/*

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 Example 1:

Input: s = "anagram", t = "nagaram"
Output: true

Example 2:

Input: s = "rat", t = "car"
Output: false

Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.

ПЕРЕВОД:

При наличии двух строк s и t верните значение true, если t является анаграммой s, и значение false в противном случае.
Анаграмма - это слово или фраза, образованные путем перестановки букв другого слова или фразы, обычно с использованием всех исходных букв ровно один раз.

Пример 1:

Ввод: s = "анаграмма", t = "нагарам"
Вывод: истина

Пример 2:

Ввод: s = "крыса", t = "автомобиль"
Вывод: ложь

Ограничения:

1 <= s.длина, t.длина <= 5 * 104
s и t состоят из строчных английских букв.

 */

public class _242_Valid_Anagram_ {

  public static void main(String[] args) {

    String s = "anagram";
    String t = "nagaram";

    Solution242 solution242 = new Solution242();
    System.out.println(solution242.isAnagram(s, t));

  }

  static class Solution242 {

    public boolean isAnagram(String s, String t) {
      // первое - проверяем обязательно длины строк, если длины разные, то  уже не анограмы
      if(s.length() != t.length()) {
        return false;
      }

      // создаем массив (счетчмк) для хранения количества символов английского алфавита - 26 букв, от 0
      int[] chatCount = new int[26];

      // проходимся по каждому символу циклом,
      // т. е. образаемся по индексу с пом. метода charAt(i)
      for (int i = 0; i < s.length(); i++) {
        // иттерируемся по первому слову
        // делаем 0, отняв 'a' и оборачиваем в [],
        // чтобы вызвать соотв элемент массива chatCount,
        // т. е. обращаемся при первой итерации к нулевому элементу массива,
        // т. е. мы встретили символ 'a' и хотим чтобы значение символа стало еденичкой
        // еденичкой в массиве стало
        // поэтому инкрементим, т. е. ++ - массив заполняется количеством символов, которое он встречает
        // если 'a' встр. 3 раза, то в массиве будет - 3
        chatCount[s.charAt(i) - 'a']++;
        // иттерируемся по второму слову
        // в этом случае, со второй строкой, уже декрементим,
        // т. е. отнимаем, к примеру - встречается буква 'n' - будет -1
        // т. е. вычитаем из нуля 1
        chatCount[t.charAt(i) - 'a']--;
      }

      // т. е., если слово анограмма, мы увидим что у нас все обнуляется
      // т. к. первый цикл по строке s - сначала прибалвяем, потом вычитаем,
      // но уже из строки t

      // далее пробегаемся по массиву циклом форейч
      for (int count : chatCount) {
        // если, пробегая по массиву в каком то месте у нас новый массив не ноль,
        // т. е. элементы разные, значит это не анограмма
        if (count != 0) return false;
      }
      // первая строка не отработала, значит анограмма, значит true
      return true;

    }
  }
}
