import { Component } from '@angular/core';
import { AppointmentsControllerService } from '../../dist/apiclient/src';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  constructor(private appointmentService: AppointmentsControllerService){

    this.appointmentService.getAllAppointments().subscribe((data)=>{
      console.log(data);
    })

  }


  title = 'front';
}
