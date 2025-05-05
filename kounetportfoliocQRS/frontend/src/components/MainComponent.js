import React from 'react';
import {Route, Routes, useParams} from "react-router-dom"
import ContactPage from "../pages/ContactPage";
import HomePage from "../pages/HomePage";
import BlogPage from "../pages/BlogPage";
import PricingPage from "../pages/PricingPage";
import ServicePage from "../pages/ServicePage";
import TeamPage from "../pages/TeamPage";

const MainComponent = () => {
    return (
        <div>
            <h1> Home Page</h1>
            <Routes>
                <Route exact path="/home"    element={<HomePage/>}/>
                <Route exact path="/blog"    element={<BlogPage/>}/>
                <Route exact path="/contact"    element={<ContactPage/>}/>
                <Route exact path="/pricing"    element={<PricingPage/>}/>
                <Route exact path="/service"    element={<ServicePage/>}/>
                <Route exact path="/team"    element={<TeamPage/>}/>
            </Routes>
        </div>

    );
};

export default MainComponent;
