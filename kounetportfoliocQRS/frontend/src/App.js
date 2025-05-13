import HomePage from "./pages/website/HomePage";
import ContactPage from "./pages/website/ContactPage";
import PricingPage from "./pages/website/PricingPage";
import ServicePage from "./pages/website/ServicePage";
import TeamPage from "./pages/website/TeamPage";


import {BrowserRouter, Route, Routes, useRoutes} from "react-router-dom";
import React from "react";
import BlogDetailsPage from "./pages/website/BlogDetailsPage";
import BlogFormPage from "./pages/website/BlogFormPage";
import SignInPage from "./pages/SignInPage";
import SignUpPage from "./pages/SignUpPage";
import ForgotPasswordPage from "./pages/website/ForgotPasswordPage";
import DomainFormPage from "./pages/website/DomainFormPage";
import DomainPage from "./pages/website/DomainPage";
import BlogPage from "./pages/website/BlogPage";

function App() {
    const routes = useRoutes([
        { path: '/', element: <HomePage /> },
        { path: '/contact', element: <ContactPage /> },
        { path: '/pricing', element: <PricingPage /> },
        { path: '/services', element: <ServicePage /> },
        { path: '/team', element: <TeamPage /> },
        { path: '/blog', element: <BlogPage /> },
        { path: '/blog/:id', element: <BlogDetailsPage /> },
        { path: '/blog/new', element: <BlogFormPage /> },
        { path: '/domain/new', element: <DomainFormPage /> },
        { path: '/domain', element: <DomainPage /> },
        { path: '/lecontinent', element: <PricingPage /> },

        { path: '/signin', element: <SignInPage /> },
        { path: '/signup', element: <SignUpPage /> },
        { path: '/forgotten', element: <ForgotPasswordPage /> },

    ]);

    return routes;
}

export default App
