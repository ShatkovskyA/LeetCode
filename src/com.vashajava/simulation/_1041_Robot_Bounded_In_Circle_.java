package simulation;

import org.w3c.dom.ls.LSOutput;

/**
 * _1041_Robot_Bounded_In_Circle_.
 *
 * @author Anton Shatkovskiy
 * @created 18.04.2024 г.
 */

/*

On an infinite plane, a robot initially stands at (0, 0) and faces north. Note that:

The north direction is the positive direction of the y-axis.
The south direction is the negative direction of the y-axis.
The east direction is the positive direction of the x-axis.
The west direction is the negative direction of the x-axis.
The robot can receive one of three instructions:

"G": go straight 1 unit.
"L": turn 90 degrees to the left (i.e., anti-clockwise direction).
"R": turn 90 degrees to the right (i.e., clockwise direction).
The robot performs the instructions given in order, and repeats them forever.

Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.

Example 1:

Input: instructions = "GGLLGG"
Output: true
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"G": move one step. Position: (0, 2). Direction: North.
"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: West.
"L": turn 90 degrees anti-clockwise. Position: (0, 2). Direction: South.
"G": move one step. Position: (0, 1). Direction: South.
"G": move one step. Position: (0, 0). Direction: South.
Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (0, 2) --> (0, 1) --> (0, 0).
Based on that, we return true.

Example 2:

Input: instructions = "GG"
Output: false
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"G": move one step. Position: (0, 2). Direction: North.
Repeating the instructions, keeps advancing in the north direction and does not go into cycles.
Based on that, we return false.

Example 3:

Input: instructions = "GL"
Output: true
Explanation: The robot is initially at (0, 0) facing the north direction.
"G": move one step. Position: (0, 1). Direction: North.
"L": turn 90 degrees anti-clockwise. Position: (0, 1). Direction: West.
"G": move one step. Position: (-1, 1). Direction: West.
"L": turn 90 degrees anti-clockwise. Position: (-1, 1). Direction: South.
"G": move one step. Position: (-1, 0). Direction: South.
"L": turn 90 degrees anti-clockwise. Position: (-1, 0). Direction: East.
"G": move one step. Position: (0, 0). Direction: East.
"L": turn 90 degrees anti-clockwise. Position: (0, 0). Direction: North.
Repeating the instructions, the robot goes into the cycle: (0, 0) --> (0, 1) --> (-1, 1) --> (-1, 0) --> (0, 0).
Based on that, we return true.

Constraints:

1 <= instructions.length <= 100
instructions[i] is 'G', 'L' or, 'R'.

ПЕРЕВОД: 1041. Робот, Ограниченный Кругом или же земкнутый круг.
На бесконечной плоскости робот изначально стоит в точке (0, 0) и смотрит на север. Обратите внимание, что:

Направление на север является положительным направлением оси y.
Направление на юг является отрицательным направлением оси y.
Направление на восток - это положительное направление оси x.
Направление на запад - отрицательное направление оси x.
Робот может получить одну из трех инструкций:

"G": пройти прямо 1 единицу.
"L": поверните на 90 градусов влево (т.е. против часовой стрелки).
"R": поверните на 90 градусов вправо (т.е. по часовой стрелке).
Робот выполняет приведенные инструкции по порядку и повторяет их бесконечно.

Возвращает значение true тогда и только тогда, когда на плоскости существует окружность, так что робот никогда не покидает ее.

Пример 1:

Ввод: инструкции = "GGLLGG"
Вывод: true
Пояснение: Изначально робот находится в точке (0, 0), обращенной в северном направлении.
"G": переместиться на один шаг. Позиция: (0, 1). Направление: Север.
"G": переместиться на один шаг. Позиция: (0, 2). Направление: Север.
"L": поверните на 90 градусов против часовой стрелки. Положение: (0, 2). Направление: Запад.
"L": поверните на 90 градусов против часовой стрелки. Положение: (0, 2). Направление: Юг.
"G": переместиться на один шаг. Позиция: (0, 1). Направление: Юг.
"G": переместиться на один шаг. Позиция: (0, 0). Направление: Юг.
Повторяя инструкции, робот переходит в цикл: (0, 0) --> (0, 1) --> (0, 2) --> (0, 1) --> (0, 0).
Исходя из этого, мы возвращаем значение true.

Пример 2:

Ввод: instructions = "GG"
Вывод: false
Пояснение: Робот изначально находится в точке (0, 0), обращенной в северном направлении.
"G": переместиться на один шаг. Позиция: (0, 1). Направление: Север.
"G": переместиться на один шаг. Местоположение: (0, 2). Направление: Север.
Повторяя инструкции, робот продолжает двигаться в северном направлении и не зацикливается.
Исходя из этого, мы возвращаем значение false.

Пример 3:

Ввод: instructions = "GL"
Вывод: true
Пояснение: Изначально робот находится в точке (0, 0), обращенной в северном направлении.
"G": переместитесь на один шаг. Положение: (0, 1). Направление: Север.
"L": повернитесь на 90 градусов против часовой стрелки. Положение: (0, 1). Направление: Запад.
"G": переместитесь на один шаг. Положение: (-1, 1). Направление: Запад.
"L": повернитесь на 90 градусов против часовой стрелки. Положение: (-1, 1). Направление: Юг.
"G": сделайте один шаг. Положение: (-1, 0). Направление: Юг.
"L": повернитесь на 90 градусов против часовой стрелки. Положение: (-1, 0). Направление: Восток.
"G": сделайте один шаг. Положение: (0, 0). Направление: Восток.
"L": поверните на 90 градусов против часовой стрелки. Положение: (0, 0). Направление: Север.
Повторяя инструкции, робот переходит в цикл: (0, 0) --> (0, 1) --> (-1, 1) --> (-1, 0) --> (0, 0).
Исходя из этого, мы возвращаем значение true.

Ограничения:

1 <= инструкции.длина <= 100
команд[i] - это "G", "L" или "R".

 */


