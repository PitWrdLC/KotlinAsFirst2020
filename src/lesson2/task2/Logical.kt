@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr

/**
 * Пример
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
    sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая (2 балла)
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean { //on tw th fr это как ни странно будут сами 4 числа
    val on = number / 1000
    val tw = (number - (number / 1000) * 1000) / 100
    val th = (number - (number / 100) * 100) / 10
    val fr = (number - (number / 10) * 10) / 1
    return on + tw == th + fr
}

/**
 * Простая (2 балла)
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean = TODO()


/**
 * Простая (2 балла)
 *
 * Дан номер месяца (от 1 до 12 включительно) и год (положительный).
 * Вернуть число дней в этом месяце этого года по григорианскому календарю.
 */
fun daysInMonth(month: Int, year: Int): Int = TODO()

/**
 * Простая (2 балла)
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(
    x1: Double, y1: Double, r1: Double,
    x2: Double, y2: Double, r2: Double
): Boolean = TODO()

/**
 * Средняя (3 балла)
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(
    a: Int,
    b: Int,
    c: Int,
    r: Int,
    s: Int
): Boolean {
    var maxVhod: Int
    var minVhod: Int
    var midVhod: Int
    var maxVih: Int
    var minVih: Int
    if ((a == b) || (a == c) || (c == b)) { //вариант, когда все три знач равны
        if ((a == b) && (b == c)) {
            maxVhod = a
            midVhod = b
            minVhod = c
        } else {
            if (a == c) { // вариант, когда в команде 1 импостер
                if (a > b) {
                    maxVhod = a
                    minVhod = b
                    midVhod = c
                } else {
                    maxVhod = b
                    minVhod = a
                    midVhod = c
                }
            } else if (a == b) {
                if (a > c) {
                    maxVhod = a
                    minVhod = c
                    midVhod = b
                } else {
                    maxVhod = c
                    minVhod = a
                    midVhod = b
                }
            } else if (b == c) {
                if (b > a) {
                    maxVhod = c
                    minVhod = a
                    midVhod = b
                } else {
                    maxVhod = a
                    minVhod = b
                    midVhod = c
                }
            } else return false
        }
    } else { //вариант, когда никто не равен
        maxVhod = maxOf(a, b, c)
        minVhod = minOf(a, b, c)
        midVhod = a + b + c - maxVhod - minVhod
    }
    if (r > s) {
        maxVih = r
        minVih = s
    } else {
        minVih = r
        maxVih = s
    }
    return ((minVhod <= minVih) && (midVhod <= maxVih))
    //по-моему получилось более читабельно

} // оставлю  на память)
/*
    if ((a > c) && (a > c)) { //ищем максимально значение
        maxVhod = a
    } else if ((b > a) && (b > c)) {
        maxVhod = b
    } else if ((c > a) && (c > b)) {
        maxVhod = c
    } else { // этот вариает если значение равны и избегает ошибок при равных значениях
        maxVhod = a
        minVhod = c
    }
    if ((a < c) && (a < c)) { // теперь ищем минимальное значение и так же предусматриваем возможность равенства
        minVhod = a
    } else if ((b < a) && (b < c)) {
        minVhod = b
    } else if ((c < a) && (c < b)) {
        minVhod = c
    } else {
        maxVhod = a
        minVhod = c
    }
    val midVhod =
        a + b + c - minVhod - maxVhod // самый оптимизированный способ нахождения числа в центре ( из трех допустимых)
    if (r > s) { // ищем максимальное значение в дырке
        maxVih = r
        minVih = s
    } else {
        minVih = r
        maxVih = s
    }
    println("------")
    println(minVhod)
    println(midVhod)
    println(maxVhod)
    println("------")
    println(maxVih)
    println(minVih)
    println("------") // проверка
    if ((minVhod <= minVih) && (midVhod <= maxVih)) { // а тепер ьфинальный штрих я беру самое минимальное значение и мерю его в другое минимальное значение
        return true
    } else {
        return false    // без нахождение минимального и максимального значение было бы геморойно предусматривать случаи, когда например беру первое попавшейся в руки число и мерю это число с первой попавшейся дыркий для этого числа
    }                   //как раз первые значение поймали меня на том
    return false
}
*/ //сохрнаю на потом
