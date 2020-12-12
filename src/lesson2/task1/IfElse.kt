@file:Suppress("UNUSED_PARAMETER")

package lesson2.task1

import lesson1.task1.discriminant
import kotlin.math.max
import kotlin.math.sqrt

// Урок 2: ветвления (здесь), логический тип (см. 2.2).
// Максимальное количество баллов = 6
// Рекомендуемое количество баллов = 5
// Вместе с предыдущими уроками = 9/12

/**
 * Пример
 *
 * Найти число корней квадратного уравнения ax^2 + bx + c = 0
 */
fun quadraticRootNumber(a: Double, b: Double, c: Double): Int {
    val discriminant = discriminant(a, b, c)
    return when {
        discriminant > 0.0 -> 2
        discriminant == 0.0 -> 1
        else -> 0
    }
}

/**
 * Пример
 *
 * Получить строковую нотацию для оценки по пятибалльной системе
 */
fun gradeNotation(grade: Int): String = when (grade) {
    5 -> "отлично"
    4 -> "хорошо"
    3 -> "удовлетворительно"
    2 -> "неудовлетворительно"
    else -> "несуществующая оценка $grade"
}

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + sqrt(d)) / (2 * a)
    val y2 = (-b - sqrt(d)) / (2 * a)
    val y3 = max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -sqrt(y3)           // 7
}

/**
 * Простая (2 балла)
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String {
    var x = age
    if (age % 100 < 21) { // брал этот промежуток потому нужно, например,14 лет(а не 14 года) итд
        x = x % 100
        return when {
            age == 0 -> "лол тебя еще нет "// почему бы и нет?)
            x == 1 -> "$age год"
            x == 0 -> "$age лет"
            x < 5 -> "$age года"
            else -> "$age лет"
        }
    } else {
        x = x % 10
        return when {
            x == 1 -> "$age год"
            x == 2 -> "$age года"
            x == 3 -> "$age года"
            x == 4 -> "$age года"
            x == 5 -> "$age лет"
            x == 6 -> "$age лет"
            x == 7 -> "$age лет"
            x == 8 -> "$age лет"
            x == 9 -> "$age лет"
            x == 0 -> "$age лет"
            else -> "что ты такое?"
        }
    }
}


/**
 * Простая (2 балла)
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(
    t1: Double, v1: Double,
    t2: Double, v2: Double,
    t3: Double, v3: Double
): Double = TODO()


/**
 * Простая (2 балла)
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(
    kingX: Int, kingY: Int,
    rookX1: Int, rookY1: Int,
    rookX2: Int, rookY2: Int
): Int = TODO()


/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */
fun rookOrBishopThreatens(
    kingX: Int, kingY: Int,
    rookX: Int, rookY: Int,
    bishopX: Int, bishopY: Int
): Int = TODO()

/**
 * Простая (2 балла)
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */

fun triangleKind(a: Double, b: Double, c: Double): Int = TODO()


/**
 * Средняя (3 балла)
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(
    a: Int,
    b: Int,
    c: Int,
    d: Int
): Int {
    var fin = -1
    var minN= minOf(a,b,c,d)
    var maxN= maxOf(a,b,c,d)
    if ((a == minN) && (b == maxN)) { // значит существуют всего 3 места для прямых - 1:2 1:3 1:4 [ проверка 1:4 a:b]
        fin = d - c
    } else if ((c == minN) && (d == maxN)) {
        fin = b - a
    } else if ((a == minN) && (d == maxN)) { // [ 1:3 ]
        if (c > b) {
            fin = -1
        } else {
            fin = b - c
        }
    } else if ((c == minN) && (b == maxN)) {
        if (a > d) {
            fin = -1
        } else {
            fin = d - a
        }
    } else if (c == b) { //[ 1:2 ]
        fin = c - b
    } else if (d == a) {
        fin = d - a
    }
    return fin //вроде получилось
}
/*if (b > d) {
    if (a > d) {
        return -1
    } else if (a >= d) {
        return a - d
    } else if (a > c) { // теперь проверяется не возможно ли такое что переменные стяят в порядке [с а д в] то есть друг через друга
        return d - a
    } else if (a == c) {
        return d - c
    } else {
        return d - c
    }
} else if (b == d) {
    if (a > c) { // идет проверка на расположение [с а б=д ]
        return b - a
    } else {
        return b - c
    }
} else if (b > c) {
    if (a > c) { // точка б утвердило свое второе место как наибольшее теперь проверка 3-го и 4-го места
        return b - a
    } else {
        return b - c
    }
} else if (b == c) {
    return b - c
} else {
    return -1
}
return -1
}

*/




