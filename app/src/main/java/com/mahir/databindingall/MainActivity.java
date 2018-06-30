package com.mahir.databindingall;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.mahir.databindingall.databinding.ActivityMainBinding;
import com.mahir.databindingall.models.User;

public class MainActivity extends AppCompatActivity {

    private User user;
    private MyClickHandlers myevents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        user = new User();
        user.setUserName("Navin");
        user.setUserPhone("+919033070283");

        binding.setUser(user);

        myevents = new MyClickHandlers(this);
        binding.setHandlers(myevents);

    }


    public class MyClickHandlers {

        Context context;

        public MyClickHandlers(Context context) {
            this.context = context;
        }

        public void onFabClicked(View view) {
            Toast.makeText(getApplicationContext(), "FAB clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onButtonClick(View view) {
            Toast.makeText(getApplicationContext(), "Button clicked!", Toast.LENGTH_SHORT).show();
        }

        public void onButtonClickWithParam(View view, User user) {
            Toast.makeText(getApplicationContext(), "Button clicked! Name: " + user.getUserName(), Toast.LENGTH_SHORT).show();
            startActivity(new Intent(context, RecycleBinding.class));
        }

        public boolean onButtonLongPressed(View view) {
            Toast.makeText(getApplicationContext(), "Button long pressed!", Toast.LENGTH_SHORT).show();
            return false;
        }
    }

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
}
