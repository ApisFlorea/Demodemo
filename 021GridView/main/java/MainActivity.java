
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener, AdapterView.OnItemClickListener {
    private ImageView mImageView;
    private int[] resIds = new int[]
            {
                    R.drawable.item1,R.drawable.item2,R.drawable.item3,R.drawable.item4,
                    R.drawable.item5,R.drawable.item6,R.drawable.item7,R.drawable.item8,
                    R.drawable.item9,R.drawable.item10,R.drawable.item11,R.drawable.item12,
                    R.drawable.item13,R.drawable.item14,R.drawable.item15,R.drawable.item16
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView)findViewById(R.id.gridView);

        List<Map<String, Object>> cells = new ArrayList<Map<String, Object>>();
        for(int i = 0; i < resIds.length;i++)
        {
            Map<String, Object> cell = new HashMap<>();
            cell.put("hello", resIds[i]);
            cells.add(cell);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,cells,R.layout.cell,
                new String[]{"hello"}, new int[]{R.id.imageview});
        gridView.setAdapter(simpleAdapter);

        mImageView =(ImageView)findViewById(R.id.imageview);
        gridView.setOnItemClickListener(this);
        gridView.setOnItemSelectedListener(this);

        mImageView.setImageResource(resIds[0]);

    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        mImageView.setImageResource(resIds[position]);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        mImageView.setImageResource(resIds[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
