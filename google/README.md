# 코틀린 기초 2

## Android 모바일 앱 개발자 도구 - Android 개발자
[출처](https://developer.android.com/)

### Kotlin 프로그래밍 언어 알아보기
[열기](https://developer.android.com/kotlin/learn?hl=ko&_gl=1*y919hh*_up*MQ..*_ga*NjM1Nzk4OTgyLjE3MzAwMzU0MjE.*_ga_6HH9YJMN9M*MTczMDAzNTQyMS4xLjAuMTczMDAzNjM0Ny4wLjAuMTU5ODAwMTE2)

- 이 내용을 그대로 보고 학습할 것

### 안드로이드와 코틀린

#### 안드로이드 플랫폼은 리눅스 OS 상에서 상호작용하면서 동작
- 안드로이드 플랫폼

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0002.png" width="600">

    - 출처 : https://developer.android.com/guide/platform?hl=ko

    - 안드로이드는 플랫폼버전과 달리 API 레벨이 존재함
        - API 레벨에 따라 새로운 기능이 추가되므로 코드를 변경해야 하는 경우 발생

        - 내용 : https://developer.android.com/about/versions?hl=ko

    - 안드로이드 플랫폼 구조는 리눅스 커널과 자바 API 프레임워크 결합형태
    - 안드로이드 런타임(Android RunTime) 사용

- Kotlin
    - 2017년 이전 안드로이드 개발에는 Java를 앱 개발언어로 사용, 2017년 5월 Google I/O에서 코틀린을 공식 언어로 채택
    - JetBrains(체코 IT개발사)에서 개발한 프로그래밍 언어
        - ReSharper라는 Visual Studio 플러그인 개발사로 시작
        - 2011년 코틀린 언어 배포
    
##### 자바와 코틀린
- 코틀린은 자바와 100% 호환
- 코틀린으로 작성하면 자바 작성시보다 코드양이 줄어듬

##### 코틀린 개발 진행
- 순서
    1. 소스코트 작성 - 코틀린으로 코드 작성
    2. 설치파일 생성 - 안드로이드에서 실행될 수 있는 설치파일 형태로 변환
    3. 업로드 - 구글 플레이스토어에 앱 업로드
    4. 앱등록 - 플레이스토어에 앱 등록
    5. 앱 선택/설치 - 스마트폰에서 구글 플레이스토어 설치할 앱 검색 후 설치
    6. 앱 실행 - 아이콘 터치로 앱 실행

##### 앱 실행 과정
- 순서
    1. 빌드(컴파일 + 비밀번호) - 빌드를 통해 진행. 소스코드를 바이트코드로 변환, APK 매니저에서 비밀번호 키 스토어와 조합 최종설치파일 생성
    2. 파일 검증 - 업로드 시 구글 플레이스토어에서 앱 검수하는 과정
    3. 플랫폼 버전 체크 - 앱 선택 시 버전이 맞는 지 확인, 설치 가능한 앱 목록만 표시
    4. AOT 컴파일/설치 권한 체크 - 앱 설치 시 APK 파일 설치하면 리눅스에서 실행가능한 파일로 폰 내부에서 한번 더 컴파일.
    5. JIT 컴파일/실행 권한 체크 - 스마트폰에서 실행 미리 컴파일되지 않은 파일을 호출하면서 리눅스 실행파일로 컴파일


#### 개발도구 설치
- 안드로이드 스튜디오 설치
    - https://developer.android.com/studio?hl=ko 에서 최신판 다운로드
    - 기본 설치 진행
    - 안드로이드 SDK 를 설치 

- IntelliJ IDEA에 안드로이드 설치
    - 플러그인에 Android 검색 후 설치
    - 안드로이드 SDK는 안드로이드 스튜디오 설치 시 SDK 로케이션을 선택
    - 완료

- 에뮬레이터 생성

#### 최초 실행(IntelliJ IDEA 기반)
- 순서 진행
    1. 프로젝트 클릭

        <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0003.png" width="600">

    2. Empty Activity 선택 
    3. Configure Your Project 입력

        <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0004.png" width="800">

    4. SDK Component Installer 확인

        <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0005.png" width="800">

    5. 화면오픈 후
    6. 메뉴 > 도구 > Android > 장치 관리자(Device Manager) 클릭
    7. Create Virtual Device 클릭

        <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0006.png" width="800">

    8. 장치 관리자에서 디바이스 실행


        <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0007.png" width="400">

    9. 메뉴 상단 app > 플레이버튼 클릭해서 앱 실행

#### 다음 진행(Android Studio)
- 진행 순서
    1. 실행 후 Gradle 설정 필요
        - IntelliJ의 Gradle 사용자홈 (보통 C:\Users\사용자명\.gradle) 확인
    2. Settings > Build Tools > Gradle 에서 위 설정 입력 

#### 안드로이드 SDK 설정내용
- SDK Platforms -  소스코드 빌드시 사용하는 플랫폼이 버전별로 표시
- SDK Tools 
    - Android SDK Build-Tools - 리소스 아이디를 가지고 있는 R 파일 생성, 설치파일 APK를 최적화하는 도구. Java Bytecode를 Dalvik Bytecode로 변환하는 도구 포함
    - Android Emulator - 가상 스마트폰 환경으로 앱 설치 및 실행확인 도구
    - Android SDK Platform - Tools - 에뮬레이터와 스마트폰간의 연결및 디버깅 도구 등을 제공
    - Intel x86 Emulator Accelerator(HAXM) - 윈도우에서 에뮬레이터의 처리속도 가속을 위한 하드웨어 가속기

#### 스마트폰과 연결 설정
- 스마트폰(안드로이드) 설정 오픈
- 휴대전화 정보로 이동
- 소프트웨어 정보 이동
- 빌드 번호 영역을 5번 이상 연속으로 누르면 개발자 모드 활성화 토스트 메시지 오픈
- 설정 > 시스템 > 고급 > 개발자 옵션으로 이동
- USB 디버깅 활성화
- USB 케이브로 스마트폰 컴퓨터에 연결
- Available devices 목록버튼 클릭 후 Run on multiple devices 클릭
- 위 목록에 나타난 이름 선택 후 Run 버튼 클릭

#### 기본 실행 후 수정
- 실행하면 'Hello Android!' 가 흰색 바탕화면에 나타나는 앱 실행됨
- MainActivity.kt 에서 맨 아래 코드 확인

    ```kotlin
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                FirstAppTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
    ```

- name = "Android" 매개변수 값을 원하는 문자열로 변경 
- 로테이션 아이콘으로 변경된 Run 버튼 클릭

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0008.png" width="800">

#### 코틀린에 맞게 재구현

##### 새 프로젝트 생성
1. 새 프로젝트 시작:
    - Android Studio를 열고, **"New Project"**를 선택하세요.

2. 프로젝트 템플릿 선택:
    - Phone and Tablet > Empty Views Activity 템플릿을 선택하는 것이 좋습니다. 기본적인 앱 구조를 갖춘 상태로 시작할 수 있습니다.

3. 앱 세부 정보 설정:
    - Name: 앱 이름을 입력합니다. 여기서는 TutorialApp 으로 입력했습니다,
    - Package Name: 앱의 고유 패키지 이름을 입력합니다 (예: com.hugo83.tutorialapp).
    - Save location: 프로젝트를 저장할 위치를 지정합니다.
    - Language: "Kotlin"을 선택합니다.
    - Minimum API Level: 앱이 지원할 Android 버전을 설정합니다. 일반적으로 API 21 (Lollipop) 정도가 좋은 선택입니다.
    - Build configuration language : Kotlin DSL은 최신, Groovy DSL은 예전 방식입니다.

4. Finish:
    - 설정을 마친 후 "Finish"를 클릭하면 프로젝트가 생성됩니다.

##### 앱 구조이해
Android Studio가 생성한 기본 프로젝트 구조를 이해해보겠습니다.

- MainActivity.kt: 코틀린으로 작성된 메인 액티비티 파일입니다. 안드로이드 앱의 첫 화면을 담당하는 클래스입니다.
- res/layout/activity_main.xml: 메인 화면의 UI 레이아웃 파일입니다.
- AndroidManifest.xml: 앱의 주요 설정 파일로, 각 액티비티와 앱 권한 등을 정의합니다.

##### 간단한 UI 추가
activity_main.xml 파일에서 UI 요소를 추가해 봅시다.

1. 디자인 모드와 코드 모드:
    - Android Studio에서 res/layout/activity_main.xml 파일을 열면 "Design"과 "Code" 두 가지 모드가 있습니다. Design 모드에서 드래그 앤 드롭으로 UI를 추가할 수 있습니다.

2. 텍스트 추가:
    - Design 모드에서 "TextView"를 찾아 드래그해 화면 중앙에 놓습니다.
    - TextView를 선택한 후, "Attributes" 창에서 text 속성을 "Hello, Kotlin!"으로 설정합니다.

3. 버튼 추가:
    - Design 모드에서 "Button"을 찾아 드래그해 화면 아래쪽에 놓습니다.
    - Button의 text 속성을 "Click Me"로 설정합니다.

    ```xml
    <RelativeLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        xmlns:tools="http://schemas.android.com/tools"
        android:id="@+id/main"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        tools:context=".MainActivity">

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Hello World!"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="100dp"
            android:textSize="24sp" />

        <Button
            android:id="@+id/button"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="Click Me"
            android:layout_below="@id/textView"
            android:layout_centerHorizontal="true"
            android:layout_marginTop="20dp" />

    </RelativeLayout>
    ```

##### 기능 추가
추가 설정이 필요합니다.

1. build.gradle에 아래의 코드를 추가합니다. android { ... } 사이에 입력합니다.

    ```groovy
    buildFeatures {
        viewBinding = true
    }
    ```

2. Sync now를 클릭합니다.

3. MainActivity.kt 를 아래와 같이 변경합니다. import 네임스페이스를 신경씁니다.

    ```kotlin
    class MainActivity : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            var mine = ActivityMainBinding.inflate(layoutInflater)
            /* 안드로이드 앱에서 Edge-to-Edge 디자인을 적용하기 위해 사용하는 함수
                앱의 UI를 화면 가장자리까지 확장하여 시스템 내비게이션 바나 상태 표시줄과 겹치는 부분까지 콘텐츠가 표시되도록 하는 것
                안드로이드 10(API 29)부터 도입
            */
            enableEdgeToEdge()
            //setContentView(R.layout.activity_main) // res/layout/activity_main.xml을 사용한다
            setContentView(mine.root)

    //        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
    //            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
    //            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
    //            insets
    //        }
            // 굳이 위의 소스 부분이 문제를 일으키진 않는다. 현재까진...

            mine.button.setOnClickListener {
                mine.textView.text = "Hello, Kotlin!!!!"
            }
        }
    }
    ```

4. Run을 실행하면 두 가지 이슈 발생 - AAR 메다데이터 검사시
    - 첫번째 : 종속성 'androidx.core:core-ktx:1.15.0'은 이에 종속된 라이브러리와 애플리케이션이 Android API의 버전 35 이상에 대해 컴파일해야 한다고 나옴. build.gradle의 compileSdk를 35로 변경해야함
    - 두번째 : 역시 같은 내용임

    - 이하 아래의 영어로 된 부분이 링크로 걸려있음. 이를 클릭하면 자동으로 변경
        - Update minCompileSdk in modules with dependencies that require a higher minCompileSdk.

5. 재실행

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0009.png" width="800">

### 안드로이드 프로그래밍

#### 로그 활용
- 필요시 마다 Log.d() 활용
    - 디버깅을 줄일 수 있음(체험상)

- 아래의 로그캣(고양이 모양 아이콘 클릭)

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0010.png" width="820">

- 로그 종류는 Log.v(), d(), i(), w(), e() 등 존재하지만
    - d() - debug
    - w() - warning
    - e() - error 정도만 사용하면 될 것

### 위젯 / 리소스

#### 레이아웃
- 프로젝트 생성 후 기본화면이 구성되는 activity_main.xml 파일이 레이아웃을 구성하는 UI
- 레이아웃 종류
    
    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0011.png" width="500">

    - RelativeLayout, GridLayout은 안드로이드 스튜디오 3.1 이상부터는 업데이트 되지 않음

- 레이아웃 창 보는 방법

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0012.png" width="820">

    - 오른쪽 상단 아이콘으로 Code, Split, Design 순으로 변환

### 구글 플레이스토어 작업
