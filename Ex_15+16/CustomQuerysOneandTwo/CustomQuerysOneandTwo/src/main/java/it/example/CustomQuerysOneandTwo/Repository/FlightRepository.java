package it.example.CustomQuerysOneandTwo.Repository;

import it.example.CustomQuerysOneandTwo.Entity.Flight;

import it.example.CustomQuerysOneandTwo.Enum.FlightEnum;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

    // Custom query method to find flights that are ON_TIME or DELAYED
    @Query("SELECT f FROM Flight f WHERE f.status = 'ON_TIME' OR f.status = 'DELAYED'")
    List<Flight> findOnTimeOrDelayedFlights();

    // Custom query method to retrieve all flights in ascending order by fromAirport
    Page findAllByOrderByFromAirportAsc(Pageable pageable);

    // Custom query method to retrieve all flights that are ON_TIME
    List<Flight> findByStatus(FlightEnum status);

    // Custom query method to retrieve flights with specific statuses (p1 and p2)
    @Query("SELECT f FROM Flight f WHERE f.status = ?1 OR f.status = ?2")
    List<Flight> findFlightsByStatus(String p1, String p2);

}
