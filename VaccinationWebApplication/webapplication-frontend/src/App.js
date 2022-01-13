import './App.css';
import DataList from './DataList';
import NavBar from './NavBar';

function App() {
  return (
    <div>
      <NavBar/>
      <div className="col-md- offset-md"></div>
    <div className="App">
      <DataList/>
    </div>
    </div>
  );
}

export default App;
