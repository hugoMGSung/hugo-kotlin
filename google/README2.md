# 코틀린 기초 2.1

## Android 모바일 앱 개발 - 계속

### 안드로이드와 코틀린 - 계속

#### 권한
- 아래 두가지 방법으로 분류
    - AndroidManifest.xml에 작성 - 인터넷 접속 같은 일반 권한은 설정파일에...
    - 소스코드 작성 - 전화번호부 요청같은 개인정보 노출 위험등이 있다면 소스코드에...

- 일반권한 종류

    |권한|설명|
    |:---|:---|
    | ACCESS_NETWORK_STATE | 네트워크 연결 상태 확인 |
    | ACCESS_WIFI_STATE | 와이파이 상태 확인 |
    | BLUETOOTH | 블루투스 상태 확인 |
    | INTERNET | 네트워크 및 인터넷 사용 |
    | NFC | 기기 간 근거리 통신 사용 |
    | SET_ALARM | 알람 설정 |
    | VIBRATE | 진동 설정 |

- 위험권한 종류

    <table>
        <tr>
            <td>권한그룹</td>
            <td>권한</td>
            <td>설명</td>
        </tr>
        <tr>
            <td rowspan="2">CALENDAR</td>
            <td>READ_CALENDAR</td>
            <td>캘린더 읽기</td>
        </tr>
        <tr>
            <!-- <td>CALENDAR</td> -->
            <td>WRITE_CALENDAR</td>
            <td>캘린더 쓰기</td>
        </tr>
        <tr>
            <td>CAMERA</td>
            <td>CAMERA</td>
            <td>카메라</td>
        </tr>
        <tr>
            <td rowspan="3">CONTACTS</td>
            <td>READ_CONTACTS</td>
            <td>주소록 읽기</td>
        </tr>
        <tr>
            <!-- <td>CONTACTS</td> -->
            <td>WRITE_CONTACTS</td>
            <td>주소록 쓰기</td>
        </tr>
        <tr>
            <!-- <td>CONTACTS</td> -->
            <td>GET_ACCOUNTS</td>
            <td>계정정보 가져오기</td>
        </tr>
        <tr>
            <td rowspan="2">LOCATION</td>
            <td>ACCESS_FINE_LOCATION</td>
            <td>위치정보 사용</td>
        </tr>
        <tr>
            <!-- <td>LOCATION</td> -->
            <td>ACCESS_COARSE_LOCATION</td>
            <td>위치정보 사용</td>
        </tr>
        <tr>
            <td>MICROPHONE</td>
            <td>RECORD_AUDIO</td>
            <td>마이크 녹음</td>
        </tr>
        <tr>
            <td rowspan="9">PHONE</td>
            <td>READ_PHONE_STATE</td>
            <td>폰 상태 정보</td>
        </tr>
        <tr>
            <!-- <td>PHONE</td> -->
            <td>READ_PHONE_NUMBERS</td>
            <td>전화번호 가져오기</td>
        </tr>
        <tr>
            <!-- <td>PHONE</td> -->
            <td>CALL_PHONE</td>
            <td>발신하기</td>
        </tr>
        <tr>
            <!-- <td>PHONE</td> -->
            <td>ANSWER_PHONE_CALLS</td>
            <td>응답하기</td>
        </tr>
        <tr>
            <!-- <td>PHONE</td> -->
            <td>READ_CALL_LOG</td>
            <td>전화 로그 읽기</td>
        </tr>
        <tr>
            <!-- <td>PHONE</td> -->
            <td>WRITE_CALL_LOG</td>
            <td>전화 로그 쓰기</td>
        </tr>
        <tr>
            <!-- <td>PHONE</td> -->
            <td>ADD_VOICEMAIL</td>
            <td>음성메일 추가</td>
        </tr>
        <tr>
            <!-- <td>PHONE</td> -->
            <td>USE_SIP</td>
            <td>SIP 사용</td>
        </tr>
        <tr>
            <!-- <td>PHONE</td> -->
            <td>PROCESS_OUTGOING_CALLS</td>
            <td>통화 관련 Broadcast 수신</td>
        </tr>
        <tr>
            <td>SENSORS</td>
            <td>BODY_SENSORS</td>
            <td>바디센서</td>
        </tr>
        <tr>
            <td rowspan="5">SMS</td>
            <td>SEND_SMS</td>
            <td>SMS 보내기</td>
        </tr>
        <tr>
            <!-- <td>SMS</td> -->
            <td>RECEIVE_SMS</td>
            <td>SMS 받기</td>
        </tr>
        <tr>
            <!-- <td>SMS</td> -->
            <td>READ_SMS</td>
            <td>SMS 읽기</td>
        </tr>
        <tr>
            <!-- <td>SMS</td> -->
            <td>RECEIVE_WAP_PUSH</td>
            <td>WAP 수신</td>
        </tr>
        <tr>
            <!-- <td>SMS</td> -->
            <td>RECEIVE_MMS</td>
            <td>MMS 받기</td>
        </tr>
        <tr>
            <td rowspan="2">STORAGE</td>
            <td>READ_EXTERNAL_STORAGE</td>
            <td>안드로이드 공용 저장소 읽기</td>
        </tr>
        <tr>
            <!-- <td>STORAGE</td> -->
            <td>WRITE_EXTERNAL_STORAGE</td>
            <td>안드로이드 공용 저장소 쓰기</td>
        </tr>
    </table>

