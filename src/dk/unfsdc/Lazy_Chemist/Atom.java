package dk.unfsdc.Lazy_Chemist;

/**
 * Created by sdc on 7/16/14.
 */
public class Atom {
    int number;
    String symbol;
    String name1;
    double weight;
    double electroNegativity;
    String category;
    String group;
    int year;

    public Atom(int number, String symbol, String name1, double weight, double electroNegativity, String category, String group, int year) {
        this.number = number;
        this.symbol = symbol;
        this.name1 = name1;
        this.weight = weight;
        this.electroNegativity = electroNegativity;
        this.category = category;
        this.group = group;
        this.year = year;
    }

    //Number
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    //Symbol
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    //Name
    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    //weight
    public double getweight() {
        return weight;
    }

    public void setweight(double weight) {
        this.weight = weight;
    }

    //ElectroNegativity
    public double getElectroNegativity() {
        return electroNegativity;
    }

    public void setElectroNegativity(double electroNegativity) {
        this.electroNegativity = electroNegativity;
    }

    //Category
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    //group
    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    //year
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}