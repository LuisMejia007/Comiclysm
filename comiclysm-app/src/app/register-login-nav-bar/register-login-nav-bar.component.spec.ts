import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterLoginNavBarComponent } from './register-login-nav-bar.component';

describe('RegisterLoginNavBarComponent', () => {
  let component: RegisterLoginNavBarComponent;
  let fixture: ComponentFixture<RegisterLoginNavBarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterLoginNavBarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterLoginNavBarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
