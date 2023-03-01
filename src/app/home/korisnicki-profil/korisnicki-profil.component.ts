import { HttpResponse, HttpResponseBase } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormBuilder, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Korisnik } from 'src/app/models/korisnik.model';
import { MustMatch } from 'src/app/util/must-match-validator.directive';
import { FormErrorService } from 'src/app/util/services/form-error.service';
import { SnackBarService } from 'src/app/util/services/snack-bar.service';
import { KorisnikService } from './korisnik.service';

@Component({
  selector: 'app-korisnicki-profil',
  templateUrl: './korisnicki-profil.component.html',
  styleUrls: ['./korisnicki-profil.component.css']
})
export class KorisnickiProfilComponent implements OnInit{

  public korisnickiProfilForm : FormGroup;
  korisnickoIme : String = this.route.snapshot.paramMap.get("username");
  korisnik : Korisnik;
  sifraIzmenjena : boolean;

  constructor(private fb: FormBuilder,  private route: ActivatedRoute, public formError: FormErrorService, public korisnikServis: KorisnikService, public snackBar : SnackBarService) {
  }

  ngOnInit() {
    this.korisnickiProfilForm = this.fb.group({
      korisnickoIme: ['', {validators: [Validators.required, Validators.minLength(3)]}],
      email: ['', {validators: [Validators.required, Validators.email]}],
      sifra: ['', {validators: [Validators.required, Validators.minLength(8)]}],
      confirmPassword: [''],
    },
    {
      validators: [MustMatch('sifra', 'confirmPassword')]
    });

    if(this.korisnickoIme){
      this.korisnikServis.getKorisnikByKorisnickoIme(this.korisnickoIme).subscribe((data: Korisnik) => {
        this.korisnik = data;
        this.sifraIzmenjena = false;
        this.korisnickiProfilForm.patchValue({korisnickoIme: data.korisnickoIme, email:data.email});
      });
    }    
  }

  izmeniSifru(){
    if (this.korisnickiProfilForm.invalid) {
      this.formError.markFormGroupTouched(this.korisnickiProfilForm);
    } else {
      this.sifraIzmenjena = true;
      const std = this.korisnickiProfilForm.value;
      this.korisnik.sifra = std.sifra;
      this.korisnikServis.updateKorisnik(this.korisnik).subscribe((data : HttpResponseBase)=>{
        this.sifraIzmenjena = (data.status ==200) ? true : false;
        this.snackBar.openSnackBar((data.status ==200) ? "Šifra izmenjena" : "Greška!", "X");        
      });      
    }
  }

  checkMatchValidator(field1: string, field2: string) {
    return function (frm) {
      let field1Value = frm.get(field1).value;
      let field2Value = frm.get(field2).value;
  
      if (field1Value !== '' && field1Value !== field2Value) {
        return 'Šifre se ne poklapaju';
      }
      return null;
    }
  }

}
