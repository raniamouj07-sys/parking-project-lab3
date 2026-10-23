package parking.refactored;

public class TruckTariff implements Tariff{
    @Override
    public double fee(int hours){
        return 20+hours*10.0;
    }
    @Override
    public String type(){
        return "TRUCK";
    }
}
