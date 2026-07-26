import { Component, OnInit } from '@angular/core';
import {
  ReactiveFormsModule,
  FormBuilder,
  FormGroup,
  Validators,
  FormArray,
  FormControl,
  AbstractControl,
  ValidationErrors,
  AsyncValidatorFn
} from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-reactive-enrollment-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './reactive-enrollment-form.component.html',
  styleUrl: './reactive-enrollment-form.component.css'
})
export class ReactiveEnrollmentFormComponent implements OnInit {

  enrollForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit(): void {

    this.enrollForm = this.fb.group({

      studentName: [
        '',
        [Validators.required, Validators.minLength(3)]
      ],

      studentEmail: this.fb.control(
        '',
        [Validators.required, Validators.email],
        [this.simulateEmailCheck()]
      ),

      courseId: [
        '',
        [Validators.required, this.noCourseCode]
      ],

      preferredSemester: [
        'Odd',
        Validators.required
      ],

      agreeToTerms: [
        false,
        Validators.requiredTrue
      ],

      additionalCourses: this.fb.array([])

    });

  }

  // Custom Validator

  noCourseCode(control: AbstractControl): ValidationErrors | null {

    if (
      control.value &&
      control.value.startsWith('XX')
    ) {
      return {
        noCourseCode: true
      };
    }

    return null;

  }

  // Async Validator

  simulateEmailCheck(): AsyncValidatorFn {

    return (
      control: AbstractControl
    ): Promise<ValidationErrors | null> => {

      return new Promise(resolve => {

        setTimeout(() => {

          if (
            control.value &&
            control.value.includes('test@')
          ) {

            resolve({
              emailTaken: true
            });

          } else {

            resolve(null);

          }

        }, 800);

      });

    };

  }

  get additionalCourses(): FormArray<FormControl> {
  return this.enrollForm.get('additionalCourses') as FormArray<FormControl>;
}

  addCourse() {

    this.additionalCourses.push(

      new FormControl(
        '',
        Validators.required
      )

    );

  }

  removeCourse(index: number) {

    this.additionalCourses.removeAt(index);

  }

  submitForm() {

    console.log(this.enrollForm.value);

    console.log(this.enrollForm.getRawValue());

    alert("Enrollment Successful");

  }

}