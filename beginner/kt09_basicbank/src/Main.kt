import java.util.*
import kotlin.math.*
// 183.
import kotlin.system.exitProcess

// 184.
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun main() {
    println("kt09_basicbank!")

    /*157. StringBuilder 클래스 - 문자열 덧붙이기

    class StringBuilder:CharSEquence, Appendable

    interface Appendable
    {
        fun append(csq:CharSequence):Appendable
        fun append(csq:CharSequence, start:Int, end:Int):Appendable
        fun append(c:Char):Appendable
    }
     */
    val builder = StringBuilder()
        .append("2020")
        .append("-12")
        .append("-29")

    println(builder)

    val result = builder.toString()
    println(result)

    // 158. Regex class
    val regex = Regex("[0-9]+")
    val str = "5243251"
    val str2 = "877 5424 3214"

    println(regex matches str)  //true
    println(regex matches str2) //false
    println(regex.replace(str2, "숫자"))  //숫자 숫자 숫자

    /* 159. toList 확장 함수
    - List 타입으로 변환하기

    fun <T> 타입.toList():List<T>
     */
    // 같은 타입으로 이루어져 있어야 한다. Pair(10,"h") 안됨
    var list:List<Int> = Pair(10, 20).toList()
    var list2:List<Double> = Triple(5.2,3.15,6.493).toList()
    println(list)
    println(list2)

    /* 160. run 확장 함수 - 코드 중복 줄이기
    inline fun <T,R> T.run(block:T.()->R):R
    {
        return this.block()
    }
     */
    val a = 10
    val b = 5

    (a*b - 2*a).run {
        if(this > 0)
            println(this)
    }

    // run 의 리시버는 (a*b - 2*a)
    // 매개변수로 받음 함수 ({} 내부) 를 바로 호출하고 this는 리시버
    // if(a*b - 2*a > 0) println(a*b - 2*a)
    // 중복되는 (a*b - 2*a)를 this로 묶은 것

    /* 161.let 확장 함수 - run과 같은 역할을 한다.

    inline fun <T,R> T.let(block:(T)->R):R
    {
        return block(this)
    }
     */
    (a*b - 2*a).let { result:Int->
        if(result > 0)
            println(result)
    }
    //표현식의 결과가 매개변수 result로 들어가 사용

    /* 162. with 함수 - this로 표현식 전달

    inline fyn <T,R> with(receiver:T, block:T.()->R):R
    {
        return receiver.block()
    }
     */
    with(a*b - b*b){
        println(this)
        println(-this)
    }

    // 163. apply function
    println(
        Person().apply {
            this.name = "Alan"
            this.money = 70
        }.toSting()
    )

    /* 164. also 함수
    - 객체 생성 및 초기화를 하나의 표현식으로 압축

    fun <T> T.also(block:(T)->Unit):T
    {
        block(this)
        return this
    }

    Person().also {person:Person ->
            person.name = "Alan"
            person.money = 70
        }
     */

    /* 165. lazy 함수
    - 프로퍼티의 값이 필요한 시점에 계산을 시작하게 함

    fun <T> lazy(initializer:()->T):Lazy<T>

    게으른 초기화의 이점
    - 실제로 가지고 있지 않은 데이터를 지금 당장 갖고 있는 것처럼 과장할 수 있다.

    class AAA
    {
        var num:Int = 0
        val num2 by lazy {num*5}
    }
     */

    /* 166. BigInteger 클래스
    - 매우 큰 정수
    import java.math.BigInteger

    val a = 78423343545.toBigInteger()
    */

    /* 167. BigDecimal 클래스
    - 매우 작은 실수 보관하기
    - 소수점 자리가 아무리 길어도 실수 값을 정확히 표현할 수 있어 오차 없이 정확하계 계산

    val b = 4.0000000000004.toBigDecimal()
    */

    /* 168. 최댓값, 최솟값 - max, min 함수

    import kotlin.math.max
    import kotlin.math.min
    */

    /* 169. 실수 값 올림, 내림, 반올림
    import kotlin.math.*
    */
    println("${ceil(5.2)}")
    println("${ceil(5.6)}")
    println("${floor(5.2)}")
    println("${floor(5.6)}")
    println("${round(5.2)}")
    println("${round(5.6)}")
    println("${15.62.roundToInt()}")
    println("${52419.58.roundToLong()}")

    /* 170. abs - 절댓값
    import kotlin.math.abs
    */

    /* 171. E, Pi
    Kotlin.math 패키지에 상수로 선언되어있다. (Double)

    import kotlin.math.PI
    import kotlin.math.E
    */

    /* 172. hypot 함수로 빗변 길이 구하기 (x제곱 + y제곱)

    import kotlin.math.hypot

    hypot(5.0, 12.0)
    */

    /* 173. 지수함수
    sqrt - square root 제곱근
    pow - 리시버의 인수 제곱
    exp - e의 인수 제곱
    expm1 - e의 인수 제곱 -1

    import kotlin.math.exp
    import kotlin.math.expm1
    import kotlin.math.pow
    import kotlin.math.sqrt
     */

    // 174. 로그함수
    // log(...), log2(...), log10(...), ln(...), etc

    // 175. 삼각함수
    // sin(...), cos(...), tan(...), etc

    /* 176. toBits, toRawBits 확장 함수
    - 이진수 배열로 나타내기
    */

    /* 177. fromBits 확장함수
    이진수 -> 실수 변환하기

    Float.fromBits(0b01000001_00100111_10101110_00010100)
    */

    /* 178. Any?.toString 확장 함수

    fun Any?.toString():String = this?.toString() ?:"null"
    (엘비스 연산자 - this?.toString()이 null일 때 null 반환)
    */

    /* 179. String?.plus 연산자 확장 함수 - null인 String에도 + 사용
    operator fun String?.plus(other:Any?):String
    {
        return this.toString() + other.toString()
    }
    */

    /* 180. Double 값 검증하기
    NaN 또는 Infinite
    */
    val d:Double = 0.0/0.0
    val e:Double = 7/0.0
    val f:Double = 3.2

    println("$d")
    println(d.isNaN())

    println("$e")
    println(e.isInfinite())

    println("$f")
    println(f.isFinite())

    // 181.
    func(10)
    func2(0.0/0.0)

    /* 182. KotlinVersion클래스 - 코틀린 버전 알아내기
    */
    val kotlinVersion:KotlinVersion = KotlinVersion.CURRENT
    println("${kotlinVersion.major}.${kotlinVersion.minor}.${kotlinVersion.patch}")
    println(kotlinVersion.isAtLeast(1,1,0))

    // 183.
    // something(-1) //종료
    println("hello") //출력되지 않음

    // 184. 성능측정
    println(measureTimeMillis {
        var sum = 0L
        for(i in 1..100000000)
            sum += i
    })

    println(measureNanoTime {
        var sum = 0L
        for(i in 1..100000000)
            sum += i
    })
}

