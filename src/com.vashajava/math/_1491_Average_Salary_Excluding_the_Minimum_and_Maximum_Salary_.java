package math;

/**
 * _1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary_.
 *
 * @author Anton Shatkovskiy
 * @created 23.05.2024 г.
 */

/*
You are given an array of unique integers salary where salary[i] is the salary of the ith employee.

Return the average salary of employees excluding the minimum and maximum salary.
Answers within 10-5 of the actual answer will be accepted.

Example 1:

Input: salary = [4000,3000,1000,2000]
Output: 2500.00000
Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500

Example 2:

Input: salary = [1000,2000,3000]
Output: 2000.00000
Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
Average salary excluding minimum and maximum salary is (2000) / 1 = 2000

Constraints:

3 <= salary.length <= 100
1000 <= salary[i] <= 106
All the integers of salary are unique.

ПЕРЕВОД: 1491. Средняя заработная плата без учета минимальной и максимальной заработной платы
Вам предоставлен массив уникальных целых чисел salary, где salary[i] - это зарплата i-го сотрудника.

Возвращает среднюю зарплату сотрудников, исключая минимальную и максимальную зарплату.
Будут приняты ответы в пределах 10-5 от фактического ответа.

Пример 1:

Входные данные: зарплата = [4000,3000,1000,2000]
Выходные данные: 2500,00000
Пояснение: Минимальная и максимальная зарплата равны 1000 и 4000 соответственно.
Средняя зарплата без учета минимальной и максимальной составляет (2000+3000) / 2 = 2500

Пример 2:

Входные данные: зарплата = [1000,2000,3000]
Производительность: 2000.00000
Пояснение: Минимальная и максимальная заработная плата составляют 1000 и 3000 рублей соответственно.
Средняя заработная плата без учета минимальной и максимальной заработной платы составляет (2000) / 1 = 2000

Ограничения:

3 <= зарплата.стаж работы <= 100
1000 <= зарплата[i] <= 106
Все целые значения зарплаты уникальны.
 */

public class _1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary_ {

  public static void main(String[] args) {

    int[] salary = {4000, 3000, 1000, 2000};

    Solution1491 solution1491 = new Solution1491();
    System.out.println(solution1491.average(salary));


  }

  static class Solution1491 {

     /*
        1. Рассчитаем общую з. п. вместе, в виде суммы;
        2. Найдем max и min з. п.;
        3. Вычтем из п. 1 п. 2, получим з. п. без max и min з. п.;
        4. Вычтем среднюю з. п. исходя из п. 4;
        5. Вернем результат.
         */
    public double average(int[] salary) {

      // инициализируем сумму заработной платы равной 0
      int sum = 0;
      // устанавливаем минимальную заработную плату на максимально возможное целочисленное значение
      int minSalary = Integer.MAX_VALUE;
      // устанавливаем максимальную заработную плату на максимально возможное целочисленное значение
      int maxSalary = Integer.MIN_VALUE;

      // вводим цикл и перебераем все з. п.
      // пробегаемся по salary
      for (int value : salary) {
        // Обновляем минимальную зарплату, если найдена зарплата поменьше, с помощью стандартной библиотечной функции
        minSalary = Math.min(minSalary, value);
       // Обновляем максимальную зарплату, если найдена зарплата побольше, с помощью стандартной библиотечной функции
        maxSalary = Math.max(maxSalary, value);
        // Суммируем все зарплаты, с value, т. к. value это новое значение
        sum += value;
      }

      // Вычитаем крайние значения (минимальную и максимальную зарплату) - это к п. 2
      sum -= (minSalary + maxSalary);

      // количество элементов (salary.length), исключающих две крайние величины - п. 4. и п. 5
      int count = salary.length - 2;

      // И вычисляем среднее значение: разделим измененную сумму на количество элементов (salary.length), исключающих две крайние величины - п. 4. и п. 5
      return sum * 1.0 / count;

    }
  }

}
