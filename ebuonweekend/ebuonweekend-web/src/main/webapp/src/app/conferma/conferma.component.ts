import { Component, OnInit } from '@angular/core';
import {FileUploaderComponent} from "../file-uploader/file-uploader.component";


@Component({
  selector: 'app-conferma',
  templateUrl: './conferma.component.html',
  styleUrls: ['./conferma.component.css'],
  providers: [FileUploaderComponent]
})
export class ConfermaComponent implements OnInit {

  isFinished = 1;
  constructor() { }

  ngOnInit() {
  }

}
