import { Routes } from '@angular/router';
import { ReactiveEnrollmentFormComponent } from './pages/reactive-enrollment-form/reactive-enrollment-form.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'enroll-reactive',
    pathMatch: 'full'
  },
  {
    path: 'enroll-reactive',
    component: ReactiveEnrollmentFormComponent
  }
];