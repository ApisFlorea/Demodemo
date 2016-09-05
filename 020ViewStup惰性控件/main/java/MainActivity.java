import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick_Button(View view)
    {
        View v = findViewById(R.id.viewstub);
        if(v != null)
        {
           // ((ViewStub)v).inflate();
            v.setVisibility(View.VISIBLE);
        }
        else
        {
            setTitle("ViewStub已经替换为Custom.xml");
        }
    }
    }

}
