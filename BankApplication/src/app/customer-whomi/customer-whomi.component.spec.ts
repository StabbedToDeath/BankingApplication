import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerWhomiComponent } from './customer-whomi.component';

describe('CustomerWhomiComponent', () => {
  let component: CustomerWhomiComponent;
  let fixture: ComponentFixture<CustomerWhomiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerWhomiComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerWhomiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
