// actions/articlesActions.js
import { 
  getAllArticles, 
  getArticleById, 
  getAllDomains 
} from '../api/blog/query';
import { 
  createArticle as apiCreateArticle, 
  updateArticle as apiUpdateArticle, 
  deleteArticle as apiDeleteArticle 
} from '../api/blog/command';



// Action Types
export const FETCH_ARTICLES = 'FETCH_ARTICLES';
export const FETCH_DOMAINS = 'FETCH_DOMAINS';

export const FETCH_ARTICLE = 'FETCH_ARTICLE';

export const CREATE_ARTICLE = 'CREATE_ARTICLE';
export const UPDATE_ARTICLE = 'UPDATE_ARTICLE';
export const DELETE_ARTICLE = 'DELETE_ARTICLE';
export const SET_LOADING = 'SET_LOADING';
export const SET_ERROR = 'SET_ERROR';

// Actions articles
export const fetchArticles = () => async (dispatch) => {
    try {
        dispatch({ type: SET_LOADING, payload: true });
        const data = await getAllArticles();
        dispatch({ type: FETCH_ARTICLES, payload: data });
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
        console.log(error.message);
    } finally {
        dispatch({ type: SET_LOADING, payload: false });
    }
};

export const createArticle = (articleData) => async (dispatch) => {
    try {
        const data = await apiCreateArticle(articleData);
        dispatch({ type: CREATE_ARTICLE, payload: data });
    } catch (error) {
        console.log(error.message);
        dispatch({ type: SET_ERROR, payload: error.message });
    }
};

export const updateArticle = (id, articleData) => async (dispatch) => {
    try {
        const data = await apiUpdateArticle(id, articleData);
        dispatch({ type: UPDATE_ARTICLE, payload: data });
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
    }
};

export const deleteArticle = (id) => async (dispatch) => {
    try {
        await apiDeleteArticle(id);
        dispatch({ type: DELETE_ARTICLE, payload: id });
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
    }
};

export const fetchArticle = (id) => async (dispatch) => {
    dispatch({ type: SET_LOADING, payload: true });

    try {
        const data = await getArticleById(id);
        dispatch({ type: FETCH_ARTICLE, payload: data });
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
    } finally {
        dispatch({ type: SET_LOADING, payload: false });
    }
};


// Actions domain
export const fetchDomains = () => async (dispatch) => {
    try {
        dispatch({ type: SET_LOADING, payload: true });
        const data = await getAllDomains();
        dispatch({ type: FETCH_DOMAINS, payload: data });
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
        console.log(error.message);
    } finally {
        dispatch({ type: SET_LOADING, payload: false });
    }
};
