import React from "react";

function ListofPlayers() {

  const players = [
    { name: "Virat Kohli", score: 98 },
    { name: "Rohit Sharma", score: 82 },
    { name: "Shubman Gill", score: 65 },
    { name: "KL Rahul", score: 55 },
    { name: "Hardik Pandya", score: 74 },
    { name: "Ravindra Jadeja", score: 68 },
    { name: "MS Dhoni", score: 91 },
    { name: "Rishabh Pant", score: 60 },
    { name: "Surya Kumar", score: 88 },
    { name: "Bumrah", score: 48 },
    { name: "Mohammed Shami", score: 72 }
  ];

  const below70 = players.filter(player => player.score < 70);

  return (
    <div>
      <h1>List of Players</h1>

      <h2>All Players</h2>

      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>Name</th>
            <th>Score</th>
          </tr>
        </thead>

        <tbody>
          {players.map((player, index) => (
            <tr key={index}>
              <td>{player.name}</td>
              <td>{player.score}</td>
            </tr>
          ))}
        </tbody>
      </table>

      <br />

      <h2>Players with Score Below 70</h2>

      <table border="1" cellPadding="8">
        <thead>
          <tr>
            <th>Name</th>
            <th>Score</th>
          </tr>
        </thead>

        <tbody>
          {below70.map((player, index) => (
            <tr key={index}>
              <td>{player.name}</td>
              <td>{player.score}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ListofPlayers;