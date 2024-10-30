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
    2. 


### 안드로이드 화면구성

### 안드로이드 프로그래밍

### 구글 플레이스토어 작업
