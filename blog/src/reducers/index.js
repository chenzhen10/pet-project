import { combineReducers } from "redux";
import errorsReducer from "./errorsReducer";
import postReducer from "./postReducer";

export default combineReducers({
  errors: errorsReducer,
  posts: postReducer
});
