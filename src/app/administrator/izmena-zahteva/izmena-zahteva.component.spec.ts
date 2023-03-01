import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IzmenaZahtevaComponent } from './izmena-zahteva.component';

describe('IzmenaZahtevaComponent', () => {
  let component: IzmenaZahtevaComponent;
  let fixture: ComponentFixture<IzmenaZahtevaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IzmenaZahtevaComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(IzmenaZahtevaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
