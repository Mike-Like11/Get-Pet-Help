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
    private void showRegisterWindow(){
    final AlertDialog.Builder dialog=new AlertDialog.Builder(this);
    dialog.setTitle("Зарегистрироваться");
    dialog.setPositiveButton("Добавить",null);
    dialog.setNegativeButton("отменить",null);
    dialog.setMessage("Введите все ваши данные для регистрации");
    LayoutInflater inflater=LayoutInflater.from(this);
    View register_window=inflater.inflate(R.layout.register_window,null);
    dialog.setView(register_window);
dialog.setCancelable(false);
   final MaterialEditText email=register_window.findViewById(R.id.emailField);
   final MaterialEditText name=register_window.findViewById(R.id.nameField);
   final MaterialEditText phone=register_window.findViewById(R.id.telephoneField);
   final MaterialEditText pass=register_window.findViewById(R.id.parolField);
  dialog.setNegativeButton("Отменить", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface , int which) {
            dialogInterface.dismiss();
        }
    });

    dialog.setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(final DialogInterface dialogInterface , int which) {


            }
    });

final AlertDialog dialog1=dialog.create();
dialog1.show();
dialog1.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if(TextUtils.isEmpty(email.getText().toString())){
            email.setError("Введите вашу почту");



        }
        else {
            if (TextUtils.isEmpty(name.getText().toString())) {
                name.setError("Введите ваше имя");

                return;

            } else {
                if (TextUtils.isEmpty(phone.getText().toString())) {
                    phone.setError("Введите ваш телефон");

                    return;

                } else {
                    if (pass.getText().toString().length() < 5) {
                        pass.setError("Введите ваш пароль(более 5 символов)");

                        return;
                    } else {

                       
                    }
                }
            }
        }
    }
});
}
}
