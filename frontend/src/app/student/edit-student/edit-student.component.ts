import { Component, OnInit, ViewEncapsulation } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';
import {
  StudentDetalji,
  StudentDetaljiDTO,
  StudentSV20DTO,
} from 'src/app/models/student-sv20-dto.model';
import { StudentServiceService } from '../student-service.service';
import { FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { FormErrorService } from './../../util/services/form-error.service';
import { SnackBarService } from 'src/app/util/services/snack-bar.service';
import { HttpResponse } from '@angular/common/http';
import { ConfirmationDialogComponent } from '../../util/confirmation-dialog/confirmation-dialog.component';
import { MatDialog } from '@angular/material/dialog';

@Component({
  selector: 'app-edit-student',
  templateUrl: './edit-student.component.html',
  styleUrls: ['./edit-student.component.css'],
  encapsulation: ViewEncapsulation.None,
})
export class EditStudentComponent implements OnInit {
  edit = false;
  brojIndeksa = this.route.snapshot.paramMap.get("brojIndeksa");
  loggedUser = this.authService.getCurrentUser();
  loggedUserRole = this.authService.getCurrentRoles();
  private student: StudentSV20DTO;
  public form: FormGroup;
  constructor(
    private studentServis: StudentServiceService,
    private authService: AuthService,
    private route: ActivatedRoute,
    public formError: FormErrorService,
    public dialog: MatDialog,
    public snackBar : SnackBarService
  ) {}

  ngOnInit() {
    this.form = new FormGroup({});

    if (this.brojIndeksa) {
      this.getStudent(this.brojIndeksa);
      this.edit = true;
    } else {
      console.log('unknown username');
    }
  }

  getStudent(username: string) {
    this.studentServis
      .getStudentByIndeks(username)
      .subscribe((data: StudentSV20DTO) => {
        this.student = data;
        this.form.get('skola').patchValue(this.student.skola);
        if (this.student.detalji != null){
          this.form.get('detalji').patchValue(new StudentDetalji(this.student.detalji));
        } else {
          this.form.get('detalji').disable();
        }
        
        this.form.get('licniPodaci').patchValue(this.student.student);
      });
  }

  onSave() {
    if (this.form.invalid) {
      this.formError.markFormGroupTouched(this.form);
    } else {
      const std = this.form.value;
      delete std['licniPodaci']['fotografija'];

      this.edit = false;
      std.licniPodaci.id = this.student.student.id;
      std.detalji.id = this.student.detalji.id;
      std.skola.id = this.student.skola.id;
      this.student = {student : std.licniPodaci, skola : std.skola, detalji : new StudentDetaljiDTO(std.detalji)};
      this.student.student.jeDiplomirao = (std.detalji != null) ? std.detalji.jeDiplomirao : std.student.student.jeDiplomirao;
      delete std['detalji']['jeDiplomirao'];
      this.studentServis.update(this.student.student.id, this.student, this.form.get('licniPodaci').get('fotografija').value).subscribe((data)=>{
        this.edit = (data.status ==200) ? true : false;
        this.snackBar.openSnackBar((data.status ==200) ? "Podaci izmenjeni" : "Greška!", "X");        
      });
    }
  }

  delete(){
    const dialogRef = this.dialog.open(ConfirmationDialogComponent, {
      width: '250px',
      data: {naslov: "Obriši studenta", sadrzaj: "Da li želite da obrišete studenta?"}
    });

    dialogRef.afterClosed().subscribe(result => {
      if(result){
        this.studentServis.delete(this.brojIndeksa).subscribe((data)=>{
          this.snackBar.openSnackBar( (data.status == 200) ? "Detalji studenta obrisani" : "Greška prilikom brisanja" , "X");
        });
      }
    });
  }
}
