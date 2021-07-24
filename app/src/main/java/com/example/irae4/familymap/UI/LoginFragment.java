package com.example.irae4.familymap.UI;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.irae4.familymap.R;
import Model.Model.LoginData;
import Model.Responce.Error;
import Model.Responce.LoginResponse;
import Model.Responce.Response;
import Model.ServerAccess.ServerProxy;


public class LoginFragment extends Fragment {

    private LoginData mLoginData;

    private EditText mHostField;
    private EditText mPortField;
    private EditText mUserNameField;
    private EditText mPasswordField;
    private EditText mFirstNameField;
    private EditText mLastNameField;
    private EditText mEmailField;
    private RadioGroup mGenderRadio;
    private RadioButton mMaleRadio;
    private RadioButton mFemaleRadio;

    private Button mLoginButton;
    private Button mRegisterButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLoginData = new LoginData();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);

        mHostField = (EditText) v.findViewById(R.id.host_edit_text);
        mHostField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mLoginData.setHost(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });
        mPortField = (EditText) v.findViewById(R.id.port_edit_text);
        mPortField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mLoginData.setPort(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });
        mUserNameField = (EditText) v.findViewById(R.id.userName_edit_text);
        mUserNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mLoginData.setUserName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });
        mPasswordField = (EditText) v.findViewById(R.id.password_edit_text);
        mPasswordField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mLoginData.setPassword(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });
        mFirstNameField = (EditText) v.findViewById(R.id.firstName_edit_text);
        mFirstNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mLoginData.setFirstName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });
        mLastNameField = (EditText) v.findViewById(R.id.lastName_edit_text);
        mLastNameField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mLoginData.setLastName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });
        mEmailField = (EditText) v.findViewById(R.id.email_edit_text);
        mEmailField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(
                    CharSequence s, int start, int count, int after) {
                // This space intentionally left blank
            }

            @Override
            public void onTextChanged(
                    CharSequence s, int start, int before, int count) {
                mLoginData.setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                // This one too
            }
        });

        mMaleRadio = (RadioButton) v.findViewById(R.id.radio_male);
        mFemaleRadio = (RadioButton) v.findViewById(R.id.radio_female);
        mGenderRadio = (RadioGroup) v.findViewById(R.id.gender_group);
        mGenderRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                RadioButton checkedRadioButton = (RadioButton)mGenderRadio.findViewById(mGenderRadio.getCheckedRadioButtonId());

                if (checkedRadioButton == mMaleRadio)
                {
                    mLoginData.setGender("m");
                }
                else if (checkedRadioButton == mFemaleRadio){
                    mLoginData.setGender("f");
                }
                else {
                    mLoginData.setGender(null);
                }
            }
        });



        mLoginButton = (Button) v.findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mLoginButton.setEnabled(false);
                mRegisterButton.setEnabled(false);
                boolean full = checkFields(false);
                if(!full){
                    Toast.makeText(getActivity(), "Please Check Your Input", Toast.LENGTH_SHORT).show();
                    mLoginButton.setEnabled(true);
                    mRegisterButton.setEnabled(true);
                }
                else{
                    Toast.makeText(getActivity(), "Logging In", Toast.LENGTH_SHORT).show();
                    LoginTask task = new LoginTask();
                    task.execute(mLoginData);
                }


            }
        });
        mRegisterButton = (Button) v.findViewById(R.id.register_button);
        mRegisterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mLoginButton.setEnabled(false);
                mRegisterButton.setEnabled(false);
                boolean full = checkFields(true);
                if(!full){
                    Toast.makeText(getActivity(), "Please Check Your Input", Toast.LENGTH_SHORT).show();
                    mLoginButton.setEnabled(true);
                    mRegisterButton.setEnabled(true);
                }
                else{
                    Toast.makeText(getActivity(), "Registering", Toast.LENGTH_SHORT).show();
                    RegisterTask task = new RegisterTask();
                    task.execute(mLoginData);
                }

            }
        });


        return v;
    }
    private boolean checkFields(boolean register){
        if(mLoginData.getHost() == null)
            return false;
        if(mLoginData.getPort() == null)
            return false;
        if(mLoginData.getUserName() == null)
            return false;
        if(mLoginData.getPassword() == null)
            return false;
        if(register){
            if(mLoginData.getFirstName() == null)
                return false;
            if(mLoginData.getLastName() == null)
                return false;
            if(mLoginData.getEmail() == null)
                return false;
            if(mLoginData.getGender() == null)
                return false;
        }
        return true;
    }

    public class LoginTask extends AsyncTask<LoginData, Integer, Boolean>{
        Response response;
        String host;
        String port;
        LoginData data;
        @Override
        protected Boolean doInBackground(LoginData...datas){
            data = datas[0];
            host = data.getHost();
            port = data.getPort();

            ServerProxy proxy = new ServerProxy();
            response = proxy.login(data);
            if(response instanceof Error){
                return false;
            }

            LoginResponse resp = (LoginResponse)response;
            response = proxy.getPeople(resp.getAuthToken(), host, port);
            if(response instanceof Error){
                return false;
            }
            response = proxy.getEvents(resp.getAuthToken(), host, port);
            if(response instanceof Error){
                return false;
            }
            return true;
        }
        protected void onPostExecute(Boolean result) {
            if(result){
                String info ="Register Successful for " + data.getFirstName() + " " + data.getLastName();
                Toast.makeText(getActivity(), info, Toast.LENGTH_SHORT).show();
            }
            else{
                mLoginButton.setEnabled(true);
                mRegisterButton.setEnabled(true);
                Error error = (Error)response;
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }

        }
    }
    public class RegisterTask extends AsyncTask<LoginData, Integer, Boolean>{
        @Override
        protected Boolean doInBackground(LoginData...data){

            return true;
        }
        protected void onPostExecute(Boolean result) {
            Toast.makeText(getActivity(), "Register successful", Toast.LENGTH_SHORT).show();
        }
    }

}

