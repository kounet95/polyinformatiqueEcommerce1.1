import React from 'react';
import { Link } from 'react-router-dom';

const NavBarComponent = () => {
    return (
        <nav id="navmenu" className="navmenu d-flex justify-content-evenly">
            <ul>
            <li><Link to="/" className="active">Home</Link></li>
            <li className="dropdown"><Link to="/service"><span>Services</span> <i className="bi bi-chevron-down toggle-dropdown"></i></Link>
                <ul>
                <li><Link to="/services-details">Services Details</Link></li>
                <li className="dropdown"><a href="#"><span>Deep Dropdown</span> <i className="bi bi-chevron-down toggle-dropdown"></i></a>
                    <ul>
                    <li><a href="#">Deep Dropdown 1</a></li>
                    <li><a href="#">Deep Dropdown 2</a></li>
                    </ul>
                </li>
                <li><a href="#">Dropdown 2</a></li>
                </ul>
            </li>  
            <li><Link to="/portfolio">Portfolio</Link></li>
            <li><Link to="/pricing">Pricing</Link></li>
            <li><Link to="/team">Team</Link></li>

            <li className="dropdown"><Link to="/blog"><span>Blog</span> <i className="bi bi-chevron-down toggle-dropdown"></i></Link>
                <ul>
                <li><Link to="/blog/new">New Post</Link></li>
                <li className="dropdown"><a href="#"><span>Categories</span> <i className="bi bi-chevron-down toggle-dropdown"></i></a>
                    <ul>
                    <li><a href="#">Technology</a></li>
                    <li><a href="#">Business</a></li>
                    </ul>
                </li>
                <li><a href="#">Archives</a></li>
                </ul>
            </li>
            <li><Link to="/contact">Contact</Link></li>
            <li className="dropdown"><span>Sign in</span> <i className="bi bi-chevron-down toggle-dropdown"></i>
                <ul>
                <li><Link to="/signin">Sign in</Link></li>
                <li><Link to="/signup">Sign up</Link></li>            
                </ul>
            </li>  
            </ul>
            <i className="mobile-nav-toggle d-xl-none bi bi-list"></i>
        </nav>
    );
};

export default NavBarComponent;
