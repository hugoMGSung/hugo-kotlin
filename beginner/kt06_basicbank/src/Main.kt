// 126. Delegated Property
import kotlin.reflect.KProperty

fun main() {
    println("Kt06_basicbank!!")

    var finance = getFinance(Student(350), Student(350), 
                            Professor(1), Professor(2), 
                            Employee(1300, 2))
    println("학교재정 : ${finance}원")

    // 099. Nested class
    var instance: Outer.Nested = Outer.Nested()
    instance.hello()

    // 100. Inner class
    var inst: Outer = Outer(600)
    var innerInst: Outer.Inner = inst.Inner(50)
    innerInst.print()

    // 101. Data class
    var first = OtherEmployee("John", 30, 2000)
    var second = OtherEmployee("Page", 24, 1800)
    var third = first.copy()

    println(first.toString())
    println(third.toString())
    println(first === third)
    println(first == third)

    // 102. 객체 분해
    var (name, _, salary) = OtherEmployee("Hugo", 50, 8000)
    println("이름: ${name} / 급여: ${salary}")

    // 103. Lambda expression
    var instantFunc: (Int) -> Unit
    instantFunc = { number: Int ->
        println("Hello $number")
    }

    instantFunc(33)
    instantFunc.invoke(34)

    // 104. Anonymous function
    var instantFunc2: (Int) -> Unit = fun(number: Int): Unit {
        println("Hello $number 2")
    }

    instantFunc2(42)
    instantFunc2.invoke(43)

    // 106.
    var instantFunc3: (Int, Int) -> Unit
    instantFunc3 = ::plus
    instantFunc3(60, 27) // 87

    instantFunc3 = Object::minus
    instantFunc3(36, 12) // 24

    instantFunc3 = Class()::average
    instantFunc3(25, 15) // 20

    // 107. 고차함수
    decorate({
        val a = 10; val b = 5
        println("$a + $b = ${a + b}")
    })
    decorate({
        println("some"); println("tasks")
    })

    // 108
    val f: () -> Unit = returnFunc(30)
    f()

    // 110
    val func: () -> Int = toFunction<Int>(1107)
    println(func())

    // 111
    val square: Int =
        11.map {
            it * it
        }
    println(square)

    // 113
    var pair: Pair<Int, Double>
    pair = Pair<Int, Double>(15, 9.12)
    println(pair.toString())

    // 116
    val aaaSub = AAA<Int>()
    val aaaSuper: AAA<Any> = aaaSub

    val bbbSuper = BBB<Any>()
    val bbbSub: BBB<Int> = bbbSuper

    val star: AAA<*> = aaaSub

    // 117 범위표현식
    val oneToTen: IntRange = 1..10
    println(5 in oneToTen)

    val upperAtoZ: CharRange = 'A'..'Z'
    if ('C' in upperAtoZ)
        println("대문자입니다.")

    if ('p' in 'a'..'z')
        println("소문자입니다.")

    // 118 Iterator
    val range: IntRange = 1..3
    val iter: Iterator<Int> = range.iterator()

    println(iter.hasNext())
    println(iter.next())

    println(iter.hasNext())
    println(iter.next())

    println(iter.hasNext())
    println(iter.next())

    println(iter.hasNext())

    // 119 for
    for (i: Int in 1..10)
        print("$i ")

    println()

    for (i: Int in 1..10) {
        if (i > 5)
            break

        print("$i ")
    }

    // 120 배열
    val integers: Array<Int> = arrayOf(10, 20, 30, 40)

    println(integers.size)
    println(integers[1])

    for (i in integers)
        print("$i ")


    // 121
    val numbers: Array<String> = arrayOf("What's", "your", "name?")
    printAll(*numbers)

    // 123 열거클래스에 프로퍼티, 멤버함수 선언
    // 현재 선택된 모드
    val mode: Mode = Mode.ERASER

    println(mode.number)
    mode.printNumber()

    // 125. sealed class
    val instances: Outers = Outers.Three()

    val text: String = when (instances)
    {
        is Outers.One -> "첫 번째"
        is Outers.Two -> "두 번째"
        is Outers.Three -> "세 번째"
    }

    println(text)

    // 126. Delegated property
    val sample = Sample()
    sample.number = -50
    println(sample.number)

    sample.number = 100
    println(sample.number)

    // 127. Class Delegation
    println(Sample2() + 10)
}

