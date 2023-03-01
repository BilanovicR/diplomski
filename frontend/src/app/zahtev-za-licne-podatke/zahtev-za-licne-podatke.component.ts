import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ZahtevZaLicnePodatkeService } from '../services/zahtev-za-licne-podatke.service';
import { FormErrorService } from '../util/services/form-error.service';
import {MatDialog, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { PregledZahtevaComponent } from './pregled-zahteva/pregled-zahteva.component';
import { ZahtevZaLicnePodatke } from '../models/zahtev-za-lp.model';
import { AuthService } from '../auth/auth.service';
import { MatTableDataSource } from '@angular/material/table';
import { SnackBarService } from '../util/services/snack-bar.service';

@Component({
  selector: 'app-zahtev-za-licne-podatke',
  templateUrl: './zahtev-za-licne-podatke.component.html',
  styleUrls: ['./zahtev-za-licne-podatke.component.css']
})
export class ZahtevZaLicnePodatkeComponent implements OnInit {

  vrstaZahteva: String[] = ["BRISANJE", "IZMENA", "PRISTUP"];

  zahtevForm :  FormGroup;
  zahtev :  ZahtevZaLicnePodatke = new ZahtevZaLicnePodatke(); 
  displayedColumns: String[] = ['no', 'vrstaZahteva', 'datumPodnosenja', 'komentar', 'datumFinalizacije'];
  dataSource = new MatTableDataSource<ZahtevZaLicnePodatke>();     
  constructor(private authService:AuthService,public dialog: MatDialog, private zahtevServis: ZahtevZaLicnePodatkeService, private fb: FormBuilder,public formError: FormErrorService, private snackBar: SnackBarService ){}

  ngOnInit(){
    this.dobaviZahteve();
  }

  openDialog(){
    if(this.zahtevForm.invalid) {
      this.formError.markFormGroupTouched(this.zahtevForm);
      return;
    }
    this.zahtev = this.zahtevForm.value;
    this.zahtev.datumPodnosenjaZahteva = new Date();
    this.zahtev.podnosilacZahteva = this.authService.getCurrentUser();
    this.zahtev.korisnikID = this.authService.getCurrentUser();

    let CurrentDialog =  this.dialog.open(PregledZahtevaComponent, {
      data: this.zahtev,
    });

    CurrentDialog.afterClosed().subscribe(result => {
      if (result){
        this.zahtevServis.addZahtev(result).subscribe(result => {
          this.snackBar.openSnackBar((result.statusText == 'OK') ? "Zahtev izmenjen": "Greška prilikom izmene", "X");
          this.dobaviZahteve();
        });
      }
    });

  }

  dobaviZahteve(){
    this.zahtevForm = this.fb.group({
      vrstaZahteva : ["", Validators.required],
      komentar : [""]
    });
    this.zahtevForm.patchValue(this.zahtev);
    this.zahtevServis.getZahteveByKorisnik(this.authService.getCurrentUser())
    .subscribe((data: ZahtevZaLicnePodatke[]) => {
      this.dataSource.data = data;
    });
  }

}
