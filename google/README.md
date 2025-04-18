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

    10. `중요!` - SDK 버전이 맞지 않으면 오류 발생

        ```groovy
        plugins {
            alias(libs.plugins.android.application)
            alias(libs.plugins.kotlin.android)
        }

        android {
            namespace = "com.hugo83.gptgenapp"
            compileSdk = 35  // 여기!

            defaultConfig {
                applicationId = "com.hugo83.gptgenapp"
                minSdk = 21
                targetSdk = 35  // 여기! 수정 필요!
                versionCode = 1
                versionName = "1.0"

                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
            }

        ```

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
    - Build configuration language : Kotlin DSL은 최신, **Groovy DSL**은 예전 방식입니다.

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
        private lateinit var bind: ActivityMainBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            bind = ActivityMainBinding.inflate(layoutInflater)
            /* 안드로이드 앱에서 Edge-to-Edge 디자인을 적용하기 위해 사용하는 함수
                앱의 UI를 화면 가장자리까지 확장하여 시스템 내비게이션 바나 상태 표시줄과 겹치는 부분까지 콘텐츠가 표시되도록 하는 것
                안드로이드 10(API 29)부터 도입
            */
            enableEdgeToEdge()
            //setContentView(R.layout.activity_main) // res/layout/activity_main.xml을 사용한다
            setContentView(bind.root)

    //        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
    //            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
    //            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
    //            insets
    //        }
            // 굳이 위의 소스 부분이 문제를 일으키진 않는다. 현재까진...

            bind.button.setOnClickListener {
                bind.textView.text = "Hello, Kotlin!!!!"
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
    - ContraintLayout - 드래그 앤 드랍으로 각각 화면의 요소들을 원하는 곳에 배치할 수 있는 레이아웃
    - LinearLayout - 위젯 가로 또는 세로 한 줄로 배치하는 레이아웃
    - FrameLayout - 입력되는 위젯을 중첩해서 사용하기 위한 레이아웃


- 레이아웃 창 보는 방법

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0012.png" width="820">

    - 오른쪽 상단 아이콘으로 Code, Split, Design 순으로 변환

##### 위젯
- 3.1 이후부터 텍스트, 버튼. 위젯으로 세분화
    - Common - TextView, Button, ImageView, RecyclerView 등 많이 사용하는 위젯 묶음
    - Text - TextView, Plain Text 등 텍스트 종류 위젯 
    - Buttons - Button, ImageButton 등 버튼 종류
    - Widgets - View, ProgressBar 등 화면 그리기 위젯 묶음
    - Layouts - 자주 사용하는 레이아웃 묶음
    - Containers - 위젯 담는 컨테이너 위젯 묶음
    - Helpers - 개발에 도움을 주는 위젯 
    - Google - 지도와 구글애드 등 구글관련 위젯
    - Legacy - 레가시로 가장 오래된 위젯 종류

##### 위젯 요소
- text - 텍스트 입력
- textAppearance 아래
    - fontFamily - 글자체 확인 및 변경
    - typeface - sans, serif, normal 등 영어체 타입 변경
    - textSize - sp 단위로 텍스트 크기 변경 (Scale-independent Pixels) 약어
    - textColor - 글자 색
    - textStyle - Bold, Italic
    - textAlignment - left, center, right 등 
- 엄청나게(!) 많은 Attributes 들이 나열되어 있음

- inputType - 입력타입 지정
    - textUri, textEmailAddress, textPassword, textVisiblePassword, number, phone, date 등

- imeOptions - 입력완료 후 실행할 이벤트 설
    - normal, actionUnspecified, actionGo, actionSearch, actionSend, actionsNext, actionDone, actionPrevious

##### 이미지버튼
- 이미지 크기 설정 - scaleType
    - matrix, fitXY, fitStart, fitCener, fitEnd, center, centerCrop, centerInside

##### 라디오그룹, 라디오버튼
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/02.RadioGroup/RadioButton/google/TutorApp)
- setOnCheckedChangeListener 
    - RadioGroup 에 리스너를 추가하여 선택된 라디오버튼의 변경을 감지
    - checkedId는 현재 선택된 라디오버튼의 ID
