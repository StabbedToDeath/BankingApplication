import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerAddBeneficiaryComponent } from './customer-add-beneficiary.component';

describe('CustomerAddBeneficiaryComponent', () => {
  let component: CustomerAddBeneficiaryComponent;
  let fixture: ComponentFixture<CustomerAddBeneficiaryComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerAddBeneficiaryComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerAddBeneficiaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
