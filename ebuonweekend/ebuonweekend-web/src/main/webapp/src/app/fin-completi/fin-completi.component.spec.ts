/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { FinCompletiComponent } from './fin-completi.component';

describe('FinCompletiComponent', () => {
  let component: FinCompletiComponent;
  let fixture: ComponentFixture<FinCompletiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FinCompletiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FinCompletiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
