import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ApproveDisableComponent } from './approve-disable.component';

describe('ApproveDisableComponent', () => {
  let component: ApproveDisableComponent;
  let fixture: ComponentFixture<ApproveDisableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ApproveDisableComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ApproveDisableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
