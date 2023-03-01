import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { FakultetDTO } from '../models/fakultet.model';
import { StudijskiProgram } from '../models/studijski-program.model';

@Injectable({
  providedIn: 'root'
})
export class FakultetService {

  private fakultetUrl = "http://localhost:8080/fakultet";

  constructor(private http: HttpClient) {}

  getFakulteti(){
    return this.http.get<FakultetDTO[]>(this.fakultetUrl + `/svi`);
  }

  getStudijskiProgramiByFakultet(fakultetId: String){
    return this.http.get<StudijskiProgram[]>(this.fakultetUrl + `/${fakultetId}/svi-programi`);
  }
}
