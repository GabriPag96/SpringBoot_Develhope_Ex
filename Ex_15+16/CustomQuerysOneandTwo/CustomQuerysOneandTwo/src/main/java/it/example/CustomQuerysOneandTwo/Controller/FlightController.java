package it.example.CustomQuerysOneandTwo.Controller;

import it.example.CustomQuerysOneandTwo.Entity.Flight;
import it.example.CustomQuerysOneandTwo.Repository.FlightRepository;
import it.example.CustomQuerysOneandTwo.Service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    @Autowired
    FlightRepository flightRepository;

    @PostMapping("/addFlights")
    public void randomFlights(@RequestParam(required = false, defaultValue = "100") int n){

        flightService.addFlights(n);
    }

    @GetMapping("/all")
    public List<Flight> getAllFlights(){ //aggiungere (Pageable pageable) per riga.35.

//        return flightRepository.findAll(pageable).getContent();

        return flightService.getAllFlights();
    }

    @GetMapping("/onTime")
    public List<Flight> getOnTime(){

        return flightService.getOnTimeFlights();
    }

    @GetMapping("/delayed")
    public List<Flight> getDelayed(){

        return flightService.getDelayedFlights();
    }

    @GetMapping("/canceled")
    public List<Flight> getCanceled(){

        return flightService.getCanceledFlights();
    }

    @GetMapping("/delayed-cancelled")
    public List<Flight> getCanceledDelayed(){

        return flightService.getDelayedOrCancelledFlights();
    }

    @GetMapping("/delayed-onTime")
    public List<Flight> getOnTimeDelayed(){

        return flightService.getDelayedOrOnTimeFlights();
    }

//    @GetMapping("/onTime-delayed")
//    public List<Flight> getOnTimeOrDelayedFlights() {
//
//        // Retrieve flights that are ON_TIME or DELAYED
//        return flightRepository.findFlightsByStatus(
//                Arrays.asList(FlightEnum.ONTIME, FlightEnum.DELAYED
//                ));
//    }

}
