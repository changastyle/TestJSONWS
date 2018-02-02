package network;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class ResultadoRest {
    private JsonArray jsonArray;
    private JsonObject jsonObject;
    private int returnCode = -1;


    public ResultadoRest(JsonArray jsonArray, JsonObject jsonObject, int returnCode) {
        this.jsonArray = jsonArray;
        this.jsonObject = jsonObject;
        this.returnCode = returnCode;
    }

    public JsonArray getJsonArray() {
        return jsonArray;
    }

    public void setJsonArray(JsonArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }

    public void setJsonObject(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public int getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(int returnCode) {
        this.returnCode = returnCode;
    }
    public boolean isValid()
    {
        boolean valid = false;


        if(returnCode == 200)
        {
            valid = true;
        }


        return valid;
    }
    public boolean is401()
    {
        boolean si = false;

        if(returnCode == 401)
        {
            si = true;
        }

        return si;
    }

    @Override
    public String toString()
    {
        return "ResultadoRest\n{\n" + " jsonArray = " + jsonArray + "\n jsonObject = " + jsonObject + "\n returnCode = " + returnCode + "\n}\n";
    }
    
    
}
