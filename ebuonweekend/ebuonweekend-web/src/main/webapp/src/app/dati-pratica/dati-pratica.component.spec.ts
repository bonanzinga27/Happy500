/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { DatiPraticaComponent } from './dati-pratica.component';

describe('DatiPraticaComponent', () => {
  let component: DatiPraticaComponent;
  let fixture: ComponentFixture<DatiPraticaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DatiPraticaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DatiPraticaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
