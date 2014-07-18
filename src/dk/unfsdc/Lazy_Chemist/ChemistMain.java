package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class ChemistMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AtomLibrary atomLibrary = new AtomLibrary();
        atomLibrary.read(getAssets());

        ArrayList<Atom> atomList = atomLibrary.getAtoms();

        AtomAdapter atomAdapter = new AtomAdapter(atomList, getApplicationContext());

        Button search = (Button) findViewById(R.id.button);
        Button molarity = (Button) findViewById(R.id.molarity);
        Button EN = (Button) findViewById(R.id.EN);

        molarity.setOnClickListener(new View.OnClickListener() {

        });

    }
}

