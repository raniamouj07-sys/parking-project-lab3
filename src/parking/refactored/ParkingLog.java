package parking.refactored;

import java.io.IOException;

public interface ParkingLog {
    public void log(String line)throws IOException;
}