- 서명권한(Signature Permission)
    - 권한을 사용하려는 앱이 권한을 정의하는 앱과 동일한 인증서로 서명된 경우 시스템은 권한을 자동으로 부여
    - 몇몇 서명 권한은 써드파티 앱에서는 사용할 수 없음
    
- 권한 그룹
    - 각 권한은 그룹단위로 구성
    - 파일에 대한 읽기/쓰기 권한이 있으면 2개의 권한은 하나의 그룹

##### 안드로이드앱 권한 설정 방법
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/13.Registration-Camera/google/CameraReg)

1. 프로젝트 생성
2. 프로젝트 초기설정
3. AndroidManifest.xml 권한 추가

    ```xml
    <manifest xmlns:android="http://schemas.android.com/apk/res/android"
        package="com.example.yourappname">

        <application
            android:allowBackup="true"
            android:label="CameraPermissionApp"
            android:supportsRtl="true"
            android:theme="@style/Theme.AppCompat.Light.NoActionBar">
            <!-- 다른 앱 설정 -->
        </application>

        <!-- 카메라 권한 선언 -->
        <uses-permission android:name="android.permission.CAMERA" />

    </manifest>
    ```

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0027.png" width="800">

4. activity_main.xml에 카메라 권한 요청 버튼 추가

5. MainActivity.kt 수정
    - 카메라 버튼 클릭 시 권한을 확인하고, 권한이 없으면 권한 요청을 하는 로직을 구현
    - checkCameraPermission() 메서드에서 카메라 권한이 이미 부여되었는지 확인
    - 권한이 부여되지 않은 경우 requestPermissionLauncher를 통해 권한을 요청
    - registerForActivityResult(ActivityResultContracts.RequestPermission())로 정의한 requestPermissionLauncher에서 권한 승인 또는 거부 여부를 처리
    - isGranted가 true이면 카메라를 열고, false이면 권한 거부 메시지를 표시
    - openCamera() - 실제로 카메라를 여는 메서드
        - 이 예제에서는 Toast 메시지로 카메라가 열렸다고 표시
        - 실제로 카메라 기능을 구현하려면 이 메서드에서 카메라 앱을 호출하거나 카메라 화면을 구성

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0028.png" width="800">

#### 파일 IO

- 안드로이드 가상머신이 동작하는 플랫폼
    - 리눅스 파일시스템, 파일과 디렉토리에 대한 권한 설정
- 내부 저장소(앱별 저장공간)
    - 설치한 앱에 제공되는 디렉토리
    - 특정앱을 설치하면 /data/data/App 디렉토리 생성, 설치한 앱만이 디렉터리 읽고쓰는 권한 있음
- 외부 저장소(공유저장공간)
    - 모든 앱이 함께 사용할 수 있는 공용공간
    - 매니페스트에 접근하려는 파일은 외부저장소 디렉터리 권한을 명세

##### 내부저장소 파일 입출력
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/14.FileIO/google/FileIoTest)

1. 프로젝트 생성
2. 프로젝트 초기설정
3. activity_main.xml 수정
    - 파일에 데이터를 저장하고 읽는 기능을 수행하는 버튼과 텍스트를 표시할 EditText 및 TextView를 추가
