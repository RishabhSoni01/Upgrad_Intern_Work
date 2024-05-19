import React, { useState } from 'react';
import { BookProvider } from './context/BookContext';
import BookList from './components/BookList';
import BookForm from './components/BookForm';
import './App.css';

const App = () => {
  const [isAdding, setIsAdding] = useState(false);
  const [editingBook, setEditingBook] = useState(null);

  const handleAdd = () => {
    setEditingBook(null);
    setIsAdding(true);
  };

  const handleEdit = (book) => {
    setEditingBook(book);
    setIsAdding(true);
  };

  const handleFinish = () => {
    setIsAdding(false);
    setEditingBook(null);
  };

  return (
    <BookProvider>
      <div className="App">
        <header className="App-header">
          <h1>Book Management App</h1>
          <img src="/book-icon.png" alt="Book Icon" />
        </header>
        {isAdding ? (
          <BookForm bookToEdit={editingBook} onFinish={handleFinish} />
        ) : (
          <BookList onEdit={handleEdit} />
        )}
      </div>
    </BookProvider>
  );
};

export default App;
