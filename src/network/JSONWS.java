package network;

import java.io.OutputStreamWriter;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.List;

public class JSONWS
{
    public static ResultadoRest sendData2(String urlWS, List<ParametroJSON> listaParametros,  boolean isGet , boolean esArray)
    {
        ResultadoRest resultado = null;
        URL url;
        String data = "";
        
        try
        {
            url = new URL(urlWS);

            // 0 - COSAS HTTP:
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setDoOutput(true);
            
            StringBuilder infoParaMandar  = new StringBuilder();
            
            // 1 - PREPARO LOS PARAMETROS:
            if(url != null)
            {
                //GET:
                if(isGet)
                {
                    conn.setRequestMethod("GET");
                    
                    if(listaParametros != null)
                    {
                        if(listaParametros.size() > 0)
                        {
                            for(ParametroJSON parametro :  listaParametros)
                            {
                                urlWS += "?" + parametro.getNombreParametro() + "=" + parametro.getValor();
                            }
                        }
                    }
                   
                    System.out.println("PARAMETROS (" + listaParametros.size() + "): " + urlWS);
                    conn.setRequestProperty("Content-Length", String.valueOf(0));
                    if(listaParametros.size() > 0)
                    {
                     url = new URL(URLEncoder.encode(urlWS, "UTF-8"));
                    }
                }
                else
                {
                    //POST_
                    conn.setRequestMethod("POST");
                    
                    if(listaParametros != null)
                    {
                        if(listaParametros.size() > 0)
                        {
                            for(ParametroJSON parametro :  listaParametros)
                            {
                                infoParaMandar.append(parametro.getNombreParametro() + "=" + parametro.getValor());
                            }
                        }
                    }
                    System.out.println("PARAMETROS (" + listaParametros.size() + "): " + infoParaMandar);
                    byte[] bytesAenviar = infoParaMandar.toString().getBytes("UTF-8");
                    conn.setRequestProperty("Content-Length", String.valueOf(bytesAenviar.length));
                    
                    //ENVIO LOS PARAMETROS POR POST:
                    conn.getOutputStream().write(bytesAenviar);
                }
                
                
                
                
                
                // 3 - LEO EL ARCHIVO QUE ME DEVUELVE:
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

                //2.Leo el archivo y guardo el contenido en data:
                String linea;
                while(( linea = in.readLine()) != null)
                {
                    data += linea;
                }

                if(data != null && !data.isEmpty())
                {
                    if(esArray)
                    {
                        JsonArray jsonArrayRecibido = new JsonParser().parse(data).getAsJsonArray();
                        resultado = new ResultadoRest(jsonArrayRecibido, null,conn.getResponseCode());
                    }
                    else
                    {
                        JsonObject jsonObjectRecibido = new JsonParser().parse(data).getAsJsonObject();
                        resultado = new ResultadoRest(null, jsonObjectRecibido,conn.getResponseCode());
                    }
                }
            }
        }
        catch(Exception e)
        {
            System.out.println( "Error: sendData(" + urlWS + ") ->" + e.toString() );
        }
        return resultado;
    }
    public static String sendData(String urlWS , String parameter, String datosParaEnviar)
    {
        URL url;
        String data = "";

        try
        {
            url = new URL(urlWS);

            if(url != null)
            {
                StringBuilder postData  = new StringBuilder();

                /*
                postData.append(URLEncoder.encode("jugadas", "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder.encode(String.valueOf("1"), "UTF-8"));
                */

                postData.append(parameter + "=" + datosParaEnviar);
                byte[] postDataBytes = postData.toString().getBytes("UTF-8");

                System.out.println("Sending: " + postData);


                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
                conn.setDoOutput(true);
                conn.getOutputStream().write(postDataBytes);

                //1.Traigo los datos del WS a un "Archivo":
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));

                //2.Leo el archivo y guardo el contenido en data:
                String linea;
                while(( linea = in.readLine()) != null)
                {
                    data += linea;
                }
            }
        }
        catch(Exception e)
        {
            System.out.println( "Error: sendData(" + urlWS + ") ->" + e.toString() );
        }
        return data;
    }
    private static String getDataFromWS(String urlWS)
    {
        URL url;
        String data = "";
        try
        {
            url = new URL(urlWS);
            if(url != null)
            {
                //1.Traigo los datos del WS a un "Archivo":

                InputStreamReader inputStreamReader = new InputStreamReader(url.openStream());
                if(inputStreamReader != null)
                {
                    BufferedReader in = new BufferedReader(inputStreamReader);

                    //2.Leo el archivo y guardo el contenido en data:
                    String linea;
                    while(( linea = in.readLine()) != null)
                    {
                        data += linea;
                    }
                }
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println("ERROR: Controller.getDataFromWS(" + urlWS +")");
        }
        return data;
    }
    public static Object dameObjetoJava(String url, Class claseAParsear)
    {
        String data = getDataFromWS(url);
        //System.out.println("dameObjetoJava: RECIBO ESTO -> " + url + "-> "+ data);

        Gson gson = new Gson();
        Object obj = null;
        if(!data.trim().equalsIgnoreCase(""))
        {
            obj = gson.fromJson(data, claseAParsear);
        }

        /* System.out.println("dameObjetoJava : parsie esto ->" + obj);*/

        return obj;
    }
    public static ArrayList dameArrayJava(String url, Class claseAParsear)
    {
        ArrayList arrSaliente = new ArrayList<>();

        String dataFromWS = getDataFromWS(url);
        //System.out.println("dataFromWS: " + dataFromWS);

        if(!dataFromWS.trim().equalsIgnoreCase(""))
        {
            Gson gson = new Gson();
            JsonArray entries = (JsonArray) new JsonParser().parse(dataFromWS);
            //System.out.println("entries: " + entries);

            for(int i = 0 ; i < entries.size() ; i++)
            {
                Object objGenerico = gson.fromJson( entries.get(i) , claseAParsear);
                arrSaliente.add(objGenerico);
                //System.out.println("objGenerico: " + objGenerico);
            }
        }


        return arrSaliente;
    }
    public static String dameArrayEnJSON(ArrayList<Object> arr)
    {
        Gson gson = new Gson();
        return gson.toJson(arr);
    }
    public static ArrayList solamenteConvertirDatosJSONaArrayJava(String datosJSON,Class claseAParsear)
    {
        ArrayList arrSaliente = new ArrayList<>();

        if(!datosJSON.trim().equalsIgnoreCase(""))
        {
            Gson gson = new Gson();
            JsonArray entries = (JsonArray) new JsonParser().parse(datosJSON);
            //System.out.println("entries: " + entries);

            for(int i = 0 ; i < entries.size() ; i++)
            {
                Object objGenerico = gson.fromJson( entries.get(i) , claseAParsear);
                arrSaliente.add(objGenerico);
                //System.out.println("objGenerico: " + objGenerico);
            }
        }

        return arrSaliente;
    }
    public static Object solamenteConvertirDatosJSONaObjetoJava(String datosJSON, Class claseAParsear)
    {
        Gson gson = new Gson();
        Object obj = null;
        if(!datosJSON.trim().equalsIgnoreCase(""))
        {
            obj = gson.fromJson(datosJSON, claseAParsear);
        }
        return obj;
    }


    public static ResultadoRest sendPorPost(String url, List<ParametroJSON> listadoParametros, boolean esArray)
    {
        ResultadoRest resultado = null;

        ResultadoRest resultadoRest = sendData2(url,listadoParametros,true,esArray);

        if(resultadoRest != null )
        {
            resultado = resultadoRest;
        }

        return resultado;
    }

    public static ResultadoRest sendPorGet(String url, List<ParametroJSON> listadoParametros, boolean esArray)
    {
        ResultadoRest resultado = null;

        ResultadoRest resultadoRest = sendData2(url,listadoParametros,true,esArray);

        if(resultadoRest != null )
        {
            resultado = resultadoRest;
        }

        return resultado;
    }
}