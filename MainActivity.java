package com.dicoding.javafundamental.f55122060;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtwidth, edtheight, edtlength;
    private Button btncalculate;
    private TextView tvresult;
    private static final String STATE_RESULT = "state_result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtwidth = findViewById(R.id.edt_width);
        edtheight = findViewById(R.id.edt_height);
        edtlength = findViewById(R.id.edt_length);
        btncalculate = findViewById(R.id.btn_calculate);
        tvresult = findViewById(R.id.tv_result);
        btncalculate.setOnClickListener(this);
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvresult.setText(result);
        }
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outstate) {
        super.onSaveInstanceState(outstate);
        outstate.putString(STATE_RESULT, tvresult.getText().toString());
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String inputlength = edtlength.getText().toString().trim();
            String inputwidth = edtwidth.getText().toString().trim();
            String inputheight = edtheight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(inputlength)) {
                isEmptyFields = true;
                edtlength.setError("Field ini tidak kosong");
            }
            if (TextUtils.isEmpty(inputwidth)) {
                isEmptyFields = true;
                edtwidth.setError("Field ini tidak kosong");
            }
            if (TextUtils.isEmpty(inputheight)) {
                isEmptyFields = true;
                edtheight.setError("Field ini tidak kosong");
            }
            if (!isEmptyFields) {
            double volume = Double.parseDouble(inputlength) *
                    Double.parseDouble(inputwidth) * Double.parseDouble(inputheight);
            tvresult.setText(String.valueOf(volume));
        }
    }
}
}