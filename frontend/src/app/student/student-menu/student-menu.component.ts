import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-student-menu',
  templateUrl: './student-menu.component.html',
  styleUrls: ['./student-menu.component.css']
})
export class StudentMenuComponent implements OnInit {

  constructor(public authServis :  AuthService){}

  public user : String;

  ngOnInit(){
    this.user = this.authServis.getCurrentUser();
  }

}
