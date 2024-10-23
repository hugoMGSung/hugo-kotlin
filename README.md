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