import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentLicniPodaciComponent } from './student-licni-podaci.component';

describe('StudentLicniPodaciComponent', () => {
  let component: StudentLicniPodaciComponent;
  let fixture: ComponentFixture<StudentLicniPodaciComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentLicniPodaciComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentLicniPodaciComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
