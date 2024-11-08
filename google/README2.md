# 코틀린 기초 2.1

## Android 모바일 앱 개발 - 계속

### 안드로이드와 코틀린 - 계속

#### 권한

##### 안드로이드앱 권한 설정 방법
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