- 선택된 라디오버튼의 텍스트 가져오기
    - findViewById로 선택된 라디오 버튼을 RadioButton으로 캐스팅하여 text를 수신
    - 가져온 텍스트를 TextView에 표시

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0014.png" width="400">

##### 체크박스
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/03.CheckBox/google/TutorApp)
- View Binding 설정: ActivityMainBinding을 사용해 View Binding을 초기화
- 체크박스 리스트 생성
    - checkBoxes 리스트에 각 체크박스를 넣고, 각 체크박스에 setOnCheckedChangeListener를 설정하여 상태가 변경될 때마다 updateSelectedOptions()가 호출됨
- updateSelectedOptions 함수
    - 각 체크박스가 선택되어 있는지 확인하고, 선택된 항목의 텍스트를 selectedOptions 리스트에 추가
    - selectedOptions 리스트의 값을 콤마로 구분하여 TextView에 표시

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0015.png" width="400">

##### 토글버튼, 스위치, 이미지뷰
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/04.ToggleButton/google/TutorApp)
1. View Binding 설정: ActivityMainBinding을 사용해 View Binding을 초기화
2. 상태 리스너 설정:
    - setOnCheckedChangeListener를 사용하여 ToggleButton과 Switch의 상태가 변경될 때 updateStatus()가 호출되도록 함
3. updateStatus 함수:
    - ToggleButton과 Switch의 상태에 따라 텍스트와 이미지를 업데이트
    - 두 버튼이 모두 ON일 때 특정 이미지를 표시하고, 그렇지 않으면 다른 이미지를 표시


    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0016.png" width="800">

##### 프로그래스바
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/05.ProgressBar/google/TutorApp)
1. View Binding 설정: ActivityMainBinding을 사용해 View Binding을 초기화
2. increaseButton 클릭 이벤트:
    - increaseProgress() 함수가 호출되어, 버튼을 누를 때마다 progressStatus가 10씩 증가.
3. increaseProgress 함수:
    - ProgressBar와 TextView를 업데이트
    - progressStatus가 100% 미만일 때만 증가하도록 제한하여 최대값을 넘어가지 않도록 설정

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0017.png" width="400">

##### 시크바
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/06.SeekBar/google/TutorApp)
- 사용자가 슬라이더를 움직여 특정 값을 선택할 수 있도록 하는 Android UI 위젯

1. View Binding 설정: ActivityMainBinding을 사용해 View Binding을 초기화
2. SeekBar Change Listener 설정:
    - onProgressChanged 메서드에서 SeekBar의 값이 변경될 때마다 TextView를 업데이트하여 현재 값을 표시
    - onStartTrackingTouch와 onStopTrackingTouch는 사용자가 SeekBar를 터치하거나 손을 뗄 때 호출. 필요 시 추가 동작을 정의가능

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0018.png" width="400">

##### 레이팅바
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/07.RatingBar/google/TutorApp)
1. View Binding 설정: ActivityMainBinding을 사용하여 View Binding을 초기화
2. RatingBar Change Listener 설정:
    - onRatingBarChangeListener를 설정하여 사용자가 RatingBar의 값을 변경할 때마다 현재 별점을 TextView에 업데이트.

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0019.png" width="400">

#### drawable 단위
- 이미지 리소스인 drawable, 앱 아이콘에 사용되는 mipmap, strings를 이용한 다국어 처리 학습
    - 스마트폰마다 가로세로 화소(픽셀)의 개수가 다르기 때문에 화소 개념인 dp로 사이즈 표시
    - dp는 화면 밀도인 DPI에 따라서 실제 픽셀로 변환되는 크기가 변경 drawable 또한 DPI에 따라 다른 이름의 디렉터리 사용

- DPI(Dots Per Inch) - 가로세로 1인치(2.54cm) 정사각형 공간에 들어있는 픽셀의 숫자

    |표현|1인차 내 화소수|비고|
    |:---:|---:|:---|
    |ldpi|120|미사용|
    |mdpi|160|기준: 1dp = 1pixel|
    |hdpi|240| |
    |xhdpi|320|1dp = 2pixel|
    |xxhdpi|480|1dp = 3pixel|
    |xxxhdpi|640|1dp = 4pixel|
    
##### mipmap
- 앱의 아이콘 사용용도로 mipmap 디렉토리 제공

