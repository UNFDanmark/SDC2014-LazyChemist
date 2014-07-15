package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import dk.unfsdc.Lazy_Chemist.AtomLibrary;

public class ChemistMain extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final Spinner dropdown = (Spinner) findViewById(R.id.dropdown);
        final String[] dropdownItems = { "Atom Liberary" };
        dropdown.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, dropdownItems));
        dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final

    }
}
