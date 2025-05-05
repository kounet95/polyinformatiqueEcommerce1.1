import React from 'react';

const NavBarComponent = () => {
    return (
        <nav id="navmenu" className="navmenu d-flex justify-content-evenly">
            <ul>
            <li><a href="/" className="active">Home</a></li>
            <li className="dropdown"><a href="/services"><span>Services</span> <i className="bi bi-chevron-down toggle-dropdown"></i></a>
                <ul>
                <li><a href="/services/new">New</a></li>
                <li className="dropdown"><a href="#"><span>Deep Dropdown</span> <i className="bi bi-chevron-down toggle-dropdown"></i></a>
                    <ul>
                    <li><a href="#">Deep Dropdown 1</a></li>
                    <li><a href="#">Deep Dropdown 2</a></li>
                    
                    </ul>
                </li>
                <li><a href="#">Dropdown 2</a></li>
                
                </ul>
            </li>  
            <li><a href="/pricing">Pricing</a></li>
            <li><a href="/team">Team</a></li>

            <li className="dropdown"><a href="/blog"><span>Blog</span> <i className="bi bi-chevron-down toggle-dropdown"></i></a>
                <ul>
                <li><a href="/blog/new">New</a></li>
                <li className="dropdown"><a href="#"><span>Deep Dropdown</span> <i className="bi bi-chevron-down toggle-dropdown"></i></a>
                    <ul>
                    <li><a href="#">Deep Dropdown 1</a></li>
                    <li><a href="#">Deep Dropdown 2</a></li>
                    
                    </ul>
                </li>
                <li><a href="#">Dropdown 2</a></li>
                
                </ul>
            </li>
            <li><a href="/contact">Contact</a></li>
            <li className="dropdown"><span>Sign in</span> <i className="bi bi-chevron-down toggle-dropdown"></i>
                <ul>
                <li><a href="/signin">Sign in</a></li>
                <li><a href="/signup">Sign up</a></li>            
                </ul>
            </li>  
            </ul>
            <i className="mobile-nav-toggle d-xl-none bi bi-list"></i>
        </nav>
    );
};

export default NavBarComponent;
