import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { FakultetDTO } from 'src/app/models/fakultet.model';
import { StudijskiProgram } from 'src/app/models/studijski-program.model';
import { UpisGodineDTO } from 'src/app/models/upis-godine-dto.model';
import { FakultetService } from 'src/app/services/fakultet.service';
import { SnackBarService } from 'src/app/util/services/snack-bar.service';

@Component({
  selector: 'app-studijski-programi',
  templateUrl: './studijski-programi.component.html',
  styleUrls: ['./studijski-programi.component.css']
})
export class StudijskiProgramiComponent implements OnInit {

  @Input() public parrentForm: FormGroup;
  public studijskiProgramForm : FormGroup;
  public upisGodine: UpisGodineDTO = new UpisGodineDTO();
  public fakulteti: FakultetDTO[] = [];
  public studijskiProgrami: StudijskiProgram[] = [];
  private edit = false;
  private id: string;

  constructor(private fb: FormBuilder, private route: ActivatedRoute, private fakultetServis: FakultetService, private snackBarService: SnackBarService) { }

  ngOnInit() {
    this.studijskiProgramForm = this.fb.group({
      fakultet: ['', {validators: [Validators.required]}],
      studijskiProgram: ['', {validators: [Validators.required]}],
      brojIndeksa: ['', {validators: [Validators.required]}],
      espbStecenoUkupno: ['', {validators: [Validators.required]}],
      godinaUpisa: ['', {validators: [Validators.required]}]
    });

    this.parrentForm.addControl("upis", this.studijskiProgramForm);
    this.edit = true;

    this.getFakulteti();
  }

  getFakulteti(){
    this.fakultetServis.getFakulteti().subscribe((data: FakultetDTO[]) => {
      this.fakulteti = data;
    });
  }

  getStudijskiProgramiByFakultet(fakultetId: String){
    this.fakultetServis.getStudijskiProgramiByFakultet(fakultetId).subscribe(data => {
      this.studijskiProgrami = data;
    });
  }

}
