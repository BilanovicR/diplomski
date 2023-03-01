import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { NoviUpisGodine } from '../models/noviUpisGodineDTO.model';
import { UpisGodineDTO } from '../models/upis-godine-dto.model';

@Injectable({
  providedIn: 'root'
})
export class UpisGodineService {

  private upisGodineUrl = "http://localhost:8080/upis";

  constructor(private http: HttpClient) {}

  getUpisiByStudent(studentID){
    return this.http.get<UpisGodineDTO[]>(this.upisGodineUrl + `/sviUpisi/${studentID}`)
  }

  addUpisGodine(upis:NoviUpisGodine){
    return this.http.post<UpisGodineDTO>(this.upisGodineUrl + '/add', upis, { observe: 'response' });
  }
}
