import React from 'react';
import ServicesDetailsComponent from '../../components/website/ServicesDetailsComponent';
import HeaderComponent from '../../components/website/HeaderComponent';

const ServicesDetailsPage = () => {
  return (
    <main className="main">
        <div className="page-title" data-aos="fade">
                <HeaderComponent title="Service en details" />
                <nav className="breadcrumbs">
                    <div className="container">
                        <ol>
                            <li><a href="/">Accueil</a></li>
                        <li className="current">Service en detail</li>
                        </ol>
                    </div>
                </nav>
            </div>
      
      <ServicesDetailsComponent />
    </main>
  );
};

export default ServicesDetailsPage;