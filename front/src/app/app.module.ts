import { NgModule } from '@angular/core';
import { BrowserModule, provideClientHydration } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AppointmentsControllerService, BASE_PATH } from '../../dist/apiclient/src';
import { AppointmentsComponent } from './appointments/appointments.component';
import { AddAppointmentComponent } from './add-appointment/add-appointment.component';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';
import { AgGridAngular } from '@ag-grid-community/angular';


@NgModule({
  declarations: [
    AppComponent,
    AppointmentsComponent,
    AddAppointmentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AgGridAngular
  ],
  providers: [
    provideClientHydration(),
    AppointmentsControllerService,
    {provide:BASE_PATH , useValue: "http://localhost:8080"}
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
