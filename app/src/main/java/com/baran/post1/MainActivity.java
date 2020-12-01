package com.baran.post1;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.baran.post1.Models.ResultModel;
import com.baran.post1.RestApi.ManagerAll;
import com.google.android.material.textfield.TextInputEditText;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextInputEditText textInputEditTextAd, textInputEditTextSoyad;
    Button buttonKayitEkle;
    String ad, soyad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tanimla();
        butonaTikla();
    }

    public void tanimla() {
        textInputEditTextAd = findViewById(R.id.textInputEditTextAd);
        textInputEditTextSoyad = findViewById(R.id.textInputEditTextSoyad);
        buttonKayitEkle = findViewById(R.id.buttonKayitEkle);

    }

    public void textVerileriniAl() {
        ad = textInputEditTextAd.getText().toString().trim();
        soyad = textInputEditTextSoyad.getText().toString().trim();
    }

    public void istekAt() {
        textVerileriniAl();

        if (!ad.equals("") && !soyad.equals("")){
            Call<ResultModel> istekAtCall = ManagerAll.getInstance().addUser(ad, soyad);
            istekAtCall.enqueue(new Callback<ResultModel>() {
                @Override
                public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                    Toast.makeText(getApplicationContext(),response.body().getResult(),Toast.LENGTH_LONG).show();
                    Log.i("eklemesonucu ", response.body().getResult());
                    edittextTemizle();
                }

                @Override
                public void onFailure(Call<ResultModel> call, Throwable t) {
                    Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
                }
            });
        }else {
            Toast.makeText(this,"Lütfen Bütün Alanları Doldurunuz...",Toast.LENGTH_LONG).show();
        }

    }

    public void butonaTikla(){
        buttonKayitEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                istekAt();
            }
        });
    }

    public void edittextTemizle(){
        textInputEditTextAd.setText("");
        textInputEditTextSoyad.setText("");
    }
}