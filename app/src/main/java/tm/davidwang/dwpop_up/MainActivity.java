package tm.davidwang.dwpop_up;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DWPOPView line1;
    private ListView list;
    private LinearLayout addview;
    private MainListAdapter adapter;
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findID();
        inData();
        line1.setAdapterView(addview);
    }

    private void findID(){
        line1 = (DWPOPView)findViewById(R.id.line1);
        line1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                line1.showanimation();
            }
        });
        addview = (LinearLayout)View.inflate(MainActivity.this,
                R.layout.view_list, null);
        list = (ListView)addview.findViewById(R.id.list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"点击"+position,0).show();
            }
        });
    }

    private void inData(){
        data = new ArrayList<String>();
        for (int i = 0 ; i < 5; i ++){
            data.add("内容"+(i+1));
        }
        adapter = new MainListAdapter(this,data);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void Onclick_0(View view){
        if (line1.getVisibility() == View.GONE){
            line1.showanimation();
        }
    }

    public void Onclick_1(View view){
        if (line1.getVisibility() == View.GONE){
            line1.showanimation();
        }
    }

    public void Onclick_2(View view){
        if (line1.getVisibility() == View.GONE){
            line1.showanimation();
        }
    }

}


