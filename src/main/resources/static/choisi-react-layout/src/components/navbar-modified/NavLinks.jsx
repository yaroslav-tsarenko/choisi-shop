import React from 'react';
import './NavLinks.css'

const NavLinks = ({ isOpen }) => {

    return (

        <ul className={`nav-links ${isOpen ? 'active' : ''}`}>

            <li>
                <a href="#">HOME</a>
            </li>
            <li>
                <a href="#">ABOUT</a>
            </li>
            <li>
                <a href="#">SHOP</a>
            </li>
            <li>
                <a href="#">ABOUT US</a>
            </li>

        </ul>

    );
};

export default NavLinks;
