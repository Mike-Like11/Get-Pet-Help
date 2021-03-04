package com.example.getpethelp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Button sign,register;
    RelativeLayout root;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        sign=findViewById(R.id.button2);
        register=findViewById(R.id.button);
        root=findViewById(R.id.root_element);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRegisterWindow();
            }
        });
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSignWindow();
            }
        });
    }
    private void showSignWindow(){
        final AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setTitle("Войти");
        dialog.setMessage("Введите данные для входа ");
        dialog.setPositiveButton("Войти",null);
        LayoutInflater inflater=LayoutInflater.from(this);
        View sign_window=inflater.inflate(R.layout.sign_window,null);
        dialog.setView(sign_window);
        final MaterialEditText email=sign_window.findViewById(R.id.emailField);

        final MaterialEditText pass=sign_window.findViewById(R.id.parolField);
        dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface , int which) {
                dialogInterface.dismiss();
            }
        });
        dialog.setPositiveButton("Войти", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface , int which) {

            }
        });
        final AlertDialog dialog1=dialog.create();
        dialog1.show();
        dialog1.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(email.getText().toString())){
                    email.setError("Введите вашу почту");

                    return;

                }

                if(pass.getText().toString().length()<5){
                    pass.setError("Неправильный пароль");
                    return;
                }

                                dialog1.dismiss();
                                startActivity(new Intent(MainActivity.this, MaiwActivity.class));
                                finish();
            }
        });
    }
}