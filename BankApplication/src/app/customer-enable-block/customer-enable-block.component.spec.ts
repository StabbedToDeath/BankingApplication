import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerEnableBlockComponent } from './customer-enable-block.component';

describe('CustomerEnableBlockComponent', () => {
  let component: CustomerEnableBlockComponent;
  let fixture: ComponentFixture<CustomerEnableBlockComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerEnableBlockComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustomerEnableBlockComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
