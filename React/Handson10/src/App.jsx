import React from "react";
import "./App.css";
import officeImage from "./assets/office.jpg";

function App() {
  const office = {
    name: "Sky Tower Workspace",
    rent: 55000,
    address: "MG Road, Bangalore"
  };

  const officeList = [
    {
      name: "Sky Tower Workspace",
      rent: 55000,
      address: "MG Road, Bangalore"
    },
    {
      name: "Tech Park Offices",
      rent: 75000,
      address: "HITEC City, Hyderabad"
    },
    {
      name: "Business Hub",
      rent: 45000,
      address: "Anna Nagar, Chennai"
    },
    {
      name: "Corporate Plaza",
      rent: 90000,
      address: "Banjara Hills, Hyderabad"
    }
  ];

  return (
    <div className="container">

      <h1>Office Space Rental App</h1>

      <img
        src={officeImage}
        alt="Office Space"
        width="500"
        height="300"
      />

      <h2>Office Details</h2>

      <p><strong>Name:</strong> {office.name}</p>

      <p>
        <strong>Rent:</strong>
        <span
          style={{
            color: office.rent < 60000 ? "red" : "green"
          }}
        >
          ₹{office.rent}
        </span>
      </p>

      <p><strong>Address:</strong> {office.address}</p>

      <hr />

      <h2>Available Office Spaces</h2>

      {officeList.map((item, index) => (
        <div className="card" key={index}>

          <h3>{item.name}</h3>

          <p>
            <strong>Rent:</strong>
            <span
              style={{
                color: item.rent < 60000 ? "red" : "green"
              }}
            >
              ₹{item.rent}
            </span>
          </p>

          <p>
            <strong>Address:</strong> {item.address}
          </p>

        </div>
      ))}

    </div>
  );
}

export default App;