##### strings
- strings.xml을 Translations Editor를 통해서 관리
    - 다국어 처리

#### 안드로이드 컴포넌트
- 컴포넌트는 독립적인 생명주기에 의해 실행

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0013.png" width="820">
    

    1. Activity - 화면 UI 담당 컴포넌트
    2. Broadcast Receiver - 시스템/사용자가 발생하는 메시지 수신 컴포넌트
    3. Service - 백그라운드 코드 처리를 담당하는 컴포넌트
    4. Content Provider - 앱 간의 데이터 공유를 위한 컴포넌트
    5. Intent - 1 ~ 3의 컴포넌트를 실행하기 위해 시스템에 전달되는 메시지 도구
    6. Content Resolver - Content Provider가 제동하는 데이터를 사용하기 위한 도구

##### 컨텍스트
- 시스템을 사용하기 위한 프로퍼티와 메서드가 담겨있는 클래스. 대부분 컴포넌트 실행과 함께 생성, 생성된 컴포넌트가 가지고 있는 메서드를 호출해서 각각의 도구들을 사용

##### 인텐트
- 안드로이드가 전달받은 인텐트로 해석하고 실행하여 안드로이드 앱을 진행
- MainActivity 는 특별한 설정없이도 안드로이드에 자동으로 인텐트가 등록됨. 이외 액티비티를 사용할 때는 인텐트에 새 액티비티의 이름을 담아서 시스템에 전달

    1. 실행할 대상 액티비티 이름과 전달할 데이터를 담아서 인텐트를 생성
    2. startActivity() 메서드에 담아서 호출 -> 액티비티 관리자가 수신
    3. 액티비지 관리자는 인텐트를 분석 지정 액티비티 실행
    4. 타겟 액티비티까지 전달
    5. 전달받은 인텐트에 데이터를 가져와 사용

##### 인텐트 사용 구현
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/08.IntentAndExtradatas/google/IntentTest)
1. app > kotlin+java > New > Activity > Empty Views Activity 선택
2. Activity Name을 입력 - SubActivity
3. Generate a Layout File 체크(기본)

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0020.png" width="820">

    - 텍스트와 버튼 추가(생략)

4. activity_main.xml 수정
    - TextView text -> **메인 액티비티**로 변경
    - 버튼 추가

5. MainActivity.kt 수정
    - setContentView(...) 아래 추가
    - btnChange 온클릭리스너 추가

    ```kotlin
    var intent = Intent(this, SubActivity::class.java)

    // ...
    bind.btnChange.setOnClickListner { startActivity(intent) }
    ```

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0021.png" width="820">


6. 데이터 전달
    - MainActivity.kt 소스 추가

    ```kotlin
    intent.putExtra("main1", "Extra Data")
    intent.putExtra("main2", 2025)
    ```

    - activity_sub.xml에 텍스트 위젯 추가 및 SubActivity.kt 소스 추가

    ```kotlin

    ```

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0022.png" width="820">

##### 액티비티 생명주기
1. onCreate() - 액티비티 생성(핵심)
2. onStart() - 화면 표시
3. onResume() - 실제 액티비티가 실행중
4. onPause() - 화면이 가려짐
5. onStop() -  화면이 없어짐
6. onDestroy() - 종료
 
##### Spinner - RecyclerView
- 여러개 목록 중 하나를 선택하는 도구 - RecyclerView(확장된 도구)

[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/09.RecyclerView/google/RecyclerViewTest)

1. 프로젝트 생성
2. build.gradle 설정
3. MainActivity.kt ActivityMainBinding으로 변경
4. activity_main.xml 파일 LinearLayout과 RecyclerView 코드 추가
5. layout > New > XML > Layout XML file 선택, item_view.xml로 입력
6. item_view.xml 코드 추가
7. ItemData.kt 데이터클래스 정의
8. RecyclerView의 데이터 관리 및 아이템 클릭 처리하는 어댑터 클래스 ItemAdapter.kt 정의
9. MainActivity.kt 수정 - 100개의 랜덤 데이터를 생성하고 Adapter에 전달

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0023.png" width="400">


