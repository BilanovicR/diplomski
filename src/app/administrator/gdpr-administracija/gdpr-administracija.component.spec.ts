import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GdprAdministracijaComponent } from './gdpr-administracija.component';

describe('GdprAdministracijaComponent', () => {
  let component: GdprAdministracijaComponent;
  let fixture: ComponentFixture<GdprAdministracijaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GdprAdministracijaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GdprAdministracijaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
