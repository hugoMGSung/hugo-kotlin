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
}

