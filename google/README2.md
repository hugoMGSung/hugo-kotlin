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


