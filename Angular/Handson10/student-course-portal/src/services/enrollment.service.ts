import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn:'root'
})

export class EnrollmentService{

  constructor(private http:HttpClient){}

  getStudentsByCourse(id:number){

    return this.http.get<any[]>(

      `http://localhost:3000/enrollments?courseId=${id}`

    );

  }

}