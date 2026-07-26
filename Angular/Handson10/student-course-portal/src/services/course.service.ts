import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { map, tap, retry, catchError } from 'rxjs/operators';
import { Course } from '../model/course';

@Injectable({
  providedIn: 'root'
})
export class CourseService {

  private api = 'http://localhost:3000/courses';

  constructor(private http: HttpClient) {}

  getCourses(): Observable<Course[]> {

    return this.http.get<Course[]>(this.api).pipe(

      map(courses => courses.filter(c => c.credits > 0)),

      tap(courses =>
        console.log('Courses Loaded:', courses.length)
      ),

      retry(2),

      catchError(err => {
        console.error(err);

        return throwError(() =>
          new Error('Failed to load courses.')
        );
      })

    );

  }

  getCourseById(id:number){
    return this.http.get<Course>(`${this.api}/${id}`);
  }

  createCourse(course:Omit<Course,'id'>){
    return this.http.post<Course>(this.api,course);
  }

  updateCourse(id:number,course:Course){
    return this.http.put<Course>(`${this.api}/${id}`,course);
  }

  deleteCourse(id:number){
    return this.http.delete(`${this.api}/${id}`);
  }

}