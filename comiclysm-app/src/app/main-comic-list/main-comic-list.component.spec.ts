import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MainComicListComponent } from './main-comic-list.component';

describe('MainComicListComponent', () => {
  let component: MainComicListComponent;
  let fixture: ComponentFixture<MainComicListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MainComicListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MainComicListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
