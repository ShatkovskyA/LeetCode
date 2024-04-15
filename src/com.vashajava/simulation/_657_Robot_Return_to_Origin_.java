package simulation;

/**
 * _657_Robot_Return_to_Origin_.
 *
 * @author Anton Shatkovskiy
 * @created 14.04.2024 г.
 */

/*
There is a robot starting at the position (0, 0), the origin, on a 2D plane.
Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.

You are given a string moves that represents the move sequence of the robot
where moves[i] represents its ith move. Valid moves are 'R' (right), 'L' (left), 'U' (up),
and 'D' (down).

Return true if the robot returns to the origin after it finishes all of its moves,
or false otherwise.

Note: The way that the robot is "facing" is irrelevant.
'R' will always make the robot move to the right once, 'L' will always make it move left, etc.
Also, assume that the magnitude of the robot's movement is the same for each move.

Example 1:

Input: moves = "UD"
Output: true
Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the origin where it started. Therefore, we return true.

Example 2:

Input: moves = "LL"
Output: false
Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin. We return false because it is not at the origin at the end of its moves.

Constraints:

1 <= moves.length <= 2 * 104
moves only contains the characters 'U', 'D', 'L' and 'R'.

ПЕРЕВОД: 657. Робот возвращается в исходное положение
Есть робот, который стартует с позиции (0, 0), являющейся началом координат,
на двумерной плоскости.
Учитывая последовательность его перемещений, оцените,
окажется ли этот робот в точке (0, 0) после завершения своих перемещений.

Вам будет предоставлена строка moves, представляющая последовательность движений робота,
где moves[i] представляет его i-й ход. Допустимыми ходами являются "R" (вправо),
"L" (влево), "U" (вверх) и "D" (вниз).

Возвращает значение true, если робот возвращается в исходное положение после завершения
всех своих перемещений, или значение false в противном случае.

Примечание: То, как робот "повернут лицом", не имеет значения.
"R" всегда заставит робота один раз переместиться вправо,
"L" всегда заставит его переместиться влево и т.д.
Кроме того, предположим, что величина перемещения робота одинакова для каждого перемещения.

Пример 1:

Ввод: перемещения = "UD"
Вывод: true
Пояснение: Робот перемещается один раз вверх, а затем один раз вниз.
Все перемещения имеют одинаковую величину, поэтому он оказывается в начале координат.
Следовательно, мы возвращаем значение true.

Пример 2:

Ввод: moves = "LL"
Вывод: false
Пояснение: Робот дважды перемещается влево.
В итоге он оказывается на два "хода" левее начала координат.
Мы возвращаем значение false, поскольку в конце своих перемещений он не находится в начале координат.

Ограничения:

1 <= ходы.длина <= 2 * 104
хода содержит только символы "U", "D", "L" и "R".
 */

public class _657_Robot_Return_to_Origin_ {

  public static void main(String[] args) {

    String moves = "UD";

    Solution657 solution657 = new Solution657();
    System.out.println(solution657.judgeCircle(moves));



  }

  static class Solution657 {
    public boolean judgeCircle(String moves) {

      return  true;
    }
  }

}
