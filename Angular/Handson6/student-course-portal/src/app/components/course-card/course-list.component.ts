import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { Course } from '../../../models/course.model';
import { CourseService } from '../../services/course.service';
import { CourseCardComponent } from '../../components/course-card/course-card.component';

@Component({

  selector:'app-course-list',

  standalone:true,

  imports:[
    CommonModule,
    CourseCardComponent
  ],

  templateUrl:'./course-list.component.html',

  styleUrl:'./course-list.component.css'

})

export class CourseListComponent implements OnInit{

  courses:Course[]=[];

  constructor(private courseService:CourseService){}

  ngOnInit():void{

    this.courses=this.courseService.getCourses();

  }

  onEnroll(courseId:number){

    alert(

      "Enrolled in Course ID : "

      +courseId

    );

  }

}