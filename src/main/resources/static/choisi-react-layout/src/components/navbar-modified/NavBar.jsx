import React, { useState } from 'react';
import './NavBar.css';
import Logo from "../logo/Logo";
import NavLinks from "./NavLinks";

const NavBar = () => {
    const [isNavOpen, setIsNavOpen] = useState(false);

    const handleNavToggle = () => {
        setIsNavOpen(!isNavOpen);
    };

    return (
        <nav className={`navbar ${isNavOpen ? 'active' : ''}`}>
            <div className="navbar-logo">
                <Logo />
            </div>

            <div className="navbar-center">
                <NavLinks isOpen={isNavOpen} />
            </div>

            <div className="navbar-icons">
                {/* Add icons for search bar, shopping cart, wishlist, and login */}
                <i className="fas fa-search"></i>
                <i className="fas fa-shopping-cart"></i>
                <i className="far fa-heart"></i>
                <i className="fas fa-user"></i>
            </div>

            <div className="navbar-mobile" onClick={handleNavToggle}>
                <i className={`fas ${isNavOpen ? 'fa-times' : 'fa-bars'}`}></i>
            </div>
        </nav>
    );
};

export default NavBar;
