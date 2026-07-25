import React, { Component } from "react";

class ComplaintRegister extends Component {
  constructor(props) {
    super(props);

    this.state = {
      employeeName: "",
      complaint: "",
    };
  }

  handleChange = (event) => {
    this.setState({
      [event.target.name]: event.target.value,
    });
  };

  handleSubmit = (event) => {
    event.preventDefault();

    const referenceNo = Math.floor(Math.random() * 100000);

    alert(
      `Thanks ${this.state.employeeName}\nYour Complaint was Submitted.\nTransaction ID is: ${referenceNo}`
    );

    this.setState({
      employeeName: "",
      complaint: "",
    });
  };

  render() {
    return (
      <div className="container">
        <h2>Ticket Raising App</h2>

        <form onSubmit={this.handleSubmit}>
          <label>Employee Name:</label>
          <br />
          <input
            type="text"
            name="employeeName"
            value={this.state.employeeName}
            onChange={this.handleChange}
            required
          />

          <br />
          <br />

          <label>Complaint:</label>
          <br />
          <textarea
            name="complaint"
            rows="5"
            cols="30"
            value={this.state.complaint}
            onChange={this.handleChange}
            required
          ></textarea>

          <br />
          <br />

          <button type="submit">Submit</button>
        </form>
      </div>
    );
  }
}

export default ComplaintRegister;