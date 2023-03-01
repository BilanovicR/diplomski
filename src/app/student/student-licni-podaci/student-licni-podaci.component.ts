import { Component, OnInit, Input, ViewEncapsulation } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MapeVrednosti } from 'src/app/util/mapirane-vrednosti';
import { mimeTypeValidator } from 'src/app/util/mime-type-validator.directive';
import { FileService } from 'src/app/util/services/file.service';
import { FormErrorService } from './../../util/services/form-error.service';

@Component({
  selector: 'app-student-licni-podaci',
  templateUrl: './student-licni-podaci.component.html',
  styleUrls: ['./student-licni-podaci.component.css'],
  encapsulation : ViewEncapsulation.None
})
export class StudentLicniPodaciComponent implements OnInit  {

  @Input() public parrentForm: FormGroup;
  public licniPodaciForm : FormGroup;
  imagePreview: string;
  bracniStatusi : Map<String, String> = MapeVrednosti.bracniStatusi;
  pol : Array<String> = new Array("Muški","Ženski");
  fileUrl : String;

  constructor(private fb: FormBuilder, public formError: FormErrorService, public fileServis : FileService) { }

  ngOnInit() {
    this.licniPodaciForm = this.fb.group({
      ime: ['', {validators: [Validators.required]}],
      prezime: ['', {validators: [Validators.required]}],
      imeRoditelja: ['', {validators: [Validators.required]}],
      email: [''],
      jmbg: [''],
      pol: ['', {validators: [Validators.required]}],
      datumRodjenja: ['', {validators: [Validators.required]}],
      mestoRodjenja: ['', {validators: [Validators.required]}],
      brojTelefona: ['', {validators: [Validators.required]}],
      brojPasosa: [''],
      prebivaliste: ['', {validators: [Validators.required]}],
      ulica: ['', {validators: [Validators.required]}],
      naselje: ['', {validators: [Validators.required]}],
      drzavljanstvo: ['', {validators: [Validators.required]}],
      nacionalnost: [''],
      bracniStatus: ['', {validators: [Validators.required]}],
      fotografijaURL: [''],
      fotografija: ['', {asyncValidators: [mimeTypeValidator]}]
    });

    this.parrentForm.addControl("licniPodaci", this.licniPodaciForm);
    this.fileUrl = this.fileServis.fileUrl;
    this.licniPodaciForm.get('fotografijaURL').setValue(this.fileServis.defaultStudentImageURL);
    this.fileUrl = this.fileServis.fileUrl;

  }

  onImagePicked(event: Event) {
    const file = (event.target as HTMLInputElement).files[0];
    if(file){
      this.licniPodaciForm.patchValue({ fotografija: file });
      this.licniPodaciForm.get("fotografija").updateValueAndValidity();
      const reader = new FileReader();
      reader.onload = () => {
        this.imagePreview = reader.result as string;
      };
      reader.readAsDataURL(file);
    }
  }

}

