import React, { useState } from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faSearch, faTimes } from "@fortawesome/free-solid-svg-icons";
import "./SearchBar.css"; // Create a separate CSS file for styling

const SearchBar = () => {
    const [isSearchOpen, setIsSearchOpen] = useState(false);

    const toggleSearch = () => {
        setIsSearchOpen(!isSearchOpen);
    };

    const handleClearSearch = () => {
        setIsSearchOpen(false);
    };

    return (
        <div className={`search-bar ${isSearchOpen ? "open" : ""}`}>
            <div className="search-icon-container" onClick={toggleSearch}>
                <FontAwesomeIcon icon={faSearch} className="search-icon" />
            </div>
            <div className="search-input-container">
                <input type="text" placeholder="Search..." />
                <div className="close-icon-container" onClick={handleClearSearch}>
                    <FontAwesomeIcon icon={faTimes} className="close-icon" />
                </div>
            </div>
        </div>
    );
};

export default SearchBar;