4. MainActivity.kt 작성
    - Save 버튼을 클릭하면 EditText의 내용을 파일에 저장하고, Load 버튼을 클릭하면 파일에서 저장된 내용을 읽어 TextView에 표시
    - fileName 변수에 저장할 파일 이름을 정의합니다. 예제에서는 "hugoText.txt"로 파일 이름을 지정
    - 파일쓰기 saveToFile - FileOutputStream을 이용해 내부 저장소에 파일을 열고, write 메서드로 문자열을 저장. 
    - 파일읽기 loadFromFile - FileInputStream을 사용하여 파일을 읽고, bufferedReader를 이용해 파일 내용을 텍스트로 변환하여 로드
    - 버튼 이벤트 처리 - buttonSave 버튼을 클릭하면 EditText의 텍스트를 파일에 저장하고, buttonLoad 버튼을 클릭하면 파일에서 텍스트를 로드

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0029.png" width="800">

##### SharedPreferences 입출력

1. 프로젝트 생성
2. 프로젝트 초기설정
3. activity_main.xml 수정
    - 데이터를 입력할 EditText, 데이터를 저장하고 불러올 버튼들, 그리고 저장된 데이터를 보여줄 TextView를 추가
4. MainActivity.kt 작성
    - sharedPrefFile 변수에 저장할 파일의 이름을 지정합니다. SharedPreferences 파일은 해당 앱에만 접근이 가능하며, getSharedPreferences() 메서드를 사용
    - Save 버튼 클릭 시 edit() 메서드를 사용하여 SharedPreferences에 데이터를 저장
    - putString("savedText", textToSave)로 "savedText"라는 키를 사용하여 데이터를 저장하고, apply()로 변경사항을 적용
    - Load 버튼 클릭 시 getString("savedText", "저장된 데이터가 없습니다.")로 데이터 로드
    - 불러온 데이터를 TextView에 표시

5. 메뉴 > Project Structure... 클릭
    - 앱 선택 후 + 클릭
    - Add Dependency 클릭
    - Step 1 에 preference 입력 후 검색버튼 클릭
    - Group ID가 androidx.preference 인 preference:1.2.1과 preference-ktx:1.2.1 추가
    - Step 2 는 implementation
 
    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0030.png" width="800">

- 나중에 다시!!


#### SQLite 연동
- DB 기초내용은 생략

##### DB 연동

[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/15.SQLite-Handling/google/DatabaseHandling)

1. 프로젝트 생성
2. 기초 설정
3. SQLiteOpenHelper 클래스 정의, DatabaseHelper.kt
    - onCreate 메서드에서 테이블을 생성합니다. 여기서는 id, name, age 세 개의 컬럼을 갖는 테이블을 생성
    - insertData 메서드를 통해 데이터를 테이블에 삽입하고, getAllData 메서드를 통해 모든 데이터를 조회
4. activity_main.xml 수정
    - 데이터를 입력할 EditText, 데이터를 삽입하고 조회할 Button, 그리고 조회 결과를 표시할 TextView를 추가
5. MainActivity.kt 작업
    - Insert 버튼 클릭 시 사용자가 입력한 이름과 나이를 데이터베이스에 삽입
    - Select 버튼 클릭 시 데이터베이스에서 모든 데이터를 조회하여 TextView에 표시


    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0031.png" width="800">


#### 카메라 연동
- 카메라와 갤러리 사용
    - 카메라와 저장소 접근 권한 요청
    - 카메라 인텐트로 사진 촬영
    - 촬영 사진 기기 갤러리 저장
    - 사진 로드

- 만들면서 CameraReg, CameraReg2 등에 문제 발생!!

##### 일반 카메라
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/16.Camera/google/CameraReg3)

1. 프로젝트 생성
2. build.gradle (:app) 수정
    - compileSdk 35
    
    ```groovy
    buildFeatures {
        viewBinding = true
    }
    ```
    
3. AndroidManifest.xml 에 내용 수정

    ```xml
    <!-- 카메라와 저장소 권한 -->
    <uses-feature android:name="android.hardware.camera" />

    <uses-permission android:name="android.permission.CAMERA" />
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@mipmap/ic_launcher"
        android:label="@string/app_name"
        android:roundIcon="@mipmap/ic_launcher_round"
        android:supportsRtl="true"
        android:theme="@style/Theme.CameraReg3"
        tools:targetApi="31"
        android:requestLegacyExternalStorage="true">
        <!-- ... -->
    ```

4. xml/file_paths.xml 작성
    - xml 디렉토리 > New > XML Resource file 선택

    ```xml
    <paths xmlns:android="http://schemas.android.com/apk/res/android">
        <external-path name="external_files" path="." />
    </paths>
    ```

