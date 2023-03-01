import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { StudentDTO } from 'src/app/models/student-dto.model';
import { StudentServiceService } from 'src/app/student/student-service.service';
import { FormErrorService } from 'src/app/util/services/form-error.service';

@Component({
  selector: 'app-pretraga-studenata',
  templateUrl: './pretraga-studenata.component.html',
  styleUrls: ['./pretraga-studenata.component.css']
})
export class PretragaStudenataComponent implements OnInit {

  students: StudentDTO[];
  studentDetailed: StudentDTO;
  public searchForm : FormGroup;
  displayedColumns: string[] = ['no', 'ime', 'prezime', 'email', 'brojIndeksa', 'prikaz'];
  dataSource = new MatTableDataSource<StudentDTO>();
  @ViewChild(MatPaginator) paginator: MatPaginator;
  
  constructor(private studentService: StudentServiceService, public formError: FormErrorService, private fb: FormBuilder) { }

  ngOnInit() {
    this.searchForm = this.fb.group({
      ime: [""],
      prezime: [""],
      brojIndeksa: [""]
    });

  }

  search() {
    let query = {};
    query = this.searchForm.value;
    this.studentService.searchStudents(query)
      .subscribe((data: StudentDTO[]) => {
        this.students = data;
        this.dataSource.data = data;
      });
  }

}
