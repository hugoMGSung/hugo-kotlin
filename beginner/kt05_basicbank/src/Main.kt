package kt05_basicbank

import org.jetbrains.annotations.Nullable

// 047. Class
class Manager {
    var name: String = ""
    var level: Int = 1
}

// 048. 힙에 저장하는 이유
fun createManager(): Manager {
    var mng9 = Manager()
    mng9.name = "Hugo"
    mng9.level = 19

    return mng9
}

fun levelUpManager(mng: Manager) {
    mng.level += 10
}

fun checkManagerInfo(mng: Manager) {
    println("Name -> ${mng.name} / Level -> ${mng.level}")
}

// 054. Contructor와 Initializer
class Person constructor(name: String, age: Int) {
    // val은 사용 불가!
    var name: String = name
//        get() = name
//        set(value) {
//            field = value
//        }
//    fun getName():String {
//        return name
//    }


    var age: Int = age
//        get() { return age + 1 }
//        set(value) {
//            field = value
//        }

    init {
        this.name = name
        this.age = age
    }
}

class BornPerson(var name: String, var birthday: String) {
    operator fun get(position: Int): String {
        return when (position) {
            0 -> name
            1 -> birthday
            else -> "알수 없음"
        }
    }

    operator fun set(position: Int, value: String) {
        when (position) {
            0 -> name = value
            1 -> birthday = value
        }
    }
}

fun main() {
    println("kt05_basicbank")

    // 045. Object
    var person = object {
        var name: String = "애슐리"
        var age: Int = 40
    }

    print(person.name)
    print(", ")
    println(person.age)

    println("${person.age} and ${person.name}")

    // 047. Class
    var mng1: Manager
    mng1 = Manager()
    mng1.name = "홍길동"
    mng1.level = 9

    var mng2: Manager
    mng2 = Manager()
    mng2.name = "홍길순"
    mng2.level = 4

    println(mng1)

    // 048. reason of Using heap
    val mng: Manager; mng = createManager()
    checkManagerInfo(mng)
    levelUpManager(mng)
    checkManagerInfo(mng)

    // 054.
    val someone = Person("홍길자", 66)
    println("이름: ${someone.name}, 나이: ${someone.age}")

    // 060. Indexed Access Operator
    var bPerson = BornPerson("코코코", "2024-10-20")
    println(bPerson[0])
    println(bPerson[1])

    bPerson[0] = "자바바"
    println(bPerson[0])

    // 061. Invoke operator
    var prd760921 = Product(760921, "HUGO")
    prd760921(108)

    // 062. in operator
    println('o' in "Hi, Kotlin!")

    // 054.
    var building = Building()
    building.name = "H프라자"
    building.date = "1989-12-13"
    building.area = 150 * 9
    building.print()

    // 076. Safe call operator ?.
    var bld: Building? = null
    bld?.print() // 아무것도 나오지 않음
    bld?.name = "먼건물"

    bld = Building()
    bld?.name = "경기장"
    bld?.date = "2020-10-01"
    bld?.area = 3_456
    bld?.print()

    // 077.
    var obj: Building? = Building()
    obj!!.name = "서울시청"
//    println(obj!!.name)
    obj!!.print()

    obj = null
//    obj!!.print() // unresolved reference: print

    // 079. Smart Casting
    val number: Int? = null
    val number2 = 1225

    checkNull(number)
    checkNull(number2)

    println(number is Int?)

    // 089. 동반자 객체
    var aP = People.create()
    var bP = People.create()
    println(People.countCreated)

    // 091. const
    println(Foo.bar)
    //Foo.bar = "noBar"
}

// 079
fun checkNull(any: Any?) {
    if (any == null) {
        println("null이 들어왔습니다.")
        return
    }
    println(any.toString())
}

// 061. Invoke operator
class Product(var id: Int, var name: String) {
    operator fun invoke(value: Int) {
        println(value)
        println("ID: ${id}\nNAME: ${name}")
    }
}

// 052. Member function
class Building {
    var name = ""   // 건물명
    var date = ""   // 건축일자
    var area = 0    // 면적

    fun print() {
        println("건물명: ${this.name}")
        println("건축일: ${this.date}")
        println("면적: ${this.area} ㎡")
    }
}

// 086. Companion object
class People private constructor() {
    companion object {
        fun create(): People {
            countCreated += 1
            return People()
        }

        var countCreated = 0
            private set
    }
}

// 091
object Foo {
    const val bar = "bar"
}