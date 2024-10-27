package kt10_filetest

import java.io.*  // 185. 파일입출력

fun main() {
    println("kt10_filetest!!")

    val file = File("./hello.txt")

    if(!file.exists())
        file.createNewFile()

    val outputStream:OutputStream = file.outputStream() //코틀린 확장 함수
    //inline fun File.outputStream():FileOutputStream
    outputStream.write(35)

    //File.writer 함수, OutputStream.writer 함수
    val osw:OutputStreamWriter = outputStream.writer()
    osw.write("파일 입출력")
    osw.close()

    val inputStream:InputStream = file.inputStream() //코틀린 확장 함수
    println(inputStream.read())

    //File.reader 함수, InputStream.reader 함수
    val isr:InputStreamReader = inputStream.reader()
    println(isr.readText())
    isr.close()
    println("파일 입출력 끝.")

    // 186. 디렉토리 순회
    //File.walk로 생성시 FileWalkDirection은 TOP_DOWN of BOTTOM_UP(기본값 TOP_DOWN)
    //maxDepth는 하위 탐색 최대 깊이
    val fileTree:FileTreeWalk = File("./").walk()
        .maxDepth(3)
        .onEnter { file-> //새로운 디렉토리 방문할 때
            println("새 디렉토리 방문 : ${file.name}")
            true
        }

    for (file in fileTree)
        println(file.name)
}