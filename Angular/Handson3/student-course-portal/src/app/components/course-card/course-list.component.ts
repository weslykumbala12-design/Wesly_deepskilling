import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCardComponent } from '../../components/course-card/course-card.component';
import { HighlightDirective } from '../../directives/highlight.directive';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, CourseCardComponent,HighlightDirective],
  templateUrl: './course-list.component.html',
  styleUrl: './course-list.component.css'
})
export class CourseListComponent implements OnInit {

  isLoading = true;

  selectedCourseId = 0;

  courses = [
    {
      id: 1,
      name: 'Angular',
      code: 'ANG101',
      credits: 4,
      gradeStatus: 'passed',
      enrolled: false
    },
    {
      id: 2,
      name: 'React',
      code: 'REA102',
      credits: 3,
      gradeStatus: 'failed',
      enrolled: false
    },
    {
      id: 3,
      name: 'Java',
      code: 'JAVA201',
      credits: 4,
      gradeStatus: 'pending',
      enrolled: false
    },
    {
      id: 4,
      name: 'Python',
      code: 'PY301',
      credits: 3,
      gradeStatus: 'passed',
      enrolled: false
    },
    {
      id: 5,
      name: 'Spring Boot',
      code: 'SB401',
      credits: 4,
      gradeStatus: 'pending',
      enrolled: false
    }
  ];

  ngOnInit() {

    setTimeout(() => {
      this.isLoading = false;
    }, 1500);

  }

  onEnroll(courseId: number) {

    this.selectedCourseId = courseId;

    const course = this.courses.find(c => c.id === courseId);

    if (course) {
      course.enrolled = true;
    }

  }

  trackByCourseId(index: number, course: any) {
    return course.id;
  }

}