package com.cscorner.sqliteexpl;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.cscorner.sqliteexpl.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding a;
    String name, loc;

    DBHelpr dbobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
      a = DataBindingUtil.setContentView(this,R.layout.activity_main);

      dbobj = new DBHelpr(this);

      a.button.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              name= a.editTextText.getText().toString();
              loc= a.editTextText2.getText().toString();
              a.textView.setText(name+"\n"+loc);
                dbobj.savedata(name,loc);
              Toast.makeText(MainActivity.this, "saving done!", Toast.LENGTH_SHORT).show();
          }
      });

      a.button2.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
             String lodfromdb = dbobj.getloc(a.editTextText3.getText().toString());

             a.textView2.setText(lodfromdb);

          }
      });

      a.button3.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              dbobj.updateval(
                      a.editTextText4.getText().toString(),
                      a.editTextText5.getText().toString()
              );
          }
      });

    }
}