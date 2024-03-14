package it.example.CustomQuerysOneandTwo.Service;

import it.example.CustomQuerysOneandTwo.Entity.Flight;
import it.example.CustomQuerysOneandTwo.Enum.FlightEnum;
import it.example.CustomQuerysOneandTwo.Repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;


    public void addFlights(int n) {

        for (int i = 1; i < n; i++){

            Flight flight = new Flight();
            flight.setDescription(generateRandomString(9));
            flight.setFromAirport(generateRandomString(9));
            flight.setToAirport(generateRandomString(9));
            flight.setStatus(getRandomStatus());

            flightRepository.save(flight);
        }
    }

    private String generateRandomString(int length) {

        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder randomString = new StringBuilder();

        for (int i = 0; i < length; i++) {
            Random random = new Random();
            int index = random.nextInt(characters.length());
            randomString.append(characters.charAt(index));
        }

        return randomString.toString();
    }

    public FlightEnum getRandomStatus() {

        FlightEnum[] statusValues = FlightEnum.values();

        int randomIndex = new Random().nextInt(statusValues.length);

        return statusValues[randomIndex];
    }

    public List<Flight> getAllFlights(){

        return flightRepository.findAll();
    }

//    public List<Flight> getOnTimeFlights() {
//
//        List<Flight> statusFlights = new ArrayList<>();
//
//        for (Flight flight : flightRepository.findAll()) {
//
//            if (flight.getStatus() == FlightEnum.ONTIME) {
//
//                statusFlights.add(flight);
//
//            }
//        }
//
//        return statusFlights;
//    }
//
    public List<Flight> getDelayedFlights() {

        List<Flight> statusFlights = new ArrayList<>();

        for (Flight flight : flightRepository.findAll()) {

            if (flight.getStatus() == FlightEnum.DELAYED) {

                statusFlights.add(flight);

            }
        }

        return statusFlights;
    }

    public List<Flight> getCanceledFlights() {

        List<Flight> statusFlights = new ArrayList<>();

        for (Flight flight : flightRepository.findAll()) {

            if (flight.getStatus() == FlightEnum.CANCELLED) {

                statusFlights.add(flight);

            }
        }

        return statusFlights;
    }

    public List<Flight> getOnTimeFlights(){

        return flightRepository.findByStatus(FlightEnum.ONTIME);
    }

    public List<Flight> getDelayedOrCancelledFlights() {

        List<Flight> canceledDelayedFlights = new ArrayList<>();

        for (Flight flight : flightRepository.findAll()) {

            if (flight.getStatus() == FlightEnum.CANCELLED && flight.getStatus() == FlightEnum.DELAYED) {

                canceledDelayedFlights.add(flight);

            }
        }
        return canceledDelayedFlights;
    }

    public List<Flight> getDelayedOrOnTimeFlights() {

        List<Flight> statusQueryFlights = new ArrayList<>();

        for (Flight flight : flightRepository.findAll()) {

            if (flight.getStatus() == FlightEnum.ONTIME && flight.getStatus() == FlightEnum.DELAYED) {

                statusQueryFlights.add(flight);

            }
        }
        return statusQueryFlights;
    }

}
