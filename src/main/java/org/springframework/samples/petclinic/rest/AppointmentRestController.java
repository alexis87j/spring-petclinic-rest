package org.springframework.samples.petclinic.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.Appointment;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@CrossOrigin(exposedHeaders = "errors, content-type")
@RequestMapping("/api/appointments")
public class AppointmentRestController {

    @PreAuthorize( "hasRole(@roles.OWNER_ADMIN)" )
    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<Appointment>> findAllAppointments() {
        Appointment appointment = new Appointment();
        appointment.setDate("date");
        appointment.setOwner("owner");
        appointment.setPetname("petname");
        appointment.setPettype("pettype");
        appointment.setDescription("desc");
        return new ResponseEntity<>(Collections.singletonList(appointment), HttpStatus.OK);
    }
}
