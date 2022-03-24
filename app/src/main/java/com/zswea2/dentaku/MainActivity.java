package com.zswea2.dentaku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isFirstInput = true; // 입력 값이 처음 입력되는가를 체크
    int resultNumber = 0; // 계산된 결과 값을 저장하는 변수
    char operator = '+';  //char 은 문자형 변수

    TextView resultText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultText = findViewById(R.id.result_text);
    }

    public void buttonClick(View view) {


        Button getButton = findViewById(view.getId());

        Log.e("buttonClick" , "buttonClick 시작 : " + getButton.getText().toString() + "버튼이 클릭되었습니다.");
        Log.d("bottonClick" , "resultNumber = " + resultNumber); // 정수형 + 문자열은 문자로 바뀐다

        switch (view.getId()){
            case R.id.all_clear_button:
                if (view.getId() == R.id.all_clear_button) {
                    isFirstInput = true;   //먼저 들어온 숫자가 있는가
                    resultNumber = 0;
                    operator = '+';
                    resultText.setText(String.valueOf(resultNumber));  //valve0f로 string로 바꾸기, 또는 정수 +""(문자열)하면 문자열로 바뀌기 때문에 에러가 안난다.
                    resultText.setTextColor(0xFF716F6F);
                }
                break;

            case R.id.tasu_button:
            case R.id.hiku_button:
            case R.id.division_button:
            case R.id.kakeru_button:
                int lastNum = Integer.parseInt(resultText.getText().toString());
                if(operator == '+'){
                    resultNumber = resultNumber + lastNum;
                }else if(operator == '-'){
                    resultNumber = resultNumber - lastNum;
                }else if(operator == '/'){
                    resultNumber = resultNumber / lastNum;
                }else if(operator == '*'){
                    resultNumber = resultNumber * lastNum;
                }
                operator = getButton.getText().toString().charAt(0);
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                Log.d("bottonClick" , "add resultNumber = " + resultNumber);

                break;
            case R.id.result_button:
                if(operator == '+'){
                    resultNumber = resultNumber + Integer.parseInt(resultText.getText().toString());
                }else if(operator == '-'){
                    resultNumber = resultNumber - Integer.parseInt(resultText.getText().toString());
                }else if(operator == '/'){
                    resultNumber = resultNumber / Integer.parseInt(resultText.getText().toString());
                }else if(operator == '*'){
                    resultNumber = resultNumber * Integer.parseInt(resultText.getText().toString());
                }
                resultText.setText(String.valueOf(resultNumber));
                isFirstInput = true;
                Log.d("bottonClick" , "add resultNumber = " + resultNumber);
                break;


            case R.id.num_0_button:
            case R.id.num_1_button:
            case R.id.num_2_button:
            case R.id.num_3_button:
            case R.id.num_4_button:
            case R.id.num_5_button:
            case R.id.num_6_button:
            case R.id.num_7_button:
            case R.id.num_8_button:
            case R.id.num_9_button:
                if (isFirstInput) {
                    resultText.setTextColor(0xFF000000);
                    resultText.setText(getButton.getText().toString());
                    isFirstInput = false;
                } else {
                    resultText.append(getButton.getText().toString());
                }
                break;


                default: //예외값이 들어왔을떄
//                    Toast.makeText(getApplicationContext(), getButton.getText().toString() + "버튼이 클릭되었습니다.", Toast.LENGTH_LONG).show();
                    Log.e("buttonClick" , "default : " + getButton.getText().toString() + "버튼이 클릭되었습니다.");
                    break;
        }


//        if (view.getId() == R.id.all_clear_button) {
//            isFirstInput = true;
//            resultNumber = 0;
//            operator = '+';
//            resultText.setText(String.valueOf(resultNumber));  //valve0f로 string로 바꾸기, 또는 정수 +""(문자열)하면 문자열로 바뀌기 때문에 에러가 안난다.
//            resultText.setTextColor(0xFF716F6F);
//        }
//
//
//
//        if (view.getId() == R.id.num_0_button
//                || view.getId() == R.id.num_1_button
//                || view.getId() == R.id.num_2_button
//                || view.getId() == R.id.num_3_button
//                || view.getId() == R.id.num_4_button
//                || view.getId() == R.id.num_5_button
//                || view.getId() == R.id.num_6_button
//                || view.getId() == R.id.num_7_button
//                || view.getId() == R.id.num_8_button
//                || view.getId() == R.id.num_9_button) {
//            if (isFirstInput) {
//                resultText.setTextColor(0xFF000000);
//                resultText.setText(getButton.getText().toString());
//                isFirstInput = false;
//            } else {
//                resultText.append(getButton.getText().toString());
//            }
//        }

    }
}