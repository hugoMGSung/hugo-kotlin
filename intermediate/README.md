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


### 앱 프로젝트
- UiLover Android 클로닝
- Philipp Lackner 클로닝

#### 