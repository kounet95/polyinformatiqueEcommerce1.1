import React from 'react';
import HeaderComponent from '../../components/website/HeaderComponent';
import ShopComponent from "../../components/shop/ShopComponent";

const HomePage = () => {
    return (
        <>
          <div className="page-title" data-aos="fade">
            <HeaderComponent title="Bienvenue au contient" />
            <nav className="breadcrumbs">
              <div className="container">
                <ol>
                  <li className="current">Accueil</li>
                </ol>
              </div>
            </nav>
          </div>
          <main className="main">
              <ShopComponent/>
              <section id="clients" className="clients section">
                <div className="container" data-aos="fade-up">

                  <div className="row gy-4">

                    <div className="col-xl-2 col-md-3 col-6 client-logo">
                      <img src="/assets/img/clients/client-1.png" className="img-fluid" alt=""/>
                    </div>
                    <div className="col-xl-2 col-md-3 col-6 client-logo">
                      <img src="/assets/img/clients/client-2.png" className="img-fluid" alt=""/>
                    </div>

                    <div className="col-xl-2 col-md-3 col-6 client-logo">
                      <img src="/assets/img/clients/client-3.png" className="img-fluid" alt=""/>
                    </div>

                    <div className="col-xl-2 col-md-3 col-6 client-logo">
                      <img src="assets/img/clients/client-4.png" className="img-fluid" alt=""/>
                    </div>
                    <div className="col-xl-2 col-md-3 col-6 client-logo">
                      <img src="assets/img/clients/client-5.png" className="img-fluid" alt=""/>
                    </div>

                    <div className="col-xl-2 col-md-3 col-6 client-logo">
                      <img src="assets/img/clients/client-6.png" className="img-fluid" alt=""/>
                    </div>

                  </div>

                </div>
              </section>
          </main>
        </>
    );
};

export default HomePage;
