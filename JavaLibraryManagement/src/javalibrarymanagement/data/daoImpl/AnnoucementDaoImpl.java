package javalibrarymanagement.data.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javalibrarymanagement.patterns.SingletonDataWorks;
import javalibrarymanagement.data.dao.AnnoucementDao;
import javalibrarymanagement.data.model.Annoucement;

public class AnnoucementDaoImpl implements AnnoucementDao {
    
    private final Statement statement = SingletonDataWorks.getStatement();
    private ResultSet results;
    private static AnnoucementDao instance;
    
    public static synchronized AnnoucementDao getInstance(){
        if (instance == null) {
            instance = new AnnoucementDaoImpl();
        }
        return instance;
    }

    @Override
    public ArrayList<Annoucement> getAllAnnoucements() {
        ArrayList<Annoucement> allAnnoucement = new ArrayList<>();
        try{
            results = statement.executeQuery("SELECT * FROM library_management_system.annoucements;");
            while(results.next()){
                allAnnoucement.add(new Annoucement(
                        results.getInt("annoucementID"),
                        results.getString("annoucementsName"),
                        results.getString("annoucementsDesc"),
                        results.getString("annoucementsDate"),
                        results.getInt("librarianID")
                        
                ));
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return allAnnoucement;
    }
    
}
