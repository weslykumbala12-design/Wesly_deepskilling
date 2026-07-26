import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CourseService } from '../../../services/course.service';
import { Course } from '../../../model/course';

@Component({
  selector:'app-course-list',
  standalone:true,
  imports:[CommonModule],
  templateUrl:'./course-list.component.html'
})

export class CourseListComponent implements OnInit{

  courses:Course[]=[];

  errorMessage='';

  isLoading=true;

  constructor(private courseService:CourseService){}

  ngOnInit(){

    this.loadCourses();

  }

  loadCourses(){

    this.courseService.getCourses().subscribe({

      next:data=>{

        this.courses=data;

        this.isLoading=false;

      },

      error:error=>{

        this.errorMessage=error.message;

        this.isLoading=false;

      }

    });

  }

  addCourse(){

    const course={

      title:'NodeJS',

      credits:4

    };

    this.courseService.createCourse(course).subscribe(()=>{

      this.loadCourses();

    });

  }

  updateCourse(){

    const course={

      id:1,

      title:'Angular 20',

      credits:5

    };

    this.courseService.updateCourse(1,course).subscribe(()=>{

      this.loadCourses();

    });

  }

  deleteCourse(id:number){

    this.courseService.deleteCourse(id).subscribe(()=>{

      this.loadCourses();

    });

  }

}