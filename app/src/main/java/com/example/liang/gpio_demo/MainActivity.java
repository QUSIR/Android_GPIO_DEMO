package com.example.liang.gpio_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener {

    private TextView metextview;
    private Button mybutton1;
    private Button mybutton2;

    private Button mybutton3;
    private Gpio megpio=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        metextview=(TextView)findViewById(R.id.textView);



        mybutton3=(Button)findViewById(R.id.SetGpio);
        mybutton3.setOnClickListener(this);
        megpio=new Gpio();


            Process process = null;
            try {

                process = Runtime.getRuntime().exec(
                        "chmod 777 /sys/class/gpio_sw/PI7/data");
                process.waitFor();
                String command = "chmod 777 /sys/class/gpio_sw/PI7/data";
                Runtime runtime = Runtime.getRuntime();
                process = runtime.exec(command);
                process.waitFor();
            } catch (Exception e) {

            }


     /*   Process p = Runtime.getRuntime().exec("chmod 777 /sys/class/gpio_sw/PI7/data");
        int status = p.waitFor();
        if (status == 0) {
            //chmod succeed
        } else {
            //chmod failed
        }  */
/*
        try {
            String command = "chmod 777 /sys/class/gpio_sw/PI8/data";
            Runtime runtime = Runtime.getRuntime();

            Process proc = runtime.exec(command);
        } catch (IOException e) {

            e.printStackTrace();
        }
*/
       // Process process = Runtime.getRuntime().exec("su");

    }
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.SetGpio:
                metextview.setText("SetGpio is ok");
                megpio.Set_GPIO();
                break;
            default:
                break;
        }

    }
}
