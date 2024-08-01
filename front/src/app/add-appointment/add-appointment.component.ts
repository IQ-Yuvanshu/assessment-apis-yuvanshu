import { Component, OnInit } from '@angular/core';
import { FormGroup , FormControl, FormBuilder } from '@angular/forms';
import { AppointmentRequest } from '../../../dist/apiclient/src';
@Component({
  selector: 'app-add-appointment',
  templateUrl: './add-appointment.component.html',
  styleUrl: './add-appointment.component.scss'
})
export class AddAppointmentComponent implements OnInit {
  appointmentForm!:FormGroup;

  constructor(private fb:FormBuilder){

  }

  // appointmentForm=this.fb.

  ngOnInit(){
    this.appointmentForm = new FormGroup({
      patientName: new FormControl(''),
      doctorName: new FormControl(''),
      dateTime:new FormControl('')
    });

   
  }

  submitForm(){
    console.log(this.appointmentForm)
    const data:AppointmentRequest={
      patientName:this.appointmentForm.value.patientName,
      doctorName:this.appointmentForm.value.doctorName,
      time:this.appointmentForm.value.dateTime
    }



  }

}