// 096. Abstract class
// 단순히 학생, 교수, 직원 클래스를 하나의 타입으로 묶어주기 위한 기반클래스
abstract class Person
{
    abstract fun getSalary(): Int
}

// 학생 클래스. tuition는 한 학기 등록금
class Student(private val tuition: Int) : Person()
{
    // 학생은 등록금을 납부하므로 salary를 음수 처리
    override fun getSalary() = -tuition
}

// 교수 클래스. classCount는 진행하는 수업의 수
class Professor(private val classCount: Int) : Person()
{
    override fun getSalary() = classCount * 200
}

// 학교 직원 클래스. initial은 초봉(반기), years는 경력(년)
class Employee(private val initial: Int, private val years: Int) : Person()
{
    override fun getSalary() = initial * (1.0 + years / 10.0).toInt()
}

// 여러구성원(!)으로부터 학교의 재정을 구한다.
fun getFinance(vararg persons: Person): Int
{
    var i = 0
    var finance = 0
    while (i < persons.size)
    {
        finance -= persons[i].getSalary()
        i += 1
    }
    return finance
}

// 099. Nested class
class Outer(private val value: Int) { // 바깥 클래스
    class Nested { // 중첩 클래스
        fun hello() = println("중첩된 클래스")
    }

    fun print() {
        println(this.value)
    }

    // 100. Inner class
    inner class Inner(private val innerValue: Int) {
        fun print() {
            this@Outer.print()
            println(this.innerValue + this@Outer.value)
        }
    }
}

// 101. Data class 데이터클래스
data class OtherEmployee(var name: String, var age: Int, var salary: Int)

// 106. 함수참조
fun plus(a: Int, b: Int) = println("plus 호출됨 ${a + b}")

object Object {
    fun minus(a: Int, b: Int) = println("Object의 minus 호출됨 ${a - b}")
}

class Class {
    fun average(a: Int, b: Int) = println("Class average 호출됨 ${(a + b) / 2}")
}

// 107. 고차함수
fun decorate(task: () -> Unit) {
    println("=== 작업 시작 ===")
    task()
    println("=== 작업 끝 ===")
}

// 108 클로저
fun returnFunc(num: Int): () -> Unit = { println(num) }

// 110 제네릭
fun <T> toFunction(value: T): () -> T = { value }

// 111 여러타입 받기
fun <T, R> T.map(mapper: (T) -> R): R {
    return mapper(this)
}

// 112
inline fun <reified T> check() {
    val number = 0
    if (number is T)
        println("T는 Int 타입 입니다.")
}

// 113. 클래스 인터페이스에 제네릭 사용
class Pair<A, B>(val first: A, val second: B) {
    override fun toString() = "$first\n$second"
}

// 114. 제네릭이 적용된 클래스/인터페이스 상속,구현
interface Plusable<T> {
    operator fun plus(other: T): T
}

class Rectangle(val width: Int, val height: Int) : Plusable<Rectangle> {
    override fun plus(other: Rectangle) =
        Rectangle(width + other.width, height + other.height)

    override fun toString() = "width: $width, height: $height"
}

// 116 in/out
class AAA<out T>

class BBB<in T>

// 121
fun printAll(vararg tokens: String) {
    for (token in tokens)
        print("$token ")
}

// 123
enum class Mode(val number: Int) {
    SELECTION(0),
    PEN(1),
    SHAPE(2),
    ERASER(3);

    fun printNumber() {
        println("모드: $number")
    }
}

// 125 sealed class
sealed class Outers {
    class One : Outers()
    class Two : Outers()
    class Three : Outers()
}

// 126. Delegated Property
class OnlyPositive {
    private var realValue: Int = 0

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        return realValue
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
        realValue = if (value > 0) value else 0
    }
}

class Sample {
    var number: Int by OnlyPositive()
}

// 127. Class Delegation
interface Plusable2 {
    operator fun plus(other: Int): Int
}

class ClassDelegator : Plusable2 {
    override fun plus(other: Int): Int {
        println("기본 구현")
        return other
    }
}

class Sample2 : Plusable2 by ClassDelegator()
