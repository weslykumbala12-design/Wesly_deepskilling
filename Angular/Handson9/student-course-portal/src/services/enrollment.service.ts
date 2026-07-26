import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


@Injectable({
providedIn:'root'
})
export class EnrollmentService{

private api="http://localhost:3000/enrollments";

constructor(private http:HttpClient){}

getStudentsByCourse(courseId:number){

return this.http.get<any[]>(`${this.api}?courseId=${courseId}`);

}

}