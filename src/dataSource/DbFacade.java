package dataSource;

public class DbFacade {
    //== Fields
    private DbFacade instance;
    
    //== Constructor
    private DbFacade(){
    }
    
    //== Methods
    public DbFacade getInstance(){
        if(instance == null)
            instance = new DbFacade();
        return instance;
    }
}
