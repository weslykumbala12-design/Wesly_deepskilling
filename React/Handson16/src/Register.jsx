import { useState } from "react";

function Register() {
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");

  const [nameError, setNameError] = useState("");
  const [emailError, setEmailError] = useState("");
  const [passwordError, setPasswordError] = useState("");

  // Event Handler
  const handleChange = (e) => {
    const { name, value } = e.target;

    if (name === "name") {
      setName(value);
      if (value.length < 5)
        setNameError("Name should have atleast 5 characters");
      else
        setNameError("");
    }

    if (name === "email") {
      setEmail(value);
      if (!(value.includes("@") && value.includes(".")))
        setEmailError("Email should contain @ and .");
      else
        setEmailError("");
    }

    if (name === "password") {
      setPassword(value);
      if (value.length < 8)
        setPasswordError("Password should have atleast 8 characters");
      else
        setPasswordError("");
    }
  };

  // Event Submit
  const handleSubmit = (e) => {
    e.preventDefault();

    if (
      name.length >= 5 &&
      email.includes("@") &&
      email.includes(".") &&
      password.length >= 8
    ) {
      alert("Registration Successful");
    } else {
      alert("Please enter valid details");
    }
  };

  return (
    <div style={{ textAlign: "center", marginTop: "50px" }}>
      <h2>Mail Registration</h2>

      <form onSubmit={handleSubmit}>
        <div>
          <label>Name : </label>
          <input
            type="text"
            name="name"
            value={name}
            onChange={handleChange}
          />
          <br />
          <span style={{ color: "red" }}>{nameError}</span>
        </div>

        <br />

        <div>
          <label>Email : </label>
          <input
            type="text"
            name="email"
            value={email}
            onChange={handleChange}
          />
          <br />
          <span style={{ color: "red" }}>{emailError}</span>
        </div>

        <br />

        <div>
          <label>Password : </label>
          <input
            type="password"
            name="password"
            value={password}
            onChange={handleChange}
          />
          <br />
          <span style={{ color: "red" }}>{passwordError}</span>
        </div>

        <br />

        <button type="submit">Register</button>
      </form>
    </div>
  );
}

export default Register;