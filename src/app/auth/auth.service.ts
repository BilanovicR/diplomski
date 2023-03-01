import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Router } from "@angular/router";
import { Subject } from 'rxjs';
import { SnackBarService } from '../util/services/snack-bar.service';
import jwtDecode from 'jwt-decode';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  loggedInStatusChanged = new Subject<boolean>();

  constructor(private http: HttpClient, private router: Router, private snackBarService: SnackBarService) {}

  login(username: string, password: string){
    this.http.post<{token: string}>("http://localhost:8080/login", {korisnickoIme: username, sifra: password}).subscribe(response =>{
      if(response.token){
        localStorage.setItem('token', response.token);
        this.getCurrentRoles();
        this.router.navigate(['/home']).then(() => {
          window.location.reload();
        });
        this.loggedInStatusChanged.next(true);
        this.snackBarService.openSnackBar("Welcome " + this.getCurrentUser() + "!", "X")
      }
    });
  }

  logout(){
    localStorage.removeItem('token');
    this.router.navigate(['/']).then(() => {
      window.location.reload();
    });
    this.loggedInStatusChanged.next(false);
  }

  getCurrentRoles(){
    const token = localStorage.getItem('token');
    var roles : string;
    if(token){
      var decodedToken = (jwtDecode(token) as any);
      if (decodedToken != null) {
        let roleObj = decodedToken.role[0];
        roles = roleObj.authority;
      }      
    }
    return roles;
  }

  getCurrentUser(){
    const token = localStorage.getItem('token');
    if(token){
      return (jwtDecode(token) as any).sub;
    }
    return null;
  }

  isLoggedIn(){
    if(localStorage.getItem('token')){
      return true;
    }
    return false;
  }

}
