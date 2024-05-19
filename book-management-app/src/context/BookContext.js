import React, { createContext, useReducer, useContext, useMemo } from 'react';

const BookContext = createContext();

const initialState = {
  books: [],
  searchTerm: '',
  sortField: '',
};

const bookReducer = (state, action) => {
  switch (action.type) {
    case 'ADD_BOOK':
      return { ...state, books: [...state.books, action.payload] };
    case 'EDIT_BOOK':
      return {
        ...state,
        books: state.books.map(book => book.id === action.payload.id ? action.payload : book),
      };
    case 'DELETE_BOOK':
      return { ...state, books: state.books.filter(book => book.id !== action.payload) };
    case 'SET_SEARCH_TERM':
      return { ...state, searchTerm: action.payload };
    case 'SET_SORT_FIELD':
      return { ...state, sortField: action.payload };
    default:
      return state;
  }
};

export const BookProvider = ({ children }) => {
  const [state, dispatch] = useReducer(bookReducer, initialState);

  const value = useMemo(() => ({
    state,
    dispatch,
  }), [state, dispatch]);

  return <BookContext.Provider value={value}>{children}</BookContext.Provider>;
};

export const useBookContext = () => useContext(BookContext);
