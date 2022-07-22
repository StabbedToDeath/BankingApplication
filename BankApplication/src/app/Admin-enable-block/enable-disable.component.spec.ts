import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EnableDisableComponent } from './enable-disable.component';

describe('EnableDisableComponent', () => {
  let component: EnableDisableComponent;
  let fixture: ComponentFixture<EnableDisableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EnableDisableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EnableDisableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
