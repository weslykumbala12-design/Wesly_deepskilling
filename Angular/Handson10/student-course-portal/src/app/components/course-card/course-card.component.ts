import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Course } from '../../../model/course';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports:[CommonModule],
  templateUrl:'./course-card.component.html'
})
export class CourseCardComponent {

  @Input()
  course!: Course;

  @Output()
  enrollRequested = new EventEmitter<number>();

  enroll() {
    this.enrollRequested.emit(this.course.id);
  }

}