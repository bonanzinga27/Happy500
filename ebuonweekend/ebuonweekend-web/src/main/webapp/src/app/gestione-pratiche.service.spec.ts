/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { GestionePraticheService } from './gestione-pratiche.service';

describe('GestionePraticheService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GestionePraticheService]
    });
  });

  it('should ...', inject([GestionePraticheService], (service: GestionePraticheService) => {
    expect(service).toBeTruthy();
  }));
});
