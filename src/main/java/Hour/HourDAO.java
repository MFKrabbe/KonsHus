package Hour;

public interface HourDAO
{
        // C i CRUD
        void saveHour(Hour hour) throws Exception;
        // R i CRUD
        Hour getHour(String id) throws Exception; // no er primærnøglen
        // R i CRUD
        String [] getAllHours() throws Exception;
        // U i CRUD
        void updateHour(String iD, Hour hour) throws Exception;
        // D i CRUD
        void deleteHour(String iD) throws Exception;

}