public class _1041_Robot_Bounded_In_Circle_ {

    public static void main(String[] args) {
      // String instructions = "GGLLGG";

      String instructions = "GLRLLGLL";

      Solution1041 solution1041 = new Solution1041();
      System.out.println(solution1041.isRobotBounded(instructions));

    }

  static  class Solution1041 {
    public boolean isRobotBounded(String instructions) {

//      int directionIndex = 0;
//      int[] distance = new int[4];
//      for (int i = 0; i < instructions.length(); ++i) {
//        char currentInstruction = instructions.charAt(i);
//        if (currentInstruction == 'L') {
//          directionIndex = (directionIndex + 1) % 4;
//        }
//        else if (currentInstruction == 'R') {
//          directionIndex = (directionIndex + 3) % 4;
//        }
//        else {
//          distance[directionIndex]++;
//        }
//      }
//      return (distance[0] == distance[2] && distance[1] == distance[3]) || (directionIndex != 0);

      // "Индекс направления" представляет текущее направление движения робота:
      // 0-Вверх, 1-Влево, 2-Вниз, 3-Вправо
      int directionIndex = 0;

      // инициализация направления и расстояния - везде по нулям, т. е. инициализируем 4-мя нулями
      // массив 'distance' хранит чистое расстояние, пройденное во всех 4 направлениях
      int[] distance = new int[4];

      // инструкция по процессу - в зависимости от букв в скрипте либо двигаемся в ту или иную сторону, массив направений увеличиввается, либо уменьшается
      // повторяем каждую инструкцию и соответствующим образом обновляем направление или расстояние - цикл
      for (int i = 0; i < instructions.length(); ++i) {
        // текущий символ получаем из комбинации путем метода charAt
        char currentInstruction = instructions.charAt(i);

        // если в команде указана буква "L", робот поворачивается на 90 градусов влево
        if(currentInstruction == 'L') {
          directionIndex = (directionIndex + 1) % 4;
        }

        // если команда "R", она поворачивает робота на 90 градусов вправо
        else if(currentInstruction == 'R') {
          directionIndex = (directionIndex + 3) % 4;
        }

        // если команда "G", робот перемещается на одну единицу вперед в текущем направлении
        else {
          distance[directionIndex]++;
        }
      }

      // проверяем ограниченность кругом - т. е. проверки должны показать, что робот двигается в круге
      // робот ограничен, если:
      // 1. Он возвращается в исходное положение (расстояние, пройденное вверх, равно расстоянию, пройденному вниз, а влево - вправо).
      // 2. После выполнения всех инструкций он не будет обращен на север.


      return (distance[0] == distance[2] && distance[1] == distance[3]) || (directionIndex != 0);

    }
  }
}
