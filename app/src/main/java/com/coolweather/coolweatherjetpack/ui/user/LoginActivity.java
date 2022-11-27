package com.coolweather.coolweatherjetpack.ui.user;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.coolweather.coolweatherjetpack.R;

public class LoginActivity extends AppCompatActivity {
    String userName;
    String password;
    boolean superUser;
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = new User(1);
        EditText nameText = findViewById(R.id.userName);
        nameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                userName = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        final CheckBox superCheck = findViewById(R.id.superUser);
        superCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                superUser = b;
            }
        });

        final EditText psdText = findViewById(R.id.userName);
        psdText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserManager.getInstance().login(user, superUser);
            }
        });
        findViewById(R.id.btn_change).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserManager.getInstance().changeData(user);
            }
        });
        findViewById(R.id.btn_access).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserManager.getInstance().accessData(user);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        UserManager.getInstance().logout(user);
    }
}
