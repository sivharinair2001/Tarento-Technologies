import { useReducer, useState } from 'react';
import './App.css';
import { Board } from './components/Board';
import { ScoreBoard } from './components/ScoreBoard';
import { ResetButton } from './components/ResetButton';

function App() {
  
  const winConditions = [
    [0, 1, 2], 
    [3, 4, 5],
    [6, 7, 8], 
    [0, 3, 6],
    [1, 4, 7], 
    [2, 5, 8], 
    [0, 4, 8], 
    [2, 4, 6]  
  ];
  

  const [score, setScore] = useState({xScore:0, oScore:0})
  const [board, setBoard] = useState(Array(9).fill(null));
  const [xPlaying, setXPlaying] = useState(true);
  const [gameOver, setGameOver] = useState(false);
  const [matchesPlayed, setMatchesPlayed] = useState(0);
  const [overallWinner, setOverallWinner] = useState(null);

  const handleBoxClick = (blockIndex) =>{
    const updatedBoard = board.map((value, index) =>{
      if(index == blockIndex) {
        return xPlaying === true ? "X" : "O";
      } else {
        return value;
      }
    })

    const winner = checkWinner(updatedBoard);

    if(winner) {
      if(winner == "O") {
        let {oScore} = score;
        oScore += 1 ;
        setScore({...score, oScore});
      } else {
        let {xScore} = score;
        xScore += 1 ;
        setScore({...score, xScore});
      }
    }

    setBoard(updatedBoard);
    setXPlaying(!xPlaying);
  }

  const  checkWinner = (board) => {
    for(let i = 0 ;i < winConditions.length;i++) {
      const [x,y,z] = winConditions[i];


      if(board[x] && board[x] === board[y] && board[y] === board[z] && board[z]){
        setGameOver(true);
        return board[x];
      }

    }
  }

  const resetBoard = () => {
    setGameOver(false);
    setBoard(Array(9).fill(null));
  }

  return (
    <div className="App">
      <ScoreBoard score={score} xPlaying={xPlaying}/>
      <Board board={board} onClick={gameOver ? resetBoard : handleBoxClick}/>
      <ResetButton resetBoard={resetBoard}/>
    </div>
  );
}

export default App;
