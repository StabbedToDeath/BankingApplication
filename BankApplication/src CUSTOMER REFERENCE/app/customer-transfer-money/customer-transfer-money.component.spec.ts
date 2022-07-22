import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerTransferMoneyComponent } from './customer-transfer-money.component';

describe('CustomerTransferMoneyComponent', () => {
  let component: CustomerTransferMoneyComponent;
  let fixture: ComponentFixture<CustomerTransferMoneyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerTransferMoneyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerTransferMoneyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
