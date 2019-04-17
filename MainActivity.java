package com.example.a0417test01;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "버튼이 눌러졌습니다.",
                        Toast.LENGTH_SHORT).show();
            }
        });
        final EditText editText = (EditText) findViewById(R.id.search);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    Toast.makeText(getApplicationContext(), editText.getText(),
                            Toast.LENGTH_SHORT).show();
                    handled = true;
                }
                return handled;
            }
        });

        final RatingBar ratingbar = (RatingBar)
                findViewById(R.id.ratingbar);
        ratingbar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingbar, float rating, boolean fromUser)
            {
                Toast.makeText(MainActivity.this,"New Rating: " +
                        rating, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radio_red:
                if(checked)
                    Toast.makeText(getApplicationContext(),((RadioButton) view).getText(),
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_blue:
                if(checked)
                    Toast.makeText(getApplicationContext(),((RadioButton) view).getText(),
                            Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void onCheckboxClicked(View view){
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkbox_meat:
                if(checked)
                    Toast.makeText(getApplicationContext(), "고기 선택",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"고기 선택 해제",
                            Toast.LENGTH_SHORT).show();
                break;
            case R.id.checkbox_cheese:
                if(checked)
                    Toast.makeText(getApplicationContext(), "치즈 선택",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(),"치즈 선택 해제",
                            Toast.LENGTH_SHORT).show();
                break;
        }
    }
    public void onToggleClicked(View view) {
        // is the toggle on?
        boolean on = ((ToggleButton) view).isChecked();

        if(on) {
                Toast.makeText(getApplicationContext(),"Checked",
                        Toast.LENGTH_SHORT).show();
        } else {
                Toast.makeText(getApplicationContext(),"Not checked",
                        Toast.LENGTH_SHORT).show();
        }
    }

}
