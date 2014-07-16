package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import dk.unfsdc.Lazy_Chemist.AtomLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChemistMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        BufferedReader reader = null;
        try {
            InputStream is = getAssets().open("atoms.csv");
            reader = new BufferedReader(new InputStreamReader(is));
            ArrayList<Atom> atomList = new ArrayList<Atom>();
            String s = null;
            while (reader.ready()) {
                s = reader.readLine();
                //number
                String[] atomlib = s.split(",");
                int number = Integer.parseInt(atomlib[0]);
                System.out.print(atomlib[0]);
                //symbol
                String symbol = atomlib[1];
                System.out.print(atomlib[1]);
                //name1
                String name1 = atomlib[2];
                System.out.print(atomlib[2]);
                //weight
                double weight = Double.parseDouble(atomlib[3]);
                System.out.print(atomlib[3]);
                //electroNegativity
                double electroNegativity = Double.parseDouble(atomlib[6]);
                System.out.print(atomlib[6]);
                //category
                String category = atomlib[14];
                System.out.print(atomlib[14]);
                //group
                String group = atomlib[19];
                System.out.print(atomlib[19]);
                //year
                int year = Integer.parseInt(atomlib[20]);
                System.out.print(atomlib[20]);

                Atom atom = new Atom(number,symbol,name1,weight,electroNegativity,category,group,year);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

//test