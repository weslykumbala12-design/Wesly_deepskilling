import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Course } from '../model/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private api="http://localhost:3000/courses";

  constructor(private http:HttpClient){}

  getCourses():Observable<Course[]>{
    return this.http.get<Course[]>(this.api);
  }

  getCourseById(id:number):Observable<Course>{
    return this.http.get<Course>(`${this.api}/${id}`);
  }

  createCourse(course:Omit<Course,'id'>):Observable<Course>{
    return this.http.post<Course>(this.api,course);
  }

  updateCourse(id:number,course:Course):Observable<Course>{
    return this.http.put<Course>(`${this.api}/${id}`,course);
  }

  deleteCourse(id:number):Observable<any>{
    return this.http.delete(`${this.api}/${id}`);
  }

}