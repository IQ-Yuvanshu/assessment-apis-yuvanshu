package com.assessment.yuvanshu.Models;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Appointment(
        String patientName,
        String doctorName,
        LocalDateTime appointmentTime
) {
}
