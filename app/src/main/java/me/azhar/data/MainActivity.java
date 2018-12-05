package me.azhar.data;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import me.azhar.data.model.DataItem;
import me.azhar.data.sample.SampleDataProvider;


public class MainActivity extends AppCompatActivity {

    List<DataItem> dataItemList = SampleDataProvider.dataItemList;
    List<String> stringList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (DataItem item : dataItemList)
            stringList.add(item.getItemName());
        Collections.sort(stringList);


        ListView listView=(ListView)findViewById(android.R.id.list);
        ArrayAdapter<String> stringArrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stringList);
        listView.setAdapter(stringArrayAdapter);


    }
}
