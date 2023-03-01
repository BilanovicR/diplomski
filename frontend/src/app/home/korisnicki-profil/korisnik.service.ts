import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Korisnik } from 'src/app/models/korisnik.model';

@Injectable({
  providedIn: 'root'
})
export class KorisnikService {

  public korisnikURL = "http://localhost:8080/korisnik";

  constructor(private http: HttpClient) { }

  getKorisnikByKorisnickoIme( korisnickoIme : String){
    return this.http.get<Korisnik>(this.korisnikURL + `/${korisnickoIme}`);
  }

  updateKorisnik(korisnik : Korisnik){
  return this.http.put<HttpResponse<any>>(this.korisnikURL + `/izmeni/${korisnik.korisnickoIme}`, korisnik, { observe: 'response' });
  }
}
