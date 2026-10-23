package parking.refactored;

import parking.PaymentMethod;

import java.util.List;

public class receiptFormatter {
    public String dailyReport(List<String> receipts,double total){
        StringBuilder sb = new StringBuilder("=== Daily report ===\n");
        for (String receipt : receipts) {
            sb.append(receipt).append("\n");
        }
        sb.append("Total: ").append(total).append(" MAD");
        return sb.toString();
    }
    public String receipt(Vehicle vehicle, int hours, double amount, PaymentMethod method){
        String receipt = vehicle.getPlate() + " | " + vehicle.getTariff().type() + " | "
                + hours + " h | " + amount + " MAD | " + method.name();
        return receipt;
    }


}
