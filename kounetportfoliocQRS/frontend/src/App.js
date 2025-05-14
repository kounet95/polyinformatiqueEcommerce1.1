import {BrowserRouter, Route, Routes, useRoutes} from "react-router-dom";
import React from "react";
import HomePage from "./pages/shop/HomePage";
import ContactPage from "./pages/website/ContactPage";
import PricingPage from "./pages/website/PricingPage";
import ServicePage from "./pages/website/ServicePage";
import TeamPage from "./pages/website/TeamPage";

import BlogDetailsPage from "./pages/website/BlogDetailsPage";
import BlogFormPage from "./pages/website/BlogFormPage";

import ForgotPasswordPage from "./pages/website/ForgotPasswordPage";
import DomainFormPage from "./pages/website/DomainFormPage";
import DomainPage from "./pages/website/DomainPage";
import BlogPage from "./pages/website/BlogPage";
import SignInSignUpPage from "./pages/SignInSignUpPage";
import CartPage from "./pages/shop/CartPage";
import DetailPage from "./pages/shop/DetailPage";

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
        { path: '/cart', element: <CartPage /> },
        { path: '/product-details', element: <DetailPage /> },

        { path: '/sign', element: <SignInSignUpPage /> },

        { path: '/forgotten', element: <ForgotPasswordPage /> },

    ]);

    return routes;
}

export default App
