package parking;

import java.io.IOException;

public class TestQuestion5 {
    public static void main(String[] args){

        Vehicle truck = new Vehicle("TRK-999", "TRUCK");
        PaymentMethod mockCard = new CardPayment("1234");

        // instantiating ParkingGarage automatically forces the creation of "parking.log"
        ParkingGarage garage = new ParkingGarage();

        try {
            double fee = garage.fee(truck, 4);
            System.out.println("Calculated Fee: " + fee); // 60.0

            garage.checkout(truck, 4, mockCard); // This writes to "parking.log" directly
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Violation of DIP:
        //ParkingGarage depends directly on a concrete implementation (ie FileLogger) rather than an abstraction like an interface
    }
}

