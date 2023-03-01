import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpisGodineComponent } from './upis-godine.component';

describe('UpisGodineComponent', () => {
  let component: UpisGodineComponent;
  let fixture: ComponentFixture<UpisGodineComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpisGodineComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UpisGodineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
