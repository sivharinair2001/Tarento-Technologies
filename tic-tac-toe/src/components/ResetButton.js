import React from 'react';
import "./ResetBoard.css";

export const ResetButton = ({ resetBoard }) => {
  return (
    <button className='reset-btn' onClick={resetBoard}>
      Reset
    </button>
  );
};
