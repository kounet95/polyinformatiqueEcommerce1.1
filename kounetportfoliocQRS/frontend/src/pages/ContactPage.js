import React from 'react';
import CommentFormComponent from '../components/CommentFormComponent';
import HeaderComponent from '../components/HeaderComponent';

const ContactPage = () => {
    return (
        <>
            <div className="page-title" data-aos="fade">
                <HeaderComponent title="Contact" />
                <nav className="breadcrumbs">
                    <div className="container">
                        <ol>
                        <li><a href="/">Home</a></li>
                        <li className="current">Contact</li>
                        </ol>
                    </div>
                </nav>
            </div>

            <CommentFormComponent />
        </>
    );
};

export default ContactPage;
