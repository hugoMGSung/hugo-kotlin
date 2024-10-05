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

#### 010 문자타입
