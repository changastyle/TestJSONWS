package network;

import com.google.gson.JsonObject;
import java.util.List;


public class ThreadNetworking2 extends Thread
{
    private String url;
    private String token;
    private List<ParametroJSON> listadoParametros;
    private ResultadoRest resultado;
    private boolean isGetRequest, esperoArray;

    public ThreadNetworking2(String url, String token, boolean isGet, boolean esperoArray, List<ParametroJSON> listadoParametros)
    {
        this.url = url;
        this.token = token;
        this.isGetRequest = isGet;
        this.esperoArray = esperoArray;
        this.listadoParametros = listadoParametros;

        //this.run();

    }

    @Override
    public void run()
    {
        super.run(); 
        
        if(isGetRequest)
        {
            if(esperoArray)
            {
                resultado = JSONWS.sendPorGet(url, listadoParametros, true);
            }
            else
            {
                resultado = JSONWS.sendPorGet(url, listadoParametros, false);
            }
        }
        else
        {
            if(esperoArray)
            {
                resultado = JSONWS.sendPorPost(url, listadoParametros, true);
            }
            else
            {
                resultado = JSONWS.sendPorPost(url, listadoParametros, false);
            }
        }

       /* if(resultado.getReturnCode()==401)
        {
            //MasterController.logout();
            //MasterController.tokenDeSesion=null;
        }*/

        //return null;
        
    }

    /*
    @Override
    protected Object doInBackground(Object[] objects)
    {
        JSONWS jsonws = new JSONWS();
        RestWSClient rest= new RestWSClient();

        if(isGetRequest)
        {
            if(esperoArray)
            {
                JSONWS.dameArrayJava(url,)
                restResult = rest.getAsArr(url, jsonToSend, token);
            }
            else
            {
                restResult = rest.getAsObj(url, jsonToSend,token);
            }
        }
        else
        {
            restResult = rest.post(url , jsonToSend , token);
        }

        if(restResult.getReturnCode()==401)
        {
            //MasterController.logout();
            //MasterController.tokenDeSesion=null;
        }

        return null;
    }
*/
    public ResultadoRest dameResultado() {
        return resultado;
    }
}
