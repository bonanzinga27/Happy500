/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { PraticaService } from './pratica.service';

describe('PraticaService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PraticaService]
    });
  });

  it('should ...', inject([PraticaService], (service: PraticaService) => {
    expect(service).toBeTruthy();
  }));
});
