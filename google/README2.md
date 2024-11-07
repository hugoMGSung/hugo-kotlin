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
            <td>CALENDAR</td>
            <td>READ_CALENDAR</td>
            <td>캘린더 읽기</td>
        </tr>
        <tr>
            <td>CALENDAR</td>
            <td>WRITE_CALENDAR</td>
            <td>캘린더 쓰기</td>
        </tr>
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </table>


