import React from "react";

export default function Navbar() {
  return (
    <ul className="nav">
      <li className="nav-item">
        <a className="nav-link active" href="#">
          Active
        </a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="#">
          Link
        </a>
      </li>
      <li className="nav-item">
        <a className="nav-link" href="#">
          Link
        </a>
      </li>
      <li className="nav-item">
        <a
          className="nav-link disabled"
          href="#"
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
