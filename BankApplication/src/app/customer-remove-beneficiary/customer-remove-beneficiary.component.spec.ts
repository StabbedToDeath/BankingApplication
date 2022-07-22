import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerRemoveBeneficiaryComponent } from './customer-remove-beneficiary.component';

describe('CustomerRemoveBeneficiaryComponent', () => {
  let component: CustomerRemoveBeneficiaryComponent;
  let fixture: ComponentFixture<CustomerRemoveBeneficiaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerRemoveBeneficiaryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerRemoveBeneficiaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
