import { TestBed, inject } from '@angular/core/testing';

import { ComiclysmService } from './comiclysm.service';

describe('ComiclysmService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ComiclysmService]
    });
  });

  it('should be created', inject([ComiclysmService], (service: ComiclysmService) => {
    expect(service).toBeTruthy();
  }));
});
