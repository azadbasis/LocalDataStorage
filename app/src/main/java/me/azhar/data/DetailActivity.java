package me.azhar.data;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import me.azhar.data.adapter.DataItemAdapter;
import me.azhar.data.model.DataItem;
import me.azhar.data.sample.SampleDataProvider;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String itemId=getIntent().getExtras().getString(DataItemAdapter.ITEM_ID_KEY);
        DataItem item=SampleDataProvider.dataItemMap.get(itemId);
        Toast.makeText(this, "item name "+item.getItemName(), Toast.LENGTH_SHORT).show();

    }
}
