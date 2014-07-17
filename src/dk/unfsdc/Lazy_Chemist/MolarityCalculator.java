package dk.unfsdc.Lazy_Chemist;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.*;

public class MolarityCalculator extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);

        final EditText mol = (EditText) findViewById(R.id.editText);
        final EditText mass = (EditText) findViewById(R.id.editText2);
        final EditText volume = (EditText) findViewById(R.id.editText3);
        final EditText molarMass = (EditText) findViewById(R.id.editText4);
        final EditText molarity = (EditText) findViewById(R.id.editText5);
        mol.setHint("Amount of Substance");
        mass.setHint("Mass");
        volume.setHint("Volume");
        molarMass.setHint("Molar Mass [Formula]");
        molarity.setHint("Molarity");


        mol.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    mol.setText("");
                }
            }
        });
        mass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    mass.setText("");
                }
            }
        });
        volume.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    volume.setText("");
                }
            }
        });
        molarMass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    molarMass.setText("");
                }
            }
        });
        molarity.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    molarity.setText("");
                }
            }
        });

        final Button calculate = (Button) findViewById(R.id.button);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] input = { mol.getText().toString(), mass.getText().toString(), volume.getText().toString(), molarMass.getText().toString(), molarity.getText().toString() };
                boolean[] inputIsEmpty = { input[0].isEmpty(), input[1].isEmpty(), input[2].isEmpty(), input[3].isEmpty(), input[4].isEmpty() };
                String ERROR_MESSAGE = "Error";
                String UNIT_ERROR_MESSAGE = " ( No such unit as: ";
                int amountOfDecimals = 10000; // + 0 for ekstra decimal.

                double MOL = 0;
                String[] MOL_UNITS = { "mol" };
                double[] MOL_UNIT_VALUES = { 1.0 };
                int MOL_UNIT = 0;
                int MOL_UNIT_PREFIX = 0;
                boolean MOL_ERROR = false;
                String MOL_NONEXISTANT_UNIT = "";
                String[] MOL_SPLIT = input[0].split("");

                if (input[0].matches("[0-9]+")) {
                    MOL = Double.parseDouble(input[0]);
                } else if (input[0].matches("[A-Za-z]+")) {
                    boolean noMatch = true;
                    for (int i = 0; i < MOL_UNITS.length; i ++) {
                        if (input[0].toLowerCase().equals(MOL_UNITS[i])) {
                            MOL_UNIT = i;
                            noMatch = false;
                        }
                        for (int j = 0; j < UnitPrefixLibrary.UNIT_PREFIXES.length; j ++) {
                            if (input[0].toLowerCase().equals(UnitPrefixLibrary.UNIT_PREFIXES[j] + MOL_UNITS[i]) ||
                                    input[0].equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + MOL_UNITS[i])) {
                                MOL_UNIT = i;
                                MOL_UNIT_PREFIX = j;
                                noMatch = false;
                            }
                        }
                    }
                    if (noMatch) {
                        MOL_NONEXISTANT_UNIT = input[0];
                    }
                } else if (!inputIsEmpty[0]) {
                    if (input[0].substring(0, 1).matches("[0-9]")) {
                        String valuePlaceHolder = "";
                        String unitPlaceHolder = "";
                        boolean hasChanged = false;
                        for (int i = 0; i < MOL_SPLIT.length; i ++) {
                            if (MOL_SPLIT[i].matches("[0-9]") || MOL_SPLIT[i].equals(".")) {
                                if (!hasChanged) {
                                    valuePlaceHolder += MOL_SPLIT[i];
                                } else {
                                    MOL_ERROR = true;
                                }
                            } else if (MOL_SPLIT[i].matches("[A-Za-z]")) {
                                unitPlaceHolder += MOL_SPLIT[i];
                                hasChanged = true;
                            }
                        }
                        MOL = Double.parseDouble(valuePlaceHolder);
                        for (int i = 0; i < MOL_UNITS.length; i ++) {
                            if (unitPlaceHolder.toLowerCase().equals(MOL_UNITS[i])) {
                                MOL_UNIT = i;
                            }
                            for (int j = 0; j < UnitPrefixLibrary.UNIT_PREFIXES.length; j ++) {
                                if (unitPlaceHolder.toLowerCase().equals((UnitPrefixLibrary.UNIT_PREFIXES[j] + MOL_UNITS[i])) ||
                                        unitPlaceHolder.equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + MOL_UNITS[i])) {
                                    MOL_UNIT = i;
                                    MOL_UNIT_PREFIX = j;
                                }
                            }
                        }
                    } else {
                        MOL_ERROR = true;
                    }
                }

                double MASS = 0;
                String[] MASS_UNITS = { "grams", "gram", "tonne", "ton" };
                String[] MASS_SHORT_UNITS = { "g", "g", "æ", "t" };
                double[] MASS_UNIT_VALUES = { 1.0, 1.0, 1000.0, 907.185 };
                int MASS_UNIT = 0;
                int MASS_UNIT_PREFIX = 0;
                boolean MASS_ERROR = false;
                String MASS_NONEXISTANT_UNIT = "";
                String[] MASS_SPLIT = input[1].split("");

                if (input[1].matches("[0-9]+")) {
                    MASS = Double.parseDouble(input[1]);
                } else if (input[1].matches("[A-Za-z]+")) {
                    boolean noMatch = true;
                    for (int i = 0; i < MASS_UNITS.length; i ++) {
                        if (input[1].toLowerCase().equals(MASS_UNITS[i])) {
                            MASS_UNIT = i;
                            noMatch = false;
                        }
                        for (int j = 0; j < UnitPrefixLibrary.UNIT_PREFIXES.length; j ++) {
                            if (input[1].toLowerCase().equals(UnitPrefixLibrary.UNIT_PREFIXES[j] + MASS_UNITS[i]) ||
                                    input[1].toLowerCase().equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + MASS_UNITS[i]) ||
                                    input[1].toLowerCase().equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + MASS_SHORT_UNITS[i])) {
                                MASS_UNIT = i;
                                MASS_UNIT_PREFIX = j;
                                noMatch = false;
                            }
                        }
                    }
                    if (noMatch) {
                        MASS_NONEXISTANT_UNIT = input[1];
                    }
                } else if (!inputIsEmpty[1]) {
                    if (input[1].substring(0, 1).matches("[0-9]")) {
                        String valuePlaceHolder = "";
                        String unitPlaceHolder = "";
                        boolean hasChanged = false;
                        for (int i = 0; i < MASS_SPLIT.length; i ++) {
                            if (MASS_SPLIT[i].matches("[0-9]") || MASS_SPLIT[i].equals(".")) {
                                if (!hasChanged) {
                                    valuePlaceHolder += MASS_SPLIT[i];
                                } else {
                                    MASS_ERROR = true;
                                }
                            } else if (MASS_SPLIT[i].matches("[a-zA-Z]")) {
                                unitPlaceHolder += MASS_SPLIT[i];
                                hasChanged = true;
                            }
                        }
                        MASS = Double.parseDouble(valuePlaceHolder);
                        for (int i = 0; i < MASS_UNITS.length; i ++) {
                            if (unitPlaceHolder.toLowerCase().equals(MASS_UNITS[i])) {
                                MASS_UNIT = i;
                            }
                            for (int j = 0; j < UnitPrefixLibrary.UNIT_PREFIXES.length; j ++) {
                                if (unitPlaceHolder.toLowerCase().equals((UnitPrefixLibrary.UNIT_PREFIXES[j] + MASS_UNITS[i])) ||
                                        unitPlaceHolder.toLowerCase().equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + MASS_UNITS[i]) ||
                                        unitPlaceHolder.toLowerCase().equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + MASS_SHORT_UNITS[i])) {
                                    MASS_UNIT = i;
                                    MASS_UNIT_PREFIX = j;
                                }
                            }
                        }
                    } else {
                        MASS_ERROR = true;
                    }
                }

                double VOLUME = 0;
                String[] VOLUME_UNITS = { "liters", "liter" };
                String[] VOLUME_SHORT_UNITS = { "l", "l" };
                double[] VOLUME_UNIT_VALUES = { 1.0, 1.0 };
                int VOLUME_UNIT = 0;
                int VOLUME_UNIT_PREFIX = 0;
                boolean VOLUME_ERROR = false;
                String VOLUME_NONEXISTANT_UNIT = "";
                String[] VOLUME_SPLIT = input[2].split("");

                if (input[2].matches("[0-9]+")) {
                    VOLUME = Double.parseDouble(input[2]);
                } else if (input[2].matches("[a-zA-Z]+")) {
                    boolean noMatch = true;
                    for (int i = 0; i < VOLUME_UNITS.length; i ++) {
                        if (input[2].toLowerCase().equals(VOLUME_UNITS[i])) {
                            VOLUME_UNIT = i;
                            noMatch = false;
                        }
                        for (int j = 0; j < UnitPrefixLibrary.UNIT_PREFIXES.length; j ++) {
                            if (input[2].toLowerCase().equals(UnitPrefixLibrary.UNIT_PREFIXES[j] + VOLUME_UNITS[i]) ||
                                    input[2].equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + VOLUME_UNITS[i]) ||
                                    input[2].equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + VOLUME_SHORT_UNITS[i])) {
                                VOLUME_UNIT = i;
                                VOLUME_UNIT_PREFIX = j;
                                noMatch = false;
                            }
                        }
                    }
                    if (noMatch) {
                        VOLUME_NONEXISTANT_UNIT = input[2];
                    }
                } else if (!inputIsEmpty[2]) {
                    if (input[2].substring(0, 1).matches("[0-9]")) {
                        String valuePlaceHolder = "";
                        String unitPlaceHolder = "";
                        boolean hasChanged = false;
                        for (int i = 0; i < VOLUME_SPLIT.length; i ++) {
                            if (VOLUME_SPLIT[i].matches("[0-9]") || VOLUME_SPLIT[i].equals(".")) {
                                if (!hasChanged) {
                                    valuePlaceHolder += VOLUME_SPLIT[i];
                                } else {
                                    VOLUME_ERROR = true;
                                }
                            } else if (VOLUME_SPLIT[i].matches("[a-zA-Z]")) {
                                unitPlaceHolder += VOLUME_SPLIT[i];
                                hasChanged = true;
                            }
                        }
                        VOLUME = Double.parseDouble(valuePlaceHolder);
                        for (int i = 0; i < VOLUME_UNITS.length; i ++) {
                            if (unitPlaceHolder.toLowerCase().equals(VOLUME_UNITS[i])) {
                                VOLUME_UNIT = i;
                            }
                            for (int j = 0; j < UnitPrefixLibrary.UNIT_PREFIXES.length; j ++) {
                                if (unitPlaceHolder.toLowerCase().equals((UnitPrefixLibrary.UNIT_PREFIXES[j] + VOLUME_UNITS[i])) ||
                                        unitPlaceHolder.equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + VOLUME_UNITS[i]) ||
                                        unitPlaceHolder.equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + VOLUME_SHORT_UNITS[i])) {
                                    VOLUME_UNIT = i;
                                    VOLUME_UNIT_PREFIX = j;
                                }
                            }
                        }
                    } else {
                        VOLUME_ERROR = true;
                    }
                }

                double MOLAR_MASS = 0;
                String[] MOLAR_MASS_UNITS = { "grammol" };
                String[] MOLAR_MASS_SHORT_UNITS = { "g/mol" };
                double[] MOLAR_MASS_UNIT_VALUES = { 1.0 };
                int MOLAR_MASS_UNIT = 0;
                int MOLAR_MASS_UNIT_PREFIX = 0;
                boolean MOLAR_MASS_ERROR = false;
                String MOLAR_MASS_NONEXISTANT_UNIT = "";
                String[] MOLAR_MASS_SPLIT = input[3].split("");
                String MOLAR_MASS_ELEMENT = "";

                if (input[3].matches("[0-9]+")) {
                    MOLAR_MASS = Double.parseDouble(input[3]);
                } else if (!inputIsEmpty[3] && input[3].substring(0, 1).matches("[A-Za-z]")) {
                    boolean noMatch = true;
                    for (int i = 0; i < MOLAR_MASS_UNITS.length; i++) {
                        if (input[3].toLowerCase().equals(MOLAR_MASS_UNITS[i])) {
                            MOLAR_MASS_UNIT = i;
                            noMatch = false;
                        }
                        for (int j = 0; j < UnitPrefixLibrary.UNIT_PREFIXES.length; j++) {
                            if (input[3].toLowerCase().equals(UnitPrefixLibrary.UNIT_PREFIXES[j] + MOLAR_MASS_UNITS[i]) ||
                                    input[3].equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + MOLAR_MASS_UNITS[i]) ||
                                    input[3].equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + MOLAR_MASS_SHORT_UNITS[i])) {
                                MOLAR_MASS_UNIT = i;
                                MOLAR_MASS_UNIT_PREFIX = j;
                                noMatch = false;
                            }
                        }
                    }
                    if (noMatch) {
                        for(int i = 0; i < AtomLibrary.ATOMS.length; i ++) {
                            if (AtomLibrary.ATOMS[i][0].toLowerCase().equals(input[3].toLowerCase())) {
                                MOLAR_MASS = Double.parseDouble(AtomLibrary.ATOMS[i][2]);
                                noMatch = false;
                            }
                        }
                    }
                    if (noMatch) {
                        ArrayList<String> elements = new ArrayList<String>();
                        String intHolder = "";
                        boolean error = false;
                        for (int i = 0; i < MOLAR_MASS_SPLIT.length; i++) {
                            if (MOLAR_MASS_SPLIT[i].matches("[0-9]")) {
                                if (i < MOLAR_MASS_SPLIT.length - 1 && MOLAR_MASS_SPLIT[i + 1].matches("[0-9]")) {
                                    intHolder += MOLAR_MASS_SPLIT[i];
                                } else {
                                    elements.add(intHolder + MOLAR_MASS_SPLIT[i]);
                                    intHolder = "";
                                }
                            } else if (MOLAR_MASS_SPLIT[i].matches("[A-Z]")) {
                                if (i < MOLAR_MASS_SPLIT.length - 1 && MOLAR_MASS_SPLIT[i + 1].matches("[a-z]")) {
                                    elements.add(MOLAR_MASS_SPLIT[i] + MOLAR_MASS_SPLIT[i + 1]);
                                } else {
                                    elements.add(MOLAR_MASS_SPLIT[i]);
                                }
                            } else if (i < MOLAR_MASS_SPLIT.length - 1 && MOLAR_MASS_SPLIT[i].matches("[a-z]") && MOLAR_MASS_SPLIT[i + 1].matches("[a-z]")) {
                                MOLAR_MASS_ERROR = true;
                            }
                        }
                        ArrayList<Double> elementValues = new ArrayList<Double>();
                        for (int i = 0; i < elements.size(); i++) {
                            if (elements.get(i).matches("[0-9]")) {
                                elementValues.set(elementValues.size() - 1, elementValues.get(elementValues.size() - 1) * Double.parseDouble(elements.get(i)));
                            } else {
                                for (int j = 0; j < AtomLibrary.ATOMS.length; j++) {
                                    if (elements.get(i).equals(AtomLibrary.ATOMS[j][1])) {
                                        elementValues.add(Double.parseDouble(AtomLibrary.ATOMS[j][2]));
                                    }
                                }
                            }
                        }
                        if (!error) {
                            noMatch = false;
                            for (int i = 0; i < elementValues.size(); i++) {
                                MOLAR_MASS += elementValues.get(i);
                            }
                        }
                    }
                    if (noMatch) {
                        MOLAR_MASS_NONEXISTANT_UNIT = input[3];
                    }
                } else if (!inputIsEmpty[3]) {
                    if (input[3].substring(0, 1).matches("[0-9]")) {
                        String valuePlaceHolder = "";
                        String unitPlaceHolder = "";
                        boolean hasChanged = false;
                        for (int i = 0; i < MOLAR_MASS_SPLIT.length; i ++) {
                            if (MOLAR_MASS_SPLIT[i].matches("[0-9]") || MOLAR_MASS_SPLIT[i].equals(".")) {
                                if (!hasChanged) {
                                    valuePlaceHolder += MOLAR_MASS_SPLIT[i];
                                } else {
                                    MOLAR_MASS_ERROR = true;
                                }
                            } else if (MOLAR_MASS_SPLIT[i].matches("[a-zA-Z]")) {
                                unitPlaceHolder += MOLAR_MASS_SPLIT[i];
                                hasChanged = true;
                            }
                        }
                        MOLAR_MASS = Double.parseDouble(valuePlaceHolder);
                        for (int i = 0; i < MOLAR_MASS_UNITS.length; i ++) {
                            if (unitPlaceHolder.toLowerCase().equals(MOLAR_MASS_UNITS[i])) {
                                MOLAR_MASS_UNIT = i;
                            }
                            for (int j = 0; j < UnitPrefixLibrary.UNIT_PREFIXES.length; j ++) {
                                if (unitPlaceHolder.toLowerCase().equals((UnitPrefixLibrary.UNIT_PREFIXES[j] + MOLAR_MASS_UNITS[i])) ||
                                        unitPlaceHolder.equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + MOLAR_MASS_UNITS[i]) ||
                                        unitPlaceHolder.equals(UnitPrefixLibrary.UNIT_SHORT_PREFIXES[j] + MOLAR_MASS_SHORT_UNITS[i])) {
                                    MOLAR_MASS_UNIT = i;
                                    MOLAR_MASS_UNIT_PREFIX = j;
                                }
                            }
                        }
                    } else {
                        MOLAR_MASS_ERROR = true;
                    }
                }

                double MOLARITY = 0;
                String[] MOLARITY_UNITS = { "molarity", "molar" };
                String[] MOLARITY_SHORT_UNITS = { "mol/l", "M" };
                double[] MOLARITY_UNIT_VALUES = { 1.0, 1.0 };
                int MOLARITY_UNIT = 0;
                int MOLARITY_UNIT_PREFIX = 0;
                boolean MOLARITY_ERROR = false;
                String MOLARITY_NONEXISTANT_UNIT = "";
                String[] MOLARITY_SPLIT = input[4].split("");

                if (input[4].matches("[0-9]+")) {
                    MOLARITY = Double.parseDouble(input[4]);
                } else if (input[4].matches("[a-zA-Z]+")) {
                    for (int i = 0; i < MOLARITY_UNITS.length; i ++) {
                        if (input[4].toLowerCase().equals(MOLARITY_UNITS[i])) {
                            MOLARITY_UNIT = i;
                        }
                        for (int j = 0; j < UnitPrefixLibrary.UNIT_PREFIXES.length; j ++) {
                            if (input[4].toLowerCase().equals((UnitPrefixLibrary.UNIT_PREFIXES[i] + MOLARITY_UNITS[i]).toLowerCase())) {
                                MOLARITY_UNIT = i;
                                MOLARITY_UNIT_PREFIX = j;
                            }
                        }
                    }
                } else if (!inputIsEmpty[4]) {
                    String[] characters = input[4].split("");
                    if (characters[1].matches("^[0-9]")) {
                        String valuePlaceHolder = "";
                        String unitPlaceHolder = "";
                        boolean hasChanged = false;
                        for (int i = 0; i < characters.length; i ++) {
                            if (characters[i].matches("[0-9]") || characters[i].equals(".")) {
                                if (!hasChanged) {
                                    valuePlaceHolder += characters[i];
                                } else {
                                    MOLARITY_ERROR = true;
                                }
                            } else if (characters[i].matches("[a-zA-Z]")) {
                                unitPlaceHolder += characters[i];
                                hasChanged = true;
                            }
                        }
                        MOLARITY = Double.parseDouble(valuePlaceHolder);
                        for (int i = 0; i < MOLARITY_UNITS.length; i ++) {
                            if (unitPlaceHolder.toLowerCase().equals(MOLARITY_UNITS[i])) {
                                MOLARITY_UNIT = i;
                            }
                            for (int j = 0; j < UnitPrefixLibrary.UNIT_PREFIXES.length; j ++) {
                                if (input[4].toLowerCase().equals((UnitPrefixLibrary.UNIT_PREFIXES[i] + MOLARITY_UNITS[i]).toLowerCase())) {
                                    MOLARITY_UNIT = i;
                                    MOLARITY_UNIT_PREFIX = j;
                                }
                            }
                        }
                    } else {
                        MOLARITY_ERROR = true;
                    }
                }

                // Mol

                if (MASS != 0 && MOLAR_MASS != 0 && MOL == 0) {
                    MOL = (MASS / MOLAR_MASS) / UnitPrefixLibrary.UNIT_PREFIX_VALUES[MOL_UNIT_PREFIX];
                } else if (MOLARITY != 0 && VOLUME != 0 && MOL == 0) {
                    MOL = (MOLARITY * VOLUME) / UnitPrefixLibrary.UNIT_PREFIX_VALUES[MOL_UNIT_PREFIX];
                }

                if (MOL_ERROR) {
                    mol.setText(ERROR_MESSAGE);
                } else if (MOL != 0) {
                    MOL = (double) Math.round(MOL * amountOfDecimals) / amountOfDecimals; // fjernelse af decimaler
                    mol.setText((MOL * MOL_UNIT_VALUES[MOL_UNIT]) +
                            " " + UnitPrefixLibrary.UNIT_SHORT_PREFIXES[MOL_UNIT_PREFIX] + MOL_UNITS[MOL_UNIT] +
                            ((MOL_NONEXISTANT_UNIT != "") ? UNIT_ERROR_MESSAGE + MOL_NONEXISTANT_UNIT + " )" : "" ));
                }

                // Mass

                if (MOL != 0 && MOLAR_MASS != 0 && MASS == 0) {
                    MASS = MOL * MOLAR_MASS / UnitPrefixLibrary.UNIT_PREFIX_VALUES[MASS_UNIT_PREFIX];
                }

                if (MASS_ERROR) {
                    mass.setText(ERROR_MESSAGE);
                } else if (MASS != 0) {
                    MASS = (double) Math.round(MASS * amountOfDecimals) / amountOfDecimals; // fjernelse af decimaler
                    mass.setText((MASS * MASS_UNIT_VALUES[MASS_UNIT]) +
                            " " + UnitPrefixLibrary.UNIT_SHORT_PREFIXES[MASS_UNIT_PREFIX] + MASS_SHORT_UNITS[MASS_UNIT] +
                            ((MASS_NONEXISTANT_UNIT != "") ? UNIT_ERROR_MESSAGE + MASS_NONEXISTANT_UNIT + " )" : "" ));
                }

                // Volume

                if (MOL != 0 && MOLARITY != 0 && VOLUME == 0) {
                    VOLUME = MOL / MOLARITY;
                }

                if (VOLUME_ERROR) {
                    volume.setText(ERROR_MESSAGE);
                } else if (VOLUME != 0) {
                    VOLUME = (double) Math.round(VOLUME * amountOfDecimals) / amountOfDecimals; // fjernelse af decimaler
                    volume.setText((VOLUME * VOLUME_UNIT_VALUES[VOLUME_UNIT]) +
                            " " + UnitPrefixLibrary.UNIT_PREFIXES[VOLUME_UNIT_PREFIX] + VOLUME_SHORT_UNITS[VOLUME_UNIT] +
                            ((VOLUME_NONEXISTANT_UNIT != "") ? UNIT_ERROR_MESSAGE + VOLUME_NONEXISTANT_UNIT + " )" : "" ));
                }

                // Molar Mass

                if (MASS != 0 && MOL != 0 && MOLAR_MASS == 0) {
                    MOLAR_MASS = MASS / MOL;
                }

                if (MOLAR_MASS_ERROR) {
                    molarMass.setText(ERROR_MESSAGE);
                } else if (MOLAR_MASS != 0) {
                    MOLAR_MASS = (double) Math.round(MOLAR_MASS * amountOfDecimals) / amountOfDecimals; // fjernelse af decimaler
                    molarMass.setText((MOLAR_MASS * MOLAR_MASS_UNIT_VALUES[MOLAR_MASS_UNIT]) +
                            " " + UnitPrefixLibrary.UNIT_PREFIXES[MOLAR_MASS_UNIT_PREFIX] + MOLAR_MASS_SHORT_UNITS[MOLAR_MASS_UNIT]);
                }

                // Molarity

                if (MOL != 0 && VOLUME != 0 && MOLARITY == 0) {
                    MOLARITY = MOL / VOLUME;
                } else if (MASS != 0 && MOLAR_MASS != 0 && VOLUME != 0 && MOLARITY == 0) {
                    MOLARITY = (MASS * MOLAR_MASS) / VOLUME;
                }

                if (MOLARITY_ERROR) {
                    molarity.setText(ERROR_MESSAGE);
                } else if (MOLARITY != 0) {
                    MOLARITY = (double) Math.round(MOLARITY * amountOfDecimals) / amountOfDecimals; // fjernelse af decimaler
                    molarity.setText((MOLARITY * MOLARITY_UNIT_VALUES[MOLARITY_UNIT]) +
                            " " + UnitPrefixLibrary.UNIT_PREFIXES[MOLARITY_UNIT_PREFIX] + MOLARITY_UNITS[MOLARITY_UNIT]);
                }
            }
        });

        final Button search = (Button) findViewById(R.id.button);
    }
}
