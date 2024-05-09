// Function to show the add contact form
function showAddContactForm() {
    document.getElementById('addContactForm').style.display = 'block';
}

// Function to hide the add contact form
function hideAddContactForm() {
    document.getElementById('addContactForm').style.display = 'none';
}

// Function to add a new contact
function addContact(event) {
    event.preventDefault(); // Prevent the form from submitting normally
    
    const formData = new FormData(document.getElementById('editContactForm'));
    const newContact = {};
    formData.forEach((value, key) => {
        newContact[key] = value;
    });

    fetch('http://localhost:8080/api/contacts', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(newContact)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to add contact');
        }
        alert('Contact added successfully!');
        hideAddContactForm();
        // Optionally, fetch and display the updated contact list
        fetchContacts(currentPage);
    })
    .catch(error => {
        console.error('Error adding contact:', error);
        alert('An error occurred while adding the contact. Please try again later.');
    });
}