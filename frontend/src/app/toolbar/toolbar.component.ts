import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {

  title = "Univerzitet";
  isLoggedIn = false;
  public loggedUserUsername: String;
  private loggedUserRoles: String;
  public loggedUserType: String;

  private loggedInSubcription : Subscription;

  constructor(private authService: AuthService) { }

  ngOnInit() {
    this.isLoggedIn = this.authService.isLoggedIn();
    this.loggedInSubcription = this.authService.loggedInStatusChanged.subscribe(
      (status: boolean)=>{
        this.isLoggedIn = status;
        this.setUserForEditProfile();
      }
    );
    this.setUserForEditProfile();
  }

  setUserForEditProfile(){
    this.loggedUserUsername = this.authService.getCurrentUser();
    this.loggedUserRoles = this.authService.getCurrentRoles();
    this.loggedUserType = this.loggedUserRoles;
  }

  onLogout(){
    this.authService.logout();
  }
  
  ngOnDestroy(){
    this.loggedInSubcription.unsubscribe();
  }

}
