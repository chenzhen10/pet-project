import React from "react";
import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from "./components/Navbar";
import Blog from "./components/Blog";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddPost from "./components/post/AddPost";
import { Redirect } from "react-router";
import { Provider } from "react-redux";
import store from "./store";

function App() {
  return (
    <Provider store={store}>
      <Router>
        <Redirect exact from="/" to="/blog" />
        <div className="App">
          <Navbar />
          <Route exact path="/blog" component={Blog} />
          <Route exact path="/post/add" component={AddPost} />
        </div>
      </Router>
    </Provider>
  );
}

export default App;
