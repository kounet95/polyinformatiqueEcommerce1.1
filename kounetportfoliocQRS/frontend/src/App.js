import HomePage from "./pages/HomePage";
import ContactPage from "./pages/ContactPage";
import PricingPage from "./pages/PricingPage";
import ServicePage from "./pages/ServicePage";
import TeamPage from "./pages/TeamPage";
import BlogPage from "./pages/BlogPage";
import NavBarComponent from "./components/NavBarComponent";



import {BrowserRouter, useParams, useRoutes} from "react-router-dom";
import React from "react";
import BlogDetailsPage from "./pages/BlogDetailsPage";
import BlogFormPage from "./pages/BlogFormPage";
import SignInPage from "./pages/SignInPage";
import SignUpPage from "./pages/SignUpPage";
import ForgotPasswordPage from "./pages/ForgotPasswordPage";

function App() {
    const routes = useRoutes([
        { path: '/', element: <HomePage /> },
        { path: '/contact', element: <ContactPage /> },
        { path: '/pricing', element: <PricingPage /> },
        { path: '/services', element: <ServicePage /> },
        { path: '/team', element: <TeamPage /> },
        { path: '/blog', element: <BlogPage /> },
        { path: '/blog/:id', element: <BlogDetailWithId /> },
        { path: '/blog/new', element: <BlogFormPage /> },
        { path: '/signin', element: <SignInPage /> },
        { path: '/signup', element: <SignUpPage /> },
        { path: '/forgotten', element: <ForgotPasswordPage /> },

    ]);

    return routes;
}

const BlogDetailWithId = () => {
    const { id } = useParams()
    return (
        <BlogDetailsPage id={id}/>
    )
}
export default function Root() {
    return (
        <>
            <NavBarComponent />
            <BrowserRouter>
                <main className="main">
                    <App/>
                </main>
            </BrowserRouter>
        </>
);
}