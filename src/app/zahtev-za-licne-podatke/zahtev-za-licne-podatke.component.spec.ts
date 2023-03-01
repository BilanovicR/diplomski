import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZahtevZaLicnePodatkeComponent } from './zahtev-za-licne-podatke.component';

describe('ZahtevZaLicnePodatkeComponent', () => {
  let component: ZahtevZaLicnePodatkeComponent;
  let fixture: ComponentFixture<ZahtevZaLicnePodatkeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZahtevZaLicnePodatkeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ZahtevZaLicnePodatkeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
