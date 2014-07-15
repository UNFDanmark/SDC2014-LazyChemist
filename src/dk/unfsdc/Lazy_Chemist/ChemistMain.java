package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import dk.unfsdc.Lazy_Chemist.AtomLibrary;

public class ChemistMain extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final EditText searchField = (EditText) findViewById(R.id.searchField);
        final Button search = (Button) findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = searchField.getText().toString();
                if(!input.equals("")) {
                    for(int i = 0; i < AtomLibrary.ATOMS.length; i ++) {
                        if(input.toLowerCase().equals(AtomLibrary.ATOMS[i][0].toLowerCase()) || input.equals(AtomLibrary.ATOMS[i][1]) || input.equals((i + 1) + "")) {
                            System.out.println(AtomLibrary.ATOMS[i][0]);
                            return;
                        }
                    }
                    String[] letters = input.split("");
                    for(int i = 0; i < letters.length; i ++) {
                        if(letters[i] == letters[i].toUpperCase()) {
                            if(letters[i + 1] != letters[i + 1].toLowerCase()) {

                            } else {

                            }
                        }
                    }
                }
            }
        });
    }
}
