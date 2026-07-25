import CalculateScore from "./Components/CalculateScore";

function App() {
  return (
    <div>
      <CalculateScore
        name="John Wesley"
        school="ABC Public School"
        total={500}
        goal={5}
      />
    </div>
  );
}

export default App;