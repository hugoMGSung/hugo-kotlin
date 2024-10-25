# hugo-kotlin
혼자서 코틀린 공부하기

## 교재
- 초보자를 위한 코틀린 200제 
	- [교재](https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=145772464)

### 개발환경
- JDK
- InteliJ IDEA 

### 시작하기
1. 새 프로젝트 선택
2. 아래처럼 작성

	<!-- ![프로젝트](https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0001.png) -->
	<img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0001.png" width="730">

3. 생성 클릭

### 소스 확인
- Main.kt에 작성된 자동 생성 기본소스

	```kotlin
	fun main(args: Array<String>) {
		println("Hello Kotlin!")

		// Try adding program arguments via Run/Debug configuration.
		// Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
		println("Program arguments: ${args.joinToString()}")
	}
	```

	- fun main() : 기본 엔트리포인트 메서드
		- args: Array<String> 은 기본적으로 필요없음
	
		- println() : 콘솔출력 내장(Built-in) 메서드
		- args.joinToString() : 차후 확인
		- 문장의 마지막 ;(세미콜론)은 사용하지 않음


### 200제 시작

#### 003 변수
- var 와 val로 선언

	```kotlin
	// 003 Variable
    var total: Int
    total = 0

    val a: Int = 10 + 53 - 7
    println(a)
	```

#### 004 리터럴 타입
- 정수 리터럴은 자동 Int 타입
- 소수점이 있는 리터럴은 자동 Double 타입

#### 008 데이터 타입
- Byte
- Short
- Int
- Long
- Float, Double
	- 10L : Long 타입
	- 67.5f : Float 타입
	- (67.5f + 658.4).toFloat() : Float 타입으로 변환하는 메서드
- Any - Object와 동일
- Unit - Java의 void
- Nothing - 정상적으로 끝나지 않음을 나타내는 타입

#### 010 문자타입
- Deprecated 확인

	```kotlin
	ch = 'A'
    println(ch.toInt()) // toInt() is deprecated 
	```

- 일반 문자의 숫자화, 유니코드의 숫자화, 숫자형 문자의 숫자화는 다 다르다!

#### 013 타입별명
- typealias 새로운타입명 = 기존타입

#### 017, 018 논리연산자, 비교연산자
- kt02_basicBank - 00 ~ 018까지 일부 학습

#### 019 흐름제어 if
- 기본 생략

#### 022 if-else 표현식
- 특별한 방식

	```kotlin
    // 022 if-else 표현식
    var value: Int = if (10 > 5) {
        println("10은 5보다 큼")
        10
    } else {
        println("10은 5보다 작음")
        5
    }
    println(value)	
	```

#### 023 흐름제어 - when
- switch - case와 동일

	```kotlin
    // 023 흐름제어 - When
    val score = 64

    when (score / 10) {
        6 -> { println('D') }
        7 -> { println('C') }
        8 -> { println('B') }
        9, 10 -> { println('A') }
        else -> { println('F') }
    }
	```

#### 025~029 while, continue, break
- 설명 생략!

#### 030 Function
- 함수 만들기
	- fun 함수명(): 반환타입 { ... return 반환타입값 }

#### 031 매개변수
- 함수() 괄호안 전달 값

#### 032 Unit타입
- 리턴타입이 없는 함수의 반환타입형

#### 033 디폴트 인수 
- 패스

#### 034 가변인수
- vararg 키워드로 N개의 매개변수를 받을 수 있는 함수 생성 가능

#### 035 함수 오버로딩
- 같은 이름의 함수는 매개변수의 갯수

#### 036 지역변수와 전역변수
- 어떠한 블록에도 소속되지 않은 변수 - 전역변수
- 어떤 블록에 소속된 변수 - 지역변수

#### 037 지역변수와 전역변수 이름 중복
- 전역변수와 지역변수의 이름이 같을때 인식할 수 있는 블록에서 같은 이름의 변수를 쓰면 지역변수가 우선적으로 인식

#### 039 지역함수
- 한 함수 내에 선언된 함수로 블록 내에서만 호출가능

#### 040 메모리 스택영역
- 변수를 선언하면 메모리의 스택(Stack)에 저장됨
- 변수는 선언된 순서대로 스택에 쌓임
- 블록 밖으로 벗어나면 블록안에 선언했던 변수들은 스택에서 사라짐
##### 스택과 힙에 대한 내용을 알고 있어야 함

