import React, { Component } from "react";
import { connect } from "react-redux";
import { deletePost } from "../../actions/postActions";

class DeletePost extends Component {
  constructor() {
    super();

    this.onClick = this.onClick.bind(this);
  }

  onClick(e) {
    this.props.deletePost(e.target.id);
  }

  render() {
    return (
      <div>
        <button
          id={this.props.id}
          onClick={this.onClick}
          className="btn btn-danger float-right"
        >
          <i id={this.props.id} className="fas fa-times"></i>
        </button>
      </div>
    );
  }
}

export default connect(
  null,
  { deletePost }
)(DeletePost);
