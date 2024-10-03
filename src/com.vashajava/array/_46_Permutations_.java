package com.vashajava.array;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 * _46_Permutations_.
 *
 * @author Anton Shatkovskiy
 * @created 02.10.2024 г.
 */

/*
Given an array nums of distinct integers, return all the possible
permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.

ПЕРВОД: 46. Перестановки.
Учитывая массив nums, состоящий из различных целых чисел, верните все возможные
перестановки. Вы можете вернуть ответ в любом порядке.

Пример 1:

Ввод: nums = [1,2,3]
Вывод: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Пример 2:

Ввод: nums = [0,1]
Вывод: [[0,1],[1,0]]
Пример 3:

Ввод: nums = [1]
Вывод: [[1]]

Ограничения:

1 <= nums.длина <= 6
-10 <= nums[i] <= 10
Все целые числа в nums уникальны.

 */
public class _46_Permutations_ {

  public static void main(String[] args) {

    int[] nums = {1, 2, 3};

    Solution46 solution46 = new Solution46();
    List<List<Integer>> permute = solution46.permute(nums);
    System.out.println(permute);

  }

  // исполбзуем поиск в глубину (DFS). DFS - это распространенный алгоритм обхода или поиска древовидных или графовых структур данных
  static class Solution46 {

    // ВВОДИМ ОСНОВНЫЕ ПЕРЕМЕННЫЕ
    // создаем список для хранения всех перестановок
    private List<List<Integer>> permutations = new ArrayList<>();
    // теперь создаем временный список для хранения текущей перестановки
    private List<Integer> currentPermutation = new ArrayList<>();
    // и создаем массив посещений для отслеживания элементов, уже включенных в перестановку,
    // почему boolean, потому что в массиве будут либо true либо false
    private boolean[] visited;
    // также создаем массив перестановок из элементов
    private int[] elements;

    // непостредственно сам метод инициирования процесса поиска всех перестановок
    public List<List<Integer>> permute(int[] nums) {
      // приводим к массиву перестановок
      elements = nums;
      // инициализируем массив посещение, в качестве аргументов передаем количество элементов массива nums
      visited = new boolean[nums.length];
      // рекурсивный метод с нулевым элементом
      backtrack(0);
      // возвращаем список перестановок
      return permutations;
    }

    // вспомогательный рекурсивный метод для выполнения обратного отслеживания и поиска в глубину (DFS)
    private void backtrack(int index) {
      // базовый вариант: если размер перестановки равен количеству элементов, добавьте его в ответ
      if(index == elements.length) {
        // включаем во временный список
        permutations.add(new ArrayList<>(currentPermutation));
        return;
      }

      // традиционно выполняем итерацию по массиву элементов, пробегаясб циклом
      for(int j = 0; j < elements.length; ++j) {
        // итак если элемент с индексом j не был посещен, включите его в перестановку
        if(!visited[j]) {
          // помечаем элемент с индексом j как посещенный - true
          visited[j] = true;
          // затем добавляем элемент к текущей перестановке
          currentPermutation.add(elements[j]);
          // далее переходим к следующему уровню глубины (следующий индекс) - т. е. вызываем опять метод, т. к. это рекурсия c аргументом index
          backtrack(index + 1);
          // и последнее, возрващемся назад: удалить последний добавленный элемент
          // currentPermutation.size() - 1 - есть последний эоемент
          currentPermutation.remove(currentPermutation.size() - 1);
          // и пометить его как не посещенный
          visited[j] = false;
        }
      }
    }
  }
}

/*
Временная сложность алгоритма определяется количеством выполненных рекурсивных вызовов и работой, выполняемой в каждом вызове.
Функция dfs вызывается рекурсивно до тех пор, пока не достигнет базового варианта (i == n).

Для n отдельных элементов существуют n! (факториал n) перестановки.
На каждом уровне рекурсии мы делаем n выбор, затем n - 1 для следующего уровня и так далее, что означает, что мы выполняем n! работу,
поскольку необходимо сгенерировать такое количество перестановок, и для каждой из них мы выполняем O(1) операцию.
Следовательно, временная сложность равна O(n!).
 */