/* 163. apply 함수
객체 생성과 초기화 코드를 하나로 묶는다.

inline fun<T> T.apply(block:T.()->Unit):T
{
    this.block() //함수 호출
    return this //리시버 반환
}
 */
class Person:Object()
{
    var name:String = ""
    var age:Int = 0
    var money:Int = 0
    fun toSting() = "$name $age $money" //override가 안됨 ???
}

/* 181. 인수 Argument 유효성 검증하기
check, require 함수로 조건을 검사하고 예외를 던진다.
 */
fun func(num:Int?)
{
    checkNotNull(num) //num이 null이면 IllegalStateException을 던진다.
    //null이 아니면 Non-null 타입으로 캐스팅하여 반환한다.
    check(num!!>=0) //표현식이 false이면 IllegalStateException을 던진다.
}

fun func2(num:Double?)
{
    requireNotNull(num) //num이 null이면 IllegalStateException을 던진다.
    //null이 아니면 Non-null 타입으로 캐스팅하여 반환한다.
    require(num!!.isNaN()) //표현식이 false이면 IllegalStateException을 던진다.
}

/* 183. exitProcess - 어디서나 프로그램 종료하기

import kotlin.system.exitProcess

inline fun exitProcess(status:Int):Nothing
status에 0을 넣어 전달하면 정상 종료, 다른 값을 넣으면 비정상 종료
*/
fun something(num:Int) {
    if(num < 0)
        exitProcess(0)
}

/* 184. 코드 성능 측정하기
measureTimeMillis
measureNanoTimes
Unit 타입 함수를 매개변수를 받아 실행하여 시간을 측정

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis
 */