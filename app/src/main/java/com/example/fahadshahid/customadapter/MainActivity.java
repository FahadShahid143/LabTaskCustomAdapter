package com.example.fahadshahid.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fahadshahid.customadapter.models.User;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //adapter view
         ListView listview = (ListView) this.findViewById(R.id.list1);

        //date source
        ArrayList<User> arrayList = new ArrayList<>();
        arrayList.add(new User(1, "Fahad", "pass", "bcs02143185", "Fahad Shahid"));

        for (int i=1; i<100; i++){
            arrayList.add(new User(1, "Fahad", "pass", "bcs02143185", "Fahad Shahid"));
        }
        UserAdapter userAdapter = new UserAdapter(this, arrayList);
        listview.setAdapter(userAdapter);

        ListView listView = (ListView) this.findViewById(R.id.list1);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(view.getContext(), "ListView clicked", Toast.LENGTH_SHORT).show();
            }
        });




    }
}
