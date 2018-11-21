import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturedHeroesHomeComponent } from './featured-heroes-home.component';

describe('FeaturedHeroesHomeComponent', () => {
  let component: FeaturedHeroesHomeComponent;
  let fixture: ComponentFixture<FeaturedHeroesHomeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeaturedHeroesHomeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeaturedHeroesHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
