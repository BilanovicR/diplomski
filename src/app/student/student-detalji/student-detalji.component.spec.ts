import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentDetaljiComponent } from './student-detalji.component';

describe('StudentDetaljiComponent', () => {
  let component: StudentDetaljiComponent;
  let fixture: ComponentFixture<StudentDetaljiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentDetaljiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentDetaljiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
