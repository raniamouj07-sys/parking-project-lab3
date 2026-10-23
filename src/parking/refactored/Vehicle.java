package parking.refactored;

public class Vehicle {
    private final String plate;
    private final Tariff tariff;      // "CAR", "MOTORBIKE" or "TRUCK"

    public Vehicle(String plate, Tariff tariff) {
        this.plate = plate;
        this.tariff = tariff;
    }
    public String getPlate() { return plate; }
    public Tariff getTariff() {
        return tariff;
    }
    public double fee(int hours){
        return tariff.fee(hours);
    }
}
