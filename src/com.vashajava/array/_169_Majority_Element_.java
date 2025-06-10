package com.vashajava.array;

/**
 * Класс _169_Majority_Element_ - мажоритарный элемент.
 *
 * @author Anton Shatkovskiy
 * @created 28.06.2024 г.
 */

/*
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times.
You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109

Follow-up: Could you solve the problem in linear time and in O(1) space?

ПЕРЕВОД: 169. Мажоритарный элемент.
Если задан массив nums размером n, верните основной элемент.

Мажоритарный элемент - это элемент, который появляется более ⌊n / 2⌋ раз.
Можно предположить, что основной элемент всегда существует в массиве.

Пример 1:

Ввод: nums = [3,2,3]
Результат: 3
Пример 2:

Ввод: nums = [2,2,1,1,1,2,2]
Результат: 2

Ограничения:

n == числа.длина
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
 */

  // применяется алгоритм голосования Мура
public class _169_Majority_Element_ {

  public static void main(String[] args) {

    int[] nums = {3, 2, 3};

    Solution169 solution169 = new Solution169();
    int majorityElement = solution169.majorityElement(nums);
    System.out.println(majorityElement);
  }

  static class Solution169 {

    // метод находит основной элемент в массиве,
    // который определяется как элемент, появляющийся более n/2 раз
    public int majorityElement(int[] nums) {
      // тут - инициализируем две (2) переменные - подсчет т. е. счетчик
      // и кандидата в мажоритарный элемент
      int count = 0;
      int candidate = 0;

      // пробегаемся упрощенным циклом без условий for-each - выполняем итерацию по всем элементам массива
      for (int num : nums) {
        // если значение count равно нулю, мы выбираем текущий элемент в качестве нового кандидата
        if (count == 0) {
          candidate = num;
          // т увеличиваем счетчик в связи с этим на 1
          count = 1;
        } else {
          // если же текущий элемент совпадает с кандидатом, количество приращений увеличивается
          if (num == candidate) {
            count++;
          } else {
            // если же отличается, то количество уменьшений
            count--;
          }
        }
      }
        // ну и тут возвращаем кандидата - это и есть элемент большинства, существование которого гарантировано
      return candidate;
    }
  }
}
/*
Функция выполняет итерацию по списку nums ровно один раз.
Для каждого элемента x в nums коде выполняется постоянное количество операций, либо увеличивающих, либо уменьшающих количество,
либо устанавливающих количество cnt и, возможно, обновляющих потенциальный мажоритарный элемент m.
Таким образом, количество операций пропорционально длине nums, которая равна n. Следовательно, временная сложность равна O(n).
 */
