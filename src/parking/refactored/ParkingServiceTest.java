package parking.refactored;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ParkingServiceTest {

    static class InMemoryLog implements ParkingLog {
        final List<String> lines = new ArrayList<>();
        @Override public void log(String line) { lines.add(line); }
    }

    public static void main(String[] args) throws Exception {
        InMemoryLog log = new InMemoryLog();
        ParkingService service = new ParkingService(log, new receiptFormatter());

        Vehicle car   = new Vehicle("12345-A-6", new CarTariff());
        Vehicle bike  = new Vehicle("67890-B-1", new MotorbikeTariff());
        Vehicle truck = new Vehicle("24680-D-8", new TruckTariff());

        CardPayment card = new CardPayment("4111111111114242");
        CashPayment cash = new CashPayment();

        service.checkout(car, 3, card);
        service.checkout(bike, 2, cash);
        service.checkout(truck, 4, card);
        service.cancel(truck, 4, card);

        String report = service.getFormatter().dailyReport(service.getReceipts(), service.getTotal());
        System.out.println(report);
    }
}