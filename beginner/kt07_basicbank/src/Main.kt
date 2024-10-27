fun main() {
    println("kt07_basicbank!!")

    // 128. data class Pair<out A, out B>(val first:A, val second:B):Serializable
    val(q,r) = divide(10,3) //Pair 객체로 받아서 두 변수로 분해
    println("몫 : $q | 나머지 : $r")

    // 129. to 확장 함수 : 두 값을 간단히 Pair로 묶기
    // infix fun <A,B> A.to(that:B):Pair<A,B> = Pair(this,that)
    val test:Pair<Int, Double> = 10 to 3.14 // infix로 선언되어 연산자처럼 사용
    println(test)

    // 130. Triple class : 세변수를 하나로 묶기
    // data class Triple<out A, out B, out C>(val first:A, val second:B, val third:C):Serializable
    val (diameter, _, area) = calculateCircle(5)
    println("지름 : $diameter | 넓이 : $area")
}

// 128. a,b의 몫과 나머지를 반환
fun divide(a:Int, b:Int):Pair<Int,Int> = Pair(a/b, a%b) // ==> 두 값을 반환할 수 있음

// 130. Triple 클래스
fun calculateCircle(radius:Int):Triple<Int,Double,Double> =
    Triple(radius*2, radius*2*3.14, radius*radius*3.14)