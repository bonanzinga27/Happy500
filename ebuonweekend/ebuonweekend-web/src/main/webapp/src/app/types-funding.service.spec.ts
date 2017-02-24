/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { TypesFundingService } from './types-funding.service';

describe('TypesFundingService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [TypesFundingService]
    });
  });

  it('should ...', inject([TypesFundingService], (service: TypesFundingService) => {
    expect(service).toBeTruthy();
  }));
});
