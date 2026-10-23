package parking.refactored;

public class CarTariff implements Tariff{
    @Override
    public double fee(int hours){
        return hours*5.0;
    }
    @Override
    public String type(){
        return "CAR";
    }
}
