package general;

public class MemoryDemo {
    int instanceVar = 10;          // biến instance -> lưu trong Heap
    static int staticVar = 20;     // biến static -> lưu trong Metaspace/Class area

    public static void main(String[] args) {
        int localVar = 30;         // biến cục bộ -> lưu trong Stack
        MemoryDemo obj = new MemoryDemo(); // object -> lưu trong Heap

        obj.methodExample(localVar);
    }

    void methodExample(int param) {
        int localMethodVar = 40;   // biến cục bộ -> Stack
        System.out.println("param = " + param);
        System.out.println("localMethodVar = " + localMethodVar);
        System.out.println("instanceVar = " + instanceVar);
        System.out.println("staticVar = " + staticVar);
    }
}