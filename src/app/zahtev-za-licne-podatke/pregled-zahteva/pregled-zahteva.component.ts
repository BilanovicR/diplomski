import { Component, Inject } from '@angular/core';
import { MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material/dialog';
import { ZahtevZaLicnePodatke } from 'src/app/models/zahtev-za-lp.model';

@Component({
  selector: 'app-pregled-zahteva',
  templateUrl: './pregled-zahteva.component.html',
  styleUrls: ['./pregled-zahteva.component.css']
})
export class PregledZahtevaComponent {

  constructor(@Inject(MAT_DIALOG_DATA) public data: ZahtevZaLicnePodatke, public dialogRef: MatDialogRef<PregledZahtevaComponent>) {}

  onNoClick(): void {
    this.dialogRef.close();
  }

}
