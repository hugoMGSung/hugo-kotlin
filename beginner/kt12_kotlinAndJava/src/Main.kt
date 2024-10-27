// 192.
import java.util.*

fun main() {
    println("kt12_kotlinAndJava!")

    // 190. 코틀린에서 자바 코드 접근하기
    val rand:Double = Math.random()// double 타입이 Double 타입으로 변환
    //자바의 Math.random 메서드
    // public static double random()
    println(rand)

    val buffer:StringBuffer = StringBuffer()
    //자바의 StringBuffer 클래스
    buffer.append("Hello, ") //java.lang.String 타입 인수 -> kotlin.String 타입
    buffer.append("world!")
    val result:String = buffer.toString()
    println(result)

    /* 191. 코틀린에서 자바 코드 접근하기 - Null 안전성
    자바의 참조 타입 -> 느낌표가 붙는다. (null을 허용하기 때문에)
    자바의 원시 타입 -> 느낌표 없이 인식됨.
    */
    val javaInterface:JavaInterface = KotlinClass()
    println(javaInterface.trim("  hi   "))

    // 192. 코틀린에서 자바 코드 접근하기 - 키워드 충돌
    val scanner:Scanner = Scanner(System.`in`)

    // 자바의 System 클래스 내 정적 필드 in => ``로 감싸주기
    // val `어떤 변수`:Int = 10
    // println(`어떤 변수`)

    /* 193. SAM(Single Abstract Method) 변환 (Runnable, Comparable 등)
    추상메서드 한개를 가진 인터페이스  */
    val runnable:Runnable = Runnable { println("SAM") } //인터페이스 바로 구현
    runnable.run()

    /* 194. 자바 getter / setter 접근하기 
       JavaClass.java를 생성해야 함
    */
    val java = JavaClass()

    java.something = 301
    println(java.something)

    println(java.isGood)
    println(java.doubleValue)

    // 195. 자바코드 접근하기 - 연산자 오버로딩
    // JavaClass2.java 생성
    var java2 = JavaClass2()

    println(13 in java2) //contains 호출 => true
    println(java2[13])   // get 호출 => 80
    println(java2[28])
    println(java2[18])

    // 196. 자바코드 접근하기 - 클래스 접근
    val number:Int = 27
    val str:String = "2021년"

    //인스턴스 뒤에 ::class.java를 적으면 자바와 호환되는 Class<T> 타입의 객체를 가져온다.
    JavaClass3.printClassInfo(number::class.java)
    JavaClass3.printClassInfo(str::class.java)
    JavaClass3.printClassInfo(Double::class.java)
}

// 191. JavaInterface.java 파일과 연계
class KotlinClass:JavaInterface {
    override fun trim(str: String?): String = str?.trim()?:""
}