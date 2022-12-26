import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import Hello from './components/Hello';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(  // 루트를 렌더링
  <React.StrictMode>
    <App />
    {/* App 안에 출력되길 원하는 자손을 넣어주기 */}
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
