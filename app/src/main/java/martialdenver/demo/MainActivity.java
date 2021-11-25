package martialdenver.demo;

import android.os.Bundle;
import android.renderscript.Script;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.telephony.mbms.MbmsErrors;
import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import martialdenver.demo.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.transform.Result;

public class MainActivity extends AppCompatActivity {
    TextView workingsTV;
    TextView resultsTV;
    private String workings;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTextviews();
    }

    private void initTextviews() {
        workingsTV = (TextView) findViewById(R.id.workingstextView);
        resultsTV = (TextView) findViewById(R.id.resultTextView);
    }

    private void setWorkings(String givenValue) {
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void clearOnClick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
    }

    public void bracketsOnClick(View view) {
    }

    public void powerofOnClick(View view) {
        setWorkings("^");

    }

    public void equalsOnClick(View view) {
        Double result = null;
        Object shortName;
        Script engine = new ScriptEngineManager().getEngineByName(shortName:"rhino");
        try {
            result = (double)engine.eval(workings);
        } catch (Exception e) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if (result != null)
            resultsTV.setText(String.valueOf(result.doubleValue()));
    }

    public void decimalOnClick(View view) {
        setWorkings(".");
    }

    public void zeroOnClick(View view) {
        setWorkings("0");
    }


    public void plusOnClick(View view) {
        setWorkings("+");
    }

    public void divisionOnClick(View view) {
        setWorkings("/");
    }

    public void minusOnClick(View view) {
        setWorkings("-");
    }

    public void timesOnClick(View view) {
        setWorkings("*");
    }

    public void nineOnClick(View view) {
        setWorkings("9");
    }

    public void heightOnClick(View view) {
        setWorkings("8");
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
    }

    public void sixOnClick(View view) {
        setWorkings("6");
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
    }

    public void fourOnClick(View view) {
        setWorkings("4");
    }

    public void threeOnClick(View view) {
        setWorkings("3");
    }

    public void twoOnClick(View view) {
        setWorkings("2");
    }

    public void oneOnClick(View view) {
        setWorkings("1");
    }
}







































    