# hugo-kotlin
혼자서 코틀린 공부하기

## 교재
- 초보자를 위한 코틀린 200제 
	<!-- - [교재](https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=145772464) -->
	<a href="https://www.aladin.co.kr/shop/wproduct.aspx?ItemId=145772464" target="_blank">

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
		println("Hello World!")

		// Try adding program arguments via Run/Debug configuration.
		// Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
		println("Program arguments: ${args.joinToString()}")
	}
	```