import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { FormErrorService } from './../../util/services/form-error.service';

@Component({
  selector: 'app-student-skola',
  templateUrl: './student-skola.component.html',
  styleUrls: ['./student-skola.component.css']
})
export class StudentSkolaComponent implements OnInit {

  @Input() public parrentForm: FormGroup;
  public skolaForm : FormGroup;

  constructor(private fb: FormBuilder, public formError: FormErrorService) { }

  ngOnInit() {
    this.skolaForm = this.fb.group({
      "naziv": ['', {validators: [Validators.required]}],
      "vrstaSkole": ['', {validators: [Validators.required]}],
      "opstina": ['', {validators: [Validators.required]}],
      "grad": ['', {validators: [Validators.required]}],
      "drzava": ['', {validators: [Validators.required]}],
      "godinaZavrsetka": ['', {validators: [Validators.required]}]
    });

    this.parrentForm.addControl("skola", this.skolaForm);
  }



}
