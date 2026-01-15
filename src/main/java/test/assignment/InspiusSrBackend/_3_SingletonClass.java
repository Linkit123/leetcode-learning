package test.assignment.InspiusSrBackend;

public final class _3_SingletonClass {

    private static _3_SingletonClass INSTANCE;
    
    private _3_SingletonClass() {        
    }
    
    public static _3_SingletonClass getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new _3_SingletonClass();
        }
        
        return INSTANCE;
    }
}