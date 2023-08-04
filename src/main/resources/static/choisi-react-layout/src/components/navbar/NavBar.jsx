import { useRef } from "react";
import { FaBars, FaTimes } from "react-icons/fa";
import "./NavBar.css";
import Logo from "../logo/Logo";
import SearchBar from "../searchbar/SearchBar";

function Navbar() {
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
                <a href="/#">HOME</a>
                <a href="/#">SHOP</a>
                <a href="/#">BLOG</a>
                <a href="/#">ABOUT US</a>
                <button
                    className="nav-btn nav-close-btn"
                    onClick={showNavbar}>
                    <FaTimes />
                </button>
            </nav>
            <SearchBar/>

            <button
                className="nav-btn"
                onClick={showNavbar}>
                <FaBars />
            </button>
        </header>
    );
}

export default Navbar;