import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { UpisGodineComponent } from './student/upis-godine/upis-godine.component';
import { EditStudentComponent } from './student/edit-student/edit-student.component';
import { KorisnickiProfilComponent } from './home/korisnicki-profil/korisnicki-profil.component';
import { ZahtevZaLicnePodatkeComponent } from './zahtev-za-licne-podatke/zahtev-za-licne-podatke.component';
import { UpisStudentaComponent } from './administrator/upis-studenta/upis-studenta.component';
import { PretragaStudenataComponent } from './administrator/pretraga-studenata/pretraga-studenata.component';
import { GdprAdministracijaComponent } from './administrator/gdpr-administracija/gdpr-administracija.component';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'upisiGodine', component: UpisGodineComponent },
  { path: 'korisnickiProfil/:username', component: KorisnickiProfilComponent },
  { path: 'student/sv20/:brojIndeksa', component: EditStudentComponent },
  { path: 'student/:brojIndeksa', component: EditStudentComponent },
  { path: 'zahtevZaLicnePodatke', component: ZahtevZaLicnePodatkeComponent },
  { path: 'pregledZahtevaZaLicnePodatke', component: GdprAdministracijaComponent },
  { path: 'upisStudenta', component: UpisStudentaComponent },
  { path: 'pretragaStudenata', component: PretragaStudenataComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
