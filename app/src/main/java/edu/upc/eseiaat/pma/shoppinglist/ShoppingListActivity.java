package edu.upc.eseiaat.pma.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity {

    private ArrayList<String> itemlist;
    private ArrayAdapter<String> adapter;
    private ListView list;
    private Button btn_add;
    private EditText edit_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        list = (ListView)findViewById(R.id.list);
        btn_add = (Button)findViewById(R.id.btn_add);
        edit_text = (EditText) findViewById(R.id.edit_item);
        itemlist=new ArrayList<>();
        itemlist.add("NIkon");
        itemlist.add("BMW Bk75");
        itemlist.add("iPrusa");
        itemlist.add("Snowboard");

        adapter= new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                itemlist
        );
        list.setAdapter(adapter);
    }
}
