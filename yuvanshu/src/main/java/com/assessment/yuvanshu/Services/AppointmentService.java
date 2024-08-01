package com.assessment.yuvanshu.Services;

import com.assessment.yuvanshu.Models.Appointment;
import com.assessment.yuvanshu.Models.AppointmentRequest;
import com.assessment.yuvanshu.Repository.AppointmentRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepo appointmentRepo;

    public List<Appointment> getAppointmentsList(){
        return appointmentRepo.getAppointmentsList();
    }

    public void createAppointment(AppointmentRequest appointmentRequest){
        appointmentRepo.createAppointment(appointmentRequest);
    }

    public void updateAppointment(Long id,AppointmentRequest appointmentRequest){
        appointmentRepo.updateAppointment(id,appointmentRequest);
    }

    public Appointment getAppointment(Integer id){
        return appointmentRepo.getAppointment(id);
    }

    public void deleteAppointment(Integer id){
        appointmentRepo.deleteAppointment(id);

    }
}
