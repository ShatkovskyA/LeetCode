package twopointers;

/**
 * _125_Valid_Palindrome_.
 *
 * @author Anton Shatkovskiy
 * @created 06.06.2024 г.
 */

/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:

Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.
Example 2:

Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.
Example 3:

Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.

ПЕРЕВОД: 125. Допустимый палиандром.
Фраза является палиндромом, если после преобразования всех прописных букв в строчные и удаления всех не алфавитно-цифровых символов
она читается одинаково как в прямом, так и в обратном порядке. Буквенно-цифровые символы включают буквы и цифры.

Если задана строка s, верните значение true, если это палиндром, или false в противном случае.

Пример 1:

Ввод: s = "Человек, план, канал: Панама"
Вывод: true
Пояснение: "amanaplanacanalpanama" - это палиндром.
Пример 2:

Ввод: s = "гоночный автомобиль"
Вывод: false
Пояснение: "гоночный автомобиль" не является палиндромом.
Пример 3:

Ввод: s = " "
Вывод: true
Пояснение: s - это пустая строка "" после удаления не буквенно-цифровых символов.
Поскольку пустая строка читается одинаково как в прямом, так и в обратном направлении, это палиндром.

Ограничения:

1 <= сек.длина <= 2 * 105
сек. состоит только из символов ASCII, пригодных для печати.
 */

public class _125_Valid_Palindrome_ {

  public static void main(String[] args) {

    String s = "A man, a plan, a canal: Panama";

    Solution125 solution125 = new Solution125();
    boolean isPalindrome = solution125.isPalindrome(s);
    System.out.println(isPalindrome);

  }

  /*
  Временная сложность алгоритма равна O (n), где n - длина строки, поскольку требуется один проход по строке.
   */
  static class Solution125 {

    /**
     * Проверьте, является ли данная строка палиндромом, используя только буквенно-цифровые символы и игнорируя регистры.
     *
     * @param определяет входную строку, которую нужно проверить на наличие палиндрома.
     * @return логическое значение, указывающее, является ли входная строка палиндромом.
     */
    public boolean isPalindrome(String s) {

      // инициализируем два указателя, чтобы пробегаться с двух сторон и сравнивать, пробегаемся навстрчу друг другу
      // инициализируем два указателя
//      int i = 0;
//      int j = 0;

      // или же так
      int leftIndex = 0;
      // это правый указатель!, т. е. начало справа, т. к. отсчет с нуля
      int rightIndex = s.length() - 1;

      // теперь вводим цикл while с условием
      // сравниваем символы, пока левый индекс меньше правого
      while (leftIndex < rightIndex) {
        // проверям и сравниваем символы
        // если символ в левом указателе не является буквенно-цифровым, переместите левый указатель вправо
        // тут все методы библиотченые, charAt - возвращает значение char по указанному индексу,
        // isLetterOrDigit - проверяет, является ли символ буквой или цифрой Unicode
        // Character - символная оболочка
        if (!Character.isLetterOrDigit(s.charAt(leftIndex))) {
          leftIndex++;
        }
        // аналгично, если символ с правым индексом не является буквенно-цифровым, переместите правый указатель влево
        else if (!Character.isLetterOrDigit(s.charAt(rightIndex))) {
          rightIndex--;
        }
        // затем, если символы в обоих индексах являются буквенно-цифровыми, сравните их, игнорируя регистр
        // toLowerCase -делает все буквы в строке строчными, сравниваем, т. е одно если не равно другому, то false
        else if (Character.toLowerCase(s.charAt(leftIndex)) != Character.toLowerCase(s.charAt(rightIndex))) {
          // и если символы не совпадают, это не палиндром
          return false;
        } else {
          // если же символы совпадают, то перемещаем два указателя навстречу друг другу
          leftIndex++;
          rightIndex--;
        }
      }
      //  в противном случае, если все буквенно-цифровые символы были успешно сопоставлены, то это палиндром
      return true;
    }
  }
}
