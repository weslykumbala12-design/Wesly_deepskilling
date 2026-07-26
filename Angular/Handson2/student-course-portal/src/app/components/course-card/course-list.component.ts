import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CourseCardComponent } from '../../components/course-card/course-card.component';

@Component({
selector:'app-course-list',
standalone:true,
imports:[
CommonModule,
CourseCardComponent
],
templateUrl:'./course-list.component.html',
})
export class CourseListComponent{

selectedCourseId=0;

courses=[

{
id:1,
name:'Angular',
code:'ANG101',
credits:4
},

{
id:2,
name:'React',
code:'REA102',
credits:3
},

{
id:3,
name:'Java',
code:'JAVA201',
credits:4
},

{
id:4,
name:'Python',
code:'PY301',
credits:3
},

{
id:5,
name:'Spring Boot',
code:'SB401',
credits:4
}

];

onEnroll(courseId:number){

console.log(
'Enrolling in course : '+courseId
);

this.selectedCourseId=courseId;

}

}