5. activity_main.xml 코드 작성

    ```xml
    <LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:orientation="vertical"
        android:padding="16dp">

        <Button
            android:id="@+id/buttonCamera"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="카메라로 사진 찍기" />

        <Button
            android:id="@+id/buttonLoadImage"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="갤러리에서 사진 불러오기" />

        <ImageView
            android:id="@+id/imageView"
            android:layout_width="match_parent"
            android:layout_height="300dp"
            android:layout_marginTop="16dp"
            android:scaleType="centerCrop"
            android:contentDescription="Selected image will be shown here" />
    </LinearLayout>
    ```

6. MainActivity.kt 수정
    - 내용 생략 

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0033.png" width="400">


##### CameraX
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/17.CameraX/google/CameraXApp)

1. 프로젝트 생성
    - Empty View Activity가 아니라 Empty Activity로 만들것
2. build.gradle.kts, dependencies 추가
3. AndroidManifest.xml 에 카메라 권한 추가
4. MainActivity.kt 작성 시작
5. 4번 작성시 CameraPreview.kt 생성, 작성
6. 9번 작성시 PhotoBottomSheetContent.kt 생성, 작성
7. 19번 작성시 MainViewModel.kt 클래스 생성, 작성

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0034.png" width="800">


#### 스레드

- 메인 스레드는 1개의 스레드만 존재. 백그라운드 스레드는 여러개의 스레드 사용가능
- 메인 스레드의 특징
    - 화면 UI를 그리는 처리에 담당
    - android.widget, android.view 등의 안드로이드 UI 툴킷 구성요소와 인터렉션, UI 이벤트는 사용자와 응답
    - UI 이벤트 및 프로세스가 수 초내에 응답하지 않으면 ANR(Application Not Responding) 팝업창을 표시 - 윈도우 앱에서 응답없음과 동일

- 백그라운드 스레드
    - 시간을 특정할 수 없는 작업에 대체방안
    - Thread Class
        - Thread 클래스 상속받은 WorkerThread 클래스 정의
        - run() 메서드와 start() 메서드가 WorkerThread 작업 처리
    - Runnable Interface
        - Runnable 구현한 WorkerRunnable 클래스 정의
        - Thread 클래스의 생성자로 객체 전달 후 start() 메서드를 호출

##### 스레드 예제
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/18.Thread/google/ThreadTest)

1. 프로젝트 생성
2. build.gradle.kts 수정, ReSync
3. MainActivity.kt 코드 수정

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0035.png" width="800">

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0036.png" width="830">

##### 타이머 예제
[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/19.ThreadTimer/google/ThreadTest)

- 위의 소스에서 계속(내용 생략)

1. 타이머로 변경

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0037.png" width="400">


#### 코루틴

- 스레드를 경량화한 코루틴Coroutine이라는 새로운 도구를 제공
    - 타언어에서 이미 사용되고 있는 동시성 프로그래밍 개념을 코틀린에 도입
    - 컨텍스트 스위칭을 하나의 스레드에서 처리하므로 성능 저하가 적고, 동일한 구조에서는 스레드보다 훨씬 적은 자원을 소모
    - 디스패처(코루틴이 실행될 스레드를 지정하는 것) 를 사용하여 코루틴스코프를 구성
    - 코루틴은 launch와 async로 시작가능

##### 코루틴

[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/20.Coroutine/google/ImageDownloader)

1. 프로젝트 생성
2. build.gradle에 의존성 추가

    ```groovy
    android {
        namespace = "com.hugo83.imagedownloader"
        compileSdk = 35

        // 생략...
        buildFeatures {
            viewBinding = true
        }
    }
    dependencies {

        implementation(libs.androidx.core.ktx)
        // 생략...
        // 추가
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
        implementation("com.github.bumptech.glide:glide:4.12.0")
    }   
    ```

3. AndroidManifest.xml 권한 추가

    ```xml
    <uses-permission android:name="android.permission.INTERNET"/>
    ```

4. activity_main.xml 수정
    - Button, EditText, ImageView, ProgressBar 로 구성

5. MainActivity.kt 작성

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0038.png" width="850">

[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/21.Glide/google/ImageDownloader)

6. Glide 라이브러리를 사용하여 처리하여도 동일한 기능 제공

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0039.png" width="300">


#### 서비스와 컨텐트리졸버
- 안드로이드에서 자주 사용되는 중요한 컴포넌트

