import React, { useState } from 'react';
import useBookManager from '../hooks/useBookManager';

const BookItem = ({ book, onEdit }) => {
  const { deleteBook } = useBookManager();
  const [showModal, setShowModal] = useState(false);

  const handleDelete = () => {
    setShowModal(true);
  };

  const confirmDelete = () => {
    deleteBook(book.id);
    setShowModal(false);
  };

  return (
    <li className="book-item">
      <div>
        <div className="book-lis">
            <p>Title: {book.title}</p>
            <p>Author: {book.author}</p>
            <p>Genre: {book.genre}</p>
        </div>
        <div className="button-container">
            <button className="edit-button" onClick={() => onEdit(book)}>✏️</button>
            <button className="delete-button" onClick={handleDelete}>🗑️</button>
        </div>
      </div>
      {showModal && (
        <div className="modal">
          <div className="modal-content">
            <p>Are you sure you want to delete this book?</p>
            <button onClick={confirmDelete}>Yes</button>
            <button onClick={() => setShowModal(false)}>Cancel</button>
          </div>
        </div>
      )}
    </li>
  );
};

export default BookItem;

