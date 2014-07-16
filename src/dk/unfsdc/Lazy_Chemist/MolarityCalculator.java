package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MolarityCalculator extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        final EditText mol = (EditText) findViewById(R.id.editText);
        final EditText molarity = (EditText) findViewById(R.id.editText2);
        final EditText volume = (EditText) findViewById(R.id.editText3);
        mol.setHint("Mol ( or Mass, Formula )");
        molarity.setHint("Molarity");
        volume.setHint("Volume");

        final Button calculate = (Button) findViewById(R.id.button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] input = { mol.getText().toString(), molarity.getText().toString(), volume.getText().toString() };
                String[] values = { input[0].replaceAll("[^0-9]", ""), input[1].replaceAll("[^0-9]", ""), input[2].replaceAll("[^0-9]", "") };
                String[] units = { input[0].replaceAll("[^A-Ba-b/]", ""), input[1].replaceAll("[^A-Ba-b/]", ""), input[2].replaceAll("[^A-Ba-b/]", "") };
                Boolean[] inputIsEmpty = { values[0].isEmpty(), values[1].isEmpty(), values[2].isEmpty() };
                Boolean[] unitIsEmpty = { units[0].isEmpty(), units[1].isEmpty(), units[2].isEmpty() };
                if (!inputIsEmpty[0] && !inputIsEmpty[1] && inputIsEmpty[2]) {
                    if (unitIsEmpty[0]) {
                        mol.setText(input[0] + " m");
                    }
                    if (unitIsEmpty[1]) {
                        molarity.setText(input[1] + " M");
                    }
                    volume.setText(Double.parseDouble(values[0]) / Double.parseDouble(values[1]) + " l");
                } else if (!inputIsEmpty[0] && inputIsEmpty[1] && !inputIsEmpty[2]) {
                    molarity.setText(Double.parseDouble(values[0]) / Double.parseDouble(values[2]) + "");
                } else if (inputIsEmpty[0] && !inputIsEmpty[1] && !inputIsEmpty[2]) {
                    mol.setText(Double.parseDouble(values[1]) * Double.parseDouble(values[2]) + "");
                }

                if(input[0].contains(",")) {
                    // input[0] = input[0].split(",");
                }
            }
        });
    }
}
