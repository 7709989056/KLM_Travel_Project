import { TestBed } from '@angular/core/testing';

import { TravelfareServiceService } from './travelfare-service.service';

describe('TravelfareServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TravelfareServiceService = TestBed.get(TravelfareServiceService);
    expect(service).toBeTruthy();
  });
});
