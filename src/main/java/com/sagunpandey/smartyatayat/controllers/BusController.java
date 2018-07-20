package com.sagunpandey.smartyatayat.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sagunpandey.smartyatayat.dao.bus_log.BusLogService;
import com.sagunpandey.smartyatayat.entities.BusLog;
import com.sagunpandey.smartyatayat.helpers.GsonExclusionStrategy;
import com.sagunpandey.smartyatayat.objects.BusStatusCheckpointExit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusLogService busLogService;

    @GetMapping(
            value = "/log/exit",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public String getBusStatusForCheckpointExit() {
        List<BusLog> logs = busLogService.findLatestLogForExitEventForAllBuses();

        List<BusStatusCheckpointExit> statuses = new ArrayList<>();
        for(BusLog log: logs) {
            BusStatusCheckpointExit status = new BusStatusCheckpointExit();
            status.setBusNumber(log.getBus().getBusNumber());
            status.setCheckpoint(log.getCheckpointInfo().getCheckpointName());
            status.setTime(log.getTime());

            Integer seats = log.getBus().getTotalSeats();
            Integer standings = log.getBus().getStandingCapacity();
            Integer passengerCount = log.getPassengersCount();

            String availability;
            if(passengerCount >= (seats + standings))
                availability = "FULL";
            else {
                Integer remSeats;
                Integer remStands;

                if(passengerCount < seats) {
                    remSeats = seats - passengerCount;
                    remStands = standings;
                } else {
                    remSeats = 0;
                    remStands = (standings + seats) - passengerCount;
                }

                availability = "Seats: " + remSeats + " Stands: " + remStands;
            }

            status.setTotalPassengers(passengerCount);
            status.setAvailability(availability);

            statuses.add(status);
        }

        Gson gson = new GsonBuilder().addSerializationExclusionStrategy(new GsonExclusionStrategy()).create();
        return gson.toJson(statuses);
    }
}
