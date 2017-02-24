/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { FormPraticheComponent } from './form-pratiche.component';

describe('FormPraticheComponent', () => {
  let component: FormPraticheComponent;
  let fixture: ComponentFixture<FormPraticheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormPraticheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormPraticheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
