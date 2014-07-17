package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.*;
import dk.unfsdc.Lazy_Chemist.AtomLibrary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ChemistMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ListView listView = (ListView) findViewById(R.id.listViewAtomlistview);

        AtomLibrary atomLibrary = new AtomLibrary();
        atomLibrary.read(getAssets());

        ArrayList<Atom> atomList = atomLibrary.getAtoms();

        AtomAdapter atomAdapter = new AtomAdapter(atomList, getApplicationContext());
        listView.setAdapter(atomAdapter);

    }
}

