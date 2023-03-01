import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { AuthService } from 'src/app/auth/auth.service';
import { NoviUpisGodine } from 'src/app/models/noviUpisGodineDTO.model';
import { StudentDetaljiDTO, StudentSV20DTO } from 'src/app/models/student-sv20-dto.model';
import { UpisGodineService } from 'src/app/services/upis-godine.service';
import { StudentServiceService } from 'src/app/student/student-service.service';
import { FormErrorService } from 'src/app/util/services/form-error.service';
import { SnackBarService } from 'src/app/util/services/snack-bar.service';

@Component({
  selector: 'app-upis-studenta',
  templateUrl: './upis-studenta.component.html',
  styleUrls: ['./upis-studenta.component.css'],
})
export class UpisStudentaComponent implements OnInit {
  public form: FormGroup;
  public student: StudentSV20DTO;
  public upisGodine: NoviUpisGodine;

  constructor(
    private studentServis: StudentServiceService,
    private authService: AuthService,
    private upisGodineServis: UpisGodineService,
    public formError: FormErrorService,
    public snackBar: SnackBarService
  ) {}

  ngOnInit() {
    this.form = new FormGroup({});
  }

  onSave() {
    if (this.form.invalid) {
      this.formError.markFormGroupTouched(this.form);
    } else {
      const std = this.form.value;
      delete std['licniPodaci']['fotografija'];
      this.student = {
        student: std.licniPodaci,
        skola: std.skola,
        detalji: new StudentDetaljiDTO(std.detalji),
      };
      this.student.student.brojIndeksa = std.upis.brojIndeksa;
      this.studentServis.add(this.student,this.form.get('licniPodaci').get('fotografija').value).subscribe((data) => {

        if (data.status == 201) {
          this.upisGodine = {
            espbStecenoUkupno: std.upis.espbStecenoUkupno,
            godinaUpisa: std.upis.godinaUpisa,
            studijskiProgramId: std.upis.studijskiProgram.id,
            fakultetId: std.upis.fakultet.id,
            brojIndeksa: std.upis.brojIndeksa,
          };

          this.upisGodineServis.addUpisGodine(this.upisGodine).subscribe((data) => {
              this.snackBar.openSnackBar(data.statusText == 'OK' ? 'Student je upisan' : 'Greška!', 'X');
          });
        }
      });
    }
  }
}
