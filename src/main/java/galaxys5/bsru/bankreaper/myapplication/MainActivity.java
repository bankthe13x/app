package galaxys5.bsru.bankreaper.myapplication;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    //explicit
    private TextView txtQuestion;
    private ImageView imvIshihara;
    private RadioGroup ragChoice;
    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private Button btnAnswer;
    private int intRadio, intIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bindwidget
        bindWidget();
        //buttoncontroler
        buttonControler();

        radioButtonController();


    }//on create

    private void radioButtonController() {

        ragChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                //sound effect
                MediaPlayer soundRadio = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_shut);
                soundRadio.start();
                //setup
                switch (checkedId) {
                    case R.id.radioButton:
                        intRadio = 1;
                        break;
                    case R.id.radioButton2:
                        intRadio = 2;
                        break;
                    case R.id.radioButton3:
                        intRadio = 3;
                        break;
                    case R.id.radioButton4:
                        intRadio = 4;
                        break;
                }//switch

            }//event
        });


    }//radio button

    private void buttonControler() {
        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //sound effect
                MediaPlayer soundButton = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_long);
                soundButton.start();
                //check zero
                checkZero();

            }//event
        });


    }//buttoncontroler

    private void checkZero() {
        if (intRadio == 0) {
            MyAlertDialog objMyalert = new MyAlertDialog();
            objMyalert.answer(MainActivity.this);

        } else {

            checkTime();


        }
    }//check zero

    private void checkTime() {
        if (intIndex == 9) {
            Intent objIntent = new Intent(MainActivity.this, ShowScoreActivity.class);
           startActivity(objIntent);

        } else {
txtQuestion.setText(Integer.toString(intIndex + 2) + ".What is this ?"  );

            intIndex += 1;

        }

    }//checktime


    private void bindWidget() {
        txtQuestion = (TextView) findViewById(R.id.textView2);
        imvIshihara = (ImageView) findViewById(R.id.imageView);
        ragChoice = (RadioGroup) findViewById(R.id.ragChoice);
        radChoice1 = (RadioButton) findViewById(R.id.radioButton);
        radChoice2 = (RadioButton) findViewById(R.id.radioButton2);
        radChoice3 = (RadioButton) findViewById(R.id.radioButton3);
        radChoice4 = (RadioButton) findViewById(R.id.radioButton4);
        btnAnswer = (Button) findViewById(R.id.button);


    }//bind widget


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}//main class
