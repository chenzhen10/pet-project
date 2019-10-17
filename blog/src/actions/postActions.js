import { FETCH_POSTS, NEW_POST, DELETE_POST } from "./types";
import axios from "axios";

export const fetchPosts = () => dispatch => {
  axios.get("http://localhost:8080/api/posts?page=0&size=3").then(posts => {
    dispatch({
      type: FETCH_POSTS,
      payload: posts.data.content,
      pages: posts.data.totalPages
    });
  });
};

export const createPost = postData => dispatch => {
  axios.post("http://localhost:8080/api/posts", postData).then(data =>
    dispatch({
      type: NEW_POST,
      payload: data
    })
  );
};

export const deletePost = id => dispatch => {
  axios.delete("http://localhost:8080/api/posts/" + id).then(data =>
    dispatch({
      type: DELETE_POST,
      payload: data.data
    })
  );
};

export const paginateFetchPosts = pageNum => dispatch => {
  axios
    .get(`http://localhost:8080/api/posts?page=${pageNum}&size=3`)
    .then(posts => {
      dispatch({
        type: FETCH_POSTS,
        payload: posts.data.content,
        pages: posts.data.totalPages
      });
    });
};
