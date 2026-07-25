import React from "react";

function IndianPlayers() {

  const players = [
    "Virat",
    "Rohit",
    "Gill",
    "Rahul",
    "Hardik",
    "Jadeja"
  ];

  const [odd1, even1, odd2, even2, odd3, even3] = players;

  const T20players = [
    "Virat",
    "Rohit",
    "Surya",
    "Hardik"
  ];

  const RanjiPlayers = [
    "Pujara",
    "Rahane",
    "Sarfaraz",
    "Iyer"
  ];

  const mergedPlayers = [...T20players, ...RanjiPlayers];

  return (
    <div>

      <h1>Odd Team Players</h1>

      <ul>
        <li>{odd1}</li>
        <li>{odd2}</li>
        <li>{odd3}</li>
      </ul>

      <h1>Even Team Players</h1>

      <ul>
        <li>{even1}</li>
        <li>{even2}</li>
        <li>{even3}</li>
      </ul>

      <h1>Merged Players</h1>

      <ul>
        {mergedPlayers.map((player, index) => (
          <li key={index}>{player}</li>
        ))}
      </ul>

    </div>
  );
}

export default IndianPlayers;