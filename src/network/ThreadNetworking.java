package network;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;


/**
 * Created by lpiedra on 19/01/18.
 */

public class ThreadNetworking extends Thread
{
    private String url;
    private String token;
    private JsonObject jsonToSend;
    private ResultadoRest restResult;
    private boolean isGetRequest, esperoArray;

    public ThreadNetworking(String url, String token, boolean isGet, boolean esperoArray, JsonObject jsonToSend)
    {
        this.url = url;
        this.token = token;
        this.isGetRequest = isGet;
        this.esperoArray = esperoArray;
        this.jsonToSend = jsonToSend;

        //this.run();

    }

//    @Override
//    protected Object doInBackground(Object[] objects)
//    {
//        RestWSClient rest= new RestWSClient();
//
//        if(isGetRequest)
//        {
//            if(esperoArray)
//            {
//                //restResult = JSONWS.sendPorGet()
//            }
//            else
//            {
//                restResult = rest.getAsObj(url, jsonToSend,token);
//            }
//        }
//        else
//        {
//            restResult = rest.post(url , jsonToSend , token);
//        }
//
//        if(restResult.getReturnCode()==401)
//        {
//            //MasterController.logout();
//            //MasterController.tokenDeSesion=null;
//        }
//
//        return null;
//    }
//
//    public ResultadoRest dameResultado() {
//        return restResult;
//    }
}
