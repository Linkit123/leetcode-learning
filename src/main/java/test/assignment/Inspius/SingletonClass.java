package test.assignment.Inspius;

public final class SingletonClass {

    private static SingletonClass INSTANCE;
    
    private SingletonClass() {        
    }
    
    public static SingletonClass getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new SingletonClass();
        }
        
        return INSTANCE;
    }
}