import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerCreateAccountComponent } from './customer-create-account.component';

describe('CustomerCreateAccountComponent', () => {
  let component: CustomerCreateAccountComponent;
  let fixture: ComponentFixture<CustomerCreateAccountComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerCreateAccountComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerCreateAccountComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