- 여기까지 kt03_basicBank

#### 041 소스파일 분리
- 함수단위로 분리 가능하며, 다른 파일에서 또 다른 파일의 함수 참조가능

#### 042 Package
- 소스파일을 담는 폴더 - 패키지
- 패키지에 담긴 파일은 package '패키지명' 입력 필요
- 사용시 package '패키지명' 입력 필요

- 단, 패키지와 소스파일 분리를 같이 사용하면 소스파일 분리에서 사용한 함수는 사용 불가
- 그래서,

#### 043 다른 패키지 함수 호출
- 패키지명.함수 로 사용하면 이전 다른 소스 함수와 병행가능
- 결론, 패키지로 모두 작업하는게 가장 깔끔하다

#### 044 import
- 패키지명 없이 다른 패키지에 선언된 함수에 접근하고 싶을 때 사용 

- 여기까지 kt04_basicBank

#### 045~046 Object and 메모리 힙영역
- object { 속성(프로퍼티)나열 }
- 객체는 힙(Heap)에 생성
- 힙은 객체를 무작위의 위치에 보관하기 때문에 객체의 위치(주소)를 변수에 저장하고 있어야 접근 가능
- 객체 위치를 저장하는 변수를 참조변수라고 함


#### 047 Class
- 똑같은 형태의 객체를 여러번 생성하고 싶을때 사용
- class 클래스명 { 속성 나열 } 형태
- 타언어와 같이 new를 사용하지 않음

#### 048 힙영역에 저장하는 이유
- 힙 영역에 있으면 여러 참조 변수가 하나의 객체를 공유할 수 있기 때문
- 블록밖을 빠져나와도 객체는 힙에서 지워지지 않으므로 특정 블록에서 생성한 객체를 다른 블록으로 전달할 수 있음

#### 049 문자열간 + 연산시 주의점
- 문자열간 + 연산시 마다 새로운 문자열이 계속 힙에 생성됨

#### 050 Garbage Collection
- 참조변수와 연결이 끊어진 객체는 가비지컬렉션에 의해 소멸됨
- 일정조건(메모리 부족 등) 만족시만 발생함
- 049 같은 경우라도 너무 걱정하지는 말것

#### 051 ===, !==
- 두 참조변수가 같은 객체를 가리키고 있는지 여부 조사

#### 052 멤버함수
- 클래스에 포함된 함수
- 클래스 내의 멤버변수를 this 키워드로 접근(생략가능)

#### 053 프로퍼티와 멤버함수의 매개변수 이름이 중복시
- this 키워드 사용

#### 054 생성자와 초기화 블록
- 객체를 초기화 하는 특수함수
- 객체가 생성되는 순간 호출

#### 055 Init 블록 나누기
- init 블록을 여러번 나눠쓸 수 있음

#### 056 생성자와 프로퍼티 한번에 쓰기
- 당연한것

#### 057 보조생성자
- 클래스 이름 바로 옆에 선언한 생성자 - 주 생성자
- 보조 생성자는 파라미터 오버로딩 이어야 하고 주 생성자를 반드시 호출해야
- constructor(...) : this(...) 형태로 호출

#### 058 프로터리 Getter/Setter
- Getter - 프로퍼티 값을 읽을때 호출되는 특수 함수
- Setter - 프로퍼티 값을 저장할 때 호출하는 특수 함수

- 기본적인 getName(), setName(name:String) 일반적인 방식과
- 커스텀 방식 존재
- 단, 이때는 val은 사용 불가, 무조건 var로 시작할 것

	```kotlin
	var name: String = name
		get() = name
		set(value) {
			field = value
		}

	var age: Int = age
		get() { return age + 1 }
		set(value) {
			field = value
		}
	```
##### 되도록은 쓰지 말것

#### 059 연산자 오버로딩
- operator 키워드 사용

	```kotlin
	class Point(var x: Int = 0, var y: Int = 0)
	{
		operator fun plus(other: Point): Point {
			return Point(x + other.x, y + other.y)
		}

		operator fun minus(other: Point): Point {
			return Point(x - other.x, y - other.y)
		}

		operator fun times(number: Int): Point {
			return Point(x * number, y * number)
		}

		operator fun div(number: Int): Point {
			return Point(x / number, y / number)
		}

		// 좌표 값을 출력
		fun print() {
			println("x: $x, y: $y")
		}
	}
	
	```

