package edu.upc.eseiaat.pma.shoppinglist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoppingListActivity extends AppCompatActivity {

    private ArrayList<String> itemlist;
    private ArrayAdapter<String> adapter;
    private ListView list;
    private Button btn_add;
    private EditText edit_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        list = (ListView)findViewById(R.id.list);
        btn_add = (Button)findViewById(R.id.btn_add);
        edit_item = (EditText) findViewById(R.id.edit_item);
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

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem();
            }
        });

        edit_item.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {\
                addItem();
                return true;
            }
        });




        list.setAdapter(adapter);
    }

    private void addItem() {
        String item_text=edit_item.getText().toString();
        if (!item_text.isEmpty()){
        itemlist.add(item_text);
        adapter.notifyDataSetChanged();
        edit_item.setText("");
        }
    }
}
