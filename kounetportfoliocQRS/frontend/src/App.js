import HomePage from "./pages/HomePage";
import ContactPage from "./pages/ContactPage";
import PricingPage from "./pages/PricingPage";
import ServicePage from "./pages/ServicePage";
import TeamPage from "./pages/TeamPage";
import PortfolioPage from "./pages/PortfolioPage";
import PortfolioDetailsPage from "./pages/PortfolioDetailsPage";
import ServicesDetailsPage from "./pages/ServicesDetailsPage";

import NavBarComponent from "./components/NavBarComponent";
import FooterComponent from "./components/FooterComponent";

import {BrowserRouter, Route, Routes} from "react-router-dom";
import React from "react";
import BlogDetailsPage from "./pages/BlogDetailsPage";
import BlogFormPage from "./pages/BlogFormPage";
import SignInPage from "./pages/SignInPage";
import SignUpPage from "./pages/SignUpPage";
import ForgotPasswordPage from "./pages/ForgotPasswordPage";
import HeaderComponent from "./components/HeaderComponent";
import BlogListComponent from "./components/BlogListComponent";

function App() {
    return(
       <BrowserRouter>
            <HeaderComponent/>
            <NavBarComponent/>
            <Routes>
                <Route path="/" element={<HomePage/>}/>
                <Route path="/contact" element={<ContactPage/>}/>
                <Route path="/pricing" element={<PricingPage/>}/>
                <Route path="/service" element={<ServicePage/>}/>
                <Route path="/services-details" element={<ServicesDetailsPage/>}/>
                <Route path="/team" element={<TeamPage/>}/>
                <Route path="/portfolio" element={<PortfolioPage/>}/>
                <Route path="/portfolio-details" element={<PortfolioDetailsPage/>}/>
                <Route path="/blog/new" element={<BlogFormPage/>}/>
                <Route path="/blog/:id" element={<BlogDetailsPage/>}/>
                <Route path="/blog" element={<BlogListComponent/>}/>
                <Route path="/signin" element={<SignInPage/>}/>
                <Route path="/signup" element={<SignUpPage/>}/>
                <Route path="/forgot-password" element={<ForgotPasswordPage/>}/>
            </Routes>
            <FooterComponent/>
        </BrowserRouter>
    );
}

export default App
