import React, { Component } from "react";
import { connect } from "react-redux";
import { createPost } from "../../actions/postActions";

class AddPost extends Component {
  constructor() {
    super();
    this.state = {
      name: "",
      date: "",
      tag: ""
    };
    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(e) {
    this.setState({ [e.target.name]: e.target.value });
  }

  onSubmit(e) {
    e.preventDefault();
    const newPost = {
      name: this.state.name,
      date: this.state.date,
      tag: this.state.tag
    };
    this.props.createPost(newPost);
    this.props.history.push("/blog");
  }

  render() {
    return (
      <div className="container">
        <form onSubmit={this.onSubmit}>
          <div className="input-group mb-3">
            <div className="input-group-prepend">
              <span className="input-group-text" id="basic-addon1">
                <i className="fas fa-signature"></i>
              </span>
            </div>
            <input
              type="text"
              className="form-control"
              placeholder="Post name"
              name="name"
              value={this.state.name}
              aria-label="Post name"
              aria-describedby="basic-addon1"
              onChange={this.onChange}
            />
            <div className="input-group-prepend">
              <span className="input-group-text" id="basic-addon1">
                <i className="fas fa-table"></i>
              </span>
            </div>
            <input
              type="text"
              className="form-control"
              placeholder="Date"
              name="date"
              value={this.state.date}
              aria-label="Date"
              aria-describedby="basic-addon1"
              onChange={this.onChange}
            />
            <div className="input-group-prepend">
              <span className="input-group-text" id="basic-addon1">
                <i className="fas fa-tag"></i>
              </span>
            </div>
            <input
              type="text"
              className="form-control"
              placeholder="Tag"
              name="tag"
              value={this.state.tag}
              aria-label="Tag"
              aria-describedby="basic-addon1"
              onChange={this.onChange}
            />
          </div>
          <button type="submit" className="btn btn-primary">
            Ok
          </button>
        </form>
      </div>
    );
  }
}

export default connect(
  null,
  { createPost }
)(AddPost);
