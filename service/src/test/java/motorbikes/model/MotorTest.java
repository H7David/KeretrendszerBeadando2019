package motorbikes.model;

import com.mongodb.MongoClient;
import  com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import motorbikes.exception.RosszRendszam;
import org.bson.Document;
import org.junit.Test;

//import javax.swing.text.Document;
import java.net.UnknownHostException;

public class MotorTest {

    @Test
    public void testSetRendszam() {
        String rendszam="GSX-666";
        Motor motor = new Motor();
        try {
            motor.setRendszam(rendszam);
        } catch (RosszRendszam rosszRendszam) {
            rosszRendszam.printStackTrace();
        }
    }
    @Test(expected = RosszRendszam.class)
    public void testSetRendszamWithBadParameter() throws RosszRendszam {
        String rendszam="GS-666";
        Motor motor = new Motor();
        motor.setRendszam(rendszam);

    }

    @Test
    public void testDB() throws UnknownHostException {
        String uri =
                "mongodb+srv://proba:proba@ora-hypby.mongodb.net/test?retryWrites=true&w=majority";

        MongoClient mongoClient = new MongoClient(uri);
        MongoDatabase database = mongoClient.getDatabase("adatbazis");
        System.out.println(database.getName());
        MongoCollection<Document> motors = database.getCollection("motors");
        Document ujmotor= new Document();
        ujmotor.append("rendszam","gsx-666");
        motors.insertOne(ujmotor);
    }

}
