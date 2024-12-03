package com.vashajava.sorting;

import java.util.Arrays;

/**
 * _274_H_Index_.
 *
 * @author Anton Shatkovskiy
 * @created 02.12.2024 г.
 */

/*
Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper,
return the researcher's h-index.

According to the definition of h-index on Wikipedia:
The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.

Example 1:
Input: citations = [3,0,6,1,5]
Output: 3
Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.

Example 2:
Input: citations = [1,3,1]
Output: 1

Constraints:

n == citations.length
1 <= n <= 5000
0 <= citations[i] <= 1000

ПЕРЕВОД: 274. H-Индекс.
Что такое H-Индекс: Ученый имеет индекс, h если h в его {" " "} n статьях есть по крайней мере h цитаты каждая,
а в других n − h статьях не более h ссылок в каждой. Или же: Индекс Хирша — это метрика, используемая для оценки продуктивности и влияния исследователя или публикаций.
Он определяется как наибольшее число h, такое что у исследователя есть как минимум h публикаций, каждая из которых цитировалась не менее h раз.

Учитывая массив целых чисел citations, где citations[i] - количество цитирований, полученных исследователем за свою популярную статью,
возвращает индекс хирша исследователя.

Согласно определению индекса хирша в Википедии:
Индекс хирша определяется как максимальное значение h, при котором данный исследователь опубликовал не менее h статей, каждая из которых цитировалась не менее h раз.

Пример 1:
Входные данные: цитаты = [3,0,6,1,5]
Выходные данные: 3
Пояснение: [3,0,6,1,5] означает, что у исследователя всего 5 статей, и каждая из них получила 3, 0, 6, 1, 5 цитат соответственно.
Поскольку у исследователя есть 3 статьи, в каждой из которых приведено не менее 3 цитат, а в оставшихся двух - не более 3 ссылок, их индекс хирша равен 3.

Пример 2:
Входные данные: цитаты = [1,3,1]
Выходные данные: 1

Ограничения:

n == цитат.длина
1 <= n <= 5000
0 <= количество цитат[i] <= 1000
 */
public class _274_H_Index_ {

  public static void main(String[] args) {

    int[] citations = {3, 0, 6, 1, 5};

    Solution274 solution274 = new Solution274();
    int hIndex = solution274.hIndex(citations);
    System.out.println(hIndex);
  }

  // II - тут решение сортировкой, в классическом виде, сначала сортируем заводской сортировкой, потом пробегаемся циклом
  static class Solution274 {
    public int hIndex(int[] citations) {
      // обратная сортировка int[] в Java вызывает раздражение
      // для начала выполняем обычную сортировку, а затем меняем массив на обратный
      // сортируем "заводской" библиотечной функцией - в порядке возрастания
      Arrays.sort(citations);
      // далее после перрвой сортировки, пробегаемся циклом для, т. н. разворота массива, чтобы у нас все отсиртировалос в порядке убывание,
      // путем обмена элементов с начала и конца массива
      for(int i = 0; i < citations.length/2; i++) {
        // вводим переменную и к i-у элементу
        int tmp = citations[i];
        // тут высчитываем i-ый элемент
        citations[i] = citations[citations.length - 1 - i];
        // тут меняем местами
        citations[citations.length - 1 - i] = tmp;
      }
      // далее считаем индекс Хирша
      // вводим переменную для индекса Хирша и инициализируем нулем
      int h = 0;
      // и циклом, т. е. пока индекс меньше длины массивы цитат - цикл продолжается до максимального значения, и,
      // удовлетворяет ли текущее значение h условию индекса Хирша: количество цитирований citations[h] должно быть не меньше h+1
      while (h < citations.length && citations[h] >= h + 1) {
        // индекс увеличиваем, если выполняется условие
        h++;
      }
      // далее и возвращаем этот индекс
      return h;
    }
  }

  // I - тут решение сортировкой более подробное, соротирвка не заводская
//  class Solution {
//    static boolean hasAtLeastHPapersWithHCitations(int h, int[] citations) {
//      int count = 0;
//      for (int cite_count : citations) {
//        if (cite_count >= h)
//          count++;
//      }
//      return count >= h;
//    }
//    public int hIndex(int[] citations) {
//      int low = 0, high = citations.length;
//      while (low <= high) {
//        int mid = (low + high) / 2;
//        if (hasAtLeastHPapersWithHCitations(mid, citations))
//          low = mid + 1;
//        else
//          high = mid - 1;
//      }
//      return high;
//    }
//  }
}
/*
I бычное решение:
Каждый звонок в hasAtLeastHPapersWithHCitations проверяет все n n документов, принимая O(n) O(n).
Бинарный поиск в диапазоне [0, n] [0,n] занимает O(log⁡n)O(logn).
Умножая их вместе, мы получаем O(nlog⁡n)O(nlogn).

II решение сортировкой:
Сортировка - это O(nlog⁡n) O(nlogn). Зацикливание h - это O(n)O(n). Итак, временная сложность равна O(nlog⁡n)O(nlogn).
 */
