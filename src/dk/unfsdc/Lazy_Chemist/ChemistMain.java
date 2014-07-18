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

        Button searchs = (Button) findViewById(R.id.buttons);
        Button molar = (Button) findViewById(R.id.molar);
        Button ENs = (Button) findViewById(R.id.ENs);

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
    }
}

