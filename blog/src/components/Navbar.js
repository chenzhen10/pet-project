import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <ul className="nav bg-dark">
      <li className="nav-item">
        <Link to="/blog" className="nav-link active">
          <i className="fas fa-cookie-bite"> Yummy posts</i>
        </Link>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="!#">
          Link
        </a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="!#">
          Link
        </a>
      </li>
      <li className="nav-item">
        <a
          className="nav-link disabled"
          href="!#"
          tabIndex="-1"
          aria-disabled="true"
        >
          Disabled
        </a>
      </li>
      <div className="input-group mb-3">
        <div className="input-group-prepend">
          <span className="input-group-text" id="basic-addon1">
            <i className="fas fa-search"></i>
          </span>
        </div>
        <input
          type="text"
          className="form-control"
          placeholder="Search..."
          aria-label="Search"
          aria-describedby="basic-addon1"
        />
      </div>
    </ul>
  );
}
