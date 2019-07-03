package ovh.garrigues.android.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Long> numberList = new ArrayList<>();
    private ArrayList<Operator> operandList = new ArrayList<>();
    private TextView operationView ;
    private TextView resultView ;
    private long actualNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         operationView = findViewById(R.id.OperationScreen);
         resultView = findViewById(R.id.resultScreen);
    }

    public void addoperand(View view) {
        Operator op;
        switch (view.getId())
        {
            case R.id.ButtonPlus: op = Operator.PLUS ;break;
            case R.id.ButtonDivide:op = Operator.DIVIDE ; break;
            case R.id.ButtonMinud:op = Operator.MINUS ; break;
            case R.id.ButtonMult:op = Operator.MULT ; break;
            default: op=null;
        }
        operandList.add(op);
        numberList.add(actualNumber);
        affScreen(op,actualNumber);
        actualNumber=0;
        resultView.setText(String.valueOf(actualNumber));

    }

    public void compute(View view) {

    }

    public void addnumber(View view) {
        Long num= Long.parseLong(((Button)view).getText().toString());
       actualNumber*=10;
       actualNumber+=num;
       resultView.setText(""+actualNumber);
    }
    private void affScreen(Operator operator,long number)
    {
        String str =operationView.getText().toString();
        String op = "" ;
        switch (operator)
        {
            case MULT:op="*";break;
            case MINUS:op="-";break;
            case PLUS:op="+";break;
            case DIVIDE:op="/";break;
        }
        if (numberList.size() == 1)
            operationView.setText(""+number+" "+op);
        else
            operationView.setText( str+" "+number+" "+op);

    }
    private enum Operator
    {
        PLUS,
        MINUS,
        MULT,
        DIVIDE

    }
}
