/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { FinIncompletiComponent } from './fin-incompleti.component';

describe('FinIncompletiComponent', () => {
  let component: FinIncompletiComponent;
  let fixture: ComponentFixture<FinIncompletiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinIncompletiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinIncompletiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
