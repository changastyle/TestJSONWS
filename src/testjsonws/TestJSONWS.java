package testjsonws;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.ParametroJSON;
import network.ThreadNetworking;
import network.ThreadNetworking2;

public class TestJSONWS
{
    public static void main(String[] args)
    {
        try
        {
            String url = "http://192.168.5.131:8080/controlgastosws/findEntradas";
            List<ParametroJSON> parametrosList = new ArrayList<ParametroJSON>();
            parametrosList.add(new ParametroJSON("mesYAnio", new Gson().toJson(new MesYAnio(2, (2018 - 1900 )) )));
            
            ThreadNetworking2 thread = new ThreadNetworking2(url,null,false,true,parametrosList);
            thread.start();
            thread.join();
            System.out.println("res: " + thread.dameResultado());
            
        } 
        catch (InterruptedException ex)
        {
            Logger.getLogger(TestJSONWS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
               
    }
    
}
