import { BrowserRouter, Routes, Route, Link, Navigate } from "react-router-dom";

import Home from "./Home";
import TrainersList from "./TrainersList";
import TrainerDetails from "./TrainerDetails";

import "./App.css";

function App() {
    return (

        <BrowserRouter>

            <div className="container">

                <h1>Cognizant Academy</h1>

                <nav>

                    <Link to="/">Home</Link>

                    <Link to="/trainers"> Trainers</Link>

                </nav>

                <hr />

                <Routes>

                    <Route
                        path="/"
                        element={<Navigate to="/home" />}
                    />

                    <Route
                        path="/home"
                        element={<Home />}
                    />

                    <Route
                        path="/trainers"
                        element={<TrainersList />}
                    />

                    <Route
                        path="/trainers/:id"
                        element={<TrainerDetails />}
                    />

                </Routes>

            </div>

        </BrowserRouter>

    );
}

export default App;