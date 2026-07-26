import { Component, OnInit } from '@angular/core';
import { CourseService } from '../../../services/course.service';
import { Course } from '../../../model/course';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './course-list.component.html'
})

export class CourseListComponent implements OnInit{

    courses:Course[]=[];
    errorMessage='';
    isLoading=true;

    constructor(private courseService:CourseService){}

    ngOnInit(){

      this.courseService.getCourses().subscribe({

        next:(courses)=>{
          this.courses=courses;
        },

        error:(err)=>{
          this.errorMessage=err.message;
        },

        complete:()=>{
          this.isLoading=false;
        }

      });

    }

}