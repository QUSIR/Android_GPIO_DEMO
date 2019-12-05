package com.gpio.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Used to load the 'native-lib' library on application startup.
    private TextView metextview;
    private Button mybutton3;
    private GpioJni megpio=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        //TextView tv = findViewById(R.id.sample_text);
        //tv.setText(stringFromJNI());

        setContentView(R.layout.activity_main);
        metextview=(TextView)findViewById(R.id.textView);

        mybutton3=(Button)findViewById(R.id.SetGpio);
        mybutton3.setOnClickListener(this);
        megpio=new GpioJni();


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
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public void onClick(View v) {
        switch(v.getId()){

            case R.id.SetGpio:
                metextview.setText("SetGpio is ok");
                megpio.SetGpio();
                break;
            default:
                break;
        }

    }
}
