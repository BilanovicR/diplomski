import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MapeVrednosti } from 'src/app/util/mapirane-vrednosti';
import { FormErrorService } from './../../util/services/form-error.service';


@Component({
  selector: 'app-student-detalji',
  templateUrl: './student-detalji.component.html',
  styleUrls: ['./student-detalji.component.css']
})
export class StudentDetaljiComponent {

  @Input() public parrentForm: FormGroup;
  @Input() public loggedUserRole: String;
  public detaljiForm : FormGroup;

  nacinFinansiranja : Map<String, String> = MapeVrednosti.nacinFinansiranja;  
  tipSmestaja : Map<String, String> = MapeVrednosti.tipSmestaja;
  izvorSredstava : Map<String, String> = MapeVrednosti.izvorSredstava;
  izdrzavaDrugaLica : Map<String, String> = MapeVrednosti.izdrzavaDrugaLica;
  skolskaSprema : Map<String, String> = MapeVrednosti.skolskaSprema;
  vidPodrske : Map<String, String> = MapeVrednosti.vidPodrske;  

  constructor(private fb: FormBuilder, public formError: FormErrorService) { }

  ngOnInit() {
    this.detaljiForm = this.fb.group({
      mestoStanovanja: ['', {validators: [Validators.required]}],
      tipSmestaja: ['', {validators: [Validators.required]}],
      izvorSredstava: ['', {validators: [Validators.required]}],
      glavniIzvorSredstava: ['', {validators: [Validators.required]}],
      jeZaposlen: [Boolean],
      izdrzavaDrugaLica: ['', {validators: [Validators.required]}],
      izdrzavalacJeZaposlen: [Boolean],
      zanimanjeIzdrzavaoca: [''],
      skolskaSpremaOca: ['', {validators: [Validators.required]}],
      skolskaSpremaMajke: ['', {validators: [Validators.required]}],
      nacinFinansiranja: ['', {validators: [Validators.required]}],
      istaVrstaStudijaNaDrugomFakultetu: [Boolean],
      drugiFakultet: [''],
      jeDiplomirao: [''],
      godinaZavrsetkaDrugogFakulteta: [''],
      drzavaZavrsetkaDrugogFakulteta: [''],
      potrebanVidPodrske: ['', {validators: [Validators.required]}]
    });

    this.parrentForm.addControl("detalji", this.detaljiForm);
  }

}
