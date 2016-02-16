package androidlearning.sweethome.widgetexploration;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButtonLondon;
    private RadioButton radioButtonBeijing;
    private RadioButton radioButtonNewYork;
    private EditText editText;
    private Button button;
    private TextClock textClock;
    private TextView textView;
    private CheckBox checkBoxTransparency;
    private CheckBox checkBoxTint;
    private CheckBox checkBoxReSize;
    private ImageView imageView;
    private Switch switch1;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exploration_layout);

        //Get reference to the widgets - Start
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonLondon = (RadioButton) findViewById(R.id.radioButtonLondon);
        radioButtonBeijing = (RadioButton) findViewById(R.id.radioButtonBeijing);
        radioButtonNewYork = (RadioButton) findViewById(R.id.radioButtonNewYork);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setText(editText.getText());
            }
        });
        textClock = (TextClock) findViewById(R.id.textClock);
        textView = (TextView) findViewById(R.id.textView);

        radioGroup.clearCheck();
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                switch (radioButton.getId()) {
                    case R.id.radioButtonLondon:
                        textClock.setTimeZone("Europe/London");
                        break;
                    case R.id.radioButtonBeijing:
                        textClock.setTimeZone("CST6CDT");
                        break;
                    case R.id.radioButtonNewYork:
                        textClock.setTimeZone("America/New_York");
                        break;
                }
            }
        });

        checkBoxTransparency = (CheckBox) findViewById(R.id.checkBoxTransparency);
        checkBoxTransparency.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBoxTransparency.isChecked()) {
                    imageView.setAlpha(0.1f);
                } else {
                    imageView.setAlpha(1f);
                }
            }
        });
        checkBoxTint = (CheckBox) findViewById(R.id.checkBoxTint);
        checkBoxTint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBoxTint.isChecked()) {
                    imageView.setColorFilter(Color.argb(150, 255, 0, 0));
                } else {
                    imageView.setColorFilter(Color.argb(0, 0, 0, 0));
                }
            }
        });
        checkBoxReSize = (CheckBox) findViewById(R.id.checkBoxReSize);
        checkBoxReSize.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (checkBoxReSize.isChecked()) {
                    imageView.setScaleX(2);
                    imageView.setScaleY(2);
                } else {
                    imageView.setScaleX(1);
                    imageView.setScaleY(1);
                }
            }
        });
        imageView = (ImageView) findViewById(R.id.imageView);
        switch1 = (Switch) findViewById(R.id.switch1);
        webView = (WebView) findViewById(R.id.webView);
        webView.loadUrl("https://www.digitec.ch/en/s1/product/roline-usb-31-kabel-datenrate-10-gbits-a-c-050m-black-usb-cables-5639006");
        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    webView.setVisibility(View.VISIBLE);
                } else {
                    webView.setVisibility(View.INVISIBLE);
                }
            }
        });
        //Get reference to the widgets - End

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
