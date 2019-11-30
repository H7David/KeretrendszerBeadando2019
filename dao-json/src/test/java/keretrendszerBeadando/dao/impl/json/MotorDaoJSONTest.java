package keretrendszerBeadando.dao.impl.json;

import motorbikes.dao.MotorDAO;
import motorbikes.exception.RendszamMarFoglalt;
import motorbikes.exception.RosszDatum;
import motorbikes.exception.RosszEvjarat;
import motorbikes.exception.RosszRendszam;
import motorbikes.model.Allapot;
import motorbikes.model.Motor;
import org.junit.Test;

import java.time.LocalDate;

public class MotorDaoJSONTest {

    @Test
    public void test(){
        MotorDAO dao =new MotorDAOJSON("src/main/resources/jsonfile.json");
        try{
            Motor motor = new Motor("Suzuki","GSX-R 1000","QSX-666", LocalDate.of(2019,03,22),185,192,6,1,17,2015,"#FFFFFF", Allapot.UJSZERU);
            dao.insertMotor(motor);
            System.out.print(dao.readAllMotors());
        }
        catch (RosszDatum rosszDatum){rosszDatum.printStackTrace();}
        catch (RosszRendszam rosszRendszam) { rosszRendszam.printStackTrace(); }
        catch (RosszEvjarat rosszEvjarat) { rosszEvjarat.printStackTrace(); }
        catch (RendszamMarFoglalt rendszamMarFoglalt) { rendszamMarFoglalt.printStackTrace(); }

    }
}
