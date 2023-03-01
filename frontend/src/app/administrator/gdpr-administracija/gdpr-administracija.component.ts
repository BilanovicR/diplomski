import { Component, OnInit } from '@angular/core';
import { FormBuilder} from '@angular/forms';
import { ZahtevZaLicnePodatkeService } from '../../services/zahtev-za-licne-podatke.service';
import { FormErrorService } from '../../util/services/form-error.service';
import { MatDialog } from '@angular/material/dialog';
import { ZahtevZaLicnePodatke } from '../../models/zahtev-za-lp.model';
import { AuthService } from '../../auth/auth.service';
import { MatTableDataSource } from '@angular/material/table';
import { IzmenaZahtevaComponent } from '../izmena-zahteva/izmena-zahteva.component';
import { SnackBarService } from 'src/app/util/services/snack-bar.service';

@Component({
  selector: 'app-gdpr-administracija',
  templateUrl: './gdpr-administracija.component.html',
  styleUrls: ['./gdpr-administracija.component.css'],
})
export class GdprAdministracijaComponent implements OnInit {
  displayedColumns: String[] = [
    'no',
    'vrstaZahteva',
    'datumPodnosenja',
    'korisnik',
    'komentar',
    'datumFinalizacije',
    'izmeni',
  ];
  dataSource = new MatTableDataSource<ZahtevZaLicnePodatke>();
  zahtev: ZahtevZaLicnePodatke;

  constructor(
    private snackBar: SnackBarService,
    private authService: AuthService,
    public dialog: MatDialog,
    private zahtevServis: ZahtevZaLicnePodatkeService,
    private fb: FormBuilder,
    public formError: FormErrorService
  ) {}

  ngOnInit() {
    this.dobaviZahteve();
  }

  izmeni(zahtev: ZahtevZaLicnePodatke) {
    this.zahtev = zahtev;
    let CurrentDialog = this.dialog.open(IzmenaZahtevaComponent, {
      data: this.zahtev,
    });

    CurrentDialog.afterClosed().subscribe((result) => {
      if (result) {
        this.zahtevServis.editZahtev(result, zahtev.id).subscribe((result) => {
          this.snackBar.openSnackBar(
            result.statusText == 'OK' ? 'Zahtev izmenjen' : 'Greška prilikom izmene', 'X');
            this.dobaviZahteve();
        });
      }
    });
  }

  dobaviZahteve(){
    if (this.authService.getCurrentRoles() === 'administrator') {
      this.zahtevServis.getAll().subscribe((data: ZahtevZaLicnePodatke[]) => {
        this.dataSource.data = data;
      });
    }
  }
}
