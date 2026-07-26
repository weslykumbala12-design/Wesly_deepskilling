import React, { Component } from "react";

class Getuser extends Component {
  constructor(props) {
    super(props);

    this.state = {
      title: "",
      firstname: "",
      image: "",
    };
  }

  async componentDidMount() {
    const response = await fetch("https://api.randomuser.me/");
    const data = await response.json();

    this.setState({
      title: data.results[0].name.title,
      firstname: data.results[0].name.first,
      image: data.results[0].picture.large,
    });
  }

  render() {
    return (
      <div style={{ textAlign: "center", marginTop: "50px" }}>
        <h2>Random User Details</h2>

        <img
          src={this.state.image}
          alt="User"
          width="150"
          height="150"
        />

        <h3>Title: {this.state.title}</h3>
        <h3>First Name: {this.state.firstname}</h3>
      </div>
    );
  }
}

export default Getuser;