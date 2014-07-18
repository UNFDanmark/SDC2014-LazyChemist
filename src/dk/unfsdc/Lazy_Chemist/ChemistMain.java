package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class ChemistMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        AtomLibrary atomLibrary = new AtomLibrary();
        atomLibrary.read(getAssets());

        ArrayList<Atom> atomList = atomLibrary.getAtoms();

        AtomAdapter atomAdapter = new AtomAdapter(atomList, getApplicationContext());

        final Button searchs = (Button) findViewById(R.id.buttons);
        final Button molar = (Button) findViewById(R.id.molar);
        final Button ENs = (Button) findViewById(R.id.ENs);
        final EditText search = (EditText) findViewById(R.id.editText2);

        molar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MolarityCalculator.class);
                startActivity(i);
            }
        });

        ENs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Electronegativity.class);
                startActivity(i);
            }
        });

        searchs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });
    }
}

