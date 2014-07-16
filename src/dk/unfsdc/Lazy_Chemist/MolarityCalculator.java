package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.*;

public class MolarityCalculator extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        final EditText mol = (EditText) findViewById(R.id.editText);
        final EditText mass = (EditText) findViewById(R.id.editText2);
        final EditText volume = (EditText) findViewById(R.id.editText3);
        final EditText molarMass = (EditText) findViewById(R.id.editText4);
        final EditText molarity = (EditText) findViewById(R.id.editText5)
        mol.setHint("Mol");
        mass.setHint("Mass");
        volume.setHint("Volume");



        final Button calculate = (Button) findViewById(R.id.button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] input = { mol.getText().toString(), molarity.getText().toString(), volume.getText().toString() };
                Boolean[] inputIsEmpty = { input[0].isEmpty(), input[1].isEmpty(), input[2].isEmpty() };

                /*
                double weight = 0;
                String[] letters = input[0].split("");
                if(!letters[0].matches(".*\\d.*") && !inputIsEmpty[0]) {
                    List<String> atoms = new ArrayList<String>();
                    for(int i = 0; i < letters.length; i ++) {
                        if(letters[i].equals(letters[i].toUpperCase()) && !letters[i].matches(".*\\d.*")) {
                            if(i + 1 <= letters.length && letters[i + 1].equals(letters[i + 1].toLowerCase() && )) {
                                atoms.add(letters[i] + letters[i + 1]);
                            } else {
                                atoms.add(letters[i]);
                            }
                        } else if(letters[i].matches(".*\\d.*")) {
                            atoms.ad
                        }
                    }
                    if(!atoms.isEmpty()) {
                        for(int i = 0; i < atoms.size(); i ++) {
                            for(int j = 0; j < AtomLibrary.ATOMS.length; j ++) {
                                if(atoms.get(i).equals(AtomLibrary.ATOMS[i][1])) {
                                    weight += Double.parseDouble(AtomLibrary.ATOMS[i][2]);
                                } else {
                                    return; // ABORT (FAILED)
                                }
                            }
                        }
                    } else {
                        System.out.println("Can't recognize ");
                    }
                }
                String[] values = { input[0].replaceAll("[^0-9]", ""), input[1].replaceAll("[^0-9]", ""), input[2].replaceAll("[^0-9]", "") };
                String[] units = { input[0].replaceAll("[^A-Ba-b]", ""), input[1].replaceAll("[^A-Ba-b]", ""), input[2].replaceAll("[^A-Ba-b]", "") };
                Boolean[] inputIsEmpty = { values[0].isEmpty(), values[1].isEmpty(), values[2].isEmpty() };
                Boolean[] unitIsEmpty = { units[0].isEmpty(), units[1].isEmpty(), units[2].isEmpty() };
                if (!inputIsEmpty[0] && !inputIsEmpty[1] && inputIsEmpty[2]) {
                    if (unitIsEmpty[0]) {
                        System.out.println(units[0]);
                        mol.setText(input[0] + " m");
                    }
                    if (unitIsEmpty[1]) {
                        molarity.setText(input[1] + " M");
                    }
                    volume.setText(Double.parseDouble(values[0]) / Double.parseDouble(values[1]) + " l");
                } else if (!inputIsEmpty[0] && inputIsEmpty[1] && !inputIsEmpty[2]) {
                    if (unitIsEmpty[0]) {
                        mol.setText(input[0] + " m");
                    }
                    if (unitIsEmpty[2]) {
                        volume.setText(input[2] + " l");
                    }
                    molarity.setText(Double.parseDouble(values[0]) / Double.parseDouble(values[2]) + "");
                } else if (inputIsEmpty[0] && !inputIsEmpty[1] && !inputIsEmpty[2]) {
                    if (unitIsEmpty[1]) {
                        molarity.setText(input[1] + " M");
                    }
                    if (unitIsEmpty[2]) {
                        volume.setText(input[2] + " l");
                    }
                    mol.setText(Double.parseDouble(values[1]) * Double.parseDouble(values[2]) + "");
                }

                if(input[0].contains(",")) {
                    // input[0] = input[0].split(",");
                }*/
            }
        });
    }
}
