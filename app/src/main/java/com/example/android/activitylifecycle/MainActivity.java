package com.example.android.activitylifecycle;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.app.Dialog;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static int ThreadRestart = 0;
    private Button button;
   // private Button close;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("" + ThreadRestart);

        button = (Button) findViewById(R.id.button);
    //    button = (Button) findViewById(R.id.close);

     //   close.setOnClickListener(new View.OnClickListener() {
      //      @Override
      //      public void onClick(View view) {
     //           finish();
     //       }
    //    });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder myAlertBuilder = new AlertDialog.Builder(MainActivity.this);
                myAlertBuilder.setTitle("Simple Dialog");
                myAlertBuilder.setMessage("This is a dialog box that will display an error or message.");
                myAlertBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        Toast.makeText(MainActivity.this, "You clicked yes.", Toast.LENGTH_SHORT).show();

                    }
                });
                myAlertBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                        Toast.makeText(MainActivity.this, "You clicked no.", Toast.LENGTH_SHORT).show();
                    }
                });
                myAlertBuilder.show();
            }
        });


        Log.e("onCreate ------ ", "MainActivity: onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("onStart ------ ","MainActivity: onStart()");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.e("onResume ------ ","MainActivity: onResume()");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.e("onPause ------ ","MainActivity: onPause()");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("onStop ------ ","MainActivity: onStop()");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy ------ ","MainActivity: onDestroy()");
    }


    @Override
    protected void onRestart() {
        ThreadRestart++;
        super.onRestart();
        TextView textView2 =  (TextView) findViewById(R.id.textView2);
        textView2.setText(""+ThreadRestart);
        Log.e("onRestart ------ ","MainActivity: onRestart()");

    }

    public void switchActivity(View view){
        Intent intent = new Intent(MainActivity.this, AnotherActivity.class);
        startActivity(intent);
    }
}
