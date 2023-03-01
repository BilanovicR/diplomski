import { TestBed } from '@angular/core/testing';

import { UpisGodineService } from './upis-godine.service';

describe('UpisGodineService', () => {
  let service: UpisGodineService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpisGodineService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
