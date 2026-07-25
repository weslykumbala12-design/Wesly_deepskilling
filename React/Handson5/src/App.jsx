import CohortDetails from "./components/color";

function App() {

  const cohorts = [
    {
      id: 1,
      name: "React Fundamentals",
      mentor: "John",
      startDate: "01-Jul-2026",
      currentStatus: "Ongoing",
      coach: "David",
      trainer: "Alex"
    },
    {
      id: 2,
      name: "Java Full Stack",
      mentor: "James",
      startDate: "15-Jun-2026",
      currentStatus: "Completed",
      coach: "Peter",
      trainer: "Robert"
    },
    {
      id: 3,
      name: "Spring Boot",
      mentor: "Steve",
      startDate: "10-May-2026",
      currentStatus: "Ongoing",
      coach: "Kevin",
      trainer: "Thomas"
    }
  ];

  return (
    <div>
      <h1 align="center">Academy Dashboard</h1>

      {
        cohorts.map((cohort) => (
          <CohortDetails
            key={cohort.id}
            cohort={cohort}
          />
        ))
      }

    </div>
  );
}

export default App;