##### 간단 프래그먼트 
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/10.Fragment/google/FragmentTest)
- 서로다른 크기의 화면을 가진 기기등 에서 하나의 액티비티로 서로 다른 레이아웃을 구성할 수 있도록 설계하는 것
- 하나의 액티비티에 3개의 프래그먼트를 옆으로 슬라이드 하거나, 하나의 액티비티에 프래그먼트를 모아서 표시

- Fragment는 하나의 액티비티에서 여러 UI 화면을 전환하거나 분할하여 사용할 수 있게 해주는 중요한 안드로이드 컴포넌트. Fragment를 사용하여 버튼을 눌렀을 때 텍스트를 변경하는 간단한 예제를 진행

1. 프로젝트 생성
2. 프로젝트 초기 구성 (build.gradle 및 MainActivity.kt ActivityMainBinding 추가 등)
3. activity_main.xml에 FrameLayout 추가
    - FrameLayout을 사용하여 Fragment를 담을 컨테이너를 정의
4. fragment_example.xml 레이아웃 파일 생성
    - Fragment 레이아웃 파일로 TextView와 Button을 포함
5. Fragment 클래스(ExampleFragment.kt) 정의 
    - onCreateView에서 inflate 메서드를 사용해 fragment_example.xml 레이아웃을 호출
    - Button을 클릭하면 TextView의 텍스트가 변경되도록 설정
6. MainActivity.kt 코드 변경
    - supportFragmentManager를 사용해 ExampleFragment를 fragmentContainer에 추가
    - savedInstanceState == null 조건을 통해 액티비티가 새로 생성된 경우에만 Fragment를 추가하도록 지정

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0024.png" width="400">

##### 멀티 프래그먼트
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/11.Fragment2/google/MultiFragment)
1. 프로젝트 생성
2. 프로젝트 초기 구성 (build.gradle 및 MainActivity.kt ActivityMainBinding 추가 등)
3. activity_main.xml 수정
    - FrameLayout을 사용하여 Fragment를 담을 컨테이너를 정의하고, 3 개의 버튼을 사용해 각 Fragment로 전환할 수 있도록
4. Fragment 레이아웃 파일 (fragment_one.xml, fragment_two.xml, fragemnt_three.xml)
5. Fragment 클래스 정의 (FragmentOne.kt, FragmentTwo.kt, FragmentThree.kt)
    - 각각 서로 다른 레이아웃을 onCreateView에서 inflate하여 표시
6. MainActivity.kt 수정
    - supportFragmentManager.beginTransaction()을 사용하여 replace()로 Fragment를 교체하는 방식으로 구현
    - replaceFragment()라는 메서드를 추가하여, 이를 통해 Fragment를 교체할 수 있도록 설정
    - buttonFragment1과 buttonFragment2 버튼 클릭 시 FragmentOne 또는 FragmentTwo, FragmentThree 가 fragmentContainer에 표시

7. Frag1, Frag2, Frag3 버튼으로 동작. Fragment1 화면은 생략

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0025.png" width="800">

##### 뷰/커스텀 위젯 사용
- 내용은 일단 생략

##### 탭 메뉴 화면구성
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/12.TabLayout/google/TabMenuTest)
- ViewPager - Swipe로 화면을 전환하는 컨테이너
- TabLayout - 탭 메뉴 구성

1. activity_main.xml 에 TabLayout과 ViewPager2를 추가
    - TabLayout을 통해 탭 메뉴를 표시하고, ViewPager2를 통해 각 Fragment로 전환할 수 있게
2. fragment_one.xml, fragment_two.xml, fragment_three.xml, fragment_four.xml 생성
3. FragmentOne.kt, FragmentTwo.kt, FragmentThree.kt, FragmentFour.kt 생성
4. ViewPager 어댑터 (FragmentPagerAdapter.kt) 생성
    - ViewPager2에서 사용할 Fragment 어댑터
    - getItemCount() 메서드로 Fragment의 개수를 정의하고, createFragment() 메서드로 각 포지션에 따라 Fragment를 생성
5. MainActivity.kt 코드 수정
    - FragmentPagerAdapter를 ViewPager2에 설정
    - TabLayoutMediator를 사용해 TabLayout과 ViewPager2를 연결하고, 각 탭의 제목을 설정

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0026.png" width="800">

[다음](https://github.com/hugoMGSung/hugo-kotlin/blob/main/google/README2.md)
