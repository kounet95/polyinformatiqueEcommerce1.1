// reducers/articlesReducer.js
import {FETCH_DOMAINS, SET_ERROR, SET_LOADING} from '../actions/articleActions';

const initialState = {
    domains: [],
    loading: false,
    error: null
};

const domainReducer = (state = initialState, action) => {
    switch (action.type) {

        case FETCH_DOMAINS:
            return { ...state, articles: action.payload };

        case SET_LOADING:
            return { ...state, loading: action.payload };
        case SET_ERROR:
            return { ...state, error: action.payload };
        default:
            return state;
    }
};

export default domainReducer;
