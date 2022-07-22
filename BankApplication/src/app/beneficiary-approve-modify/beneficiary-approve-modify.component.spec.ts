import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeneficiaryApproveModifyComponent } from './beneficiary-approve-modify.component';

describe('BeneficiaryApproveModifyComponent', () => {
  let component: BeneficiaryApproveModifyComponent;
  let fixture: ComponentFixture<BeneficiaryApproveModifyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BeneficiaryApproveModifyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BeneficiaryApproveModifyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
