//package com.example.Rest_APIs;
//
//
//import com.example.Rest_APIs.entity.Speaker;
//import com.example.Rest_APIs.entity.Tyre;
//import com.example.Rest_APIs.entity.Vehicle;
//import com.example.Rest_APIs.repository.VehicleRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final VehicleRepository vehicleRepository;
//    private final SpeakerService speakerService;
//    private final TyreService tyreService;
//
//    public DataInitializer(VehicleRepository vehicleRepository, SpeakerService speakerService, TyreService tyreService) {
//        this.vehicleRepository = vehicleRepository;
//        this.speakerService = speakerService;
//        this.tyreService = tyreService;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Insert dummy data
////        Speaker speaker = new Speaker();
////        speaker.setBrand("Bose");
////        speaker.setPrice(250.0);
////
////        Tyre tyre = new Tyre();
////        tyre.setBrand("Bridgestone");
////        tyre.setPrice(150.0);
////
////        Vehicle vehicle = new Vehicle();
////        vehicle.setSpeaker(speaker);
////        vehicle.setTyre(tyre);
////        vehicle.setPrice(speaker.getPrice() + tyre.getPrice());
//
//        Speaker speaker = speakerService.generateSpeaker();
//        Tyre tyre = tyreService.generateTyre();
//
//        Vehicle vehicle = new Vehicle();
//        vehicle.setSpeaker(speaker);
//        vehicle.setTyre(tyre);
//        vehicle.setPrice(speaker.getPrice() + tyre.getPrice());
//
//        vehicleRepository.save(vehicle);
//    }
//}
//
