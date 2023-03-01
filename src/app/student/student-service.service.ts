import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StudentDTO } from '../models/student-dto.model';
import { StudentSV20DTO } from '../models/student-sv20-dto.model';

@Injectable({
  providedIn: 'root',
})
export class StudentServiceService {
  public studentUrl = 'http://localhost:8080/student';
  public studentSV20Url = 'http://localhost:8080/student/sv20';

  constructor(private http: HttpClient) {}

  getStudentByIndeks(indeks: String) {
    return this.http.get<StudentSV20DTO>(this.studentSV20Url + `/${indeks}`);
  }

  delete(brojIndeksa: String) {
    return this.http.delete(this.studentUrl + `/obrisi/${brojIndeksa}`, {
      observe: 'response',
    });
  }

  add(student: StudentSV20DTO, image: File) {
    const postData = new FormData();
    if (image) {
      postData.append('studentImage', image, image.name);
    }
    postData.append('student', JSON.stringify(student));
    
    return this.http.post(this.studentUrl + '/add', postData, {
      observe: 'response',
    });
  }

  update(studentId: String, student: StudentSV20DTO, image: File) {
    const putData = new FormData();
    if (image) {
      putData.append('studentImage', image, image.name);
    }
    putData.append('student', JSON.stringify(student));
    return this.http.put(this.studentUrl + `/update/${studentId}`, putData, {
      observe: 'response',
    });
  }

  searchStudents(queryParams: {}) {
    return this.http.get<StudentDTO[]>(this.studentUrl + `/search/`, {
      params: queryParams,
    });
  }
}
