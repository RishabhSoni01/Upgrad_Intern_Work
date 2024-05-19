import React from 'react';
import BookItem from './BookItem';
import useBookManager from '../hooks/useBookManager';

const BookList = ({ onEdit }) => {
  const { books, setSearchTerm, setSortField } = useBookManager();

  return (
    <div className="book-list-container">
      <h1>Book List</h1>
      <div className="search-sort">
        <input 
          type="text" 
          placeholder="Search by title, author, genre" 
          onChange={(e) => setSearchTerm(e.target.value)} 
        />
        <div className="sort-buttons">
          <div className="sort-dropdown">
            <select onChange={(e) => setSortField(e.target.value)}>
              <option value="title">Sort by Title</option>
              <option value="author">Sort by Author</option>
              <option value="genre">Sort by Genre</option>
            </select>
          </div>
        </div>
      </div>
      <ul className="book-list">
        {books.map((book) => (
          <BookItem key={book.id} book={book} onEdit={onEdit} />
        ))}
      </ul>
      <button className="add-button" onClick={() => onEdit(null)}>
        <span>ADD</span> <i className="plus-icon">+</i>
      </button>
    </div>
  );
};

export default BookList;
