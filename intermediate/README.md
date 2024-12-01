# 코틀린 중급

## Android 모바일 앱 프로젝트

### Jetpack Compose 학습

- Android UI를 개발하는 방법 중 하나
- 최신 Android UI 개발 트렌드 중 하나로, XML이나 View 계층 구조 대신 Kotlin 코드로 UI를 작성하는 방식
    - 다시 과거로 회귀???

#### Jetpack Compose의 특징
- 선언형 UI: UI를 코드로 선언하여 작성. 개발 속도가 빠르고 유지보수가 쉽다(는 주관적인 판단)
- 컴포넌트 재사용:
- 반응형 UI: UI가 사용자의 입력에 반응하여 동적으로 변경
- 자동 레이아웃: 자동으로 레이아웃을 구성

#### 장단점
- 장점
    - 개발속도가 빠름
    - 유지보수가 쉬움
    - 컴포넌트 재사용이 가능
    - 반응형 UI 구현 쉬움
    - 자동 레이아웃 제공

- 단점
    - 기존 안드로이드 UI 개발방식과 달라 적응식ㄴ 필요
    - 베타버전으로 일부기능이 제한될 수 있음

##### 기본 시작 앱

1. 기본프로젝트 생성에서 'Empty Activity' 선택
2. build.gradle.kts(Module) 에 compileSdk = 35 변경 Sync Now 
3. MainActivity.kt 수정

    - 첫번째

    ```kotlin
    @Composable
    fun Greeting() {
        Text( text = "Hello Kotlin!" )
    }
    ```

    - 두번째
    
    ```kotlin
    // 진입점 동일
    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContent {
                MyTheme {
                    Greeting()
                    }
                }
            }
        }
    }
    ```

    - 앱테마 설정

    ```kotlin
    @Composable
    private fun MyTheme(content: @Composable() () -> Unit) {
        MaterialTheme(
            colorScheme = lightColorScheme(
                primary = Purple80,
                secondary = Pink80
            ),
            typography = Typography,
            shapes = Shapes(),
        ) {
            content()
        }
    }
    ```

    - 미리보기

    ```kotlin
    @Preview
    @Composable
    fun GreetingPreview() {
        MyTheme {
            Greeting()
        }
    }
    ```

4. 미리보기

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0048.png" width="540">

    [미리보기버튼]

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0049.png" width="500">

    [앱과프리뷰차이]

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0050.png" width="500">

    [프리뷰]

##### 소감

- 일단 베타버전이라 그런지 계속 사용방법 로직이 변경되고 있음
- 나중에 참조, 적용할 예정

### 앱 프로젝트
- UiLover Android 클로닝
- Philipp Lackner 클로닝

#### Coffee Online Shop Cloning
- https://github.com/worldsat/project195 

1. 프로젝트 생성
2. build.gradle.kts (:app) 설정 추가
3. res/values/colors.xml 추가
4. res/drawable 폴더 붙여넣기 (다운로드 한 리소스)
5. Firebase 설정 - Menu Tools > Firebase 클릭
    - Realtime Database 클릭 > Connect to Firebase 버튼 클릭
    - 웹사이트 에서 프로젝트 생성 (시작 영어 소문자 주의!)
    - 다음으로 넘기면 자동 연결완료!
6. Add the Realtime Database to your app 아래 SDK 연결 버튼 클릭
7. Firebase 사이트로 가서 Realtime Database 클릭
    - Create Database 버튼 클릭
    - 싱가포르 선택 후 다음
    - 잠금모드로 시작 확인 후 완료
    - 규칙에 ".read": true, 로 변경

8. Data 탭에서 세로... > Import JSON 선택
    - database_firebase.json 선택 업로드

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0051.png" width="800">

    [RealtimeDatabase구조]

9. Storage 선택 
    - 프로덕션 모드에서 시작
    - 리소스 파일에서 5개 jpg 업로드
    - 각 커피 이미지 링크주소 복사
    - Realtime Datase Item 내 picUrl에 붙여넣기

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0052.png" width="800">

    [이미지URL매핑]

10. New > Activity > Emtpy Views Activity 선택
    - IntroActivity로 이름 변경
    - Launcher Activity 체크
    - Finish 버튼 클릭

11. activity_intro.xml 
    - Pixel 7 Pro 선택
    - ScrollView를 main에 드래그
    - 스크롤뷰 아래 LinearLayout에 ImageView 드래그 후 intro_pic 선택

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0053.png" width="800">


    - ... 디자이너에서 처리 

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0054.png" width="480">

12. Resource Manager 클릭
    - + 클릭 > Drawable Resource File 선택
    - File Name, 'brown_gradient' 입력
    
    ```xml
    <?xml version="1.0" encoding="utf-8"?>
    <selector xmlns:android="http://schemas.android.com/apk/res/android">
        <item>
            <shape android:shape="rectangle">
                <gradient android:angle="-90" android:endColor="@color/darkBrown"
                        android:startColor="@color/black" />
            </shape>
        </item>
    </selector>
    ```

13. Resource Manager에서 'orange_bg' 추가

    ```xml
    <selector xmlns:android="http://schemas.android.com/apk/res/android">
        <item>
            <shape android:shape="rectangle">
                <solid android:color="@color/orange" />
                <corners android:radius="10dp" />
            </shape>
        </item>
    </selector>
    ```

14. IntroActivity.kt 수정

15. AndroidManifest.xml 수정
    - intent-filter IntroActivity로 이전
    - MainActivity 에서는 삭제

    ```xml
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
    ```

16. BaseActivity 추가 생성
    - Generate a Layout File 체크 해제
    - BaseActivity 내용 작성

17. IntroActivity의 부모클래스를 BaseActivity로 변경
    - BaseActivity open 처리 - AndroidManifest.xml에 추가됨

18. 현재 LG G5에 맞춰서 작업하려면 Galaxy Nexus(4.65` 720, 360x640dp, xhdpi) 에 맞춰야 함
    - 다른 디바이스와 매칭해서 디스플레이 하는 방법 모색
    - 캡쳐된 이미지 크기 - 1440 x 2560 px 

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0055.png" width="310">