import { Component, OnInit } from '@angular/core';
import { Appointment, AppointmentsControllerService } from '../../../dist/apiclient/src';
import { ColDef } from 'ag-grid-community';
import 'ag-grid-enterprise';
import 'ag-grid-community/styles/ag-grid.css';
import 'ag-grid-community/styles/ag-theme-alpine.css';

@Component({
  selector: 'app-appointments',
  templateUrl: './appointments.component.html',
  styleUrl: './appointments.component.scss'
})
export class AppointmentsComponent implements OnInit{

  rowData?: Appointment[];
  columnDefs: any[] = [
    { headerName: 'Patient Name', field: 'patientName' },
    { headerName: 'Doctor Name', field: 'doctorName' },
    { headerName: 'Date/Time', field: 'appointmentTime' },
];
  constructor(private appointmentService:AppointmentsControllerService){}

  ngOnInit() {

    this.appointmentService.getAllAppointments().subscribe((data)=>{
      this.rowData=data;
    })
    
  }

}

