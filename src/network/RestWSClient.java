package network;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RestWSClient
{



    public static JsonObject jsonObj;
    public static JsonArray jsonArr;


/*
    public static void main(String[] args) {
        String token;
        JsonObject ret;
        JsonArray retArr;
        JsonObject toSend = new JsonObject();

        toSend.addProperty("idCajero", 1000);
        toSend.addProperty("pin", 2233);
        toSend.addProperty("serial", "12345678");
        toSend.addProperty("maqlo", "1002841");

        ret = post("http://192.168.59.213:8081/login", toSend);
        if (ret != null) {
            token = ret.get("descripcion").getAsString();
            System.out.println("token: " + token);
            retArr = getAsArr("http://192.168.59.213:8081/sorteos", token);
            System.out.println("Dio: " + retArr.toString());
        } else {
            System.out.println("UPA, dio null");
        }
    }
    */

//    public static ResultadoRest post(String url, JsonObject toSend, String token)
//    {
//        ResultadoRest ret=new ResultadoRest();
//                try {
//
//                    URL urlObj = new URL(url);
//                    HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
//                    conn.setDoOutput(true);
//                    conn.setRequestMethod("POST");
//                    conn.setRequestProperty("Content-Type", "application/json");
//
//                    if(token != null && !token.isEmpty())
//                    {
//                        conn.setRequestProperty("authorization", token);
//                    }
//
//                    OutputStream os = conn.getOutputStream();
//
//                    String str = new Gson().toJson(toSend);
//                    System.out.println("MANDO POR POST: " +str );
//                    if(toSend != null)
//                    {
//                        os.write(str.getBytes());
//                    }
//                    os.flush();
//
//                    //os.close();
//                    int code=conn.getResponseCode();
//                    ret.setReturnCode(code);
//                    if (code == HttpURLConnection.HTTP_OK || code == HttpURLConnection.HTTP_BAD_REQUEST)
//                    {
//                        InputStreamReader isr;
//                        if(code == HttpURLConnection.HTTP_OK)
//                        {
//                            isr = new InputStreamReader(conn.getInputStream());
//                        } else
//                        {
//                            isr = new InputStreamReader(conn.getErrorStream());
//                        }
//                        BufferedReader br = new BufferedReader(isr);
//                        String output;
//                        String acumulado = "";
//                        while ((output = br.readLine()) != null)
//                        {
//                            acumulado += output;
//                            //System.out.println(output);
//                        }
//                        ret.setJsonObject(new JsonParser().parse(acumulado).getAsJsonObject());
//                    }
//                    else
//                    {
//                        System.out.println("Error: " + conn.getResponseCode());
//                    }
//                    conn.disconnect();
//                } catch (Exception e)
//                {
//                    e.printStackTrace();
//                }
//        return ret;
//    }
//
//    public static ResultadoRest getAsArr(String url, JsonObject toSend, String token)
//    {
//        ResultadoRest ret = new ResultadoRest();
//
//        try
//        {
//            URL urlObj = new URL(url);
//            HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
//            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Accept", "application/json");
//
//            if(token != null && !token.isEmpty())
//            {
//                conn.setRequestProperty("authorization", token);
//            }
//            OutputStream os = conn.getOutputStream();
//
//            if(toSend != null)
//            {
//                os.write(toSend.toString().getBytes());
//            }
//            os.flush();
//
//            ret.setReturnCode(conn.getResponseCode());
//
//            System.out.println("STATUS PETICION ("+ url + ") : " + conn.getResponseCode());
//            if (conn.getResponseCode() != 200)
//            {
//                System.out.println("Error: " + conn.getResponseCode());
//            }
//            else
//            {
//
//                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
//
//                String output;
//                String acumulado = "";
//                while ((output = br.readLine()) != null)
//                {
//                    acumulado += output;
//                }
//                ret.setJsonArray(new JsonParser().parse(acumulado).getAsJsonArray());
//            }
//            conn.disconnect();
//
//        }
//        catch (Exception e)
//        {
//            e.printStackTrace();
//
//        }
//
//        return ret;
//    }
//
//    public static ResultadoRest getAsObj(String url, JsonObject toSend, String token)
//    {
//        ResultadoRest ret=new ResultadoRest();
//                try
//                {
//
//                    URL urlObj = new URL(url);
//                    HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
//                    conn.setRequestMethod("GET");
//                    conn.setRequestProperty("Accept", "application/json");
//
//                    if(token != null && !token.isEmpty())
//                    {
//                        conn.setRequestProperty("authorization", token);
//                    }
//                    OutputStream os = conn.getOutputStream();
//
//                    if(toSend != null)
//                    {
//                        os.write(toSend.toString().getBytes());
//                    }
//                    os.flush();
//
//                    ret.setReturnCode(conn.getResponseCode());
//
//                    if (conn.getResponseCode() != 200)
//                    {
//                        System.out.println("Error: " + conn.getResponseCode());
//                    } else {
//
//                        BufferedReader br = new BufferedReader(new InputStreamReader(
//                                (conn.getInputStream())));
//
//                        String output;
//                        String acumulado = "";
//                        while ((output = br.readLine()) != null) {
//                            System.out.println("SALIDA: " + output);
//                            acumulado += output;
//                        }
//
//                        ret.setJsonObject(new JsonParser().parse(acumulado).getAsJsonObject());
//                    }
//                    conn.disconnect();
//
//                } catch (Exception e) {
//
//                    e.printStackTrace();
//
//                }
//
//        return ret;
//    }
}
