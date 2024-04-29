package org.example;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleService {
    @Autowired
    private TyreService tyreService;
    @Autowired
    private SpeakerService speakerService;

    private List<Vehicle> vehicles;

    @PostConstruct
    public void init() {
        vehicles = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Tyre tyre = tyreService.getTyre();
            Speaker speaker = speakerService.getSpeaker();
            Vehicle vehicle = new Vehicle("Vehicle " + i,10000 + tyre.getPrice() + speaker.getPrice(), speaker,tyre);
            vehicles.add(vehicle);
        }
    }

    public Vehicle getMostExpensiveVehicle() {
        Vehicle mostExpensive = null;
        double maxPrice = 0;

        for (Vehicle vehicle : vehicles) {
            if (vehicle.getPrice() > maxPrice) {
                maxPrice = vehicle.getPrice();
                mostExpensive = vehicle;
            }
        }

        return mostExpensive;
    }
}
