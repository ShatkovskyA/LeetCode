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

  static  class Solution1491 {
    public double average(int[] salary) {

      return 0.00;

    }
  }

}
