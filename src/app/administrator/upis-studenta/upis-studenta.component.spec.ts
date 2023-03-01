import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpisStudentaComponent } from './upis-studenta.component';

describe('UpisStudentaComponent', () => {
  let component: UpisStudentaComponent;
  let fixture: ComponentFixture<UpisStudentaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpisStudentaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpisStudentaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
