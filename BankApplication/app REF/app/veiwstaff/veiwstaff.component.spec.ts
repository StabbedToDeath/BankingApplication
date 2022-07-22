import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeiwstaffComponent } from './veiwstaff.component';

describe('VeiwstaffComponent', () => {
  let component: VeiwstaffComponent;
  let fixture: ComponentFixture<VeiwstaffComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ VeiwstaffComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VeiwstaffComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
