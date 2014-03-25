package dataSource;

public class DBFacade {
    //== Fields
    private DBFacade instance;
    
    //== Constructor
    private DBFacade(){
    }
    
    //== Methods
    public DBFacade getInstance(){
        if(instance == null)
            instance = new DBFacade();
        return instance;
    }
}
