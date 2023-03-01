import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class FileService {

  public fileUrl = "http://localhost:8080/file/";
  public defaultStudentImageURL = "images/student_images/default.png";

  constructor(private http: HttpClient) {}

}

