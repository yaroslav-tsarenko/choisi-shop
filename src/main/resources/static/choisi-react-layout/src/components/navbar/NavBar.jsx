import React from 'react';
import { FaBars, FaSearch } from 'react-icons/fa';
import { Link } from 'react-router-dom';
import "./NavBar.css"

const NavBar = () => {
    return (
        <nav className="navbar">
            <div className="nav-center">
                <div className="nav-header">
                    <Link to="/" className="logo">
                        Your Logo
                    </Link>
                    <button type="button" className="nav-toggle">
                        <FaBars />
                    </button>
                </div>
                <ul className="nav-links">
                    <li>
                        <Link to="/">Home</Link>
                    </li>
                    <li>
                        <Link to="/about">About</Link>
                    </li>
                    <li>
                        <Link to="/contact">Contact</Link>
                    </li>
                </ul>
                <div className="search-container">
                    <input type="text" placeholder="Search..." />
                    <button type="button" className="search-button">
                        <FaSearch />
                    </button>
                </div>
            </div>
        </nav>
    );
};

export default NavBar;