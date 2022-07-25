import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ZsampleComponent } from './zsample.component';

describe('ZsampleComponent', () => {
  let component: ZsampleComponent;
  let fixture: ComponentFixture<ZsampleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ZsampleComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ZsampleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
