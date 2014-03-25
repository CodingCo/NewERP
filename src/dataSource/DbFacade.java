package dataSource;



import java.sql.Connection;




/**
 *
 * @author kasper
 */



import java.sql.Connection;


public class DbFacade {
    //== Fields
    private UnitOfWorkProcess uow;
    private Connection con;
    
    //== Singleton Start
    private static DbFacade instance;
    
    //== Constructor
    private DbFacade(){
        uow = UnitOfWorkProcess.getInstance();
        con = DBConnector.getInstance().getConnection();
    }
    
    public static DbFacade getInstance(){
        if(instance == null)
            instance = new DbFacade();
        return instance;
    }

    //== Singleton End
    
}
