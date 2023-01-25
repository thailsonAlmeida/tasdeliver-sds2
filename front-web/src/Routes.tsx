import { BrowserRouter, Route } from "react-router-dom";
import Home from "./Home";
import Orders from "./Orders";
import Navbar from "./Navbar";

function Routes() {
    return(
        <BrowserRouter>
            <Navbar />
            <Route component={ Home } path="/" exact />
            <Route component={ Orders } path="/orders" exact />
        </ BrowserRouter>
    )
}

export default Routes;