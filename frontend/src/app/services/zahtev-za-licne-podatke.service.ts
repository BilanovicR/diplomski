import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { ZahtevZaLicnePodatke } from '../models/zahtev-za-lp.model';

@Injectable({
  providedIn: 'root'
})
export class ZahtevZaLicnePodatkeService {

  private zahtevZaLPurl = "http://localhost:8080/zahtevi";

  constructor(private http: HttpClient) {}

  addZahtev(zahtev: ZahtevZaLicnePodatke){
    return this.http.post<ZahtevZaLicnePodatke>(this.zahtevZaLPurl + `/add`, zahtev, { observe: 'response' });
  }

  editZahtev(zahtev: ZahtevZaLicnePodatke, id:String){
    return this.http.put<ZahtevZaLicnePodatke>(this.zahtevZaLPurl + `/edit/${id}`, zahtev, { observe: 'response' });
  }

  getZahteveByKorisnik(korisnickoIme: String){
    return this.http.get<ZahtevZaLicnePodatke[]>(this.zahtevZaLPurl + `/korisnik/${korisnickoIme}`)
  }

  getAll(){
    return this.http.get<ZahtevZaLicnePodatke[]>(this.zahtevZaLPurl + `/svi`);
  }

}
