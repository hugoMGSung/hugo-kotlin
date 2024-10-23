fun main(args: Array<String>) {
    // 019 흐름제어 if
    var a = 20
    var b = 10

    if (a >= b) {
        println("a가 b보다 큼")
        a -= b
    }

    println(a)

    // 020 if-else
    if (a > b)
        println("a가 큼")
    else
        println("a가 큰게 아니라는데?")

    // 022 if-else 표현식
    var value: Int = if (10 > 5) {
        println("10은 5보다 큼")
        10
    } else {
        println("10은 5보다 작음")
        5
    }
    println(value)

    // 023 흐름제어 - When
    val score = 64

    when (score / 10) {
        6 -> { println('D') }
        7 -> { println('C') }
        8 -> { println('B') }
        9, 10 -> { println('A') }
        else -> { println('F') }
    }
    println("when end.")

    // 024. when 표현식
    var grade: Char = when(score / 10) {
        6 -> 'D'
        7 -> 'C'
        8 -> 'B'
        9, 10 -> 'A'
        else -> 'F'
    }
    println("학점은 $grade")

    // 025. while
    var i = 1

    while (i < 10) {
        println(i)
        i++
    }

    // 029 label
    var x = 0
    var y = 0

    outer@ while (x <= 20) {
        y = 0
        while (y <= 20) {
            if (x + y == 15 && x - y == 5) {
                break@outer
            }
            y += 1
        }
        x+=1
    }

    println("x = ${x}, y = ${y}")

    // 030. Function
    println(myFunction() + 10)

    // 031. Parameter or Argument
    println(celToFah(30))

    // 034. 가변인수
    println(getSumOf(1,2,3,4,5,6,7,8,9,10))
}

fun myFunction(): Int {
    val a = 3
    val b = 6
    println("a: " + a + ", b: " + b)
    return a + b
}

fun celToFah(celsius: Int): Double {
    return celsius * 1.8 + 32
}

fun getAverage(a: Int, b: Int): Double {
    return (a + b)/ 2.0
}

// 032. Unit타입. 리턴이 없을때
fun celToFah2(celsius: Int): Unit {
    println(celsius * 1.8 + 32)
}

// 034. 가변인수
fun getSumOf(vararg numbers: Int): Int {
    var i = 0; var sum = 0

    while (i < numbers.size) {
        sum += numbers[i]
        i++
    }
    return sum
}