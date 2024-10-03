package com.vashajava.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * _39_Combination_Sum_.
 *
 * @author Anton Shatkovskiy
 * @created 01.10.2024 г.
 */

/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations
of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40

ПЕРЕВОД: 39. Сумма комбинаций.
при использовании массива различных целых чисел-кандидатов и целевого целевого числа target возвращает список всех уникальных комбинаций
кандидатов, в которых выбранные числа суммируются с target. Вы можете возвращать комбинации в любом порядке.

Одно и то же число может быть выбрано из кандидатов неограниченное количество раз. Две комбинации считаются уникальными, если
частота хотя бы одного из выбранных чисел различна.

Тестовые примеры генерируются таким образом, чтобы количество уникальных комбинаций, которые в сумме дают целевое значение,
было меньше 150 комбинаций для заданных входных данных.

Пример 1:

Входные данные: кандидаты = [2,3,6,7], цель = 7
Выходные данные: [[2,2,3],[7]]
Объяснение:
2 и 3 являются кандидатами, и 2 + 2 + 3 = 7. Обратите внимание, что 2 можно использовать несколько раз.
7 - это кандидат, а 7 = 7.
Это единственные две комбинации.
Пример 2:

Входные данные: кандидаты = [2,3,5], цель = 8
Выходные данные: [[2,2,2,2],[2,3,3],[3,5]]
Пример 3:

Входные данные: кандидаты = [2], цель = 1
Выходные данные: []

Ограничения:

1 <= кандидаты.длина <= 30
2 <= кандидаты[i] <= 40
Все элементы
 */
public class _39_Combination_Sum_ {

  public static void main(String[] args) {

    int[] candidates = {2, 3, 6, 7};
    int target = 7;

    Solution39 solution39 = new Solution39();
    List<List<Integer>> combinationSum = solution39.combinationSum(candidates, target);
    System.out.println(combinationSum);

  }

  // используется dfs функция, которая организует рекурсивный поиск в глубину для изучения различных комбинаций
 static class Solution39 {

    // ввод необходимых переменных
    // сохраняем список всех комбинаций
    private List<List<Integer>> combinations = new ArrayList<>();
    // изучаем текущую комбинацию, т. е. List<Integer>
    private List<Integer> currentCombination = new ArrayList<>();
    // вводим и инициализируем номеров-кандидатов
    private int[] candidateNumbers;

    // сам непосредственно метод поиска всех уникальных комбинаций, в которых числа-кандидаты суммируются с целевыми
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

      // ЭТАПЫ:
      // I. СОРТИРОВКА КАНДИДАТОВ
      // сортируем массив кандидатов для оптимизации процесса, в отсортиорованном виде массив лчше "работает"
      // спользуем для сортировки "заводской" метиод класса Arrays - sort
      Arrays.sort(candidates);
      // и сохранем в методе глобальную ссылку на номера-кандидаты, через this, как в конструкторе
      this.candidateNumbers = candidates;
      // тут вызываем рекурсивный метод, реализация которого ниже
      backtrack(0, target);
      // возвращаем искомы комбинации
      return combinations;
      // IV. ОТСЛЕЖИВАНИЕ ВОЗВРАТА
      // V. ИЗБЕГАНИЕ ДУБЛИКАТОВ
      // VI. ВЫПОЛНЕНИЕ
    }
    // II. ФУНКЦИЯ DFS
    // вспомогательный метод для выполнения поиска в глубину, который вызывается рекурсивно
    private void backtrack(int startIndex, int remainingSum) {
      // вводим условие, если оставшаяся сумма равна 0, мы нашли правильную комбинацию
      if(remainingSum == 0) {
        // т. е. включаем правильные комбинации в списко всех комбинаций
        combinations.add(new ArrayList<>(currentCombination));
        return;
      }
      // а если startIndex находится за пределами допустимого значения или наименьший кандидат превышает оставшуюся сумму
      // candidateNumbers[startIndex] - это начальный наименьший кандидат в отсортированном списке
      if(startIndex >= candidateNumbers.length || remainingSum < candidateNumbers[startIndex]) {
        // возвращаемся
        return;
      }
      // III. ИЗУЧЕНИЕ КАНДИДАТОВ
      // тут - пропуск текущего кандидата и переходите к следующему
      backtrack(startIndex + 1, remainingSum);
      // тут - включаем текущего кандидата в текущую комбинацию
      currentCombination.add(candidateNumbers[startIndex]);
      // продолжаем изучение с текущим кандидатом (поскольку мы можем использовать один и тот же номер несколько раз)
      backtrack(startIndex, remainingSum - candidateNumbers[startIndex]);
      // возвращаемся назад и удалите последний элемент, прежде чем пробовать следующий кандидат
      // где currentCombination.size() - 1 - это есть последний элемент в ArrayList
      currentCombination.remove(currentCombination.size() - 1);
      }
    }
  }


/*
Временная сложность данного кода в первую очередь зависит от количества потенциальных комбинаций,
которые могут быть сформированы с помощью данного candidates массива, сумма которых равна target.
Учитывая, что массив имеет длину, n а рекурсия включает в себя перебор кандидатов и их включение / исключение,
мы получаем дерево рекурсии с глубиной, которая потенциально может увеличиться до target/min(candidates),
если мы продолжим использовать наименьший элемент. Это приводит к экспоненциальному увеличению числа возможностей.
Таким образом, временная сложность алгоритма O(2^n) в худшем случае, когда дерево рекурсии полностью разработано.
Однако, поскольку мы часто возвращаемся раньше, когда s < candidates[i], это верхняя граница.
*/
