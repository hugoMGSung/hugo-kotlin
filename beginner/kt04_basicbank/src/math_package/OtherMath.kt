package math_package

// a와 b 중 더 큰 수를 반환하는 함수
fun max2(a: Int, b: Int): Int =
    if (a > b) a else b

// a와 b 중 더 작은 수를 반환하는 함수
fun min2(a: Int, b: Int): Int =
    if (a < b) a else b

// num의 절대값을 반환하는 함수
fun abs2(num: Int): Int =
    if (num >= 0) num else -num