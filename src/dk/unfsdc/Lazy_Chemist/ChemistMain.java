package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import org.w3c.dom.Text;

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
        final TextView navn = (TextView) findViewById(R.id.Navn);
        final TextView forkortelse = (TextView) findViewById(R.id.Forkortelse);
        final TextView vaegt = (TextView) findViewById(R.id.Vaegt);
        final TextView elektronegativitet = (TextView) findViewById(R.id.Elektronegativitet);
        final TextView kategori = (TextView) findViewById(R.id.Kategori);

        molar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MolarityCalculator.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });

        ENs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Electronegativity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(i);
            }
        });

        searchs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = search.getText().toString();
                if(!input.isEmpty()) {
                    for(int i = 0; i < AtomLibrary.ATOMS.length; i ++) {
                        if (input.toLowerCase().equals(AtomLibrary.ATOMS[i][0].toLowerCase())) {
                            navn.setText(AtomLibrary.ATOMS[i][0]);
                            forkortelse.setText(AtomLibrary.ATOMS[i][1]);
                            vaegt.setText(AtomLibrary.ATOMS[i][2]);
                            elektronegativitet.setText(AtomLibrary.ATOMS[i][3]);
                            kategori.setText(AtomLibrary.ATOMS[i][4]);
                        } else if (AtomLibrary.ATOMS[i][1].equals(input)) {
                            navn.setText(AtomLibrary.ATOMS[i][0]);
                            forkortelse.setText(AtomLibrary.ATOMS[i][1]);
                            vaegt.setText(AtomLibrary.ATOMS[i][2]);
                            elektronegativitet.setText(AtomLibrary.ATOMS[i][3]);
                            kategori.setText(AtomLibrary.ATOMS[i][4]);
                        }
                    }
                }
            }
        });
    }
}

