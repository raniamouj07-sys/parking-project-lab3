package parking.refactored;

public class MotorbikeTariff implements Tariff{
    @Override
    public double fee(int hours){
        return hours*2.0;
    }
    @Override
    public String type(){
        return "MOTORBIKE";
    }
}
