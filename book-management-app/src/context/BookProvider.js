import React, { useState, useMemo, useCallback } from 'react';
import BookContext from './BookContext';

const BookProvider = ({ children }) => {
  const [books, setBooks] = useState([]);
  const [searchTerm, setSearchTerm] = useState('');
  const [sortField, setSortField] = useState('');

  const addBook = useCallback((book) => {
    setBooks((prevBooks) => [...prevBooks, book]);
  }, []);

  const editBook = useCallback((updatedBook) => {
    setBooks((prevBooks) =>
      prevBooks.map((book) => (book.id === updatedBook.id ? updatedBook : book))
    );
  }, []);

  const deleteBook = useCallback((id) => {
    setBooks((prevBooks) => prevBooks.filter((book) => book.id !== id));
  }, []);

  const filteredBooks = useMemo(() => {
    let filtered = books.filter((book) =>
      book.title.toLowerCase().includes(searchTerm.toLowerCase()) ||
      book.author.toLowerCase().includes(searchTerm.toLowerCase()) ||
      book.genre.toLowerCase().includes(searchTerm.toLowerCase())
    );

    if (sortField) {
      filtered = filtered.sort((a, b) => (a[sortField] > b[sortField] ? 1 : -1));
    }

    return filtered;
  }, [books, searchTerm, sortField]);

  return (
    <BookContext.Provider value={{ books: filteredBooks, addBook, editBook, deleteBook, setSearchTerm, setSortField }}>
      {children}
    </BookContext.Provider>
  );
};

export default BookProvider;
