function TransactionList({ transactions }) {
    return (
        <div className="transaction-list">
            <h2>TransactionList</h2>

            {
                transactions.length == 0 ? (
                    <p>No transactions found </p>
                ) : (
                    <table>
                        <thread>
                            <tr>
                                <th>Date</th>
                                <th>Description</th>
                                <th>Amount</th>
                            </tr>
                        </thread>
                        <tbody>
                            {
                                transactions.map((transaction) => (
                                    <tr key={transaction.id}>
                                        <td>{transaction.date}</td>
                                        <td>{transaction.amount}</td>
                                        <td>{transaction.description}</td>
                                    </tr>
                                ))
                            }
                        </tbody>
                    </table>
                )
            }
        </div>
    )
}

export default TransactionList;