package binarytreegeneral;

/**
 * _278_First_Bad_Version_.
 *
 * @author Anton Shatkovskiy
 * @created 20.06.2024 г.
 */

/*
You are a product manager and currently leading a team to develop a new product.
Unfortunately, the latest version of your product fails the quality check.
Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad.
Implement a function to find the first bad version. You should minimize the number of calls to the API.

Example 1:

Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.
Example 2:

Input: n = 1, bad = 1
Output: 1

Constraints:

1 <= bad <= n <= 231 - 1

ПЕРЕВОД: 278. Перввя плохая версия.
Вы являетесь менеджером по продукту и в настоящее время возглавляете команду по разработке нового продукта.
К сожалению, последняя версия вашего продукта не прошла проверку качества.
Поскольку каждая версия разрабатывается на основе предыдущей, все версии после неудачной версии также являются плохими.

Предположим, у вас есть версии [1, 2, ..., n], и вы хотите найти первую плохую версию, которая приводит к тому, что все последующие становятся плохими.

Вам предоставляется API bool isBadVersion(версия), который возвращает, является ли версия плохой.
Реализуйте функцию для поиска первой плохой версии. Вам следует минимизировать количество обращений к API.

Пример 1:

Входные данные: n = 5, плохие = 4
Выходные данные: 4
Объяснение:
вызов isBadVersion(3) -> ложный
вызов isBadVersion(5) -> истинный
вызов isBadVersion(4) -> true
Тогда 4 - это первая неверная версия.
Пример 2:

Входные данные: n = 1, bad = 1
Выход: 1

Ограничения:

1 <= плохо <= n <= 231 - 1

 */
public class _278_First_Bad_Version_ {

  public static void main(String[] args) {

    int n = 5;
    int bad = 4;

    Solution278 solution278 = new Solution278(bad);
//    int firstBBV = solution278.firstBadVersion(n);
//    System.out.println(firstBBV);
    System.out.println(solution278.firstBadVersion(n));

  }

  /* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);

      API isBadVersion определен в системе управления версиями родительского класса.
      Логическое значение isBadVersion(int version);
      */
  static public class VersionControl {
    private int badVersion;

    public VersionControl(int badVersion) {
      this.badVersion = badVersion;
    }

    boolean isBadVersion(int version) {
      return version >= badVersion;
    }

//    boolean isBadVersion(int version) {
//      return true;
//    }
  }


  static public class Solution278 extends VersionControl {


    public Solution278(int badVersion) {
      super(badVersion);
    }

    /**
     * Находит первую неверную версию.
     *
     * @param - Общее количество версий.
     * @return номер первой неверной версии.
     */
    public int firstBadVersion(int n) {
      // традиционно вводим и инициализируем указатели начала и конца для бинарного поиска
      int start = 1;
      int end = n;

      // вводим цикл while
      // продолжаем поиск, пока в ассортименте есть более одной версииц
      while (start < end) {
        // опять же вычисляем среднюю версию текущего диапазона
        // и используем оператор сдвига вправо без знака, чтобы избежать переполнения целых чисел
        // int mid = (start + end) >> 1;
        int mid = start + (end - start) / 2;

        //  теперь проверка, не является ли средняя версия, которую мы вычислили - плохая
        if (isBadVersion(mid)) {
          // если средняя версия плохая, то перед ней находится первая плохая версия
          // или это сама первая плохая версия
          end = mid;
        } else {
          //  в противном случае
          // если средняя версия хорошая, то первая плохая версия
          // должно быть, после этого
          start = mid + 1;
        }
      }
      // на данный момент start == end, и это первая плохая версия
      return start;
    }
  }
}

/*
Временная сложность этого алгоритма составляет O(log n).
Это связано с тем, что при каждом сравнении пространство поиска фактически уменьшается вдвое, что является характеристикой бинарного поиска.
Таким образом, количество сравнений, необходимых для поиска цели, пропорционально логарифму общего числа версий n.
 */
