import React from "react";

function GuestPage() {
  const flights = [
    {
      flightNo: "AI101",
      from: "Hyderabad",
      to: "Delhi",
      price: "₹5,500"
    },
    {
      flightNo: "6E205",
      from: "Chennai",
      to: "Mumbai",
      price: "₹4,200"
    },
    {
      flightNo: "UK812",
      from: "Bangalore",
      to: "Kolkata",
      price: "₹6,000"
    }
  ];

  return (
    <div>
      <h2>Guest Page</h2>

      <p>You can browse available flights.</p>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Flight No</th>
            <th>From</th>
            <th>To</th>
            <th>Fare</th>
          </tr>
        </thead>

        <tbody>
          {flights.map((flight, index) => (
            <tr key={index}>
              <td>{flight.flightNo}</td>
              <td>{flight.from}</td>
              <td>{flight.to}</td>
              <td>{flight.price}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <h3>Please Login to Book Tickets.</h3>
    </div>
  );
}

export default GuestPage;