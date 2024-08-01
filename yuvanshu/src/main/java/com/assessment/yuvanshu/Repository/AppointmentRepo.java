package com.assessment.yuvanshu.Repository;

import com.assessment.yuvanshu.Models.Appointment;
import com.assessment.yuvanshu.Models.AppointmentRequest;
import database.Tables;
import database.tables.records.AppointmentsRecord;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpClientErrorException;

import java.util.*;

@Repository
public class AppointmentRepo {
    private final DSLContext context;
    public AppointmentRepo(DSLContext context) {
        this.context=context;
    }

    public List<Appointment> getAppointmentsList(){
        return this.context.selectFrom(Tables.APPOINTMENTS)
                .where(Tables.APPOINTMENTS.DELEATED.eq(false))
                .stream().map(record -> Appointment.builder()
                        .patientName(record.getPatientName())
                        .doctorName(record.getDoctorName())
                        .appointmentTime(record.getDateTime())
                        .build()).toList();
    }

    public void createAppointment(AppointmentRequest appointmentRequest){
        AppointmentsRecord appointmentsRecord = this.context.newRecord(Tables.APPOINTMENTS);

        appointmentsRecord.setPatientName(appointmentRequest.patientName());
        appointmentsRecord.setDoctorName(appointmentRequest.doctorName());

        if(appointmentRequest.time() != null){
            appointmentsRecord.setDateTime(appointmentRequest.time());

        }

        appointmentsRecord.store();
    }

    public void updateAppointment(Long id,AppointmentRequest appointmentRequest){

        AppointmentsRecord appointmentsRecord = this.context.selectFrom(Tables.APPOINTMENTS)
                .where(Tables.APPOINTMENTS.ID.eq(id.intValue()))
                .fetchOne();

        if(appointmentsRecord == null){
            return;
        }
        appointmentsRecord.setDateTime(appointmentRequest.time());
        appointmentsRecord.setDoctorName(appointmentRequest.doctorName());
        appointmentsRecord.update();



    }

    public Appointment getAppointment(Integer id){
        Condition condition = Tables.APPOINTMENTS.ID.eq(id);

        AppointmentsRecord appointmentsRecord = this.context.selectFrom(Tables.APPOINTMENTS)
                .where(condition)
                .fetchOne();

        Appointment appointment = Appointment.builder()
                .patientName(appointmentsRecord.getPatientName())
                .doctorName(appointmentsRecord.getDoctorName())
                .appointmentTime(appointmentsRecord.getDateTime())
                .build();

        return appointment;
    }

    public void deleteAppointment(Integer id){
        Condition condition = Tables.APPOINTMENTS.ID.eq(id);

        AppointmentsRecord appointmentsRecord = this.context.selectFrom(Tables.APPOINTMENTS)
                .where(condition)
                .fetchOne();

        appointmentsRecord.setDeleated(true);

        appointmentsRecord.update();

    }
}
