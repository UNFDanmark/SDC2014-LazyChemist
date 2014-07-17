package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by sdc on 7/16/14.
 */

public class Electronegativity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.electronegativity);
        super.onCreate(savedInstanceState);

        final EditText ENText1 = (EditText) findViewById(R.id.ENText1);
        final EditText ENText2 = (EditText) findViewById(R.id.ENText2);
        final Button calculate = (Button) findViewById(R.id.ENCalculate);
        final TextView ENTextViewSvar = (TextView) findViewById(R.id.ENTextViewSvar);
        final TextView EnTextViewType = (TextView) findViewById(R.id.ENTextViewType);
        ENText1.setHint("1. Atom");
        ENText2.setHint("2. Atom");
        //atomlib
        ListView listView = (ListView) findViewById(R.id.listViewAtomlistview);

        AtomLibrary atomLibrary = new AtomLibrary();
        atomLibrary.read(getAssets());

        final ArrayList<Atom> atomList = atomLibrary.getAtoms();

        AtomAdapter atomAdapter = new AtomAdapter(atomList, getApplicationContext());
        listView.setAdapter(atomAdapter);
        //atomlib end

        ENText1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    ENText1.setText("");
                }
                ENText2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    @Override
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (hasFocus) {
                            ENText2.setText("");
                        }

                        calculate.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                double EN1 = Double.parseDouble(ENText1.getText().toString());
                                double EN2 = Double.parseDouble(ENText2.getText().toString());
                                atomList.contains(EN1);
                                atomList.contains(EN2);

                                String answer;
                                String type;
                                if (EN1 < 0 || EN2 < 0) {
                                    answer = "ERROR: The EN for one or more atoms are unknown";
                                } else if (EN1 > EN2) {
                                    answer = EN1 - EN2 + "";
                                    if (Double.parseDouble(answer) < 0.5) {
                                        type = "Nonpolar covalent";
                                    } else if (Double.parseDouble(answer) < 1.6) {
                                        type = "Polar covalent";
                                    } else {
                                        type = "Ionic";
                                    }
                                    EnTextViewType.setText(" The binding is: " + type);
                                } else {
                                    answer = EN2 - EN1 + "";
                                    if (Double.parseDouble(answer) < 0.5) {
                                        type = "Nonpolar covalent";
                                    } else if (Double.parseDouble(answer) < 1.6) {
                                        type = "Polar covalent";
                                    } else {
                                        type = "Ionic";
                                    }
                                    EnTextViewType.setText(" The binding is: " + type);
                                }

                                ENTextViewSvar.setText(answer + "");


                            }
                        });
                    }
                });
            }
        });
    }
}
//test