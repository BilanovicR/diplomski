import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpRequest, HttpHandler } from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {

  intercept(req: HttpRequest<any>, next: HttpHandler) {
    const token = localStorage.getItem('token');
    if(token){
        const authRequest = req.clone({
            headers: req.headers.set("Authorization", token).set("Access-Control-Allow-Origin", "*")
        });
        return next.handle(authRequest);
    }

    return next.handle(req);
  }
}
