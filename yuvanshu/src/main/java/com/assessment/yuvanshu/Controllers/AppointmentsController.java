package com.assessment.yuvanshu.Controllers;

import com.assessment.yuvanshu.Models.Appointment;
import com.assessment.yuvanshu.Models.AppointmentRequest;
import com.assessment.yuvanshu.Services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentsController {
    @Autowired
    private final AppointmentService appointmentService;



    @GetMapping("/getAll")
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAppointmentsList();
    }

    @PostMapping("/create-new")
    public void createAppointment(@RequestBody AppointmentRequest appointmentRequest){
        appointmentService.createAppointment(appointmentRequest);
    }

    @PostMapping("/update-appointment/{id}")
    public void updateAppointment(@PathVariable("id")Long id, @RequestBody AppointmentRequest appointmentRequest){
        appointmentService.updateAppointment(id,appointmentRequest);
    }

    @GetMapping("get-appointment/{id}")
    public Appointment getAppointment(@PathVariable("id") Integer id){
        return appointmentService.getAppointment(id);
    }

    @PostMapping("delete-appointment/{id}")
    public void deleteAppointment(@PathVariable("id") Integer id){
        appointmentService.deleteAppointment(id);


    }
}
