import { TestBed } from '@angular/core/testing';

import { ZahtevZaLicnePodatkeService } from './zahtev-za-licne-podatke.service';

describe('ZahtevZaLicnePodatkeService', () => {
  let service: ZahtevZaLicnePodatkeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ZahtevZaLicnePodatkeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
