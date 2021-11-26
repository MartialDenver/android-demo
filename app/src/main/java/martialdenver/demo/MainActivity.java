package martialdenver.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;


public class MainActivity<ScriptEngine, ScriptException extends Throwable> extends AppCompatActivity {
    TextView workingsTV;
    TextView resultsTV;

    String workings = "";
    String formula = "";
    String tempFormula = "";



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
        leftBracket = true;
    }

    boolean leftBracket = true;

    public void bracketsOnClick(View view) {

        if(leftBracket)
        {
            setWorkings("(");
            leftBracket = false;
        }
        else
        {
            setWorkings(")");
            leftBracket = true;
        }
    }

    public void powerofOnClick(View view) {
        setWorkings("^");

    }

    public void equalsOnClick(View view) throws ScriptException {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        checkForPowerOf();

        Double result = (double) engine;

        if(result != null)
            resultsTV.setText(String.valueOf(result.doubleValue()));

    }

    private void checkForPowerOf()
    {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for(int i = 0; i < workings.length(); i++)
        {
            if (workings.charAt(i) == '^')
                indexOfPowers.add(i);
        }

        formula = workings;
        tempFormula = workings;
        for(Integer index: indexOfPowers)
        {
            changeFormula(index);
        }
        formula = tempFormula;
    }

    private void changeFormula(Integer index)
    {
        String numberLeft = "";
        String numberRight = "";

        for(int i = index + 1; i< workings.length(); i++)
        {
            if(isNumeric(workings.charAt(i)))
                numberRight = numberRight + workings.charAt(i);
            else
                break;
        }

        for(int i = index - 1; i >= 0; i--)
        {
            if(isNumeric(workings.charAt(i)))
                numberLeft = numberLeft + workings.charAt(i);
            else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original,changed);
    }

    private boolean isNumeric(char c)
    {
        if((c <= '9' && c >= '0') || c == '.')
            return true;

        return false;
    }

    public void decimalOnClick(View view) {
        setWorkings(".");
    }

    public void zeroOnClick(View view) { setWorkings("0");
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







































    