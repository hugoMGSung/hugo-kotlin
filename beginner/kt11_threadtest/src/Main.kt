import kotlin.concurrent.thread
/* 187. thread 함수 : 스레드 생성하기
(JVM의 스레드를 생성하여 JVM에 의존성 생김)
 */
// 188
import java.util.Timer
import kotlin.concurrent.timer
// 189. synchronized 함수
// import kotlin.concurrent.thread

private var obj:Int = 0

private fun objPlus()
{
    for(i in 1..1000)
        synchronized(obj){ //동기화 블록으로 감싼다. obj를 점유한다.
            obj++
        }
}

/*
fun thread(
    start:Boolean=true, //스레드의 생성과 동시에 실행
    isDaemon:Boolean=false, //데몬 스레드로 만들 것인지
    contextClassLoader:ClassLoader?=null,
    name:String?=null,
    priority:Int=-1,
    block:()->Unit
):Thread
*/

/* 188. timer 함수 - 주기적으로 함수 실행하기

fun timer(
    name:String = null,
    daemon:Boolean = false,
    initialDelay:Long = 0.toLong(), //초기 지연 시간
    period:Long, //주기
    action:TimerTask.()->Unit //주기마다 실행할 함수
):Timer
 */
fun main() {
    println("kt11_threadtest!")

    thread(start=true){
        print("Hello, ")
        Thread.sleep(1000)
        println("World!")
    }

    Thread.sleep(500)
    print("Kotlin ")

    // 바로 "Hello, "
    // 0.5초 "Kotlin "
    // 1초 "World!"

    // 188.
    var i = 1
    val t: Timer = timer(initialDelay=1500, period = 250){
        println(i)
        i += 1
    }

    Thread.sleep(2400)
    t.cancel()

    // 189.
    thread { objPlus() }
    objPlus()
    //두 개의 스레드에서 obj 값을 동시에 증가시키고 있다.
    Thread.sleep(100) // 스레드가 종료될때까지 대기한다.
    println(obj) //2000
}