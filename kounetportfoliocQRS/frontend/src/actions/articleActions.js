// actions/articlesActions.js
import axios from 'axios';

// URL de l'API
//const API_URL = 'http://localhost:8888/BLOGSERVICE/api/blog/articles';
const API_URL_ARTICLES = 'http://localhost:8082/query/article/articles';



// Action Types
export const FETCH_ARTICLES = 'FETCH_ARTICLES';

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
<<<<<<< HEAD
        const response = await axios.post(`${API_URL_ARTICLES}/add`, articleData);
        dispatch({ type: CREATE_ARTICLE, payload: response.data });
=======
        const data = await apiCreateArticle(articleData);
        dispatch({ type: CREATE_ARTICLE, payload: data });
>>>>>>> 5e6eb90f0a766d7b47902d23e3d1ca6cdc05886e
    } catch (error) {
        console.log(error.message);
        dispatch({ type: SET_ERROR, payload: error.message });
    }
};

export const updateArticle = (id, articleData) => async (dispatch) => {
    try {
<<<<<<< HEAD
        const response = await axios.put(`${API_URL_ARTICLES}/${id}`, articleData);
        dispatch({ type: UPDATE_ARTICLE, payload: response.data });
=======
        const data = await apiUpdateArticle(id, articleData);
        dispatch({ type: UPDATE_ARTICLE, payload: data });
>>>>>>> 5e6eb90f0a766d7b47902d23e3d1ca6cdc05886e
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
    }
};

export const deleteArticle = (id) => async (dispatch) => {
    try {
<<<<<<< HEAD
        await axios.delete(`${API_URL_ARTICLES}/${id}`);
=======
        await apiDeleteArticle(id);
>>>>>>> 5e6eb90f0a766d7b47902d23e3d1ca6cdc05886e
        dispatch({ type: DELETE_ARTICLE, payload: id });
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
    }
};

export const fetchArticle = (id) => async (dispatch) => {
    dispatch({ type: SET_LOADING, payload: true });

    try {
<<<<<<< HEAD
        const response = await axios.get(`${API_URL_ARTICLES}/${id}`);
        dispatch({ type: FETCH_ARTICLE, payload: response.data });
=======
        const data = await getArticleById(id);
        dispatch({ type: FETCH_ARTICLE, payload: data });
>>>>>>> 5e6eb90f0a766d7b47902d23e3d1ca6cdc05886e
    } catch (error) {
        dispatch({ type: SET_ERROR, payload: error.message });
    } finally {
        dispatch({ type: SET_LOADING, payload: false });
    }
};

<<<<<<< HEAD
=======

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
>>>>>>> 5e6eb90f0a766d7b47902d23e3d1ca6cdc05886e
