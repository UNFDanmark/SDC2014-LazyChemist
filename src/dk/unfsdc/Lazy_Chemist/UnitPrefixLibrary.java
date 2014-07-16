package dk.unfsdc.Lazy_Chemist;

/**
 * Created by sdc on 7/16/14.
 */
public class UnitPrefixLibrary {

    public static final String[] UNIT_PREFIXES = { "", "Giga", "Mega", "Kilo", "Hecto", "Deca", "Deci", "Centi", "Milli", "Micro", "Nano" };
    public static final String[] UNIT_SHORT_PREFIXES = { "", "G", "M", "k", "h", "da", "d", "c", "m", "µ", "n"};
    public static final double[] UNIT_PREFIX_VALUES = { 1, Math.pow(10, 9), Math.pow(10, 6), Math.pow(10, 3), Math.pow(10, 2), Math.pow(10, 1), Math.pow(10, -1), Math.pow(10, -2), Math.pow(10, -3), Math.pow(10, -6), Math.pow(10, -9) };

}
