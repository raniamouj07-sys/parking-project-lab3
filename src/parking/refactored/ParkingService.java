package parking.refactored;

import parking.CashPayment;

import java.io.IOException;
import java.sql.Ref;
import java.util.*;

public class ParkingService {
    private final List<String> receipts = new ArrayList<>();
    private  ParkingLog logger ;
    private double total;
    private receiptFormatter formatter;
    ParkingService(ParkingLog logger,receiptFormatter formatter){
        this.logger=logger;
        this.formatter=formatter;
    }
    public receiptFormatter getFormatter() {
        return formatter;
    }
    public double getTotal() {
        return total;
    }
    public List<String> getReceipts() {
        return receipts;
    }
    public void checkout(Vehicle vehicle, int hours, PaymentMethod method)
            throws IOException {
        double amount = vehicle.getTariff().fee(hours);
        method.pay(amount);
        total += amount;

        String receipt = vehicle.getPlate() + " | " + vehicle.getTariff().type() + " | "
                + hours + " h | " + amount + " MAD | " + method.name();
        receipts.add(receipt);
        logger.log(receipt);
    }
    public void cancel(Vehicle vehicle, int hours, RefundablePayment method) {
        double amount = vehicle.getTariff().fee(hours);
        if (method instanceof CashPayment) {            // cash cannot be refunded
            System.out.println("Refund " + amount + " MAD at the desk for "
                    + vehicle.getPlate());
        } else {
            method.refund(amount);
        }
        total -= amount;
    }


}
