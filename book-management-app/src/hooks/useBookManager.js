import { useBookContext } from '../context/BookContext'

import { useMemo } from 'react';

const useBookManager = () => {
  const { state, dispatch } = useBookContext();

  const addBook = (book) => {
    dispatch({ type: 'ADD_BOOK', payload: book });
  };

  const editBook = (book) => {
    dispatch({ type: 'EDIT_BOOK', payload: book });
  };

  const deleteBook = (id) => {
    dispatch({ type: 'DELETE_BOOK', payload: id });
  };

  const setSearchTerm = (term) => {
    dispatch({ type: 'SET_SEARCH_TERM', payload: term });
  };

  const setSortField = (field) => {
    dispatch({ type: 'SET_SORT_FIELD', payload: field });
  };

  const filteredAndSortedBooks = useMemo(() => {
    let books = state.books.filter(book =>
      book.title.toLowerCase().includes(state.searchTerm.toLowerCase()) ||
      book.author.toLowerCase().includes(state.searchTerm.toLowerCase()) ||
      book.genre.toLowerCase().includes(state.searchTerm.toLowerCase())
    );

    if (state.sortField) {
      books = books.sort((a, b) => {
        if (a[state.sortField] < b[state.sortField]) return -1;
        if (a[state.sortField] > b[state.sortField]) return 1;
        return 0;
      });
    }

    return books;
  }, [state.books, state.searchTerm, state.sortField]);

  return {
    books: filteredAndSortedBooks,
    addBook,
    editBook,
    deleteBook,
    setSearchTerm,
    setSortField,
  };
};

export default useBookManager;
