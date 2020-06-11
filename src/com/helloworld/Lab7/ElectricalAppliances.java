package OOP.Lab7;

public class ElectricalAppliances {
    private int power;
    private String name;

    public ElectricalAppliances(int power, String name) throws MyException {
        if (power < 0){
            throw new MyException();
        }
        this.name = name;
        this.power = power;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof ElectricalAppliances
                && ((ElectricalAppliances) obj).power == power;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

}
