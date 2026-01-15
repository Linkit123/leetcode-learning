import React, { useState } from "react";

function AddTransaction({ onAddTransaction }) {
    const [date, setDate] = useState('');
    const [amount, setAmount] = useState('');
    const [description, setDescription] = useState('');

    const handleSubmit = (e) => {

        // validate
        if (!date || !description || !amount) {
            //log
            return;
        }
        // create new trans
        const newTransaction = {
            date, description, amount: parseFloat(amount)
        }

        onAddTransaction(newTransaction);

        // reset
        setDate('');
        setDescription('');
        setAmount('');

    }

    return (
        <div className="create-transaction">
            <h2>Add transaction</h2>
            <form onSubmit={handleSubmit}>
                <div className="form-group">
                    <label for="start">Start date:</label>
                    <input
                        type="date"
                        id="date"
                        value={date}
                        onChange={(e) => setDate(e.target.value)}
                        required
                    />

                </div>

                <div className="form-group">
                    <label for="start">Description:</label>
                    <input
                        type="text"
                        id="description"
                        value={description}
                        onChange={(e) => setDescription(e.target.value)}
                        placeholder="Enter your desc"
                        required
                    />
                </div>

                <div className="form-group">
                    <label for="start">Amount:</label>
                    <input
                        type="number"
                        id="amount"
                        value={amount}
                        onChange={(e) => setAmount(e.target.value)}
                        placeholder="0.00"
                        required
                    />
                </div>

                <button type="submit" className="btn-submit">
                    Add Transaction
                </button>
            </form>
        </div>
    )
}


export default AddTransaction;