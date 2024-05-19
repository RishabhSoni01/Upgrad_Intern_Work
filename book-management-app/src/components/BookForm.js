import React, { useState, useEffect } from 'react';
import useBookManager from '../hooks/useBookManager';
import { useNavigate } from 'react-router-dom';

const BookForm = ({ bookToEdit, onFinish }) => {
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');
  const [genre, setGenre] = useState('');
  const { addBook, editBook } = useBookManager();

  useEffect(() => {
    if (bookToEdit) {
      setTitle(bookToEdit.title);
      setAuthor(bookToEdit.author);
      setGenre(bookToEdit.genre);
    }
  }, [bookToEdit]);

  const handleSubmit = (e) => {
    e.preventDefault();

    if (!title || !author || !genre) {
      alert('All fields are required');
      return;
    }

    const book = { id: bookToEdit ? bookToEdit.id : Date.now(), title, author, genre };

    if (bookToEdit) {
      editBook(book);
    } else {
      addBook(book);
    }


    onFinish();
  };

  return (
    <>
    <h2>{bookToEdit ? 'Edit' : 'Add'}</h2> {/* Toggle text based on whether editing or adding */}
    <form onSubmit={handleSubmit} className="book-form">

    
    <label htmlFor="title">Title:</label>
      <input 
        type="text" 
        placeholder="Title" 
        value={title} 
        onChange={(e) => setTitle(e.target.value)} 
      />
    

    
    <label htmlFor="author">Author:</label>
      <input 
        type="text" 
        placeholder="Author" 
        value={author} 
        onChange={(e) => setAuthor(e.target.value)} 
      />
   

    
    <label htmlFor="genre"s>Genre:</label>
      <input 
        type="text" 
        placeholder="Genre" 
        value={genre} 
        onChange={(e) => setGenre(e.target.value)} 
      />
    
    
      
       

<div className="butoon">
        <button type="submit" className="add-butoon">{bookToEdit ? 'EDIT' : 'ADD'}</button>
        <button type="button" className="back-button" onClick={() => window.location.href = 'http://localhost:3000/'}>&#171;&#171;</button>
    </div>
      
    </form>
    
    </>
  );
};

export default BookForm;

