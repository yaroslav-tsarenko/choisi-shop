import React, { useRef, useState} from "react";
import { FaBars, FaTimes } from "react-icons/fa";
import { SearchBar } from "../searchbar/SearchBar";
import { SearchResultsList } from "../searchbar/SearchResultsList";
import   Logo from "../logo/Logo";
import "./NavBar.css";


function Navbar() {

    const [results, setResults] = useState([]);
    const navRef = useRef();

    const showNavbar = () => {
        navRef.current.classList.toggle(
            "responsive_nav"
        );
    };

    return (

        <header>

            <Logo/>

            <nav ref={navRef}>

                <div className="search-bar-container">

                    <SearchBar setResults={setResults}/>
                    {results && results.length > 0 && <SearchResultsList results={results}/>}

                </div>

                <button

                    className="nav-btn nav-close-btn"
                    onClick={showNavbar}>
                    <FaTimes/>

                </button>

                <a href="/#">HOME <i className="fi fi-sr-home"></i></a>
                <a href="/#">SHOP <i className="fi fi-sr-shop"></i></a>
                <a href="/contact-form">CONTACT US <i className="fi fi-sr-phone-call"></i></a>
                <a href="/#">LOG IN <i className="fi fi-sr-user"></i></a>
                <a href="/#">WISHLIST <i className="fi fi-sr-heart"></i></a>
                <a href="/#">CART <i className="fi fi-sr-shopping-cart"></i></a>

            </nav>

            <button
                className="nav-btn"
                onClick={showNavbar}>
                <FaBars/>
            </button>

        </header>
    );
}

export default Navbar;