#### 060 번호붙은 접근 연산자(Indexed Access Operator)
- [] 연산자는 객체의 일부 값을 추출해낼 때 사용
- '표현식[표현식]' 형태로 사용
- get 이라는 이름의 멤버 함수로 오버로딩

#### 061 호출연산자 Invoke Operator
- 객체명(파라미터) 형태로 호출
- invoke() 라는 함수 선언

	```kotlin
	fun main() {
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
	```

#### 062 in 연산자
- 어떤 값이 객체에 포함되었는지 조사할 때 사용
- '표현식 in 표현식' 형태로 사용

#### 063 멤버함수 중위 표기법
- 멤버 함수 앞에 infix 를 붙이면 연산자처럼 호출
- infix 가 붙은 멤버 함수는 매개변수가 하나만 가능


	```kotlin
	class Point(var x: Int = 0, var y: Int = 0)
	{
		// base를 원점으로 생각했을 때의 좌표를 반환한다.
		infix fun from(base: Point): Point
		{
			return Point(x - base.x, y - base.y)
		}
	}
	
	fun main(args: Array<String>)
	{
		val pt = Point(3, 6) from Point(1, 1)
		println(pt.x)
		println(pt.y)
	}
	
	```

#### 064 상속 Inheritance
- 상속은 이미 존재하는 클래스를 확장하여 새로운 클래스를 정의하는 OOP 기법
- class BaseClass(…) : ExtendClass(…) 형태로 선언
- 확장할 클래스를 슈퍼(부모)클래스, 확장된 클래스를 서브(자식)클래스로 명칭
- 클래스는 한 개만 상속 가능

#### 065 업캐스팅 Upcasting
- 서브클래스 타입의 표현식은 슈퍼클래스 타입으로 가리킬 수 있음 - 업캐스팅
- 슈퍼클래스에는 서브클래스의 모든 내용이 들어있으므로 서브클래스의 객체가 슈퍼클래스를 가리킨다고 해도 논리적으로 문제없음

	```kotlin
	open class Person(val name: String, val age: Int)
	
	class Student(name: String, age: Int, val id: Int) : Person(name, age)
	
	fun main(args: Array<String>)
	{ 
		val person: Person = Student("John", 32, 20200156) // 업캐스팅!
	}
	```

#### 066 오버라이딩 Overriding
- 슈퍼클래스의 멤버함수를 서브클래스에서 덮어버리고 새로운 기능으로 바꿔버리는 것
- 오버라이딩할 슈퍼클래스에는 반드시 open을, 오버라이딩할 서브클래스 함수에는 override를 입력

	```kotlin
	open class AAA
	{
		open fun func() = println("AAA")
	}
	
	class BBB : AAA()
	{
		override fun func()
		{
			super.func()
			println("BBB")
		}
	}
	
	```

#### 067 프로퍼티 오버라이딩
- 생략!
- 커스텀 프로퍼티를 권장하지 않음

#### 069 클래스를 상속하는 객체
- ‘object : 상속할 클래스(생성자 인수) { … }’ 형태로 생성

#### 070 Any 클래스
- 모든 클래스는 Any 클래스를 자동으로 상속
- Any 클래스에는 equals, hashCode, toString 이라는 멤버함수 존재
- 코틀린의 모든 클래스는 저 3개의 멤버 함수를 가짐

#### 072 예외처리
- try ~ catch (e: NumberFormatException) ~ finally 형태
- 나머지 내용 생략

#### 073 예외던지기
- 우리가 직접 예외를 일으킬 수도 
- 예외를 일으킬 때는 ‘throw 예외 객체’ 
- 예외 객체는 Throwable 클래스를 상속하는 클래스로부터 생성된 객체여야 함

#### 074 Nothing 타입
- Nothing 은 특수한 표현식을 위한 특수 타입
- 'throw 예외 객체' 도 표현식이며, 이 표현식은 Nothing 타입을 갖는다

	```kotlin
	fun throwing(): Nothing = throw Exception()
	
	fun main(args: Array<String>)
	{
		println("start")
		val i: Int = throwing()
		println(i)
	}
	```

#### 075 Nullable 타입과 null
- Nullable: null 을 지정할 수 있음을 뜻함
- null: 참조 변수가 아무것도 가리키지 않음을 뜻함
- 타입명 뒤에 ? 을 붙이면 변수를 Nullable 하게 생성