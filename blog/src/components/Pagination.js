import React, { Component } from "react";
import { paginateFetchPosts } from "../actions/postActions";
import { connect } from "react-redux";

class Pagination extends Component {
  constructor() {
    super();

    this.onClick = this.onClick.bind(this);
  }

  onClick(e) {
    e.preventDefault();
    let pageNum = +e.target.innerHTML - 1;
    this.props.paginateFetchPosts(pageNum);
  }

  render() {
    let pages = [];
    for (let i = 0; i < this.props.totalPages; i++) {
      pages.push(i + 1);
    }

    return (
      <nav className="pagination">
        {pages.map(number => (
          <li key={number} className="page-item">
            <a onClick={this.onClick} href="!#" className="page-link">
              {number}
            </a>
          </li>
        ))}
      </nav>
    );
  }
}

export default connect(
  null,
  { paginateFetchPosts }
)(Pagination);
