import React, { useState } from 'react';
import axios from 'axios';
import { API_URL_ADD_ARTICLE, API_URL_UPDATE_ARTICLE } from '../../api';

const BlogFormComponent = ({ articleId, initialData }) => {
    const [formData, setFormData] = useState(initialData || { title: '', content: '' });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            if (articleId) {
                await axios.put(API_URL_UPDATE_ARTICLE(articleId), formData);
                alert('Article updated successfully!');
            } else {
                await axios.post(API_URL_ADD_ARTICLE, formData);
                alert('Article created successfully!');
            }
        } catch (error) {
            console.error('Error saving article:', error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>Title:</label>
                <input
                    type="text"
                    name="title"
                    value={formData.title}
                    onChange={handleChange}
                />
            </div>
            <div>
                <label>Content:</label>
                <textarea
                    name="content"
                    value={formData.content}
                    onChange={handleChange}
                />
            </div>
            <button type="submit">{articleId ? 'Update' : 'Create'} Article</button>
        </form>
    );
};

export default BlogFormComponent;