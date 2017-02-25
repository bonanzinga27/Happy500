/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { AccountServiceService } from './account-service.service';

describe('AccountServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AccountServiceService]
    });
  });

  it('should ...', inject([AccountServiceService], (service: AccountServiceService) => {
    expect(service).toBeTruthy();
  }));
});
