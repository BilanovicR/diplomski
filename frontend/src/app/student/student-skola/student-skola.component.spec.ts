import { ComponentFixture, TestBed } from '@angular/core/testing';

import { StudentSkolaComponent } from './student-skola.component';

describe('StudentSkolaComponent', () => {
  let component: StudentSkolaComponent;
  let fixture: ComponentFixture<StudentSkolaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ StudentSkolaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(StudentSkolaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
