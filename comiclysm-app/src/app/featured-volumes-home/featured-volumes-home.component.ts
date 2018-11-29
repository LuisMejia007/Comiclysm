import { Component, OnInit } from '@angular/core';
import {Comic} from '../models/Comic';
import { ComiclysmService } from '../services/comiclysm.service';
@Component({
  selector: 'app-featured-volumes-home',
  templateUrl: './featured-volumes-home.component.html',
  styleUrls: ['./featured-volumes-home.component.css']
})
export class FeaturedVolumesHomeComponent implements OnInit {


  featuredVolumes: Comic[];
  constructor(private service: ComiclysmService) { }

  ngOnInit() {


  }

}
