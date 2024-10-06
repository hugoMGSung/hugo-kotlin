fun main(args: Array<String>) {
    // 003 Variable
    var total: Int
    total = 0

    val a: Int = 10 + 53 - 7
    println(a)

    var b: Int = 43 + 75 + a
    println(b)

    total = a + b
    println(total)

    // 004 리터럴 타입
    var newVal = 10 + 12 - 5
    println(newVal)

    // 009 실수타입 함정
    println(0.1f + 0.1f + 0.1f)
    println(0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f + 0.1f) // 오차 주의!
    println(0.1f * 10)

    // 010 문자타입
    var ch: Char = 'A'
    println(ch)
    println(ch + 1)

    ch = '\uAC00'
    println(ch)

    ch = '1'
    // println(ch.toInt()) // deprecated
    println(ch.digitToInt())

    // 011~ 문자열
    var str: String = "Hello"

    str = str + "\tKotlin!"
    println(str)

    val c = 10
    var d = 20
    println("c = $c")
    println("c + d = ${c + d}")

    // 013 타입별명
    val e: Number = 11
    println(e)

    // 014 주석
    // 한줄 주석
    /* 여러줄
       주석
     */

    // 015 할당연산자 - 기본적 언어들과 동일

    // 017 비교연산자
    var isRight: Boolean = (10 + 80) > (3 * 20)
    println(isRight)

    isRight = 30 == (10 + 19)
    println(isRight)

    // 018 논리연산자
    var bool: Boolean = (a - b < a+ b) && (a == 100)
    println(bool)
}

typealias Number = Int