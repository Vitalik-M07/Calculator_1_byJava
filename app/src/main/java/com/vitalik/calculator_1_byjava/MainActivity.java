package com.vitalik.calculator_1_byjava;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private  MediaPlayer mMediaPlayer;
    String fgh;
    String oldNumber="";
    String number="";







    String tyu;
    String newNumber="";
    Double result=0.0;



    String operator="";
    EditText editText;
    boolean isNew  = true;
    boolean isMinus = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        mMediaPlayer = MediaPlayer.create(this, R.raw.zvuk);
    }
    public void ClickNumber(View view) {
        mMediaPlayer.start();
    final int KEYBOARD_TAP;
    if(isNew){
            editText.setText("");
            isNew=false;
        }

        number = editText.getText().toString();
        switch (view.getId()){

            case R.id.bu1:if(zeroIsFirst(number)&& number.length() == 1){
                number = number.substring(1);
                //delFirstZero(number);
            } number= number+"1";break;

            case R.id.bu2:if(zeroIsFirst(number)&& number.length() == 1){
                number = number.substring(1);
            } number= number+"2";break;

            case R.id.bu3:if(zeroIsFirst(number)&& number.length() == 1){
                number = number.substring(1);
            } number= number+"3";break;

            case R.id.bu4: if(zeroIsFirst(number)&& number.length() == 1){
                number = number.substring(1);
            }number= number+"4";break;

            case R.id.bu5:if(zeroIsFirst(number)&& number.length() == 1){
                number = number.substring(1);
            } number= number+"5";break;

            case R.id.bu6:if(zeroIsFirst(number)&& number.length() == 1){
                number = number.substring(1);
            } number= number+"6";break;

            case R.id.bu7:if(zeroIsFirst(number)&& number.length() == 1){
                number = number.substring(1);
            } number= number+"7";break;

                case R.id.bu8:
                if(zeroIsFirst(number)&& number.length() == 1){
                    number = number.substring(1);
                }number= number+"8";break;

            case R.id.bu9:
                if(zeroIsFirst(number)&& number.length() == 1){
                    number = number.substring(1);
                }

                number= number+"9"; break;

            case R.id.bu0:
                if(zeroIsFirst(number)&& number.length() == 1){
                number="0";
            }else{
                number= number+"0";
            }break;

                case R.id.buPlusMinus:
                if( numberIsZero(number))
                {number= "0";}else{
                if(minusIsPresent(number)){
                    //number="-"+number;
                    number = number.substring(1);
                }else{
                    number="-"+number;
                }}

            break;


            case R.id.buDot:


                if(dotIsPresent(number)){

                }else
                if(zeroIsFirst(number))
                {number="0.";}
                else{
                    number= number+"."; break;
                }



            break;
        }
        editText.setText(number);
    }
    private boolean zeroIsFirst(String number) {

        if(number.equals("")   ){
            return true;
        }
        if(number.charAt(0)=='0'){
            return true;
        }
        else {
            return false;
        }


    }
    private boolean numberIsZero(String number) {
        if(number.equals("0") || number.equals("")  ){
            return true;
        }else{
            return false;
        }
    }
    public void operation(View view){
        mMediaPlayer.start();
        isNew = true;
        oldNumber = editText.getText().toString();

        switch (view.getId()){
            case R.id.buPlus: operator="+" ; break;
            case R.id.buMinus: operator="-"; break;
            case R.id.buDivide: operator="/"; break;
            case R.id.buMultiply:operator="*" ; break;
            //case R.id.buEqual:operator="=";break;

        }



    }
    public void clickEqual(View view) {
        mMediaPlayer.start();
         newNumber = editText.getText().toString();
        result= 0.0;
        //if(Double.parseDouble(newNumber) ==0 && operator=="/" /*number.equals("")*/|| newNumber.equals("") && operator=="/"){
        if((Double.parseDouble(newNumber) ==0 ||newNumber.equals("") )&& operator=="/"){
            Toast.makeText(MainActivity.this, R.string.toast_massage,Toast.LENGTH_SHORT).show();
        }
       /*if (number==""&&newNumber==""||oldNumber==""||operator==""){

           editText.setText(result+"");
        }*/
       /* if (operator ==""){
            editText.setText(number);
        }
*/
        else {


            switch (operator) {
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                    break;
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                    break;
                case "/":
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                    break;
                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                    break;
                case "=":
                    result = 0.0;
                    break;
            }

        }
        editText.setText(result+"");


    }
    public void asClick(View view) {
        mMediaPlayer.start();
        editText.setText("0");
         oldNumber="";
         number="";
         newNumber="";
         result=0.0;

         operator="";




        isNew = true;
    }
    public boolean dotIsPresent(String number){

        if(number.indexOf("." )==-1){
            return false;
        }else
            return true;




    }
    private boolean PlusMinusPresent(){
        if(number.indexOf("." )==-1){
            return false;
        }else
            return true;

    }





    private boolean minusIsPresent(String number) {
        if(number.charAt(0)=='-'){
            return true;
        }else
            return false;
    }
    public void clickPercent(View view) {
        mMediaPlayer.start();
        if(operator == ""){
            String  number = editText.getText().toString();
            double temp = Double.parseDouble(number)/100;
            number = temp+"";
            editText.setText(number);


        }
        else{
            Double result= 0.0;
            String newNumber = editText.getText().toString();
            switch (operator){
                case "+": result= Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber)*Double.parseDouble(newNumber)/100 ; break;
                case "-": result= Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber)*Double.parseDouble(newNumber)/100 ; break;
                case "/": result=Double.parseDouble(oldNumber) / Double.parseDouble(newNumber)*100 ; break;
                case "*": result=Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) /100; break;
            }
               editText.setText(result+"");
            operator = "";


        }


    }
}