1. 서비스 - 화면이 없는 액티비티
    - 백그라운드에서 장시간 실행되는 작업을 처리하는 컴포넌트. 
        - 미디어 플레이어 앱 - 음악을 계속 재생하는 백그라운드 서비스
        - 위치 기반 앱 - 사용자 위치를 추적하는 서비스
        - 파일 다운로드 - 다운로드 완료될 때까지 계속 실행되는 서비스

    - 서비스 종류
        - Started Service - 명령을 받으면 작업을 수행, 스스로 종료
        - Bound Service - 다른 컴포넌트가 서비스와 바인딩하여 상호작용
        - Forground Service - 알림을 통해 사용자에게 지속적으로 보여지는 서비스

2. 컨텐트 리졸버
    - 앱이 다른 앱 또는 시스템의 데이터에 접근하도록 해주는 인터페이스. 데이터 공유 매개체를 통해 다른 앱 데이터에 접근
        - 연락처 앱에서 다른 앱이 연락처를 읽으려면 Content Resolver 를 사용
        - 사진이나 파일을 가져오거나 다른 앱 데이터를 사용해야 할 때 사용

- 서비스는 백그라운드 작업을 수행하므로 주로 장시간 실행이 필요한 작업
- 컨텐트 리졸버는 다른 앱의 데이터, 시스템 데이터에 접근이 필요할 때


#### 서비스 프로젝트

[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/22.Service/google/MyService)

1. 프로젝트 생성 및 초기화
2. MyService.kt 클래스 생성 및 작성
    - onCreate: 서비스가 처음 생성될 때 한 번만 호출
    - onStartCommand: 서비스가 시작될 때마다 호출. 여기서 for 루프와 Thread.sleep()을 사용해 간단한 작업을 수행하도록
    - onDestroy: 서비스가 종료될 때 호출.
3. activity_main.xml 레이아웃 수정
4. MainActivity.kt 작성
5. AndroidManifest.xml 서비스 등록

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0040.png" width="850">

#### 바운드서비스 프로젝트

[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/23.BoundService/google/BoundServiceApp)

1. 프로젝트 생성 및 초기화
2. MyBoundService.kt 클래스 생성 및 작성
3. activity_main.xml 레이아웃 수정
4. MainActivity.kt 작성
5. AndroidManifest.xml 서비스 등록

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0041.png" width="850">

#### 포어그라운드 서비스 프로젝트

[소스](https://github.com/hugoMGSung/hugo-kotlin/tree/24.ForegoundService/google/ForgoundServiceApp)

1. 프로젝트 생성 및 초기화
2. MyForegroundService.kt 클래스 생성 및 작성
3. activity_main.xml 레이아웃 수정
4. MainActivity.kt 작성
5. AndroidManifest.xml 서비스 등록

- 동작 확인안됨. 보류

#### 컨텐츠 리졸버
- 기기에 저장된 음원 목록을 가져와 표시

1. 프로젝트 생성 및 초기화
2. AndroidManifest.xml 권한 등록
3. Music.kt 클래스 생성 및 작성
4. activity_main.xml 디자인 작업
5. item_recycler.xml 생성 및 작업
6. MusicRecyclerAdapter.kt 클래스 생성
7. MainActivity.kt 수정

- 권한 문제 발견. 보류

### 네트워크

#### 구글지도앱 

[소스]()

1. Android Studio > SDK Manager > SDK Tools 내 Google Play services 체크 설치
2. 프로젝트 생성 - Empty Activity 로 만들어도 상관없음
3. MainActivity.kt, activity_main.xml 삭제
4. New > Google > Google Maps Views Activity 클릭
    - MainActivity 로 이름 변경
    - Launcher Activity 체크박스 체크

5. GoogleMaps API 키 받기
    - AndroidManifest.xml 에 Google에 관련된 내용 추가
    - https://developers.google.com/maps/documentation/android-sdk/get-api-key 링크 클릭

    - 새 프로젝트 생성 > 프로젝트 선택
    - API 및 서비스 > + API 및 서비스 사용 설정 > GoogleMap 검색 > Maps sdk for Android
    - 사용자 인증 정보 > API 키 생성

6. AndroidManifest.xml 에 API 키 복사

    ```xml
    <meta-data
        android:name="com.google.android.geo.API_KEY"
        android:value="YOUR_API_KEY" />
    ```

7. build.gradle.kts에 구글플레이 서비스 라이브러리 추가
8. activity_main.xml 수정
9. MainActivity.kt 수정

    <img src="https://raw.githubusercontent.com/hugoMGSung/hugo-kotlin/refs/heads/main/images/kt0042.png" width="310">

### 파이어베이스
13장

### 플레이스토어 게시

