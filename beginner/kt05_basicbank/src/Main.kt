package kt05_basicbank

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
}

// 061. Invoke operator
class Product(var id: Int, var name: String) {
    operator fun invoke(value: Int) {
        println(value)
        println("ID: ${id}\nNAME: ${name}")
    }
}