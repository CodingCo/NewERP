package dataSource;

public class UnitOfWorkProcess {
    //== Fields
    
    //== Singleton Start
    private static  UnitOfWorkProcess instance;
    
    //== Constructor
    private UnitOfWorkProcess(){
        
    }
    
    public static UnitOfWorkProcess getInstance(){
        if(instance == null)
            instance = new UnitOfWorkProcess();
        return instance;
    }
    //== Singleton End
    
    
    //== Methods
    
    
}
