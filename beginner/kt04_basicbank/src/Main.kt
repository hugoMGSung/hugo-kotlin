// package math_package
//import math_package.min2
//import math_package.abs2
import math_package.*

fun main() {
    println("kt04_basicbank")

    // 041. 소스파일 분리
    val a = 20
    val b = -30

    println(max(a, abs(b)))

    // 042. Package
    // println(min2(a, abs2(b))) 
    // println(math_package.min2(a, math_package.abs2(b))) // 043. 다른 패키지 함수 호출
    println(min2(a, abs2(b))) // 044. import

}