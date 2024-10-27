fun main() {
    println("kt08_basicbank!!")

    // 131. Comparable interface
    val rect = Rectangle(3,5) //15
    val rect2 = Rectangle(6,4) //24
    val rect3 = Rectangle(8,2) //16

    println(rect >= rect3)  //false
    println(rect < rect2)   //true
    println(rect2 > rect3)  //true

    println(rect.compareTo(rect2))  //-1

    // 132. ClosedRange interface
    /*
    ClosedRange 인터페이스 - 닫힌 구간을 표현
    interface ClosedRange<T:Comparable<T>> {
        val start:T
        val endInclusive:T
        //value가 구간에 속하는지
        operator fun contains(value:T):Boolean = value >= start && value <= endInclusive
        //구간이 비어있는지
        fun isEmpty():Boolean = start > endInclusive
    }
     */
    var intRange: IntRange = 1..10
    var longRange: LongRange = 1L..100L
    var charRange: CharRange = 'A'..'Z'

    println(intRange.start)
    println(longRange.endInclusive)
    println('*' in charRange)
    println(charRange.isEmpty())
    
    // 133. Iterable interface - 클래스 반복자 지원
    var prog:IntProgression = 2..8
    println(prog.first)
    println(prog.last)
    println(prog.step)

    for (i in prog) {
        print("$i\t")
    }

    // 135. Collection
    // fun<T> listOf(vararg elements:T):List<T>
    var list:Collection<Int> = listOf(10,20,10)
    // fun<T> setOf(vararg elements:T):Set<T>
    var set:Collection<Int> = setOf(1,2,3,2,3)
    // fun<K,V> mapOf(vararg pairs:Pair<K,V>):Map(K,V)
    //val map:Map<String, String> = mapOf("Apple" to "사과", "Banana" to "바나나")

    /*
    136. Collection 인터페이스

    interface Collection<out E>:Iterable<E> //iterator()함수 주입

    멤버 함수
    abstract val size:Int
    abstract fun isEmpty():Boolean
    abstract operator fun contains(element:E):Boolean
    abstract fun containsAll(elements:Collection<E>):Boolean
    abstract fun iterator():Iterator:Iterator<E>
    */

    /*
    137. List 인터페이스
    interface List<out E>:Collection<E>

    abstract operator fun get(index:Int):E //[]연산자
    abstract fun indexOf(element:E):Int
    abstract fun lastIndexOf(element:E):Int //indexOf에서는 일치하는 첫번째 인덱스, 여기서는 마지막 인덱스
    abstract listIterator():ListIterator<E> //iterator를 반환
    abstract fun listIterator(index:Int):ListIterator<E> //index부터 시작하는 iterator 반환
    abstract fun subList(fromIndex:Int, toIndex:Int):List<E> // [fromIndex,toIndex) 리스트 반환
     */

    /*
    138. ListIterator 인터페이스
    Iterator<T> 인터페이스를 구현

    abstract fun hasPrevious():Boolean
    abstract fun previous():T //커서를 옮김
    abstract fun nextIndex():Int
    abstract fun previousIndex():Int

     */

    /*
    139. Map 인터페이스
    interface Map<K, out V>
    멤버
    interface Entry<out K, out V>
    abstract val size:Int
    abstract val keys:Set<K> //Key는 중복되지 않으므로 Set
    abstract val values:Collection<V>  //Value는 중복될 수 있으므로 Collection
    abstract val entries:Set<Map.Entry<K,V>> //모든 (key, value) 쌍

    abstract fun isEmpty():Boolean
    abstract fun containsKey(key:K):Boolean
    abstract fun containsValue(value:V):Boolean
    abstract operator fun get(key:K):V? //null을 반환할 수 있도록, []연산자
    open fun getOrDefault(key:K, defaultValue:V):V //key에 해당하는 값이 없을 때 defaultValue를 반환

     */
    var map:Map<String, String> = mapOf("Apple" to "사과", "Banana" to "바나나")

    println(map.size)
    println(map.keys)
    println(map.values)
    println(map.entries)
    println(map.isEmpty())
    println(map.containsKey("Cocoa"))
    println(map.containsValue("바나나"))
    println(map["Apple"])
    println(map.getOrDefault("Cocoa", "코코아"))

    /*
    140. Mutable Collection
    코틀린의 컬렉션은 기본적으로 수정이 불가능. Thread-safe한 코드 생성가능. (권장사항)
    원소를 추가하거나 삭제하기 위해 MutableCollection
    interface MutableCollection<E>:Collection<E>, MutableIterable<E>

    interface MutableIterable<out T>:Iterable<T>
    {
        override fun iterator():MutableIterator<T>
        //Interable 인터페이스의 iterator 함수를 오버라이드해서 MutableIterator 타입으로 반환
    }
    멤버
    abstract fun add(element:E):Boolean //원소 추가 후 true 반환, 중복되어 추가 못할 시 false
    abstract fun addAll(elements:Collection<E>):Boolean //모두 추가되면 true
    abstract fun removeAll(elements:Collection<E>):Boolean//하나라도 제거시 true
    abstract fun retainAll(elements:Collection<E>):Boolean //일치하는 원소만 남김, 하나라도 제거되면 true
    abstract fun clear() //모든 원소 삭제
     */
    val mutableList:MutableCollection<Int> = mutableListOf(1,2,4,2,3,2,5)
    println(mutableList)

    mutableList.add(1)
    println(mutableList)

    mutableList.addAll(listOf(3,2,4))
    println(mutableList)

    mutableList.remove(1)
    println(mutableList)

    /*
    141. MutableIterator 인터페이스

    public interface Mutable<out T>:Iterator<T>
    {
        public fun remove():Unit
    }
    */
    list = mutableListOf(1,2,3)
    val iter:MutableIterator<Int> = list.iterator()

    println(list)

    iter.next(); iter.remove() //가리키는 원소를 삭제한다.
    println(list)

    iter.next();iter.remove()
    println(list)

    /*
    142. MutableList 인터페이스 - MutableCollection 상속
    mutableListOF로 객체 생성

    abstract fun add(index:Int, element:E):Unit
    abstract fun addAll(index:Int, elements:Collection<E>):Boolean //index 위치에 elements 모두 추가
    abstract operator fun set(index:Int, element:E):E //[] 연산자, index 위치 원소를 element로 교체, 이전 값 반환
    abstract fun removeAt(index:Int):E //index 위치 원소 삭제
     */

    /*
    143. MutableListIterator 인터페이스
    - ListIterator, MutableIterator 구현
    abstract fun set(element:T):Unit //커서 위치에 교체
    abstract fun add(element:T):Unit //커서 위치에 추가
     */

    /*
    144. MutableSet 인터페이스
    - 같은 원소는 추가 불가
    - mutableSetOf() 호출하여 생성
    - MutableCollection<E> 상속
     */

    /*
    145. MutableMap 인터페이스
    - mutableMapOf 함수 호출하여 생성
    - Map<K,V> 상속

    interface MutableEntry<K,V>:Map.Entry<K,V>
    {
        fun setValue(newValue:V):V
    }

    override val keys:MutableSet<K>
    override val values:MutableCollection<V>
    override val entries:MutableSet<MutableMap.MutableEntry<K,V>>
    abstract fun put(key:K, value:V):V? //key에 value를 설정하고 원래 값 반환 or null 반환
    abstract fun remove(key:K):V? //삭제된 값 반환 or null 반환
    abstract fun remove(key:K, value:V):Boolean //key와 value가 일치하는 쌍을 삭제, true or false
    abstract fun putAll(from:Map<out K,V>):Unit
    abstract fun clear():Unit

    inline operator fun<K,V> MutableMap<K,V>.set(key:K, value:V):Unit
    {
        put(key,value)
    } // map[key] = value 로 값 설정
     */
    var map2:MutableMap<String, String> = mutableMapOf()
    println(map2)

    println(map2.put("Good morning", "Guten Morgen"))
    println(map2)

    println(map2.put("Good morning", "좋은 아침"))
    println(map2)

    map2["Good morning"] = "Bonjour"
    println(map2)

    map2.putAll(mapOf("Blue" to "파랑", "Red" to "빨강"))
    println(map2)

    println(map2.remove("Blue"))
    println(map2)

    println(map2.remove("Red", "빨"))
    println(map2)

    println(map2.remove("Red", "빨강"))
    println(map2)

    map2.clear()
    println(map2)

    /*
    146. Sequence 인터페이스
    List와 달리 데이터를 게으르게 계산. (필요한 순간에 계산을 시작.(
    -> 무한대의 데이터 핸들

    크기가 정해져 있지 않음. size, length 같은 프로퍼티는 없음
    interface Sequence<out T>
    {
        operator fun iterator():Iterator<T>
    }
     */
    val seq:Sequence<Int> = sequenceOf(1,2,3)

    for(i in seq)
        print("$i")

    /*
    148. 컬렉션 중 원하는 원소 걸러내기
    (T) -> Boolean ㅅ타입의 함수를 인수를 받음
    */
    val to50 = 1..50

    println(to50.filter{it%4==0})
    println(to50.filterNot{it%4==0})
    println(to50.filterNotNull()) //null이 아닌 원소만 걸러냄
    println(to50.filterIndexed{index, element -> element > 20}) //매개변수 index
    println(to50.filterIsInstance<Long>())//타입에 맞는 원소만 걸러냄

    // 149. 컬렉션 정렬 - store 계열 확장 함수 사용
    list = listOf(42,15,36,51,23)

    println(list.sorted())
    println(list.sortedDescending())

    // 150
    /*
    CharSequence 인터페이스 - 문자열 관련 클래스의 뼈대 인터 페이스
    String, StringBuilder가 구현

    CharSequence 멤버
    abstract val length:Int
    abstract operator fun get(index:Int):Char
    abstract fun subSequence(startIndex:Int, endIndex:Int):CharSequence
    */
    var seq1:CharSequence = "Hello"
    println(seq1.length)
    println(seq1[2])
    println(seq1.subSequence(1,4))

    // 151. CharSequence 확장함수 - 접두사, 접미사 관련
    var str:CharSequence = "https://www.naver.com"

    //prefix로 시작하거나 suffix로 끝날 때 true / 아닐 때 false 반환, 대소문자 구분 안 할시 ignoreCase true
    println(str.startsWith("https://",ignoreCase = true)) //true
    println(str.endsWith(".com")) //true

    //prefix로 시작하거나 suffix로 끝나면 이것을 삭제한 문자열 반환
    println(str.removePrefix("https://"))
    println(str.removeSuffix(".com"))

    //prefix로 시작하고 suffix로 끝날 때 이것을 삭제한 문자열 반환
    println(str.removeSurrounding("https://", ".com")) // www.naver
    println(str.removeSurrounding(prefix = "https://", suffix = ".net")) //https://www.naver.com

    // 152. CharSequence 빈여부 확인
    val emptyStr = ""
    val whiteSpace = " "
    val nullStr:String? = null

    //isEmpty는 ""와 같은 지 비교
    println(emptyStr.isEmpty())
    println(whiteSpace.isEmpty()) // false

    //isBlank는 isEmpty이거나 공백 문자로 이루어졌는지 비교
    println(emptyStr.isBlank())
    println(whiteSpace.isBlank())

    //isNullOrEmpty는 null이거나 isEmpty인지
    println(nullStr.isNullOrEmpty())
    //isNullOrBlank는 null이거나 공백 문자로 이루어져있는지
    println(nullStr.isNullOrBlank())

    //아래 모두 true
    println(emptyStr.isNullOrBlank())
    println("    ".isNullOrBlank())
    println("".isNullOrBlank())
    println("\n".isNullOrBlank())
    println("\t".isNullOrBlank())
    println("\n\t".isNullOrBlank())

    // 153. CharSequence 가공하는 확장 함수
    str = "  hello "

    println(str.removeRange(0..2))          //ello

    // 앞/뒤를 padChar로 채워서 길이를 length로 만들기
    println(str.padStart(20, '*'))  //************  hello
    println(str.padEnd(17,'&'))     //  hello &&&&&&&&&

    println(str.trimStart())    //hello
    println(str.trimEnd())      //  hello
    println(str.trim())         //hello

    println(str.slice(3..5))       //ell
    println(str.subSequence(3..5))  //ell
    println(str.substring(3..5))    //ell

    println(str.reversed())               // olleh

    // 154. CharSequence 쪼개기
    var hello:CharSequence = "안녕하세요\n감사해요\n잘있어요"
    var date:CharSequence = "2020.12.29"

    println(hello.lines()) //'\n' 기준으로 자르기, List<String> 타입으로 반환
    for(line in hello.lineSequence()) //Sequence<String> 타입으로 반환
        print(line+"/")
    println()
    println(date.split('.'))
}

/* 131. Comparable 인터페이스 - 클래스를 비교 가능하게

interface Comparable<in T>
{
    operator fun compareTo(other:T):Int //이 인터페이스를 상속한 클래스 끼리 비교 (> < <= >=)
}
.. 연산자 지원
 */

class Rectangle(val width:Int, val height:Int):Comparable<Rectangle>
{
    val area = width*height

    override fun compareTo(other: Rectangle):Int=
        when
        {
            this.area > other.area -> 1
            this.area < other.area -> -1
            else -> 0
        }
}