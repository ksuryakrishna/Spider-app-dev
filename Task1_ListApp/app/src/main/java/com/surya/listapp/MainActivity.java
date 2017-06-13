package com.surya.listapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button1,button3;
    EditText editText,editText2;
    ListView listView;
    ArrayList<String> list = new ArrayList<String>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button3 = (Button)findViewById(R.id.button3);
        button1.setOnClickListener(this);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, list);
        listView=(ListView)findViewById(R.id.list_options);
        listView.setAdapter(adapter);
        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                TextView item = (TextView) view;
                Intent intent = new Intent(MainActivity.this,NextActivity.class);
                intent.putExtra(NextActivity.EXTRA_MESSAGE,item.getText());
                startActivity(intent);
            }
        };
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText2.getText().toString();
                editText2.setText("");
                int inp_pos = Integer.parseInt(input);
                int size = listView.getAdapter().getCount();
                if (size>inp_pos){
                    list.remove(inp_pos);
                    adapter.notifyDataSetChanged();
                }
                else
                    Toast.makeText(MainActivity.this,"No item present in position "+inp_pos,Toast.LENGTH_LONG).show();

            }
        });

        listView=(ListView)findViewById(R.id.list_options);
        listView.setOnItemClickListener(itemClickListener);


    }
    public void onClick(View v)
    {
        String input = editText.getText().toString();
        editText.setText("");
        if(input.length() > 0)
        {
            adapter.add(input);

        }
    }
}
