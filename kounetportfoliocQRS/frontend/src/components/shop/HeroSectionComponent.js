import React from 'react'

const HeroSectionComponent = () => {
  return (
      <section id="hero" className="hero section dark-background">
        
              <img src="/assets/img/hero-bg.jpg" alt="" data-aos="fade-in"/>
        
              <div className="container">
                <div className="row">
                  <div className="col-lg-10">
                    <h2 data-aos="fade-up" data-aos-delay="100">Welcome to Our Website</h2>
                    <p data-aos="fade-up" data-aos-delay="200">We are team of talented designers making websites with Bootstrap</p>
                  </div>
                  <div className="col-lg-5" data-aos="fade-up" data-aos-delay="300">
                    <form action="forms/newsletter.php" method="post" className="php-email-form">
                      <div className="sign-up-form"><input type="email" name="email"/><input type="submit" value="Subscribe"/></div>
                      <div className="loading">Loading</div>
                      <div className="error-message"></div>
                      <div className="sent-message">Your subscription request has been sent. Thank you!</div>
                    </form>
                  </div>
                </div>
              </div>
        
            </section>
        
  )
}

export default HeroSectionComponent
