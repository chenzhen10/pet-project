import { FETCH_POSTS, NEW_POST, DELETE_POST } from "../actions/types";

const initialState = {
  items: [],
  item: {},
  deleteItem: {},
  totalPages: {}
};

export default function(state = initialState, action) {
  switch (action.type) {
    case FETCH_POSTS:
      return {
        ...state,
        items: action.payload,
        totalPages: action.pages
      };
    case NEW_POST:
      return {
        ...state,
        item: action.payload
      };
    case DELETE_POST:
      return {
        ...state,
        items: state.items.filter(post => post.id !== action.payload)
      };
    default:
      return state;
  }
}
