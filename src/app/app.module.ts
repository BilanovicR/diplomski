import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CommonModule } from '@angular/common';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HTTP_INTERCEPTORS } from '@angular/common/http';

import { LoginComponent } from './login/login.component';
import { AngMaterialModule } from './util/ang-material/ang-material.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { HomeComponent } from './home/home.component';
import { AdminMenuComponent } from './administrator/admin-menu/admin-menu.component';
import { StudentMenuComponent } from './student/student-menu/student-menu.component';
import { UpisGodineComponent } from './student/upis-godine/upis-godine.component';
import { AuthInterceptorService } from './auth/auth-interceptor.service';
import { EditStudentComponent } from './student/edit-student/edit-student.component';
import { StudentLicniPodaciComponent } from './student/student-licni-podaci/student-licni-podaci.component';
import { StudentSkolaComponent } from './student/student-skola/student-skola.component';
import { StudentDetaljiComponent } from './student/student-detalji/student-detalji.component';
import { MAT_FORM_FIELD_DEFAULT_OPTIONS } from '@angular/material/form-field';
import { KorisnickiProfilComponent } from './home/korisnicki-profil/korisnicki-profil.component';
import { PretragaStudenataComponent } from './administrator/pretraga-studenata/pretraga-studenata.component';
import { UpisStudentaComponent } from './administrator/upis-studenta/upis-studenta.component';
import { ZahtevZaLicnePodatkeComponent } from './zahtev-za-licne-podatke/zahtev-za-licne-podatke.component';
import { PregledZahtevaComponent } from './zahtev-za-licne-podatke/pregled-zahteva/pregled-zahteva.component';
import { StudijskiProgramiComponent } from './administrator/studijski-programi/studijski-programi.component';
import { GdprAdministracijaComponent } from './administrator/gdpr-administracija/gdpr-administracija.component';
import { IzmenaZahtevaComponent } from './administrator/izmena-zahteva/izmena-zahteva.component';
import { ConfirmationDialogComponent } from './util/confirmation-dialog/confirmation-dialog.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ToolbarComponent,
    HomeComponent,
    AdminMenuComponent,
    StudentMenuComponent,
    UpisGodineComponent,
    EditStudentComponent,
    StudentLicniPodaciComponent,
    StudentSkolaComponent,
    StudentDetaljiComponent,
    KorisnickiProfilComponent,
    PretragaStudenataComponent,
    UpisStudentaComponent,
    ZahtevZaLicnePodatkeComponent,
    PregledZahtevaComponent,
    StudijskiProgramiComponent,
    GdprAdministracijaComponent,
    IzmenaZahtevaComponent,
    ConfirmationDialogComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    AngMaterialModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    CommonModule
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true },
    {provide: MAT_FORM_FIELD_DEFAULT_OPTIONS, useValue: {appearance: 'outline'}}],
  bootstrap: [AppComponent]
})
export class AppModule { }
