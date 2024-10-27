public class JavaClass {
    private int value;

    // get... set... 메서드가 있으면 프로퍼티 접근이 가능하다.
    // int 타입을 다루므로 Int 타입의 프로퍼티로 인식된다.
    public int getSomething()
    {
        return value;
    }

    public void setSomething(int value)
    {
        this.value = value;
    }

    public double getDoubleValue()
    {
        return 3.14;
    }

    //is... 형태이고 boolean 타입인 메서드 -> 프로퍼티로 접근 가능
    //메서드 이름과 동일한 프로퍼티
    public boolean isGood()
    {
        return true;
    }
}
