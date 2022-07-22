import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerWHOMIComponent } from './customer-whomi.component';

describe('CustomerWHOMIComponent', () => {
  let component: CustomerWHOMIComponent;
  let fixture: ComponentFixture<CustomerWHOMIComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerWHOMIComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerWHOMIComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
