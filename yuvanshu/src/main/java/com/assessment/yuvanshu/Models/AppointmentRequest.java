package com.assessment.yuvanshu.Models;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record AppointmentRequest(
        String patientName,
        String doctorName,
        LocalDateTime time
) {
}
