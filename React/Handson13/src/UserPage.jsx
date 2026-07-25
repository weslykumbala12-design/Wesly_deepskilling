import React from "react";

function UserPage() {
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

  const bookTicket = () => {
    alert("Ticket Booked Successfully!");
  };

  return (
    <div>
      <h2>User Page</h2>

      <p>Welcome! You can book flight tickets.</p>

      <table border="1" cellPadding="10">
        <thead>
          <tr>
            <th>Flight No</th>
            <th>From</th>
            <th>To</th>
            <th>Fare</th>
            <th>Action</th>
          </tr>
        </thead>

        <tbody>
          {flights.map((flight, index) => (
            <tr key={index}>
              <td>{flight.flightNo}</td>
              <td>{flight.from}</td>
              <td>{flight.to}</td>
              <td>{flight.price}</td>
              <td>
                <button onClick={bookTicket}>
                  Book Ticket
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default UserPage;