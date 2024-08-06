function generateRandomData() {
    const minDate = new Date(2024, 0, 1);
    const maxDate = new Date(2024, 11, 31);
    const currentDate = new Date();
    let dueDate;

    do {
        dueDate = new Date(minDate.getTime() + Math.random() * (maxDate.getTime() - minDate.getTime()));
    } while (dueDate < currentDate);

    const formattedDueDate = dueDate.toISOString().replace(/-/g, '').substring(0, 8);

    return {
        account_identifier: account_identifier, 
        value: parseFloat((Math.random() * 1000).toFixed(2)),
        due_date: formattedDueDate
    };
}


async function callEndpoint(data) {
    try {
        const response = await fetch('http://localhost:8080/api/installments/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(data),
        });

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        console.log('Success:', response.statusText);
    } catch (error) {
        console.error('Error:', error);
    }
}


const numberOfCalls = 1000;
const account_identifier = "24450a02-7f85-44f9-b3ad-dafac26c9174";

for (let i = 0; i < numberOfCalls; i++) {
    const data = generateRandomData();
    callEndpoint(data)
        .then(() => console.log(`Chamada ${i+1} concluída.`))
        .catch(error => console.error(`Erro na chamada ${i+1}:`, error));
}
