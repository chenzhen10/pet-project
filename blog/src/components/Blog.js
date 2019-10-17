import React, { Component } from "react";
import { Link } from "react-router-dom";
import { connect } from "react-redux";
import { fetchPosts } from "../actions/postActions";
import DeletePost from "./post/DeletePost";
import Pagination from "./Pagination";

class Blog extends Component {
  UNSAFE_componentWillMount() {
    this.props.fetchPosts();
  }

  UNSAFE_componentWillReceiveProps(nextProps) {
    if (nextProps.newPost.data) {
      this.props.posts.unshift(nextProps.newPost.data);
    }
  }

  render() {
    const posts = this.props.posts.map(post => (
      <div key={post.id} className="card mb-4 shadow-sm">
        <div className="card-header">
          <DeletePost id={post.id} />
          <h4 className="my-0 font-weight-normal pl-5">{post.name}</h4>
        </div>
        <p>{post.tag}</p>
        <p>{post.date}</p>
      </div>
    ));

    return (
      <div className="fluid-container">
        <div className="alert alert-primary" role="alert">
          <h4 className="alert-heading">Top posts of week</h4>
        </div>
        <div className="card-deck mb-3 shadow-sm">{posts}</div>
        <Pagination totalPages={this.props.totalPages} />
        <Link to="/post/add" type="button" className="btn btn-success">
          Create post
        </Link>
      </div>
    );
  }
}

const mapStateToProps = state => ({
  posts: state.posts.items,
  newPost: state.posts.item,
  totalPages: state.posts.totalPages
});

export default connect(
  mapStateToProps,
  { fetchPosts }
)(Blog);
