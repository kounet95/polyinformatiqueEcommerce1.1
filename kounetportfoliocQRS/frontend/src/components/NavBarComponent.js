import React from 'react';
import { Link } from 'react-router-dom';

const NavBarComponent = () => {
    return (
        <nav id="navmenu" className="navmenu d-flex justify-content-evenly">
            <ul>
                <li className="dropdown"><Link to="/"><span>Boutique</span> <i className="bi bi-chevron-down toggle-dropdown"></i></Link>
                    <ul>
                        <li><Link to="/product-details"> Details produit</Link></li>
                    </ul>
                </li>


                <li className="dropdown">
                    <Link to="/services"><span>Services</span> <i className="bi bi-chevron-down toggle-dropdown"></i></Link>
                            <ul>
                                <li><Link to="/pricing">Pricing</Link></li>
                                <li><Link to="/services/new">Nouveau</Link></li>
                                <li><Link to="/services-details">Services Details</Link></li>
                            </ul>
                </li>




            <li className="dropdown"><Link to="/blog"><span>Blog</span> <i className="bi bi-chevron-down toggle-dropdown"></i></Link>
                <ul>
                    <li className="dropdown"><a href="/blog"><span>Articles</span> <i className="bi bi-chevron-down toggle-dropdown"></i></a>
                        <ul>
                            <li><a href="/blog/new">nouveau</a></li>
                        </ul>
                    </li>
                    <li className="dropdown"><a href="/domain"><span>Domaines</span> <i className="bi bi-chevron-down toggle-dropdown"></i></a>
                        <ul>
                            <li><a href="/domain/new">nouveau </a></li>
                        </ul>
                    </li>
                    <li className="dropdown"><a href="/tag"><span>Tags</span> <i className="bi bi-chevron-down toggle-dropdown"></i></a>
                        <ul>
                            <li><a href="/tag/new">nouveau </a></li>
                        </ul>
                    </li>
                
                </ul>
            </li>

            <li><Link to="/contact">Contact</Link></li>
            <li ><Link to="/sign">Sign in / Sign up</Link></li>
                <li ><Link to="/event">Evenements</Link></li>
                <li><Link to="/team">Team</Link></li>
            </ul>
            <i className="mobile-nav-toggle d-xl-none bi bi-list"></i>
        </nav>
    );
};

export default NavBarComponent;
