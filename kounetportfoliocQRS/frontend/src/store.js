// store.js
import { createStore, combineReducers, applyMiddleware } from 'redux';
import {thunk} from 'redux-thunk';  // pour gérer les actions asynchrones (API calls)

// Importer tes réducteurs
import articlesReducer from './reducers/articleReducer';

const rootReducer = combineReducers({
  articles: articlesReducer
});

const store = createStore(rootReducer, applyMiddleware(thunk));

export default store;
