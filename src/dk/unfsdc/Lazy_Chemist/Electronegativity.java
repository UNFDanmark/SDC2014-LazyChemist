package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sdc on 7/16/14.
 */

public class Electronegativity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.electronegativity);
        super.onCreate(savedInstanceState);

        final Button search = (Button) findViewById(R.id.search);
        final Button molarity = (Button) findViewById(R.id.molarity);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ChemistMain.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });

        molarity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MolarityCalculator.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });

        final EditText ENText1 = (EditText) findViewById(R.id.ENText1);
        final EditText ENText2 = (EditText) findViewById(R.id.ENText2);
        final Button calculate = (Button) findViewById(R.id.ENCalculate);
        final TextView ENTextViewSvar = (TextView) findViewById(R.id.ENTextViewSvar);
        final TextView EnTextViewType = (TextView) findViewById(R.id.ENTextViewType);
        ENText1.setHint("1. Atom");
        ENText2.setHint("2. Atom");
        //atomlib

        AtomLibrary atomLibrary = new AtomLibrary();
        atomLibrary.read(getAssets());

        final ArrayList<Atom> atomList = atomLibrary.getAtoms();

        AtomAdapter atomAdapter = new AtomAdapter(atomList, getApplicationContext());
        // listView.setAdapter(atomAdapter);
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
                                String A1 = "";
                                String A2 = "";
                                double B1 = 0;
                                double B2 = 0;
                                try{
                                    B1 = Double.parseDouble(ENText1.getText().toString());

                                }catch (Exception e){
                                    A1 = ENText1.getText().toString();
                                }


                                try{
                                    B2 = Double.parseDouble(ENText2.getText().toString());

                                }catch (Exception e){
                                    A2 = ENText2.getText().toString();
                                }

                                Atom atom1 = null;
                                Atom atom2 = null;
                                //if(atomList.contains(EN1) || atomList.contains(EN2)) {}
                                for(Atom a : atomList){
                                    if(a.symbol.toString().replace(" ", "").equalsIgnoreCase(A1)){
                                        atom1 = a;
                                    }
                                    if(a.symbol.toString().replace(" ", "").equalsIgnoreCase(A2)){
                                        atom2 = a;
                                    }
                                }
                                System.out.println(atom1 + " og " +
                                        "" + atom2);
                                double EN1 = 0, EN2 = 0;
                                //atom.getElectroNegativity();
                                if(atom1 != null){
                                    EN1 = atom1.getElectroNegativity();
                                }
                                else {
                                    EN1 = B1;
                                }
                                if(atom2 != null){
                                    EN2 = atom2.getElectroNegativity();
                                } else {
                                    EN2 = B2;
                                }



                                String answer;
                                String type;
                                if (EN1 < 0 || EN2 < 0) {
                                    answer = "ERROR: The EN for one or more atoms are unknown";
                                } else if (EN1 > EN2) {
                                    answer = (double)(EN1 - EN2) + "";
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