import React from 'react'
import LoginRegisterForm from "../components/shop/LoginRegisterForm";
import HeaderComponent from "../components/website/HeaderComponent";


const SignInSignUpPage = () => {
  return (
    <>
        <div className="page-title" data-aos="fade">
            <HeaderComponent title="Se connecter" />
            <nav className="breadcrumbs">
                <div className="container">
                    <ol>
                        <li><a href="/">Accueil</a></li>
                        <li className="current">Se connecter</li>
                    </ol>
                </div>
            </nav>
        </div>
        <main className="main">
            <div className="container ">
                 <LoginRegisterForm/>
            </div>
        </main>
    </>
  )
}

export default SignInSignUpPage
