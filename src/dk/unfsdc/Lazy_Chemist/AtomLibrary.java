package dk.unfsdc.Lazy_Chemist;

public class AtomLibrary {

    public static final String[] CATEGORIES = {
            "Diatomic Nonmetals",       // 0
            "Noble Gases",              // 1
            "Alkali Metals",            // 2
            "Alkaline Earth Metals",    // 3
            "Metalloids",               // 4
            "Polyatomic Nonmetals",     // 5
            "Other Metals",             // 6
            "Transition Metals"         // 7
    };

    public static final String[] HYDROGEN = { "Hydrogen", "H", "1.008", "2.20", CATEGORIES[0] };
    public static final String[] HELIUM = { "Helium", "He", "4.002602", "", CATEGORIES[1] };
    public static final String[] LITHIUM = { "Lithium", "Li", "6.94", "0.98", CATEGORIES[2] };
    public static final String[] BERYLLIUM = { "Beryllium", "Be", "9.0121831", "1.57", CATEGORIES[3] };
    public static final String[] BORON = { "Boron", "B", "10.81", "2.04", CATEGORIES[4] };
    public static final String[] CARBON = { "Carbon", "C", "12.011", "2.55", CATEGORIES[5] };
    public static final String[] NITROGEN = { "Nitrogen", "N", "14.007", "3.04", CATEGORIES[0] };
    public static final String[] OXYGEN = { "Oxygen", "O", "15.999", "3.44", CATEGORIES[0] };
    public static final String[] FLUORINE = { "Fluorine", "F", "18.998403163", "3.98", CATEGORIES[0] };
    public static final String[] NEON = { "Neon", "Ne", "20.1797", "", CATEGORIES[1] };
    public static final String[] SODIUM = { "Sodium", "Na", "22.98976928", "0.93", CATEGORIES[2] };
    public static final String[] MAGNESIUM = { "Magnesium", "Mg", "24.305", "1.31", CATEGORIES[3] };
    public static final String[] ALUMINIUM = { "Aluminium", "Al", "26.9815385", "1.61", CATEGORIES[6] };
    public static final String[] SILICON = { "Silicon", "Si", "28.085", "1.9", CATEGORIES[4] };
    public static final String[] PHOSPHORUS = { "Phosphorus", "P", "30.973761998", "2.19", CATEGORIES[5] };
    public static final String[] SULFUR = { "Sulfur", "S", "32.066", "2.58", CATEGORIES[5] };
    public static final String[] CHLORINE = { "Chlorine", "Cl", "35.45", "3.16", CATEGORIES[0] };
    public static final String[] ARGON = { "Argon", "Ar", "39.948", "", CATEGORIES[1] };
    public static final String[] POTASSIUM = { "Potassium", "K", "39.0983", "0.82", CATEGORIES[2] };
    public static final String[] CALCIUM = { "Calcium", "Ca", "40.078", "1", CATEGORIES[3] };
    public static final String[] SCANDIUM = { "Scandium", "Sc", "44.955908", "1.36", CATEGORIES[7] };
    public static final String[] TITANIUM = { "Titanium", "Ti", "47.867", "1.54", CATEGORIES[7] };
    public static final String[] VANADIUM = { "Vanadium", "V", "50.9415", "0.98", CATEGORIES[2] };
    public static final String[] CHROMIUM = { "chromium", "Cr", "51.9961", "1.66", CATEGORIES[7] };
    public static final String[] MANGANESE = { "Manganese", "Mn", "54.938044", "1.55", CATEGORIES[7] };
    public static final String[] IRON = { "Iron", "Fe", "55.845", "1.83", CATEGORIES[7] };
    public static final String[] COBALT = { "Cobalt", "Co", "58.933194", "1.88", CATEGORIES[7] };
    public static final String[] NICKEL = { "Nickel", "Ni", "58.6934", "1.91", CATEGORIES[7] };
    public static final String[] COPPER = { "Copper", "Cu", "63.546", "1.9", CATEGORIES[7] };
    public static final String[] ZINC = { "Zinc", "Zn", "65.38", "1.65", CATEGORIES[7] };
    public static final String[] GALLIUM = { "Gallium", "Ga", "69.723", "1.81", CATEGORIES[6] };
    public static final String[] GERMANIUM = { "Germanium", "Ge", "72.63", "2.01", CATEGORIES[4] };
    public static final String[] ARSENIC = { "Arsenic", "As", "74.921595", "2.18", CATEGORIES[4] };
    public static final String[] SELENIUM = { "Selenium", "Se", "78.971", "2.55", CATEGORIES[5] };
    public static final String[] BROMINE = { "Bromine", "Br", "79.904", "2.96", CATEGORIES[0] };
    public static final String[] KRYPTON = { "Krypton", "Kr", "83.798", "3.00", CATEGORIES[1] };
    public static final String[] RUBIDIUM = { "Rubidium", "Rb", "85.4678", "0.82", CATEGORIES[2] };
    public static final String[] STRONTIUM = { "Strontium", "Sr", "87.62", "0.95", CATEGORIES[3] };
    public static final String[] YTTRIUM = { "Yttrium", "Y", "88.90584", "1.22", CATEGORIES[7] };
    public static final String[] ZIRCONIUM = { "Zirconium", "Zr", "91.224", "1.33", CATEGORIES[7] };
    public static final String[] NIOBIUM = { "Niobium", "Nb", "92.90637", "1.6", CATEGORIES[7] };
    public static final String[] MOLYBDENUM = { "Molybdenum", "Mo", "95.95", "2.16", CATEGORIES[7] };    // public static final String[] = { "", "", "", "", CATEGORIES[] };
    public static final String[] TECHNETIUM = { "Technetium", "Tc", "98", "1.9", CATEGORIES[7] };
    public static final String[] RUTHENIUM = { "Ruthenium", "Ru", "101.07", "2.2", CATEGORIES[7] };
    public static final String[] RHODIUM = { "Rhodium", "Rh", "102.90550", "2.28", CATEGORIES[7] };

    public static final String[][] ATOMS = {
            HYDROGEN,
            HELIUM,
            LITHIUM,
            BERYLLIUM,
            BORON,
            CARBON,
            NITROGEN,
            OXYGEN,
            FLUORINE,
            NEON,
            SODIUM,
            MAGNESIUM,
            ALUMINIUM,
            SILICON,
            PHOSPHORUS,
            SULFUR,
            CHLORINE,
            ARGON,
            POTASSIUM,
            CALCIUM,
            SCANDIUM,
            TITANIUM,
            VANADIUM,
            CHROMIUM,
            MANGANESE,
            IRON,
            COBALT,
            NICKEL,
            COPPER,
            ZINC,
            GALLIUM,
            GERMANIUM,
            ARSENIC,
            SELENIUM,
            BROMINE,
            KRYPTON,
            RUBIDIUM
    };
}
