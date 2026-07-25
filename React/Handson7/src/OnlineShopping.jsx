import React, { Component } from "react";
import Cart from "./Cart";

class OnlineShopping extends Component {
  constructor() {
    super();

    this.items = [
      new Cart("Laptop", 65000),
      new Cart("Mobile", 25000),
      new Cart("Headphones", 3000),
      new Cart("Smart Watch", 12000),
      new Cart("Keyboard", 1500),
    ];
  }

  render() {
    return (
      <div className="container">
        <h1>Online Shopping Cart</h1>

        <table border="1" cellPadding="10">
          <thead>
            <tr>
              <th>S.No</th>
              <th>Item Name</th>
              <th>Price (₹)</th>
            </tr>
          </thead>

          <tbody>
            {this.items.map((item, index) => (
              <tr key={index}>
                <td>{index + 1}</td>
                <td>{item.itemname}</td>
                <td>{item.price}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default OnlineShopping;