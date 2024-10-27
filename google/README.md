# 코틀린 기초 2

## Android 모바일 앱 개발자 도구 - Android 개발자
[열기](https://developer.android.com/)

### Kotline 프로그래밍 언어 알아보기
Kotlin은 프로그래밍 언어입니다. 전 세계에서 Android 개발자가 널리 사용합니다. 이 주제는 활용도를 높이기 위한 Kotlin 단기 집중과정입니다.

#### 변수 선언
Kotlin은 두 키워드(val 및 var)를 사용하여 변수를 선언합니다.

- 값이 변경되지 않는 변수에 val을 사용합니다. val을 사용하여 선언된 변수에 값을 재할당할 수 없습니다.
- 값이 변경될 수 있는 변수에 var을 사용합니다.
아래 예에서 count는 10의 초기 값이 할당되는 Int 유형의 변수입니다.

```kotlin
var count: Int = 10
```

Int는 정수를 나타내는 유형이며 Kotlin에서 표현될 수 있는 많은 숫자 유형 중 하나입니다. 다른 언어와 마찬가지로 수치 데이터에 따라 Byte, Short, Long, Float, Double을 사용할 수도 있습니다.

var 키워드는 필요에 따라 count에 값을 재할당할 수 있음을 의미합니다. 예를 들어 count 값을 10에서 15로 변경할 수 있습니다.

```kotlin
var count: Int = 10
count = 15
```

하지만 일부 값은 변경되지 않습니다. languageName이라는 String을 고려합니다. languageName에서 'Kotlin'의 값이 항상 유지되도록 하려면 val 키워드를 사용하여 languageName을 선언합니다.

```kotlin
val languageName: String = "Kotlin"
```

이러한 키워드를 사용하면 변경 가능한 항목을 명시할 수 있습니다. 필요에 따라 키워드를 유용하게 사용하세요. 변수 참조를 재할당할 수 있어야 하는 경우 var로 선언합니다. 그렇지 않은 경우 val을 사용합니다.