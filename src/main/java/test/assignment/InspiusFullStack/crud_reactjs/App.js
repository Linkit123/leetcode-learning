import './App.css';
import { useEffect, useState } from 'react';
import AddTransaction from './components/AddTransaction';
import TransactionList from './components/TransactionList';

function App() {

  const [transactions, setTransactions] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState();

  useEffect(() => {
    fetchTransactions();
  }, []);

  const fetchTransactions = async () => {
    setLoading(true);
    try {
      const response = await fetch('http://localhost:8080/api/v1/transactions/entire');
      if (!response.ok()) {
        //log error
        return;
      }

      const data = await response.json();

      setTransactions(data);
    } catch (e) {
      // throw error
      setError(`Fail to load transactions: ${e.message}`)
    } finally {
      setLoading(false);
    }
  }

  const addTransaction = async (newTransaction) => {
    setLoading(true);
    try {
      // call api
      const response = await fetch('http://localhost:8080/api/v1/transactions', {
        method: 'post',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(newTransaction)
      });

      setTransactions(newTransaction, ...transactions);

      if (!response.ok()) {
        //log error
        return;
      }

      const data = await response.json();

      setTransactions(data);
    } catch(e) {
      // throw error
      setError(`Fail to add transaction: ${e.message}`)
    } finally {
      setLoading(false);
    }


  }

  return (
    <div className="App">
      <h2>Transaction manager</h2>

      {error && <div>Error {error} </div>}

      <AddTransaction onAddTransaction={addTransaction}></AddTransaction>

      {loading ? <div>Loading transactions ... </div> :
        <TransactionList transactions={transactions}></TransactionList>
      }

    </div>
  );
}

export default App;
