import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FeaturedHeroesComponent } from './featured-heroes.component';

describe('FeaturedHeroesComponent', () => {
  let component: FeaturedHeroesComponent;
  let fixture: ComponentFixture<FeaturedHeroesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FeaturedHeroesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FeaturedHeroesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
