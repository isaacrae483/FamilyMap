package Model.ServerAccess;


import java.io.*;
import java.net.*;

import Model.Model.AuthToken;
import Model.Model.LoginData;
import Model.Requests.LoginRequest;
import Model.Requests.RegisterRequest;
import Model.Responce.LoginResponse;
import Model.Responce.Response;
import Model.Responce.Error;

public class ServerProxy {


    public Response login(LoginData data){
        LoginRequest loginRequest = new LoginRequest(data.getUserName(), data.getPassword());

        /*try{
            URL url = new URL ("http://" + data.getHost() + ":" + data.getPort() + "/login");
            HttpURLConnection http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.connect();
            String reqData = null;//convert login request to json
            OutputStream reqBody = http.getOutputStream();
            OutputStreamWriter sw = new OutputStreamWriter(reqBody);
            sw.write(reqData);
            sw.flush();
            reqBody.close();

            //checking response;
            if(http.getResponseCode() == HttpURLConnection.HTTP_OK){

                InputStreamReader respBody = new InputStreamReader(http.getInputStream());


            }
            else{
                InputStream respBody = http.getInputStream();
                //return the Error
            }


        }catch(IOException e){
            e.printStackTrace();
        }*/


        return new Error("hello world");
    }
    public Response register(LoginData data){
        RegisterRequest registerRequest = new RegisterRequest(data.getUserName(), data.getPassword(), data.getEmail(), data.getFirstName(), data.getLastName(), data.getGender());

        return new Error("hello world");
    }
    public Response getPeople(String token, String host, String port){
        return new Error("hello world");
    }
    public Response getEvents(String token, String host, String port){
        return new Error("hello world");
    }
}
