import { Component, Inject, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { ZahtevZaLicnePodatke } from 'src/app/models/zahtev-za-lp.model';

@Component({
  selector: 'app-izmena-zahteva',
  templateUrl: './izmena-zahteva.component.html',
  styleUrls: ['./izmena-zahteva.component.css']
})
export class IzmenaZahtevaComponent implements OnInit {

  public zahtevForm : FormGroup;
  public zahtev : ZahtevZaLicnePodatke;
  public zahtevZakljucen : Boolean = false;

  constructor(@Inject(MAT_DIALOG_DATA) public data: ZahtevZaLicnePodatke,private fb: FormBuilder, public dialogRef: MatDialogRef<IzmenaZahtevaComponent>) { }

  ngOnInit() {
    this.zahtevForm = this.fb.group({
      vrstaZahteva: [''],
      datumPodnosenjaZahteva: [''],
      datumFinalizacijeZahteva: [''],
      komentar: [''],
      podnosilacZahteva: [''],
      korisnikID: [''],
      id: ['']
    });

    this.zahtevForm.patchValue(this.data);
    this.zahtevZakljucen = (this.data.datumFinalizacijeZahteva != null) ? true : false;
  }

  sacuvaj(){
    this.zahtev = this.zahtevForm.value;
    this.dialogRef.close(this.zahtev);
  }
  zakljuci(){
    this.zahtev = this.zahtevForm.value;
    this.zahtev.datumFinalizacijeZahteva = new Date();
    this.dialogRef.close(this.zahtev);
  }

  onNoClick(): void {
    this.dialogRef.close();
  }

}
