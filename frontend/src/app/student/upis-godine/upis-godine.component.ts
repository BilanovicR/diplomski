import { Component, OnInit } from '@angular/core';
import { AuthService } from '../../auth/auth.service';
import { UpisGodineDTO } from '../../models/upis-godine-dto.model';
import { UpisGodineService } from '../../services/upis-godine.service';

@Component({
  selector: 'app-upis-godine',
  templateUrl: './upis-godine.component.html',
  styleUrls: ['./upis-godine.component.css']
})
export class UpisGodineComponent implements OnInit{

  upisi: UpisGodineDTO[] = [];

  constructor(private upisService: UpisGodineService, private authService: AuthService) { }

  ngOnInit() {
    let loggedUser = this.authService.getCurrentUser();
    if (loggedUser) {
      this.getUpisi(loggedUser);
    }
  }

  getUpisi(username: string){
    this.upisService.getUpisiByStudent(username).subscribe((data : UpisGodineDTO[]) => {
      this.upisi = data;
    });
  }

}
