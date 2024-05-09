document.addEventListener('DOMContentLoaded', function() {
    const urlParams = new URLSearchParams(window.location.search);
    const contactId = urlParams.get('id');
    fetchContactDetails(contactId);
});

function fetchContactDetails(contactId) {
    fetch(`http://localhost:8080/api/contacts/${contactId}`)
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(contact => {
            populateEditForm(contact);
        })
        .catch(error => {
            console.error('Error fetching contact details:', error);
        });
}

function populateEditForm(contact) {
    document.getElementById('name').value = contact.name;
    document.getElementById('email').value = contact.email;
    document.getElementById('number').value = contact.phoneNumber;
    document.getElementById('dob').value = contact.dob;
    document.getElementById('address').value = contact.address;
}

function updateContact(event) {
    event.preventDefault();

    const formData = new FormData(document.getElementById('profile-form'));
    const updatedContact = {};
    formData.forEach((value, key) => {
        updatedContact[key] = value;
    });

    const urlParams = new URLSearchParams(window.location.search);
    const contactId = urlParams.get('id');

    fetch(`http://localhost:8080/api/contacts/${contactId}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(updatedContact)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Failed to update contact');
        }
        alert('Contact updated successfully!');
        window.location.href = 'index.html';
    })
    .catch(error => {
        console.error('Error updating contact:', error);
        alert('An error occurred while updating the contact. Please try again later.');
    });
}