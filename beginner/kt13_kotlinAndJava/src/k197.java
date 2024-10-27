// 197~200 자바에서 코틀린 코드 접근

public class k197 {
    public static void main(String[] args) {
        // 197
        System.out.println(File1Kt.getA()); // File1.kt 파일과 매핑
        File1Kt.func();
        File1Kt.extension(100);

        MyKotlin.func2(); // File2.kt 파일 JvmName()과 매핑

        // 198
        KotlinClass2 kotlin = new KotlinClass2();
        kotlin.setNum(17);
        System.out.println(kotlin.getNum());

        // JvmField 어노테이션을 붙이면
        kotlin.num2 = 5;
        System.out.println(kotlin.num2);

        // JvmName 어노테이션
        kotlin.setter(23);
        System.out.println(kotlin.getter()); // num3 출력

        // 199
        System.out.println(KotlinObject.INSTANCE.getNum());
        KotlinObject.INSTANCE.setNum(0);
        KotlinObject.INSTANCE.hello();

        // JvmName 어노테이션
        System.out.println(KotlinObject.getNum2());

        // 200. 코틀린의 동반자 객체 - 선언된 객체와 비슷하게 접근
        KotlinClass3.Companion.setNum(29);
        System.out.println(KotlinClass3.Companion.getNum());
        KotlinClass3.Companion.hello();

        //JvmStatic 어노테이션
        KotlinClass3.hi();
    }
}
