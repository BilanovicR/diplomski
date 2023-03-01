import { Component, OnInit, OnDestroy } from '@angular/core';
import { AuthService } from './auth/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'diplomski';

  opened: boolean = true;
  roles : String;
  private roleSubcription : Subscription;

  constructor(private authService: AuthService) {}

  ngOnInit() {
    this.roles = this.authService.getCurrentRoles();
  }

  ngOnDestroy(){
    this.roleSubcription.unsubscribe();
  }

}
