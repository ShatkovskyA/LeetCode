package com.vashajava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _15_3Sum_.
 *
 * @author Anton Shatkovskiy
 * @created 28.08.2024 г.
 */

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

Constraints:

3 <= nums.length <= 3000
-105 <= nums[i] <= 105

ПЕРЕВОД: 15. 3 Суммы.
Учитывая целочисленный массив nums, верните все триплеты [nums[i], nums[j], nums[k]] такие, что i != j, i != k и j != k, и nums[i] + nums[j] + nums[k] == 0.

Обратите внимание, что набор решений не должен содержать повторяющихся триплетов.

Пример 1:

Входные данные: числа = [-1,0,1,2,-1,-4]
Выходные данные: [[-1,-1,2],[-1,0,1]]
Объяснение:
цифры[0] + цифры[1] + цифры[2] = (-1) + 0 + 1 = 0.
цифры[1] + цифры[2] + цифры[4] = 0 + 1 + (-1) = 0.
числа[0] + числа[3] + числа nums[4] = (-1) + 2 + (-1) = 0.
Различными триплетами являются [-1,0,1] и [-1,-1,2].
Обратите внимание, что порядок вывода и очередность троек не имеют значения.
Пример 2:

Входные данные: nums = [0,1,1]
Выходные данные: []
Пояснение: Единственно возможный триплет в сумме не равен 0.
Пример 3:

Входные данные: nums = [0,0,0]
Выходные данные: [[0,0,0]]
Пояснение: Единственная возможная тройка в сумме равна 0.

Ограничения:

3 <= числа.длина <= 3000
-105 <= числа[i] <= 105


 */
public class _15_3Sum_ {

  public static void main(String[] args) {

    int[] nums = {-1, 0, 1, 2, -1, -4};
    
    Solution15 solution15 = new Solution15();
    List<List<Integer>> threeSum = solution15.threeSum(nums);

    // тут применяем цикл фор эйч для вывода только троек чисел сумма которых равно 0
    for (List<Integer> resultTriplets : threeSum) {
      // применяем Strim API + ляиюда выражение и ссылку на метод,
      // где mapToInt — используется для получения одного потока целых чисел из другого потока путём применения функции ко всем элементам потока,
      // intValue() — возвращает числовое значение, представленное объектом после преобразования его в тип int.
      int sum = resultTriplets.stream()
          .mapToInt(Integer::intValue)
          .sum();

      // и теперь через условие
      if (sum == 0) {
//         System.out.print(formatList(resultTriplets));
        System.out.println(resultTriplets);
      }
    }
  }

//  // создаем и используем собственный метод для преобразования при печати к виду
//  private static String formatList(List<Integer> list) {
//    // опять задействуем стримбилдер, создаем объект
//    StringBuilder sb = new StringBuilder();
//    // StringBuilder append (String s) — это метод класса StringBuilder в Java, который добавляет указанную строку к существующей строке
//    // вводим открывающую скобку
//    sb.append("[");
//    // далее пробегаемся циклом
//    for (int i = 0; i < list.size(); i++) {
//      // тут включаем в объект элементы
//      sb.append(list.get(i));
//      if (i < list.size() - 1) {
//        // вводим запятую и пробел
//        sb.append(", ");
//      }
//    }
//    // вводим закрывающую скобку
//    sb.append("]");
//    // добавляем запятую и пробел после каждой тройки чисел
//    sb.append(", ");
//    // возвращаем результат
//    return sb.toString();
//  }

 static class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
      // сортируем массив, стандартным методом, чтобы применить метод двух указателей
      Arrays.sort(nums);

      // далее создаем и инициализируем список для хранения триплетов, исп. в качестве изначального типа - типа переменной аргумента
      List<List<Integer>> triplets = new ArrayList<>();

      // вводим переменную для получения длины массива, опять же стандартным библиотечным, "заводским" методом
      int length = nums.length;

      // теперь выполняем итерацию по массиву в поисках первого элемента триплета
      // где опять вводим в цикле новую переменную first (это есть первый указатель) и попутно добавляя дополнительные условия,
      // т. е. пока число меньше И (логический оператор) меньше или равно 0
      for (int first = 0; first < length - 2 && nums[first] <= 0; ++first) {
        // тут вводим доп. условие для того, чтобы пропускать все повторяющиеся элементы, чтобы избежать повторяющихся триплетов
        if(first > 0 && nums[first] == nums[first - 1]) {
          // оператор continue используется, чтобы пропустить какую-то часть цикла и продолжить выполнение следующей итерацией цикла
          continue;
        }
        // теперь вводим и инциализируем второй и третий(последний) указатели исходя из описания алгоритма
        // т. е. второй указатель - это первый указатель + 1
        // а последний это длина массива - 1, т. к. начинаем с 0
        int second = first + 1;
        int third = length - 1;

        // теперь исп. т. н. метод двух указателей, чтобы найти оставшиеся два элемента
        // вводим цикл while, пока второй меньше третьего
        while (second < third) {
          // вводим новую переменную, которая явл. суммой элеменетов массива, которая как раз по условию должна быть равна нулю
          int sum = nums[first] + nums[second] + nums[third];
          // условие вводим - если сумма меньше нуля, переместите второй указатель вправо
          if(sum < 0) {
            // "++second" сначала происходит увеличение значения переменной "second", а затем возвращается это увеличенное значение.
            // То есть сначала "second" увеличивается на 1, а затем возвращается результат увеличения.
            ++second;
          }
          // а если сумма больше нуля, переместите третий указатель влево - уменьшаем
          else if(sum > 0) {
            --third;
          }
          // в итоге сумма равна нулю, то мы нашли допустимую тройку
          else {
            // т. е. включаем в созданный список, где
            // list.of() - позволяет создавать неизменяемые списки.
            // Такие списки нельзя модифицировать после создания, что обеспечивает целостность данных и неизменяемость.
            triplets.add(List.of(nums[first], nums[second], nums[third]));
            // перемещаем второй указатель вправо, пропуская дубликаты
            while (second < third && nums[second] == nums[second + 1]) {
              ++second;
            }
            // перемещая третий указатель влево, пропуская дубликаты
            while (second < third && nums[third] == nums[third - 1]) {
              --third;
            }
            // перемещаем далее оба указателя для следующего потенциального триплета
            ++second;
            --third;
          }
        }
      }
      // в итоге возвращаем список триплетов
      return triplets;
    }
  }
}

/*
Временная сложность данного кода составляет O(n^2).
Это связано с тем, что существует вложенный цикл, в котором внешний цикл выполняется n раз (сокращенный на 2,
чтобы избежать ненужных последних итераций из-за триплетов),
и внутри этого цикла есть два указателя, которые независимо движутся навстречу друг другу,
что в сумме приведет к n итерациям в худшем случае.
Внутри цикла while нет вложенных циклов, поэтому внутренние операции выполняются с постоянным временем,
несмотря на условия while, которые также есть O(n). Умножение их вместе дает нам n * n = n^2, следовательно O(n^2).
 */
