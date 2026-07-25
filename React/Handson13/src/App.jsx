import React from "react";
import BookDetails from "./BookDetails";
import BlogDetails from "./BlogDetails";
import CourseDetails from "./CourseDetails";
import "./App.css";

function App() {
  const showBook = true;
  const showBlog = true;
  const showCourse = true;

  return (
    <div className="container">
      <h1>Blogger App</h1>

      {/* Conditional Rendering using && */}
      {showBook && <BookDetails />}

      {/* Conditional Rendering using Ternary Operator */}
      {showBlog ? <BlogDetails /> : <h2>No Blogs Available</h2>}

      {/* Conditional Rendering using if-else */}
      {displayCourse(showCourse)}
    </div>
  );
}

function displayCourse(flag) {
  if (flag) {
    return <CourseDetails />;
  } else {
    return <h2>No Courses Available</h2>;
  }
}

export default App;