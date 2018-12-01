import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Comic } from '../models/Comic';
import { ComiclysmService } from '../services/comiclysm.service';

@Component({
  selector: 'app-side-bar-filter',
  templateUrl: './side-bar-filter.component.html',
  styleUrls: ['./side-bar-filter.component.css']
})
export class SideBarFilterComponent implements OnInit {

  @Output() filterByName: EventEmitter<string> = new EventEmitter();
  @Output() filterByWriter: EventEmitter<string> = new EventEmitter();
  @Output() filterByArtist: EventEmitter<string> = new EventEmitter();
  @Output() filterByYear: EventEmitter<string> = new EventEmitter();

  filteredComicsListSubject = new BehaviorSubject<Comic[]>(null);
  filteredComicsList: Comic[];
  comicNameInput: string;
  comicWriterInput: string;
  comicArtistInput: string;
  comicDateInput: string;

  constructor(private service: ComiclysmService) { }

  ngOnInit() {
  }

  getFilteredComicList() {
    return this.filteredComicsListSubject.asObservable();
  }

  callFilterByName() {
    this.comicNameInput = this.comicNameInput.replace(' ', '_');
    this.filterByName.emit(this.comicNameInput);
   // this.comicDateInput.replace()
  }
  callFilterByWriter() {
    this.comicWriterInput = this.comicWriterInput.replace(' ', '_');
    this.filterByWriter.emit(this.comicWriterInput);
  }

  callFilterByArtist() {
    this.comicArtistInput = this.comicArtistInput.replace(' ', '_');
    this.filterByArtist.emit(this.comicArtistInput);
  }

  callFilterByYear() {
    this.comicDateInput = this.comicDateInput.replace(' ', '_');
    this.filterByYear.emit(this.comicDateInput);
  }
}
