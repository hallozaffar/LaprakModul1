package com.example.PerhitunganGaji;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;

import com.example.PerhitunganGaji.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding binding;
    private  static final String STATE_RESULT = "state result";
    Dialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(view.getId() == binding.Btn.getId()) {

                    String edtNama = binding.edtNama.getText().toString().trim();
                    int tunjangan, total;
                    int gaji = 0;
                    binding.hasilnama.setText(edtNama);
                    if (binding.cbMenikah.isChecked()) {
                        binding.status.setText("Menikah");
                        tunjangan = 100000;
                    } else {
                        binding.status.setText(" Belum Menikah");
                        tunjangan = 0;
                    }

                    if (binding.rbgolongan1.isChecked()) {
                        binding.hasilgol.setText("1");
                        gaji = 2000000;
                    } else if (binding.rbgolongan2.isChecked()) {
                        binding.hasilgol.setText("2");
                        gaji = 4000000;
                    }
                    total  = gaji + tunjangan;
                    binding.totgaji.setText(String.valueOf(total));
                }



            }
        });

        if(savedInstanceState != null){
            String result = savedInstanceState.getString(STATE_RESULT);
                    binding.edtNama.setText(result);
        }
    }

    @Override
    public void onClick(View v) {


    }
}