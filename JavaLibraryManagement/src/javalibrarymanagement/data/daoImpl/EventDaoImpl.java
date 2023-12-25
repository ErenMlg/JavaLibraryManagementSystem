package javalibrarymanagement.data.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javalibrarymanagement.patterns.SingletonDataWorks;
import javalibrarymanagement.data.dao.EventDao;
import javalibrarymanagement.data.model.Event;


public class EventDaoImpl implements EventDao{

    private final Statement statement = SingletonDataWorks.getStatement();
    private ResultSet results;
    private static EventDao instance;
    
    public static synchronized EventDao getInstance(){
        if (instance == null) {
            instance = new EventDaoImpl();
        }
        return instance;
    }
    
    
    @Override
    public ArrayList<Event> getAllEvents() {
        ArrayList<Event> allEvents = new ArrayList<Event>();
        try{
            results = statement.executeQuery("SELECT * FROM library_management_system.events;");
            while(results.next()){
                allEvents.add(new Event(
                        results.getInt("eventID"),
                        results.getString("eventType"),
                        results.getString("eventName"),
                        results.getString("eventDesc"),
                        results.getString("eventDate"),
                        results.getInt("librarianID")
                ));
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return allEvents;
    }
    
}
