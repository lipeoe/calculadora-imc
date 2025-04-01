package br.fecap.ads.calculadoraimc.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.fecap.ads.calculadoraimc.R;

public class MainActivity extends AppCompatActivity {
    private Button mainAction;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        mainAction = findViewById(R.id.btnMainActivity);
        mainAction.setOnClickListener(view -> {
            goToCalc();
        });

    }

    private void goToCalc(){
        Intent intent = new Intent(this, CalculoIMCActivity.class);
        startActivity(intent);
        finish();
    }

}
